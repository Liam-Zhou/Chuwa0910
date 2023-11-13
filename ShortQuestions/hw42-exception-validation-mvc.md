# Ke Chen - hw42-exception-validation + MVC

# exception-validation
## 1.  List all of the annotations you learned from class and homework to annotaitons.md
see files: annotaitons.md
## 2.  what is the @configuration and @bean?
1. **@Configuration**:
   - `@Configuration` is an annotation that <u>marks a Java class as a configuration class</u>. 
   
   It indicates that the class contains bean definitions and configuration for the Spring application context. Configuration classes are typically used in place of XML configuration files. They are processed by the Spring container, and their methods annotated with `@Bean` are used to define beans.

   Example:
   ```java
   @Configuration
   public class AppConfig {
       // Bean definitions using @Bean
       @Bean
       public MyBean myBean() {
           return new MyBean();
       }
   }
   ```

2. **@Bean**:
   - `@Bean` is an annotation that is used within a `@Configuration` class to <u>define a Spring bean</u>. It <u>marks a method as a factory for creating and configuring a bean</u>. 
   
   The return value of the method becomes the bean instance, and the method's name becomes the bean's name. You can also customize the bean's name using the `name` attribute of the `@Bean` annotation.

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

## 3.  How do you handle the exception in Spring?
In Spring, you can handle exceptions using a variety of mechanisms and techniques. Here are some common approaches to handling exceptions in a Spring application:

1. **Using Exception Handling in Controllers**:
   - Spring MVC provides a way to handle exceptions at the controller level using the `@ExceptionHandler` annotation. You can define methods within your controller classes and annotate them with `@ExceptionHandler` to handle specific exceptions. When an exception of the specified type occurs during the execution of a controller method, Spring will invoke the corresponding exception handler method.

   ```java
   @Controller
   public class MyController {
       @ExceptionHandler(MyCustomException.class)
       public ModelAndView handleCustomException(MyCustomException ex) {
           // Handle the exception and return a response or view
       }
   }
   ```

2. **Global Exception Handling with `@ControllerAdvice`**:
   - You can create a global exception handler for your Spring MVC application using the `@ControllerAdvice` annotation. This allows you to define exception handling logic that applies to multiple controllers. You can use the `@ExceptionHandler` method within a controller advice class to handle exceptions globally.

   ```java
   @ControllerAdvice
   public class GlobalExceptionHandler {
       @ExceptionHandler(Exception.class)
       public ModelAndView handleGlobalException(Exception ex) {
           // Handle the exception and return a response or view
       }
   }
   ```

3. **Using `@ResponseStatus`**:
   - The `@ResponseStatus` annotation can be used to specify the HTTP status code to be returned when an exception is thrown. You can annotate your custom exception classes with `@ResponseStatus` to define the status code and reason for the response.

   ```java
   @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
   public class ResourceNotFoundException extends RuntimeException {
       // ...
   }
   ```

4. **Global Exception Handling with `HandlerExceptionResolver`**:
   - You can create a custom implementation of the `HandlerExceptionResolver` interface to handle exceptions globally. This approach allows you to define custom exception resolution logic and is more flexible than using `@ControllerAdvice`.

5. **Using Spring AOP for Exception Logging**:
   - Spring AOP (Aspect-Oriented Programming) can be used to create aspects that log exceptions. You can define pointcuts that intercept method executions and log exceptions or take specific actions when exceptions occur.

6. **Custom Error Pages**:
   - You can configure custom error pages in your web application deployment descriptor (e.g., web.xml) or use the `ErrorController` in Spring Boot to customize error handling.

7. **Exception Translation**:
   - Spring provides support for translating exceptions thrown by data access frameworks, such as Hibernate or JPA, into Spring's `DataAccessException` hierarchy.

8. **Using Spring Boot Actuator**:
   - In a Spring Boot application, you can use Spring Boot Actuator to expose various management and monitoring endpoints, including exception information. This can be helpful for diagnosing issues in production environments.


