**Entity**
1. @Entity: telling JPA that instances of this class should be treated as entities. 
JPA assumes that the table name in the database is the same as the name of the entity class. However, you can use the @Table annotation to specify a different table name or to configure other database-specific settings.

        @Entity
        @Table(name = "my_table")
        public class MyEntity {
            // Class fields and methods
        }

2. @Table: specify a different table name or to configure other database-specific settings. See above example. 
3. @UniqueConstraint: You apply the @UniqueConstraint annotation to your entity class to specify the unique constraints on the table generated for that entity.
   We've specified two unique constraints:
The first unique constraint ensures that values in "column1" must be unique across all rows in the table.
The second unique constraint ensures that the combination of values in "column2" and "column3" must be unique.

        @Entity
        @Table(
            name = "my_table", 
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"column1"}),
                @UniqueConstraint(columnNames = {"column2", "column3"})
        })
        public class MyEntity {
            // Entity fields and methods
        }
4. @Id: apply the @Id annotation to one of the fields in your entity class to specify which field serves as the primary key for that entity.

        @Entity
        public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
            private String name;
            private double price;
        
            // Getters and setters, constructors, and other methods
        }
5. @GeneratedValue: specify how the primary key values are generated (e.g., auto-incremented in the database). See above example
6. @Column: apply the @Column annotation to a field or property within your entity class to specify the database column properties.
   1. @Column(name = "product_name"): This annotation specifies that the name field should be mapped to a database column named "product_name". You can use the name attribute to customize the column name if it differs from the field name.
   2. @Column(length = 100, nullable = false): This annotation specifies that the name field should have a maximum length of 100 characters, and it should not allow null values. The length attribute sets the maximum length, and the nullable attribute controls whether the column allows null values.
   3. @Column(name = "unit_price"): This annotation specifies that the price field should be mapped to a database column named "unit_price".


        @Entity
        public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
            @Column(name = "product_name", length = 100, nullable = false)
            private String name;
        
            @Column(name = "unit_price")
            private double price;
        
            // Getters and setters, constructors, and other methods
        }
7. @CreationTimeStamp: Not a JPA annotation. In Hibernate, automatically populate a field with the timestamp of when an entity is first persisted (i.e., when it's initially saved to the database). This annotation is typically used for auditing purposes to track when records are created.
8. @UpdateTimeStamp: Similar to @CreationTimeStamp.

        @CreationTimestamp
        @Column(name = "created_at")
        private Timestamp createdAt;

**Controller**
1. @Controller: define a class as a spring mvc controller. Usually conjunction with method annotation @RequestMapping to handle http request.

        @Controller
        public class MyController {
            // Request mapping methods here
        }
2. @RestController: a specialized version of @Controller that is used to define REST-ful web service controllers. (@Controller + @RequestBody)

        @RestController
        public class MyRestController {
        //Request mapping methods here
        }
3. @RequestMapping/@GetMapping: This annotation is used to map a URL pattern to a method in a _controller_. It specifies which HTTP method(s) the method should handle and the URL path.

        @RequestMapping("/api/v1/posts")
        public class PostController {
4. @RequestBody: typically use @RequestBody in a controller method to `capture the data` sent in the request body.
   In this example, MyDto is a Java class that represents the structure of the JSON or XML data expected in the request body. 
The @RequestBody annotation tells Spring to deserialize the request body into an instance of MyDto and pass it as a parameter to the create method.

        @PostMapping("/create")
        public ResponseEntity<String> create(@RequestBody MyDto myDto) {
        // Process myDto and return a response
        }
5. @PutMapping: This annotation is used to handle HTTP PUT requests. It specifies that the annotated method should be invoked when a PUT request is sent to a specific URL or URI path. PUT requests are typically used for updating existing resources on the server.
         
         @PutMapping("/products/{id}")
         public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
            Update the product with the given ID
            Return an appropriate response
         }

6. @DeleteMapping: This annotation is used to handle HTTP DELETE requests. It specifies that the annotated method should be invoked when a DELETE request is sent to a specific URL or URI path. DELETE requests are used for deleting resources on the server.
7. @PostMapping: This annotation is used to handle HTTP POST requests. It specifies that the annotated method should be invoked when a POST request is sent to a specific URL or URI path. POST requests are typically used for creating new resources on the server.
8. @GetMapping:  This annotation is used to handle HTTP GET requests. It specifies that the annotated method should be invoked when a GET request is sent to a specific URL or URI path. It is commonly used for retrieving data from the server.
   
         @GetMapping("/products")
         public List<Product> getAllProducts() {
         // Return a list of products
         }
9. @ControllerAdvice: Class Level, >make this class be a bean

9. @RequestParam:
**Services**
1. @Service: typically used for service classes. In this example, PostServiceImplementation class implements an interface. That is a real class, so marked @Service.

        @Service
        public class PostServiceImplementation implements PostService {

**全局**
1. @AutoWired: This annotation is used for automatic dependency injection. When placed on a field, constructor, or setter method, Spring will automatically inject the required dependency.

        public class PostController {
            @Autowired
            private PostService postService;
            @PostMapping
            public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){ //json object
                PostDTO response = postService.createPost(postDTO);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
        }
2. @SpringBootApplication: mark the main class of a spring boot application. It's usually placed on the class containing the main method.

        @SpringBootApplication
        public class MyApplication {
            public static void main(String[] args) {
                SpringApplication.run(MyApplication.class, args);
            }
        }
3. @ResponseStatus(value = HttpStatus.NotFound):

**JPQL**
1. @PersistenceContext: It is used to manage entity objects and perform database operations. 
The entity manager is a core component of JPA that manages entity objects and their persistence in the database. 
It provides methods for querying, persisting, updating, and removing entities.

            @PersistenceContext
            private EntityManager entityManager;
2. @NamedQuery: This annotation is used to define a named query. A named query is a static query with a predefined unchangeable query string.

            @Entity
            @NamedQuery(
               name = "findPersonByName",
               query = "SELECT p FROM Person p WHERE p.name = :name"
            )
            public class Person {
            // ...
            }
3. @NamedQueries: This annotation is used to define multiple named queries. It is used to group multiple @NamedQuery annotations.
            
            @Entity
            @NamedQueries({
            @NamedQuery(
            name = "findPersonByName",
            query = "SELECT p FROM Person p WHERE p.name = :name"
            ),
            @NamedQuery(
            name = "findPersonByAge",
            query = "SELECT p FROM Person p WHERE p.age = :age"
            )
            })
            public class Person {
            // ...
            }
4. @Query: This annotation is used to define a query. Unlike @NamedQuery, the query string is not static and can be changed at runtime.
               
               public interface UserRepository extends JpaRepository<User, Long> {
               @Query("SELECT u FROM User u WHERE u.username = ?1")
               List<User> findByUsername(String username);
               }
               //In this example, the @Query annotation is used to define a custom JPQL query for finding users by their username.
5. @Query: It also can define a native SQL query. SQL语句中的变量以":"开头`.
               
         @Query("select p from Post p where p.id = :key or p.title =:title")

**Exception**
1. @ControllerAdvice: Class Level, >make this class be a bean
2. @ExceptionHandler: Method Level, >handle exception

        @ControllerAdvice
        public class GlobalExceptionHandler {
            @ExceptionHandler(NotFoundException.class)
            @ResponseStatus(HttpStatus.NOT_FOUND)
            public void handleNotFound() {
                // Nothing to do
            }
        }


**Bean**
@Service
@Controller
@RestController
@Component
@Configuration
@Repository
@ControllerAdvice
@Bean


