package com.chuwa.mongoblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class PostRepositoryImpl implements PostRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public
}
