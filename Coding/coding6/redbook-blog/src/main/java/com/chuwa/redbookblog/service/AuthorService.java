package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.payload.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);
    AuthorDTO updateAuthor(AuthorDTO authorDTO, long id);
    String deleteAuthorById(long id);

}