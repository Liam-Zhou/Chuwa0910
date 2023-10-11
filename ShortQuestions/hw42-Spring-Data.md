###### 4. what is JPA? and what is Hibernate?
JPA is a standard API for working with databases in Java, while Hibernate is a popular ORM framework that implements the JPA specification but also offers additional features and flexibility.

###### 5. What is Hiraki? what is the benefits of connection pool?
Hikari is a high-performance JDBC connection pool library, and connection pooling.
It provides improved resource efficiency, enhanced performance, simplified connection management, and better scalability for Java applications interacting with databases.

###### 6. What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
@OneToMany defines a one-to-many relationship between two entities. It means that one entity can be associated with multiple instances of another entity. Such as one author to many books
@ManyToOne is used to define a many-to-one relationship between two entities. It means that many instances of one entity can be associated with a single instance of another entity. Such as many books to one author.
@ManyToMany is used to define a many-to-many relationship between two entities. It means that multiple instances of one entity can be associated with multiple instances of another entity. Such as weekdays and classes.

###### 7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
orphanRemoval = true automatically deletes associated entities when they're removed from a collection in the owning entity.
cascade defines which operations on the owning entity should be applied to the associated entity.
    Use CascadeType.PERSIST when you want to automatically persist related entities when the owning entity is persisted.
    Use CascadeType.MERGE when you want to automatically merge related entities when the owning entity is merged.
    Use CascadeType.REMOVE when you want to automatically remove related entities when the owning entity is removed.
    Use CascadeType.REFRESH when you want to automatically refresh related entities when the owning entity is refreshed.
    Use CascadeType.DETACH when you want to automatically detach related entities when the owning entity is detached.
    Use CascadeType.ALL sparingly and with caution, as it can lead to unintended cascading of operations.

###### 8. What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
FetchType.LAZY loads related data when you explicitly access it in your code, making it efficient for large datasets.
FetchType.EAGER loads all related data immediately when the owning entity is fetched, which can be convenient but may lead to performance issues with large datasets.
Choose based on whether you want to load data on-demand (use LAZY) or load it all upfront (use EAGER), considering data size and query patterns.

###### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
Entity class names should match table names in CamelCase. (Comment)
Primary key fields are often named "id."
Table and column names follow the default conventions but can be customized with annotations.
Relationship field names typically use the related entity name and primary key field name.
Repository interfaces are named after the managed entity with "Repository" appended. (PostRepository)
 
###### 14. What is JPQL?
JPQL (Java Persistence Query Language) is a high-level query language in Java Persistence API (JPA) used for querying and manipulating database records using object-oriented syntax. It allows developers to write database-agnostic queries that work with entity classes and their attributes.

###### 15. What is @NamedQuery and @NamedQueries?
Annotations used in Java Persistence API (JPA) to define named queries for entities. Named queries are pre-defined database queries that can be reused in your JPA application by referencing them by name. 

###### 16. What is @Query? In which Interface we write the sql or JPQL?
Annotation used to define custom SQL or JPQL (Java Persistence Query Language) queries for database operations. It allows you to specify a query directly within your repository interface or associated methods. 

###### 17.  What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is a string-based query language similar to SQL used in Hibernate.
Criteria Queries are programmatic queries built using Java classes and methods, providing type safety and dynamic query building capabilities.

###### 18. What is EnityManager?
A core interface in Java Persistence API (JPA) used for managing and interacting with entity objects in a JPA-based application. 

###### 19. What is SessionFactory and Session?
The SessionFactory is a long-lived object responsible for configuring Hibernate and creating Session instances. The Session, on the other hand, is a short-lived object used for performing database operations within a specific unit of work or transaction. Multiple Session instances can be created and used concurrently within a single application, but the SessionFactory is typically shared across the entire application.

###### 20. What is Transaction? how to manage your transaction?
A transaction is a unit of work that consists of one or more database operations treated as a single, atomic entity.
In Java applications, you can manage transactions programmatically using APIs provided by Java Persistence API (JPA) or frameworks like Hibernate.
Typically, you start a transaction, perform database operations, and then either commit the transaction to save changes or roll it back to discard changes if an error occurs.

###### 21. What is hibernate Caching?
Hibernate caching refers to the mechanism provided by the Hibernate ORM framework to store and manage frequently accessed data in memory, improving the efficiency and performance of database operations. It involves storing query results or entity data in a cache, which is a faster and easily accessible data store compared to the database. Hibernate caching helps reduce the number of database queries and minimizes the load on the database server.

###### 22. What is the difference between first-level cache and second-level cache?
first-level cache is session-specific and fine-grained, providing benefits within a single session. In contrast, the second-level cache is shared among sessions, coarser-grained, and requires explicit configuration but offers performance improvements for shared and frequently accessed data across multiple sessions.

###### 23. How do you understand @Transactional? (不要clone，要自己抄写并测试transactional，https://github.com/TAIsRich/tutorial-transaction)
Make sure everything work correct, get the except result, or rollback everything that made within the transaction.


###### 24. Write a simple factory design pattern.
```
// Product interface
interface Shape {
    void draw();
}

// Concrete products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Factory interface
interface ShapeFactory {
    Shape createShape();
}

// Concrete factories
class CircleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}
```