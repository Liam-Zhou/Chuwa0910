# HW7 Xiao Yang

### 1. List all of the new annotations to your annotaitons.md and explain its role.

[File Here: annotations.md](./annotations.md)

### 2. How do you do the debug?

When using `IntelliJ` as IDE, I would set some breakpoints for some lines and debug. During the debug process, I would check every variable for its type and value, to see if the result is under expectation or not. In this case, I could figure out the problems came out from which lines and handle it.

### 3. What is DTO, VO, Payload, DO, model?
- DTO (Data Transfer Object):

- - DTO is a design pattern used to transfer data between different layers or components of an application, typically between the presentation layer (UI) and the business logic or data access layer.
- - DTOs are often used to encapsulate data and send it as a single object, reducing the number of remote calls and improving performance.
- - DTOs typically contain only the data fields needed for a specific operation, which can be different from the structure of the underlying domain objects.
- VO (Value Object):

- - A Value Object is a design pattern used to represent an immutable object whose value is determined by its attributes or properties.
- - Value Objects are often used to represent simple, atomic values, such as strings, numbers, dates, or currency amounts.
- - They are typically used to ensure data consistency and can be used as building blocks for more complex objects.
- Payload:

- - The term "payload" in software development generally refers to the data that is being transmitted or processed in a communication or messaging system.
In the context of HTTP requests and responses, the payload is the data being sent or received in the body of the message. This data can be in various formats, such as JSON, XML, or binary data.

- - Payload can also refer to the data being carried by a message in a message queue or communication between microservices.
- DO (Domain Object):

- - A Domain Object represents an entity or concept within the domain or problem space that an application is designed to solve.
- - Domain Objects are closely related to the business logic of an application and typically encapsulate behavior and data specific to that domain.
- - They may also be referred to as domain entities and are often a part of domain-driven design (DDD) practices.
- Model:

- - In the context of software development, "model" is a broad term that can have different meanings depending on the context.
- - It can refer to the representation of data and its structure, such as a data model that defines the relationships and attributes of data entities.
It can also refer to a software design pattern, like the Model-View-Controller (MVC) pattern, where the model represents the application's data and business logic.
In machine learning and data science, a model is a mathematical or computational representation used for prediction or analysis.

### 4. What is @JsonProperty("description_yyds")?

`@JsonProperty("description_yyds")` is a Java annotation used in the context of object serialization and deserialization with libraries like Jackson. It is typically applied to a field or getter method within a Java class to specify the mapping between a JSON property and a Java object property when converting JSON data to Java objects or vice versa.

- Serialization: When you want to convert a Java object into a JSON representation, the @JsonProperty annotation allows you to specify the name of the JSON property that should be used for a particular Java object property. In this case, "description_yyds" would be the name of the JSON property that will be used when serializing the Java object.

Example:
```java
public class MyClass {
    @JsonProperty("description_yyds")
    private String description;

    // Getter and setter methods for 'description' property
}

```
If you serialize an instance of MyClass to JSON, it would look like this:
```json
{
    "description_yyds": "Some description"
}
```

- Deserialization: When you want to convert JSON data back into a Java object, the @JsonProperty annotation allows you to specify the name of the JSON property that corresponds to a particular Java object property. In this case, it tells the deserialization library that when it encounters the "description_yyds" property in JSON data, it should map it to the "description" property of the Java object.

Example:
```java
public class MyClass {
    @JsonProperty("description_yyds")
    private String description;

    // Getter and setter methods for 'description' property
}
```
If you have JSON data like this:
```json
{
    "description_yyds": "Some description"
}
```
When you deserialize this JSON into a MyClass object, the "description" field will be populated with the value "Some description."

### 5. Do you know what is jackson?
`Jackson` is a widely used Java library for working with JSON (JavaScript Object Notation) data. It provides a set of APIs and tools for both serializing Java objects into JSON format (serialization) and deserializing JSON data into Java objects (deserialization). Jackson is commonly used in Java applications to handle JSON data, making it easier to work with web APIs, exchange data between systems, and store data in a human-readable format.
Some key features and components of Jackson include:

`ObjectMapper`: The ObjectMapper class is at the core of Jackson and is used for converting JSON data to Java objects (deserialization) and Java objects to JSON (serialization). It allows you to customize the mapping between JSON properties and Java object properties, handle different data types, and manage JSON data in a flexible way.

`Annotations`: Jackson provides a set of annotations (e.g., @JsonProperty, @JsonIgnore) that allow you to customize how JSON data is mapped to Java objects and vice versa. These annotations are applied to fields, methods, or classes to control the serialization and deserialization process.

`Streaming API`: Jackson offers a low-level streaming API that allows you to process JSON data incrementally as it's being read or written. This can be useful for working with large JSON documents or when you need fine-grained control over the parsing or generation process.

`Data Binding`: Jackson supports automatic data binding, which means it can automatically map JSON data to Java objects based on their structure and data types. It can also handle complex data structures, such as lists, maps, and nested objects.

`Support for Various Data Formats`: While Jackson is primarily known for JSON, it also provides support for other data formats, such as XML and Smile (binary JSON). This flexibility makes it a versatile choice for data serialization and deserialization needs.

