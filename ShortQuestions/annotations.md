# all annotations in Spring Boot

## used for main application

1. `@SpringBootApplication`: mark a class to be Spring Boot.
2. `@Repository`: used on the repository interfaces to indicate that they are Spring-managed components and should be eligible for Spring's component scanning.
3. `@Service`: used to indicate that a class is a service component in a Spring Boot. In Spring, a service is typically a class that performs business logic or service-layer operations.
4. `@Autowired`: automatically inject dependencies into a Spring bean, typically through constructor injection, setter injection, or field injection.
5. `@ResponseStatus`: cause Spring boot to respond with the specified HTTP status code whenever this exception is thrown from your controller.
6. `@EnableTransactionManagement`: enable Transaction management inside the application.
7. `@configuration`: indicate that a class is a configuration class.
8. `@Bean`: define Spring beans within a configuration class.
9. `@ExceptionHandler`: create a global exception handler class

## used by Entity

1. `@Entity`: Marks a class as a JPA entity, which means it will be persisted to a database table.
2. `@Table`: Specifies the name of the database table associated with the entity. We can also use it to define additional table-related properties.
    ```java
    @Entity
    @Table(
        name = "posts",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
        }
    )
    ```
3. `@Id`: Indicates the primary key field of the entity.
4. `@GeneratedValue`: Specifies how the primary key value is generated, such as `GenerationType.AUTO`, `GenerationType.IDENTITY`, or `GenerationType.SEQUENCE`.
5. `@Column`: Allows us to customize the mapping of a field or property to a database column. We can specify attributes like `name`, `length`, `nullable`, etc.
6. `@UniqueConstraint`: Make a field in database unique. 
7. `@CreationTimestamp`: automatically generate the time that it be created.
8. `@UpdateTimestamp`: automatically generate the time that it be updated.
    ```java
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title", nullable = false)
        private String title;
        @CreationTimestamp
        private LocalDateTime createDateTime;
        @UpdateTimestamp
        private LocalDateTime updateDateTime;
    ```
9. `@OneToOne`: define a one-to-one relationship between two table.
10. `@ManyToOne`: define a many-to-one relationship between two table.
11. `@OneToMany`: define a one-to-many relationship between two table.
12. `@ManyToMany`: define a many-to-many relationship between two table.
13. `@JoinColumn`: define how two tables should be joined.
14. `@NamedQuery`: using JPQL to define a query method at the class.
15. `@NamedQueries`: define multiple NamedQuery.
16. `@Query`: define a query method using sql or JPQL.

## used by Controller
1. `@RestController`: used for building RESTful APIs, where the return values of methods are automatically converted to JSON or XML and included in the response body. 
2. `@RequestMapping`: Defines the base URL path for all methods within the controller class.
    ```java
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    ```
3. `@PostMapping`: define the method as an HTTP POST method.
4. `@GetMapping`: define the method as an HTTP GET method.
5. `@PutMapping`: define the method as an HTTP PUT method.
6. `@DeleteMapping`: define the method as an HTTP DELETE method.
7. `@RequestBody`: Binds the body of an HTTP request to a method parameter.
8. `@PathVariable`: Binds the variable inside the URL path to program.
   ```java
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updateAuthorById(@PathVariable(name="id") long id, @RequestBody AuthorDTO authorDTO){
    ```
9. `@RequestParam`: Binds the HTTP requests parameter to a variable.
10. `@ControllerAdvice`: handle custom exception with global exception handler.

## used by GraphQL
1. `@Controller`: define class as a controller.
2. `@QueryMapping`: define a method that only read data from api, like GET.
3. `@MutationMapping`: define a method that will send new data to api, like POST or PUT.
4. `@Argument`: Binds the parameter that sent to api.

## used by service
1. `@Transactional`: make the method transactional.