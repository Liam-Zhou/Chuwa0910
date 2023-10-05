1. Core Annotations
    
    - @SpringBootApplication
      
      Marks a class as the application’s entry point and triggers auto-configuration and component scanning. It's a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan.
      
      ```
      @SpringBootApplication
      public class Application {
         public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
         }
      }
      ```
      
2. Spring Bean Annotations
    
    - @Autowired
      
      Injects an instance of a bean automatically. The injected class should be a Spring component.

      ```@Autowired
      private UserService userService;
      ```

    - @Component
      
      General-purpose stereotype annotation indicating a Spring component.

    - @Repository
      
      Indicates that a class serves as a repository and operates primarily on the database.

    - @Service
      
      Marks a class as a service that holds business logic.

    - @Controller
      
      Designates a class as a Spring MVC controller.

    - @RestController
      
      Combines @Controller and @ResponseBody - typically used in RESTful services.

    - @Scope
      
      Specifies the scope of a Spring bean.
      
      ```
      @Bean
      @Scope("singleton")
      public Person person() {
         return new Person();
      }
      ```

3. HTTP Request Handling Annotations
    
    - @GetMapping
      
      A shortcut for @RequestMapping(method = RequestMethod.GET).
      
      ```
      @GetMapping("/users")
      public ResponseEntity<List<User>> getAllUsers() {
         return userRepository.findAll();
      }
      ```

    - @PostMapping
      
      A shortcut for @RequestMapping(method = RequestMethod.POST).

      ```
      @PostMapping("/users")
      public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
         return userRepository.save(user);
      }
      ```
  
    - @PutMapping
      
      A shortcut for @RequestMapping(method = RequestMethod.PUT).

      ```
      @PutMapping("/users/{userId}")
      public ResponseEntity<User> updateUser(@PathVariable Long userId, 
                                        @Valid @RequestBody User user) {
         // update logic
      }
      ```

    - @DeleteMapping
      
      A shortcut for @RequestMapping(method = RequestMethod.DELETE).
      
      ```
      @DeleteMapping("/users/{userId}")
      public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
         // delete logic
      }
      ```
      
    - @PatchMapping
      
      Used for partial updates.

      ```
      @PatchMapping("/users/{userId}")
      public ResponseEntity<User> patchUser(@PathVariable Long userId, 
                                      @Valid @RequestBody User user) {
         // patch logic
      }
      ```
      
4. Data Transfer Between Frontend and Backend
 
    - @Configuration
      
      Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests.

    - @RequestBody

      Bind the method return value to the body of the web response.

    - @PathVariable
      
      Indicates that a method parameter should be bound to a URI template variable.

    - @CreatedDate and @LastModifiedDate
      
      Annotations provided by Spring Data JPA to track the entity's creation and modification timestamps.

    - @Valid
      
      Used to validate a model, it checks if the fields are in accordance with the annotations applied to the model fields.
 
5. Reading Configuration Information

    - @Value (Commonly Used)
      
      Use @Value("${property}") to read simple configuration information.

      ```
      @Value("${wuhan2020}")
      String wuhan2020;
      ```
      
    - @ConfigurationProperties (Commonly Used)
      
      Use @ConfigurationProperties to read configuration information and bind it with a bean.

      ```
      @Component
      @ConfigurationProperties(prefix = "library")
      class LibraryProperties {
    
         @NotEmpty
         private String location;
         private List<Book> books;

         // getters and setters

         static class Book {
            String name;
            String description;
            // getters and setters
         }
      }
      ```
      
    - @PropertySource (Less Common)
      
      Use @PropertySource to read a specified properties file.
      
      ```
      @Component
      @PropertySource("classpath:website.properties")
      class Website {
    
         @Value("${url}")
         private String url;
         // getters and setters
      }
      ```
      
6. Parameter Validation

    - Common Field Validation Annotations
      
      - @NotEmpty: The annotated string must not be null or empty.
      - @NotBlank: The annotated string must not be null and must contain at least one non-whitespace character.
      - @Null: The annotated element must be null.
      - @NotNull: The annotated element must not be null.
      - @Email: The annotated string must be a well-formed email address.
      - @Min(value): The annotated element must be a number whose value must be higher or equal to the specified minimum.
      - @Max(value): The annotated element must be a number whose value must be lower or equal to the specified maximum.

    - Validating the Request Body (@RequestBody)
      
      ```
      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      public class Person {
    
         @NotNull(message = "classId cannot be null")
         private String classId;
    
         @NotNull(message = "name cannot be null")
         @Size(max = 33)
         private String name;
    
         // other fields and their validation annotations
      }
      ```
      
      Use the @Valid annotation before the @RequestBody to trigger validation:
      
      ```
      @RestController
      @RequestMapping("/api")
      public class PersonController {

         @PostMapping("/person")
         public ResponseEntity<Person> getPerson(@RequestBody @Valid Person person) {
            return ResponseEntity.ok().body(person);
         }
      }
      ```

    - Validating Path Variables and Request Parameters
      
      Use @Validated at the class level to enable parameter validation.
      
      ```
      @RestController
      @RequestMapping("/api")
      @Validated
      public class PersonController {

         @GetMapping("/person/{id}")
         public ResponseEntity<Integer> getPersonByID(@Valid @PathVariable("id") @Max(value = 5, message = "ID exceeds the limit") Integer id) {
            return ResponseEntity.ok().body(id);
         }
      }
      ```

7. Global Exception Handling in Controller Layer

    Every Spring project should have global exception handling for the Controller layer. Here is how we can implement it:

    Annotations Used:
    
    - @ControllerAdvice: This annotation is used to define a global exception handling class.
    - @ExceptionHandler: This annotation is used to declare an exception handling method.

    Here is an example of how to use these annotations. Suppose there is a parameter validation in section 5. If the method parameter is incorrect, a MethodArgumentNotValidException will be thrown. We can handle this exception as follows:
    
    ```
    @ControllerAdvice
    @ResponseBody
    public class GlobalExceptionHandler {

       /**
        * Handling request parameter exception
        */
       @ExceptionHandler(MethodArgumentNotValidException.class)
       public ResponseEntity<?> handleMethodArgumentNotValidException(
          MethodArgumentNotValidException ex, 
          HttpServletRequest request) {
             // Implementation...
       }
    }
    ```

8. JPA Related
    
    - Creating a Table
      
      - @Entity: Declares a class to correspond to a database entity.
      - @Table: Sets the table name.
    
    - Creating a Primary Key
      
      - @Id: Declares a field as the primary key.
      - @GeneratedValue: Specifies how the primary key is generated.
    
    - Setting Field Types

      - @Column: Declares a field, allowing you to set attributes such as name, nullable, and length.

    - Specifying Non-Persistent Specific Fields
      
      - @Transient: Declares fields that do not need to be mapped to the database.
    
    - Declaring Large Fields
      
      - @Lob: Declares a field as a large object.
    
    - Creating an Enum Type Field
      
      Use an enum type field, but it must be annotated with @Enumerated.
    
    - Adding Audit Functionality
      
      Classes that inherit from AbstractAuditBase will automatically have four additional fields.

    - Deleting/Modifying Data
      
      - @Modifying: Indicates a modifying query. It must be used with @Transactional.
    
    - Relationship Annotations
      
      - @OneToOne: Declares a one-to-one relationship.
      - @OneToMany: Declares a one-to-many relationship.
      - @ManyToOne: Declares a many-to-one relationship.
      - @ManyToMany: Declares a many-to-many relationship.

