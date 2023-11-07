package com.chuwa.redbook.service;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.impl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PostServiceTest {
    //so the exercise is for the comment service
    //but basically the way to test the service is similar

    @Mock
    private PostRepository postRepository;


    @InjectMocks
    private PostServiceImpl postService;

    private PostDto postDto;
    private Post savedPost;

    @BeforeEach
    public void setUp() {
        postDto = new PostDto(1L, "title", "content", "");
        savedPost = new ModelMapper().map(postDto, Post.class);
    }

    @Test
    public void testCreatePost() {
        Mockito.when(postRepository.save(ArgumentMatchers.any(Post.class))).thenReturn(savedPost).thenReturn(savedPost);
        postService.createPost(postDto);
        Mockito.verify(postRepository, Mockito.times(1)).save(ArgumentMatchers.any(Post.class));
    }

    @Test
    public void testGetPostById() {
        Mockito.when(postRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(savedPost));
        postService.getPostById(1L);
        Mockito.verify(postRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void testUpdatePost() {
        Mockito.when(postRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(savedPost)).thenReturn(java.util.Optional.ofNullable(savedPost));
        Mockito.when(postRepository.save(savedPost)).thenReturn(savedPost);
        postService.updatePost(postDto, 1L);
        Mockito.verify(postRepository, Mockito.times(1)).save(savedPost);
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(savedPost));
        postService.deletePostById(1L);
        Mockito.verify(postRepository, Mockito.times(1)).delete(savedPost);
    }

}
