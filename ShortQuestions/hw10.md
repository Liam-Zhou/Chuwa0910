### 1. List all of the annotations you learned from class and homework to annotaitons.md

Here is a list of all the annotations I learned from class and homework:

* @Entity: Marks a class as an entity that can be persisted to a database.
* @Id: Marks a field as the primary key of an entity.
* @GeneratedValue: Marks a field as a generated value, such as an auto-incrementing ID.
* @Column: Marks a field as a column in a database table.
* @Table: Marks a class as being mapped to a specific database table.
* @OneToOne: Marks a relationship between two entities where each entity can only have one other entity.
* @OneToMany: Marks a relationship between two entities where each entity can have many other entities.
* @ManyToOne: Marks a relationship between two entities where each entity can only have one other entity.
* @ManyToMany: Marks a relationship between two entities where each entity can have many other entities.
* @Embedded: Marks a field as being embedded in the database table of the containing entity.
* @Transient: Marks a field as being ignored by JPA.
* @Inheritance: Marks a class as being an inheritance strategy for other entities.
* @DiscriminatorColumn: Specifies the column that is used to store the discriminator value for an inheritance strategy.
* @DiscriminatorValue: Specifies the discriminator value for an entity in an inheritance strategy.
* @SequenceGenerator: Specifies a sequence generator to be used for generating values for a field.
* @TableGenerator: Specifies a table generator to be used for generating values for a field.
* @NamedQuery: Specifies a named query that can be executed using JPA.


### 4.	what is JPA? and what is Hibernate?

* JPA (Java Persistence API): JPA is a Java specification for accessing, managing, and persisting data between Java objects and relational databases. It provides a standard way for Java applications to interact with databases.

* Hibernate: Hibernate is a popular, open-source implementation of the Java Persistence API (JPA). It is a powerful and flexible framework for Java applications to interact with databases. Hibernate provides an object-relational
mapping (ORM) solution to map Java objects to database tables and vice versa.

### 5.	What is Hiraki? what is the benefits of connection pool?

Hiraki is a connection pool for PostgreSQL. It is designed to improve the performance and scalability of PostgreSQL applications.

The benefits of connection pool include:

* Improved performance: Connection pools can improve the performance of database applications by reducing the number of times that a new connection needs to be created.
* Increased scalability: Connection pools can increase the scalability of database applications by allowing more connections to be open simultaneously.
* Reduced costs: Connection pools can reduce the costs of running database applications by reducing the number of database connections that need to be maintained.
  
### 6.	What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany: This annotation is used to map a one-to-many relationship between two entities. For example, a Post entity can have many Comment entities.

Example:

```Java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    // getters and setters
}

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private Post post;

    // getters and setters
}
```
@ManyToOne: This annotation is used to map a many-to-one relationship between two entities. For example, a Comment entity can only belong to one Post entity.

Example:

```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // getters and setters
}

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private Post post;

    // getters and setters
}
```

@ManyToMany: This annotation is used to map a many-to-many relationship between two entities. For example, a User entity can belong to many Role entities, and a Role entity can have many User entities.

