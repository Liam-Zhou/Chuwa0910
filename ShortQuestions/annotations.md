helper: https://zhuanlan.zhihu.com/p/137507309

**Annotations Used by Entity (JPA/Hibernate):**

- `@Entity` 表示数据库的一个table, 表明这是一个实体类。一般用于jpa这两个注解一般一块使用，但是如果表名和实体类名相同的话，@Table可以省略
- `@Table` table的details
- `@Id` primary key in a table 表示该属性为主键。
- `@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = “repair_seq”)` 和`@Id`一起使用，注明primary key是怎么生成的,name为sequence的名称，以便使用，sequenceName为数据库的sequence名称，两个名称可以一致。
- `@Column`: database column
- `@OneToOne`：对应hibernate配置文件中的一对一。
- `@OneToMany`：对应hibernate配置文件中的一对多.
- `@ManyToOne`：对应hibernate配置文件中的多对一。
- `@Transient`：表示该属性并非一个到数据库表的字段的映射,ORM框架将忽略该属性。如果一个属性并非数据库表的字段映射,就务必将其标示为@Transient,否则,ORM框架默认其注解为@Basic。@Basic(fetch=FetchType.LAZY)：标记可以指定实体属性的加载方式
- `@JsonIgnore`：作用是json序列化时将Java bean中的一些属性忽略掉,序列化和反序列化都受影响。
- `@JoinColumn（name=”loginId”）`:一对一：本表中指向另一个表的外键。一对多：另一个表指向本表的外键。
- `@MappedSuperClass`: 用在确定是父类的entity上。父类的属性子类可以继承
- `@NoRepositoryBean`:一般用作父类的repository，有这个注解，spring不会去实例化该repository。

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

**Global Exception Handler Annotations:**
- `@ExceptionHandler`:（Exception.class）：用在方法上面表示遇到这个异常就执行以下方法, 用于全局处理控制器里的异常.
- `@InitBinder`: 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。
- `@ModelAttribute`: 本来的作用是绑定键值对到Model里，在@ControllerAdvice中是让全局的@RequestMapping都能获得在此处设置的键值对。

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
- `@EnableTransactionManagement` 开启注解式事务的支持
- `@EnableCaching` 开启注解式的缓存支持

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