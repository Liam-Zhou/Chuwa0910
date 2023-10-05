package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {
    private PostService postService;

    private AuthorService authorService;

    public GraphQLController() {
    }

    public GraphQLController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
    }

    public GraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDTO postById(@Argument Long id){
        return postService.getPostDTOById(id);
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDTO postDTO = new PostDTO(title,description,content);
        return postService.createPost(postDTO);
    }


    @QueryMapping
    public AuthorDTO authorById(@Argument Long id){
        return authorService.getAuthorDTOById(id);
    }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String name, @Argument String dateOfBirth, @Argument String placeOfBirth,@Argument String nationality,@Argument String gender,@Argument String occupation,@Argument String numberOfWorks,@Argument String mostFamousWork){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(name);
        authorDTO.setDateOfBirth(dateOfBirth);
        authorDTO.setPlaceOfBirth(placeOfBirth);
        authorDTO.setNationality(nationality);
        authorDTO.setGender(gender);
        authorDTO.setOccupation(occupation);
        authorDTO.setNumberOfWorks(Integer.valueOf(numberOfWorks));
        authorDTO.setMostFamousWork(mostFamousWork);
        return authorService.createAuthor(authorDTO);
    }
}
