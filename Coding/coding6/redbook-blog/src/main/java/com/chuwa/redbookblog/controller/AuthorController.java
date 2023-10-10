package com.chuwa.redbookblog.controller;

import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) { this.authorService = authorService; }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO response = authorService.createAuthor(authorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> reslist = authorService.getAllAuthors();
        return new ResponseEntity<>(reslist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(name = "id") Long id) {
        AuthorDTO authorDTO = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthorById(@PathVariable(name = "id") Long id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO response = authorService.updateAuthor(authorDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteAuthorById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(authorService.deleteAuthorById(id), HttpStatus.OK);
    }
}
