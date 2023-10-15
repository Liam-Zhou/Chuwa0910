# HW11 Xiao Yang

### 1. List all of the annotations you learned from class and homework to 
[annotaitons.md](./annotations.md)

### 2.  what is the @configuration and @bean?
`@Configuration` and `@Bean` are annotations used to define and configure beans in the Spring container. They are part of Spring's Java-based configuration approach, which allows you to define beans and their relationships in a Java class rather than using traditional XML-based configuration.

The @Configuration annotation is used to indicate that a class defines Spring configuration. It's typically applied to a Java class that contains one or more @Bean methods.

Classes annotated with @Configuration serve as a replacement for XML-based configuration. They define how the Spring container should create and configure beans.

The methods within a @Configuration class that are annotated with @Bean are responsible for creating and configuring individual beans.

The method annotated with @Bean can return an instance of a bean. You can configure the bean's properties, dependencies, and other attributes within this method.

Example:
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

```
### 3.  How do you handle the exception in Spring?

For a more general cases, we can customize our own exception handler by creating a `GlobalExceptionHandler` class. By using the @ControllerAdvice annotation. This allows you to define exception handling methods that apply to all controllers in your application.
@ControllerAdvice classes can define methods to handle various exceptions and return consistent error responses or perform other error-handling actions.
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred: " + ex.getMessage());
    }
}

```

### 4.  How do you do the validations in Spring? And list some validation annotaitons you know.

Some common Spring validation annotations include:
- @NotNull: Ensures that a field is not null.
- @NotEmpty: Ensures that a field is not empty (for collections, strings, and arrays).
- @NotBlank: Ensures that a field is not null and has at least one non-whitespace character (for strings).
- @Size(min, max): Validates the size or length of a field.
- @Min and @Max: Ensure that a numeric field is greater than or less than a specified value.
- @Pattern(regexp): Validates a field based on a regular expression pattern.
- @Email: Ensures that a field is a valid email address.
- @DateTimeFormat: Specifies the format of a date field.
- @Valid: Indicates that a nested object should also be validated.

### 5.  What is the actuator
Spring Boot Actuator is a set of production-ready features provided by the Spring Boot framework that helps you monitor and manage your Spring Boot application. 
Actuator offers a variety of tools and services that allow you to gain insights into your application's behavior, health, and performance, making it easier to troubleshoot issues and ensure that your application is running smoothly in a production environment.

### 6. What is MVC pattern?
The MVC (Model-View-Controller) pattern is a widely used architectural design pattern in software engineering and web development. It separates an application into three interconnected components, each with its own distinct responsibilities. The MVC pattern helps to manage the complexity of applications by promoting a clear separation of concerns.


- Model:
The Model represents the application's data and business logic.
It is responsible for managing and maintaining the application's state and business rules.
In the context of web development, the Model often interacts with a database to retrieve and persist data.
The Model notifies the View of any changes to the data, typically through a mechanism like the Observer pattern.

- View:The View represents the user interface (UI) and is responsible for displaying the data to the user.
It presents the data in a human-readable format and provides the user with an interface for interacting with the application.
The View doesn't contain application logic and should be focused on the presentation of data.
In web development, the View is often composed of HTML, CSS, and client-side JavaScript.

- Controller:The Controller acts as an intermediary between the Model and the View. It receives user input and processes it to determine how the Model should change. The Controller invokes methods on the Model to update data and interacts with the View to update the UI.
In web development, the Controller is often implemented as server-side code, such as a servlet, that handles HTTP requests and manages the application's flow.

### 7.  What is Front-Controller? 

A Front Controller is a design pattern commonly used in web applications to centralize and manage the processing of incoming requests. It serves as the entry point for handling all HTTP requests, providing a single point of control for routing requests, executing pre-processing logic, and dispatching the request to the appropriate components for further processing. The Front Controller design pattern is often employed in web frameworks to achieve a consistent and organized approach to request handling.

