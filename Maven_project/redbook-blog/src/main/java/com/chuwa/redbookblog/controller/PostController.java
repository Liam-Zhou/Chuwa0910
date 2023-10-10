package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable(name = "id") long id){
        PostDTO postDTO = postService.getPostById(id);
        return postDTO;
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePostById(@PathVariable(name = "id") long id,@RequestBody PostDTO postDTO){
        PostDTO response = postService.getPostById(id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> updatePostById(@PathVariable(name = "id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
