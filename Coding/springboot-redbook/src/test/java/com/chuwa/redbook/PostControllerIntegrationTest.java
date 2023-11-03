package com.chuwa.redbook;

import com.chuwa.redbook.payload.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePost() throws Exception {
        // Prepare a PostDto object
        PostDto postDto = new PostDto();
        postDto.setTitle("Test Title");
        postDto.setContent("Test Content");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                        .content(objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("title").value("Test Title")); // Adjust as per response
    }

    @Test
    public void testGetPostById() throws Exception {
        long postId = 1L; // Assuming post with ID 1 exists
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/" + postId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(postId)); // Adjust as per response
    }

    // Write tests for getAllPosts, updatePostById, deletePost, covering different scenarios.
    // For instance, testing edge cases, wrong input, unauthorized access, etc.
}

