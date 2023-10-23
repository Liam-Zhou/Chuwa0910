## 1. List all of the annotations you learned from class and homework to annotaitons.md

## 2. Type the Comment feature for the class project.

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

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

## 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-red book/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

## 12. (Optional) use JDBC to read the data from database.

## 13. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL.

## 14. What is JPQL?

## 15. What is @NamedQuery and @NamedQueries?

## 16. What is @Query? In which Interface we write the sql or JPQL?

## 17. What is HQL and Criteria Queries?

## 18. What is EnityManager?

## 19. What is SessionFactory and Session?

## 20. What is Transaction? how to manage your transaction?

## 21. What is hibernate Caching?

## 22. What is the difference between first-level cache and second-level cache?

## 23. How do you understand @Transactional? (不要 clone，要自己抄写并测试 transactional，https://github.com/TAIsRich/tutorial-transaction)

the annotated code should be executed within a transaction. Only a couple of operations can be completed for all in a transaction, then this transaction can be commited and the data dier to be changed.

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
