package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostDTOV2;
import com.chuwa.redbookblog.payload.PostResponse;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.AppConstants;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostContorller {

    private PostService postService;

    //Bean @Service
    public PostContorller(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){ //JSON Object
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir,
            ResponseEntity<PostResponse> ResponseEntity) {

        PostResponse allPosts = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(allPosts);
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

    @GetMapping("/v2/{id}")
    public PostDTOV2 getPostByIdv2(@PathVariable(name="id") long id){
        PostDTOV2 postDTO = new PostDTOV2();

        return postDTO;
    }

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
