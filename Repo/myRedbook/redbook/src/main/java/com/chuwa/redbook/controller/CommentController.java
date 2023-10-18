package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts/{postId}")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") Long postId,
                                                    @Valid @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDTO> getCommentsById(@PathVariable(value = "postId") Long postId,
                                                      @PathVariable(value = "id") Long id){
        CommentDTO commentDTO = commentService.getCommentById(postId, id);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long id,
                                                    @Valid @RequestBody CommentDTO commentDTO){
        CommentDTO updateComment = commentService.updateComment(postId, id, commentDTO);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long id) {
        commentService.deleteComment(postId, id);

        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }
}
