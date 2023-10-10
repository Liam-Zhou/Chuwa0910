package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.payload.PostDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Long id);

    AuthorDTO updateAuthor(AuthorDTO authorDTO, long id);

    void deleteAuthorDTOById(long id);
}
