package org.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
    // Define custom queries or use the default CRUD methods
}
