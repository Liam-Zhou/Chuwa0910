1. List all of the annotations you learned from class and homework to annotaitons.md.

2. Type the Comment feature for the class project.

3. In postman, call of the APIs in PostController and CommentController.

4. What is JPA? And what is Hibernate?

    1. JPA (Java Persistence API)
       
       - Definition:
       
         JPA is a specification that provides a set of concepts and APIs to incorporate data persistence into Java applications using ORM (Object-Relational Mapping). It allows developers to map Java classes to database tables and from Java data types to SQL data types.

       - Key Components:
         
         - EntityManager: It acts as a factory for EntityTransaction instances and various entity manager instances. It also provides methods to find, persist, and remove entities.
         - EntityTransaction: This represents a transaction in JPA. It ensures that data changes happen atomically.
         - JPQL (Java Persistence Query Language): It's a string-based query language that operates against the entity objects rather than directly with database tables.

       - Features:
         
         - Simplifies database handling in Java applications.
         - Provides a way to map Java objects to database entities.
         - Allows for the use of Java objects (entities) to represent and manipulate database content.

    2. Hibernate
       
       - Definition:
         
         Hibernate is a popular implementation of JPA. It's an open-source ORM tool that provides a framework for mapping application domain objects to the relational database tables and vice versa.

       - Key Components:
         
         - SessionFactory: It's a factory class used to obtain the Session objects. It's created at the time of application startup and usually created only once for an application.
         - Session: Represents a single-threaded unit of work. It provides methods to perform create, read, update, and delete operations.
         - Transaction: Represents a unit of work with the database. It's used to ensure that the data integrity is maintained.
         - Criteria API: Allows creating complex queries programmatically. It's a type-safe way to express queries.

       - Features:
         
         - Supports a variety of mapping, including one-to-one, one-to-many, many-to-one, and many-to-many.
         - Provides query options such as HQL (Hibernate Query Language), native SQL, and Criteria API.
         - Offers caching mechanisms to store frequently queried data in the cache, improving performance.
         - Allows integration with various application frameworks like Spring, EJB, etc.

5. What is Hiraki? what is the benefits of connection pool?

    1. HikariCP
       
       - Definition:
         
         HikariCP is a high-performance, lightweight, and reliable connection pooling library for Java applications. Connection pooling is a mechanism to maintain and manage a pool of database connection objects, which can be reused for future requests to the database, reducing the overhead of opening and closing connections every time a request is made.

      - Features:
        
        - Performance: HikariCP is often touted for its superior performance and speed in comparison to other connection pooling libraries. It is optimized for providing minimal latency and maximum throughput.
        - Reliability: It offers a highly simplified and reliable connection pool mechanism, focusing on a minimal and straightforward design for reduced complexity and potential for errors.
        - Configuration: HikariCP allows for easy configuration, making it accessible for developers to integrate and manage.
        - Monitoring: It provides metrics support to track and monitor the behavior and performance of the connection pool, aiding in identifying and resolving issues quickly.

     2. Benefits of Connection Pooling
        
        - Efficiency:
          
          - Connection Reusability: Connection objects are reused, reducing the time taken to create and close connections for every database request.
          - Request Handling: Handles a large number of requests efficiently by managing and maintaining a pool of active connections.
        
        - Performance:
          
          - Speed: Increases the speed of application performance by reducing the latency associated with establishing connections.
          - Scalability: Helps applications to scale by efficiently managing database connections, especially under high loads.
       
        - Resource Optimization:
          
          - Resource Management: Optimizes the use of system resources as the connections are managed in the pool.
          - Garbage Collection: Reduced frequency and duration of garbage collection due to fewer objects being created and destroyed.
        
        - Reliability:
          
          - Availability: Ensures that connections are always available for use, enhancing the reliability of applications.
          - Fault Tolerance: Provides mechanisms to check and ensure that the connections in the pool are healthy.
        
        - Maintenance:
          
          - Monitoring: Easier to monitor and manage a finite set of connections rather than unpredictable and numerous individual connections.
          - Tuning: Allows for performance tuning by adjusting the pool size and other configurations.

