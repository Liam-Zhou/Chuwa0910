package com.chuwa.cassandrablog.service;

import com.chuwa.cassandrablog.entity.Comment;
import com.chuwa.cassandrablog.entity.Post;
import com.chuwa.cassandrablog.entity.User;
import com.chuwa.cassandrablog.dao.BlogDao;
import me.prettyprint.cassandra.utils.TimeUUIDUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;
import java.util.UUID;

public class BlogService {
    public static final int MAX_SORT_DAYS = 30;

    private final BlogDao dao;

    public BlogService(BlogDao dao) {
        this.dao = dao;
    }


    public Comment createComment(String userEmail, UUID postId, String commentText) {
        User user = dao.findUser(userEmail);
        if ( null == user ) {
            throw new RuntimeException( "user with email, " + userEmail + ", does not exist!  Cannot create comment");
        }

        return dao.saveComment(new Comment(TimeUUIDUtils.getUniqueTimeUUIDinMillis(), user.getEmail(), user.getName(),
                                            postId, System.currentTimeMillis(), commentText));
    }


    public User createUser(String email, String password, String fullName) {
        return dao.saveUser(new User(email, password, fullName));
    }

    public Post createPost(String userEmail, String title, String text) {
        User user = dao.findUser(userEmail);
        return dao.savePost(new Post(TimeUUIDUtils.getUniqueTimeUUIDinMillis(), user.getEmail(), user.getName(), title, new DateTime(), text));
    }


    public List<Post> findPostsByTimeRange(DateTime start, DateTime end) {
        return dao.findPostsByTimeRange(start, end);
    }

    public void findRecentPosts(int minutes) {
        DateTime end = new DateTime().withZone(DateTimeZone.forOffsetHours(0));
        DateTime start = end.minusMinutes(minutes);
        findPostsByTimeRange(start, end);
    }

    public List<Post> findTopPosts(int number) {
        dao.sortPostsByVote(MAX_SORT_DAYS);
        return dao.findPostsByVote(number);
    }

    public void voteOnPost(String userEmail, UUID uuid) {
        if ( null == dao.findUserVote(userEmail, uuid) ) {
            dao.voteOnPost(userEmail, uuid);
        }
    }


    public void voteOnComment(String userEmail, UUID uuid) {
        if ( null == dao.findUserVote(userEmail, uuid) ) {
            dao.voteOnComment(userEmail, uuid);
        }
    }

    public User findUser(String userEmail) {
        return dao.findUser(userEmail);
    }

    public List<Comment> findCommentsByUser(String userEmail) {
        return dao.findCommentsByUser(userEmail);
    }

    public Post findPost(UUID postId) {
        return dao.findPost(postId);
    }

    public Comment findComment(UUID commentId) {
        return dao.findComment(commentId);
    }
}
