helper: https://zhuanlan.zhihu.com/p/137507309

**Annotations Used by Controller (Spring MVC):**

- `@Controller` Controller层
- `@RestController`: 该注解为一个组合注解，相当于@Controller和@ResponseBody的组合，注解在类上，意味着，该Controller的所有方法都默认加上了@ResponseBody。
- `@ControllerAdvice`: 通过该注解，我们可以将对于控制器的全局配置放置在同一个位置，注解了@Controller的类的方法可使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上，这对所有注解了 @RequestMapping的控制器内的方法有效。
- `@EnableWebMvc`: 在配置类中开启Web MVC的配置支持，如一些ViewResolver或者MessageConverter等，若无此句，重写WebMvcConfigurerAdapter方法（用于对SpringMVC的配置）。

- `@RequestMapping` :@RequestMapping(“/path”)表示该控制器处理所有“/path”的UR L请求。RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。
用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。该注解有六个属性：
    - `params`:指定request中必须包含某些参数值是，才让该方法处理。
    - `headers`:指定request中必须包含某些指定的header值，才能让该方法处理请求。
    - `value`:指定请求的实际地址，指定的地址可以是URI Template 模式
    - `method`:指定请求的method类型， GET、POST、PUT、DELETE等
    - `consumes`:指定处理请求的提交内容类型（Content-Type），如application/json,text/html;
    - `produces`:指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回

- `@RequestParam`：用在方法的参数前面。
- `@PathVariable`  从URI抓取元素, 用于接收路径参数，比如@RequestMapping(“/hello/{name}”)申明的路径，将注解放在参数中前，即可获取该值，通常作为Restful的接口实现方法。

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- `@ResponseBody` : 支持将返回值放在response内，而不是一个页面，通常用户返回json数据（返回值旁或方法上）
- `@RequestBody`: 允许request的参数在request体中，而不是在直接连接在地址后面。（放在参数前）

<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
**Global Exception Handler Annotations:**
- `@ExceptionHandler`:（Exception.class）：用在方法上面表示遇到这个异常就执行以下方法, 用于全局处理控制器里的异常.
- `@InitBinder`: 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。
- `@ModelAttribute`: 本来的作用是绑定键值对到Model里，在@ControllerAdvice中是让全局的@RequestMapping都能获得在此处设置的键值对。

<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
## Spring Data

### annotations:
**Annotations Used by Entity (JPA/Hibernate):**

1. `@Repository`: 表示为数据层

2.  `@Entity`: 
    - Applied to a Java class to mark it as a JPA entity, representing a table in the database.
    - 表示数据库的一个table, 表明这是一个实体类。一般用于jpa这两个注解一块使用，但是如果表名和实体类名相同的话，@Table可以省略
3. `@Table`:
    - specify the details of the database table to which the entity is mapped
    - table的details, specifies the table name associated with an entity class.
4.  `@Id` :
    - specify the primary key of an entity. It marks a field as the unique identifier of the entity.
    - primary key in a table 表示该属性为主键。

5. `@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = “repair_seq”)` :
    - specify how the primary key value is generated. It is often used in conjunction with @Id. Options include AUTO, IDENTITY, SEQUENCE, and TABLE.
    - 和`@Id`一起使用，注明primary key是怎么生成的, name为sequence的名称，以便使用，sequenceName为数据库的sequence名称，两个名称可以一致。


6. `@Column` database column
   - specify the mapping of a field to a database column. It allows you to customize column properties like name, length, and whether it's nullable.
   - 

7. `@OneToOne`：对应hibernate配置文件中的一对一。

8. `@OneToMany` and `@ManyToOne`：
    - specify one-to-many and many-to-one relationships between entities.
    - 对应hibernate配置文件中的一对多和多对一.

9. `@ManyToMany`: 
    - specify a many-to-many relationship between entities.
    - 对应hibernate配置文件中的多对多。

10. `@Transient`：
    - mark a field as not persistable in the database. It's used for non-persistent fields.
    - 表示属性并非数据库表字段的映射,ORM框架将忽略该属性

11. `@JsonIgnore`：作用是json序列化时将Java bean中的一些属性忽略掉,序列化和反序列化都受影响。

12. `@JoinColumn（name=”loginId”）`:
    - specify the column that is used for joining in a relationship.
    - 一对一：本表中指向另一个表的外键。一对多：另一个表指向本表的外键。

