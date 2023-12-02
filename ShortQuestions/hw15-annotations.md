# Annotations Used by Entity (JPA/Hibernate):

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
    - specify how the primary key value is generated. It is often used in conjunction with @Id.
    -  Options include:
        - AUTO: 根据底层数据库的支持情况自动选择适合的主键生成策略。通常情况下，它会根据数据库自动增长（例如 MySQL 的 AUTO_INCREMENT）或序列（例如 Oracle 的序列）来选择合适的策略。
        - IDENTITY: 依赖于底层数据库的自动增长机制（比如 MySQL 中的 AUTO_INCREMENT)
        - SEQUENCE: 使用数据库中的序列来生成主键值（比如 Oracle 中的序列）。它从预定义的序列获取下一个值作为主键
        - TABLE: 使用一个特定的数据库表来存储下一个可用的主键值。它通过在表中存储和维护键值对的方式生成主键。
    - 和`@Id`一起使用，注明primary key是怎么生成的。

- `@Column`
    - Provides column-level mapping settings for an entity attribute.
    - name: Specifies the name of the column in the database table.
    - nullable: Indicates whether the column allows null values (false means it's not nullable).
    - length: Defines the maximum length of the column.

- `@CreationTimeStamp`
    - automatically populating it with the current timestamp when a new entity instance is persisted.
    - 记录对象的创建时间戳，以便跟踪对象的创建日期和时间。

- `@UpdateTimestamp`
    - 记录对象的最后一次更新时间戳，以便跟踪对象的最后修改日期和时间

- `@JsonProperty`
    - 它表示在 JSON 序列化和反序列化过程中，该字段将使用指定的名称：name
    - 如果是@jsonProperty("full name"),那么在 JSON 中将其表示为不同的名称： full_name

- `Getter`, `Setter`, `NoArgsConstructor`,`AllArgsContructor`
    - 来自于 Lombok 库，自动生成类中所有字段的 Getter 和 Setter 方法, 自动生成构造函数。

    ```java
    import javax.persistence.*;
    import java.time.LocalDateTime;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @jsonProperty("full name")
        @Column(name = "full_name", nullable = false, length = 100)
        private String fullName;

        @Column(name = "email", unique = true, nullable = false, length = 100)
        private String email;

        @CreationTimestamp
        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updateDateTime;
    }
    ```

- `@OneToOne`：
    - specify one-to-many and one-to-one relationships between entities.
    - 描述实体之间的关系，其中一个实体对象可以与另一个实体对象建立一对一的关系。

- `@OneToMany` and `@ManyToOne`：
    - specify one-to-many and many-to-one relationships between entities.
    - 描述实体之间的关系，其中一个实体对象可以与另一个实体对象建立一对多/多对一的关系。
    - @ManyToOne(fetch = FetchType.LAZY)：指定加载关联实体的方式。
    - 在加载实体时不会立即加载关联的实体数据，而是在访问关联属性时才会触发加载，这种方式也被称为延迟加载。

- `@JoinColumn`:
    - specify the column that is used for joining in a relationship.
    - 充当了外键的角色，指示了实体之间的关联关系。
    - 一对一：本表中指向另一个表的外键。一对多/多对一：另一个表指向本表的外键。

    ```java
    @Entity
    public class Author {
        // ...
        // Specifies the field in the target entity (Book in this case) that owns the relationship
        @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)    
        private List<Book> books;
        // ...
    }

    @Entity
    public class Book {
        // ...
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id")
        private Author author;
        // ...
    }
    ```

- `@ManyToMany`:
    - specify a many-to-many relationship between entities.
    - 描述实体之间的关系，其中一个实体对象可以与另一个实体对象建立多对多的关系。

- `@JoinTable`:
    - define the join table for a many-to-many relationship

    ```java
    @Entity
    public class Student {
        // ...
        @ManyToMany
        @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private List<Course> courses;
        // ...
    }

    @Entity
    public class Course {
        // ...
        @ManyToMany(mappedBy = "courses")
        private List<Student> students;
        // ...
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by JPQL:

- `@NamedQuery` : 
    - define a named query at the entity level for JPA entities.

- `@NamedQueries`:
    - define multiple named queries for an entity class.

- `@Query` : 
    - define a custom queries for a repository using JPQL (Java Persistence Query Language) or native SQL.
    - 定义一个基于JPQL（Java Persistence Query Language）的查询方法。

    ```java
    // Entity层
    @Entity
    @Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
    )
    // 在实体类 Post 上定义一个名为 "Post.getAll" 的查询。
    // 从数据库中选择所有的 Post 对象并返回。在这个查询中，p 是 Post 类的别名，
    @NamedQuery(name="Post.getAll", query="select p from Post p")
    public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        //省略其他field
    }

    // Repository层
    @Repository
    public interface PostJPQLRepository{

        // 根据条件从数据库中选择 Post 对象
        // ?1 对应方法参数中的第一个参数 Long id。
        // ?2 对应方法参数中的第二个参数 String title。
        @Query("select p from Post p where p.id = ?1 or p.title = ?2")
        // 通过 id 或者 title 获取对应的 Post 对象。
        Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);

        @Query("select p from Post p where p.id = :key or p.title = :title")
        Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                   @Param("title") String title);
    }
    ```

- `@PersistenceContext`
    - All operations that are performed in a specific session are stored inside the PersistenceContext. 

    ```java
    // entity层
    @Entity
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private double price;

        // Constructors, getters, setters
    }

    // repository层
    @Repository
    public class ProductRepository {

        @PersistenceContext
        private EntityManager entityManager;

        @Transactional
        public void saveProduct(Product product) {
            entityManager.persist(product); // Persisting a new product
        }

        @Transactional
        public Product findProductById(Long productId) {
            return entityManager.find(Product.class, productId); // Finding product by ID
        }

        @Transactional
        public void updateProduct(Product updatedProduct) {
            entityManager.merge(updatedProduct); // Updating an existing product
        }

        @Transactional
        public void deleteProduct(Long productId) {
            Product productToDelete = entityManager.find(Product.class, productId);
            if (productToDelete != null) {
                entityManager.remove(productToDelete); // Deleting a product
            }
        }
    }
    ```



<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by GraphQL:

- `@QueryMapping`:  相当于restful api里面的@GetMapping

- `@MutationMapping`:  相当于restful api里面的@PostMapping

- `@Argument`:  相当于restful api里面的@PathVariable

```java
    @Controller
    public class PostGraphQLController {
        private final PostService postService;

        public PostGraphQLController(PostService postService) {
            this.postService = postService;
        }

        /*
        @GetMapping("/{id}")
        public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
            return ResponseEntity.ok(postService.getPostById(id));
        }
        */
        @QueryMapping
        public PostDto getPostById(@Argument Long id){
            return postService.getPostById(id);
        }

        /*
        @PostMapping("/posts")
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
            PostDto postResponse = postService.createPost(postDto);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }
        */
        @MutationMapping
        public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
            PostDto postDto = new PostDto();

            postDto.setTitle(title);
            postDto.setDescription(description);
            postDto.setContent(content);

            return postService.createPost(postDto);
        }
    }
