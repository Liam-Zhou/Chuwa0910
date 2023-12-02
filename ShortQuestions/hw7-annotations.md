# Annotations Used by Entity (JPA/Hibernate):

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




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Controller (Spring MVC):

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

# Annotations Used by Exception:

- `@ExceptionHandler`:（Exception.class）：用在方法上面表示遇到这个异常就执行以下方法, 用于全局处理控制器里的异常.
- `@InitBinder`: 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。
- `@ModelAttribute`: 本来的作用是绑定键值对到Model里，在@ControllerAdvice中是让全局的@RequestMapping都能获得在此处设置的键值对。




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

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




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by MongoDB:**
1. `@Document`: Marks a class as a document for Spring Data MongoDB.
2. `@Field`: Customizes the mapping of a field in a Spring Data MongoDB document.




<!-- 分割线------------------------------------------------------------------------------------------------------------------------------- -->

# Annotations Used by Redis:**
1. `@NoSqlHash`: Specifies the name of the hash key for a Spring Data Redis entity.