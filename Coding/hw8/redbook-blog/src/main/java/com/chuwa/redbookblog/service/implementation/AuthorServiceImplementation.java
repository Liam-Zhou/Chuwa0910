package com.chuwa.redbookblog.service.implementation;

import com.chuwa.redbookblog.ResourceNotFoundException;
import com.chuwa.redbookblog.dao.AuthorRepository;
import com.chuwa.redbookblog.entity.Author;
import com.chuwa.redbookblog.payload.AuthorDTO;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {
    AuthorRepository authorRepository;
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setAge(authorDTO.getAge());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        Author savedAuthor = this.authorRepository.save(author);
        return convertEntityToDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(this::convertEntityToDTO).toList();
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        return convertEntityToDTO(authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Author", "id", id)));
    }

    @Override
    public AuthorDTO updateAuthorById(AuthorDTO authorDTO, Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Author", "id", id));
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(author.getLastName());
        author.setAge(authorDTO.getAge());
        Author savedAuthor = this.authorRepository.save(author);
        return convertEntityToDTO(savedAuthor);
    }

    @Override
    public void deleteAuthorById(Long id) {
        this.authorRepository.deleteById(id);
    }

    private AuthorDTO convertEntityToDTO(Author author){
        AuthorDTO dto = new AuthorDTO();
        dto.setAge(author.getAge());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setId(author.getId());
        return dto;
    }
}
