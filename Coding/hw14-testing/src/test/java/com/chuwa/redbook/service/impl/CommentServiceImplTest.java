package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentServiceImplTest {

    @Autowired
    private PostService postService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreatePost() {
        PostDto postDto = new PostDto(); // Create a sample PostDto

        ResponseEntity<PostDto> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/posts", postDto, PostDto.class);

        assertEquals(201, responseEntity.getStatusCodeValue());
        // Add assertions for the response entity
    }

    @Test
    public void testGetPostById() {
        long postId = 1; // Provide an existing post ID

        ResponseEntity<PostDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/v1/posts/" + postId, PostDto.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        // Add assertions for the response entity
    }

    @Test
    public void testGetAllPosts() {
        // Provide query parameters for pagination and sorting as needed
        ResponseEntity<PostResponse> responseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/v1/posts", PostResponse.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        // Add assertions for the response entity
    }

    @Test
    public void testUpdatePostById() {
        long postId = 1; // Provide an existing post ID
        PostDto postDto = new PostDto(); // Create a sample PostDto for update

        restTemplate.put("http://localhost:" + port + "/api/v1/posts/" + postId, postDto);

        // Optionally, you can perform a GET request to verify the updated content
    }

    @Test
    public void testDeletePost() {
        long postId = 1; // Provide an existing post ID

        restTemplate.delete("http://localhost:" + port + "/api/v1/posts/" + postId);

        // Optionally, you can perform a GET request to verify the deletion
    }
}