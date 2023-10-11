# Annotations Overview

## Entity Related Annotations

### `@Entity`
Marks a class as a JPA entity, indicating it will be persisted to the database.
```java
@Entity
public class User {
    ...
}
```
### `@Table`
Specifies the table name for an entity in the database.
```java
@Entity
@Table(name = "users")
public class User {
    ...
}

```

### `@Id`
Marks a field as the primary key of an entity.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

```

### `@GeneratedValue`
Specifies how the primary key value is generated.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

```

### `@Column`
Specifies column attributes for an entity field.
```java
@Column(name = "username", unique = true)
private String username;

```

### `@CreationTimestamp & @UpdateTimestamp`
Automatically populate creation and update timestamps in the database.
```java
@CreationTimestamp
@Column(name = "created_at")
private LocalDateTime createdAt;

@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;

```
# Controller Annotations

### `@RestController`
A specialized version of the @Controller annotation that is a stereotype for creating RESTful controllers.
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    ...
}

```

### `@RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping`
Define endpoints, HTTP methods, and more.
```java
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    ...
}

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
    ...
}

```

### `@PathVariable`
Indicates that a method parameter should be bound to a URI template variable.
```java
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    ...
}

```

### `@RequestBody`
Annotation indicating a method parameter should be bound to the body of the web request.
```java
@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
    ...
}

```

### `@Autowired`
Marks a constructor, field, or setter method to be autowired by Spring's dependency injection facilities.

java
```java
@Autowired
private UserService userService;

```
# Exception Annotations
### `@ExceptionHandler & @ControllerAdvice`
Used to handle exceptions across the whole application.

# Service Annotations


### `@Service`
Marks a class as a Spring service.
```java
@Service
public class UserService {
    ...
}

```

### `@Repository`
Indicates that a class is a Spring Data repository.
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    ...
}

```