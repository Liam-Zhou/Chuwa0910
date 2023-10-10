package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {

}
