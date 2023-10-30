package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        if (post == null) {
            return ResponseEntity.badRequest().build();
        }

        // Save the post and return a response entity
        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }
}