6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

    1. @OneToMany

       This annotation is used to define a one-to-many relationship between two entities, meaning one entity can be associated with multiple records of another entity.
 
       ```
       @Entity
       public class Post {
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          private String title;

          @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
          private List<Comment> comments = new ArrayList<>();

          // getters and setters
       }

       @Entity
       public class Comment {
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          private String content;

          @ManyToOne
          @JoinColumn(name = "post_id")
          private Post post;

          // getters and setters
       }
       ```

    2. @ManyToOne Relationship

       This annotation is used to define a many-to-one relationship between two entities, meaning multiple records of an entity can be associated with a single record of another entity.

    3. @ManyToMany Relationship

       This annotation is used to define a many-to-many relationship between two entities, meaning multiple records of an entity can be associated with multiple records of another entity.

       ```
       @Entity
       public class Student {
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          private String name;

          @ManyToMany(cascade = CascadeType.ALL)
          @JoinTable(
             name = "student_course", 
             joinColumns = @JoinColumn(name = "student_id"), 
             inverseJoinColumns = @JoinColumn(name = "course_id")
          )
          private List<Course> courses = new ArrayList<>();

          // getters and setters
       }

       @Entity
       public class Course {
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          private String name;

          @ManyToMany(mappedBy = "courses")
          private List<Student> students = new ArrayList<>();

          // getters and setters
       }
       ```

7. What is the cascade = CascadeType.ALL, orphanRemoval = true? And what are the other CascadeType and their features? In which situation we choose which one?

   1. Cascade Types in JPA and Hibernate

      In JPA and Hibernate, the cascade type is used to manage the state of the target entity automatically, based on the state of the source entity. It helps manage the states of both entities such that an operation carried out on the source entity gets cascaded to the target entity.

      - CascadeType.PERSIST: It means that save operations will be cascaded across the entity's association. If we save the source entity, the target entity will also get saved.
      - CascadeType.MERGE: When you update the source entity, the target entity will also get updated.
      - CascadeType.REMOVE: If the source entity is deleted, the target entity will also get deleted.
      - CascadeType.REFRESH: If the source entity is refreshed, the target entity will also get refreshed.
      - CascadeType.DETACH: If we are detaching the source entity, the target entity will also get detached.
      - CascadeType.ALL: It indicates that all cascading operations will be applied to the parent entity's associated child entity. It's a combination of PERSIST, MERGE, REMOVE, REFRESH, and DETACH.

   2. orphanRemoval in JPA and Hibernate

      The orphanRemoval attribute is used to remove child entities when they get disassociated with the parent entity. When orphanRemoval=true, if we remove the relationship between the parent and the child, the child entity will be automatically removed. This is similar to "delete-orphan" in Hibernate.

      - CascadeType.PERSIST: Use when we want to save the child entity automatically upon saving the parent entity.
      - CascadeType.MERGE: Use when we want to update the child entity automatically upon updating the parent entity.
      - CascadeType.REMOVE: Use when we want to delete the child entity automatically upon deleting the parent entity.
      - CascadeType.REFRESH: Use when we want to refresh the child entity automatically upon refreshing the parent entity.
      - CascadeType.DETACH: Use when we want to detach the child entity automatically upon detaching the parent entity.
      - CascadeType.ALL: Use when we want to apply all the above cascade operations between parent and child entities. 

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

    1. FetchType.LAZY:
       
       - Definition: This is a fetching strategy where the related entities are not loaded unless they are explicitly   invoked. In other words, it's a “load on request” strategy.
       - Performance Aspect: It's typically used to improve performance. When an entity is loaded, its related entities (as per the entity relationship) are not loaded at the same time but will be loaded on demand.
       - Common Use Cases: It’s typically used for entities with large data sets or costly DB operations to optimize performance and memory consumption. For instance, in a OneToMany relationship with lots of related entities, lazy loading can prevent loading all related entities unnecessarily.

    2. FetchType.EAGER:

       - Definition: In this fetching strategy, related entities are loaded at the same time as the main entity. This means, if we load an entity, all its related entities will be loaded automatically.
       - Performance Aspect: It could lead to performance issues because it might load a lot of data that isn’t needed immediately. It can cause the infamous “N+1 selects problem” in Hibernate, where a significant number of SQL queries can be executed if not handled properly.
       - Common Use Cases: It’s used when we are sure that the associated entities will be needed by the application immediately after loading the parent entity, so loading everything in one go will be more efficient.

