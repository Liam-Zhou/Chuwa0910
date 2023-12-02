package kechen.hw10springbootredbook.dao;

import kechen.hw10springbootredbook.Mapper.PostRowMapper;
import kechen.hw10springbootredbook.entity.Post;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostJDBCTemplateDao {

    private final JdbcTemplate jdbcTemplate;

    public PostJDBCTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PostRowMapper(), id);
    }

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, description, content) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getContent());
    }
    /**
     * GET/SELECT
     */
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Post>(Post.class));
    }

    public Post getPostById(int id) {
        String sql = "SELECT * FROM post WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Post>(Post.class),
                new Object[] {id});
    }

    /**
     * POST/Insert
     */
    public int insertPost(Post post)
    {
        String sql = "INSERT INTO PLAYER (ID, title, description, content) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update( sql, new Object[]
                { post.getId(), post.getTitle(), post.getDescription(),
                        post.getContent()
                });
    }

    /**
     * UPDATE
     */
    public int updatePost(Post post){
        String sql = "UPDATE POST " +
                "SET Title = ?, Description = ? , Content = ? ";

        return jdbcTemplate.update( sql, new Object[] {
                post.getTitle(),
                post.getDescription(),
                post.getContent() }
        );
    }

    /**
     * DELETE
     */
    public int deletePostById(int id) {
        String sql="DELETE FROM POST WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }

}



