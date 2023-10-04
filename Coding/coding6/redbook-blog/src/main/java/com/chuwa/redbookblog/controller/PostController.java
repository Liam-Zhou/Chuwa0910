package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){ //JSON Object
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        List<PostDTO> response = postService.getAllPosts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") long id){
        PostDTO response = postService.getPostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePostById(@PathVariable(name = "id") long id, @RequestBody PostDTO postDTO){
        PostDTO response = postService.updatePostById(postDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(postService.deletePostById(id), HttpStatus.OK);
    }
}
