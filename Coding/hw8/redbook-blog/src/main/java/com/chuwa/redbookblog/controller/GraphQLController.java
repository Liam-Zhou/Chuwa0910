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

    private AuthorService authorService;
    private PostService postService;

    public GraphQLController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
    }
    @QueryMapping
    public AuthorDTO getAuthorById(@Argument Long id){return authorService.getAuthorById(id);}
    @QueryMapping// get request
    public PostDTO getPostById(@Argument Long id){
        return postService.getPostById(id);
    }
    @MutationMapping// post request
    public PostDTO createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDTO postDTO = new PostDTO(title, description, content);
        return postService.createPost(postDTO);
    }
    @MutationMapping
    public AuthorDTO createAuthor(@Argument String firstName, @Argument String lastName, @Argument int age){
        AuthorDTO authorDTO = new AuthorDTO(firstName,lastName,age);
        return authorService.createAuthor(authorDTO);
    }

}
