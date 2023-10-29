package com.hw40.mongoblog.DAO;

import com.hw40.mongoblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
    // create a repository interface to interact with MongoDB
}