13. `@JoinTable`:
    - define the join table for a many-to-many relationship
    - 

14. `@NoRepositoryBean`:
    -  父类的repository 
    - 一般用作父类的repository，有这个注解，spring不会去实例化该repository。有时我们想要创建存储库接口，其唯一目标是为子存储库提供通用方法。也就是说，使用了该注解的接口不会被单独创建实例，只会作为其他接口的父接口而被使用。这个公共接口就需要这个注解@NoRepositoryBean来标识。

```java
// 如果我们想在所有存储库中使用Optional findById（ID id） 方法，我们可以创建一个基本存储库：
@NoRepositoryBean
interface MyUtilityRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
       Optional<T> findById(ID id);
}
// 此注解不会影响子接口; 因此Spring将为以下子存储库接口创建一个bean：
@Repository
interface PersonRepository extends MyUtilityRepository<Person, Long> {}
```

```java
import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.repository.NoRepositoryBean;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Transient
    private String confirmEmail;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // Getters and setters, other methods
}
```
```java
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters, other methods
}
```

```java
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    // Getters and setters, other methods
}
```
```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    // Getters and setters, other methods
}
```
```java
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    // Getters and setters, other methods
}
```
```java
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    // Custom repository methods can be defined here
}
```


**Annotations Used by JPQL:**
1.  `@NamedQuery` : Used to define a named query at the entity level for JPA entities.
2.  `@Query` : 
    - Allows you to define custom queries for a Spring Data repository using JPQL (Java Persistence Query Language) or native SQL.
    - 可以为存储库方法提供JPQL实现
```java
import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    // Getters and setters

    // Constructors

    // Other fields and methods
}
```
```java
/*
can use the named query "User.findByRole" to retrieve users by their roles using the EntityManager. Here's an example of how you might use this named query in your Java code:

In this example, the named query "User.findByRole" is defined to select users based on their role. The @NamedQuery annotation associates this query with the User entity. The createNamedQuery method in the repository is used to execute the query and retrieve the list of users with the specified role.
*/
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserRepository {

    private EntityManager entityManager;

    public UserRepository() {
        entityManager = Persistence.createEntityManagerFactory("YourPersistenceUnit").createEntityManager();
    }

    public List<User> findUsersByRole(String role) {
        return entityManager.createNamedQuery("User.findByRole", User.class)
                .setParameter("role", role)
                .getResultList();
    }

    // Other repository methods
}
```

**Annotations Used by MongoDB:**
1. `@Document`: Marks a class as a document for Spring Data MongoDB.
2. `@Field`: Customizes the mapping of a field in a Spring Data MongoDB document.

**Annotations Used by Redis:**
1. `@NoSqlHash`: Specifies the name of the hash key for a Spring Data Redis entity.

**Annotations Used by Transaction:**
1. `@Transactional`: 配置方法的事务行为，保持原子性
2. `@EnableTransactionManagement` 开启注解式事务的支持

```java
/*
Let's assume you have a Spring application with a service class that performs database operations. You want to use Spring's transaction management annotations to ensure that these operations are executed within a transaction.

In this example:

The @Service annotation marks the UserService class as a Spring service component.
The @Transactional annotation is applied to the createUser method. This annotation indicates that the method should be executed within a transaction. If the method completes without errors, the transaction is committed, and changes are persisted to the database. If an exception is thrown, the transaction is rolled back, ensuring data consistency.
The UserRepository is assumed to be a Spring Data JPA repository or a similar data access component for managing user data.
By using @Transactional, you delegate the management of transactions to Spring, which will automatically begin, commit, or roll back transactions based on the method's execution. This ensures that the createUser method either saves the user and commits the transaction or rolls back the transaction if any errors occur during the process.
*/

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(String username, String email) {
        User user = new User(username, email);
        return userRepository.save(user);
    }
}
```

<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
## Spring Security:

### annotations:

1. `@EnableWebSecurity`: 是 Spring Security 用于启用Web安全的注解。典型的用法是该注解用在某个Web安全配置类上(实现了接口WebSecurityConfigurer或者继承自WebSecurityConfigurerAdapter)。This annotation is used to enable Spring Security for your application. It should be placed on a configuration class that extends `WebSecurityConfigurerAdapter`. You can customize security settings by overriding methods in this class.

