package com.hyc.redbookblog.service.impl;

import com.hyc.redbookblog.dao.AuthorRepository;
import com.hyc.redbookblog.entity.Author;
import com.hyc.redbookblog.exception.ResourceNotFoundException;
import com.hyc.redbookblog.payload.AuthorDTO;
import com.hyc.redbookblog.service.AuthorService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: hyc
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {this.authorRepository = authorRepository;}

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author authorToBeSaved = new Author();
        authorToBeSaved.setName(authorDTO.getName());
        authorToBeSaved.setGender(authorDTO.isGender());
        authorToBeSaved.setDescription(authorDTO.getDescription());

        Author savedAuthor = authorRepository.save(authorToBeSaved);
        return mapAuthorEntityToDTO(savedAuthor);
    }

    @Override
    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author authorToBeUpdate = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorToBeUpdate.setName(authorDTO.getName());
        authorToBeUpdate.setGender(authorDTO.isGender());
        authorToBeUpdate.setDescription(authorDTO.getDescription());

        Author updatedAuthor = authorRepository.save(authorToBeUpdate);
        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public String deleteAuthorById(Long id) {
        Author authorToBeDelete = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(authorToBeDelete);
        return "Successfully Deleted";
    }

    private AuthorDTO mapAuthorEntityToDTO(Author author) {
       AuthorDTO response = new AuthorDTO();

        response.setName(author.getName());
        response.setGender(author.isGender());
        response.setDescription(author.getDescription());

        return response;
    }
}
