package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.entity.Author;
import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {

    private AuthorService authorService;
    public AuthorGraphQLController(AuthorService authorService) { this.authorService = authorService; }

    @QueryMapping
    public AuthorDTO authorById(@Argument Long id) { return authorService.getAuthorById(id); }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String name) {
        AuthorDTO authorDTO = new AuthorDTO(name);
        return authorService.createAuthor(authorDTO);
    }
}
