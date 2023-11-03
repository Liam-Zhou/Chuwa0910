package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import net.bytebuddy.asm.Advice;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository commentRepositoryMock;
    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PostRepository postRepositoryMock;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Post testPost;
    private CommentDto testCommentDto;

    private Comment testComment;

    @BeforeAll
    static void beforeAll(){
        logger.info("Start testing CommentServiceImpl");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Comment for each test");
        this.testComment = new Comment(1L, "Xiao Yang", "shawyang@gmail.com", "test comment body");
        this.testPost = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        testComment.setPost(testPost);
        this.testCommentDto = modelMapper.map(this.testComment, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        // define behaviors
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(this.testComment);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(this.testPost));

        //execute
        CommentDto response = commentService.createComment(1L, testCommentDto);

        // assertions
        Assertions.assertNotNull(response);
        Assertions.assertEquals(testCommentDto.getName(), response.getName());
        Assertions.assertEquals(testCommentDto.getEmail(), response.getEmail());
        Assertions.assertEquals(testCommentDto.getBody(), response.getBody());

        //mockito verify
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).save(ArgumentMatchers.any(Comment.class));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(testComment);

        //define behaviors
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong())).thenReturn(comments);

        //execute
        List<CommentDto> response = commentService.getCommentsByPostId(1L);

        //assertions
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());

        Assertions.assertEquals(testCommentDto.getName(),response.get(0).getName());
        Assertions.assertEquals(testCommentDto.getEmail(),response.get(0).getEmail());
        Assertions.assertEquals(testCommentDto.getBody(),response.get(0).getBody());

        Mockito.verify(commentRepositoryMock, Mockito.times( 1)).findByPostId(1L);
    }

//    @Test
//    void testGetCommentsByPostId_exception() {
//        // define behaviors
//        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
//
//        //execute
//        Assertions.assertThrows(ResourceNotFoundException.class, ()-> commentService.getCommentsByPostId(1L));
//    }

    @Test
    void testGetCommentById() {
        // define behavior
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testPost));

        //execute
        CommentDto response = commentService.getCommentById(1L, 1L);

        //Assertions
        Assertions.assertNotNull(response);

        Assertions.assertEquals(testCommentDto.getName(),response.getName());
        Assertions.assertEquals(testCommentDto.getEmail(),response.getEmail());
        Assertions.assertEquals(testCommentDto.getBody(),response.getBody());

        Mockito.verify(commentRepositoryMock, Mockito.times( 1)).findById(1L);
        Mockito.verify(postRepositoryMock, Mockito.times( 1)).findById(1L);
    }

    @Test
    void testGetCommentById_exception(){
        Post post = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        //define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));

        //execute
        Assertions.assertThrows(BlogAPIException.class, ()-> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testUpdateComment() {
        String updatedBody = "UPDATED - " + testComment.getBody();
        testComment.setBody(updatedBody);

        Comment updatedComment = new Comment(testComment.getId(), testComment.getName(), testComment.getEmail(), testComment.getBody());
        updatedComment.setPost(testComment.getPost());

        //define behaviors
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testPost));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(updatedComment);

        //execute
        CommentDto response = commentService.updateComment(1L, 1L, testCommentDto);

        // assertions
        Assertions.assertNotNull(response);
        Assertions.assertEquals(updatedComment.getBody(), response.getBody());
        Assertions.assertEquals(updatedComment.getName(), response.getName());
        Assertions.assertEquals(updatedComment.getEmail(), response.getEmail());
    }

    @Test
    void testUpdateComment_exception(){
        Post post = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        //define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));

        //execute
        Assertions.assertThrows(BlogAPIException.class, ()-> commentService.updateComment(1L, 1L, testCommentDto));
    }

    @Test
    void testDeleteComment() {
        // define behaviors
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testPost));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        //execute
        commentService.deleteComment(1L, 1L);

        //verify
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    void testDeleteComment_exception(){
        Post post = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        //define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(testComment));

        //execute
        Assertions.assertThrows(BlogAPIException.class, ()-> commentService.deleteComment(1L, 1L));
    }
}