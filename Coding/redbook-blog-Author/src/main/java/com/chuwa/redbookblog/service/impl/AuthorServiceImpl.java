package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.ResourcesNotFoundException;
import com.chuwa.redbookblog.dao.AuthorRepository;
import com.chuwa.redbookblog.entity.Author;
import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) { this.authorRepository = authorRepository;}

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) { //create author to db with DTO requested
        Author authorToBeSaved = new Author();
        authorToBeSaved.setId(authorDTO.getId());
        authorToBeSaved.setName(authorDTO.getName());
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
    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow( () -> new ResourcesNotFoundException("Author", "id", id));
        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author authorToBeUpdated = authorRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Author", "id", id));
        authorToBeUpdated.setId(authorDTO.getId());
        authorToBeUpdated.setName(authorDTO.getName());
        Author updatedAuthor = authorRepository.save(authorToBeUpdated);
        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author authorToBeDeleted = authorRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Author", "id", id));
        authorRepository.deleteById(id);
    }

    private AuthorDTO mapAuthorEntityToDTO(Author author) {
        AuthorDTO response = new AuthorDTO();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }
}
