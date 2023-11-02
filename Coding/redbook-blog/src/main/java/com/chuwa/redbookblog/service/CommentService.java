package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.DAO.CommentRepository;
import com.chuwa.redbookblog.payload.CommentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(long postId, CommentDTO commentDTO);
    List<CommentDTO> getCommentsByPostId(long postId);

    CommentDTO getCommentById(Long postId, Long commentId);

    CommentDTO updateComment(Long postId,Long commentId,CommentDTO commentDTO);

    void deleteComment(Long postId, Long commentId);
}
