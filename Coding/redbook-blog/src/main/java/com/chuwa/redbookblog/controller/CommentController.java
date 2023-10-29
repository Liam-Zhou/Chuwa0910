package com.chuwa.redbookblog.controller;


import com.chuwa.redbookblog.entity.Comment;
import com.chuwa.redbookblog.payload.CommentDTO;
import com.chuwa.redbookblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value="postId") long id,
                                                    @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.createComment(id,commentDTO), HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> getCommentsById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "id") Long commentId) {

        CommentDTO commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }


    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @RequestBody CommentDTO commentDTO) {
        CommentDTO updateComment = commentService.updateComment(postId, commentId, commentDTO);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>("Comment deleted Successfully", HttpStatus.OK);
    }

}