2. `@EnableGlobalMethodSecurity`: 用于启用<u>全局 方法 安全性</u>。This annotation is used to <u>enable method-level security globally in your application</u>. 

    You can specify which annotations to use for securing methods, such as `@Secured`, `@PreAuthorize`, etc.

    其中属性prePostEnabled和securedEnabled都是它的属性，分别表示是否允许使用`@PreAuthorize`和`@Secured`注解来控制方法的访问权限。
    当prePostEnabled为true时，表示允许使用@PreAuthorize和@Secured注解来控制方法的访问权限；当securedEnabled为true时，表示允许使用@Secured注解来控制方法的访问权限。

3. `@PreAuthorize`:通过使用 @PreAuthorize 注解，可以<u>在方法执行之前进行对用户的权限进行校验，只有具备相应权限的用户才能执行被注解的方法</u>。 支持Spring EL表达式.

    主要是配合以下的验证方法对用户进行权限验证hasRole(“manager”)、hasAnyAuthority(“admin”,“manager”)、hasAuthority(“admin”)、hasAnyRole(“admin”)

4. `@PostAuthorize`: <u>在方法执行后再进行权限校验，适合验证带有返回值的权限</u>。 可以使用内置的表达式returnObject表示方法的返回值

5. `@Secured`: 判断是否具有角色，注意这里匹配的字符串需要添加前缀ROLE_. This annotation is used to specify that a method requires specific roles or authorities to access it.

6. `@RolesAllowed`: Similar to `@Secured`, this annotation specifies the roles allowed to access a method. 该注解需要开启jsr250Enabled

7. `@PreFilter` and `@PostFilter`： 
    - `@PreFilter` 用于<u>在请求处理之前对请求进行过滤</u>。该注解可以应用于方法级别或类级别，用于指定只有满足特定条件的请求才能通过过滤器。例如，我们可以使用@PreFilter注解来限制只有拥有特定角色的用户才能访问某个接口。
    - `@PostFilter`用于<u>在请求处理之后对请求进行过滤，过滤返回的结果</u>。该注解可以应用于方法级别或类级别，用于指定只有满足特定条件的请求才能通过过滤器。例如，我们可以使用@PostFilter注解来限制只有经过身份验证的用户才能访问某个接口。

8. `@AuthenticationPrincipal`: 用于获取当前用户的认证信息。它可以用于方法参数上，表示将当前用户的认证信息注入到该参数中。通常情况下，我们可以使用它来获取当前用户的用户名、角色、权限等信息，以便进行业务逻辑的处理。This annotation is used to access the currently authenticated principal (user) directly in a method.


### example:

