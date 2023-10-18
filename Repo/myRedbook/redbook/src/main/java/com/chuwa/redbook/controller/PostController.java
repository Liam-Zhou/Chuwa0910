package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import com.chuwa.redbook.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO){
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
        return new ResponseEntity<>(postService.getAllPosts(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable(name="id") long id){
        return postService.getPostById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePostById(@PathVariable(name="id") long id, @Valid @RequestBody PostDTO postDTO){
        PostDTO response = postService.updatePost(postDTO,id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }
}
