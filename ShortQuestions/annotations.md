### @SpringBootApplication
Used to mark the main class of a Spring Boot application.

    @SpringBootApplication
    public class MyApplication {
        public static void main(String[] args) {
            SpringApplication.run(MyApplication.class, args);
        }
    }

### @Entity
Used to mark a class as a JPA (Java Persistence API) entity.
### @Id
Used to mark a field as the primary key of an entity.
### @GeneratedValue
Specifies how the primary key value is generated (e.g., auto-increment).

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String address;
        ...
    }

### @Table
Used to specify the table name for an entity in the database.

    @Entity
    @Table(name = "User")
    public class User {
        ...
    }

### @Column
Used to specify column attributes for an entity field.

    @Column(name = "user_name", nullable = false)
    private String name;

### @CreationTimestamp  @UpdateTimestamp
Used to automatically populate creation and update timestamps in the database.

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

### @Repository
Used to indicate that a class is a Spring Data repository.

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        ...
    }

### @Service
Used to mark a class as a Spring service.
### @Autowired
Used to inject dependencies automatically.

    @Service
    public class UserService {
        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
    }


### @RestController @RequestMapping @PostMapping @RequestBody @GetMapping @PutMapping @PathVaribale @ResponseStatus
They are used for creating RESTful web services. They define endpoints, HTTP methods, request/response handling, and status codes. 
@RestController marks the class as a REST controller
@RequestMapping defines the base URL
@GetMapping and @PostMapping specify HTTP methods
@PathVariable extracts a value from the URL
@RequestBody specifies the request body
@ResponseStatus can be used to customize HTTP response status codes.

    @RestController
    @RequestMapping("/api/user")
    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            User user = UserService.findById(id);
            return ResponseEntity.ok(user);
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User savedUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }
    }

### @QueryMapping @MutationMapping @SubscriptionMapping
They are meta annotations that are themselves annotated with @SchemaMapping and have the typeName preset to Query, Mutation, or Subscription respectively. Effectively, these are shortcut annotations for fields under the Query, Mutation, and Subscription types respectively. 

### @Argument
For access to a named field argument bound to a higher-level, typed Object.

### @PreAuthorize("hasRole('ADMIN')")
Used in Spring Security to specify access control rules for methods in a Spring application. 

### @EnableRedisHttpSession
Used in Spring applications to enable and configure Spring Session to store session data in Redis, a popular in-memory data store. Spring Session is an abstraction layer that allows you to manage and store session data outside of the application server's built-in session management.

### @EnableGlobalMethodSecurity
Used in a Spring Security configuration class to enable method-level security in a Spring application.

### @EnableEurekaServer
Typically used in a Spring Boot application to indicate that it is acting as a Eureka server. Eureka is a service registry and discovery service used in microservices architectures. By using this annotation, you configure your application to serve as a Eureka server, which other services can register with and discover.

###  @RestTemplate
Not a standard Spring annotation, but it is often used to create and configure instances of the RestTemplate class. RestTemplate is a class in Spring that simplifies making HTTP requests to other services. You would typically use @RestTemplate to configure a bean that you can then inject into your classes to make RESTful API calls.

### @HystrixCommand
Uused in conjunction with Netflix Hystrix, which is a library for adding resilience and fault tolerance to your microservices. When applied to a method, it makes that method a Hystrix command. Hystrix provides features like circuit breakers and fallback mechanisms to handle failures in microservices.

### @LoadBalanced
Used with the RestTemplate to indicate that you want to use a load-balanced version of it. When you have multiple instances of a service, and you want to distribute the load across them, you can use this annotation in conjunction with a service discovery mechanism (e.g., Eureka) to automatically load balance requests.

### @EnableCircuitBreaker
Used to enable the circuit breaker pattern in a Spring Boot application. It's a higher-level annotation that's often used when you're working with different circuit breaker implementations (e.g., Hystrix) in Spring applications. When combined with specific circuit breaker implementations (e.g., using @HystrixCommand), it helps manage the resilience of your microservices.