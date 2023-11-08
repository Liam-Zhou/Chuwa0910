package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostResponse;
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
        post = new Post(100L,"test 100L","test","test",null, LocalDateTime.now(),LocalDateTime.now());
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
        //Question.

        PostResponse response = postController.getAllPosts(1, 10, "title", "asc");

        // Perform assertions on the response
        assertNotNull(response);
    }

    @Test
    void testGetPostById() {
        Long id = 6L;
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
        postDTO.setDescription("new test");
        ResponseEntity<PostDTO> response = postController.updatePostById(6L,postDTO);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(postDTO.getDescription(), response.getBody().getDescription());
    }

    @Test
    void testDeletePostById() {

        postController.deletePostById(6L);
        assertThrows(ResourcesNotFoundException.class,()->postController.getPostById(6L));
    }
}