package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.CommentService;
import com.chuwa.redbook.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class PostControllerTest {
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private CommentService commentService;


    @Resource
    private ObjectMapper objectMapper;

    private PostDTO postDTO;

    @BeforeEach
    void setup(){
        postDTO = PostDTO.builder()
                .title("xiao ruishi")
                .content("wanqu")
                .description("wanqu xiao ruishi")
                .build();
    }

    @Test
    void createPost() throws Exception {
        Mockito.when(postService.createPost(ArgumentMatchers.any(PostDTO.class)))
                .thenReturn(postDTO);

        ResultActions res = mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO)));

        res.andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.title", is(postDTO.getTitle())))
            .andExpect(jsonPath("$.description", is(postDTO.getDescription())))
            .andExpect(jsonPath("$.content", is(postDTO.getContent())));
    }

    @Test
    void getAllPosts() throws Exception {
        List<PostDTO> postDTOs = new ArrayList<>();
        postDTOs.add(postDTO);
        postDTOs.add(PostDTO.builder()
                .title("xiao ruishi 2")
                .content("wanqu 2")
                .description("wanqu xiao ruishi 2")
                .build());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOs);

        Mockito.when(postService.getAllPosts(ArgumentMatchers.anyInt(),
                                            ArgumentMatchers.anyInt(),
                                            ArgumentMatchers.anyString(),
                                            ArgumentMatchers.anyString()))
                .thenReturn(postResponse);

        ResultActions response = mockMvc.perform(get("/api/v1/posts"));
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(6)))
                .andExpect(jsonPath("$.content.size()", is(postDTOs.size())));
    }

    @Test
    void getPostById() throws Exception {
        Mockito.when(postService.getPostById(ArgumentMatchers.anyLong()))
                .thenReturn(postDTO);

        ResultActions response = mockMvc.perform(get("/api/v1/posts/{id}", 1L));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.title", is(postDTO.getTitle())))
                .andExpect(jsonPath("$.description", is(postDTO.getDescription())))
                .andExpect(jsonPath("$.content", is(postDTO.getContent())));
    }

    @Test
    void getPostById_NotFound() throws Exception {
        Mockito.when(postService.getPostById(ArgumentMatchers.anyLong())).thenThrow(new ResourcesNotFoundException("Post", "id", 1L));

        ResultActions response = mockMvc.perform(get("/api/v1/posts/{id}", 1L));
        response.andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(jsonPath("$.message", is("Post not found with id : 1")));
    }

    @Test
    void updatePostById() throws Exception {
        PostDTO postDTO2 = PostDTO.builder()
                .title("xiao ruishi 2")
                .content("wanqu 2")
                .description("wanqu xiao ruishi 2")
                .build();
        Mockito.when(postService.updatePost(ArgumentMatchers.any(PostDTO.class), ArgumentMatchers.anyLong()))
                .thenReturn(postDTO2);

        ResultActions res = mockMvc.perform(put("/api/v1/posts/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDTO)));

        res.andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.title", is(postDTO2.getTitle())))
                .andExpect(jsonPath("$.description", is(postDTO2.getDescription())))
                .andExpect(jsonPath("$.content", is(postDTO2.getContent())));
    }

    @Test
    void deletePostById() throws Exception {
        Mockito.doNothing().when(postService).deletePostById(1L);

        ResultActions response = mockMvc.perform(delete("/api/v1/posts/{id}", 1L));

        response.andExpect(status().isOk());
    }
}