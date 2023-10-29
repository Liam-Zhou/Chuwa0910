package com.chuwa.redbook.service.implementation;

import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorDTO mapAuthorEntityToDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setSex(author.getSex());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        return authorDTO;
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author(authorDTO.getFirstName(), authorDTO.getLastName(), authorDTO.getSex());

        Author savedAuthor = authorRepository.save(author);

        return mapAuthorEntityToDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors= authorRepository.findAll();

        return authors.stream().map(this::mapAuthorEntityToDTO).toList();
    }

    @Override
    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Author", "id", id));
        return mapAuthorEntityToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO, long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Author", "id", id));
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setSex(authorDTO.getSex());
        Author updatedAuthor = authorRepository.save(author);
        return mapAuthorEntityToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Author", "id", id));
        authorRepository.deleteById(id);
    }
}
