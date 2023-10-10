package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.ResourcesNotFoundException;
import com.chuwa.redbookblog.dao.AuthorRepository;
import com.chuwa.redbookblog.entity.Author;
import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {

        Author authorToBeSaved = new Author();

        authorToBeSaved.setName(authorDTO.getName());
        authorToBeSaved.setSex(authorDTO.getSex());

        Author savedAuthor = this.authorRepository.save(authorToBeSaved);

        return mapAuthorEntityToDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {

        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> response = authors.stream().map(author -> mapAuthorEntityToDTO(author)).collect(Collectors.toList());

        return response;
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author authorToBeUpdated = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));

        authorToBeUpdated.setName(authorDTO.getName());
        authorToBeUpdated.setSex(authorDTO.getSex());

        Author updatedAuthor = authorRepository.save(authorToBeUpdated);

        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public String deleteAuthorById(long id) {
        Author authorToBeDeleted = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        authorRepository.delete(authorToBeDeleted);

        return "Successfully deleted";
    }

    private AuthorDTO mapAuthorEntityToDTO(Author author) {
        AuthorDTO response = new AuthorDTO();
        response.setName(author.getName());
        response.setSex(author.getSex());
        return response;
    }
}
