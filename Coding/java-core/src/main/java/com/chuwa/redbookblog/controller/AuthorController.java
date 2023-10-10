package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO){
        AuthorDTO response = authorService.createAuthor(authorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllPosts(){
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AuthorDTO getPostById(@PathVariable(name="id") long id){
        AuthorDTO authorDTO = authorService.getAuthorById(id);

        return authorDTO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthorById(@PathVariable(name="id") long id, @RequestBody AuthorDTO authorDTO){
        AuthorDTO response = authorService.updateAuthor(authorDTO,id);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable(name="id") long id){
        authorService.deleteAuthorDTOById(id);

        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