```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by MongoDB:

- `@Document`: Marks a class as a document for Spring Data MongoDB.
- `@Field`: Customizes the mapping of a field in a Spring Data MongoDB document.

    ```java
    @Document(collection = "post")
    public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        ...
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Transaction:

- `@Transactional`: 
    - manage the transcation, represents a unit of work. if one step fails, the whole transaction fails
    - 原子操作

    ```java
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
    ```

- `@EnableTransactionManagement`:
    - 开启transaction

    ```
    @SpringBootApplication
    @EnableTransactionManagement
    public class Hw10TransactionalApplication {

        public static void main(String[] args) {
            SpringApplication.run(Hw10TransactionalApplication.class, args);
        }
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Controller:

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

- `@RequestBody`: 
    - It binds the HTTP request body to a method parameter in a controller method. 
    - is used mainly for saving objects
    - It's used to extract data from the request body, especially in POST and PUT requests.
    - 接收HTTP请求的请求体作为方法参数

    ```java
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        // 将创建的帖子的 PostDto 对象封装在 ResponseEntity 中并返回。
        // 同时，使用 HTTP 状态码 HttpStatus.CREATED 表示请求成功创建了一个资源。
        return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
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

- `@PathVariable`:
    - extract values from the URI (e.g., /users/{id}) and bind them to method parameters in the controller handler method.
    - is used mainly for getting individual objects
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

