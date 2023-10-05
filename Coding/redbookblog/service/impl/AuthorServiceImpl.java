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

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //v1
    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {

        //DTO --> Entity
        Author authorToBeSaved = new Author();
        authorToBeSaved.setName(authorDTO.getName());
        authorToBeSaved.setGender(authorDTO.getGender());
        authorToBeSaved.setBirthday(authorDTO.getBirthday());

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
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));

        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author authorToBeUpdate = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));

        //Update value here
        authorToBeUpdate.setName(authorDTO.getName());
        authorToBeUpdate.setGender(authorDTO.getGender());
        authorToBeUpdate.setBirthday(authorDTO.getBirthday());

        //save updated obj/entity
        Author updatedAuthor = authorRepository.save(authorToBeUpdate);

        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author authorToBeDelete = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        authorRepository.deleteById(id);
    }

    //Transfer
    private AuthorDTO mapAuthorEntityToDTO(Author author) {
        AuthorDTO response = new AuthorDTO();

        response.setId(author.getId());
        response.setName(author.getName());
        response.setGender(author.getGender());
        response.setBirthday(author.getBirthday());

        return response;
    }
}

