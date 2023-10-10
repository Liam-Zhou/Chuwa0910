**Annotations Used by Entity (JPA/Hibernate):**

1. `@Entity` 表示数据库的一个table
   - Usage: Applied to a Java class to mark it as a JPA entity, representing a table in the database.
   - Explanation: This annotation specifies that the class is an entity and should be mapped to a database table.

2. `@Table` table的details
   - Usage: Applied to an entity class to specify the details of the database table it maps to.
   - Explanation: Allows you to customize table name, schema, indexes, etc.

```
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    
    // Getters and setters
}
```

3. `@Id` primary key in a table
   - Usage: Applied to a field in an entity class to denote it as the primary key of the table.
   - Explanation: Marks a field as the primary identifier for database operations.

4. `@GeneratedValue` 和`@Id`一起使用，注明primary key是怎么生成的
   - Usage: Used in conjunction with `@Id` to specify how primary key values are generated.
   - Explanation: Options include AUTO, IDENTITY, SEQUENCE, and TABLE.

```
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    
    // Getters and setters
}
```

5. `@Column` database column
   - Usage: Applied to a field to specify the mapping details of that field to a database column.
   - Explanation: Allows customization of column name, type, constraints, and more.

```
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private Long id;
    
    @Column(name = "book_title", length = 100)
    private String title;
    
    @Column(nullable = false)
    private String author;
    
    // Getters and setters
}
```

**Annotations Used by Controller (Spring MVC):**

1. `@Controller` Controller层
   - Usage: Applied to a class to designate it as a Spring MVC controller.
   - Explanation: Marks a class as a controller, allowing it to handle HTTP requests.

2. `@RequestMapping` 
   - Usage: Applied to a method to specify the URL pattern that triggers that method.
   - Explanation: Maps a method to a specific HTTP request path.

```
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/example")
public class ExampleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }
}
```

3. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
   - Usage: Applied to methods to specify HTTP request methods (GET, POST, PUT, DELETE) for request mapping.
   - Explanation: Helps define which HTTP methods should trigger specific controller methods.

```
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
```

4. `@RequestParam`
   - Usage: Applied to method parameters to bind HTTP request parameters to method arguments.
   - Explanation: Allows extracting data from the query string or form data.

```
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search(@RequestParam("query") String query) {
        // Process the query parameter
        return "search_results";
    }
}
```

5. `@PathVariable`  从URI抓取元素
   - Usage: Applied to method parameters to extract values from the URI path.
   - Explanation: Useful for capturing dynamic parts of the URL.

**General Purpose Annotations:**

1. `@Autowired` 自动注入
   - Usage: Used for automatic injection of dependencies.
   - Explanation: Automatically wires (injects) a bean into another bean.
```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
    
    // Service methods
}
```

2. `@Service`, `@Repository`, `@Component` 标明是哪一层
   - Usage: Applied to classes to designate them as Spring-managed components.
   - Explanation: Used for component scanning and automatic bean creation.

3. `@Configuration` 设置层
   - Usage: Applied to a class to indicate that it contains bean configuration.
   - Explanation: Defines a class as a source of bean definitions in JavaConfig.

4. `@Bean` 设置为bean（object）
   - Usage: Applied to a method within a `@Configuration` class to define a Spring bean.
   - Explanation: Specifies that a method produces a bean to be managed by the Spring container.

```
```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

5. `@Value` 
   - Usage: Applied to a field or method parameter to inject a value from properties or configuration files.
   - Explanation: Allows injection of external configuration values.

```
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${app.api.key}")
    private String apiKey;
    
    // Getter and setter
}
```

6. `@Conditional`
   - Usage: Applied to a component or configuration class to conditionally enable or disable it.
   - Explanation: Provides conditional bean registration based on specified conditions.
   
```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    @Conditional(MyCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }
}
```