## 4.  How do you do the validations in Spring? And list some validation annotaitons you know.
In Spring, you can <u>perform data validation using various techniques, including validation annotations provided by the Spring framework and custom validation logic</u>. Here are some common ways to perform validation in a Spring application:

1. **Validation Annotations**:
   Spring provides a set of validation annotations that can be used to validate input data. 
   
   These annotations can be applied to fields of a class and are checked by Spring's validation framework. Some of the most commonly used validation annotations include:
   - `@NotNull`: Validates that a field is not null.
   - `@NotEmpty`: Validates that a field is not empty (for Strings, Collections, etc.).
   - `@NotBlank`: Validates that a String field is not null and has at least one non-whitespace character.
   - `@Size`: Validates the size of a field, e.g., specifying a minimum and maximum length.
   - `@Min` and `@Max`: Validates that a numeric field is within a specified range.
   - `@Email`: Validates that a String field is a valid email address.
   - `@Pattern`: Validates that a field matches a specified regular expression pattern.

   Example of using validation annotations in a Spring entity class:

   ```java
   public class User {
       @NotNull
       @Size(min = 3, max = 50)
       private String username;

       @Email
       private String email;
       
       // Getters and setters
   }
   ```

2. **Custom Validator Classes**:
   You can create custom validation classes by implementing the `Validator` interface from the Spring framework. Implement the `validate` method to define your custom validation logic. Then, you can use these custom validators with Spring's validation framework.

   ```java
   public class UserValidator implements Validator {
       @Override
       public boolean supports(Class<?> clazz) {
           return User.class.isAssignableFrom(clazz);
       }

       @Override
       public void validate(Object target, Errors errors) {
           User user = (User) target;
           if (!user.getPassword().equals(user.getConfirmPassword())) {
               errors.rejectValue("confirmPassword", "user.password.mismatch", "Password and confirmation do not match.");
           }
       }
   }
   ```

3. **Using `@Valid` Annotation**:
   In Spring MVC, you can use the `@Valid` annotation in your controller methods to trigger validation of command objects or form-backing objects. When you annotate a method parameter with `@Valid`, Spring will automatically validate the object, and any validation errors will be added to the `BindingResult`.

   ```java
   @PostMapping("/register")
   public String register(@Valid User user, BindingResult result) {
       if (result.hasErrors()) {
           // Handle validation errors
           return "registerForm";
       }
       // Process registration
       return "registrationSuccess";
   }
   ```

4. **Using JSR-303 (Bean Validation)**:
   Spring supports the Java API for Bean Validation (JSR-303), which allows you to define validation constraints using annotations like `@NotNull`, `@Size`, and more. You can use these annotations on your domain classes and leverage Spring's validation framework to validate them.

   ```java
   public class User {
       @NotNull
       @Size(min = 3, max = 50)
       private String username;

       // ...
   }
   ```

5. **Custom Validation Logic**:
   You can also implement custom validation logic by creating validation methods in your service or controller classes. These methods can perform custom validation checks and return appropriate validation messages.

   ```java
   public String validateUser(User user) {
       if (userRepository.existsByUsername(user.getUsername())) {
           return "Username already exists.";
       }
       return null; // No validation error
   }
   ```

## 5.  What is the actuator?
Spring Boot Actuator is <u>a set of production-ready features and tools for monitoring and managing Spring Boot applications</u>. 

It provides various out-of-the-box endpoints that <u>expose runtime information about your application, such as health, metrics, application environment details, and more</u>. 

Spring Boot Actuator is particularly useful for monitoring and managing Spring Boot applications in production environments.

Key features and components of Spring Boot Actuator include:

1. **Health Indicator**: The `/actuator/health` endpoint provides information about the health of your application. It can be customized to perform various health checks and report the overall health status.

2. **Metrics**: Spring Boot Actuator offers a wide range of metrics related to your application's performance, such as memory usage, garbage collection statistics, HTTP request metrics, and custom application-specific metrics. You can access these metrics via the `/actuator/metrics` endpoint.