9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

    JPA naming conventions for query methods are quite intuitive and self-explanatory, allowing developers to create queries directly from method names in interfaces without needing to write the underlying JPQL or SQL query. This is made possible through Spring Data JPA’s repository support.

    The basic format of these method names is:
    ```
    findBy{PropertyName}{Condition}{And|Or}{PropertyName}{Condition}
    ```
    
    Examples:
    ```
    public interface UserRepository extends JpaRepository<User, Long> {

       List<User> findByLastName(String lastName);

       List<User> findByFirstNameAndLastName(String firstName, String lastName);

       List<User> findByAgeGreaterThanEqual(int age);

       List<User> findByCreatedAtBetween(Date startDate, Date endDate);

       List<User> findByLastNameLike(String pattern);

       List<User> findByFirstNameOrAge(String firstName, int age);

       List<User> findByIsActiveTrue();
    }
    ```

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

    
11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-red book/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.


12. (Optional) use JDBC to read the data from database.


13. Type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL.


14. What is JPQL?

    JPQL (Java Persistence Query Language) is a platform-independent query language defined as part of the JPA (Java Persistence API) specification. It allows you to define queries for entities and their persistent state, including relationships among them. JPQL is similar to SQL but operates on the abstract persistence schema rather than database tables, making it database agnostic.
    
    Basic Syntax of JPQL:
    
    - SELECT Queries:

      Used for fetching data from the database.
      ```
      SELECT p FROM Person p WHERE p.name = 'John'
      ```
    - UPDATE Queries:

      Used for updating existing records in the database.
      ```
      UPDATE Person p SET p.name = 'Jane' WHERE p.id = 1
      ```

    - DELETE Queries:

      Used for deleting records from the database.
      ```
      DELETE FROM Person p WHERE p.id = 1
      ```

    - JOIN Queries:

      Used for fetching data by joining multiple tables (entities).
      ```
      SELECT p, a FROM Person p JOIN p.address a WHERE a.city = ‘New York'
      ```

15. What is @NamedQuery and @NamedQueries?

    @NamedQuery and @NamedQueries are annotations used within the Java Persistence API (JPA) to declare named queries in a centralized way. Named queries are static queries that are defined at compile-time and associated with a given name. These queries can then be executed by referencing their unique name, providing a more organized and clean way of managing JPQL queries.

    1. @NamedQuery
       
       The @NamedQuery annotation is used to define a single named query. It takes parameters for the query name and the JPQL query string. Here is the basic syntax:
       
       ```
       @Entity
       @NamedQuery(
          name = "findPersonByName",
          query = "SELECT p FROM Person p WHERE p.name = :name"
       )
       public class Person {
          // ... entity fields and methods
       }
       ```
       
       We can use this named query like this:
       ```
       TypedQuery<Person> query = entityManager.createNamedQuery("findPersonByName", Person.class);
       query.setParameter("name", "John");
       List<Person> results = query.getResultList();
       ```
       
    2. @NamedQueries
       
       The @NamedQueries annotation is a container annotation that holds multiple @NamedQuery annotations. It allows us to define several named queries for an entity class. Here is the basic syntax:
       
       ```
       @Entity
       @NamedQueries({
          @NamedQuery(
             name = "findPersonByName",
             query = "SELECT p FROM Person p WHERE p.name = :name"
          ),
          @NamedQuery(
             name = "findPersonByAge",
             query = "SELECT p FROM Person p WHERE p.age = :age"
          )
       })
       public class Person {
          // ... entity fields and methods
       }
       ```
       
       Each query can be invoked similarly:
       ```
       TypedQuery<Person> nameQuery = entityManager.createNamedQuery("findPersonByName", Person.class);
       nameQuery.setParameter("name", "John");
       List<Person> personsNamedJohn = nameQuery.getResultList();

       TypedQuery<Person> ageQuery = entityManager.createNamedQuery("findPersonByAge", Person.class);
       ageQuery.setParameter("age", 30);
       List<Person> personsAged30 = ageQuery.getResultList();
       ```

