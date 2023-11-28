package controller;

import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/create") // Make sure this mapping matches your Postman request
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        postRepository.save(post);
        return ResponseEntity.ok("Post created successfully");
    }
}
