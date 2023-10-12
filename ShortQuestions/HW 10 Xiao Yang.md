# HW10 Xiao Yang

### 1. List all of the annotations you learned from class and homework to 
[See Here](annotations.md)
### 2.  Type the Comment feature for the class project.

### 3.  In postman, call of the APIs in PostController and CommentController.

### 4.  what is JPA? and what is Hibernate?
- `JPA` is a Java specification for accessing, managing, and persisting data between Java objects and a relational database. It provides a set of standardized interfaces and annotations for mapping Java objects to database tables and for querying databases using Java programming.
- `Hibernate` is a popular and widely used ORM framework for Java that implements the JPA specification and more.
It is an open-source project that provides a comprehensive set of features for mapping Java objects to database tables and managing database interactions.

### 5.  What is Hikari? what is the benefits of connection pool?
`Hikari` is a popular Java-based connection pooling library. Connection pooling is a database optimization technique that manages and recycles database connections, improving the efficiency and performance of database operations.
Here are the benefits of using Hikari:
- Configuration and Tuning: Many connection pool libraries, like HikariCP, offer extensive configuration options to fine-tune pool behavior, such as connection timeout, maximum pool size, and validation queries.
- Concurrency Management: Connection pools can help manage concurrent access to the database, ensuring that multiple threads or users do not interfere with each other when using database connections.
- Reduced Overhead: Establishing a new database connection is an expensive operation in terms of time and resources. Connection pooling reduces this overhead by reusing existing connections. This results in faster response times for database operations.
- Connection Recycling: Connections in a pool are regularly checked for validity and, if necessary, are replaced with new connections. This helps address issues like "stale" or "dead" database connections.

### 6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany, @ManyToOne, and @ManyToMany are JPA annotations used to define and map relationships between entities in a Java-based application when working with relational databases. These annotations are commonly used for object-relational mapping, allowing you to express relationships such as one-to-many, many-to-one, and many-to-many. Here are some examples of how these annotations are used:
- @ManyToOne and @OneToMany
```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Other department fields
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Other employee fields
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

- @ManyToMany
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Other student fields
    
    @ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Other course fields
    
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
```

### 7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

In JPA, the cascade and orphanRemoval attributes are used to define how changes to an entity should propagate to related entities when dealing with entity relationships, especially in the context of parent-child relationships. These attributes allow you to control the cascading of certain operations (e.g., persist, merge, remove) and the removal of orphaned entities (i.e., entities that are no longer associated with any parent entity).
Here are some common CascadeType values and their features:

- CascadeType.PERSIST:
When a parent entity is persisted, child entities are also persisted.Child entities are not automatically removed when the parent is removed.

CascadeType.MERGE:When a parent entity is merged, child entities are also merged.Child entities are not automatically removed when the parent is removed.

- CascadeType.REMOVE:
When a parent entity is removed, child entities are also removed.This can be useful for ensuring that all related entities are removed when a parent entity is deleted.

- CascadeType.REFRESH:
When a parent entity is refreshed, child entities are also refreshed.This is typically used to ensure that related entities have the latest data from the database.
- CascadeType.DETACH:
When a parent entity is detached, child entities are also detached. Detaching entities can be useful for certain use cases, such as transferring entities between different persistence contexts.
- CascadeType.ALL:
This is a shorthand for all cascade operations, including PERSIST, MERGE, REMOVE, REFRESH, and DETACH.
- CascadeType.DETACH:
Specifies that the child entities should be detached when the parent entity is detached.
- CascadeType.NONE:
Specifies that no cascade operations should be applied.

The choice of cascade type should align with the behavior you desire for the particular relationship in your application. Additionally, consider orphanRemoval = true when you want orphaned child entities to be automatically removed from the database when they are removed from the parent's collection.

### 8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
In JPA, the `fetch` attribute is used to specify how related entities should be loaded from the database when querying for an entity with associations.
When an association is marked as FetchType.LAZY, the related entities are loaded from the database only when you access (or "fetch") the association explicitly in your code.
When an association is marked as FetchType.EAGER, the related entities are loaded from the database immediately along with the owning entity when you retrieve it from the database.

### 9.  What is the rule of JPA naming convention? Shall we implement the method by  ourselves? Could you list some examples?
JPA has naming conventions that help map entity classes and their properties to database tables and columns. Adhering to these naming conventions allows JPA to automatically handle the mapping between your Java entities and the database without the need for custom configuration. However, these conventions can be overridden or customized when necessary.

Here are some common JPA naming conventions:
- Entity Class Names: By default, JPA uses the simple class name (without the package) as the default table name. You can override the table name using the @Table annotation on the entity class.
- Entity Properties:
By default, JPA maps Java entity properties to columns in the database using the property name. For instance, a Java property named firstName maps to a database column named first_name. You can override the column name using the @Column annotation.
- Primary Key Property:
By default, JPA assumes that the property with the @Id annotation is the primary key. You can use @Id to mark the primary key property explicitly.
- Association Properties (Foreign Keys):
JPA maps association properties (e.g., @ManyToOne, @OneToMany) to foreign keys in the database. The association property's name is used to derive the name of the foreign key column.
-Underscore vs. CamelCase:
Depending on the database system and JPA provider, there might be differences in how names are converted. Some databases prefer underscores, while JPA and Java typically use camelCase. JPA providers often handle these conversions for you.

### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

### 12. (Optional) use JDBC to read the data from database.

### 13. Type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

### 14. What is JPQL?

JPQL stands for Java Persistence Query Language. It is a query language defined as part of the Java Persistence API (JPA) specification. JPQL is used to query data from a relational database using an object-oriented syntax, similar to SQL but tailored to work with JPA entities, rather than database tables.


### 15. What is @NamedQuery and @NamedQueries?
- @NamedQuery: This annotation is used to define a single named query for an entity class. You associate the annotation with a specific entity class and provide the query string and a unique name for the query.

- @NamedQueries: This annotation is used to define multiple named queries for an entity class. You can define multiple @NamedQuery annotations within @NamedQueries, each with a unique name and associated query string.

```java
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "findEmployeeById", query = "SELECT e FROM Employee e WHERE e.id = :id")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // Other properties and methods
}

```
The @NamedQuery annotation defines two named queries for the Employee entity: "findAllEmployees" and "findEmployeeById."
The "findAllEmployees" query retrieves all employees from the database.
The "findEmployeeById" query retrieves an employee by their id, and it is a parameterized query with a named parameter :id.
### 16. What is @Query? In which Interface we write the sql or JPQL?
In JPA, the @Query annotation is used to define custom queries for retrieving data from a database. This annotation allows you to write SQL (Structured Query Language) queries or JPQL (Java Persistence Query Language) queries and associate them with methods in your repository interfaces.
The @Query annotation is typically used in repository interfaces that extend the JpaRepository or similar repository interfaces provided by Spring Data JPA.
Repository interfaces define methods for data access, and you can use the @Query annotation to specify custom queries for these methods.

### 17.  What is HQL and Criteria Queries?

### 18. What is EnityManager?

### 19. What is SessionFactory and Session?
### 20. What is Transaction? how to manage your transaction?

### 21. What is hibernate Caching?

### 22. What is the difference between first-level cache and second-level cache?

### 23. How do you understand @Transactional? (不要clone，要自己抄写并测试transactional，https://github.com/TAIsRich/tutorial-transaction)

### 24. Write a simple factory design patter