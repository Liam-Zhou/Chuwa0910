package kechen.hw8springbootredbook.service;

import kechen.hw8springbootredbook.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateComment(long postId, long commentId, CommentDto commentDtoRequest);

    void deleteComment(long postId, long commentId);
}
