1. List all of the new annotations to your annotaitons.md and explain its role.
2. how do you do the debug?
> Mainly by observing the description of the problem through logs. After locating the problem, further identify the bug at the breakpoint and fix it
3. What is DTO, VO, Payload, DO, model?
> DTO (Data Transfer Object):
Used for data transfer between different parts of an app.<br>
VO (Value Object):
Represents data by its attributes, often immutable.<br>
Payload:
The actual data sent over a network.<br>
DO (Domain Object):
Represents entities in the problem domain.<br>
Model:
Represents data or application logic.<br>
4. What is @JsonProperty("description_yyds") ?
> @JsonProperty("description_yyds") is a Java annotation used with libraries like Jackson to specify that a Java class property should be mapped to a JSON property named "description_yyds" during serialization and deserialization. It's a way to handle differences in property naming between Java and JSON.
5. do you know what is jackson?
> Jackson is a popular Java library for JSON processing, providing capabilities to serialize Java objects into JSON and deserialize JSON into Java objects.
6. What is spring-boot-stater?
> Spring-boot-starter is the naming convention for these dependencies  that simplifie the setup and configuration of a specific feature or technology. They contain pre-configured settings, libraries, and templates to quickly start working with a particular aspect of Spring Boot, such as web applications, data access, or security.
7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
> post: @RequestMapping(value = "/users", method = RequestMethod.POST)<br>
> get: @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)<br>
> update: @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT) <br>
> delete: @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
8. What is ResponseEntity? why do we need it?
> ResponseEntity in Spring is used to customize and control the HTTP response. It allows you to set the status code, headers, and response body, making it flexible for handling different types of responses and error situations in web applications.
9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
> RResultSet is an interface that represents a result set obtained from executing a database query. It provides methods to traverse and manipulate the data retrieved from a database table or view. The flow involves initializing database, executing SQL queries, receiving ResultSet, and processing data step further.
10. What is the ORM framework?
> An ORM (Object-Relational Mapping) framework is a software tool that simplifies database interactions by mapping database tables to objects in object-oriented programming languages. It allows developers to work with databases using object-oriented code, making it easier to manage and query data.
11. What is the serialization and desrialization?
>
Serialization is converting objects to a storable format, while deserialization is the reverse process, reconstructing objects from that format.
12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24,
```java
int[] arr = new int[] {20, 3, 78, 9, 6, 53, 73, 99, 24};
double avg = Arrays.stream(arr)
    .average()
    .orElse(0.0);
```