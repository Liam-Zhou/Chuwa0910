package com.chuwa.redbook.controller;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.chuwa.redbook.service.PostService;
@Controller
public class GraphQLController {
    private PostService postService;
    private AuthorService authorService;

    public GraphQLController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
    }

    @QueryMapping
    public PostDTO getPostById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String description, @Argument String content) {
        return postService.createPost(new PostDTO(title, description, content));
    }

    @QueryMapping
    public AuthorDTO getAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String firstName, @Argument String lastName, @Argument String sex){
        return authorService.createAuthor(new AuthorDTO(firstName, lastName, sex));
    }
}