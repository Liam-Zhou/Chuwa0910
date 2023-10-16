package com.chuwa.mongoBlog.dao;

import com.chuwa.mongoBlog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, Long> {
}
