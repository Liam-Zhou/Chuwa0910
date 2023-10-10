## Annotations used by Entities (JPA Entities)

1. `@Entity`
    
    Marks a Java class as a JPA entity, which is mapped to a database table.
    
    ```java
    @Entity
    @Table(name = "posts",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
    public class Post {
    ...
    }
    ```
    
2. `Table`
    
    Specifies the details of the database table that corresponds to the annotated entity.
    
3. `@Id`
    
    Denotes the primary key field of the entity.
    
    ```java
    public class Post{
    	@Id
    	private Long id;
    	...
    }
    ```
    
4. `@GeneratedValue`
    
    Specifies how the primary key should be generated, e.g., **`GenerationType.AUTO`**, **`GenerationType.IDENTITY`**, etc.
    
    ```java
    public class Post{
    	@Id
    	@GeneratedValue(Strategy = Generation.IDENTITY)
    	private Long id;
    	...
    }
    ```
    
5. `@Column`
    
    Configures the mapping between a class field and a database column, allowing you to specify column name, type, and constraints.
    
    ```java
    public class Post{
    	@Column(name = "description", nullable = false)
    	private String description;
    }
    ```
    

## **Annotations Used by Controllers**

1. `@Controller`
    
    Marks a class as a Spring MVC controller.
    
2. `@RestController`
    
    Combines **`@Controller`** and **`@ResponseBody`**, indicating that the controller methods return JSON or XML responses directly.
    
    ```java
    @RestController
    @RequestMapping("/api/v1/posts")
    ```
    
3. `@RequestMapping`
    
    Maps HTTP requests to controller methods. You can specify HTTP methods and URL patterns.
    
4. `@GetMapping` , `@PostMapping`, `@PutMapping`, `@DeleteMapping`
    
    These are shortcut annotations for specific HTTP methods, making it easier to define request mappings.
    
    ```java
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) 
    {return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);}
    ```
    
5. `@RequestBody`
    
    Binds the body of a request to a method parameter, useful for receiving JSON or XML data.