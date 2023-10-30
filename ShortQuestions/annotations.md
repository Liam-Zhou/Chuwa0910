# all annotations in Spring Boot

## used for main application

1. `@SpringBootApplication`: mark a class to be Spring Boot.
2. `@Repository`: used on the repository interfaces to indicate that they are Spring-managed components and should be eligible for Spring's component scanning.
3. `@Service`: used to indicate that a class is a service component in a Spring Boot. In Spring, a service is typically a class that performs business logic or service-layer operations.
4. `@Autowired`: automatically inject dependencies into a Spring bean, typically through constructor injection, setter injection, or field injection.
5. `@ResponseStatus`: cause Spring boot to respond with the specified HTTP status code whenever this exception is thrown from your controller.
6. `@EnableTransactionManagement`: enable Transaction management inside the application.
7. `@Configuration`: indicate that a class is a configuration class.
8. `@Bean`: define Spring beans within a configuration class.
9. `@ExceptionHandler`: create a global exception handler class.
10. `@ComponentScan`: define where to find the bean.
11. `@EnableAutoConfiguration`: enable automatic configuration of the Spring application context.
12. `@Resource`: from Java EE. to inject resources.
13. `@Inject`: used for dependency injection in Java applications.
14. `@Primary`: assign a primary class that should be injected of the same type.
15. `@Qualifier`: specify which bean should be injected when there are multiple candidate beans of the same type.
16. `@EnableSchduling`: enable task schedule
17. `@Scheduled`: schedule a task

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

## used by security
1. `@PreAuthorize`: define which role can access this controller.
2. `@EnableRedisHttpSession`: enable distributed and centralized session management using Redis.

## AOP
1. `@Aspect` - indicate this is an aop class
2. `@Component` - This annotation mark the beans as Spring’s managed components
3. `@Before` – Run before the method execution
4. `@After` – Run after the method executed.
5. `@AfterReturning` – Run after the method returned a result
6. `@AfterThrowing` – Run after the method throws an exception
7. `@Around` – Run around the method execution, combine `@Before` and `@After`.

## Swagger
- `Api` Marks a class as a Swagger resource.
-   `ApiImplicitParam` Represents a single parameter in an API Operation.
-   `ApiImplicitParams` A wrapper to allow a list of multiple `ApiImplicitParam` objects.
-   `ApiModel` Provides additional information about Swagger models.
-   `ApiModelProperty` Adds and manipulates data of a model property.
-   `ApiOperation` Describes an operation or typically a HTTP method against a specific path.
-   `ApiParam` Adds additional meta-data for operation parameters.
-   `ApiResponse` Describes a possible response of an operation.
-   `ApiResponses` A wrapper to allow a list of multiple `ApiResponse` objects
-  `Authorization` Defines an authorization scheme to be used on a resource or an operation.
-  `AuthorizationScope` Describes an OAuth2 authorization scope.
-  `Contact` Contact metadata available within the info section of a Swagger definition - see https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#contactObject
-  `Extension` An optionally named list of extension properties.
-  `ExtensionProperty` A name/value property within a Swagger extension
-  `ExternalDocs` Represents an external documentation description.
-  `Info` High-level metadata for a Swagger definition - see https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#infoObject
-  `License` License metadata available within the info section of a Swagger definition, see https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#licenseObject
-  `ResponseHeader` Represents a header that can be provided as part of the response.
-  `SwaggerDefinition` Annotation that configures definition level metadata.
-  `Tag` A definition level Tag object see https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#tag-objec