`Modularity`: Jackson is designed to be modular, allowing you to include only the components you need in your project, reducing the footprint if you're concerned about size and performance.

`Open Source`: Jackson is open-source software and is widely adopted in the Java community. It is commonly used in web applications, RESTful web services, and various other Java-based projects.

### 6. What is spring-boot-starter? 
The `spring-boot-starter-web starter` is a versatile choice for developing web applications in Spring Boot. It sets up a basic web application environment with sensible defaults and allows you to quickly start building web-based projects. You can always customize and add additional dependencies based on your specific requirements as your project evolves.

a. what dependecies in the below starter? do you know any starter
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Here are some of the key dependencies that are typically included when you use the spring-boot-starter-web:

Spring MVC: The Spring Framework's Model-View-Controller (MVC) framework is included, allowing you to build web applications with a structured architecture.

Embedded Web Server: An embedded web server, such as Apache Tomcat or Jetty, is included. You don't need to set up a separate web server; Spring Boot takes care of it.

Spring Web: This includes the core Spring Web components, such as the DispatcherServlet and other classes necessary for handling HTTP requests and responses.

Spring Boot: Various Spring Boot libraries and utilities are included to simplify web application development, including auto-configuration for web-related features.

Jackson: The Jackson library is included for JSON serialization and deserialization. This allows you to easily work with JSON data in your web applications.

Validation: Dependencies for Spring's validation framework are included. This is helpful for form validation and data validation in your web application.
### 7. Do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? Could you list CRUD by this style
It defines a controller method that handles HTTP POST requests at path `/users`. 
- create: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
- get all: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
- get one: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)`
- update: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)`
- delete: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)`


### 8. What is ResponseEntity? why do we need it?
`ResponseEntity` is a class in the Spring Framework that represents an HTTP response. It provides a way to control and customize the HTTP response that your Spring application sends back to the client, including the response status code, headers, and body. ResponseEntity is commonly used in Spring-based web applications to craft and send HTTP responses with more control and flexibility than returning a simple object.

The reasons why we use it:

- Customizing the HTTP Status Code: With ResponseEntity, you can explicitly set the HTTP status code that should be returned in the response. This is useful when you want to communicate the success or failure of a request with the appropriate status code (e.g., 200 for success, 404 for not found, 500 for internal server error).

- Setting Response Headers: You can add custom HTTP headers to the response using ResponseEntity. This is handy for including metadata, such as content type, caching directives, or custom headers specific to your application.

- Providing a Response Body: ResponseEntity allows you to wrap the response body (data that gets sent back to the client) along with the status code and headers. This enables you to return different types of responses, including JSON, XML, HTML, or plain text, depending on the needs of your API or web application.

- Handling Errors: When dealing with exceptions or errors in your application, you can use ResponseEntity to create structured error responses. For example, you can return a JSON object with an error message and an appropriate status code (e.g., 404 for resource not found, 400 for a bad request).


### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC.
In JDBC (Java Database Connectivity), a `ResultSet` is an interface that represents a result set of data retrieved from a relational database after executing a SQL query. It provides methods for traversing and manipulating the data retrieved from the database. A ResultSet essentially acts as a cursor or iterator for the query results, allowing you to navigate through the rows and retrieve column values.

Here's the flow for getting data using JDBC:

- Load the JDBC Driver:
Before you can connect to a database, you need to load the appropriate JDBC driver for your database system. This is typically done using the` Class.forName()` method to dynamically load the driver class.

- Establish a Database Connection:
Use the DriverManager class to establish a connection to the database by providing the database URL, username, and password.

- Create a Statement:
To execute SQL queries, you need to create a Statement or a PreparedStatement object. Statement is used for simple SQL queries, while PreparedStatement is used for parameterized queries to prevent SQL injection.

- Execute a SQL Query:

Use the executeQuery() method of the Statement or PreparedStatement object to execute a SQL query. This method returns a ResultSet containing the result set of data from the query.

- Retrieve Data from the ResultSet:

You can use methods like next(), getString(), getInt(), etc., to traverse the ResultSet and retrieve data.

- Close Resources:

After you have finished working with the ResultSet, Statement, and Connection, it's important to close these resources to release database connections and resources.

- Handle Exceptions:

JDBC operations can throw exceptions, such as SQLException. It's crucial to handle these exceptions properly, either by handling them in your code or by propagating them up the call stack.

### 10. What is the ORM framework?
ORM stands for Object-Relational Mapping. It is a programming technique and framework that allows developers to work with relational databases in an object-oriented manner. ORM bridges the gap between the object-oriented programming world and the relational database world by providing a way to map database tables and their relationships to classes and objects in code.

### 11. Learn how to use ObjectMapper by this example

```
FoodOutlet foodOutlet = objectMapper.readValue(resBody FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```

### 12. What is the serialization and desrialization?
[See here](#4-what-is-jsonpropertydescription_yyds)
### 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24]

```java
int[] arr = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24};

double avg = Arrays.stream(arr).average().orElse(0.0);
```

