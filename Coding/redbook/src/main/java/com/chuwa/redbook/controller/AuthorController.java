package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
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
    public List<AuthorDTO> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(name="id") long id){
        AuthorDTO authorDTO = authorService.getAuthorDTOById(id);
        return new ResponseEntity<>(authorDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updatePostById(@PathVariable(name="id") long id,@RequestBody AuthorDTO authorDTO){
        AuthorDTO response = authorService.updateAuthor(authorDTO,id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

}