16. What is @Query? In which Interface we write the sql or JPQL?

    @Query is an annotation used in Spring Data JPA to define a query for executing a particular operation on the database. It allows developers to execute both JPQL (Java Persistence Query Language) and native SQL queries. We write queries directly on the repository interfaces.

    1. Example of @Query with JPQL
       
       ```
       public interface UserRepository extends JpaRepository<User, Long> {

          @Query("SELECT u FROM User u WHERE u.email = ?1")
          User findByEmail(String email);

          @Query("SELECT u FROM User u WHERE u.age > ?1")
          List<User> findUsersOlderThan(int age);
       }
       ```
       
       In this example, findByEmail and findUsersOlderThan are methods defined in the UserRepository interface. The @Query annotation is used to specify the JPQL queries for these methods.

    2. Example of @Query with Native SQL Query
       
       ```
       public interface UserRepository extends JpaRepository<User, Long> {

          @Query(value = "SELECT * FROM Users WHERE email = ?1", nativeQuery = true)
          User findByEmail(String email);
       }
       ```
       
       Here, nativeQuery = true is used to indicate that a native SQL query is being used instead of JPQL.

    3. Where to Use @Query
       
       @Query is commonly used in the repository layer of the application, specifically in the repository interfaces that extend JpaRepository, CrudRepository, or PagingAndSortingRepository from Spring Data JPA.

17. What is HQL and Criteria Queries?

    HQL (Hibernate Query Language) is an object-oriented, database-agnostic query language specific to Hibernate ORM, allowing developers to operate on persistent objects and properties rather than database tables and columns. In contrast, Criteria Queries, part of the Java Persistence API (JPA), offer a programmatic way to build structured, type-safe queries, ensuring compile-time checking and dynamic query creation. Both are aimed at offering more abstraction and safety in handling database operations, catering to object-relational mapping and ensuring that queries are adaptable across various database systems.

18. What is EnityManager?

    EntityManager is a fundamental concept in Java's Java Persistence API (JPA) and is central to the framework's runtime functionality. It is used to manage the persistence of entities, which are Java objects that represent rows in a database table. EntityManager is responsible for managing the entity objects within an application, providing operations to persist and retrieve them to and from the database.

    Here are the core functions that EntityManager performs:

    1. Persisting Entities:
       
       EntityManager is used to persist entity instances to the database, meaning it takes Java objects and stores them as records in the database.

    2. Retrieving Entities:
       
       It can retrieve entities from the database, transforming database records into Java objects that can be manipulated in code.

    3. Updating Entities:
       
       It manages the state of entities. When an entity is modified, EntityManager ensures that these changes are reflected in the database.
    
    4. Deleting Entities:
       
       Entities can be removed from the database using EntityManager.
    
    5. Query Execution:
        
       It is used to create and execute queries, including both JPQL (Java Persistence Query Language) and native SQL queries.

    6. Transaction Management:
        
       It provides API to begin, commit, and rollback transactions. It ensures that data integrity is maintained and supports both container-managed and application-managed transactions.
    
    7. Caching:
       
       EntityManager also utilizes caching mechanisms to improve performance by reducing the need for repeated database queries.

    
    ```
    // Creating an EntityManager instance
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Beginning a new transaction
    entityManager.getTransaction().begin();

    // Creating a new entity instance
    User user = new User("Alice", "alice@example.com");

    // Persisting the entity to the database
    entityManager.persist(user);

    // Committing the transaction
    entityManager.getTransaction().commit();

    // Closing the EntityManager
    entityManager.close();
    ```
   
