package com.hyc.mongoblog.dao;

import com.hyc.mongoblog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description:
 * @Author: hyc
 */
public interface PostRepository extends MongoRepository<Post, String> {


}
