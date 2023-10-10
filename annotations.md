# annotations - Grace Hu

## Entity
@Entity: Marks a class as a JPA entity, indicating that it will be persisted to the database.

@Table: Specifies the details of the database table to be used for mapping.

@UniqueConstraint

@Id: Marks the field as a primary key in the database.

@GeneratedValue: Defines the strategy for generating primary keys.

@Column: Specifies the details of the database column to which the field will be mapped.

@CreationTimestamp

@UpdateTimestamp

## Controller
@RestController: A specialized version of the @Controller annotation that is a stereotype for creating RESTful controllers.

@RequestMapping: Maps HTTP requests to handler methods in the controller.

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Shortcuts for @RequestMapping(method = RequestMethod.GET/POST/PUT/DELETE).

@PathVariable: Indicates that a method parameter should be bound to a URI template variable.

@RequestBody: Annotation indicating a method parameter should be bound to the body of the web request.

@Autowired: Marks a constructor, field, or setter method to be autowired by Spring's dependency injection facilities.

## Exception
@ExceptionHandler
@ControllerAdvice

## Service
@Service

## Example

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;

    import javax.persistence.*;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username", unique = true)
        private String username;

        @Column(name = "password")
        private String password;

        // Getters and setters

    }

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            // Implementation
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            // Implementation
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
            // Implementation
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            // Implementation
        }
    }
