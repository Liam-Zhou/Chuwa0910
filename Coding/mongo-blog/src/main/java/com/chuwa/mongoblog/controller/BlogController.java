package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.payload.BlogDTO;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongdb/v1/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO){ //JSON Object
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