Example:

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany
    private Set<Role> roles;

    // getters and setters
}

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // getters and setters
}
```
### 7.	What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

cascade = CascadeType.ALL: This option tells JPA to cascade all operations to the associated entities. For example, if you delete a Post entity, JPA will also delete all of the associated Comment entities.

orphanRemoval = true: This option tells JPA to delete any orphaned entities. For example, if you remove a Comment entity from a Post entity, JPA will delete the Comment entity from the database.

When to choose which CascadeType:

* CascadeType.ALL: This option is typically used when you want to maintain a consistent state between the parent entity and the associated entities.
* orphanRemoval = true: This option is typically used when you want to avoid orphaned entities in the database.
* Other CascadeType values: These options are typically used when you want to control how JPA cascades operations to the associated entities.

### 8.	What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

* FetchType.LAZY: Lazy loading means that the data is loaded on demand, i.e., when the data is requested. It is suitable for large associations where you want to avoid loading unnecessary data initially.
* FetchType.EAGER: Eager loading means that the associated data is loaded immediately with the main entity. It is suitable for small associations where you always need the associated data.

### 9.	What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA uses naming conventions to generate queries automatically based on the method names in the repository interface. For example, to find a user by username:

```Java
Optional<User> findByUsername(String username);
```
### 14.	What is JPQL?

JPQL is a query language defined for Java Persistence API (JPA). It is similar to SQL but operates on Java objects directly. JPQL is used to perform database operations on entities without considering the specifics of the underlying database.

### 15.	What is @NamedQuery and @NamedQueries?

@NamedQuery: Allows you to define a named query in an entity. Named queries are predefined JPQL queries that can be later executed using the entity manager.

@NamedQueries: Allows you to define multiple named queries for an entity class.

### 16.	What is @Query? In which Interface we write the sql or JPQL?

@Query is an annotation that can be used to define inline queries in JPA. Inline queries are queries that are defined directly in the code.

Example:

```java
@Query(value = "SELECT p FROM Post p WHERE p.title = :title", nativeQuery = true)
public List<Post> findPostsByTitle(@Param("title") String title) {
    // ...
}
```
Inline queries can be written in either SQL or JPQL. The nativeQuery property specifies whether the query is a SQL query or a JPQL query.

### 17.	What is HQL and Criteria Queries?

HQL stands for Hibernate Query Language. It is an object-oriented query language that is used to query Hibernate entities. HQL is very similar to JPQL, but it is specific to Hibernate.

Criteria queries are a type of query that is supported by both JPA and Hibernate. Criteria queries are more powerful and flexible than HQL or JPQL queries, but they are also more complex.

### 18.	What is EnityManager?

The EntityManager is a JPA interface that provides access to the persistence context. The persistence context is a collection of managed entities.

The EntityManager is responsible for managing the lifecycle of entities, such as persisting, updating, and deleting them. It is also responsible for flushing changes to the database

### 19.	What is SessionFactory and Session?

The SessionFactory is a Hibernate interface that is responsible for creating Session objects.

The Session is a Hibernate interface that provides access to the database. It is responsible for executing queries and managing transactions.

### 20.	What is Transaction? how to manage your transaction?

A transaction is a unit of work that is performed on the database. Transactions ensure that the database is in a consistent state before and after the work is performed.

To manage transactions in JPA, you would use the @Transactional annotation. This annotation specifies that the method should be executed within a transaction.

### 21. What is hibernate Caching?

Hibernate caching is a feature that allows Hibernate to store frequently accessed data in memory. This can improve the performance of Hibernate applications by reducing the number of database queries that need to be executed.

Hibernate caching can be used to cache both entities and collections. To cache an entity, you would use the @Cacheable annotation. To cache a collection, you would use the @CollectionCache annotation.

Hibernate provides two levels of caching: first-level and second-level.

### 22. What is the difference between first-level cache and second-level cache?

The first-level cache is a session-scoped cache. This means that it is associated with a single Hibernate Session object. The first-level cache is automatically enabled by default.

The second-level cache is a SessionFactory-scoped cache. This means that it is shared by all Hibernate Sessions that are created by the same SessionFactory object. The second-level cache is not enabled by default. To enable it, you need to configure a cache provider.

One of the main differences between the first-level and second-level cache is that the first-level cache is cleared when the Session is closed. The second-level cache, on the other hand, remains active until the SessionFactory is closed.

Another difference is that the first-level cache is only accessible to the Session that it is associated with. The second-level cache, on the other hand, is accessible to all Sessions that are created by the same SessionFactory object.

### 23. How do you understand @Transactional

The @Transactional annotation is used to mark a method as transactional. A transaction is a unit of work that is performed on the database. Transactions ensure that the database is in a consistent state before and after the work is performed.


### 24. Write a simple factory design pattern.

Here is a simple example of a factory class:

```Java
public class CarFactory {
    public static Car createCar(String type) {
        switch (type) {
            case "Sedan":
                return new Sedan();
            case "SUV":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}
```

To use the factory class, the client would call the createCar() method and specify the type of car that they want to create. The factory class would then return an instance of the requested car type.

Here is an example of how the factory class would be used:

```Java
Car car = CarFactory.createCar("Sedan");
```
The factory design pattern can be used to create objects of any type. It is a useful pattern for encapsulating the creation of objects and for making it easier to change the way that objects are created.
