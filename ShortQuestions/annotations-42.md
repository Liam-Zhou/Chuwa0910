@OneToMany:This annotation is typically used in JPA (Java Persistence API) to define a one-to-many relationship between two entities. For example, if you have an entity called Author and another entity called Book, you can use @OneToMany to specify that one author can have many books. This annotation is often accompanied by a @JoinColumn annotation to specify the foreign key column in the database.<br>

@ManyToOne: This annotation is also used in JPA to define the other side of a one-to-many relationship. In the example above, you would use @ManyToOne on the Book entity to specify that many books belong to one author. This annotation is used to map the foreign key relationship in the database.<br>

@ManyToMany:This annotation is used to define a many-to-many relationship between two entities. In a many-to-many relationship, an instance of one entity can be associated with multiple instances of another entity, and vice versa. For example, if you have entities for Student and Course, you can use @ManyToMany to specify that students can enroll in multiple courses, and each course can have multiple students.<br>

@Repository:This annotation is commonly used in Spring Framework to indicate that a class is a repository, which typically provides data access and persistence operations for a specific domain entity. It is often used with Spring Data JPA to create a repository for working with database entities. Spring provides various features like CRUD operations, query methods, and more for repositories annotated with @Repository.<br>

@JsonProperty("name"):@JsonProperty is an annotation commonly used in libraries like Jackson, which is used for JSON (de)serialization in Java. It is used to map a Java class field or property to a specific JSON property when converting Java objects to JSON and vice versa. In this case, "name" is the name of the JSON property to which the annotated field or property will be mapped.<br>

@JoinColumn(name = "post_id", nullable = false):@JoinColumn is an annotation typically used in JPA (Java Persistence API) to specify the configuration of a foreign key column in a database table when defining entity relationships. In this case, name is used to specify the name of the foreign key column in the database table, and nullable = false indicates that the foreign key column should not allow null values.<br>

