package com.chuwa.redbookblog.dao;

import com.chuwa.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostJPQLRepository {
    List<Post> getAllPostWithJPQL();
}
