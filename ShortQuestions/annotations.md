# Common annotations

### Annotations Used by Entity (Model) Classes:
@Entity:
- Used to mark a class as a JPA (Java Persistence API) entity, indicating that instances of this class can be stored in a relational database table.
- Example:
```java
@Entity
public class User {
    // ...
}
```

@Table:
- Specifies the details of the database table to which an entity is mapped.
You can use it to specify the table name, schema, and other attributes.
- Example:
```java
@Entity
@Table(name = "users")
public class User {
    // ...
}
```

@Id:
- Marks a field as the primary key of an entity.
- Example:
```java
Copy code
@Entity
public class User {
    @Id
    private Long id;
    // ...
}
```

@GeneratedValue:

- Specifies the generation strategy for primary key values. Commonly used with @Id to automatically generate primary key values.
- Example:
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ...
}
```

### Annotations Used by Controller Classes:

@Controller:

- Marks a class as a Spring MVC controller, responsible for handling HTTP requests.
Typically used in combination with @RequestMapping.
- Example:
```java
@Controller
public class UserController {
    // ...
}
```

@RestController:

- Similar to @Controller, but specifically designed for RESTful web services.
Automatically converts return values to JSON or XML responses.
- Example:
```java
@RestController
public class ApiController {
    // ...
}
```

@RequestMapping:

- Specifies the URL patterns and HTTP methods that a controller method can handle.
Used at the method level to define endpoint mappings.
- Example:
```java
@RequestMapping("/users")
public class UserController {
    // ...
}
```
### Annotations Used for Request Handling:

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, etc.:

- Convenience annotations that combine @RequestMapping with specific HTTP methods.
Used to map HTTP requests to controller methods.
- Example:
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // ...
}
```
@PathVariable:

- Binds a method parameter to a URI template variable. Used to extract values from the URL.
- Example:
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // ...
}
```

@JsonProperty()
- It is a Java annotation used in the context of object serialization and deserialization with libraries like Jackson.

- It is typically applied to a field or getter method within a Java class to specify the mapping between a JSON property and a Java object property when converting JSON data to Java objects or vice versa.

### Annotations Used by Repository(JPA):
@Query()
- Used to customize own query method in Repository, must extend JPARepository.

### Annotations Used by Exception:
@ControllerAdviosr
- Used to handle those exceptions throwed by controller.

@ExceptionHandler
- Used to customize own method to handle specific exceptions. 


### Aonntations Used by Security

@PreAuthorize("...")
- Used to authorize which user can call APIs.

@Value("")
- Used to get varibles in properties
```java
@Value("${app.xxx.xxx}")
private String xxx;
```


### Aonntations Used by AOP

@Aspect
- Used to clarify the class to define all aop self methods

@Pointcut
- Expression to find all main application methods to insert advice

@Before 
- Run before the method execution

@After 
- Run after the method returned a result

@AfterReturning 
- Run after the method returned a result, intercept the 
returned result as well.

@AfterThrowing 
- Run after the method throws an exception

@Around 
- Run around the method execution, combine all three advices above.

`Object result = joinPoint.proceed()` -- to invoke proxy methods

### Aonntations Used by Spring Tasks(Cron)
@EnableScheduling
@Schedule
```java
@Schedule(initialDelay = 1000, fixedRate = 1000)

@Schedule(cron = "* * * * * *")
```

### Annotations used in Test

@ExtendWith

@Mock
- Used to create a "fake" DAO object to mock the following processes.
```java
@Mock
private OBJRepository objRepositoryMock;

private OBJRepository objRepositoryMock = Mockito.mock(OBJRepository.class);
```

@Spy
- Similar as @Mock, but no need to define all methods used in original codes.

@InjectMocks
- Inject mock and spy objects into original class.
```java
@InjectMocks
private PostServiceImpl postService;
```
