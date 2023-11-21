# hw9 - Ke Chen

## 1. List all of the new annotations to your annotaitons.md and explain its role.

see files: annotations.md

## 2.  how do you do the debug? 主要要答：log
Debugging by checking logs is a common and effective method for identifying and resolving issues in your code. Here are the steps to debug using log messages:

1. **Add Log Statements**:
   - Insert log statements at relevant points in your code where you suspect there may be issues. Common logging libraries in Java include Log4j, Logback, and java.util.logging.

   ```java
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;

   public class MyService {
       private static final Logger logger = LoggerFactory.getLogger(MyService.class);

       public void doSomething() {
           logger.debug("Entering doSomething() method");
           // Your code logic here
           logger.debug("Exiting doSomething() method");
       }
   }
   ```

2. **Configure Logging**:
   - Make sure your logging framework is properly configured. You can configure log levels (e.g., debug, info, error), log file destinations, and log format as per your requirements.

3. **Reproduce the Issue**:
   - Execute the part of your application where you suspect the issue is occurring, causing the log statements to be generated.

4. **Review Log Output**:
   - Examine the log output, paying attention to the log levels you've used (e.g., debug, info, error).
   - Look for any error messages, unexpected behavior, or other clues that might help you identify the issue.

5. **Use Log Levels**:
   - Different log levels serve different purposes. Use them wisely:
     - `DEBUG`: For detailed debugging information that is generally not present in production.
     - `INFO`: For general informational messages about the application's state.
     - `WARN`: For non-fatal issues or unusual but recoverable situations.
     - `ERROR`: For errors or exceptional situations that require attention.
     - `TRACE` (if available): For even more detailed debugging information.

6. **Add Contextual Information**:
   - Include relevant contextual information in your log messages, such as variable values, method names, and timestamps. This can help you understand the flow of your application.

   ```java
   logger.debug("Processing user with ID {}: {}", userId, user.getName());
   ```

7. **Iterate and Refine**:
   - If the initial log messages don't provide enough information to identify the issue, add more log statements and continue to reproduce the problem.
   - Analyze the log output, and refine your understanding of the problem as you go along.

8. **Disable or Remove Debug Logs**:
   - Once you've identified and fixed the issue, remember to disable or remove unnecessary debug log statements to avoid cluttering your logs in production.

Debugging by checking logs is a valuable technique because it provides a history of what happened in your application, making it easier to trace the sequence of events leading up to a problem. Effective log messages can save you significant time when troubleshooting issues, especially in production environments where traditional debugging methods may not be feasible.


## 3.  What is DTO, VO, Payload, DO, model?
different acronyms and patterns are used to represent data objects. 

1. **DTO (Data Transfer Object)**:
   - DTOs are objects used to <u>transfer data between different layers or parts of an application</u>, such as between the client and server in a distributed system.  传输data
   
   - They typically <u>contain only the data</u> needed for a specific operation or request, omitting any behavior or logic. 只包含data，去掉任何的bebavior或者是logic

   - DTOs are often used to minimize the amount of data transferred over the network or to encapsulate data retrieved from a database before sending it to a client.

2. **VO (Value Object)**:
   - Value Objects are objects that represent a descriptive aspect of the domain(域的描述性方面) with no conceptual identity.

   - They are immutable, meaning their value does not change once set.

   - VOs are often used to model concepts that have no identity of their own, such as date ranges, colors, or points in a coordinate system.

3. **Payload**:
   - A payload generally refers to the data portion of a message or packet transmitted over a network or passed between software components.

   - In the context of web services, APIs, or messaging systems, <u>the payload is the actual data being sent</u>, distinct from any metadata or headers. 传输DTO
   
   - Payloads can take various forms, such as JSON objects, XML documents, or binary data, depending on the communication protocol.
   
   - 在项目里面，payload文件夹下存储object的DTO

4. **DO (Domain Object)**:
   - Domain Objects represent the core business entities and concepts in an application's domain.
   
   - They encapsulate both data and behavior related to a specific domain entity.
   
   - DOs are typically designed to reflect the real-world entities and relationships within the application's problem domain.

5. **Model**:
   - "Model" is a broad term and can have different meanings depending on the context of its usage.
   
   - In the Model-View-Controller (MVC) architectural pattern, the "Model" represents the application's data and business logic.
   
   - In the context of data modeling and database design, a "Model" refers to the structure and schema of data, often represented using entity-relationship diagrams or database tables.
   
   - In machine learning and data science, a "Model" refers to a trained algorithm or mathematical representation used for predictions or data analysis.

