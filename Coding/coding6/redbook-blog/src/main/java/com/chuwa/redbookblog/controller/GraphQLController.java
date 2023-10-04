package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@Controller
public class GraphQLController {
    final private PostService postService;

    public GraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDTO postById(@Argument long id){
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String content, @Argument String description){
        PostDTO postDTO = new PostDTO(title, description, content);
        return postService.createPost(postDTO);
    }

}
