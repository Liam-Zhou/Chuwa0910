package kechen.hw8springbootredbook.service.impl;

import kechen.hw8springbootredbook.dao.AuthorRepository;
import kechen.hw8springbootredbook.entity.Author;
import kechen.hw8springbootredbook.exception.ResourceNotFoundException;
import kechen.hw8springbootredbook.payload.AuthorDto;
import kechen.hw8springbootredbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);

        Author savedAuthor = authorRepository.save(author);

        AuthorDto authorResponse = mapToDTO(savedAuthor);

        return authorResponse;
    }

    @Override
    public AuthorDto getAuthorById(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));
        return mapToDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author","id",authorId));
        author.setName(authorDto.getName());


        Author updateAuthor = authorRepository.save(author);
        return mapToDTO(updateAuthor);
    }

    @Override
    public void deleteAuthorById(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("AuthorId", "id", authorId));
        authorRepository.delete(author);
    }

    private Author mapToEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());

        return author;
    }

    private AuthorDto mapToDTO(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());

        return authorDto;
    }
}
