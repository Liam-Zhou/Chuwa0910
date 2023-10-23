package com.hyc.redbookblog.service;

import com.hyc.redbookblog.payload.CommentDto;

import java.util.List;

/**
 * @Author: hyc
 * @Date: 10/22/23
 */
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentDtoRequest);

    void deleteComment(Long postId, Long commentId);
}
