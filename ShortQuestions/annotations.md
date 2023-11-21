### Annotations Used by Entity (JPA/Hibernate):

- `@Repository`: 表示为数据层

- `@Entity`:
    - Indicates that the class is a JPA entity, representing a table in the database.
    - 表示数据库的一个table, 表明这是一个实体类。一般用于jpa这两个注解一块使用，但是如果表名和实体类名相同的话，@Table可以省略
- `@Table`: 
    - specify the details of the database table to which the entity is mapped
    - table的details, specifies the table name associated with an entity class.
- `@Id` :
    - specify the primary key of an entity. It marks a field as the unique identifier of the entity.
    - primary key in a table 表示该属性为主键。

- `@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = “repair_seq”)` :
    - specify how the primary key value is generated. It is often used in conjunction with @Id. Options include AUTO, IDENTITY, SEQUENCE, and TABLE.
    - 和`@Id`一起使用，注明primary key是怎么生成的, name为sequence的名称，以便使用，sequenceName为数据库的sequence名称，两个名称可以一致。

- `@Column`
    - Provides column-level mapping settings for an entity attribute.
    - name: Specifies the name of the column in the database table.
    - nullable: Indicates whether the column allows null values (false means it's not nullable).
    - length: Defines the maximum length of the column.

- `@CreationTimeStamp`
    - automatically populating it with the current timestamp when a new entity instance is persisted.
    - 自动产生时间戳

    ```java
    import javax.persistence.*;
    import java.time.LocalDateTime;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "full_name", nullable = false, length = 100)
        private String fullName;

        @Column(name = "email", unique = true, nullable = false, length = 100)
        private String email;

        @CreationTimestamp
        @Column(name = "created_at")
        private LocalDateTime createdAt;

        // Getters and setters
        // Constructors, etc.

        // Other entity properties, methods, etc.
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

## Annotations Used by Controller:

- `@Controller` Controller层
    - mark a class as a Spring MVC controller. It works together with Spring's DispatcherServlet to handle incoming HTTP requests.
    - 表明一个class是controller组件，处理http请求
    ```java
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class MyController {
        // Controller methods
    }

- `@RestController`: 
    - combines @Controller and @ResponseBody, 
    - It's specifically used for creating RESTful web services where the response directly represents the data instead of a view.
    - @Controller注解通常用于标识控制器类，它告诉Spring该类是一个控制器，可以处理HTTP请求并返回视图。而@ResponseBody注解用于将方法的返回值直接作为HTTP响应的主体（Body）发送给客户端。

    ```java
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.bind.annotation.GetMapping;

    @RestController
    public class MyRestController {
        @GetMapping("/hello")
        public String hello() {
            return "Hello, World!";
        }
    }
    ```
    
- `@RequestMapping` :
    - This annotation maps HTTP requests to handler methods within a controller class. 
    - It can be used at the class level or at the method level to specify the request URL and HTTP methods that the method can handle.
    - 映射HTTP请求的路径和HTTP请求方法到相应的处理方法。
    - @RequestMapping(“/path”)表示该控制器处理所有“/path”的URL请求。RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。
    - 该注解有六个属性：
        - `params`:指定request中必须包含某些参数值是，才让该方法处理。
        - `headers`:指定request中必须包含某些指定的header值，才能让该方法处理请求。
        - `value`:指定请求的实际地址，指定的地址可以是URI Template 模式
        - `method`:指定请求的method类型， GET、POST、PUT、DELETE等
        - `consumes`:指定处理请求的提交内容类型（Content-Type），如application/json,text/html;
        - `produces`:指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回

    ```java
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

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
    - These annotations are specialized versions of @RequestMapping used for specific HTTP request methods (GET, POST, PUT, DELETE) respectively. They are shortcuts to specify the request method and URL.
    - 分别对应HTTP的GET、POST、PUT和DELETE请求。

    ```java
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api")
    public class MyAPIController {
        @GetMapping("/data")
        public String getData() {
            return "Some data";
        }
    
    @PostMapping("/data")
    public String createData(@RequestBody String data) {
        // Process data
        return "Data created: " + data;
    }
    
    // Other methods for PUT and DELETE
    }
    ```

- `@PathVariable`:
    - extract values from the URI (e.g., /users/{id}) and bind them to method parameters in the controller handler method.
    - 将URL中的占位符绑定到处理方法的参数上。

    ```java
    @RestController
    @RequestMapping("/users")
    public class UserController {
    @GetMapping("/{id}")
        public String getUserById(@PathVariable Long id) {
        // Retrieve user with the given ID
            return "User ID: " + id;
        }
    }
    ```

- `@RequestBody`: 
    - It binds the HTTP request body to a method parameter in a controller method. 
    - It's used to extract data from the request body, especially in POST and PUT requests.
    - 接收HTTP请求的请求体作为方法参数

    ```java
    @RestController
    public class PostController {
        private final PostRepository postRepository;

        @PostMapping("/posts")
        // @RequestBody注解将请求主体的内容绑定到Post对象（@RequestBody注解告诉Spring将请求的主体内容转换为指定的Java对象类型。
        public Post createPost(@RequestBody Post post) {
            return postRepository.save(post);
        }   
    }
    ```

- `@ResponseBody` : 
    - It's used in conjunction with @Controller to indicate that the return value of a method should be directly written to the HTTP response body (used for RESTful APIs).
    - 将方法返回的对象直接作为HTTP响应的主体内容。

    ```java
    @RestController
    @RequestMapping("/example")
    public class MyController {
        @GetMapping("/hello")
        @ResponseBody
        public String hello() {
            return "Hello, World!";
        }
    }
    ```

- `@RequestParam`：
    - Used to extract query parameters from the request URL and bind them to method parameters in the controller handler method.
    - 将请求参数绑定到处理方法的参数上。

    ```java
    @RestController
    @RequestMapping("/params")
    public class ParamsController {
        @GetMapping("/user")
        public String getUser(@RequestParam String username) {
            // Fetch user based on the provided username
            return "Requested user: " + username;
        }
    }
    ```

- `@RequestHeader`: 
    - This annotation binds a method parameter to a header value in the HTTP request.
    - 将HTTP请求头部信息绑定到处理方法的参数上。

    ```java
    @RestController
    @RequestMapping("/headers")
    public class HeaderController {
        @GetMapping("/info")
        public String getUserAgent(@RequestHeader("User-Agent") String userAgent) {
            // Fetch and return user-agent header information
            return "User-Agent: " + userAgent;
        }
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

**General Purpose Annotations:**

- `@Autowired` 自动注入
   - Usage: Used for automatic injection of dependencies.
   - Explanation: Automatically wires (injects) a bean into another bean.

    ```java
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

- `@Service`, `@Repository`, `@Component` 标明是哪一层
   - Usage: Applied to classes to designate them as Spring-managed components.
   - Explanation: Used for component scanning and automatic bean creation.

- `@Configuration` 设置层
   - Usage: Applied to a class to indicate that it contains bean configuration.
   - Explanation: Defines a class as a source of bean definitions in JavaConfig.

- `@Bean` 设置为bean（object）
   - Usage: Applied to a method within a `@Configuration` class to define a Spring bean.
   - Explanation: Specifies that a method produces a bean to be managed by the Spring container.

- `@Value` 
   - Usage: Applied to a field or method parameter to inject a value from properties or configuration files.
   - Explanation: Allows injection of external configuration values.

    ```java
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    @Component
    public class MyComponent {

        @Value("${app.api.key}")
        private String apiKey;
    
        // Getter and setter
    }
    ```

- `@Conditional`
   - Usage: Applied to a component or configuration class to conditionally enable or disable it.
   - Explanation: Provides conditional bean registration based on specified conditions.
   
    ```java
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