- `@RequestParam`：
    - Used to extract query parameters from the request URL and bind them to method parameters in the controller handler method.
    - is used mainly for filtering purposes
    - 将 HTTP 请求中的查询参数（Query Parameters）与控制器方法的参数进行绑定。

    ```java
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
                return postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
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

# Annotations Used by Exception:
- `@ResponseStatus`:
    - 用于指示当抛出此异常时返回的 HTTP 状态码

-  `@ExceptionHandler`
    - Method Level
    - used to handle the specific exceptions and sending the custom responses to the client

-  `@ControllerAdvice`
    - Class Level
    - make this class be a bean
    - define global exception handling and to consolidate centralized exception handling logic for multiple controllers in a Spring MVC application.

    ```java
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        private String resourceName;
        private String fieldName;
        private long fieldValue;

        public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
            // Post not found with id : '1'
            super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
            this.resourceName = resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }

        省略getter and setter
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {

        /**
        * handler specific exceptions
        * @param exception
        * @param webRequest
        * @return
        */

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                    webRequest.getDescription(false));

            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                    webRequest.getDescription(false));

            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    ```





<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Validation:

-  `@Valid` 
    - add validation rule to payload, then add @Valid to controller to apply the rule.

    ```java
    public class PostDto {
    private Long id;
    /**
     * 1. title should not be null or empty
     * 2. title should have at least 2 characters
     * Question, our database have set it as nullable=false,
     * why do we need to set validation here? what is the benefits?
     * 在保证不为null的情况下，也要保证不为empty（null != empty）
     */
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @NotEmpty
    private String content;

    private Set<CommentDto> comments;

    省略getter and setter

    }

    // controller
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {

        @Autowired
        private PostService postService;

        @PostMapping()
        public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
            PostDto postResponse = postService.createPost(postDto);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }
    }

    // exception: global exception handler -> accept and handle
    ```





<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Bean Define:

- `@Component`
- `@Service`
- `@Repository`
- `@Controller`
- `@ContollerAdvice`

- `@Bean`: declare a method that produces a bean to be managed by the Spring container.

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public MyBean myBean() {
           return new MyBean();
       }
   }
   ```


<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Configiuration:

-  `@ComponentScan`:
    - specify the base packages to scan components
    
    ```java
    @Configuration
    @ComponentScan(basePackages = "com.example.package")
    public class BeanConfig {
        @Bean
        .....
    }
    ```

- `@SpringBootApplication`:
    - a combination of `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan`
    - `@Configuration`: marks a class as a source of bean definitions to define Spring beans using @Bean annotations within the class.
    - `@EnableAutoConfiguration`: allows the application to add beans using classpath definitions.
    - `@ComponentScan`: directs Spring to search for components in the path specified. 在哪里寻找@Component注解标记的组件类，以便自动注册它们到应用程序的上下文中

    ```java
    @SpringBootApplication
    public class SpringbasicApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringbasicApplication.class, args);
        }

    }
    ```

