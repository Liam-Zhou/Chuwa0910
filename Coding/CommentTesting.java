package com.chuwa.redbook.service.impl;
import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.dao.security.UserRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.entity.security.User;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.payload.Comment.CommentDto;
import com.chuwa.redbook.payload.Comment.CreateCommentDto;
import com.chuwa.redbook.payload.User.UserAbstractDto;
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

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CommentTesting {
    private static final Logger logger = LoggerFactory.getLogger(CommentTesting.class);

    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private CommentServiceImpl commentService;

    private  User user;

    private UserAbstractDto userAbstractDto;

    private  Post post;

    private CreateCommentDto createCommentDto;

    private Comment comment;

    private CommentDto commentDto;

    private Principal principal;

    @BeforeAll
    static void beforeAll() {logger.info("test start");}

    @BeforeEach
    void setup(){
        logger.info("setting up for each test");
        ModelMapper modelMapper = new ModelMapper();

        this.user = new User(1L, "test", "test", "test@gmail.com", "test");
        this.userAbstractDto = modelMapper.map(this.user, UserAbstractDto.class);
        this.principal = new Principal(){
            @Override
            public String getName(){return "test@gmail.com";}
        };
        this.post = new Post(1L, "test title", "test description", "test content",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L, "test comment", this.user, this.post);
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.createCommentDto = modelMapper.map(this.comment, CreateCommentDto.class);
    }

    @Test
    void createComment(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(userRepositoryMock.findByEmail(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(user));

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CreateCommentDto commentResponse = commentService.createComment(1L, createCommentDto, principal);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(user, comment.getUser());
        Assertions.assertEquals(post, comment.getPost());
        Assertions.assertEquals(createCommentDto.getBody(),commentResponse.getBody());
    }

    @Test
    void getCommentsByPostId(){
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        List<CommentDto> commentResponse = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(1, commentResponse.size());
        CommentDto specific = commentResponse.get(0);
        Assertions.assertEquals(commentDto.getBody(), specific.getBody());
        Assertions.assertEquals(1L, commentDto.getUser().getId());
    }

    @Test
    void getCommentById(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(),commentResponse.getBody());
        Assertions.assertEquals(1L, commentResponse.getUser().getId());
    }

    @Test
    void updateComment(){
        Comment updatedComment = new Comment();
        String body = "UPDATED - " + comment.getBody();
        createCommentDto.setBody(body);

        updatedComment.setId(comment.getId());
        updatedComment.setUser(comment.getUser());
        updatedComment.setBody(body);
        updatedComment.setPost(comment.getPost());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(userRepositoryMock.findByCommentsId(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(user));

        Exception exception = assertThrows(BlogAPIException.class, () -> {
            commentService.updateComment(1L, 1L, createCommentDto, principal);
        });

        Assertions.assertEquals("No access to others' comments", exception.getMessage());
    }

    @Test
    void deleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(userRepositoryMock.findByCommentsId(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(user));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 1L, principal);


        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }
}
