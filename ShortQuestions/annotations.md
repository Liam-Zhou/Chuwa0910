@SpringBootApplication:This is the main annotation that combines
```
@SpringBootApplication
public class RedbookApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}
}
```
@Configuration: Configuration annotation indicates that the class has @Bean definition methods
```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class CollegeConfig {
    @Bean
    public College collegeBean() {
        return new College();
    }
}
```

@EnableAutoConfiguration It's typically used to annotate the main application class.
```
@SpringBootApplication
@EnableAutoConfiguration
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
@ComponentScan. It's typically used to annotate the main application class.
```
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
@RestController: Used to indicate that a class is a REST controller, and its methods are responsible for handling HTTP requests and returning responses.
```
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/api/v1/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
```
@RequestMapping: Specifies the URL mapping for a controller or a controller method. It can also be used with HTTP method-specific annotations like @GetMapping, @PostMapping, etc.
```
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello, World!";
    }
}
```
@Autowired: Used for automatic dependency injection. It allows Spring to inject beans into the annotated fields, methods, or constructors.
```
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());
        Post savedPost = this.postRepository.save(postToBeSaved);
        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());
        return response;
    }
}
```
@Component: Indicates that a class is a Spring component and should be automatically detected and registered in the application context.
```
@Component
public class MyComponent {
    public void doSomething() {
        System.out.println("MyComponent is doing something.");
    }
}
```
@Service: A specialization of @Component, used to annotate service classes. Service classes are typically used for business logic.
```
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());
        Post savedPost = this.postRepository.save(postToBeSaved);
        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());
        return response;
    }
}
```
@Repository: A specialization of @Component, used to annotate classes that interact with a database. It's often used with Spring Data to simplify database operations.
```
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
```

@Value: Used for injecting values from properties files or configuration sources into fields or constructor parameters.
```
@Component
public class AppConfig {

    @Value("${app.name}")
    private String appName;
    public void printAppInfo() {
    }
}
```
@Profile: Defines profiles for different environments or configurations, allowing you to activate specific configurations based on the environment.
```
@Component
@Profile("production")
public class ProductionDataSource implements DataSource {
    @Override
    public String getDataSourceInfo() {
        return "Production Data Source";
    }
}
```
@ConditionalOnProperty: Conditionally activates or deactivates a bean or configuration based on the presence or value of a specific property.
```
@Configuration
public class FeatureConfiguration {
    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
    public FeatureEnabledBean featureEnabledBean() {
        return new FeatureEnabledBean();
    }
    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "false", matchIfMissing = true)
    public FeatureDisabledBean featureDisabledBean() {
        return new FeatureDisabledBean();
    }
}
```
@ConditionalOnClass: Conditionally activates a bean or configuration if a specific class is present in the classpath.
```
@Configuration
public class FeatureConfiguration {
    @Bean
    @ConditionalOnClass(name = "org.springframework.web.servlet.DispatcherServlet")
    public FeatureEnabledBean featureEnabledBean() {
        return new FeatureEnabledBean();
    }
    @Bean
    public FeatureDisabledBean featureDisabledBean() {
        return new FeatureDisabledBean();
    }
}
```
@ConditionalOnMissingClass: Conditionally activates a bean or configuration if a specific class is not present in the classpath.
```
@Configuration
public class FeatureConfiguration {

    @Bean
    @ConditionalOnMissingClass("org.springframework.jms.core.JmsTemplate")
    public FeatureEnabledBean featureEnabledBean() {
        return new FeatureEnabledBean();
    }

    @Bean
    public FeatureDisabledBean featureDisabledBean() {
        return new FeatureDisabledBean();
    }
}
```
@ExceptionHandler: Used to define methods that handle exceptions thrown by the application.
```
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```
@EnableScheduling: Enables the scheduling of tasks using Spring's @Scheduled annotation.
```
@SpringBootApplication
@EnableScheduling // Enable scheduling
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
@Transactional: Marks a method, class, or interface as transactional, enabling Spring-managed transactions.
```
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
```
@Validated: Used for method-level validation in Spring MVC controllers.
```
@RestController
@Validated // Enable method-level validation
public class UserController {

    @PostMapping("/createUser")
    public String createUser(@Valid @RequestBody UserDTO userDTO) {
        // This method will only be called if userDTO is valid
        return "User created: " + userDTO.getUsername();
    }
}
```
@EntityScan: Specifies the base package for entity scanning when using Spring Data JPA.
```
@Configuration
@EntityScan(basePackages = "com.example.entity")
public class JpaConfiguration {
}
```
@SpringBootTest: Used in integration tests to load the Spring context for testing.
```
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void testSayHello() {
        String url = "http://localhost:" + port + "/api/hello";
        String response = restTemplate.getForObject(url, String.class);
        assertEquals("Hello, World!", response);
    }
}
```