# HW7 Xiao Yang

### 1.  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you 
  understand it. you need to update it when you learn a new annotation. Please organize those annotations 
  well, like annotations used by entity, annotations used by controller.
1.  File name: **annotations.md**
2.  you'd better also list a code example under the annotations.

[File Here: annotations.md](./annotations.md)

### 2.  Explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

- `columnDefination` specifies the SQL definition for the column, in this case, it means that the column will be of type VARCHAR with a maximum length of 255, and a default value of 'John Snow'
- `name` means that it maps to the column named "STUDENT_NAME", `length` means the maximum length of it is 50, and it can not be `null` and allowed to have same value.

### 3.  What is the default column names of the table in database for  @Column ?

 ```java
@Column
private String firstName;
@Column
private String operatingSystem
 ```

In JPA and Hibernate, when using `@column` without clarifying any attributes, the default column name in datebases will be derived from the name of the Java fields by following rules:

- Camel Case to Underscore: If the Java field name is in camelCase ( `firstName`), JPA will convert it to underscore-separated format (`first_name`) for the database column name.
- No Conversion: If the Java field name is already in underscore-separated format (`first_name`), JPA will use it as-is for the database column name.

So in this case, the default column names for example above would be

`private String firstName` ->`first_name`

`private String operatingSystem` -> `operating_system`



### 4. What are the layers in springboot application? what is the role of each layer?

There are mainly three layers in a Springboot application. They are:

- Presentation Layer

  In this layer, authentication and format translation works would be done.

- Business Layer

  In this layer, some business logics, validation works and authorization would be done.

- Persistence Layer

  In this layer, it ensures and manage the storage logics and mapping to the actual database.

### 5. Describe the flow in all of the layers if an API is called by Postman.



### 6. What is the application.properties? do you know application.yml?



### 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to mongoDB