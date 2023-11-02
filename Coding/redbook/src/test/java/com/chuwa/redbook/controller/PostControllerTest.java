package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourcesNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController postController;

    private Post post;
    private PostDTO postDTO;

    private ModelMapper mapper;

    @BeforeEach
    public void setUp() {
        post = new Post();
        post.setId(Long.valueOf(214));
        post.setTitle("78134567654663");
        post.setDescription("78666675567666543");
        post.setContent("78546676767886766633");
        post.setCreateDateTime(LocalDateTime.now());
        post.setUpdateDateTime(LocalDateTime.now());
        mapper = new ModelMapper();
        postDTO = mapper.map(post,PostDTO.class);
    }

    @Test
    void testCreatePost() {
        ResponseEntity<PostDTO> response = postController.createPost(postDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(postDTO.getTitle(), response.getBody().getTitle());
    }


    @Test
    void testGetAllPosts() {
        PostResponse response = postController.getAllPosts(1, 10, "title", "asc");
        assertNotNull(response);
    }

    @Test
    void testGetPostById() {
        Long id = Long.valueOf(33);
        ResponseEntity<PostDTO> response = postController.getPostById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(postDTO.getTitle(), response.getBody().getTitle());
    }

    @Test
    void testGetPostById_NotFoundException() {
        Long id = 7L;
        assertThrows(ResourcesNotFoundException.class,()-> postController.getPostById(id));
    }

    @Test
    void testUpdatePostById() {
        postDTO.setDescription("test");
        ResponseEntity<PostDTO> response = postController.updatePostById(16,postDTO);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(postDTO.getDescription(), response.getBody().getDescription());
    }

    @Test
    void testDeletePostById() {
        postController.deletePostById(33);
        assertThrows(ResourcesNotFoundException.class,()->postController.getPostById(6L));
    }
}