19. What is SessionFactory and Session?

    1. SessionFactory
       
       - Creation: It's a factory class used to get the Session objects. It is heavy-weight and thread-safe, meaning that it’s created once and shared across many database sessions. Configuring a SessionFactory is costly in terms of system resources, so it often serves multiple Session instances.
       - Configuration: It is configured at the application startup and serves as a factory of Session. It holds data of the database strategy and mapped document, typically created during the application start-up and kept for later use.
       - Function: It provides factory methods to get the Session object. It holds the second level cache (optional) of data to be persisted and is used to create a Session.

    2. Session
       
       - Creation: The Session is a light-weight and non-threadsafe object (meant to be used by a single thread) that represents a single unit-of-work with the database.
       - Operations: It’s used to get a physical connection with the database. The Session object is designed to be instantiated each time an interaction is needed with the database. Temporary in nature, the Session object is destroyed once the database operation is complete.
       - CRUD: It provides methods for the CRUD operations. It acts as a bridge between the Java application and the Hibernate configuration.
       - Transaction: Operations via a Session are not auto-committed, so it has a transaction associated which needs to be committed explicitly.
    
    ```
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    ```
    ```
    Session session = sessionFactory.openSession();
    ```
    
20. What is Transaction? How to manage your transaction?
 
    A transaction is a sequence of one or more operations (like inserting, updating, deleting) that is executed as a single unit of work. It helps in maintaining the consistency and integrity of the data in a database. If all operations within the transaction are executed successfully, it is committed, and all changes made during the transaction are permanently saved in the database. If an error occurs during the transaction, it is rolled back, and all changes are discarded.

    Key Concepts
    
    - ACID Properties: Transactions are controlled by ACID properties (Atomicity, Consistency, Isolation, Durability).
      
      - Atomicity: A transaction should be atomic, meaning it should either be completed with all of its operations successfully executed or none at all.
      - Consistency: The transaction should bring the database from one valid state to another valid state.
      - Isolation: Each transaction should be isolated from others until it's committed.
      - Durability: Once committed, the changes by a transaction should be permanent.
    
    - Transactional Annotations in Spring:

      @Transactional: This annotation can be applied at the class or method level in a Spring managed bean, and it indicates that a method or all methods of a class should be executed within a transaction context.


    In Spring, transactions can be managed in the following ways:

    1. Declarative Transaction Management:
       
       This is the most common approach, where transactions are managed with annotations or XML configurations. It is preferable because it keeps transaction management out of the business code.
       
       ```
       @Service
       public class MyService {
          @Transactional
          public void doTransaction() {
             // transactional code here
          }
       }
       ```
       
       Rolling Back: By default, Spring rolls back the transaction if an unchecked exception (a runtime exception) is thrown from the transactional method. We can also specify a condition under which it should be rolled back.
    
    2. Programmatic Transaction Management:
       
       It allows us to manage transactions through programming, which gives us extreme flexibility, but it is complex and error-prone.
       
       ```
       TransactionDefinition def = new DefaultTransactionDefinition();
       TransactionStatus status = transactionManager.getTransaction(def);
       try {
           // transactional code
           transactionManager.commit(status);
       } catch (Exception e) {
          transactionManager.rollback(status);
          throw e;
       }
       ```
       21. What is hibernate Caching?

    Hibernate caching improves the performance of the application by pooling the object in the cache. It is useful when you have to fetch the same data multiple times. Hibernate provides a cache mechanism to store and retrieve objects without interacting with the database constantly. It reduces the database traffic and increases the application's efficiency and speed. Hibernate supports two levels of caching: First Level Cache and Second Level Cache.