### 8.  What is DispatcherServlet? please decribe how it works.
The `DispatcherServlet` is a core component of the Spring Framework's web module, specifically in the context of Spring Web MVC. It acts as the front controller for Spring MVC applications, responsible for handling incoming HTTP requests, routing them to the appropriate controller, and managing the entire request-processing workflow. It plays a central role in implementing the Front Controller design pattern.

Here's how the DispatcherServlet works and its main responsibilities:

- Receiving HTTP Requests:

When a client, such as a web browser, sends an HTTP request to a Spring MVC application, the request is typically received by the web server (e.g., Tomcat, Jetty), which acts as a servlet container. Within the servlet container, the DispatcherServlet is defined as a servlet in the web.xml configuration file (or as a servlet registration in a Java-based configuration).

- Request Processing Flow:
When an HTTP request is received, the servlet container forwards it to the DispatcherServlet based on the URL mapping defined in the web.xml or Java configuration.The DispatcherServlet serves as the entry point for request processing in the Spring MVC application.

- Request Processing Phases:
The DispatcherServlet orchestrates the following phases of request processing:
Handler Mapping: The servlet first determines which controller should handle the request. It uses handler mappings, which are defined in the application context, to map request URLs to specific controller classes or methods.

- Interceptors: Interceptors can be configured to perform pre-processing and post-processing tasks. They can be applied globally or to specific controllers or request mappings.
Controller: The DispatcherServlet delegates control to the selected controller (or handler). The controller processes the request and returns a model and view or a response entity.

- View Resolution: If a view name is returned by the controller, the servlet resolves the view using a view resolver. The view can be a JSP, Thymeleaf template, or any other view technology supported by Spring MVC.
Model Data: Model data provided by the controller is made available to the view for rendering.

- View Rendering: The resolved view is rendered, and the response is generated based on the view and model data.
Post-Handling Interceptors: Any post-processing interceptors are executed.

- Response to the Client:
Once the DispatcherServlet completes all the phases of request processing, it generates an HTTP response and sends it back to the client.

### 9.  What is JSP and What is ModelAndView？

- `JSP (JavaServer Pages)`:
JSP is a technology used in web development to create dynamic web pages by embedding Java code within HTML templates. JSP files are processed on the server, and the resulting HTML is sent to the client's web browser. JSP allows web developers to write Java code within the HTML templates, which can be used to generate dynamic content, interact with databases, and control the flow of web applications.

- `ModelAndView` is a class commonly used in the Spring Framework for controlling the flow and rendering of web applications. It represents a model and a view, encapsulating data to be displayed and the view template that should be used to render that data. ModelAndView is often used to pass data between controllers and views in a Spring MVC application.

Example:
```java
@RequestMapping("/example")
public ModelAndView examplePage() {
    ModelAndView modelAndView = new ModelAndView();
    
    // Add data to the model
    modelAndView.addObject("message", "Hello, World!");
    
    // Set the view name (the JSP file to be used)
    modelAndView.setViewName("examplePage");
    
    return modelAndView;
}

```

### 10.  Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就行。)

Servlets are a fundamental component of Java-based web development, providing a platform-independent, server-side technology for building dynamic web applications. 

### 11. How many web server do you know? (Tomcat, Jetty, Jboss)
`Apache Tomcat`: Apache Tomcat, often referred to as Tomcat, is one of the most popular and widely used servlet containers for running Java-based web applications. It's known for its lightweight and efficient design, making it an excellent choice for hosting Java Servlets, JavaServer Pages (JSP), and web applications.

`Jetty`: Jetty is another lightweight and highly scalable servlet container and web server. It's often used in scenarios where low resource consumption and fast startup times are crucial, making it a good choice for embedded systems and microservices.

`JBoss` (WildFly): JBoss, now known as WildFly, is a powerful open-source application server for Java EE (Enterprise Edition) applications. It provides a robust platform for running enterprise-level applications with features like clustering, load balancing, and high availability.

`Nginx`: Nginx is a high-performance web server and reverse proxy server. While not a Java-specific server, it's commonly used to serve static content and act as a reverse proxy for Java applications, providing load balancing and caching capabilities.