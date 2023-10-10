************************************
Q1. List all of the new annotations to your annotaitons.md and explain its role.

See annotation.md
************************************
Q2. how do you do the debug?

Set up a breakpoint at the line to be fixed. Run in debug mode. Check the variable value in the memory.  
************************************
Q3. What is DTO, VO, payload, and model? 

DTO: data transfer object : encapsulate and transport data between layers or modules of an application, 
such as between the front-end and back-end or between different components of a system.

VO: Value object: used to represent an immutable object whose equality is determined by the value it holds rather than its identity.
two Value Objects are considered equal if their attribute values are the same, even if they are different instances in memory.

payload: In a Java Spring Boot project, a "payload" typically refers to the data that is sent in the body of an HTTP request or response. (DTO).

model: Models in Spring Boot projects are commonly used to encapsulate and manage data, making it easier to work with and manipulate data within the application.
************************************
Q4. What is @JsonProperty("description_yyds")?

`@JsonProperty` is an annotation provided by Jackson library which is commonly used for JSON serialization and deserialization. 
The @JsonProperty annotation allows you to specify the name of a property or field when it is serialized to or deserialized from JSON.

1. Changing the JSON Property Name During Serialization:

You can use @JsonProperty to specify a different name for a property when it is serialized to JSON. This can be useful when you want to map a Java object property to a different JSON property name.
            
        public class MyObject {

            @JsonProperty("customName")
            private String propertyName;

            // Getters and setters
        }
> Here, when you serialize MyObject to JSON, the property propertyName will be represented as "customName" in the JSON output.
2. Mapping JSON Property Name During Deserialization: Understand it in the same way as Serialization.
************************************
Q5. What is jackson?

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.3</version>
            <scope>compile</scope>
        </dependency>
Jackson is a popular Java library used in Spring Boot and many other Java applications for handling JSON data. 
It provides a set of tools to work with JSON, including both JSON serialization (converting Java objects to JSON) and deserialization (converting JSON to Java objects).
Jackson is widely used in Spring Boot applications to facilitate the integration of JSON data with Java objects.
    
        MyObject myObject = objectMapper.readValue(jsonString, MyObject.class);
************************************
Q6. What is spring-boot-starter? 

This is a special type of dependency in java spring boot project that `simplifies the process` of including common sets of dependencies in your application
The naming convention for Spring Boot starters is spring-boot-starter-*, where * is a descriptive name of the starter. Here are a few common examples:
1. spring-boot-starter-web: Provides Spring MVC(a framework for build web application), embedded web servers, HTTP message conversion
2. spring-boot-starter-data-jpa: Include Jpa, Hibernate, and a database driver.
3. spring-boot-starter-security: Add security features, a powerful framework for authentication and authorization. 
4. spring-boot-starter-test: It includes dependencies for JUnit, TestNG, and other testing frameworks
5. spring-boot-starter-actuator: Help you monitor and manage your application. It includes endpoints for health checks, metrics, and other management operations.

> These starters contain a predefined set of dependencies, configuration files, and often default behavior, 
making it easier to set up and work with specific technologies or features in your Spring Boot application.
************************************
Q7. Do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? Could you list CRUD by this style?

Basically, `@RequestMapping(value = "/users", method = RequestMethod.POST)` this is a way to specify URL and http method in @RequestMapping annotation. 
By using this annotation, the target method or controller can only handle the Post method. 

If we use `@RequestMapping` without method specification, we can let one method handle multiple Http method such as POST, GET, PUT, and DELETE. 

@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)

@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

@RequestMapping(value = "/users", method = RequestMethod.POST)

@RequestMapping(value = "/users", method = RequestMethod.GET) //get all

@RequestMapping(value = "/users/{id}", method = RequestMethod.GET) // get by id
************************************
Q8. What is ResponseEntity? why do we need it? 

        new ResponseEntity<>(postResponse, HttpStatus.OK);
        new ResponseEntity<>(postResponse,
        HttpStatus.CREATED);
        ResponseEntity.ok(postService.getPostById(id));

ResponseEntity is a class that represents the entire HTTP response, including the status code, headers, and the response body. 
We need it for a HTTP Response Control, Response with status code, allow us to custom headers, and error handling. 
************************************
Q9. What is ResultSet in jdbc? And describe the flow how to get data using JDBC. 

ResultSet is an interface provided by the Java API for interacting with the result set of a database query. 
A result set represents the data retrieved from a database after executing an SQL query.

JDBC flow: 
1. Load the JDBC driver.  // Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
2. Establish a Database Connection.
3. Create a SQL Statement.
4. Process the Result Set.
5. Close Resources.
6. Handle Exceptions. //SQLException()
************************************
Q10. What is ORM framework? 

ORM stands for Object-Relational Mapping. It's a framework that allows you to interact with a relational database using an object-oriented programming language,
(Hibernate in java). 
************************************
Q11. Learn how to use ObjectMapper. 

ObjectMapper:  converting Java objects to JSON and vice versa. It provides a simple way to serialize and deserialize Java objects to and from JSON format.

Dependency: 

    <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.5</version> <!-- Use the latest version -->
    </dependency>

Create objectMapper instance: 

    ObjectMapper objectMapper = new ObjectMapper();
Serialize an Object to JSON: `writeValueAsString()`

    try {
        String jsonString = objectMapper.writeValueAsString(yourObject);
        System.out.println(jsonString);
    } catch (Exception e) {
        e.printStackTrace();
    }
Deserialize JSON to an Object: `readValue()`
    
    try {
        YourClass object = objectMapper.readValue(jsonString, YourClass.class);
        // Now you have your Java object
    } catch (Exception e) {
        e.printStackTrace();
    }
************************************
Q12. What is Serialization and Deserialization? 

Serialization and deserialization are processes in Java that involve `converting objects into a byte stream` (serialization) 
and then `reconstructing objects from that byte stream` (deserialization). 
These processes are primarily used for the persistence of objects, which means saving an object's state to a file or transmitting it over a network. 
Serialization is a fundamental concept in Java, often used in scenarios like saving object data, caching, 
or distributing objects across different systems.
************************************
Q13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

Suppose input array: int[] a = [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]

        double average = Arrays.stream(a).average.orElse(0.0);
************************************
Q14. Copy branch-3
************************************
Q15. Copy branch-4
************************************
Q16. Spring Data for Apache Cassandra

Cassandra is a highly scalable and distributed NoSQL database system designed for handling large volumes of data across multiple commodity servers while providing high availability and fault tolerance. 
In Spring Boot, you can use the Spring Data Cassandra project to integrate Cassandra with your Spring Boot application. Only for Cassandra database. 
************************************





