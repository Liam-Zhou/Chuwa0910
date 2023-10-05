package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
@Controller
public class GraphQLController {
    private PostService postService;
    private AuthorService authorService;
    public GraphQLController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
    }

    @QueryMapping //GET Request
    public PostDto postById(@Argument Long id){
        return postService.getPostById(id);
    }

    @QueryMapping
    public AuthorDto authorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto(null, title,description,content);
        return postService.createPost(postDto);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String email){
        AuthorDto authorDto = new AuthorDto(null, email);
        return authorService.createAuthor(authorDto);
    }

}