## 4.  What is @JsonProperty("description_yyds") ?
`@JsonProperty()` is a Java annotation used in the context of Java <u>Object-JSON mapping</u>. 

It's typically used in libraries like Jackson, which is commonly used for JSON serialization and deserialization in Java applications.

Here's what it does:

1. **Mapping JSON Property Names**: In Java, you often have classes that represent objects, and you want to serialize (convert to JSON) or deserialize (convert from JSON) these objects. 

JSON property names might not always match the Java field or property names exactly. The `@JsonProperty` annotation allows you to specify the mapping between Java object properties and JSON object properties.

2. **Example**:
   
   Let's say you have a Java class like this:

   ```java
   public class MyObject {
       @JsonProperty("description_yyds")
       private String description;
       
       // Getter and Setter methods for 'description'...
   }
   ```

   In this example, the `@JsonProperty("description_yyds")` annotation is used to indicate that the Java field `description` should be serialized as `"description_yyds"` when converting an instance of `MyObject` to JSON and deserialized from `"description_yyds"` when converting JSON to a `MyObject` instance.

3. **Usage**:

   - Serialization: When you convert a `MyObject` instance to JSON, the resulting JSON will have a property named `"description_yyds"`.
   - Deserialization: When you read JSON data with a property named `"description_yyds"` and try to convert it to a `MyObject` instance, the value from `"description_yyds"` in JSON will be mapped to the `description` field in the Java object.

## 5.  do you know what is jackson?
```
     <dependency> 
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.3</version>
        <scope>compile</scope>
    </dependency>
```

Jackson is <u>a popular and widely used open-source Java library for JSON (JavaScript Object Notation) serialization and deserialization</u>. It provides a set of high-performance APIs to <u>work with JSON data in Java applications</u>. Jackson is commonly used in Java applications, including web services, RESTful APIs, and data exchange between different systems, to handle JSON data.

Key features and components of Jackson include:

1. **Streaming API (JsonParser and JsonGenerator)**: Jackson provides low-level streaming APIs that allow you to read and write JSON data efficiently. This is useful for processing large JSON documents or handling data in a memory-efficient way.

2. **Data Binding (ObjectMapper)**: Jackson's data binding API enables the conversion of JSON data into Java objects (deserialization) and Java objects into JSON data (serialization). The central class for this purpose is `ObjectMapper`.

3. **Annotations**: Jackson supports a variety of annotations that allow you to customize how Java objects are serialized and deserialized. For example, you can use `@JsonProperty` (as mentioned in a previous response) to specify JSON property names.

4. **Support for Polymorphism**: Jackson supports polymorphic types and can serialize and deserialize Java objects with inheritance hierarchies and complex type structures.

5. **Tree Model (JsonNode)**: Jackson provides a tree model that allows you to work with JSON data as a tree structure, making it easy to navigate and manipulate JSON data.

6. **Support for Custom Serialization/Deserialization**: You can implement custom serializers and deserializers to handle complex or custom data transformations during JSON conversion.

7. **Support for Date/Time Handling**: Jackson includes support for handling date and time formats, making it easier to work with date and time data in JSON.

8. **Modularity**: Jackson is highly modular, allowing you to include only the components you need in your project, which helps keep the library lightweight.

9. **Wide Adoption**: Jackson is used in many Java frameworks and libraries for handling JSON data, making it a de facto standard in the Java ecosystem.

## 6.  What is spring-boot-stater? 
    a. what dependecies in the below starter? do you know any starters?
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-
        web</artifactId>
    </dependency>
