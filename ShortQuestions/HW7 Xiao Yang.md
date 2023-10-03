# HW7 Xiao Yang

### 1.  Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

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
1. Client (Postman):

The API call is initiated from the client, which in this case is Postman.
Postman sends an HTTP request to the server containing information such as the HTTP method (e.g., GET, POST), headers, and the API endpoint URL.

2. Web Layer:

The HTTP request enters the Spring Boot application through the web layer.
Spring Boot's DispatcherServlet receives the request and maps it to the appropriate controller based on the URL and request method.
Request mapping annotations in the controller class define which method should handle the request.

3. Controller:

The controller method handles the incoming request. It can include business logic, validation, and other processing specific to the API's functionality.
The controller method may invoke services or other components to perform the required tasks.

4. Service Layer:

The service layer contains business logic that is typically separated from the controller to keep the code clean and modular.
The controller may delegate tasks to one or more service classes.
Services interact with repositories and perform the core operations required for the API call.

5. Repository/DAO Layer:

If your application interacts with a database, the repository or DAO (Data Access Object) layer is responsible for database operations.
This layer communicates with the database to retrieve or store data as needed.

6. Model Layer:

The model or domain layer represents the data structures and entities used in your application.
It defines the structure of objects that are passed between layers.

7. Business Logic:

During the processing of the API request, business logic is executed to perform specific tasks, such as data manipulation, calculations, or any other operations required by the API.

8. Response Creation:

Once the business logic is executed, the controller prepares a response.
The response typically includes an HTTP status code, headers, and the data or payload to be sent back to the client.

9. Web Layer (Response):

The prepared response is sent back through the web layer.
Spring Boot's DispatcherServlet handles the response and converts it into an HTTP response.

10. Client (Postman):

Finally, the HTTP response is sent back to the client (Postman).
Postman receives the response, which can include status information and data, and displays it to the user.


### 6. What is the application.properties? do you know application.yml?

- `application.properties` is a widely used configuration file format in Spring Boot applications. It uses a key-value pair syntax to configure properties.
Example application.properties file:
```properties
# Server settings
server.port=8080

# Database settings
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword

# Logging
logging.level.com.example=DEBUG

```

- `application.yml` is an alternative configuration file format that uses YAML (YAML Ain't Markup Language) syntax, which is more human-readable and supports a hierarchical structure.
Example application.yml file:
```yml
# Server settings
server:
  port: 8080

# Database settings
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: myuser
    password: mypassword

# Logging
logging:
  level:
    com.example: DEBUG

```

Both formats serve the same purpose of configuring your Spring Boot application, and you can choose the one that you find more convenient or readable for your project. YAML is often favored for its readability and support for nested structures, while properties files are simple and easy to work with for basic configurations.
### 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to mongoDB

