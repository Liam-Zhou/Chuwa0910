package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setTitle("Test Title");
        postDto.setDescription("Test Description");
        postDto.setContent("Test Content");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getPostById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPosts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updatePostById() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setTitle("Updated Title");
        postDto.setDescription("Updated Description");
        postDto.setContent("Updated Content");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deletePost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/posts/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}