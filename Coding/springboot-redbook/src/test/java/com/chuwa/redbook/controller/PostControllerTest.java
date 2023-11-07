package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
public class PostControllerTest {

    //actually we do not mock service generally in the integration test
    //but anyway, junit is for the unit test, so maybe we can kind of mix them together
    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;


    private MockMvc mockMvc;

    private PostDto postDto;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
        postDto = new PostDto(1L, "title", "content", "");
    }

    @Test
    public void testCreatePost() throws Exception {

        String json = new ObjectMapper().writeValueAsString(postDto);
        when(postService.createPost(ArgumentMatchers.any())).thenReturn(postDto);
        mockMvc.perform(post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
        verify(postService).createPost(postDto);
    }


    @Test
    public void testGetAllPosts() throws Exception {
        when(postService.getAllPost()).thenReturn(List.of(postDto));
        mockMvc.perform(get("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
        verify(postService).getAllPost();
    }

    @Test
    public void testGetPostById() throws Exception {
        when(postService.getPostById(1L)).thenReturn(postDto);
        mockMvc.perform(get("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
        verify(postService).getPostById(1L);
    }

    @Test
    public void testUpdatePostById() throws Exception {
        when(postService.updatePost(postDto, 1L)).thenReturn(postDto);
        mockMvc.perform(put("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
        verify(postService).updatePost(postDto, 1L);
    }

    @Test
    public void testDeletePost() throws Exception {
        doNothing().when(postService).deletePostById(1L);
        mockMvc.perform(delete("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        verify(postService).deletePostById(1L);
    }

}
