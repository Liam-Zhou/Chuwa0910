package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.DAO.CommentRepository;
import com.chuwa.redbookblog.DAO.PostRepository;
import com.chuwa.redbookblog.Exception.BlogAPIException;
import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.entity.Comment;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.CommentDTO;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.CommentService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    public static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private PostDTO postDTO;

    @Spy
    private Post post;

    private CommentDTO commentDTO;
    private Comment comment;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test for CommentServiceImpl");
    }

    @BeforeEach
    void setup() {
        logger.info("set up Post/Comment for each test");

        this.post = new Post(100L,"test title","test description","test content",new HashSet<>(), LocalDateTime.now(),LocalDateTime.now());
        modelMapper = new ModelMapper();
        this.postDTO = modelMapper.map(this.post,PostDTO.class);

        this.comment = new Comment(101L,"test comment","test@gmail.com","test body",this.post,LocalDateTime.now(),LocalDateTime.now());
        this.commentDTO = modelMapper.map(this.comment,CommentDTO.class);

        this.post.getComments().add(this.comment);
    }

    @Test
    void createComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(this.comment);

        CommentDTO response = commentService.createComment(this.post.getId(),commentDTO);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getName(),commentDTO.getName());
    }

    @Test
    void createComment_Exception() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                        .thenThrow(new ResourcesNotFoundException("Post","id",1L));

        Assertions.assertThrows(ResourcesNotFoundException.class,()->commentService.createComment(1L,this.commentDTO));
    }

    @Test
    void getCommentsByPostId() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));

        List<CommentDTO> response = commentService.getCommentsByPostId(this.post.getId());
        Assertions.assertNotNull(response);
        CommentDTO commentResponse = response.get(0);
        Assertions.assertEquals(commentResponse.getName(),this.commentDTO.getName());
    }

    @Test
    void getCommentsByPostId_Exception() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post","id",1L));

        Assertions.assertThrows(ResourcesNotFoundException.class,()->commentService.getCommentsByPostId(1L));
    }

    @Test
    void getCommentById() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));

        CommentDTO response = commentService.getCommentById(this.post.getId(),this.comment.getId());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getName(),this.commentDTO.getName());
    }

    @Test
    void getCommentById_postException() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post","id",100L));

        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.getCommentById(this.post.getId(),this.comment.getId()));
    }

    @Test
    void getCommentById_commentException() {
        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.getCommentById(this.post.getId(),this.comment.getId()));
    }

    @Test
    void getCommentById_PostCommentException() {
        Post tmp = new Post();
        tmp.setId(1L);

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(tmp));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));



        Assertions.assertThrows(BlogAPIException.class,
                () -> commentService.getCommentById(100L,101L));
    }

    @Test
    void updateComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));

        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(this.comment);

        CommentDTO response = commentService.updateComment(this.post.getId(),this.comment.getId(),this.commentDTO);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getName(),this.commentDTO.getName());
    }

    @Test
    void updateComment_postException() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post","id",100L));

        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.updateComment(this.post.getId(),this.comment.getId(),this.commentDTO));
    }

    @Test
    void updateComment_commentException() {
        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.updateComment(this.post.getId(),this.comment.getId(),this.commentDTO));
    }

    @Test
    void updateComment_PostCommentException() {
        Post tmp = new Post();
        tmp.setId(1L);

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(tmp));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));

        Assertions.assertThrows(BlogAPIException.class,
                () -> commentService.updateComment(this.post.getId(),this.comment.getId(),this.commentDTO));
    }

    @Test
    void deleteComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));
        Mockito.doNothing().when(commentRepository).delete(ArgumentMatchers.any());

        commentService.deleteComment(this.post.getId(),this.comment.getId());

    }

    @Test
    void deleteComment_postException() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post","id",100L));

        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.deleteComment(this.post.getId(),this.comment.getId()));
    }
    @Test
    void deleteComment_commentException() {
        Assertions.assertThrows(ResourcesNotFoundException.class,
                () -> commentService.deleteComment(this.post.getId(),this.comment.getId()));
    }

    @Test
    void deleteComment_PostCommentException() {
        Post tmp = new Post();
        tmp.setId(1L);

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(tmp));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));

        Assertions.assertThrows(BlogAPIException.class,
                () -> commentService.deleteComment(this.post.getId(),this.comment.getId()));
    }


}