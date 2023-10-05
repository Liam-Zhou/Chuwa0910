package com.chuwa.cassandrablog.dao;

import com.chuwa.cassandrablog.entity.Comment;
import com.chuwa.cassandrablog.entity.Post;
import com.chuwa.cassandrablog.entity.User;
import me.prettyprint.cassandra.serializers.*;
import me.prettyprint.cassandra.service.ColumnSliceIterator;
import me.prettyprint.cassandra.utils.TimeUUIDUtils;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.*;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.*;
import me.prettyprint.hom.EntityManagerImpl;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.nio.ByteBuffer;
import java.util.*;

public class BlogDao {
    private static final String KEYSPACE_NAME = "blog";
    private static final String CASS_HOST = "localhost";
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final DateTimeFormatter hourFormatter = DateTimeFormat.forPattern("YYYYMMdd:HH");
    private static final byte[] POSTS_BY_VOTE_KEY = "posts-sorted".getBytes();

    private Keyspace keyspace;
    private EntityManagerImpl entityManager;

    private static final String CF_USERS = "users";
    private static final String USER_COL_PASS = "password";
    private static final String USER_COL_NAME = "name";

    private static final String CF_COMMENTS = "comments";

    private static final String CF_POSTS = "posts";

    private static final String CF_USER_POSTS = "user_posts";

    private static final String CF_USER_VOTES = "user_votes";

    private static final String CF_POSTS_BY_TIME = "posts_by_time";

    private static final String CF_POSTS_BY_VOTE = "posts_sorted_by_vote";

    private static final String CF_USER_COMMENTS = "user_comments";

    private static final String CF_POST_COMMENTS = "post_comments";

    private static final String CF_VOTES = "votes";

    private static final String CF_POST_COMMENT_VOTE_CHANGE = "post_comment_votes_changed";

    private static final String CF_POST_COMMENTS_SORTED_BY_VOTE = "post_comments_sorted_by_vote";

    public void init() {
		initHector();
	}

    private void initHector() {
        Cluster cluster = HFactory.getOrCreateCluster("training-cluster", CASS_HOST + ":9160");
        keyspace = HFactory.createKeyspace(KEYSPACE_NAME, cluster);
        entityManager = new EntityManagerImpl(keyspace, "com.btoddb.blog" );
    }


    public User saveUser(User user ) {

        Mutator<String> m = HFactory.createMutator(keyspace, StringSerializer.get());
        m.addInsertion(user.getEmail(), CF_USERS, HFactory.createColumn(USER_COL_PASS, user.getPassword(), StringSerializer.get(), StringSerializer.get()));
        m.addInsertion(user.getEmail(), CF_USERS, HFactory.createColumn(USER_COL_NAME, user.getName(), StringSerializer.get(), StringSerializer.get()));
        m.execute();
        return user;
    }


    public Post savePost(Post post ) {
        Mutator<byte[]> m = HFactory.createMutator(keyspace, BytesArraySerializer.get());

        entityManager.persist(Collections.singleton(post), m);


        DateTime dt = calculatePostTimeGranularity(post.getCreateTimestamp());

        m.addCounter(UUIDSerializer.get().toBytes(post.getId()), CF_VOTES, HFactory.createCounterColumn("v", 0));

        // send the batch
        m.execute();

        post.setVotes( 0L );
        return post;
    }


    public Comment saveComment(Comment comment ) {
        Mutator<byte[]> m = HFactory.createMutator(keyspace, BytesArraySerializer.get());

        entityManager.persist(Collections.singleton(comment), m);

        m.addCounter(UUIDSerializer.get().toBytes(comment.getId()), CF_VOTES, HFactory.createCounterColumn("v", 0));

        m.addInsertion(UUIDSerializer.get().toBytes(comment.getPostId()), CF_POST_COMMENT_VOTE_CHANGE, HFactory.createColumn("v", EMPTY_BYTES));

        m.execute();

        comment.setVotes( 0L );
        return comment;
    }

