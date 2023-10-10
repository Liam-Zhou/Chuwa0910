2.
In IDE, mark a breakpoint, then start debug, click next step, find the value we want

3.
DTO: (Data Transfer Object): Transfer data between software application subsystems or layers, minimizing the number of method calls, especially in a network environment.
VO (Value Object): Used in the presentation layer for displaying data.
Payload: Typically used in the context of transmitting data - especially in API/Networking and Message Brokers.
DO (Data Object): Represents entities in the data storage layer, commonly reflecting database tables.
Model: A general term that can be used in different contexts like MVC (Model-View-Controller), ML (Machine Learning), or others.

4.
The @JsonProperty annotation is used to specify the property name in a JSON object when serializing or deserializing a Java object using the Jackson library

5.
Jaskon provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (JsonNode), or JSON documents to Java Maps/Lists and vice-versa.
the given dependency can do the following things:
1). Data Binding
It allows you to serialize Java objects to JSON and deserialize JSON string into Java objects. This is typically known as "data-binding".

2). Tree Model
You can deal with JSON in a tree model fashion. JsonNode can be used to represent a JSON object graph in memory.

3). Streaming API
Although jackson-databind is more commonly used for data-binding, it indirectly utilizes Jackson’s streaming API (jackson-core) to serialize and deserialize JSON efficiently, which is super useful for handling large JSON data due to its low memory usage and high efficiency.

6.
Spring Boot Starters are dependency descriptors that can be added under the dependency section in pom. xml.

spring-boot-starter-web is the starter in the below code

spring-boot-starter: The core starter, including auto-configuration support, logging, and YAML.
spring-boot-starter-logging: Logging starter using Logback.
spring-boot-starter-test: Starter for testing Spring Boot applications with libraries such as JUnit.
spring-boot-starter-web: For developing web applications using Spring MVC. It includes Tomcat as the default embedded servlet container.
spring-boot-starter-data-jpa: For Spring Data JPA with Hibernate.

7.
This annotation is used in Spring MVC to map web requests to specific handler classes and/or handler methods

post
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Logic to create a user
    ...
}

get
@RequestMapping(value = "/users", method = RequestMethod.GET)
public ResponseEntity<List<User>> getAllUsers() {
    // Logic to get all users
    ...
}

put
@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
    // Logic to update a user by ID
    ...
}

delete
@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    // Logic to delete a user by ID
    ...
}

8.
ResponseEntity is a class in Spring Framework, and it represents an HTTP response, including the headers, body, and status. When building RESTful APIs using Spring MVC, ResponseEntity is used to create a response to be sent back via the HTTP protocol to the client (such as a web browser or mobile app) making the request.
why we need it?
Full Control Over HTTP Response
Type Safety and Generics
Fluent API Style


9.
ResultSet is an object that holds the data retrieved from a database after you execute an SQL query using Statement objects. It acts as an iterator to allow you to traverse through each row of the result set, and for each row, you can retrieve the column values.
1. Load JDBC Driver
2. Establish Connection
3. Create Statement
4. Execute Query
5. Process ResultSet
6. Close Resources

10.
Object-relational mapping (ORM) is a way to align programming code with database structures. ORM uses metadata descriptors to create a layer between the programming language and a relational database.

12.
Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form
Deserialization is the opposite of serialization - it is the process of converting serialized data back into its original form (object or data structure).

13.
public class Main {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

        double average = Arrays.stream(numbers)
                               .summaryStatistics()
                               .getAverage();

        System.out.println("Average: " + average);
    }
}










