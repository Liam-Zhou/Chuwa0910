package com.chuwa.redbook.service.impl.test;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourcesNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.impl.CommentServiceImpl;
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
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    public static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

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

    private CommentDto commentDTO;
    private Comment comment;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test for CommentServiceImpl");
    }

    @BeforeEach
    void setup() {
        logger.info("set up Post/Comment for each test");

        this.post = new Post();
        post.setContent("test123");
        post.setTitle("Test");
        post.setId(101L);

        modelMapper = new ModelMapper();
        this.postDTO = modelMapper.map(this.post,PostDTO.class);

        this.comment = new Comment();
        comment.setId(101L);
        comment.setPost(post);
        comment.setName("test");
        comment.setEmail("test@gmail.com");
        comment.setBody("test");
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setUpdateDateTime(LocalDateTime.now());
        this.commentDTO = modelMapper.map(this.comment,CommentDto.class);

        //this.post.get
    }

    @Test
    void createComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(this.comment);

        CommentDto response = commentService.createComment(this.post.getId(),commentDTO);
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
    void getCommentById() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(this.comment));

        CommentDto response = commentService.getCommentById(this.post.getId(),this.comment.getId());
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

        CommentDto response = commentService.updateComment(this.post.getId(),this.comment.getId(),this.commentDTO);
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