    public User findUser( String email ) {

        SliceQuery<String, String, String> q = HFactory.createSliceQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        q.setColumnFamily(CF_USERS);
        q.setKey(email);
        q.setRange(null, null, false, 100);
        QueryResult<ColumnSlice<String, String>> qr = q.execute();

        ColumnSlice<String, String> slice = qr.get();

        if ( null == slice || slice.getColumns().isEmpty() ) {
            return null;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(slice.getColumnByName(USER_COL_PASS).getValue());
        user.setName(slice.getColumnByName(USER_COL_NAME).getValue());

        return user;
    }

    public Post findPost( UUID postId ) {
        Post p = entityManager.find(Post.class, postId);
        Map<UUID, Long> voteMap = findVotes(Collections.singletonList(postId));
        p.setVotes(voteMap.get(postId));
        return p;
    }

    public Comment findComment(UUID uuid) {
        Comment c = entityManager.find( Comment.class, uuid);
        if ( null == c ) {
            return null;
        }

        Map<UUID, Long> voteMap = findVotes(Collections.singletonList(uuid));
        if ( voteMap.isEmpty() ) {
            return c;
        }

        c.setVotes(voteMap.get(uuid));
        return c;
    }

    private List<Post> findPostsByUUIDList(List<UUID> uuidList, boolean includeVotes) {
        MultigetSliceQuery<UUID, String, byte[]> q = HFactory.createMultigetSliceQuery(keyspace, UUIDSerializer.get(), StringSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POSTS);
        q.setRange(null, null, false, 100);
        q.setKeys(uuidList);
        QueryResult<Rows<UUID, String, byte[]>> qr = q.execute();
        Rows<UUID, String, byte[]> rows = qr.get();
        if ( null == rows || 0 == rows.getCount()) {
            return null;
        }

        Map<UUID, Post> postMap = new HashMap<UUID, Post>();
        for ( Row<UUID, String, byte[]> row : rows) {
            postMap.put(row.getKey(), entityManager.find(Post.class, row.getKey(), row.getColumnSlice()));
        }

        List<Post> postList = new LinkedList<Post>();
        for ( UUID uuid : uuidList ) {
            postList.add(postMap.get(uuid));
        }

        if ( includeVotes ) {
            Map<UUID, Long> voteMap = findVotes(uuidList);
            for (Post post : postList ) {
                Long votes = voteMap.get(post.getId());
                if ( null != votes ) {
                    post.setVotes(votes);
                }
            }
        }

        return postList;
    }

    public List<UUID> findPostUUIDsByUser( String userEmail ) {
        SliceQuery<String, UUID, byte[]> q = HFactory.createSliceQuery(keyspace, StringSerializer.get(), UUIDSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_USER_POSTS);
        q.setKey(userEmail);
        q.setRange(null, null, false, 10);

        ColumnSliceIterator<String, UUID, byte[]> iter = new ColumnSliceIterator<String, UUID, byte[]>(q, null, (UUID)null, false);
        List<UUID> uuidList = new LinkedList<UUID>();
        while ( iter.hasNext() ) {
            HColumn<UUID, byte[]> col = iter.next();
            uuidList.add(col.getName());
        }

        return uuidList;
    }

    public List<Post> findPostsByUser( String userEmail ) {
        List<UUID> uuidList = findPostUUIDsByUser(userEmail);
        if ( uuidList.isEmpty() ) {
            return null;
        }

        return findPostsByUUIDList( uuidList, true );
    }

    public List<UUID> findPostUUIDsByTimeRange( DateTime start, DateTime end ) {
        DateTime firstRow = calculatePostTimeGranularity(start);
        DateTime lastRow = calculatePostTimeGranularity(end);

        MultigetSliceQuery<String, UUID, byte[]> q = HFactory.createMultigetSliceQuery(keyspace, StringSerializer.get(), UUIDSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POSTS_BY_TIME);

        DateTime current = firstRow;
        List<String> rowKeys = new LinkedList<String>();
        while ( current.isBefore(lastRow) || current.isEqual(lastRow) ) {
            rowKeys.add(hourFormatter.print(current));
            current = current.plusHours(1);
        }
        q.setKeys(rowKeys);
        q.setRange(null, null, false, 1000);

        QueryResult<Rows<String, UUID, byte[]>> qr = q.execute();
        Rows<String, UUID, byte[]> rows = qr.get();
        if ( null == rows || 0 == rows.getCount() ) {
            return null;
        }

        long startAsLong = start.getMillis();
        long endAsLong = end.getMillis();

        List<UUID> uuidList = new LinkedList<UUID>();
        for ( Row<String, UUID, byte[]> row : rows ) {
            ColumnSlice<UUID, byte[]> slice = row.getColumnSlice();
            for ( HColumn<UUID, byte[]> col : slice.getColumns() ) {
                long t = TimeUUIDUtils.getTimeFromUUID(col.getName());
                if ( t > endAsLong ) {
                    break;
                }

                if ( t >= startAsLong ) {
                    uuidList.add(col.getName());
                }
            }
        }

        return uuidList;
    }


    public List<Post> findPostsByTimeRange(DateTime start, DateTime end) {
        List<UUID> uuidList = findPostUUIDsByTimeRange(start, end);
        if ( uuidList.isEmpty() ) {
            return null;
        }

        return findPostsByUUIDList( uuidList, true );
    }

    public List<UUID> findCommentUUIDsByUser( String userEmail ) {

        List<UUID> uuidList = new LinkedList<UUID>();

        return uuidList;
    }

    public List<UUID> findCommentUUIDsByPostSortedByTime(UUID postId) {
        SliceQuery<UUID, UUID, byte[]> q = HFactory.createSliceQuery(keyspace, UUIDSerializer.get(), UUIDSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POST_COMMENTS);
        q.setKey(postId);
        q.setRange(null, null, false, 10);

        ColumnSliceIterator<UUID, UUID, byte[]> iter = new ColumnSliceIterator<UUID, UUID, byte[]>(q, null, (UUID)null, false);
        List<UUID> uuidList = new LinkedList<UUID>();
        while ( iter.hasNext() ) {
            HColumn<UUID, byte[]> col = iter.next();
            uuidList.add(col.getName());
        }

        return uuidList;
    }

    public List<UUID> findCommentUUIDsByPostSortedByVotes(UUID postId) {
        SliceQuery<UUID, Composite, byte[]> q = HFactory.createSliceQuery(keyspace, UUIDSerializer.get(), CompositeSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POST_COMMENTS_SORTED_BY_VOTE);
        q.setKey(postId);
        q.setRange(null, null, false, 10);

        ColumnSliceIterator<UUID, Composite, byte[]> iter = new ColumnSliceIterator<UUID, Composite, byte[]>(q, null, (Composite)null, false);
        List<UUID> uuidList = new LinkedList<UUID>();
        while ( iter.hasNext() ) {
            HColumn<Composite, byte[]> col = iter.next();
            uuidList.add(UUIDSerializer.get().fromByteBuffer((ByteBuffer)col.getName().get(1)));
        }

        return uuidList;
    }

    public List<Comment> findCommentsByUUIDList( List<UUID> uuidList ) {
        MultigetSliceQuery<UUID, String, byte[]> q = HFactory.createMultigetSliceQuery(keyspace, UUIDSerializer.get(), StringSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_COMMENTS);
        q.setRange(null, null, false, 100);
        q.setKeys(uuidList);
        QueryResult<Rows<UUID, String, byte[]>> qr = q.execute();
        Rows<UUID, String, byte[]> rows = qr.get();
        if ( null == rows || 0 == rows.getCount()) {
            return null;
        }

        Map<UUID, Comment> commentMap = new HashMap<UUID, Comment>();
        for ( Row<UUID, String, byte[]> row : rows) {
            commentMap.put(row.getKey(), entityManager.find(Comment.class, row.getKey(), row.getColumnSlice()));
        }

        List<Comment> commentList = new LinkedList<Comment>();
        for ( UUID uuid : uuidList ) {
            commentList.add(commentMap.get(uuid));
        }

        Map<UUID, Long> voteMap = findVotes(uuidList);
        for (Comment comment : commentList ) {
            Long votes = voteMap.get(comment.getId());
            if ( null != votes ) {
                comment.setVotes(votes);
            }
        }

        return commentList;
    }

    public List<Comment> findCommentsByUser( String userEmail ) {
        List<UUID> uuidList = findCommentUUIDsByUser(userEmail);
        if ( uuidList.isEmpty() ) {
            return null;
        }

        return findCommentsByUUIDList(uuidList);
    }

    private void vote(String userEmail, String type, UUID uuid) {
        Mutator<byte[]> m = HFactory.createMutator(keyspace, BytesArraySerializer.get());

        m.addCounter(UUIDSerializer.get().toBytes(uuid), CF_VOTES, HFactory.createCounterColumn("v", 1));
        m.addInsertion(StringSerializer.get().toBytes(userEmail), CF_USER_VOTES, HFactory.createColumn(uuid, System.currentTimeMillis()));

        if ( "comment".equalsIgnoreCase(type) ) {
            Comment c = findComment(uuid);
            if ( null != c) {
                m.addInsertion( UUIDSerializer.get().toBytes(c.getPostId()), CF_POST_COMMENT_VOTE_CHANGE, HFactory.createColumn("v", EMPTY_BYTES) );
            }
        }

        m.execute();
    }

    public void voteOnPost( String userEmail, UUID postId ) {
        vote(userEmail, "POST", postId);
    }

    public void voteOnComment( String userEmail, UUID commentId ) {
        vote(userEmail, "COMMENT", commentId);
    }

    public Map<UUID, Long> findVotes( List<UUID> uuidList ) {
        if ( null == uuidList || uuidList.isEmpty() ) {
            return Collections.emptyMap();
        }

        MultigetSliceCounterQuery<UUID, String> q = HFactory.createMultigetSliceCounterQuery(keyspace, UUIDSerializer.get(), StringSerializer.get());
        q.setColumnFamily(CF_VOTES);
        q.setKeys(uuidList);
        q.setRange(null, null, false, 100);
        QueryResult<CounterRows<UUID, String>> qr = q.execute();
        CounterRows<UUID, String> rows = qr.get();
        if ( null == rows || 0 == rows.getCount()) {
            return null;
        }

        Map<UUID, Long> voteList = new HashMap<UUID, Long>();

        for ( CounterRow<UUID, String> row : rows ) {
            CounterSlice<String> slice = row.getColumnSlice();
            if ( null != slice && !slice.getColumns().isEmpty()) {
                voteList.put( row.getKey(), slice.getColumnByName("v").getValue());
            }
        }

        return voteList;
    }

    public DateTime findUserVote(String userEmail, UUID uuid) {
        ColumnQuery<String, UUID, Long> q = HFactory.createColumnQuery(keyspace, StringSerializer.get(), UUIDSerializer.get(), LongSerializer.get());
        q.setColumnFamily(CF_USER_VOTES);
        q.setKey(userEmail);
        q.setName(uuid);

        QueryResult<HColumn<UUID, Long>> qr = q.execute();
        HColumn<UUID, Long> col = qr.get();
        if ( null != col ) {
            return new DateTime(col.getValue());
        }
        else {
            return null;
        }
    }

    public List<Post> findPostsByVote(int number) {
        SliceQuery<byte[], Composite, byte[]> q = HFactory.createSliceQuery(keyspace, BytesArraySerializer.get(), CompositeSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POSTS_BY_VOTE);
        q.setKey(POSTS_BY_VOTE_KEY);
        q.setRange(null, null, false, 10);

        ColumnSliceIterator<byte[], Composite, byte[]> iter = new ColumnSliceIterator<byte[], Composite, byte[]>(q, null, (Composite)null, false);
        List<UUID> uuidList = new LinkedList<UUID>();
        Map<UUID, Long> voteMap = new HashMap<UUID, Long>();
        int count = number;
        while ( iter.hasNext() && 0 < count--) {
            HColumn<Composite, byte[]> col = iter.next();
            ByteBuffer bb = (ByteBuffer)col.getName().get(1);
            UUID uuid = UUIDSerializer.get().fromByteBuffer(bb);
            uuidList.add( uuid );
            voteMap.put( uuid, LongSerializer.get().fromByteBuffer((ByteBuffer)col.getName().get(0)));
        }

        List<Post> postList = findPostsByUUIDList(uuidList, false);
        if ( null != postList && !postList.isEmpty() ) {
            for ( Post p : postList ) {
                p.setVotes(voteMap.get(p.getId()));
            }
        }

        return postList;
    }

    public boolean postCommentsNeedSorting(UUID postId) {
        ColumnQuery<UUID, String, byte[]> q = HFactory.createColumnQuery(keyspace, UUIDSerializer.get(), StringSerializer.get(), BytesArraySerializer.get());
        q.setColumnFamily(CF_POST_COMMENT_VOTE_CHANGE);
        q.setKey(postId);
        q.setName("v");

        QueryResult<HColumn<String, byte[]>> qr = q.execute();
        HColumn<String, byte[]> col = qr.get();
        return null != col;
    }

    public void sortPostsByVote(int days) {
        Mutator<byte[]> m = HFactory.createMutator(keyspace, BytesArraySerializer.get());

        m.addDeletion(POSTS_BY_VOTE_KEY, CF_POSTS_BY_VOTE);

        DateTime start = new DateTime().minusDays(days).hourOfDay().roundFloorCopy();
        DateTime end = new DateTime();
        List<UUID> uuidList = findPostUUIDsByTimeRange(start, end);

        if ( null != uuidList && !uuidList.isEmpty() ) {
            Map<UUID, Long> voteMap = findVotes(uuidList);
            // now write to CF
            for (Map.Entry<UUID, Long> entry : voteMap.entrySet() ) {
                Composite colName = new Composite(entry.getValue(), entry.getKey());
                m.addInsertion(POSTS_BY_VOTE_KEY, CF_POSTS_BY_VOTE, HFactory.createColumn(colName, EMPTY_BYTES));
            }
        }

        // send the batch
        m.execute();
    }

    public void sortCommentsByVotes(UUID postId) {
        Mutator<byte[]> m = HFactory.createMutator(keyspace, BytesArraySerializer.get());

        byte[] postIdAsBytes = UUIDSerializer.get().toBytes(postId);
        m.addDeletion(postIdAsBytes, CF_POST_COMMENTS_SORTED_BY_VOTE);

        List<UUID> uuidList = findCommentUUIDsByPostSortedByTime(postId);
        if ( null == uuidList || uuidList.isEmpty() ) {
            return;
        }

        Map<UUID, Long> voteMap = findVotes(uuidList);

        for (Map.Entry<UUID, Long> entry : voteMap.entrySet() ) {
            Composite colName = new Composite(entry.getValue(), entry.getKey());
            m.addInsertion(postIdAsBytes, CF_POST_COMMENTS_SORTED_BY_VOTE, HFactory.createColumn(colName, EMPTY_BYTES));
        }

        m.addDeletion(postIdAsBytes, CF_POST_COMMENT_VOTE_CHANGE);

        m.execute();
    }

    private DateTime calculatePostTimeGranularity(DateTime timestamp) {
        return timestamp.withZone(DateTimeZone.forOffsetHours(0)).hourOfDay().roundFloorCopy();
    }

}
