package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(long id);
    AuthorDTO updateAuthor(AuthorDTO authorDTO, long id);
    void deleteAuthorById(long id);
}
