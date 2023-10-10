package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.DAO.AuthorRepository;
import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
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

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setPassword(authorDTO.getPassword());

        Author response = authorRepository.save(author);
        return mapAuthor2DTO(response);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::mapAuthor2DTO).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author's getID","id",id));
        return mapAuthor2DTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author author2Update = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author's update","id",id));
        author2Update.setName(authorDTO.getName());
        author2Update.setPassword(authorDTO.getPassword());
        Author updatedAuthor = authorRepository.save(author2Update);

        return mapAuthor2DTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        authorRepository.deleteById(id);
    }

    public AuthorDTO mapAuthor2DTO(Author author) {
        AuthorDTO response = new AuthorDTO();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setPassword(author.getPassword());
        return response;
    }
}
