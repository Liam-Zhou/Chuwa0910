package kechen.hw8springbootredbook.service;

import kechen.hw8springbootredbook.payload.AuthorDto;
import kechen.hw8springbootredbook.payload.PostDto;
import kechen.hw8springbootredbook.payload.PostResponse;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto getAuthorById(long authorId);

    AuthorDto updateAuthor(AuthorDto authorDto, long authorId);

    void deleteAuthorById(long authorId);
}