3. **Environment Information**: The `/actuator/env` endpoint exposes information about the application's environment, including properties, configuration sources, and system properties.

4. **Application Info**: The `/actuator/info` endpoint allows you to provide custom information about your application. This can be useful for including version information, release notes, or any other relevant data.

5. **Audit Events**: The `/actuator/auditevents` endpoint provides information about security audit events, which is particularly useful for auditing and monitoring security-related activities.

6. **Application Shutdown**: Spring Boot Actuator includes an endpoint, `/actuator/shutdown`, which allows you to gracefully shut down a Spring Boot application remotely. This is particularly useful in a microservices architecture for controlled application termination.

7. **Custom Endpoints**: You can create custom endpoints by implementing the `Endpoint` interface and registering them with Spring Boot Actuator. This allows you to expose custom application-specific information via management endpoints.

## 6.  watch those videos(泛泛地看一遍，能理解多少是多少。没有必要看其它视频)
- a. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
- b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
- c.  IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
- d.  Bean:
    - i.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
    - ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
    - iii.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
- e.  DI: 
    - i.  https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
    - ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71

done


# MVC:

## 1.  List all of the annotations you learned from class and homework to annotaitons.md

see files: annotaitons.md

## 2.  What is MVC pattern?
The Model-View-Controller (MVC) pattern is a software architectural pattern used for <u>designing and structuring applications</u>, particularly those with a user interface. 

<u>It separates the application into three interconnected components, each responsible for a distinct set of tasks</u>:

1. **Model**: 逻辑
   - The Model <u>represents the application's data and business logic</u>. It defines the structure of the data, enforces data validation, and manages interactions with the data source (such as a database). The Model is responsible for data retrieval, manipulation, and storage. It should be independent of the user interface.

2. **View**: 返回视图
   - The View <u>represents the user interface and is responsible for presenting data to the user</u>. It displays the information from the Model to the user and interprets user input (e.g., mouse clicks, keyboard inputs) and forwards it to the Controller for processing. In a typical desktop application, the View is what the user sees and interacts with.

3. **Controller**: Model and the View的中间件
   - The Controller <u>acts as an intermediary between the Model and the View</u>. It receives user input from the View, processes that input (e.g., updates data in the Model or initiates actions), and updates the View to reflect changes in the Model. The Controller contains the application's business logic and coordinates the flow of data between the Model and the View.

## 3.  What is Front-Controller? 
A Front Controller is a design pattern used in web development to centralize request handling and processing in a web application. 

It <u>acts as a single entry point for all incoming requests, routing those requests to appropriate handlers, controllers, or components within the application</u>. 处理所有的imcoming request，并且进行分发他们给合适的handlers， controllers，components.

The Front Controller pattern helps in achieving better organization, modularity, and consistency in web applications.

By centralizing request processing and routing, the Front Controller pattern simplifies the handling of various aspects of web application development, <u>such as handling different types of requests, authentication, and authorization</u>, and allows for better organization of application logic.

## 4.  What is DispatcherServlet? please decribe how it works.
The `DispatcherServlet` is a key component in the Spring Framework, particularly in the context of Spring Web MVC. 

It <u>acts as a front controller and plays a central role in processing and dispatching HTTP requests in a Spring-based web application</u>. 

Here's how the `DispatcherServlet` works:
1. **Initialization**:
   - When a Spring-based web application is started, the `DispatcherServlet` is typically configured in the web application's deployment descriptor (e.g., `web.xml` in a traditional Java EE application or in a JavaConfig class in a Spring Boot application). The `DispatcherServlet` is mapped to a specific URL pattern (e.g., `"/"`), indicating that it should handle all requests that match that pattern.

