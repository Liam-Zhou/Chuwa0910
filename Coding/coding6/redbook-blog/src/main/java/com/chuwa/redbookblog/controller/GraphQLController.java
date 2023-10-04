package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.AuthorService;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {
    private PostService postService;
    private AuthorService authorService;

    public GraphQLController(PostService postService, AuthorService authorService) {

        this.postService = postService;
        this.authorService = authorService;

    }

    @QueryMapping
    public PostDTO postByID(@Argument Long id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public AuthorDTO authorByID(@Argument Long id) { return authorService.getAuthorById(id); }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String description, @Argument String content) {
        PostDTO postDTO = new PostDTO(title, description, content);

        return postService.createPost(postDTO);
    }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String name, @Argument String sex) {
        AuthorDTO authorDTO = new AuthorDTO(name, sex);

        return authorService.createAuthor(authorDTO);
    }
}
