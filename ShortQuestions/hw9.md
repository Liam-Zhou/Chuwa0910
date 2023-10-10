# hw9

1.  List all of the new annotations to your annotaitons.md and explain its role.  
    see `ShortQuestions/annotations.md`.
2.  how do you do the debug?  
    In production, the first thing is to find the Logs and see the error message.  
    When I encounter some bugs, I will add a breakpoint in my IDE, and then using debug mode to execute the program. By doing this, I can see the variable at the point of my breakpoint, so that allows me to find the error in the code.
3.  What is DTO, VO, Payload, DO, model?  
    DTO: Data Transfer Object, used to carry data among different layers of an application.  
    VO: Value Object, immutable, represent attributes or values that don't have a distinct identity.  
    Payload: the real meaningful data itself rapped by the outer data structure, like the request body of HTTP requests.  
    DO: Data Object, represent the core business entities or concepts within an application.  
    Model: include both domain objects (DOs) that represent the business entities and DTOs or VOs used for data transfer between the application's layers.
4.  What is `@JsonProperty("description_yyds")`?  
    `@JsonProperty` is an annotation provided by the Jackson library, it maps a class to a JSON property. `description_yyds` define the field within the Json property.  
    Usage:
    ```java
    public class MyObject {
        @JsonProperty("description_yyds")
        private String description;
    }
    ```
    will link to Json:
    ```json
    {
        "description_yyds": "Some description text"
    }
    ```
5.  do you know what is jackson?  
    Jackson is a library for processing Json data. 
6.  What is spring-boot-starter? what dependencies in the below starter? do you know any starters?  
    - spring-boot-starter is a pre-packaged and opinionated set of dependencies that simplifies the process of setting up and configuring specific functionality in a Spring Boot application. Spring Boot starters are designed to help developers get started quickly with common use cases and reduce the complexity of managing dependencies.  
    - Below is the starter as `spring-boot-starter-web`, used for building web applications with Spring Boot. This starter includes Spring MVC, embedded web servers, and other related dependencies and configurations.  
    - Some other starters: `spring-boot-starter-data-jpa` for data access using JPA, `spring-boot-starter-security` for security authentication, `spring-boot-starter-test` for unit tests and integration tests.

7.  do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)`? could you list CRUD by this style?  
    It defines a controller method that handles HTTP POST requests at path `/users`. 
    - create: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
    - get all: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
    - get one: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)`
    - update: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)`
    - delete: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)`
8.  What is ResponseEntity? why do we need it?  
    `ResponseEntity` is a class represents an HTTP response. The benefits using it includes:
    - contains a HTTP status code;
    - configure the requests' headers;
    - make the response type flexible, including Json, XML, HTML, etc.
9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC.  
    JDBC is Java Database Connectivity, `ResultSet` is an interface that represents the result set of a database query. It is a tabular data structure that contains the results of an executed SQL query, typically the rows and columns of data retrieved from a database table. The `ResultSet` interface provides methods for retrieving and manipulating this data.  
    The flow of getting data is as follows:
    - Establish a Database Connection: ```Connection connection = DriverManager.getConnection(jdbcUrl, username, password);```
    - Create a Statement: ```Statement statement = connection.createStatement();```
    - Execute SQL Query: ```ResultSet resultSet = statement.executeQuery("SELECT * FROM table");```
    - Retrieve Data from `ResultSet`: 
        ```
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
        }
        ```
10. What is the ORM framework?   
    ORM is Object-Relational Mapping, it is used to connect object-oriented programming to relational database. In Spring boot, the most used ORM is Hibernate, it provided lots of built-in functions allows the user to seamlessly interact with database within spring boot.
11. Learn how to use ObjectMapper by this example: https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java  
    `ObjectMapper` is provided by the Jackson library, allows user to convert between Java objects and JSON data, making it easy to serialize Java objects into JSON format (serialization) and deserialize JSON data into Java objects (deserialization).  
    - Serialization: ```String s = objectMapper.writeValueAsString(foodOutlet);```
    - Deserialization: ```FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);```
12. What is the serialization and deserialization? https://hazelcast.com/glossary/serialization/  
    - Serialization: converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form, like Json.
    - the reverse process of Serialization, unpack data like Json into a data structure in program.
13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
    ```java
    class Solution{
        public avarage(){
            int[] input = [20, 3, 78, 9, 6, 53, 73, 99, 24, 32];
            double answer = Arrays.stream(input).average().orElseThrow();
        }
    }
    ```
14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageabl
    e，你也可以像我一样分branch添加新代码。
