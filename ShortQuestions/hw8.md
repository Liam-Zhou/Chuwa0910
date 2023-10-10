1. List all of the new annotations to your annotations.md and explain its role.

2. How do you do the debug?

    1. IDE Debugging:
       
       Most modern IDEs like Eclipse, IntelliJ IDEA, and NetBeans have built-in debuggers that provide powerful tools for debugging.

       Steps to Debug in IDE:
       
       - Set Breakpoints: Click on the left margin on the line of code where you want to pause execution.
       - Start Debugging: Right-click on your class -> Debug as -> Java Application, or click on the debug icon.
       - Step Through Code: Use step into, step over, step out, or resume to navigate through your code.
       - Inspect Variables: View the variable values at runtime.
       - Evaluate Expressions: Check the outcomes of expressions on-the-fly.
       - Modify Variables: Change the value of variables during debugging to test different scenarios.

    2. Logging:
       
       Add log statements in our code to print variable values, flow information, or error messages.
       
       ```
       import org.slf4j.Logger;
       import org.slf4j.LoggerFactory;

       public class MyClass {
          private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

          public void myMethod() {
             logger.info("This is an info message");
             logger.error("This is an error message");
          }
       }
       ```

    3. Unit Testing:

       Writing unit tests can help to identify the issues at the early stage.
       
       ```
       import org.junit.Test;
       import static org.junit.Assert.*;

       public class MyTests {

          @Test
          public void testAddition() {
             assertEquals(5, 2 + 3);
          }
       }
       ```

    4. Remote Debugging:

       If we need to debug a Java application running on another machine or environment, we can use remote debugging. Start the Java application with debugging options enabled which specify the port to connect to.
       
       ```
       java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar myapp.jar
       ```

       Then, configure our IDE to connect to that port for remote debugging.

    5. Profiling:

       Use profiling tools to analyze the application's runtime behavior. It helps to identify performance issues, memory leaks, and CPU utilization problems.

    6. Static Code Analysis:
       
       Tools like SonarQube, PMD, or Checkstyle can analyze our code without executing it and can provide insights on potential bugs, code smells, or vulnerabilities.

    7. Exception Handling:
       
       Properly handle exceptions and log them appropriately to gather information on unexpected behaviors.
       
       ```
       try {
          // code that might throw an exception
       } catch (Exception e) {
          logger.error("An error occurred: ", e);
       }
       ```

3. What is DTO, VO, Payload, DO, model?

    1. DTO (Data Transfer Object)
    
       1. Purpose:

          DTO is an object that carries data between processes, used to reduce the number of method calls, especially in a network environment.


       2. Characteristics:

          - It only contains data attributes and does not have any business logic.
          - Often used to transfer data from the persistence layer to the client.

       3. Example:
          
          ```
          public class UserDTO {
             private String name;
             private int age;
             // Getters and setters
          }
          ```

    2. VO (View Object)

       1. Purpose:

          VO is used to encapsulate data that is sent to the view layer.

       2. Characteristics:

          - It might contain formatted data, labels, and other information specific to the presentation layer.
          - It can be seen as a subset of DTO.

       3. Example:
          
          ```
          public class UserVO {
             private String displayName;
             private String ageLabel;
             // Getters and setters
          }
          ```

     3. Payload

        1. Purpose:

           It refers to the data sent in the body of a request or response message.

        2. Characteristics:

           In RESTful APIs, payloads are often sent as JSON or XML formats.

        3. Example:
           
           ```
           {
              "name": "Alice",
              "age": 30
           }
           ```
           
     4. DO (Domain Object)

        1. Purpose:

           Represents the data from the database in the object-oriented world. It might contain business logic as well.

        2. Characteristics:

           - DO is closely related to the database table structure.
           - Can represent real-world entities and their behavior.

        3. Example:
           
           ```
           @Entity
           public class UserDO {
              @Id
              private Long id;
              private String name;
              private int age;
              // Business logic, getters, and setters
           }
           ```
    
     5. Model

        1. Purpose:

           In the context of MVC (Model-View-Controller), the model represents the data layer and the rules for handling data.

        2. Characteristics:

           - It can be a representation of a real-world entity in the application.
           - Responsible for retrieving, storing, and processing data.

        3. Example:
           
           ```
           public class UserModel {
              private String name;
              private int age;
              // Business logic, getters, and setters
           }
           ```

