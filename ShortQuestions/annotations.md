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