- `@Value` 
   - Usage: injects values from properties or configuration files and resolves them based on the property keys you specify in ${...} syntax. 
   - Explanation: Allows injection of external configuration values.

    ```java
    // in properties file
    app.title=My Application
    app.version=1.0
    app.api.key=secret_key

    // Inject Property Values:

    import org.springframework.beans.factory.annotation.Value;

    @Component
    public class MyComponent {
        @Value("${app.title}")
        private String applicationTitle;

        @Value("${app.version}")
        private String applicationVersion;

        @Value("${app.api.key}")
        private String apiKey;

        public void doSomething() {
            System.out.println("Title: " + applicationTitle);
            System.out.println("Version: " + applicationVersion);
            System.out.println("API Key: " + apiKey);
        }
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Dependency Injection:

- `@Autowired`:
   - Usage: Used for automatic injection of dependencies.
   - By Type > By Name

- `@Qualifier`
    - work with `@Autowired` to provide the name of bean to inject when there are multiple beans with same type.

- `Primary`
    - to indicate this bean is the primary bean for autowiring when there are multiple beans with same type and not define @Qualifier

    1. 如果只有一个impl,则默认用这个impl
    2. 如果有多个impl, 则查看是否有@Qualifier
    3. 如果有多个impl, 且无@Qualifier, 则查看是否有@Primary (因为这个是type level的)
    4. 如果有多个impl, 无@Qualifier, 且无@Primary, 按变量名(By Name)确定用哪一个
    5. 若无，则报错(NoUniqueBeanDefinitionException)

- `@Resource`:
    - inject beans by name by using the value of name.(By Name > By Type)

- `@Inject`: 
    - similar to `@Autowired` and can be used for bean injection by type.

    ```java
    @Component
    public class DependencyInjectionByTypeByName {
        /**
        * Match by type
        * 变量名您可以随意取
        */
        @Autowired
        private HibernateChuwa hibernate;

        /**
        * Match by Name
        * 变量名必须是某个子类的名称，且首字母小写,
        * 如果是来自于@Bean,则用的是方法名小写。
        */
        @Autowired
        private JpaChuwa hibernateChuwa;

        @Autowired
        private JpaChuwa eclipseLinkChuwa;

        @Autowired
        private JpaChuwa myDataNucleus;

        /**
        * wrong
        * NoUniqueBeanDefinitionException: No qualifying bean of type 'com.chuwa.springbasic.components.JpaChuwa'
        * available: expected single matching bean but found 3: eclipsedLinkChuwa,hibernateChuwa,myDataNucleus
        */
    //    @Autowired
    //    private JpaChuwa jpaChuwa;


        /**
        * Match by Qualifier
        * 变量名您随意起
        */
        @Autowired
        @Qualifier("hibernateChuwa")
        private JpaChuwa jpaChuwaQualifier;
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Bean Scope:

- `singleton`: 
    - the bean instance will created be only once and same instance will be returned by the IOC container
    - by using @Scope("singleton")
    - Configuration classes, utility classes, stateless services.

- `prototype`: 
    - the bean instance will be created each time when requested.
    - by using @Scope("prototype")
    - Objects that need to be uniquely instantiated each time, such as user sessions, shopping cart items.

- `request`: 
    - the bean instance will be created per HTTP request
    - by using @RequestScope
    - Web controllers, objects that need to be available during a single HTTP request.
    - Objects that need to be created anew for each HTTP request, like request-specific data processing, form handling objects.

- `session`: 
    - the bean instance will be created per HTTP session
    - by using @SessionScope
    - User-specific information stored across multiple requests, session-related data.

- `global-session(Portlet context)`:  
    - the bean instance will be created per HTTP global session. It can be used in portlet context only.
    - by using @Scope("globalSession")
    - Portlet-specific objects that need to be maintained across requests within a global session.

    ```java
    import org.springframework.context.annotation.Scope;
    import org.springframework.stereotype.Component;

    // Singleton Scope
    @Component
    @Scope("singleton")
    public class SingletonBean {
        // Implementation...
    }

    // Prototype Scope
    @Component
    @Scope("prototype")
    public class PrototypeBean {
        // Implementation...
    }

    // Request Scope (for web applications)
    import org.springframework.web.context.annotation.RequestScope;
    import org.springframework.stereotype.Component;

    @Component
    @RequestScope
    public class RequestScopedBean {
        // Implementation...
    }

    // Session Scope (for web applications)
    import org.springframework.web.context.annotation.SessionScope;
    import org.springframework.stereotype.Component;

    @Component
    @SessionScope
    public class SessionScopedBean {
        // Implementation...
    }


    // global-seesion Scope
    import org.springframework.context.annotation.Scope;
    import org.springframework.stereotype.Component;

    @Component
    @Scope("globalSession")
    public class MyGlobalSessionBean {
        // Implementation...
    }
    ```





<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Spring Security:

- `@EnableWebSecurity`: 
    - 是 Spring Security 用于启用Web安全的注解。典型的用法是该注解用在某个Web安全配置类上(实现了接口WebSecurityConfigurer或者继承自WebSecurityConfigurerAdapter)。
    - This annotation is used to enable Spring Security for your application. It should be placed on a configuration class that extends `WebSecurityConfigurerAdapter`. You can customize security settings by overriding methods in this class.

    ```java
    @Configuration
    @EnableWebSecurity
    public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    }
    ```

- `@EnableGlobalMethodSecurity`: 
    - 用于启用全局 方法 安全性。This annotation is used to enable method-level security globally in your application. 
    - You can specify which annotations to use for securing methods, such as `@Secured`, `@PreAuthorize`, etc.
    - 其中属性prePostEnabled和securedEnabled都是它的属性，分别表示是否允许使用`@PreAuthorize`和`@Secured`注解来控制方法的访问权限。
    - 当prePostEnabled为true时，表示允许使用@PreAuthorize和@Secured注解来控制方法的访问权限；当securedEnabled为true时，表示允许使用@Secured注解来控制方法的访问权限。

    ```java
    @Configuration
    // 属性prePostEnabled和securedEnabled都是它的属性，分别表示是否允许使用`@PreAuthorize`,`@Secured`和 `@RolesAllowed`注解来控制方法的访问权限。
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
    public class MethodSecurityConfig {
    }
    ```

- `@PreAuthorize`:
    - 通过使用 @PreAuthorize 注解，可以在方法执行之前进行对用户的权限进行校验，只有具备相应权限的用户才能执行被注解的方法。 支持Spring EL表达式.
    - 主要是配合以下的验证方法对用户进行权限验证hasRole(“manager”)、hasAnyAuthority(“admin”,“manager”)、hasAuthority(“admin”)、hasAnyRole(“admin”)

    ```java
    // 先开启注解功能
        @EnableGlobalMethodSecurity(prePostEnabled = true)
        public class SecurityConfig extends WebSecurityConfigurerAdapter {

        }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void adminOnlyMethod() {
        // Method that requires ROLE_ADMIN
    }
    ```

- `@PostAuthorize`: 
    - 在方法执行后再进行权限校验，适合验证带有返回值的权限。 可以使用内置的表达式returnObject表示方法的返回值

    ```java
    // 先开启注解功能
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

    }

    @PostAuthorize("hasAnyAuthority('write')")
    @RequestMapping(value = "/testPostAuthorize")
    @ResponseBody
    public String postAuthorize() {
        System.out.println("方法进入了。。。。");
        return "preAuthorize";
    }

    @PostAuthorize("returnObject.equals('PostAuthorize ok')")
    ```

- `@Secured`: 
    - 判断是否具有角色，注意这里匹配的字符串需要添加前缀ROLE_. 
    - This annotation is used to specify that a method requires specific roles or authorities to access it.

    ```java
    // 开启注解功能
    @EnableGlobalMethodSecurity(securedEnabled = true)
        public class SecurityConfig extends WebSecurityConfigurerAdapter {

        }

    @Secured("ROLE_USER")
    public void userMethod() {
        // Method that requires ROLE_USER
    }
    ```

- `@RolesAllowed`: 
    - Similar to `@Secured`, this annotation specifies the roles allowed to access a method. 
    - 该注解需要开启jsr250Enabled

    ```java

    @EnableGlobalMethodSecurity(jsr250Enabled = true)        /* 开启注解功能 */
        public class SecurityConfig extends WebSecurityConfigurerAdapter {

        }

    @RolesAllowed("ROLE_ADMIN")
    public void adminMethod() {
        // Method that requires ROLE_ADMIN
    }
    ```

- `@PreFilter` and `@PostFilter`： 
    - `@PreFilter` 用于在请求处理之前对请求进行过滤。该注解可以应用于方法级别或类级别，用于指定只有满足特定条件的请求才能通过过滤器。例如，我们可以使用@PreFilter注解来限制只有拥有特定角色的用户才能访问某个接口。
    - `@PostFilter`用于在请求处理之后对请求进行过滤，过滤返回的结果。该注解可以应用于方法级别或类级别，用于指定只有满足特定条件的请求才能通过过滤器。例如，我们可以使用@PostFilter注解来限制只有经过身份验证的用户才能访问某个接口。

    ```java
    RequestMapping("/getTestPreFilter")
    @PreFilter("hasRole('ADMIN')")
    @ResponseBody
    public List<UserPO> getTestPreFilter(@RequestBody List<UserPO> list) {
        list.forEach(t -> {
            System.out.println(t.getId() + "\t" + t.getUsername());
        });
        return list;
    }

    @RestController
    public class MyController {
        @PostFilter("hasRole('ADMIN')")
        @GetMapping("/admin")
        public String admin() {
            // ...
        }
    }

    // filterObject是执行过滤操作的内置对象。
    @PostFilter("filterObject.username == 'zhansan'") 	//这里指的是只返回username为zhangsan的内容
    ```

- `@AuthenticationPrincipal`: 
    - 用于获取当前用户的认证信息。它可以用于方法参数上，表示将当前用户的认证信息注入到该参数中。通常情况下，我们可以使用它来获取当前用户的用户名、角色、权限等信息，以便进行业务逻辑的处理。
    - This annotation is used to access the currently authenticated principal (user) directly in a method.

    ```java
    @GetMapping("/user-info")
    public String getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        // Access the authenticated user details
        return "User: " + userDetails.getUsername();
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Spring AOP:

- `@Aspect`：
    - indicate this is a aop class to define all aop self methods
    - 表明时一个aop class
    - 切面是pointcut和advice的集合，一般单独作为一个类。Pointcut和Advice共同定义了关于切面的全部内容，它是什么时候，在何时和何处完成功能。

- `@PointCut`：
    - expression to find all main application methods to insert advice - 集合/群体
    - 目标对象中实际被增强的方法。这是一组一个或多个切入点，在切点应该执行advice。

- `@JointPoint`：
    - 目标对象中可以被增强的方法

- `@Advice`：
    - before/after/around/afterThrowing - When to execute aop methods when the application pointcut is found.
    - 增强部分的代码逻辑


- `@Before`: 
    - Run before the method execution
    - 在方法执行之前执行advice
- `@After`： 
    - Run after the method returned a result
    - 在方法执行之后执行advice（不管目标方法是否有异常。最终都会执行）
- `@Around`： 
    - Run around the method execution, combine all three advices above
    - 在方法执行的前后执行advice，目标方法异常时，环绕后方法不再执行

- `@After-returning`：
    - Run after the method returned a result, intercept the returned result as well
    - 在方法执行之后执行advice，目标方法异常时，不再执行
    - returning = "result": When a method that is intercepted by the advice annotated with @AfterReturning returns a result, you can capture that result in a parameter named result.
- `@After-throwing`： 
    - Run after the method throws an exception
    - 在方法抛出异常后执行advice
    - throwing = "exception": When a method that is intercepted by the advice annotated with @AfterThrowing throws an exception, you can capture that exception in a parameter named exception.

- `@Introduction`：
    - 引用允许我们向现有的类添加新的方法或者属性

- `@Weaving`：
    - 将advice和pointcut组合动态组合的过程
    

    ```java

    // Create a Service Class
    public class MyService {
        public void doSomething() {
            System.out.println("Doing something...");
        }

        public void doSomethingElse() {
            System.out.println("Doing something else...");
            throw new RuntimeException("An error occurred.");
        }
    }

    // Create an Aspect Class
    import org.aspectj.lang.annotation.*;
    import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class MyAspect {

        // define a Pointcut named serviceMethods, which matches all methods in the MyService class.
        @Pointcut("execution(* com.example.MyService.*(..))")    
        public void serviceMethods() {}

        // runs before the methods matched by the serviceMethods pointcut
        @Before("serviceMethods()")
        public void beforeServiceMethods() {
            System.out.println("Before executing service methods.");
        }

        @After("serviceMethods()")
        public void afterServiceMethods() {
            System.out.println("After executing service methods.");
        }

        @Around("serviceMethods()")
        public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("Before executing service methods with @Around.");
            Object result = joinPoint.proceed(); // Proceed with the original method.
            System.out.println("After executing service methods with @Around.");
            return result;
        }

        @AfterReturning(pointcut = "serviceMethods()", returning = "result")
        public void afterReturningServiceMethods(Object result) {
            System.out.println("After returning from service methods with result: " + result);
        }

        @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
        public void afterThrowingServiceMethods(Exception exception) {
            System.out.println("Exception occurred in service methods: " + exception.getMessage());
        }
    }
    ```





<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Spring Batch(aka Corn):

- `@EnableBatchProcessing`: 
    - 支持所有所需spring batch特性。它还提供了设置批处理job的基本配置。

- `@EnableScheduling`: 
    - Make sure that scheduling is enabled in your Spring application

- `@Scheduled`:  
    - @Scheduled(cron = "0 0 1 * * ?") 
    - Ensure that the cron expression in the @Scheduled annotation matches your desired schedule. 

    ```java
    @SpringBootApplication
    @EnableScheduling
    public class YourApplication {
        public static void main(String[] args) {
            SpringApplication.run(YourApplication.class, args);
        }
    }

    @Component
    public class BatchJobScheduler {
        @Autowired
        private JobLauncher jobLauncher;

        @Autowired
        private Job myBatchJob;

        @Scheduled(cron = "0 0 1 * * ?") // Cron expression for daily execution at 1:00 AM
        public void runBatchJob() throws Exception {
            JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

            jobLauncher.run(myBatchJob, jobParameters);
        }
    }
    ```




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Unit testing：

- `@BeforeClass/@BeforeAll`: 
    - Run once before all test methods in the test class.
    - These methods typically perform setup tasks that are shared among all test methods in the class, such as setting up database connections or initializing common resources.

- `@BeforeEach`: 
    - Marks a method to be run before each test method.
    - These methods perform test-specific setup tasks, such as creating or configuring objects needed for the test.

- `@Test`: 
    - Indicates that the method is a test method.
    - This is where the actual testing takes place, and assertions are used to verify that the code under test behaves as expected.

- `@AfterEach`: 
    - Marks a method to be run after each test method.
    - These methods perform cleanup tasks specific to the test, such as releasing resources or cleaning up objects created during the test.

- `@AfterClass/AfterAll`: 
    - Run once after all test methods in the test class.
    - These methods perform cleanup tasks that are shared among all test methods in the class. They release any resources acquired during the class-level setup.


- `@Mock`: 
    - create a mock object in a test class

- `@InjectMocks`: 
    - create an instance of the class under test and inject the dependencies annotated with @Mock into this instance.

- `@Spy`: 
    - initialze a real instance of the test class, but still can do stubbing to define specific behaviors or return values for method calls on spy objects.

- `@SpringBootTest`:  
    - Indicates that the test is a Spring Boot test and loads the Spring application context.

- `@ExtendWith(MockitoExtension.class)`:
    - enables the Mockito extension, allowing the usage of Mockito annotations such as @Mock and @InjectMocks within the test methods.


    ```java
    import org.junit.jupiter.api.*;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.boot.test.mock.mockito.MockBean;
    import org.springframework.boot.test.mock.mockito.SpyBean;
    import org.springframework.boot.test.context.SpringBootTest;
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.mockito.Mockito.when;

    @SpringBootTest
    @ExtendWith(MockitoExtension.class)
    public class MySpringBootTest {

        @Mock
        private MyService myService;

        @Spy
        private MyRepository myRepository;

        @InjectMocks
        private MyController myController;

        @BeforeAll
        static void setUpBeforeAll() {
            // Initialization code that runs once before all test methods.
        }

        @AfterAll
        static void tearDownAfterAll() {
            // Cleanup code that runs once after all test methods.
        }

        @BeforeEach
        void setUp() {
            // Initialization code that runs before each test method.
        }

        @AfterEach
        void tearDown() {
            // Cleanup code that runs after each test method.
        }

        @Test
        void testMyController() {
            // Define the behavior of mocked and spied beans using Mockito.
            when(myService.doSomething()).thenReturn("Mocked Result");
            myRepository.setSomeValue("Spy Value");

            // Test the controller using @InjectMocks
            String result = myController.processRequest();

            assertEquals("Mocked Result: Spy Value", result);
        }
    }
    ```
