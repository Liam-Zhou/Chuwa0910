Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
   understand it. you need to update it when you learn a new annotation. Please organize those annotations
   well, like annotations used by entity, annotations used by controller.<br>
@Entity:<br>
>Usage: Used to mark a class as a JPA (Java Persistence API) entity. It indicates that the class should be mapped to a database table.<br>
Explanation: Entities represent tables in a database, and this annotation is crucial for ORM (Object-Relational Mapping) in Spring.<br>

@Table:<br>
>Usage: Used to specify the details of the database table that corresponds to an entity.<br>
Explanation: It allows customization of table names, schema, and other properties.<br>

@Id:<br>
>Usage: Used to mark a field as the primary key of an entity.<br>
Explanation: This annotation is used to uniquely identify rows in the database table.<br>

@GeneratedValue:<br>
>Usage: Used in conjunction with @Id to specify how primary keys should be generated (e.g., auto-incremented).<br>
Explanation: It automates the process of assigning primary key values.<br>
Annotations Used by Controllers:<br>
> 
@Controller:<br>
>Usage: Used to mark a class as a Spring MVC controller.<br>
Explanation: Controllers handle HTTP requests and define methods to process them.<br>
> 
@RestController:<br>
>Usage: Similar to @Controller, but specifies that the controller methods return data as JSON or XML responses.
Explanation: Useful for building RESTful web services.<br>
> 
@RequestMapping:<br>
>Usage: Used at the method level to map HTTP requests to controller methods.<br>
Explanation: It defines the URL path and HTTP methods that a method should respond to.<br>
> 
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping:<br>
> Usage: Specialized versions of @RequestMapping for common HTTP methods.<br>
Explanation: Simplifies mapping for GET, POST, PUT, and DELETE requests, respectively.<br>
> 
@PathVariable:<br>
>Usage: Used to extract values from URI templates and pass them as method parameters.<br>
Explanation: Useful for capturing dynamic parts of the URL.<br>
> 
@RequestBody:<br>
>Usage: Used to indicate that a method parameter should be bound to the body of the HTTP request.<br>
Explanation: It's commonly used to parse JSON or XML data from client requests.<br>
> 
@RequestParam:<br>
>Usage: Used to bind request parameters from the URL to method parameters.<br>
Explanation: Useful for handling query parameters in GET requests.<br>
>
@ModelAttribute:<br>
>Usage: Used to bind a method parameter or return value to a model attribute.<br>
Explanation: Helps in adding objects to the model for rendering in a view.<br>
Other Common Annotations:<br>
> 
@Autowired:<br>
>Usage: Used for automatic dependency injection.<br>
Explanation: Spring automatically wires the dependency using this annotation.<br>
> 
@Service:<br>
>Usage: Used to mark a class as a service bean.<br>
Explanation: Indicates that the class provides a service and should be managed by the Spring container.<br>
> 
@Component:<br>
>Usage: A generic stereotype annotation for any Spring-managed component.<br>
Explanation: Used to indicate that a class is a Spring-managed bean.<br>
> 
@Configuration:<br>
>Usage: Used to define Java-based configuration classes.<br>
Explanation: It defines beans and their relationships in a configuration class.<br>
>
@Qualifier:<br>
>Usage: Used in conjunction with @Autowired to specify which bean should be injected when multiple candidates are available.<br>
Explanation: Helps disambiguate dependencies.<br>
> 
@Column:<br>
> Usage: Used to customize the mapping of a field to a database column.<br>
Explanation: Allows you to specify column name, length, nullable, and other attributes.<br>
> 
@OneToMany:<br>
> Usage: Used to establish a one-to-many relationship between two entities.<br>
Explanation: Defines a foreign key relationship from one entity to a collection of another entity.<br>
> 
@ManyToOne:<br>
> Usage: Used to establish a many-to-one relationship between two entities.<br>
Explanation: Defines a foreign key relationship from one entity to another entity.<br>
> 
@ManyToMany:<br>
> Usage: Used to establish a many-to-many relationship between two entities.<br>
Explanation: Represents a many-to-many association between entities, typically through an intermediary table.<br>
