4.
JPA is a specification for object-relational mapping (ORM) in Java. It allows developers to map Java objects to relational database tables and vice versa, making it easier to interact with databases in a Java application

Hibernate is an open-source, stable, and powerful ORM framework for Java applications. It provides a reference implementation of the Java Persistence API (JPA) and goes beyond the JPA specification by offering numerous additional features.

5.
HikariCP is a popular JDBC connection pooling library in Java. It's known for its lightweight nature and outstanding performance. In the context of Spring, HikariCP can be easily configured as the DataSource implementation provided to JPA, JDBC, or any other data access technology.
Benefits of connection pool:
Reduced Connection Creation Overhead, Lower Latency, Efficient Resource Utilization, Enhanced Scalability, Improved Stability …

6.
1. @OneToMany
This annotation indicates a one-to-many relationship between entities. One instance of an entity A can be associated with multiple instances of entity B, but any instance of entity B can be associated with only one instance of entity A.

2. @ManyToOne
The @ManyToOne annotation indicates a many-to-one relationship between entities. This is the opposite of @OneToMany: multiple instances of entity A can be associated with a single instance of entity B.

3. @ManyToMany
The @ManyToMany annotation is used to define a many-to-many relationship between entities. Instances of entity A can be associated with multiple instances of entity B and vice versa.

7.
CascadeType. ALL is a cascading type in Hibernate that specifies that all state transitions (create, update, delete, and refresh) should be cascaded from the parent entity to the child entities. 
orphanRemoval = true: When a child entity is removed from the collection, it will be removed from the database.
Other CascadeType:
PERSIST: When the parent entity is persisted, associated child entities are also persisted.
MERGE: When the parent entity is merged, changes to the associated child entities are also merged.
REMOVE: When the parent entity is removed, associated child entities are also removed.
REFRESH: When the parent entity is refreshed, associated child entities are also refreshed.
DETACH: When the parent entity is detached, associated child entities are also detached.
ALL: This cascades all of the above operations.
8.
LAZY fetching means that the data will be fetched from the database only when it’s accessed for the first time. Before the data is accessed, a proxy or placeholder is created and the actual data is not retrieved.
EAGER fetching means that the data will be fetched from the database immediately, as soon as the owning entity is loaded.
It’s often preferable to use LAZY fetching for performance reasons, especially when an entity has collections of other entities or large data fields (like Blob).
EAGER fetching can be useful when the relationships are not too large and are always used when the owning entity is retrieved

9.
Entity Naming
Default Name: By default, the name of the entity is the class name.
Custom Name: Use @Entity(name = "custom_name") to customize.

Table Naming
Default Name: The default table name is the entity name.
Custom Name: Use @Table(name = "custom_name") to specify a different table 

Column Naming
Default Name: The default column name is the field name.
Custom Name: Use @Column(name = "custom_name") to customize.

Primary Key Naming
Often, a field named id with @Id annotation is used.
Use @GeneratedValue to define generation strategy (e.g., AUTO, IDENTITY).

we can implement by ourselves, like:
findBy + FieldName(PascalCase): Generates queries by field.
And, Or: Combines conditions.
OrderBy + FieldName + Asc/Desc: Adds ordering to the query.

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmailAndActive(String email, boolean active);
    List<User> findByNameOrderByEmailDesc(String name);
}


14.
JPQL is Java Persistence Query Language, is a query language used in the Java Persistence API (JPA) to perform database operations on persistent entities. Unlike SQL, which operates on database tables and columns, JPQL operates on the entity objects in your code and their mappings to the database schema. It allows you to describe queries with a syntax that is similar to SQL while working in an object-oriented way.

15.
The @NamedQuery annotation is used to define a single named, static query in your JPA entity. 
The main elements of @NamedQuery are:
name: A unique name for the query that can be used to reference it later in the code.
query: The query string written in JPQL (Java Persistence Query Language).

