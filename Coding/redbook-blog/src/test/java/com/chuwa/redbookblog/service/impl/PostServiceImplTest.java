package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.DAO.PostRepository;
import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostResponse;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    public static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    private PostDTO postDTO;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test for PostServiceImplTest");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(100L,"test title","test description","test content",new HashSet<>(),LocalDateTime.now(),LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.postDTO = modelMapper.map(this.post,PostDTO.class);
    }

    @Test
    void createPost() {
        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(this.post);

        PostDTO postResponse = postService.createPost(postDTO);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(),postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(),postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(),postResponse.getContent());
    }

    @Test
    void getAllPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Mockito.when(postRepositoryMock.findAll())
                .thenReturn(posts);

        List<PostDTO> postDTOs = postService.getAllPosts();

        Assertions.assertNotNull(postDTOs);
        Assertions.assertEquals(1,postDTOs.size());
        PostDTO postResponse = postDTOs.get(0);
        Assertions.assertEquals(postDTO.getTitle(),postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(),postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(),postResponse.getContent());
    }

    @Test
    void getPostById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
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
    void testGetPostById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post","id",1L));

        Assertions.assertThrows(ResourcesNotFoundException.class, ()->postService.getPostById(233L));
    }

    @Test
    void updatePost() {
        String description = "UPDATED - " + post.getDescription();
        postDTO.setDescription(description);

        // deep copy
        Post updatedPost = new Post();
        updatedPost.setId(post.getId());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setDescription(description);
        updatedPost.setContent(post.getContent());

        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(updatedPost);

        // execute
        PostDTO postResponse = postService.updatePost(postDTO, 1L);

        // assertions
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }
    @Test
    public void testUpdatePost_ResourceNotFoundException() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourcesNotFoundException.class, () -> postService.updatePost(postDTO,1L));
    }

    @Test
    public void testDeletePostById() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        // postRepositoryMock.delete() is a void method
        Mockito.doNothing().when(postRepositoryMock).delete(ArgumentMatchers.any(Post.class));

        // execute
        postService.deletePostById(1L);

        // verify
        // 验证 postRepositoryMock.delete() 被执行过一次
        Mockito.verify(postRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Post.class));
    }

    @Test
    public void testDeletePostById_ResourceNotFoundException() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourcesNotFoundException.class, () -> postService.deletePostById(1L));
    }


    @Test
    public void testGetAllPost_Pageable() {
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.ASC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts;
        pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pagePosts);

        PostResponse postResponse = postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(pageNo, postResponse.getPageNo());
        Assertions.assertEquals(pageSize, postResponse.getPageSize());
        Assertions.assertEquals(totalElements, postResponse.getTotalElements());
        Assertions.assertEquals(totalPages, postResponse.getTotalPages());
        Assertions.assertEquals(isLast, postResponse.isLast());

        List<PostDTO> content = postResponse.getContent();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(posts.size(), content.size());
        PostDTO dto = content.get(0);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(postDTO.getTitle(), dto.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), dto.getDescription());
        Assertions.assertEquals(postDTO.getContent(), dto.getContent());

    }
}