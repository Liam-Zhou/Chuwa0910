package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostService postService;

    @Test
    void createPost() {
        // Create a sample PostDto
        PostDto postDto = new PostDto();
        // Set properties of postDto

        // Send a POST request to create a post
        ResponseEntity<PostDto> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/posts",
                postDto,
                PostDto.class);

        // Verify the response and status code
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void getPostById() {
        // Create a sample post using postService and get its ID
        long postId = postService.createPost(new PostDto()).getId();

        // Send a GET request to retrieve the post by ID
        ResponseEntity<PostDto> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/v1/posts/" + postId,
                PostDto.class);

        // Verify the response and status code
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void getAllPosts() {
        // Send a GET request to retrieve all posts
        ResponseEntity<PostResponse> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/v1/posts",
                PostResponse.class);

        // Verify the response and status code
        assertEquals(200, response.getStatusCodeValue());

        // You can add more assertions based on your requirements
    }

    @Test
    void updatePostById() {
        // Create a sample post using postService and get its ID
        long postId = postService.createPost(new PostDto()).getId();

        // Create a sample PostDto for the update
        PostDto updatedPostDto = new PostDto();
        // Set properties of updatedPostDto

        // Send a PUT request to update the post by ID
        ResponseEntity<PostDto> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/posts/" + postId,
                updatedPostDto,
                PostDto.class);

        // Verify the response and status code
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void deletePost() {
        // Create a sample post using postService and get its ID
        long postId = postService.createPost(new PostDto()).getId();

        // Send a DELETE request to delete the post by ID
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/v1/posts/" + postId,
                String.class);

        // Verify the response and status code
        assertEquals(200, response.getStatusCodeValue());
    }
}