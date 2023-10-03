1. Seeing `annotions.md`
2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

First one specifies the `name` variable should be varchar(255) with a default value of John Snow.

The second one specifies that this attribute should map to the STUDENT_NAME in the database, the max length should be 50, it cannot be a null value, and it must be unique.

1. What is the default column names of the table in database for @Column?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

`FIRST_NAME`

`OPERATING_SYSTEM`

1. What are the layers in springboot application? what is the role of each layer?

`Controller`: It serves as presentation layer or API Layer, it receive and process HTTP requests, turn it into service calls, and return the responses to the clients.
`Service`: Implement the business logic.

`DAO`: Interactes with the database. Perfrom CRUD to the database.

1. Describe the flow in all of the layers if an API is called by Postman.

The Postman send an HTTP request(POST, PUT, GET, DELETE) to the controller. Then the controller would call the services from the Service layer. Service layer would interact with DAOs to operate the database.