1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
   understand it. you need to update it when you learn a new annotation. Please organize those annotations
   well, like annotations used by entity, annotations used by controller.
> @Entity:<br>
Usage: Used to mark a class as a JPA (Java Persistence API) entity. It indicates that the class should be mapped to a database table.<br>
Explanation: Entities represent tables in a database, and this annotation is crucial for ORM (Object-Relational Mapping) in Spring.<br>
@Table:<br>
Usage: Used to specify the details of the database table that corresponds to an entity.<br>
Explanation: It allows customization of table names, schema, and other properties.<br>
@Id:<br>
Usage: Used to mark a field as the primary key of an entity.<br>
Explanation: This annotation is used to uniquely identify rows in the database table.<br>
@GeneratedValue:<br>
Usage: Used in conjunction with @Id to specify how primary keys should be generated (e.g., auto-incremented).<br>
Explanation: It automates the process of assigning primary key values.<br>
Annotations Used by Controllers:<br>
@Controller:<br>
Usage: Used to mark a class as a Spring MVC controller.<br>
Explanation: Controllers handle HTTP requests and define methods to process them.<br>
@RestController:<br>
Usage: Similar to @Controller, but specifies that the controller methods return data as JSON or XML responses.
Explanation: Useful for building RESTful web services.<br>
@RequestMapping:<br>
Usage: Used at the method level to map HTTP requests to controller methods.<br>
Explanation: It defines the URL path and HTTP methods that a method should respond to.<br>
@PathVariable:<br>
Usage: Used to extract values from URI templates and pass them as method parameters.<br>
Explanation: Useful for capturing dynamic parts of the URL.<br>
@RequestBody:<br>
Usage: Used to indicate that a method parameter should be bound to the body of the HTTP request.<br>
Explanation: It's commonly used to parse JSON or XML data from client requests.<br>
@RequestParam:<br>
Usage: Used to bind request parameters from the URL to method parameters.<br>
Explanation: Useful for handling query parameters in GET requests.<br>
@ModelAttribute:<br>
Usage: Used to bind a method parameter or return value to a model attribute.<br>
Explanation: Helps in adding objects to the model for rendering in a view.<br>
Other Common Annotations:<br>
@Autowired:<br>
Usage: Used for automatic dependency injection.<br>
Explanation: Spring automatically wires the dependency using this annotation.<br>
@Service:<br>
Usage: Used to mark a class as a service bean.<br>
Explanation: Indicates that the class provides a service and should be managed by the Spring container.<br>
@Component:<br>
Usage: A generic stereotype annotation for any Spring-managed component.<br>
Explanation: Used to indicate that a class is a Spring-managed bean.<br>
@Configuration:<br>
Usage: Used to define Java-based configuration classes.<br>
Explanation: It defines beans and their relationships in a configuration class.<br>
@Qualifier:<br>
Usage: Used in conjunction with @Autowired to specify which bean should be injected when multiple candidates are available.<br>
Explanation: Helps disambiguate dependencies.<br>
2. explain how the below annotaitons specify the table in database?<br>
   @Column(columnDefinition = "varchar(255) default 'John Snow'")<br>
   private String name;<br>
   @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)<br>
   private String studentName;<br>
> @Column is used to specify the properties of thr column in the database table.<br>
> columnDefinition specifies the SQL definition of the column. In this case, it specifies that the name column should be of type varchar(255) and have a default value of 'John Snow'.<br>
> name attribute specifies the name of the database column. <br>
length attribute specifies the maximum length of the column.<br>
nullable attribute indicates whether the column can contain null values. <br>
unique attribute indicates whether the values in the column must be unique.<br>
3. What is the default column names of the table in database for @Column ?
> the default column name in the database is derived from the name of the field
4. What are the layers in springboot application? what is the role of each layer?
> Controller (Presentation Layer):<br>
Handles HTTP requests and manages user interactions.<br>
Service Layer:<br>
Contains business logic and orchestrates application functionality.<br>
Repository Layer (Data Access):<br>
Interacts with databases or data sources, performs CRUD operations.<br>
Entity Layer:<br>
Defines data models (Entities) and their relationships.<br>

5. Describe the flow in all of the layers if an API is called by Postman.
> User Interaction (Postman Client):<br>
User creates and sends an HTTP request in Postman, specifying method, URL, headers, and body.<br>
Request Processing (Server-Side):<br>
API request is received by the server, which routes it to the application layer.<br>
Business Logic (Server-Side):<br>
Application layer processes the request, interacts with databases or services, and generates a response.<br>
Response Handling (Postman Client):<br>
Postman receives and displays the API response to the user.<br>
> 
6. What is the application.properties? do you know application.yml?
> application.properties is a plain text file for configuring Spring Boot applications using key-value pairs.
<br>application.yml is an alternative configuration file using YAML syntax for the same purpose.
7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
   MongoDB;
   https://www.mongodb.com/compatibility/spring-boot