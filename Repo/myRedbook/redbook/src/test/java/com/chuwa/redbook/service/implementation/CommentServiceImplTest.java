package com.chuwa.redbook.service.implementation;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exceptions.BlogAPIException;
import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PostDTO;
import org.junit.jupiter.api.Assertions;
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
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PostRepository postRepository;
//    @Spy
//    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private PostDTO postDTO;
    private Post post;

    private CommentDTO commentDTO;
    private Comment comment;

    @BeforeEach
    void setUp(){
        logger.info("set up Post for each test");
        ModelMapper modelMapper = new ModelMapper();
        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        this.postDTO = modelMapper.map(this.post, PostDTO.class);
        this.comment = new Comment(1L, "John", "john@gmail.com", "great post.");
        this.commentDTO = modelMapper.map(this.comment, CommentDTO.class);
    }

    @Test
    void createComment() {
        logger.info("start test createComment");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDTO response = commentService.createComment(1L, commentDTO);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(commentDTO.getBody(), response.getBody());
        Assertions.assertEquals(commentDTO.getName(), response.getName());
        Assertions.assertEquals(commentDTO.getEmail(), response.getEmail());

        logger.info("end test createComment");
    }

    @Test
    void getCommentsByPostId() {
        logger.info("start test getCommentsByPostId");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        Mockito.when(commentRepository.findByPostId(ArgumentMatchers.anyLong())).thenReturn(comments);

        List<CommentDTO> response = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        CommentDTO resDTO = response.get(0);
        Assertions.assertEquals(commentDTO.getBody(), resDTO.getBody());
        Assertions.assertEquals(commentDTO.getName(), resDTO.getName());
        Assertions.assertEquals(commentDTO.getEmail(), resDTO.getEmail());

        logger.info("end test getCommentsByPostId");
    }

    @Test
    void getCommentById() {
        logger.info("start test getCommentById");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        comment.setPost(post);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        CommentDTO response = commentService.getCommentById(1L, 1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(commentDTO.getBody(), response.getBody());
        Assertions.assertEquals(commentDTO.getName(), response.getName());
        Assertions.assertEquals(commentDTO.getEmail(), response.getEmail());

        logger.info("end test getCommentById");
    }

    @Test
    void getCommentById_BlogAPIException() {
        logger.info("start test getCommentById_BlogAPIException");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Post post2 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        comment.setPost(post2);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));

        logger.info("end test getCommentById_BlogAPIException");
    }

    @Test
    void updateComment() {
        logger.info("start test updateComment");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        comment.setPost(post);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        String name = "UPDATED - " + comment.getName();
        commentDTO.setName(name);
        String email = "UPDATED - " + comment.getEmail();
        commentDTO.setEmail(email);
        String body = "UPDATED - " + comment.getBody();
        commentDTO.setBody(body);

        Comment updatedComment = new Comment();
        updatedComment.setId(comment.getId());
        updatedComment.setName(name);
        updatedComment.setEmail(email);
        updatedComment.setBody(body);
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class))).thenReturn(updatedComment);

        CommentDTO response = commentService.updateComment(1L, 1L, commentDTO);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(commentDTO.getBody(), response.getBody());
        Assertions.assertEquals(commentDTO.getName(), response.getName());
        Assertions.assertEquals(commentDTO.getEmail(), response.getEmail());

        logger.info("end test updateComment");
    }

    @Test
    void updateComment_BlogAPIException() {
        logger.info("start test updateComment_BlogAPIException");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Post post2 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        comment.setPost(post2);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDTO));

        logger.info("end test updateComment_BlogAPIException");
    }

    @Test
    void deleteComment() {
        logger.info("start test deleteComment");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        comment.setPost(post);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.doNothing().when(commentRepository).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 1L);

        Mockito.verify(commentRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));

        logger.info("end test deleteComment");
    }

    @Test
    void deleteComment_BlogAPIException() {
        logger.info("start test deleteComment_BlogAPIException");

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Post post2 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        comment.setPost(post2);
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));

        logger.info("end test deleteComment_BlogAPIException");
    }
}