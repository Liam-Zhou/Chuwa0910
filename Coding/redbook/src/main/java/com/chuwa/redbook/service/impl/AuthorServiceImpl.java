package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.exception.ResourcesNotFoundException;
import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
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
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        author.setPlaceOfBirth(authorDTO.getPlaceOfBirth());
        author.setNationality(authorDTO.getNationality());
        author.setGender(authorDTO.getGender());
        author.setOccupation(authorDTO.getOccupation());
        author.setNumberOfWorks(authorDTO.getNumberOfWorks());
        author.setMostFamousWork(authorDTO.getMostFamousWork());
        author.setAuthorBio(authorDTO.getAuthorBio());
        author.setProfilePicture(authorDTO.getProfilePicture());
        Author savedAuthor = authorRepository.save(author);
        return mapAuthorEntityToDto(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> response = authors.stream().map(author -> mapAuthorEntityToDto(author)).collect(Collectors.toList());
        return response;
    }

    @Override
    public AuthorDTO getAuthorDTOById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Author","id",id));
        return mapAuthorEntityToDto(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Author","id",id));
        author.setName(authorDTO.getName());
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        author.setPlaceOfBirth(authorDTO.getPlaceOfBirth());
        author.setNationality(authorDTO.getNationality());
        author.setGender(authorDTO.getGender());
        author.setOccupation(authorDTO.getOccupation());
        author.setNumberOfWorks(authorDTO.getNumberOfWorks());
        author.setMostFamousWork(authorDTO.getMostFamousWork());
        author.setAuthorBio(authorDTO.getAuthorBio());
        author.setProfilePicture(authorDTO.getProfilePicture());
        Author updatedAuthor = authorRepository.save(author);
        return mapAuthorEntityToDto(updatedAuthor);
    }

    @Override
    public String deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Author","id",id));
        authorRepository.delete(author);
        return "Deleted  Author Successfully";
    }

    private AuthorDTO mapAuthorEntityToDto(Author author){
        AuthorDTO response = new AuthorDTO();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setDateOfBirth(author.getDateOfBirth());
        response.setPlaceOfBirth(author.getPlaceOfBirth());
        response.setNationality(author.getNationality());
        response.setGender(author.getGender());
        response.setOccupation(author.getOccupation());
        response.setNumberOfWorks(author.getNumberOfWorks());
        response.setMostFamousWork(author.getMostFamousWork());
        response.setAuthorBio(author.getAuthorBio());
        response.setProfilePicture(author.getProfilePicture());
        return response;
    }
}
