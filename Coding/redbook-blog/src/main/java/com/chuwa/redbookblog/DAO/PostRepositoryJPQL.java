package com.chuwa.redbookblog.DAO;

import com.chuwa.redbookblog.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryJPQL {

    List<Post> getAllPostWithJPQL();
}
