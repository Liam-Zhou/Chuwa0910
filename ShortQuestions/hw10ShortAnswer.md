### 4. JPA and Hibernate
JPA: a specification for object-relational mapping. Allows java developers to map their objects to database tables and 
vice versa. It uses java annotations(like @entity, @id, @column, etc...) to define how the objects map to the table.

Hibernate is the implementation of JPA. Those are just the annotations.

### 5. HikariCP and Connection Pool
It's a jdbc connection pooling library. It maintain and reuse database connections so that applications don't 
have to continuously establish new connections. This would improve performance and resource efficientcy and reduce 
delays caused by recoonections.

### 6. 
@OneToMany: a collection-valued association to another entity class that has multiplicity of one.
```java
@OneToMany(mappedBy = "customer")
private List<Order> orders = new ArrayList<>();
```

@ManyToOne: a single-valued assocaition to another entity class that has multiplicity of many.
```java
@ManyToOne
@JoinColumn(name = "customer_id")
private Customer customer;
```

@ManyToMany: A collection-valued assosiation to another entity class where both entities can havem ultiple 
associations to each other.

```ManyToMany
@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
inverseJoinColumns = @JoinColumn(name = "course_id"))

private List<Course> courses = new ArrayList<>();
```

### 7. CASCADE
Cascade allows operations performed on a source entity to cascade to target entities. Casade.ALL
contains all the operations including: persist(save a parent entity and also the related entities).
merge(update the parent entity when the related entities is called). remove(if a parent entity is deleted, child entity will also be deleted). Detach: Owning entity manually detached => 
related entity detached). orphanRemoval=true is used when the child entities shouldn't exist without 
the parent entity.

### 8. FetchType
FetchType.LAZY means the related data will not be loaded when the parent entity is loaded.
If you have a User entity with lazy collecions of 'Orders', when you retrieve 'User' from the
database, 'Orders' won't be loaded until you explicitly try to access them.

FetchType.EAGER on the other hand, will load the related data immediately when the parent entity is retrieved.

### 9. jpa naming conventions.
Entities: Upper case the first letter: 'User', 'Order', 'Product'.
Attributes: camelCase, like firstName, lastName.
Database tables: upper case, like USER, ORDER.
Database Columns: upper case, like FIRSTNAME, LASTNAME.

### 14. JPQL
Java persistence Query Language. used to perform queries against entities stored in a relational database.
For example:
String jpql = "select p from person p where p.age > 25";
TypedQuery<Person> query = entityManager.createQuery(jpql)
List<Person> results = query.getResultList();

### 15. what is @NamedQuery and @NamedQueries?
@NamedQuery: Used to define a single named query.
@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name =:name")
@NamedQueries is used for multiple query.
@NamedQueries is used to group @NamedQuery, like this @NamedQueries({@NamedQuery1, @NamedQuery2))

### 16. 
@Query is an annotation that allows you to write sql directly in its primivtive native way. 
It is written in the java script.

### 17.
hql(hibernate query language): akin to sql, operating on persistent objects. It is object-oreiented and 
can support polymorphism. example: 
```java
String hql = "FROM Student";
Query query = session.createQuery(hql);
List<Student> students = query.list();
```
Criteria Queries are a way to create queries using an object-oreietned criteria api.
```java
CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
Root<Student> studentRoot = criteriaQuery.from(Student.class);
```

### 18.
EntityManager is the core primary interface between the Java application and the databse in the context 
of JPA and ORM. You can perform many tasks like crud operations, query exectuions, and many more.

### 19.
SessionFactory is similar to a connection pool. It's a heavyweight object that's typically instantiated once for an application.
Session is analogous to an individual database connection. It's a lightweight object and is instantiated per user or transaction, and closed when the unit of work is done.

### 20.
In the context of database and object-relational mapping, a transaction is 'single unit of a complete work' to ensure data integrity and consistency. The lifecycle of a transaction includes 
beginning a transaction to turn on the database, commit a transaction that saves the changes from the database, and then rollback to end the transaction.

### 21 & 22. What is hibernate Caching?
Hibernate cache database queries, entities, and other related elements to improve the performance
by reducing database interactions.
The first level cache is the default one, it simply create the cahce when you make a query. When the session end, the cache is removed.
The second level of cache goes accross all the sessions. It's more useful for caching entites and collections that are infrequently updated and are frequently accessed.

### 23. @Transactional
As shown in the in class example, @Transactional guarantees the mutual succsess of two table's update(especially for transaction management). The sender and receiver must succesuffly sent and received the payment at the same time. Or else the transaction wouldn't be approved and no one lose or gain money.

### 24.




