# all annotations in Spring Boot

## used for main application

1. `@SpringBootApplication`: mark a class to be Spring Boot.
2. `@Repository`: used on the repository interfaces to indicate that they are Spring-managed components and should be eligible for Spring's component scanning.
3. `@Service`: used to indicate that a class is a service component in a Spring Boot. In Spring, a service is typically a class that performs business logic or service-layer operations.
4. `@Autowired`: automatically inject dependencies into a Spring bean, typically through constructor injection, setter injection, or field injection.

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

## used by Controller
1. `@RestController`: used for building RESTful APIs, where the return values of methods are automatically converted to JSON or XML and included in the response body. 
2. `@RequestMapping`: Defines the base URL path for all methods within the controller class.
    ```java
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    ```
3. `@PostMapping`: define the method as an HTTP POST method.
4. `@RequestBody`: Binds the body of an HTTP request to a method parameter.
    ```java
    @PostMapping
        public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
    ```