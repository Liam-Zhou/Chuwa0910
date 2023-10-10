### Java annotations

In Java, annotations are metadata that can be added to classes, methods, fields, and other program elements to provide additional information
to the compiler, runtime, or other tools. Commonly used annotations include

### @Entity
Usage: Used to mark a Java class as a JPA entity, indicating that it should be mapped to a database table.
```java
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String email;

    // Getters and setters
}
```

### @Controller (Spring Framework):
Usage: Used to mark a class as a Spring MVC controller, indicating that it handles incoming HTTP requests.
```java
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
```

### @Service (Spring Framework):
Usage: Used to mark a class as a Spring service, indicating that it holds the business logic and is eligible for dependency injection.
```java
@Service
public class UserService {
    // Service methods
}
```

### @Autowired (Spring Framework):
Usage: Used to automatically inject dependencies into a Spring-managed component, such as controllers, services, or repositories.
```java
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Controller methods
}
```

### @RequestMapping (Spring Framework):
Usage: Used to specify the URL mapping for a controller method. It defines which HTTP methods and paths trigger the method.
```java
@Controller
public class ProductController {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts() {
        // Return a view
        return "product-list";
    }
}
```