2. **Request Handling**:
   - When an HTTP request is received, the Servlet container (e.g., Apache Tomcat) routes the request to the `DispatcherServlet` based on the URL pattern mapping. For example, if the `DispatcherServlet` is mapped to `"/"` (the root context), any request that matches this URL pattern will be directed to the `DispatcherServlet`.

3. **Request Processing**:
   - The `DispatcherServlet` receives the request and begins processing it. One of its primary tasks is to determine which controller should handle the request. It uses a mechanism known as the "handler mapping" to do this.
   - The handler mapping, which can be configured with various strategies, is responsible for mapping the request to a specific controller based on factors like the URL, HTTP method, and other criteria.
   - Once the `DispatcherServlet` determines the appropriate controller, it dispatches the request to that controller for further processing.

4. **Controller Execution**:
   - The selected controller, often annotated with `@Controller` or implementing a controller interface, contains the application's business logic. The `DispatcherServlet` calls the appropriate method (typically a handler method annotated with `@RequestMapping`) on the controller to execute the requested functionality.
   - The controller may interact with the model to fetch or update data and prepare a response.

5. **View Resolution**:
   - After the controller has executed its logic, it returns a logical view name or a view object (e.g., a `ModelAndView`). The `DispatcherServlet` then uses a "view resolver" to map this logical view name to an actual view that will be used to render the response.
   - The view resolver is responsible for determining which view technology to use (e.g., JSP, Thymeleaf, FreeMarker) and finding the appropriate view template.

6. **View Rendering**:
   - The `DispatcherServlet` invokes the chosen view to render the response. The view generates the HTML or other output based on the model data provided by the controller.
   - The rendered output is then sent back to the client as the response.

7. **Response Return**:
   - The `DispatcherServlet` sends the rendered response back to the client's web browser, and the client sees the result of the request.

8. **Lifecycle and Cleanup**:
   - The `DispatcherServlet` manages its lifecycle, initializing itself when the application starts and cleaning up resources when the application is shut down.

## 5.  What is JSP and What is ModelAndView？(please google to have a basic knowlege)
**JSP (JavaServer Pages)**:
- JSP, <u>is stand for JavaServer Pages</u>, is <u>a technology</u> used in web development to <u>create dynamic web pages</u>. It is part of the Java EE (Enterprise Edition) platform and is often used in combination with servlets to build web applications.
- JSP pages are text-based documents with embedded Java code, HTML markup, and custom JSP tags. They allow developers to create web pages that can contain dynamic content, including database queries, conditionals, loops, and more.
- JSP pages are processed on the server, and the resulting HTML is sent to the client's web browser. This approach separates the presentation layer (JSP) from the business logic (servlets or controllers), following the MVC (Model-View-Controller) architectural pattern.

**ModelAndView**:
- `ModelAndView` is a class commonly used in Spring Framework for web applications. <u>It represents a combination of data to be displayed (the "Model") and a logical view name (the "View").</u>
- In the context of Spring MVC, when a controller method processes a request, it often needs to pass data to the view (template) that will be rendered to generate the response. The data is stored in the "Model" part of the `ModelAndView`.
- The "View" part of the `ModelAndView` is the logical view name, which is resolved by a view resolver to determine which view template (e.g., JSP, Thymeleaf, FreeMarker) should be used to render the response.

For example, in a Spring MVC controller method, you might create a `ModelAndView` object as follows:

```java
@RequestMapping("/example")
public ModelAndView exampleController() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("exampleView"); // Set the logical view name
    modelAndView.addObject("dataKey", someData); // Add data to be passed to the view
    return modelAndView;
}
```

In this example, `"exampleView"` is the logical view name that Spring will resolve to a specific view template (e.g., a JSP file). `"dataKey"` is a key used to access the data in the view template.

<u>The `ModelAndView` object is a convenient way to package both the data and the view information, making it easy for a controller to pass data to the view and specify the view to be used for rendering the response.</u>

## 6.  Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就行。)
1. **Apache Tomcat**: Apache Tomcat is a widely used servlet container and web server. It's not just a servlet but a servlet container that runs servlets and JSPs.