22. What is the difference between first-level cache and second-level cache?

    1. First Level Cache:
       
       - Nature: It is enabled by default and cannot be disabled. Each Hibernate session has its own first-level cache, and it's associated with the Hibernate session.
       - Scope: Limited to the session scope. If the session is closed, the cache will be cleared.
       - Usage: Automatically used by Hibernate when it's called to load or fetch data.
       - Example: When we query an entity, and that entity is not in the session cache, Hibernate fetches it from the database and stores it in the session cache. If we query the entity again, Hibernate retrieves it from the session cache without hitting the database.
    
    2. Second Level Cache:
       
       - Nature: It needs to be configured explicitly and is not enabled by default. It’s global and is shared by all the sessions.
       - Scope: Application-level cache; objects are stored in the cache and can be accessed across sessions.
       - Providers: Hibernate provides the option to plug in various caching providers like EhCache, Infinispan, Hazlecast, etc.
       - Usage: Useful in read-heavy operations where data doesn’t change often.
       - Example: Once the data is stored in the second-level cache, it can be retrieved from there in any session until it’s not evicted or expired, reducing the database hits significantly.

23. How do you understand @Transactional?

    1. Scope of Application
       
       - Where It Applies:

         - @Transactional can be applied at the class or method level in a Spring application.
         - When applied at the class level, it affects all public methods of the class.

       - Type of Transactions:

         - Supports both programmatic and declarative transactions.
       
    2. Features
       
       - ACID Principles:

         - The annotation ensures transactions adhere to ACID principles - Atomicity, Consistency, Isolation, and Durability.

       - Rollbacks:

         - Transactions are automatically rolled back in case of a runtime exception or any checked exceptions, ensuring the database remains in a consistent state.

       - Propagation Levels:

         - Allows specification of propagation levels to control how transactions are initiated and handled in nested method calls.
    
    3. How It Works
       
       - Proxy Pattern:

         - Spring utilizes a proxy pattern to add transaction management code to the targeted method calls.
       
       - Commit and Rollback:

         - Transactions are committed when the method completes execution successfully and rolled back if an exception occurs.
       
       - Isolation Levels:

         - Allows setting isolation levels to control how data is isolated from other transactions during execution.
       
    4. Considerations
       
       - Runtime Exceptions:

         - By default, transactions are rolled back on runtime exceptions but not on checked exceptions.
       
       - Customization:

         - @Transactional properties like rollbackFor, noRollbackFor, isolation, and readOnly allow customization of transaction behavior.

24. Write a simple factory design pattern.
    
    ```
    public interface Shape {
       void draw();
    }
    ```
    ```
    public class Circle implements Shape {
       @Override
       public void draw() {
          System.out.println("Drawing a Circle");
       }
    }

    public class Square implements Shape {
       @Override
       public void draw() {
          System.out.println("Drawing a Square");
       }
    }

    public class Rectangle implements Shape {
       @Override
       public void draw() {
          System.out.println("Drawing a Rectangle");
       }
    }   
    ```
    ```
    public class ShapeFactory {
       public Shape getShape(String shapeType) {
          if (shapeType == null) {
             return null;
          }
          if (shapeType.equalsIgnoreCase("CIRCLE")) {
             return new Circle();
          } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
             return new Rectangle();
          } else if (shapeType.equalsIgnoreCase("SQUARE")) {
             return new Square();
          }
          return null;
       }
    }
    ```
    ```
    public class FactoryPatternDemo {
       public static void main(String[] args) {
          ShapeFactory shapeFactory = new ShapeFactory();

          // Get an object of Circle and call its draw method
          Shape shape1 = shapeFactory.getShape("CIRCLE");
          shape1.draw();

          // Get an object of Rectangle and call its draw method
          Shape shape2 = shapeFactory.getShape("RECTANGLE");
          shape2.draw();

          // Get an object of Square and call its draw method
          Shape shape3 = shapeFactory.getShape("SQUARE");
          shape3.draw();
       }
    }
    ```



