import com.chuwa.redbookblog.payload.AuthorDto;
import com.chuwa.redbookblog.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {
    private final AuthorService authorService;
    @MutationMapping
    public AuthorDto createAuthor(@Argument String firstName,
                                  @Argument String lastName) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setLastName(lastName);
        authorDto.setFirstName(firstName);

        return authorService.createAuthor(authorDto);
    }
    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public AuthorDto authorByID(@Argument Long id) {
        return authorService.getAuthorById(id);
    }


}