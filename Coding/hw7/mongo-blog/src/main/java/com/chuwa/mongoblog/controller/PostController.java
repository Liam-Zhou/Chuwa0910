package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.model.Post;
import com.chuwa.mongoblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping(value = "/posts")
    public String postBlog(@RequestBody Post post) {
        postRepository.save(post);
        return "Blog posted";
    }
}
