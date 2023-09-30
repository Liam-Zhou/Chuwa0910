package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.payload.BlogDTO;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