```

`spring-boot-starter` is not a specific starter itself but rather <u>a naming convention used for various Spring Boot starters(用于各种spring-boot启动程序的命名约定)</u>. 

In the context of Spring Framework and Spring Boot, a "starter" is a pre-configured set of dependencies that simplifies the process of adding specific functionality or features to your Spring Boot application. “start”是一组预先配置的依赖项，它简化了向Spring Boot应用程序添加特定功能或特性的过程。

These starters are bundled as Maven or Gradle dependencies and contain the necessary libraries, configuration files, and boilerplate code to quickly get you started with a particular aspect of your application. 

Spring Boot provides a variety of starters for different purposes, and each starter has a name that reflects its purpose or functionality. Some common examples of Spring Boot starters include:

1. **spring-boot-starter-web**: This starter includes everything you need <u>to build a web application</u> using Spring Boot. It includes Spring MVC, embedded Tomcat, and other dependencies for web development.

2. **spring-boot-starter-data-jpa**: If you want to work with Java Persistence API (JPA) for <u>database access</u>, this starter provides the necessary dependencies for data access, including Hibernate as the default JPA implementation.

3. **spring-boot-starter-security**: This starter is used for <u>adding security features to your application, including authentication and authorization</u>.

4. **spring-boot-starter-actuator**: It includes <u>monitoring and management features for your application, such as health checks, metrics, and more</u>.

5. **spring-boot-starter-test**: This starter is used for <u>writing unit and integration tests</u> for your Spring Boot application. It includes testing libraries like JUnit and Spring Test.

6. **spring-boot-starter-data-mongodb**: If you want to <u>work with MongoDB as your database</u>, this starter provides the necessary dependencies for MongoDB integration.

7. **spring-boot-starter-mail**: This starter <u>simplifies the configuration of sending emails in your application</u>.

8. **spring-boot-starter-amqp**: It includes dependencies for <u>working with Advanced Message Queuing Protocol (AMQP) using libraries like RabbitMQ</u>.

When you include one of these starters as a dependency in your Spring Boot project, Spring Boot automatically configures the necessary components, beans, and settings to enable the corresponding functionality. This makes it easier to get started with specific features without having to manually configure everything from scratch.

## 7 Do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
The `@RequestMapping` annotation in Spring (or Spring Boot) is used to <u>map HTTP requests to specific controller methods</u> in a Spring MVC application. It is commonly used for building RESTful APIs where you define the HTTP method and the URL path that the method should respond to. You can use this style to implement CRUD (Create, Read, Update, Delete) operations in your Spring application.

Here's an example of how you can use `@RequestMapping` to implement CRUD operations:

```java
@Controller
// `@RequestMapping("/users")` at the class level specifies that all methods within this controller will handle requests under the "/users" URL path.    
@RequestMapping("/users")
public class UserController {


