package com.hyc.redbookblog.controller;

import com.hyc.redbookblog.payload.PostDTO;
import com.hyc.redbookblog.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author: hyc
 */
@Controller
public class GraphQLController {
    // path is http://localhost:8080/graphiql?path=/graphql
    private PostService postService;

    public GraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDTO postById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String description, String content) {
        PostDTO postDTO = new PostDTO(title, description, content);
        return postService.createPost(postDTO);
    }
}