4. What is @JsonProperty (“description”)?

    The @JsonProperty annotation is part of the Jackson library which is used to serialize and deserialize Java objects to and from JSON. This annotation can be used to control the serialization and deserialization of a Java object’s property.
    
    ```
    import com.fasterxml.jackson.annotation.JsonProperty;

    public class Product {

       private String id;

       @JsonProperty("description")
       private String desc;

       // standard getters and setters
    }
    ```
    In this example, the Java object’s desc property will be mapped to the description key in the JSON. So, if we were to serialize an object of this class to JSON, it might look something like this:
    ```
    {
       "id": "123",
       "description": "This is a sample product description."
    }
    ```
    
5. Do you know what is jackson?

    Jackson is a popular library in the Java ecosystem for processing JSON data. It provides functionalities for reading (parsing), writing (generating), and manipulating JSON data in Java. It can also be used to convert Java objects to JSON and vice versa. Jackson is often used in web applications for receiving and sending data in JSON format.

    1. Data Binding:

       Jackson supports data binding, which means it can convert JSON to and from POJO (Plain Old Java Object) using property accessor methods (getters and setters).

    2. Streaming API:

       For scenarios where performance is critical, Jackson provides a streaming API. It reads and writes JSON content as discrete events, similar to the StAX API for XML. It's highly efficient but requires more coding effort compared to data binding.

    3. Tree Model:

       Jackson can read JSON into a tree-like structure of JsonNode objects. It is similar to XML’s DOM (Document Object Model) and is suitable for scenarios where the JSON structure is flexible or complex.

    4. Annotations:

       Jackson provides a rich set of annotations for controlling serialization and deserialization, allowing developers to customize the mapping between Java objects and JSON.

    5. Compatibility:

       Jackson works well with other Java frameworks like Spring, and it’s often included as a default JSON processor.

    6. Pluggable:

       It supports custom serializers and deserializers and has a modular architecture that allows for extending its capabilities.
       
       ```
       import com.fasterxml.jackson.databind.ObjectMapper;

       public class Example {
          public static void main(String[] args) {
             ObjectMapper objectMapper = new ObjectMapper();
             String jsonString = "{\"name\":\"Alice\", \"age\":30}";

             try {
                // Deserialize JSON string into Java object
                Person person = objectMapper.readValue(jsonString, Person.class);
                System.out.println(person.getName());  // Output: Alice

                // Serialize Java object into JSON string
                jsonString = objectMapper.writeValueAsString(person);
                System.out.println(jsonString);  // Output: {"name":"Alice","age":30}
             } catch (Exception e) {
                e.printStackTrace();
             }
          }
       }

       class Person {
          private String name;
          private int age;

          // Getters and setters
       }
       ```

6. What is spring-boot-starter?

    a. What dependecies in the below starter? Do you know any starters?
      
    ```
    <dependency>
       <groupId>org.springframework.boot</groupId> 
       <artifactId>spring-boot-starter-web</artifactId> 
    </dependency>
    ```
       
    1. Dependencies Included in spring-boot-starter-web:

    - spring-boot-starter:

      Core starter, including auto-configuration support, logging, and YAML.

    - spring-web:

      Core part of Spring's web module, including the MVC framework, WebClient, WebFlux, and more.

    - spring-webmvc:

      Spring's web MVC framework.

    - jackson-databind:

      For JSON binding.

    - spring-boot-tomcat:

      Tomcat as the default embedded container.
    
    - validation-api and hibernate-validator (optional):

      For validation of the request’s parameter.

    2. Other Popular Starters:

    - spring-boot-starter-data-jpa:

      For Spring Data JPA with Hibernate.

    - spring-boot-starter-data-rest:

      To expose JPA, MongoDB, Solr, and Neo4j repositories over REST.

    - spring-boot-starter-security:

      For Spring Security.

    - spring-boot-starter-thymeleaf:

      For building MVC web applications using Thymeleaf views.
    
    - spring-boot-starter-data-mongodb:

      For the MongoDB NoSQL database.

    - spring-boot-starter-cache:

      For enabling Spring Framework’s caching support.

    - spring-boot-starter-actuator:

      For production-ready features to help monitor and manage the application 
  