    // Create (POST)
    // `@RequestMapping(value = "", method = RequestMethod.POST)` maps the `createUser` method to handle POST requests to "/users". 
    // It creates a new user.

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Logic to create a new user
        // Typically involves saving the user to a database
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Read (GET by ID)
    // `@RequestMapping(value = "/{userId}", method = RequestMethod.GET)` maps the `getUser` method to handle GET requests to "/users/{userId}". 
    // It retrieves a user by ID.

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        // Logic to retrieve a user by ID
        // Typically involves querying the database
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update (PUT)
    // `@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)` maps the `updateUser` method to handle PUT requests to "/users/{userId}". 
    // It updates a user by ID.

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User updatedUser) {
        // Logic to update a user by ID
        // Typically involves updating the user in the database
        User user = userService.updateUser(userId, updatedUser);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete (DELETE)
    // `@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)` maps the `deleteUser` method to handle DELETE requests to "/users/{userId}". 
    // It deletes a user by ID.

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
        // Logic to delete a user by ID
        // Typically involves deleting the user from the database
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
```

## 8.  What is ResponseEntity? why do we need it?
```
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, 
    HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
```

`ResponseEntity` is <u>a class</u> in the Spring Framework (and Spring Boot) that <u>represents an HTTP response to be sent back to the client </u>in a web application. <u>It encapsulates both the HTTP status code and the response body, allowing you to customize the HTTP response that your controller method sends back to the client</u>.

Here's why you need `ResponseEntity` and its significance:

1. **Customizing the HTTP Status Code**: In a web application, the HTTP status code (e.g., 200 OK, 404 Not Found, 500 Internal Server Error) indicates the outcome of an HTTP request. With `ResponseEntity`, you can explicitly set the desired HTTP status code for your response. This is useful when you want to convey the success or failure of an operation to the client.

2. **Customizing the Response Body**: In addition to setting the status code, `ResponseEntity` allows you to set the response body. The response body can be of any type, such as a Java object, a string, or binary data. You can provide the response body based on the outcome of your controller method.

3. **Flexibility in Response Generation**: Using `ResponseEntity`, you have fine-grained control over the HTTP response. You can handle various scenarios, such as successful responses, error responses, or responses with different status codes, and build the appropriate `ResponseEntity` accordingly.

4. **Response Headers**: `ResponseEntity` also allows you to set custom HTTP headers in the response, providing additional metadata to the client.

Here's an example of how `ResponseEntity` can be used:

```java
@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable long userId) {
    User user = userService.getUserById(userId);
    if (user != null) {
        // Return a 200 OK response with the user as the response body
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        // Return a 404 Not Found response with no response body
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
```
In this example:

- If the `getUser` method finds a user with the specified `userId`, it returns a `ResponseEntity` with a status code of 200 (OK) and the user object as the response body.
- If no user is found, it returns a `ResponseEntity` with a status code of 404 (Not Found) and no response body.

## 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
In JDBC (Java Database Connectivity), a `ResultSet` is <u>an interface</u> that <u>represents the result set of a database query</u>. 

<u>It provides methods for retrieving and manipulating data retrieved from a relational database</u>. 

<u>A `ResultSet` typically consists of rows and columns(包含rows和columns)</u>, where each row represents a record in the result set, and each column represents a field or attribute of that record.

Here's an overview of the flow of how to get data using JDBC:

1. **Load JDBC Driver**:
   - Before using JDBC, you need to load the JDBC driver specific to the database you're working with. The driver is typically loaded using the `Class.forName` method or by registering the driver with the `DriverManager` class.

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL JDBC driver
   ```

2. **Establish a Database Connection**:
   - Use the `DriverManager` to establish a connection to the database by providing the database URL, username, and password.

   ```java
   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
   ```

3. **Create a SQL Statement**:
   - Create an instance of `Statement` or `PreparedStatement` to execute SQL queries on the database.

   ```java
   Statement statement = connection.createStatement();
   ```

4. **Execute SQL Query**:
   - Execute the SQL query using the `executeQuery` method of the `Statement` or `PreparedStatement` object.

   ```java
   ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
   ```

5. **Iterate Through the ResultSet**:
   - Use methods of the `ResultSet` to retrieve data from the result set.
   - Use methods like `next()` to move to the next row and `getXXX()` (e.g., `getInt()`, `getString()`) to retrieve column values.

   ```java
   while (resultSet.next()) {
       int id = resultSet.getInt("id");
       String name = resultSet.getString("name");
       // Process and use the retrieved data
   }
   ```

6. **Close Resources**:
   - It's important to close the resources when you're done with them to release database connections and prevent resource leaks.

   ```java
   resultSet.close();
   statement.close();
   connection.close();
   ```

7. **Exception Handling**:
   - Handle exceptions that may occur during database operations, such as SQLExceptions. Ensure proper error handling and resource cleanup in case of exceptions.

```java
try {
    // JDBC code here
} catch (SQLException e) {
    // Handle exceptions
} finally {
    // Close resources in a finally block
}
```

8. **Cleanup**:
   - Close the database resources (connections, statements, result sets) in a `finally` block to ensure they are properly closed, even if exceptions are thrown.

The above steps outline the basic flow of using JDBC to connect to a database, execute a query, retrieve data from a `ResultSet`, and properly manage resources. Depending on your requirements, you may use `PreparedStatement` for parameterized queries, handle transactions, and perform other database operations as needed.

## 10. What is the ORM framework?
ORM <u>stands for Object-Relational Mapping</u>. It is a programming technique and a framework that <u>enables developers to interact with relational databases using object-oriented programming languages like Java, Python, C#, and others</u>. ORM frameworks bridge the gap between the object-oriented world of application code and the relational world of databases by providing a way to map database tables and rows to objects and their relationships in code.

Here are some key aspects of ORM frameworks:

1. **Object-Relational Mapping**: ORM frameworks provide a way to define how database tables correspond to classes in your application. Each row in a table is mapped to an object, and each column in a table is mapped to an attribute or property of that object.

2. **Abstraction of SQL**: ORM frameworks abstract away the low-level SQL code required for database interactions. Developers can work with high-level object-oriented APIs instead of writing raw SQL queries.

3. **CRUD Operations**: ORM frameworks typically support CRUD operations (Create, Read, Update, Delete) on objects, making it easier to perform database operations without writing SQL statements explicitly.

4. **Relationships**: ORM frameworks support defining and managing relationships between objects/classes, including one-to-one, one-to-many, and many-to-many relationships. This simplifies working with complex data models.

5. **Database Agnosticism**: Many ORM frameworks are database-agnostic, meaning they can work with different database systems (e.g., MySQL, PostgreSQL, Oracle) with minimal code changes.

6. **Caching**: Some ORM frameworks provide caching mechanisms to improve performance by reducing the need for repeated database queries.

7. **Validation**: ORM frameworks often include validation mechanisms to ensure that data stored in the database adheres to certain constraints defined in your application code.

8. **Transaction Management**: ORM frameworks help manage database transactions, ensuring that changes to the database are either committed or rolled back in a consistent manner.

Popular ORM frameworks in various programming languages include:

- **Java**: Hibernate, Java Persistence API (JPA), EclipseLink.
- **Python**: SQLAlchemy, Django ORM (built into the Django web framework).
- **C#**: Entity Framework.
- **Ruby**: ActiveRecord (used in Ruby on Rails).

Benefits of using an ORM framework include increased developer productivity, reduced boilerplate code, improved code maintainability, and the ability to work with objects and relationships in a natural and intuitive way. However, there are also considerations such as performance and the learning curve associated with ORM frameworks, so choosing the right ORM for your project is important.

## 11. Learn how to use ObjectMapper by this example.
a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/
```
    FoodOutletJackson.java
    FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    String s = objectMapper.writeValueAsString(foodOutlet);
    objectMapper.readTree() // learn how to use it?
```

1. 题目描述在PDF文件，先阅读下面文章，再尝试自己写。
2. 答案包含了java 8, java 11怎么做HTTP call。String 和Json的转换也有两个版本。
3. 如果答案也看不懂，则先照抄一遍，能理解多少是多少。

read and learn the IO: https://www.liaoxuefeng.com/wiki/1252599548343744/1255945227202752

read and learn the HTTP: https://www.liaoxuefeng.com/wiki/1252599548343744/1319099982413858

read and learn xml and Json: https://www.liaoxuefeng.com/wiki/1252599548343744/1255945389334784

read and has basic understanding of Gson. know what is serialization。 https://zetcode.com/java/gson/

### 题目：
REST API: Relevant Food Outlets

A REST API contains information about food outlets across multiple cities. Given the city name, and maximum cost for
2 persons. The goal is to use the API to get the list of food outlets that belongs to this city and have an estimated
cost less than or equal to given cost. The API returns paginated data. (用API来获得所在城市的the list of outlets，并且给出一个estimated cost要求少于或者等于限定值, API返回分页数据)

To access the information, perform an HTTP GET request to:
`https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>` where `<city>` is the city to get the food outlets for 
and `<pageNumber>` is an integer that denotes the page of the result to return.

For example, a GET request to
`https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle&page=2` returns data associated with <u>city Seattle</u>, and on the <u>second page</u> of the results.

Similary, a GET request to 
`https://jsonmock.hackerrank.com/api/food_outlets?city=Houston&page=1` returns data associated with <u>city Houston</u>, and on the <u>first page</u> of the results.

The response to such a request is a JSON with the following 5 fields:

1. `page`: The current page of the results
2. `per_page`: The maximum number of records returned per page.
3. `total`: The total number of records in the database
4. `total_pages` The total number of pages with results;
5. `data`: Either an empty array or an array of outlet objects. Each object has the following schema:
    - `city`: city we queried for where the outlet is located[STRING]
    - `name`: name of the outlet[STRING]
    - `estimated_cost`: estimated cost for 2 persons[INTEGER]
    - `user_rating`: 
        - `average_rating`: average rating of the outlet[FLOAT]
        - `votes`: total votes for the outlet[INTEGER]
    - `id`: unique identifier of the outlet[INTEGER]

Below is an example of an outlet object:

Given a string city, numerical maximum cost for 2 persons maxCost, return the list of food outlet names that are located in this city and have an estimated cost less than or equal to given maxCost.

Function Description
Complete the function `getRelevantFoodOutlets` in the editor below. Please perform pagination in order to get all results.
`getRelevantFoodOutlets` has the following parameter(s): 
    - `String city`: string denoting the city of the food outlet
    - `int maxCost`: max cost for 2 people

Returns:
An array of Strings denoting the food outlet names that are located in this city and have an estimated cost less than or equal to given maxCost. The names in the array must be ordered in the order they appear in the API response.

Constraints:
The given city will always have data returned from the API.

Note:
Required libraries can be imported in order to solve the question.

### 1. read and learn the IO: 
https://www.liaoxuefeng.com/wiki/1252599548343744/1255945227202752

IO是指Input/Output，即输入和输出。以内存为中心：

Input指从外部读入数据到内存，例如，把文件从磁盘读取到内存，从网络读取数据到内存等等。

Output指把数据从内存输出到外部，例如，把数据从内存写入到文件，把数据从内存输出到网络等等。

1. InputStream / OutputStream 输入字节流/输出字节流

    字节流传输的最小数据单位是`byte`

2. Reader / Writer (输出)字符流/ (输入)字符流

    字符流传输的最小数据单位是`char`

3. 同步和异步

    同步IO是指，<u>读写IO时代码必须等待数据返回后才继续执行后续代码</u>，它的优点是代码编写简单，缺点是CPU执行效率低。

    异步IO是指，<u>读写IO时仅发出请求，然后立刻执行后续代码</u>，它的优点是CPU执行效率高，缺点是代码编写复杂。

### 2. read and learn the HTTP: 
https://www.liaoxuefeng.com/wiki/1252599548343744/1319099982413858

HTTP是HyperText Transfer Protocol的缩写，翻译为超文本传输协议，它是基于TCP协议之上的一种请求-响应协议。

HTTP请求的格式：HTTP Header和HTTP Body两部分构成 (GET和POST请求看链接的例子)

HTTP响应的格式： 也是由Header和Body两部分组成 (看链接的例子)

### 3. read and learn xml and Json: 
https://www.liaoxuefeng.com/wiki/1252599548343744/1255945389334784 （如何使用Java读写XML和JSON。）

***XML***：
XML是可扩展标记语言（eXtensible Markup Language）的缩写，它是一种数据表示格式，可以描述非常复杂的数据结构，常用于传输和存储数据。

XML的结构：

- 首行必定是<?xml version="1.0"?>，可以加上可选的编码。
- 紧接着，如果以类似<!DOCTYPE note SYSTEM "book.dtd">声明的是文档定义类型（DTD：Document Type Definition），DTD是可选的。
- 接下来是XML的文档内容，一个XML文档有且仅有一个根元素，根元素可以包含任意个子元素，元素可以包含属性，例如，<isbn lang="CN">1234567</isbn>包含一个属性lang="CN"，且元素必须正确嵌套。如果是空元素，可以用<tag/>表示。
- 使用DOM，SAX和Jackson解析XML

***JSON 取代 XML***
JSON是JavaScript Object Notation的缩写，它去除了所有JavaScript执行代码，只保留JavaScript的对象格式。

<u>使用Java如何对JSON进行读写 ： 利用Jackson解析JSON(直接在JSON和JavaBean之间转换)</u>

<u>序列化：把JavaBean变为JSON</u>

<u>反序列化： 把JSON解析为JavaBean</u>

### 4. read and has basic understanding of Gson. know what is serialization。 
https://zetcode.com/java/gson/： work with JSON in Java using Gson library

### 5. answer: 
see coding files: FoodOutlet

## 12. What is the serialization and desrialization?
a. https://hazelcast.com/glossary/serialization/

***Serialization*** is <u>the process of converting a data object</u>—a combination of code and data represented within a region of data storage—<u>into a series of bytes</u> that saves the state of the object in an easily transmittable form. 

In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.

The <u>reverse process—constructing a data structure or object from a series of bytes</u>—is ***deserialization***. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.

## 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        
        // Using the Stream API to calculate the average
        // use the `Arrays.stream(numbers)` method to create a stream of integers from the `numbers` array.
        // use the `.average()` method on the stream to calculate the average. 
        // The `average()` method returns an `OptionalDouble`, 
        // so we use `.orElse(Double.NaN)` to handle the case where the stream is empty (e.g., if the array is empty)
        //  and return `Double.NaN` in that case.

        double average = Arrays.stream(numbers)
            .average()
            .orElse(Double.NaN);
        
        System.out.println("Average: " + average);
    }
}

output:
Average: 41.4
```

## 14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。
see file coding : springboot-redbook

## 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我一样分branch添加新代码。
see file coding : springboot-redbook

## 16. (Optional)Try to write the CRUD api for a new application Cassandra-Blog
    a. spring 提供了相关dependency,(https://start.spring.io/)
        i.  Spring Data for Apache Cassandra
    b. Cassandra十分流行，且面试问的多。
