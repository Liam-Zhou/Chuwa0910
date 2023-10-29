## 1. List all of the annotations you learned from class and homework to annotaitons.md

## 2. Type the Comment feature for the class project.

Done.

## 3. In postman, call of the APIs in PostController and CommentController.

Done.

## 4. what is JPA? and what is Hibernate?

- JPA: Java Persistence API is a collection of classes and methods to persistently store the vast amounts of data into a database
- Hibernate: Hibernate is an open source object relational mapping (ORM) tool that provides a framework to map object-oriented domain models to relational databases for web applications

## 5. What is Hiraki? what is the benefits of connection pool?

- Hiraki Connection Pool: Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism.
- benefits:
  - Promote the reuse of connection objects and reduce the number of times that connection objects are created.
  - Significantly improve performance for database-intensive applications because creating connection objects is costly both in terms of time and resources.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

- `@OneToMany`: is a 1:N relationship. examples: post <-> comment
- `@ManyToOne`: is a N:1 relationship. examples: comment <-> post
- `@ManyToMany`: is a N:N relationship. examples: post <-> author

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

- `cascade = CascadeType.ALL`: the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
- `orphanRemoval = true`: dependent entities are removed when the relationship to their "parent" entity is destroyed.
- CascadeType
  - PERSIST: create
  - REMOVE: delete
  - REFRESH: the refresh operation should be cascaded from the parent entity to the child entities. Ps. EntityManager.refresh() is defined as: Refresh the state of the instance from the database, overwriting changes made to the entity, if any.
  - MERGE: the update (or merge) operation should be cascaded from the parent entity to the child entities.
  - DETACH: the detach operation should be cascaded from the parent entity to the child entities.

## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

`fetch = FetchType.LAZY/EAGER`: It fetches the child entities lazily/eagerly. The difference is that when getting information from database, it would get the cascading entity data or not. EAGER would.

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

Java Persistence API (JPA) follows certain naming conventions for mapping entity classes to database tables and columns. These conventions help in mapping the Java domain model to the relational database schema without requiring explicit configuration in most cases.

Yes. We can implement the method by ourselves. We can customize the mappings using annotations like @Table, @Column, and @JoinColumn as needed.

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

Done.

## 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-red book/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

## 12. (Optional) use JDBC to read the data from database.

## 13. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL.

Done.

## 14. What is JPQL?

Java Persistence Query Language, is a query language used with the Java Persistence API (JPA) to perform database queries using object-oriented syntax.

JPQL is similar to SQL (Structured Query Language) but is designed to work with Java objects and is specifically used for querying relational databases through JPA.

## 15. What is @NamedQuery and @NamedQueries?

- `@NamedQuery`: is used to define a single named query within an entity class.
- `@NamedQueries`: is used to define multiple named queries within an entity class.

## 16. What is @Query? In which Interface we write the sql or JPQL?

`@Query` is used to declare custom database queries for JPA repositories. We write the sql/JPQL in the Jpa Repository interface.

## 17. What is HQL and Criteria Queries?

- `HQL`: a query language that allows you to express database queries using a SQL-like syntax with object-oriented features.
- `Criteria Queries`: a programmatic way to build queries using a set of classes and methods that provide type-safety and dynamic query building.

## 18. What is EnityManager?

- `EntityManager`: a core component of the JPA. It works in managing database entities in a Java application. In Java applications that use JPA, the EntityManager is typically obtained from an entity manager factory, and it is used to interact with the underlying database.

## 19. What is SessionFactory and Session?

- `SessionFactory`: a crucial component in Hibernate and serves as a factory for creating Session objects. It is typically created only once during the application's startup process and is responsible for bootstrapping Hibernate, configuring various settings, and establishing a connection to the database.
- `Session`: a short-lived object representing a single unit of work or a database transaction. It is created by `SessionFactory`.

## 20. What is Transaction? how to manage your transaction?

`Transaction`: a series of one or more operations on a database that should be executed as a single, indivisible unit. Transactions ensure the integrity and consistency of data in a database.

Based on your application's requirements, We can define different operations in a transaction. In Spring framework, we can use `@Transactional` annotation.

## 21. What is hibernate Caching?

Hibernate Caching, stores and manages data in a memory cache to improve the performance and reduce the number of database queries.

## 22. What is the difference between first-level cache and second-level cache?

- First-Level Cache:
  - Associated with an individual Hibernate Session.
  - Each Session maintains its own first-level cache.
  - Cached data is available only within the scope of the current Session.
- Second-Level Cache:
  - A shared cache that can be used across multiple Session instances.
  - Data stored in the second-level cache can be shared among different Session instances and can even be accessed by different parts of the application.

## 23. How do you understand @Transactional? (不要 clone，要自己抄写并测试 transactional，https://github.com/TAIsRich/tutorial-transaction)

The annotated code should be executed within a transaction. Only a couple of operations can be completed for all in a transaction, then this transaction can be commited and the data dier to be changed.

## 24. Write a simple factory design pattern.

```
public class Americano extends Coffee{
    public String getName() {
        return "Americano";
    }
}


public class Latte extends Coffee{
    public String getName() {
        return "Latte";
    }
}

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("Add Sugar");
    }

    public void addMilk() {
        System.out.println("Add Milk");
    }
}

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("americano".equals(type)) {
            coffee = new Americano();
        } else if ("latte".equals(type)) {
            coffee = new Latte();
        } else {
            throw new RuntimeException("Sorry, No existing coffee type!");
        }

        // Add Sugar or Milk
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

```
