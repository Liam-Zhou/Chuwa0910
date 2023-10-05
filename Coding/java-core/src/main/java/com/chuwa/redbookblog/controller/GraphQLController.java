package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.AuthorService;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraphQLController {

    private PostService postService;
    private AuthorService authorService;

    public GraphQLController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
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


    @QueryMapping
    public AuthorDTO authorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDTO createAuthor(@Argument String name, @Argument String phone, @Argument String address){
        AuthorDTO authorDTO = new AuthorDTO(name,phone,address);

        return authorService.createAuthor(authorDTO);
    }
}
