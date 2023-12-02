package kechen.hw9springbootredbook.service;

import kechen.hw9springbootredbook.payload.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto getAuthorById(long authorId);

    AuthorDto updateAuthor(AuthorDto authorDto, long authorId);

    void deleteAuthorById(long authorId);
}
