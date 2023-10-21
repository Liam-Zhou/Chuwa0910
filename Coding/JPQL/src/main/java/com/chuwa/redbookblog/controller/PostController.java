package com.chuwa.redbookblog.controller;


import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){ //JSON Object
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    //jpql-----------------------------------------------------------------------------------
    @GetMapping("/jpql")
    public List<PostDTO> getAllPostsJPQL() { return postService.getAllPostWithJPQL(); }

    //@GetMapping()
    @GetMapping("/jpql-named/{id}")
    public ResponseEntity<PostDTO> getPostByIdOrTitleJPQLNamed(@PathVariable(name = "id") long id,
                                                               @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdJPQLNamedParameter(id, title));
    }

    @GetMapping("/sql-index/{id}")
    public ResponseEntity<PostDTO> getPostByIdOrTitleSQLIndex(@PathVariable(name = "id") long id,
                                                              @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdSQLIndexParameter(id, title));
    }

    @GetMapping("/sql-named/{id}")
    public ResponseEntity<PostDTO> getPostByIdOrTitleSQLParameter(@PathVariable(name = "id") long id,
                                                                  @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdSQLNamedParameter(id, title));
    }
    //jpql-----------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable(name="id") long id){
        PostDTO postDTO = postService.getPostById(id);
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
