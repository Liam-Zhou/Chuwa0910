package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    CommentDTO createComment(long postId, CommentDTO commentDto);

    List<CommentDTO> getCommentsByPostId(long postId);

    CommentDTO getCommentById(Long postId, Long commentId);

    CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentDtoRequest);

    void deleteComment(Long postId, Long commentId);
}