7. Do you know @RequestMapping(value = “/users”, method = RequestMethod.POST)? Could you list CRUD by this style?

    The @RequestMapping annotation is used in Spring MVC to map web requests to handler functions. The value attribute is used to specify the URL where the handler function should be applied, and the method attribute is used to specify the type of the HTTP method that should be handled. Here's how we can use it for CRUD operations:
    
    1. CREATE (POST)
       
       ```
       @RequestMapping(value = "/users", method = RequestMethod.POST)
       public ResponseEntity<User> createUser(@RequestBody User user) {
          // Our code to save the user
          return new ResponseEntity<>(user, HttpStatus.CREATED);
       }
       ```

    2. READ (GET)
       
       ```
       @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
       public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
          // Our code to fetch the user by id
          return new ResponseEntity<>(user, HttpStatus.OK);
       }
       ```

    3. UPDATE (PUT)
       
       ```
       @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
       public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
          // Our code to update the user
          return new ResponseEntity<>(updatedUser, HttpStatus.OK);
       }
       ```

    4. DELETE
       ```
       @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
       public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
          // Our code to delete the user
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       ```

8. What is ResponseEntity? Why do we need it?

    ResponseEntity is a class in Spring Framework that represents the entire HTTP response, including the body, HTTP status, and headers. It provides a way to fully configure the HTTP response in your RESTful web service methods.

    Key Features:
    
    - Response Body: It can hold the response body, which will be written to the HTTP response body stream when the HTTP response is delivered to the client.
    - HTTP Status Code: It can represent the HTTP status code of the response. For example, 200 OK, 201 CREATED, 400 BAD REQUEST, etc.
    - HTTP Headers: It can also hold the HTTP headers, allowing us to add custom headers to the response.

    Why Do We Need ResponseEntity?

    - Flexibility: ResponseEntity gives complete control over the HTTP response. We can set headers, status codes, and bodies as needed.
    - Readability: When a method returns ResponseEntity, developers can quickly understand that this method is a controller endpoint that is meant to handle an HTTP request and will return an HTTP response. It makes the code more readable.
    - Strong Typing: It's a generic type, enabling the response body to be strongly typed.
    - Fluent API: It provides a fluent API to create an instance, making the code cleaner.
    - Error Handling: It is particularly useful for error handling, where we can return a customized error response with a specific HTTP status code.

9. What is ResultSet in JDBC? And describe the flow how to get data using JDBC.

    A ResultSet in JDBC represents a table of data generated by executing a query against a database. It acts as an iterator to allow you to retrieve the returned data row by row. Each ResultSet object maintains a cursor pointing to its current row of data, and the cursor can be moved forward (and in some cases backward or to a specific position) to iterate over the results.

    Key Features of ResultSet:
    
    - Cursor: A ResultSet's cursor points to the current row; initially, it is before the first row. The next() method moves the cursor to the next row.
    - Retrieve Data: It provides getter methods (getString(), getInt(), etc.) to retrieve data from the current row based on the column index or column name.
    - Types of ResultSet:
      - TYPE_FORWARD_ONLY: The cursor can only move forward.
      - TYPE_SCROLL_INSENSITIVE: The cursor can move forward and backward, and the ResultSet is not sensitive to changes made to the database.
      - TYPE_SCROLL_SENSITIVE: The cursor can move forward and backward, and the ResultSet is sensitive to changes made to the database.
    - Concurrency Types:
      - CONCUR_READ_ONLY: The ResultSet cannot be updated.
      - CONCUR_UPDATABLE: The ResultSet can be updated.

    Flow to Retrieve Data Using JDBC:
    
    1. Load JDBC Driver: Load the JDBC driver class using Class.forName() method.
       
       ```
       Class.forName("com.mysql.cj.jdbc.Driver");
       ```

    2. Establish Connection: Create a connection to the database using DriverManager.getConnection() method with the database URL, username, and password.
       
       ```
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
       ```

    3. Create Statement: Create a Statement or PreparedStatement object to execute the query.
       
       ```
       Statement statement = connection.createStatement();
       ```

    4. Execute Query: Execute the query using the executeQuery() method of the Statement object. It returns a ResultSet.
       
       ```
       ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
       ```

    5. Process ResultSet: Iterate through the ResultSet and retrieve the data.
       
       ```
       while (resultSet.next()) {
          System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
       }
       ```

    6. Close Resources: Close the ResultSet, Statement, and Connection to release the resources.
       
       ```
       resultSet.close();
       statement.close();
       connection.close();
       ```

