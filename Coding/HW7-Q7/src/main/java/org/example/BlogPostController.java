package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository; // Assuming you have a repository for MongoDB

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost post) {
        return blogPostRepository.save(post);
    }
}

