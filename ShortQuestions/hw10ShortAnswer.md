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


