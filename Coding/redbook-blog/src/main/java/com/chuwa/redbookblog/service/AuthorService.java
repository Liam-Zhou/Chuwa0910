import com.chuwa.redbookblog.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthor();
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthorById(long id);
    AuthorDto updateAuthor(AuthorDto authorDto, long id);
    void deleteAuthorById(long id);

}