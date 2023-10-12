1. List all of the annotations you learned from class and homework to annotaitons.md
The new annotaitons are in the annotaitons-42-validation.md<br>


2. what is the @configuration and @bean?<br>
@Configuration and @Bean are annotations used in the Spring Framework for defining and configuring beans in a Spring application context. These annotations are part of the Java-based configuration approach provided by Spring, an alternative to XML-based configuration.<br>
@Configuration:The @Configuration annotation is used to indicate that a class is a configuration class in a Spring application. Configuration classes are used to define Spring beans and their dependencies in a programmatic way using Java code rather than XML configuration. You can think of a @Configuration class as a replacement for the XML configuration file, where you define various beans and their relationships. Configuration classes may also include other annotations like @ComponentScan and @PropertySource to further configure the application context.<br>
@Bean:The @Bean annotation is used within a @Configuration class to declare a method that produces a Spring bean. When a method is annotated with @Bean, it tells the Spring container that the return value of that method should be registered as a Spring bean in the application context. You can use this method to configure and instantiate beans and define their dependencies, allowing for fine-grained control over the configuration.<br>


3. How do you handle the exception in Spring?<br>
Handling exceptions in a Spring application can be done in several ways. Spring provides a comprehensive framework for dealing with exceptions and customizing how they are handled.Using @ExceptionHandler:Annotate methods in your controller classes with @ExceptionHandler to handle specific exceptions. When an exception occurs during the execution of a controller method, Spring will look for a corresponding @ExceptionHandler method to handle the exception.
Using @ControllerAdvice:Annotate a class with @ControllerAdvice to create global exception handlers that can be shared across multiple controllers. This is particularly useful for handling common exceptions or for centralizing exception handling logic.

4. How do you do the validations in Spring? And list some validation annotaitons
   you know.<br>
In Spring, it performs data validation using the Spring Framework's validation features. Spring provides a powerful and flexible way to validate data, typically used in web applications to validate form input.<br>
@NotNull: Ensures the field is not null.<br>
@NotEmpty: Ensures the field is not empty (for strings, collections, arrays, etc.).<br>
@NotBlank: Ensures the field is not null and contains at least one non-whitespace character.<br>
@Size: Specifies the size or length constraints for a field.<br>
@Min and @Max: Specifies minimum and maximum values for numeric fields.<br>
@Pattern: Applies a regular expression pattern to a field.<br>


5. What is the actuator?<br>
Spring Boot Actuator is a set of production-ready features that are included in the Spring Boot framework to help you monitor and manage your application. It provides built-in, out-of-the-box tools and endpoints for gathering information about your application's health, metrics, configuration, and more, which is crucial for production systems. Spring Boot Actuator simplifies the process of monitoring and managing a Spring Boot application.Spring Boot Actuator include Health Checks,Metrics,Environment Information,Configuration Properties,Application Information,Audit and Trace Information,Thread Dump and Heap Dump,Shutdown,Custom Endpoints.


6. watch those videos (done)

-----------------------------------------------MVC--------------------------------------------------------------------------------<br>

1. List all of the annotations you learned from class and homework to
   annotaitons.md
The new annotaitons are in the annotaitons-42-validation-44-MVC.md<br>

2. What is MVC pattern?<br>
The Model-View-Controller (MVC) pattern is a design pattern commonly used in software engineering, particularly in the development of user interfaces and web applications. MVC is a way to organize the structure of an application, separating its components into three interconnected and distinct parts: Model, View, and Controller. This separation helps in maintaining a clean and modular codebase and simplifies the management of different concerns in an application.<br>
Model:The Model represents the application's data and business logic. It encapsulates the data and the rules for data manipulation. The Model is responsible for data storage, retrieval, and any data-related operations. It notifies the View and Controller when data changes occur.<br>
View:The View is responsible for the presentation and rendering of data. It displays the data to the user and handles user interface components (UI elements) like buttons, forms, and widgets. The View observes the Model and updates its presentation when the Model's data changes. The View should not contain business logic and should remain as lightweight as possible.<br>
Controller:The Controller acts as an intermediary between the Model and the View. It receives user input and processes it, invoking the appropriate methods on the Model to update data. The Controller listens for user interactions and communicates with the Model to change the application's state. It updates the View to reflect changes in the Model's data.

3. What is Front-Controller?<br>
A Front Controller is a design pattern used in web development to handle requests, centralize request processing, and provide a single point of entry into an application. It is a key architectural component in many web frameworks and is responsible for routing incoming requests to the appropriate handlers or controllers. The Front Controller pattern promotes the organization and centralization of request-handling logic in web applications, making it easier to manage and maintain.

4. What is DispatcherServlet? please decribe how it works.<br>
The DispatcherServlet is a central component in the Spring Web MVC framework, and it plays a crucial role in handling incoming HTTP requests and dispatching them to the appropriate controllers and handlers. It acts as a Front Controller in the Spring MVC architecture, providing a single entry point for request handling.<br>
Client Request->Mapping to DispatcherServlet->DispatcherServlet Processing->Handler Mapping->Controller Execution->View Resolution->View Rendering->Response Sent to Client.<br>


5. What is JSP and What is ModelAndView？<br>
JSP (JavaServer Pages) and ModelAndView are components commonly used in Java web applications, specifically in the context of the Spring Framework and Spring MVC, for handling web page rendering and controlling the flow of the application.JSP is a technology used to create dynamic web pages in Java. It allows developers to embed Java code directly into HTML templates, making it easier to generate dynamic content. JSP pages have a .jsp extension and can include Java code snippets enclosed within <% %> tags. JSP is often used in combination with servlets to build web applications. Servlets handle requests and business logic, and JSP is used for rendering the HTML response. JSP pages can access Java objects and data from servlets, making it possible to display dynamic content in web pages. JSP pages can include standard tags and custom tags (tag libraries) for encapsulating and reusing common functionality and UI elements.<br>
ModelAndView is a class in Spring MVC used to combine both data (the model) and the view in a single object. It's often returned from a controller method to specify which view should be rendered and what data should be passed to that view. The "model" part of the ModelAndView contains data that the view can use to render dynamic content. This data can be any Java object, such as a Map, a POJO, or a Model object. The "view" part of the ModelAndView specifies which view template should be used to render the response. It is usually a logical view name that can be resolved by a View Resolver to an actual view template (e.g., a JSP page). By using ModelAndView, you can separate the model data from the view resolution, which makes your controllers more flexible and easier to test.<br>


6. Could you please google any other servlets<br>
GenericServlet  and HttpServlet <br>

7. How many web server do you know? <br>
Tomcat, Jetty, Jboss, WebLogic, IBM WebSphere<br>

8. clone this repo, and run it in you local.<br>
![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)