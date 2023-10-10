package com.hw40.mongoblog.Controller;

import com.hw40.mongoblog.DAO.BlogRepository;
import com.hw40.mongoblog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository; // BlogController can use this repository for database operations
    // With the BlogRepository in place, Spring Data MongoDB will provide basic CRUD operations for Blog entity.

    @PostMapping("/blogs")
    public Blog createBlog(@RequestBody Blog blog) {
        return blogRepository.save(blog);
    }
}
