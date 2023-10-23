# HW42-exception-validation-mvc - Grace Hu

## exception-validation

#### 1. List all of the annotations you learned from class and homework to
annotaitons.md

#### 2. what is the @configuration and @bean?
**@Configuration** and **@Bean** are used to define and configure beans in the Spring IoC (Inversion of Control) container.

**@Configuration** is used to indicate that a class contains one or more bean definitions, and any methods within the class that are annotated with **@Bean** will be used to create and configure beans.

A bean is an object managed by Spring IoC container and can be used to provide services or functionality to other parts of the application.

![Alt text](image.png)

#### 3. How do you handle the exception in Spring?
Anotations:

**@ExceptionHandler**
- Method Level
- used to handle the specific exceptions and sending the custom
- responses to the client

**@ControllerAdvice**
- Class Level
- make this class be a bean

Steps:
1. Create ErrorDetails Class
2. Create GlobalExceptionHandler Class
3. Test using Postman Client

Handle Specific Exception

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException
    exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

Handle Global Exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

#### 4. How do you do the validations in Spring? And list some validation annotaitons you know.

validation is to validate request body and return a customized validation Response.

**steps**:

1. import dependecy

dependecy:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
        <version>2.7.0</version>
    </dependency>


2. Add validation Rule to payload

Rule:
    
    public class PostDto {
        private long id;
        /**
        * 1. title should not be null or empty
        * 2. title should have at least 2 characters
        * Question, our database have set it as nullable=false,
        * why do we need to set validation here? what is the benefits?
        @NotEmpty
        @Size (min = 2, message = "Post title should have at least 2 characters")
        private String title;
        @NotEmpty
        @Size(min = 10, message = "Post description should have at least 10 characters")
        private String description;
        @NotEmpty
        private String content;

3. Add @valid to controller to apply the Rule here, if invalid, throw exception

@valid

    create blog post
    @PostMapping ©v
    public ResponseEntity<PostDto> createPost(@Valid RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService. createPost (postDto), HttpStatus. CREATED);
    }

4. global exception handler -> accept and handle

code:

    /**
    * Approach 1
    */
    @ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) ->
            {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
            });
            return new ResponseEntity<>(errors,
            HttpStatus.BAD_REQUEST);
        }
    }



    /**
    * Approach 2
    */
    @ControllerAdvice
    public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                errors.put(fieldName, message);
            });
            return new ResponseEntity<>(errors,
            HttpStatus.BAD_REQUEST);
        }
    }

5. Check it in Postman: for example, test "title": "", the status should be Bad_Request not 500.

**Spring Validation Annotations**:
- @NotNull: Checks if a field is not null.
- @NotEmpty: Ensures that a field is not null and not an empty string.
- @NotBlank: Checks that a string field is not null and has at least one non-whitespace character.
- @Size: Validates the size of a field, specifying minimum and maximum length.
- @Min: Ensures that a numeric field is greater than or equal to the specified minimum value.
- @Max: Validates that a numeric field is less than or equal to the specified maximum value.
- @Email: Ensures that a field is a valid email address.
- @Pattern: Allows you to define a custom regular expression for validation.

#### 5. What is the actuator?
The **actuator** is a tool for monitoring and managing Spring Boot applications in production about health, metrics, info, dump, env, etc by using HTTP endpoints.

#### 6. watch those videos

## Spring MVC

#### 1. List all of the annotations you learned from class and homework to
annotaitons.md

#### 2. What is MVC pattern?
It is a used for developing user interfaces that divides the related program logic into three interconnected elements. These elements are the internal representations of information (the Model), the interface (the View) that presents information to and accepts it from the user, and the Controller software linking the two.

Model: The backend that contains all the data logic

View: The frontend or graphical user interface (GUI)

Controller: The brains of the application that controls how data is displayed

#### 3. What is Front-Controller?
The **Front-Controller** maps the incoming request to a controller. Controllers contain the business logic of the application. They also handle requests and perform marshalling/unmarshalling. The function of the controller is to handle a user request. The incoming request may be handled in different ways like reading form data, processing it in some way, storing data in a database, or retrieving data from a web service etc. The controller places the data in the model which, simply put, is a container for the data. The controller returns the model (containing data) back to the front controller.

#### 4. What is DispatcherServlet? please decribe how it works.
**DispatcherServlet** handles an incoming HttpRequest, delegates the request, and processes that request according to the configured HandlerAdapter interfaces.

1. The web server (e.g., Tomcat) receives an HTTP request from a client (e.g., a web browser). The request is then handed over to the DispatcherServlet, which acts as a front controller.

2. The DispatcherServlet consults the Handler Mapping (often defined in the application's configuration) to determine which controller should handle the request. 

3. The Handler Mapping maps the request to a specific controller and method and return then back to DispatcherServlet.

4. The DispatcherServlet calls the appropriate controller and method to process the request. The controller may interact with services, repositories, and databases to retrieve or manipulate data.

5. After processing the request, the controller returns a ModelAndView object. It typically returns a view name (e.g., "list-customers") and the data is set in model.

6. The DispatcherServlet calls the View Resolver using the view name.

6. The View Resolverthe finds the actual view template (e.g., "list-customers.jsp")

7. Now we have view template and model data, so we call View Engine to populate the template using the model data provided in the ModelAndView. creating a dynamic HTML representation of the response.

8. The HTML is sent back as the response to the client (web browser). The client's browser renders the HTML and presents it to the user.


#### 5. What is JSP and What is ModelAndView？(please google to have a basic knowlege)
**JSP** is a technology used to create dynamic web pages by writing Java code within HTML content directly in the web pages.

**ModelAndView** is a class commonly used for handling the response. It represents a data model and a view to be rendered in response to a client's request.

#### 6. Could you please google any other servlets
**Servlet** is a class that handles requests, processes them and reply back with a response. **Servlets** work on the server-side, they are capable of handling complex requests obtained from the webserver.

For example, we can use a **Servlet** to collect input from a user through an HTML form, query records from a database, and create web pages dynamically.

**other servlets**:
- Apache Tomcat
- JServ

#### 7. How many web server do you know? (Tomcat, Jetty, Jboss)
Apache Tomcat
Node.js
Express.js

#### 8. clone this repo, and run it in you local.

a. https://github.com/TAIsRich/springmvc5-demo
b. Notice that you need to configure the Tomcat by yourself. tutorial in
the slides.
c. find out the APIs in controlelr and call some APIs, In slides, I also list
some API.
d. remeber to create a database for this project
e. all details in the slides.