1. `@EnableWebSecurity`:
    ```java
    @Configuration
    @EnableWebSecurity
    public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    }

2. `@EnableGlobalMethodSecurity`: This annotation is used to enable method-level security globally in your application. You can specify which annotations to use for securing methods, such as `@Secured`, `@PreAuthorize`, etc. For example:

   ```java
   @Configuration
   // 属性prePostEnabled和securedEnabled都是它的属性，分别表示是否允许使用`@PreAuthorize`,`@Secured`和 `@RolesAllowed`注解来控制方法的访问权限。
   @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
   public class MethodSecurityConfig {
   }
   ```

3. `@PreAuthorize`:

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

4. `@PostAuthorize`:

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

5. `@Secured`: This annotation is used to specify that a method requires specific roles or authorities to access it. For example:

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

6. `@RolesAllowed`: Similar to `@Secured`, this annotation specifies the roles allowed to access a method. For example:

   ```java

   @EnableGlobalMethodSecurity(jsr250Enabled = true)        /* 开启注解功能 */
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

    }

   @RolesAllowed("ROLE_ADMIN")
   public void adminMethod() {
       // Method that requires ROLE_ADMIN
   }
   ```

7. `@PreFilter` and `@PostFilter`： 
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

8. `@AuthenticationPrincipal`: This annotation is used to access the currently authenticated principal (user) directly in a method. For example:

   ```java
   @GetMapping("/user-info")
   public String getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
       // Access the authenticated user details
       return "User: " + userDetails.getUsername();
   }
   ```

<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
## Spring AOP:

### annotations:
1. `@Aspect`：
    - indicate this is a aop class to define all aop self methods
    - 表明时一个aop class
    - 切面是pointcut和advice的集合，一般单独作为一个类。Pointcut和Advice共同定义了关于切面的全部内容，它是什么时候，在何时和何处完成功能。


2. `@PointCut`：
    - expression to find all main application methods to insert advice - 集合/群体
    - 目标对象中实际被增强的方法。这是一组一个或多个切入点，在切点应该执行advice。

3. `@Advice`：
    - before/after/around/afterThrowing - When to execute aop methods when the application pointcut is found.
    - 增强部分的代码逻辑

4. `@Component` 
    - This annotation mark the beans as Spring’s managed components

![aop]()

5. `@Before`: 
    - Run before the method execution
    - 在方法执行之前执行advice
6. `@After`： 
    - Run after the method returned a result
    - 在方法执行之后执行advice（不管目标方法是否有异常。最终都会执行）
7. `@Around`： 
    - Run around the method execution, combine all three advices above
    - 在方法执行的前后执行advice，目标方法异常时，环绕后方法不再执行

8. `@After-returning`：
    - Run after the method returned a result, intercept the returned result as well
    - 在方法执行之后执行advice，目标方法异常时，不再执行
    - returning = "result": When a method that is intercepted by the advice annotated with @AfterReturning returns a result, you can capture that result in a parameter named result.
9. `@After-throwing`： 
    - Run after the method throws an exception
    - 在方法抛出异常后执行advice
    - throwing = "exception": When a method that is intercepted by the advice annotated with @AfterThrowing throws an exception, you can capture that exception in a parameter named exception.

`@Introduction`：
    - 引用允许我们向现有的类添加新的方法或者属性

`@Weaving`：
    - 将advice和pointcut组合动态组合的过程
    
`@JointPoint`：
    - 目标对象中可以被增强的方法


### examples:
1. **Create a Service Class**:

```java
public class MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }

    public void doSomethingElse() {
        System.out.println("Doing something else...");
        throw new RuntimeException("An error occurred.");
    }
}
```

2. **Create an Aspect Class**:

```java
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
Now, when you call methods in the `MyService` class, these aspect methods will be executed before and after the target methods.


<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
## Spring Batch
1. `@EnableBatchProcessing`: 支持所有所需spring batch特性。它还提供了设置批处理job的基本配置。
2. `@EnableScheduling`: Make sure that scheduling is enabled in your Spring application
3. `@Scheduled`:  
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
## Spring testing

### annotations:
1. `@Test`: Indicates that the method is a test method.
2. `@BeforeClass/@BeforeAll`: Run once before all test methods in the test class.
3. `@AfterClass/AfterAll`: Run once after all test methods in the test class.
4. `@BeforeEach`: Marks a method to be run before each test method.
5. `@AfterEach`: Marks a method to be run after each test method.

6. `@SpringBootTest`:  Indicates that the test is a Spring Boot test and loads the Spring application context.
7. `@Mock`: Creates a mock instance of a Spring bean when used with @SpringBootTest. It is used to replace a real bean with a mock for testing purposes.
8. `@Spy`: Creates a spy instance of a Spring bean when used with @SpringBootTest. It is used to create a partially mocked instance of a bean, allowing some methods to behave as real implementations while others can be mocked.
9. `@InjectMocks`: Injects dependencies into a class, primarily used for injecting mocks into the class under test. It simplifies the process of injecting mock objects into a class and can be used with @MockBean and @SpyBean.

### example:
```java
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MySpringBootTest {

    @MockBean
    private MyService myService;

    @SpyBean
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

<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->
**General Purpose Annotations:**

1. `@Autowired` 自动注入
2. `@Service`, `@Repository`, `@Component` 标明是哪一层
3. `@Configuration` 设置层
4. `@Bean` 设置为bean（object）
5. `@Value` 
6. `@Conditional`

**@Enable*注解说明:**
- `@EnableAspectJAutoProxy` 开启对AspectJ自动代理的支持
- `@EnableAsync` 开启异步方法的支持
- `@EnableScheduling` 开启计划任务的支持
- `@EnableWebMvc` 开启Web MVC的配置支持
- `@EnableConfigurationProperties` 开启对@ConfigurationProperties注解配置Bean的支持
- `@EnableJpaRepositories` 开启对SpringData JPA Repository的支持
- `@EnableTransactionManagement` 开启注解式事务的支持
- `@EnableCaching` 开启注解式的缓存支持









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


