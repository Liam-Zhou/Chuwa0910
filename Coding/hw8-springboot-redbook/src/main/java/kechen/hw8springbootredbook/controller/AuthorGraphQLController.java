package kechen.hw8springbootredbook.controller;

import kechen.hw8springbootredbook.payload.AuthorDto;
import kechen.hw8springbootredbook.payload.PostDto;
import kechen.hw8springbootredbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {
    private final AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public AuthorDto getAuthorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name){
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName(name);

        return authorService.createAuthor(authorDto);
    }
}
