package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private CommentDto commentDto;
    private Comment comment;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.comment = new Comment(1L, "John Doe", "john@example.com", "This is a comment");
        this.post = new Post(1L, "Sample Post", "Sample Description", "Sample Content", null, null);
        this.comment.setPost(post);
        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto createdComment = commentService.createComment(1L, commentDto);

        Assertions.assertNotNull(createdComment);
        Assertions.assertEquals(commentDto.getName(), createdComment.getName());
        Assertions.assertEquals(commentDto.getEmail(), createdComment.getEmail());
        Assertions.assertEquals(commentDto.getBody(), createdComment.getBody());
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        when(commentRepository.findByPostId(1L)).thenReturn(comments);

        List<CommentDto> commentDtos = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(1, commentDtos.size());
        CommentDto retrievedComment = commentDtos.get(0);
        Assertions.assertEquals(commentDto.getName(), retrievedComment.getName());
        Assertions.assertEquals(commentDto.getEmail(), retrievedComment.getEmail());
        Assertions.assertEquals(commentDto.getBody(), retrievedComment.getBody());
    }

    @Test
    void testGetCommentById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        CommentDto retrievedComment = commentService.getCommentById(1L, 1L);

        Assertions.assertNotNull(retrievedComment);
        Assertions.assertEquals(commentDto.getName(), retrievedComment.getName());
        Assertions.assertEquals(commentDto.getEmail(), retrievedComment.getEmail());
        Assertions.assertEquals(commentDto.getBody(), retrievedComment.getBody());
    }

    @Test
    void testGetCommentById_ResourceNotFoundException() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testUpdateComment() {
        String updatedName = "Updated Name";
        commentDto.setName(updatedName);

        Comment updatedComment = new Comment();
        updatedComment.setId(comment.getId());
        updatedComment.setName(updatedName);
        updatedComment.setEmail(comment.getEmail());
        updatedComment.setBody(comment.getBody());
        updatedComment.setPost(comment.getPost());

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(updatedComment);

        CommentDto updatedCommentDto = commentService.updateComment(1L, 1L, commentDto);

        Assertions.assertNotNull(updatedCommentDto);
        Assertions.assertEquals(updatedName, updatedCommentDto.getName());
        Assertions.assertEquals(commentDto.getEmail(), updatedCommentDto.getEmail());
        Assertions.assertEquals(commentDto.getBody(), updatedCommentDto.getBody());
    }

    @Test
    void testUpdateComment_ResourceNotFoundException() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testDeleteComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        doNothing().when(commentRepository).delete(comment);

        Assertions.assertDoesNotThrow(() -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_ResourceNotFoundException() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }
}
