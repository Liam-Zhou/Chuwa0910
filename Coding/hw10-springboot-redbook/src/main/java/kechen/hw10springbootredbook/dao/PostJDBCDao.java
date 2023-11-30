package kechen.hw10springbootredbook.dao;

import kechen.hw10springbootredbook.entity.Post;

import java.sql.*;

public class PostJDBCDao {
    public Post getPostById(int id) throws Exception {
        Post post = new Post();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1, load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2， connect to Database;  （url, username, password）
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "un", "pw");
            // 3， define sql statement
            String sql = "SELECT *  FROM posts WHERE ID = " + id;
            // 4, create a statement object
            statement = connection.createStatement();
            // 5, use statement object to execute sql statement;
            resultSet = statement.executeQuery(sql); // the result is return to ResultSet

            while(resultSet.next()) {
                // 6, get ResultSet's data to java object(employee), Retrieve Data from ResultSet
                post.setId((long) resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setDescription(resultSet.getString("decription"));
                post.setContent(resultSet.getString("content"));
            }
            return post;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
