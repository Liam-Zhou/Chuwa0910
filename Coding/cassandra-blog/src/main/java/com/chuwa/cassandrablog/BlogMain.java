package com.chuwa.cassandrablog;

import com.chuwa.cassandrablog.dao.BlogDao;
import com.chuwa.cassandrablog.entity.Comment;
import com.chuwa.cassandrablog.entity.Post;
import com.chuwa.cassandrablog.entity.User;
import com.chuwa.cassandrablog.service.BlogService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.apache.commons.lang.time.StopWatch;

import java.util.List;
import java.util.UUID;


public class BlogMain {
    private static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("MMddYYYY:HHmmss").withZone(DateTimeZone.forOffsetHours(0));

    private static BlogService service;
    private static BlogRenderer renderer;

    public static void main(String[] args) {


        if ( 1 > args.length ) {
            showUsage();
            return;
        }


        BlogDao dao = new BlogDao();
        dao.init();

        service = new BlogService(dao);
        renderer = new BlogRenderer(dao);

        for ( int i=0;i < 1;i++ ) {
            StopWatch sw = new StopWatch();
            sw.start();

            try {
                processCommand(args);
            }
            finally {
                System.out.println("execution duration = " + sw.getTime() + "ms");
            }
        }
    }

    private static void processCommand(String[] args) {
        String command = args[0];
        if ( "show-posts-by-range".equalsIgnoreCase(command)) {
            checkArgs("show-posts-by-range", args, 2);
            DateTime start = dateFormatter.withZone(DateTimeZone.forOffsetHours(0)).parseDateTime(args[1]);
            DateTime end = dateFormatter.withZone(DateTimeZone.forOffsetHours(0)).parseDateTime(args[2]);
            List<Post> postList = service.findPostsByTimeRange(start, end);
            System.out.println( String.format("Posts from %s to %s : ", start, end) );
            if ( null != postList && !postList.isEmpty()) {
                for ( Post p : postList ) {
                    renderer.displayPost(p, false, null);
                }
            }
        }
        else if ( "show-user-comments".equalsIgnoreCase(command)) {
            checkArgs("show-user-comments", args, 1);
            User user = service.findUser(args[1]);
            if ( null != user ) {
                System.out.print( "All Comments for : " );
                renderer.displayUser(user, false, null);
                List<Comment> commentList = service.findCommentsByUser(user.getEmail());
                if ( null != commentList && !commentList.isEmpty()) {
                    for ( Comment c : commentList ) {
                        renderer.displayComment(c, "  ");
                    }
                }
            }
        }
        else if ( "show-user".equalsIgnoreCase(command)) {
            checkArgs("show-user", args, 1);
            User u = service.findUser(args[1]);
            renderer.displayUser(u, true, null);
        }
        else if ( "show-post".equalsIgnoreCase(command)) {
            checkArgs("show-post", args, 1);
            Post p = service.findPost( UUID.fromString(args[1]) );
            renderer.displayPost(p, true, null);
        }
        else if ( "show-comment".equalsIgnoreCase(command)) {
            checkArgs("show-comment", args, 1);
            Comment c = service.findComment(UUID.fromString(args[1]));
            renderer.displayComment(c, null);
        }
        else if ( "show-recent-posts".equalsIgnoreCase(command)) {
            checkArgs("show-recent-posts", args, 1);
            service.findRecentPosts(Integer.parseInt(args[1]));
        }
        else if ( "show-top-posts".equalsIgnoreCase(command)) {
            checkArgs("show-top-posts", args, 1);
            List<Post> postList = service.findTopPosts(Integer.parseInt(args[1]));
            if ( null != postList && !postList.isEmpty() ) {
                for ( Post p : postList ) {
                    renderer.displayPost(p, false, null);
                }
            }
        }
        else if ( "create-user".equalsIgnoreCase(command)) {
            checkArgs("create-user", args, 3);
            User u = service.createUser(args[1], args[2], args[3]);
            renderer.displayUser(u, false, null);
        }
        else if ( "create-post".equalsIgnoreCase(command)) {
            checkArgs("create-post", args, 3);
            Post p = service.createPost(args[1], args[2], args[3]);
            renderer.displayPost(p, false, null);
        }
        else if ( "create-comment".equalsIgnoreCase(command) ) {
            checkArgs("create-comment", args, 3);
            Comment c = service.createComment(args[1], UUID.fromString(args[2]), args[3]);
            renderer.displayComment(c, null);
        }
        else if ( "vote-on-post".equalsIgnoreCase(command) ) {
            checkArgs("vote-on-post", args, 2);
            UUID uuid = UUID.fromString(args[2]);
            service.voteOnPost(args[1], uuid);
            renderer.displayPost(service.findPost(uuid), false, null);
        }
        else if ( "vote-on-comment".equalsIgnoreCase(command) ) {
            checkArgs("vote-on-comment", args, 2);
            UUID uuid = UUID.fromString(args[2]);
            service.voteOnComment(args[1], uuid);
            renderer.displayComment(service.findComment(uuid), null);
        }
        else {
            System.out.println( "Unknown command : " + command);
            showUsage();
        }
    }

    private static void showUsage() {
        System.out.println();

        System.out.println( "usage: BlogMain <command> [<params>]" );
        System.out.println();
        System.out.println( "  commands:" );
        System.out.println( "    create-user <user-email> <password> <name>" );
        System.out.println( "    create-post <user-email> <title> <text>");
        System.out.println( "    create-comment <user-email> <post-id> <text>" );
        System.out.println( "    show-user <user-email>" );
        System.out.println( "    show-post <post-id>" );
        System.out.println( "    show-comment <comment-id>" );
        System.out.println( "    show-posts-by-range <start-time> <end-time> (start/end time in format MMDDYYYY:HHMMSS as GMT)" );
        System.out.println( "    show-user-comments <user-email>" );
        System.out.println( "    show-top-posts <number-of-posts>" );
        System.out.println( "    show-recent-posts <minutes>" );
        System.out.println( "    vote-on-post <user-email> <post-id>" );
        System.out.println( "    vote-on-comment <user-email> <comment-id>" );

        System.out.println();
    }

    private static void checkArgs(String command, String[] args, int numRequiredParams) {
        if ( 1+numRequiredParams != args.length ) {
            System.out.println();
            System.out.println("*** ERROR ***  '" + command +"' command requires " + numRequiredParams + " param(s)");
            showUsage();
            System.exit(1);
        }
    }

}
