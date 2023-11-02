package com.chuwa.redbook.service.implementation;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import org.aspectj.lang.annotation.Before;
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
class PostServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    private PostDTO postDTO;
    private Post post;

    @BeforeAll
    public static void beforeAll() {logger.info("START test");}

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
//        ModelMapper modelMapper = new ModelMapper();
        this.postDTO = modelMapper.map(this.post, PostDTO.class);
    }

    @Test
    public void testCreatPost() {
        Mockito.when(postRepository.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(post);

        PostDTO postResponse = postService.createPost(postDTO);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetAllPost() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Mockito.when(postRepository.findAll())
                .thenReturn(posts);

        List<PostDTO> postDTOs = postService.getAllPosts();

        Assertions.assertNotNull(postDTOs);
        Assertions.assertEquals(1, postDTOs.size());
        PostDTO postResponse = postDTOs.get(0);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetPostById() {
        // define the behaviors
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        // execute
        PostDTO postResponse = postService.getPostById(1L);

        // assertions
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetPostById_ResourceNotFoundException() {
        // define the behaviors
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourcesNotFoundException.class, () -> postService.getPostById(1L));
    }

    @Test
    public void testUpdatePost() {
        String description = "UPDATED - " + post.getDescription();
        postDTO.setDescription(description);

        Post updatedPost = new Post();
        updatedPost.setId(post.getId());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setDescription(description);
        updatedPost.setContent(post.getContent());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(postRepository.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(updatedPost);

        PostDTO postResponse = postService.updatePost(postDTO, 1L);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }

    @Test
    public void testUpdatePost_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourcesNotFoundException.class, () -> postService.updatePost(postDTO,1L));
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.doNothing().when(postRepository).deleteById(ArgumentMatchers.anyLong());

        postService.deletePostById(1L);

        Mockito.verify(postRepository, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    public void testDeletePostById_ResourceNotFoundException() {
        // define the behaviors
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourcesNotFoundException.class, () -> postService.deletePostById(1L));
    }

}