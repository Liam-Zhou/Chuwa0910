package com.chuwa.mongoblog.repository;

import com.chuwa.mongoblog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,Long> {
    //nothing here?
}
