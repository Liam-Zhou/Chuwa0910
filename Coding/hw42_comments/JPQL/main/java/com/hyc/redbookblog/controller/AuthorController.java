package com.hyc.redbookblog.controller;


import com.hyc.redbookblog.payload.AuthorDTO;
import com.hyc.redbookblog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @Description:
 * @Author: hyc
 */
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO response = authorService.createAuthor(authorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(name="id") long id) {
        AuthorDTO authorDTO = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthorById(@PathVariable(name="id") long id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO response = authorService.updateAuthor(authorDTO, id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable(name="id") long id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