2. **Jetty**: Jetty is another servlet container that is often used in lightweight and embedded web server scenarios.

3. **GlassFish**: GlassFish is a Java EE application server that supports servlets and various other Java EE technologies.

4. **WildFly**: WildFly is another Java EE application server, formerly known as JBoss AS, that supports servlets and Java EE technologies.

5. **Resin**: Caucho Resin is a Java EE application server and servlet container.

6. **WebLogic**: Oracle WebLogic Server is a Java EE application server that supports servlets and enterprise Java applications.

7. **WebSphere**: IBM WebSphere Application Server is another Java EE application server supporting servlets and enterprise applications.

These servlet containers and application servers provide the runtime environment for running Java servlets and Java EE applications. Developers can choose the servlet container or application server that best fits their application's requirements and deployment scenarios.


## 7.  How many web server do you know? (Tomcat, Jetty, Jboss)
There are many web servers available for various purposes, but I'll mention a few popular ones:

1. **Apache HTTP Server (Apache)**: A widely used, open-source web server known for its performance, flexibility, and extensibility.

2. **Nginx**: A high-performance, lightweight web server and reverse proxy server. It's often used for load balancing and serving static content.

3. **Microsoft Internet Information Services (IIS)**: A web server developed by Microsoft for Windows-based servers. It supports various web technologies and services.

4. **Apache Tomcat**: While primarily known as a servlet container, Tomcat can also function as a web server for serving static content.

5. **Jetty**: A lightweight, embeddable web server and servlet container that is often used in embedded and microservices scenarios.

6. **LiteSpeed Web Server**: A commercial web server known for its high performance and security features.

7. **Caddy**: An open-source web server with automatic HTTPS support and other modern features.

8. **OpenLiteSpeed**: An open-source web server, a sibling of LiteSpeed, designed for simplicity and performance.

9. **Cherokee**: An open-source web server that offers a user-friendly web-based interface for configuration.

10. **Sun/Oracle Web Server**: A web server software developed by Sun Microsystems and later acquired by Oracle.

11. **IBM HTTP Server (IHS)**: A web server based on Apache HTTP Server and developed by IBM for use with their products.

12. **CherryPy**: A minimalistic Python web framework that can also be used as a standalone web server for small to medium-sized applications.


## 8.  clone this repo, and run it in you local.
a. https://github.com/TAIsRich/springmvc5-demo

b. Notice that you need to configure the Tomcat by yourself. tutorial in the slides.

c. find out the APIs in controlelr and call some APIs, In slides, I also list some API.

d. remeber to create a database for this project

e. all details in the slides.

### details:
***a.*** see files coding: springmvc5-demo

***b.*** 
- mac m1 下载tomcat： 
    - https://tomcat.apache.org (下载tar.gz)
    - 对于类 Unix 平台，选择 tar.gz 格式的压缩包，进行解压和配置。tar.gz压缩格式用于类 unix 平台，而 zip 用于 windows 平台。

    - https://blog.csdn.net/m0_65731386/article/details/129014433 (IntelliJ IDEA配置Tomcat)
    - https://blog.csdn.net/kk651/article/details/129725190 (IntelliJ IDEA配置Tomcat 有运行)

    ![Intellij IDEA上显示运行成功](https://github.com/Liam-Zhou/Chuwa0910/blob/ke_chen/master/ShortQuestions/images/hw42-2.png)
    ![浏览器端返回index.jsp](https://github.com/Liam-Zhou/Chuwa0910/blob/ke_chen/master/ShortQuestions/images/hw42-1.png)


- 出现的错误：
    - https://blog.51cto.com/u_15896104/5895387 (在pom.xm文件中配置tomcat插件时编译出现了问题)
    - https://blog.csdn.net/weixin_30586085/article/details/102436757(zip文件下载后配置Intellij IDEA ＋ Tomcat 出现权限问题(error=13, Permission denied))

***c.***

***d.***
***e.***
