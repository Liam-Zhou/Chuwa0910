package com.chuwa.redbookblog.service;


import com.chuwa.redbookblog.payload.AuthorDTO;

import java.util.List;

public interface AuthorService {
    //CRUD -> create, get, update, delete
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);
    AuthorDTO updateAuthorById(AuthorDTO authorDTO, Long id);
    void deleteAuthorById(Long id);
}