10. What is the ORM framework?
    
    ORM (Object-Relational Mapping) is a programming technique for converting data between incompatible type systems in relational databases and object-oriented programming languages. This creates a "virtual object database" that can be used from within the programming language. There are both free and commercial packages available that perform object-relational mapping, although some programmers opt to create their own ORM tools.

    Key Concepts:
    
    - Object Mapping: Maps an object to a specific row in a database table.
    - Database Abstraction: Allows developers to interact with the database using object-oriented syntax rather than SQL.
    - Data Manipulation: Objects in the program correspond to the data in the database, and changes in the objects bring about changes in the database.
    
    Common Features of ORM Frameworks:
    
    - CRUD Operations: Simplifies the process of performing Create, Read, Update, and Delete operations.
    - Transactions: Supports database transactions to ensure data integrity.
    - Caching: Many ORM frameworks have built-in caching mechanisms to improve performance.
    - Lazy Loading: Loads the objects on demand rather than loading all objects at once, which can improve performance.
    - Associations and Relationships: Handles the mapping and operations of various database relationships like one-to-one, one-to-many, and many-to-many.

    Popular ORM Frameworks in Java:

    1. Hibernate:

       - One of the most popular ORM frameworks.
       - Rich functionality and wide community support.
       - Supports a variety of database systems.

    2. JPA (Java Persistence API):

       - It’s not a tool/framework but a specification. Various providers (like Hibernate, EclipseLink, etc.) provide the actual implementation.
       - Simplifies database handling code.
       - Annotation-based configuration.

    3. MyBatis:

       - Provides detailed and highly customizable SQL handling capabilities.
       - Allows custom SQL queries and stored procedure calls.
       - Lesser abstraction over JDBC, providing more control to the developers.

    4. Spring Data JPA:

       - It's a part of the larger Spring Data family.
       - Makes data access layer implementation easier and more robust.
       - Repository abstraction and JavaConfig are some key features.
    
11. Learn how to use ObjectMapper by this example.

12. What is the serialization and deserialization?

    Serialization:
    
    Serialization is the process of converting an object or data structure into a format that can be easily stored or transmitted, and subsequently reconstructed. This process is essential for saving the state of an object or sending it across a network between servers and clients, among other things.

    Key Points about Serialization:
    
    - Data Conversion: Converts complex data structures or objects into a format (often a byte stream) that can be easily stored or transmitted.
    - Storage and Transmission: Enables the saving of objects to files or databases and the transmission of objects over a network.
    - Object State: Preserves the state of an object including its type, data, and other attributes.

    Serialization in Java:
    
    Java provides built-in support for serialization through the java.io.Serializable interface. An object can be serialized if it implements this interface.
    
    ```
    import java.io.*;

    class Employee implements Serializable {
       String name;
       int age;

       public Employee(String name, int age) {
          this.name = name;
          this.age = age;
       }
    }

    public class SerializationExample {
       public static void main(String[] args) {
          Employee emp = new Employee("Alice", 30);

          try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
              out.writeObject(emp);
           } catch (IOException e) {
              e.printStackTrace();
           }
        }
     }
     ```

     Deserialization:

     Deserialization is the reverse process of serialization. It converts the serialized format of an object or data structure back into its original form. This is essential for retrieving the object's state or reconstructing it after transmission.

     Key Points about Deserialization:
     
     - Data Reconstruction: Converts the serialized data back into its original form, reconstructing the object or data structure.
     - Object Restoration: Restores the state of an object including its type, data, and other attributes.
     - Security: Can be a vector for security vulnerabilities, so it’s essential to ensure that only trusted sources are deserialized.
     
     Deserialization in Java:
     
     Using the ObjectInputStream class, Java allows the deserialization of objects that have been serialized.
     
     ```
     import java.io.*;

     public class DeserializationExample {
       public static void main(String[] args) {
          Employee emp = null;

          try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
              emp = (Employee) in.readObject();
           } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
           }

           if (emp != null) {
              System.out.println("Name: " + emp.name);
              System.out.println("Age: " + emp.age);
           }
        }
     }
     ```
     
     Security Considerations:
     
     - Untrusted Sources: Avoid deserializing objects from untrusted sources to mitigate security risks.
     - Validation: Validate serialized data before deserializing it to ensure its integrity.
     - Use Safe Practices: Follow security best practices to mitigate risks associated with serialization and deserialization.

13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

    ```
    import java.util.OptionalDouble;
    import java.util.stream.Stream;

    public class Main {
       public static void main(String[] args) {
           OptionalDouble average = Stream.of(20, 3, 78, 9, 6, 53, 73, 99, 24, 32)
                                       .mapToInt(Integer::intValue)
                                       .average();

           average.ifPresent(avg -> System.out.println("The average is: " + avg));
        }
    }
    ```

14. Practice https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageabl.

15. Practice https://github.com/TAIsRich/springboot-redbook/tree/04_comm.

16. Try to write the CRUD api for a new application Cassandra-Blog.
            