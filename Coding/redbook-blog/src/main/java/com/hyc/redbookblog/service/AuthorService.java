package com.hyc.redbookblog.service;

import com.hyc.redbookblog.payload.AuthorDTO;

/**
 * @Description:
 * @Author: hyc
 */
public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    AuthorDTO getAuthorById(long id);

    AuthorDTO updateAuthor(AuthorDTO authorDTO, long id);
    String deleteAuthorById(Long id);
}