The @NamedQuery annotation is used to define a single named, static query in your JPA entity. 
The main elements of @NamedQuery are:
name: A unique name for the query that can be used to reference it later in the code.
query: The query string written in JPQL (Java Persistence Query Language).

16.
the @Query annotation is utilized to define a query over your entities, enabling the execution of JPQL (Java Persistence Query Language), HQL (Hibernate Query Language), or even native SQL queries.
The @Query annotation is often used in repository interfaces. When you use Spring Data JPA, you typically extend one of

17.
HQL is a query language native to Hibernate, a popular JPA (Java Persistence API) implementation. It is used to write queries against the entity objects, not database tables, which makes it database-agnostic. HQL is similar to SQL in syntax, but it works with entity objects instead of tables and columns.

Criteria Queries are a programmatic, type-safe querying method provided by JPA and also available with Hibernate. The criteria API allows constructing dynamic queries using its well-defined object-oriented API, rather than embedding JQL or HQL queries in your code. This can be particularly useful for building dynamic queries whose exact structure you might not know at compile-time.

18.
EntityManager is a fundamental concept and interface in JPA (Java Persistence API) and is responsible for managing the persistence lifecycle of entities and the operations that can be performed on them. Essentially, it acts as a bridge between the object-oriented domain model in your application and the relational database, allowing you to perform operations like persist, merge, remove, and query with respect to the entities.

19.
The SessionFactory is a thread-safe (and immutable) cache of compiled mappings for a single database. It's usually created during application startup, not per-request, and serves the following purposes:

Session is a short-lived, non-thread-safe object conceptually maintaining a particular unit of work. 



20.
In the context of databases and JPA/Hibernate, a transaction represents a unit of work that is performed against the database and is treated in a reliable and atomic manner. It's "atomic" in the sense that it either fully completes or has no effect at all. Thus, a transaction ensures data integrity and consistency in the database.

Managing transactions involves handling the following aspects:
Beginning a Transaction: Initiating the boundary where the actual work of the transaction will take place.
Committing the Transaction: If all operations within the boundary are successful, you finalize (or "commit") the transaction. Once committed, all changes made during the transaction are permanent in the database.
Rolling Back the Transaction: If any operation within the transaction boundary fails, all operations are undone, and the state of the database is reverted back to its form at the beginning of the transaction.

21.
Hibernate caching is a technique to store frequently-used data into a cache after it has been loaded from the database. Subsequent requests for the data can then be served from the cache, thus improving the performance and reducing the overall transaction time, as fetching data from the database is often one of the most resource-intensive operations.

22.
The first-level cache is localized to a single session and helps to reduce database queries by caching retrieved data. The second-level cache is shared across sessions and enables data to be cached across multiple requests.

23.
The @Transactional annotation is part of the Spring Framework. It's used to indicate that a method or a class should have transactional behavior. When a method annotated with @Transactional is involved in a transaction context, the following behaviors are enabled:

1. Transaction Management:
Start a New Transaction: If a transaction is not already running, a new one will be started before the method execution.
Join an Existing Transaction: If a transaction is already running, the method will join it.

2. ACID Principles:
Atomicity: All changes made to the database within the transaction are treated as a single unit, which either completes successfully (commit) or fails (rollback).
Consistency: The database should move from one consistent state to another and data integrity is preserved.
Isolation: The data used during the transaction is isolated from other transactions until it’s committed.
Durability: Once a transaction is committed, the changes are permanent and survive future system failures.

3. Rollback Behavior:
By default, the transaction will be rolled back only in the case of runtime, unchecked exceptions.
For checked exceptions, the transaction will not be rolled back unless explicitly configured.

4. Isolation and Propagation Behavior:
Isolation Level: You can specify the isolation level, which determines how transactional operations are isolated from each other.
Propagation Behavior: You can define how the transaction should propagate. For instance, it can create a new transaction or reuse an existing one.

5. Read-Only Flag:
You can set the transaction as read-only, which is a hint to the persistence provider that the transaction should be read-only.


