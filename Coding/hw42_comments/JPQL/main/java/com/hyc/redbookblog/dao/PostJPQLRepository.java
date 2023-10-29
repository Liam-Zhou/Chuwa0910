package com.hyc.redbookblog.dao;

import com.hyc.redbookblog.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hyc
 * @Date: 10/23/23
 */
@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}
