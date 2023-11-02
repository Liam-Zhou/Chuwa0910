package com.chuwa.redbook.integration;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PostTest extends AbstractContainerBaseTest{
    @Resource
    private MockMvc mockMvc;

    private PostDTO postDTO1;
    private PostDTO postDTO2;

    @Autowired
    private PostRepository postRepository;

    @Resource
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();
        postDTO1 = PostDTO.builder()
                .title("title-1")
                .content("content-1")
                .description("description-1")
                .build();
        postDTO2 = PostDTO.builder()
                .title("title-2")
                .content("content-2")
                .description("description-2")
                .build();
    }

    @Test
    public void testCreatePost() throws Exception{
        ResultActions response = mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO1)));

        response.andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is(postDTO1.getTitle())))
                .andExpect(jsonPath("$.content", is(postDTO1.getContent())))
                .andExpect(jsonPath("$.description", is(postDTO1.getDescription())));

    }

    @Test
    public void testCreatePost_badRequest() throws Exception{
        postDTO1.setTitle("123");  // do not meet requirements
        ResultActions response = mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO1)));

        response.andExpect(status().isBadRequest());
    }

    @Test
    public void testGetAllPosts() throws Exception{
        postRepository.save(modelMapper.map(postDTO1, Post.class));
        postRepository.save(modelMapper.map(postDTO2, Post.class));
        ResultActions response = mockMvc.perform(get("/api/v1/posts"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(6)))
                .andExpect(jsonPath("$.content.size()", is(2)));
    }

    @Test
    public void testPostById() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));

        ResultActions response = mockMvc.perform(get("/api/v1/posts/{id}", savedPost.getId()));

        response.andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(postDTO1.getTitle())))
                .andExpect(jsonPath("$.content", is(postDTO1.getContent())))
                .andExpect(jsonPath("$.description", is(postDTO1.getDescription())));
    }

    @Test
    public void testPostById_invalidId() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));

        ResultActions response = mockMvc.perform(get("/api/v1/posts/{id}", savedPost.getId() + 1));

        response.andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void testUpdatePost() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));
        ResultActions response = mockMvc.perform(put("/api/v1/posts/{id}", savedPost.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO2)));

        response.andDo(print()).andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id", is(savedPost.getId().intValue())))
                .andExpect(jsonPath("$.title", is(postDTO2.getTitle())))
                .andExpect(jsonPath("$.content", is(postDTO2.getContent())))
                .andExpect(jsonPath("$.description", is(postDTO2.getDescription())));
    }

    @Test
    public void testUpdatePost_invalidId() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));
        ResultActions response = mockMvc.perform(put("/api/v1/posts/{id}", savedPost.getId()+1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO2)));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void testUpdatePost_badRequest() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));
        postDTO2.setTitle("123"); // do not meet requirements
        ResultActions response = mockMvc.perform(put("/api/v1/posts/{id}", savedPost.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO2)));

        response.andExpect(status().isBadRequest());
    }

    @Test
    public void testDeletePost() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));
        ResultActions response = mockMvc.perform(delete("/api/v1/posts/{id}", savedPost.getId()));

        response.andExpect(status().isOk());
    }

    @Test
    public void testDeletePost_invalidID() throws Exception {
        Post savedPost = postRepository.save(modelMapper.map(postDTO1, Post.class));
        ResultActions response = mockMvc.perform(delete("/api/v1/posts/{id}", savedPost.getId()+1));

        response.andExpect(status().isNotFound());
    }

}
