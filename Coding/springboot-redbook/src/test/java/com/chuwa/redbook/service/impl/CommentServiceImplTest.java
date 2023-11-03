package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    public void testCreateComment() {
        CommentDto commentDto = new CommentDto();
        Comment comment = new Comment();
        Post post = new Post();
        long postId = 1L;

        Mockito.when(modelMapper.map(commentDto, Comment.class)).thenReturn(comment);
        Mockito.when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto savedComment = commentService.createComment(postId, commentDto);

        assertEquals(commentDto, savedComment);
        Mockito.verify(modelMapper).map(comment, CommentDto.class);
    }

    @Test
    public void testGetCommentsByPostId() {
        // Prepare test data
        // ...

        Mockito.when(commentRepository.findByPostId(any(Long.class))).thenReturn(Collections.emptyList());
        Mockito.when(modelMapper.map(any(Comment.class), eq(CommentDto.class))).thenReturn(new CommentDto());

        List<CommentDto> comments = commentService.getCommentsByPostId(1L);

        // Asserts and verifications
    }

}
