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

//    @Autowired
//    private PostService postService;

    //Bean @Service
    private PostService postService;

    //Bean @Service
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
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable(name="id") long id){
        PostDTO postDTO = postService.getPostById(id);
        return postDTO;
    }

//    @GetMapping("/v2/{id}")
//    public PostDTOV2 getPostByIdv2(@PathVariable(name="id") long id){
//        PostDTOV2 postDTO = new PostDTOV2(); //postService.getPostV2ById(id);
//
//        return postDTO;
//    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePostById(@PathVariable(name="id") long id, @RequestBody PostDTO postDTO){
        PostDTO response = postService.updatePost(postDTO,id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
