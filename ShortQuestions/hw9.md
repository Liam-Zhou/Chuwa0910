### 1. How do you debug ?
  
   To debug code, I follow these steps:

* Identify the problem. What is the code supposed to do, and what is it actually doing? What is the error message, if any?
* Isolate the problem. Where in the code is the problem occurring? This may involve narrowing down the problem to a specific line of code or function.
* Reproduce the problem. Once I have isolated the problem, I try to reproduce it consistently. This helps me to ensure that I am actually debugging the correct problem.
* Understand the code. I take some time to understand the code around the problem. This helps me to identify the potential causes of the problem.
* Use debugging tools. I use debugging tools to step through the code line by line and inspect the values of variables. This helps me to identify the exact line of code where the problem is occurring.

### 2. What is DTO, VO, Payload, DO, model?

* DTO stands for Data Transfer Object. It is a design pattern used to transfer data between different layers of an application or between different applications. DTOs are typically used to transfer data between the presentation layer and the business logic layer, or between the business logic layer and the data access layer.

* VO stands for Value Object. It is a special type of object that represents a single value, such as a number, string, or date. VOs are typically immutable and have no business logic. They are often used to encapsulate data and make it easier to transfer and manipulate.

* Payload is a term used to describe the data that is being transferred between two systems. It can be a DTO, VO, or any other type of data object.

* DO stands for Domain Object. It is a representation of a real-world entity, such as a customer, order, or product. DOs typically have business logic associated with them and are used to model the business domain of an application.

* Model is a general term used to describe a representation of a real-world system or entity. Models can be used for a variety of purposes, such as simulation, analysis, and design.

### 3. What is @JsonProperty("description_yyds") ?

In Java, @JsonProperty("description_yyds") is an annotation used in Jackson, a popular Java JSON serialization/deserialization library. This annotation is used to specify the JSON property name for a Java object's field during the serialization and deserialization processes.

Example :

```Java

public class MyObject {
    @JsonProperty("description_yyds")
    private String description;

    // Constructors, getters, setters, etc.
}
```

In this example, the @JsonProperty("description_yyds") annotation is applied to the description field. When you serialize an instance of MyObject to JSON, the resulting JSON will have a property named "description_yyds" instead of "description":

```jason

{
    "description_yyds": "some description"
}
```
### 4. Do you know what is jackson?

Jackson is a high-performance JSON processor for Java. It is a popular library for serializing and deserializing Java objects to and from JSON. Jackson is fast, efficient, and easy to use. It also supports a variety of other data formats, such as XML, CSV, and YAML.


### 5. what is spring-boot-starter? what dependecies in the below starter? do you know any starters?

What is spring-boot-starter?

A Spring Boot starter is a dependency that provides a set of common dependencies for a particular type of application. For example, the spring-boot-starter-web dependency provides all of the dependencies needed to build a basic web application using Spring Boot.

What dependencies are in the spring-boot-starter-web starter?

The spring-boot-starter-web starter includes the following dependencies:

* spring-boot-starter-tomcat
* spring-boot-starter-validation
* jackson-databind
* spring-web
* spring-webmvc
  
Do you know any other starters?

Yes, there are many other Spring Boot starters available. Here are a few examples:

* spring-boot-starter-data-jpa - Provides dependencies for using JPA to access a database.
* spring-boot-starter-thymeleaf - Provides dependencies for using Thymeleaf to render HTML templates.
* spring-boot-starter-security - Provides dependencies for using Spring Security to secure your application.
* spring-boot-starter-actuator - Provides dependencies for exposing application metrics and health information.

### 6. Do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ?  ? could you list CRUD by this style?

Yes, it is a Spring Boot annotation that maps a POST request to the /users endpoint.

Here is a list of CRUD operations using the same style:

```Java

// Create a new user
@RequestMapping(value = "/users", method = RequestMethod.POST)
public User createUser(@RequestBody User user) {
  // ...
}

// Read all users
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> readUsers() {
  // ...
}

// Read a single user by ID
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public User readUser(@PathVariable("id") Long id) {
  // ...
}

// Update a user
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
  // ...
}

// Delete a user
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public void deleteUser(@PathVariable("id") Long id) {
  // ...
}
```

### 7. What is ResponseEntity ?  why do we need it?


ResponseEntity is a Spring Boot class that represents an HTTP response. It contains the status code, headers, and body of the response.

We need ResponseEntity because it gives us complete control over the HTTP response. We can use it to set the status code, headers, and body of the response to whatever we want. This is useful for a variety of reasons, such as:

* We can use it to return custom error messages.
* We can use it to set custom caching headers.
* We can use it to return different types of content, such as JSON, XML, or HTML.

### 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet in JDBC is a tabular data structure that represents the results of a database query. It contains a cursor that can be used to iterate through the rows of the data.

To get data using JDBC, you can follow these steps:

<ol>
<li> Create a Connection object to the database.</li>
<li>Create a Statement object to execute the query.</li>
<li>Execute the query using the Statement object.</li>
<li>Get the ResultSet object from the Statement object.</li>
<li>Iterate through the rows of the ResultSet object using the cursor.</li>
<li>Get the data from each column of the row using the getter methods of the ResultSet object.</li>
<li>Close the ResultSet object, the Statement object, and the Connection object.</li>
</ol>

Here is an example of how to get data using JDBC:

```Java
import java.sql.*;

public class Main {
  public static void main(String[] args) throws Exception {
    // Create a Connection object to the database.
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "password");

    // Create a Statement object to execute the query.
    Statement statement = connection.createStatement();

    // Execute the query.
    ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

    // Iterate through the rows of the ResultSet object.
    while (resultSet.next()) {
      // Get the data from each column of the row.
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");

      // Print the data to the console.
      System.out.println("id: " + id + ", name: " + name + ", email: " + email);
    }

    // Close the ResultSet object, the Statement object, and the Connection object.
    resultSet.close();
    statement.close();
    connection.close();
  }
}
```

### 9 What is the ORM framework?

An ORM (object-relational mapping) framework is a software development tool that helps developers map objects in their code to relational database tables. This makes it easier to interact with databases and perform CRUD operations (create, read, update, and delete) on data.

ORM frameworks typically work by generating code that translates between object-oriented programming concepts and SQL. This code can then be used to execute database queries and manage data in a way that is natural and efficient for developers.
