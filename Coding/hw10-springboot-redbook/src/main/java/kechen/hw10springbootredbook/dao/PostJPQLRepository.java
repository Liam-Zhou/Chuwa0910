package kechen.hw10springbootredbook.dao;

import kechen.hw10springbootredbook.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}
