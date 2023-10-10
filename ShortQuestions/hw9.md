###### 2.  how do you do the debug?
Mark the breakpoint, run with the debug mode, then step by step, add watch variables if necessary.

###### 3.  What is DTO, VO, Payload, DO, model?
___DTO___ (Date Transfer Object): Used to transfer data between different parts of an application, often between the business logic layer nad the presentation layer
___VO___ (Value Object): Represents a value ranther than an entity with an identity
___Payload___: The data transmitted in the body of a message, such as JSON or XML data in an HTTP request or response.
___DO___ (Domain Object): An object representing a core entity in the application's domain model.
___Model___: Refers to data structures, classes, or entities used to represent and manipulate data within an application
###### 4.  What is @JsonProperty("description_yyds")?
Used to map a Java class field to a specific JSON property when serializing or deserializing JSON data.

###### 5.  do you know what is jackson?
Provides APIs for both reading (parsing) and writing (generating) JSON data.

###### 6.  What is spring-boot-stater?
A dependency package that simplifies project setup by providing curated dependencies, pre-configured settings, and auto-configuration for specific functionality

###### 7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
Above one is for creating.
```
R:
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
U:
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
D:
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
```
###### 8.  What is ResponseEntity? why do we need it?
A class in Spring Framework (including Spring Boot) that represents an HTTP response, allowing you to customize and control the response sent back to the client when handling web requests. It provides a way to encapsulate the response status, headers, and body content in a single object.

###### 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
An interface that represents the result set of a database query.
Astablish a database connection, execute SQL queries to get the ResultSet, then iterate through rows to access and process data.

###### 10. What is the ORM framework?
Tool that simplifies the interaction between a Java or other object-oriented programming language application and a relational database.

###### 12. What is the serialization and desrialization?
___Serialization___ is the process of converting a data structure or object into a format (such as binary, JSON, XML, or other) that can be easily saved to a file or transmitted over a network.
___Deserialization___ is the reverse process of serialization. It involves reconstructing an object or data structure from the serialized format.
###### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
double average = Arrays.stream(array)
                       .average()
                       .orElse(0);
```