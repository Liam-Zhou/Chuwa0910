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
    public PostDTO postById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public AuthorDTO postAuthorById(@Argument Long id) {return authorService.getAuthorById(id);}

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String discription,@Argument String content) {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setDescription(discription);
        postDTO.setContent(content);

        return postService.createPost(postDTO);
    }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String name, @Argument String password) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(name);
        authorDTO.setPassword(password);

        return authorService.createAuthor(authorDTO);
    }
}
