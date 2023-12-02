package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);


    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    // use this modelMapper to replace the mapToDto, mapToEntity methods.
    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;


    /**
     * 定义两个fields
     */
    private CommentDto commentDto;
    private Comment comment;

    @BeforeAll
    static void beforeAll(){
        logger.info("Start test");
    }

    @BeforeEach
    void setUp(){
        logger.info("set up Comment comment for each test");

        this.comment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");
        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
    }


    @Test
    void createComment() {
        // Define test data and expectations
        CommentDto commentDto = new CommentDto("ke chen", "kechen@gmail.com", "this is a test");

        Comment comment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");
        Comment savedComment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");

        // Define Mockito expectations
        when(postRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Post()));
        when(commentRepository.save(Mockito.any(Comment.class))).thenReturn(savedComment);

        // Execute the method
        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        // Assertions
        assertNotNull(commentResponse);
        assertEquals("ke chen", commentResponse.getName());
        assertEquals("kechen@gmail.com", commentResponse.getEmail());
        assertEquals("this is a test", commentResponse.getBody());
    }

    @Test
    void getCommentsByPostId() {
        // Define test data and expectations
        Long postId = 1L;
        List<Comment> comments = Arrays.asList(
                new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test"),
                new Comment(2L, "Jack", "jack@gmail.com", "Another comment")
        );

        when(commentRepository.findByPostId(postId)).thenReturn(comments);

        // Execute the method
        List<CommentDto> commentDtoList = commentService.getCommentsByPostId(postId);

        // Assertions
        assertNotNull(commentDtoList);
        assertEquals(2, commentDtoList.size()); // Make assertions based on the expected comments
    }


    @Test
    void getCommentById() {
        // Define test data and expectations
        Long postId = 1L;
        Long commentId = 1L;

        // 创建一个虚拟的 Post 对象，并设置其相关属性
        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");
        comment.setPost(post);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post)); // 模拟返回一个有效的 Post
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        // Execute the method
        CommentDto commentResponse = commentService.getCommentById(postId, commentId);

        // Assertions
        assertNotNull(commentResponse);
        assertEquals("ke chen", commentResponse.getName());
        assertEquals("kechen@gmail.com", commentResponse.getEmail());
        assertEquals("this is a test", commentResponse.getBody());
    }


    @Test
    void updateComment() {
        // Define test data and expectations
        Long postId = 1L;
        Long commentId = 1L;

        // 创建一个虚拟的 Post 对象，并设置其相关属性
        Post post = new Post();
        post.setId(postId);

        CommentDto updatedCommentDto = new CommentDto("Updated Name", "updated@example.com", "Updated body");

        Comment comment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");
        comment.setPost(post);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));
        when(commentRepository.save(comment)).thenReturn(comment); // Mock the save operation

        // Execute the method
        CommentDto commentResponse = commentService.updateComment(postId, commentId, updatedCommentDto);

        // Assertions
        assertNotNull(commentResponse);
        assertEquals("Updated Name", commentResponse.getName());
        assertEquals("updated@example.com", commentResponse.getEmail());
        assertEquals("Updated body", commentResponse.getBody());
    }



    @Test
    void deleteComment() {
        // Define test data and expectations
        Long postId = 1L;
        Long commentId = 1L;

        // 创建一个虚拟的 Post 对象，并设置其相关属性
        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment(1L, "ke chen", "kechen@gmail.com", "this is a test");
        comment.setPost(post);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        // Execute the method
        commentService.deleteComment(postId, commentId);

        // Verify the delete method was called
        Mockito.verify(commentRepository, Mockito.times(1)).delete(comment);
    }
}