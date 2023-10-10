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


    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {

        Author authorToBeSaved = new Author();
        authorToBeSaved.setName(authorDTO.getName());
        authorToBeSaved.setPhone(authorDTO.getPhone());
        authorToBeSaved.setAddress(authorDTO.getAddress());

        Author savedAuthor = this.authorRepository.save(authorToBeSaved);

        return mapAuthorEntityToDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = this.authorRepository.findAll();
        List<AuthorDTO> response = authors.stream().map(author -> mapAuthorEntityToDTO(author)).collect(Collectors.toList());
        return response;
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = this.authorRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Author", "id", id));

        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author authorToBeUpdate = authorRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Author", "id", id));

        authorToBeUpdate.setName(authorDTO.getName());
        authorToBeUpdate.setPhone(authorDTO.getPhone());
        authorToBeUpdate.setAddress(authorDTO.getPhone());

        Author updatedAuthor = authorRepository.save(authorToBeUpdate);

        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorDTOById(long id) {
        authorRepository.deleteById(id);
    }

    private AuthorDTO mapAuthorEntityToDTO(Author author){
        AuthorDTO response = new AuthorDTO();

        response.setId(author.getId());
        response.setName(author.getName());
        response.setAddress(author.getAddress());
        response.setPhone(author.getPhone());

        return response;
    }
}
