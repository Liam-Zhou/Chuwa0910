package com.chuwa.mongoblog.Controller;

import com.chuwa.mongoblog.Payload.BlogDTO;
import com.chuwa.mongoblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDTO> createPost(@RequestBody BlogDTO blogDTO) {
        BlogDTO response = blogService.createPost(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
