package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {

    private PostService postService;

    public GraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping //GET Request
    public PostDTO postById(@Argument Long id){
        return postService.getPostById(id);
    }

    @MutationMapping  //POST Request
    public PostDTO createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDTO postDTO = new PostDTO(title,description,content);

        return postService.createPost(postDTO);
    }
}
