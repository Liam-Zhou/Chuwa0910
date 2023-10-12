#### hw42-exception-validation
###### 2.  what is the @configuration and @bean?
@Configuration is used to define a class as a source of bean definitions in Spring.
@Bean is used within a @Configuration class to declare methods that produce and configure Spring beans.

###### 3.  How do you handle the exception in Spring?
Using @ControllerAdvice and @ExceptionHandler:
Annotate a class with @ControllerAdvice to define global exception handling for Spring MVC application.

###### 4.  How do you do the validations in Spring? And list some validation annotaitons you know.
Annotate model fields with validation annotations (e.g., @NotNull, @Size). Use @Valid in controller methods to trigger validation. Handle validation errors in the controller. Display error messages in your view templates.
Validation annotations: @NotEmpty, @Size, @Pattern, @Email

###### 5.  What is the actuator?
Spring Boot Actuator is a set of production-ready features in Spring Boot for monitoring and managing applications. It includes built-in endpoints for checking health, gathering metrics, inspecting configurations, and more, making it easier to manage and monitor Spring Boot applications in production.


#### hw44-Spring-MVC
###### 2.  What is MVC pattern?
MVC (Model-View-Controller) is an architectural pattern used in software development to separate an application into three parts: Model (data and logic), View (user interface), and Controller (interaction and logic).

###### 3.  What is Front-Controller? 
A Front Controller is a design pattern in web applications where a single controller manages and routes all incoming requests, handling tasks like authentication and routing before passing requests to specific handlers. It centralizes request handling for consistency and security.


###### 4.  What is DispatcherServlet? please decribe how it works.
The DispatcherServlet in Spring MVC is the central component that handles incoming HTTP requests. It maps requests to appropriate controller methods, manages view resolution, and orchestrates the entire request-response cycle in a Spring-based web application.


###### 5.  What is JSP and What is ModelAndView？(please google to have a basic knowlege)
JSP (JavaServer Pages): JSP is a technology for creating dynamic web pages in Java applications, allowing Java code to be embedded in HTML templates.
ModelAndView: ModelAndView is a Spring class used to bundle model data (for the view) and the view name into a single object for easier data passing from controllers to views in Spring MVC.

###### 6.  Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就行。)
- HttpServlet: A base class for servlets that simplifies handling HTTP requests and responses. It provides methods for handling various HTTP methods (GET, POST, etc.) and managing sessions.
- GenericServlet: An abstract class that serves as the base class for all servlets. It provides a generic way to handle requests and responses but does not include specific methods for handling HTTP.
- JSP Servlet: Responsible for processing JavaServer Pages (JSP). It compiles JSP pages into Java servlets, which are then executed to generate dynamic web content.
- RequestDispatcher: Not a servlet itself, but a utility class used within servlets. It allows servlets to forward requests or include responses to/from other resources, such as servlets, JSP pages, or HTML files.
- Filter: A servlet filter intercepts requests and responses to perform tasks like authentication, logging, or request modification. Filters can be applied to multiple servlets in a web application.
Session Tracking Servlets: Servlets that manage user sessions, such as HttpSession and Cookie.
- FileUpload Servlets: Servlets that handle file uploads from HTML forms, often used in combination with libraries like Apache Commons FileUpload.
- SOAP Servlets: Servlets that handle SOAP (Simple Object Access Protocol) requests and responses for web services.
- RESTful Servlets: Servlets used to implement RESTful web services, typically by mapping HTTP methods (GET, POST, PUT, DELETE) to specific servlet methods.
- WebSocket Servlets: Servlets that handle WebSocket connections, allowing bidirectional communication between the server and clients in real-time.


###### 7. How many web server do you know? (Tomcat, Jetty, Jboss)
- Apache HTTP Server (Apache): One of the most popular open-source web servers worldwide, known for its extensibility and configurability.
- Nginx: A lightweight, high-performance open-source web server and reverse proxy server. It's often used for serving static content and as a load balancer.
- Microsoft Internet Information Services (IIS): A web server developed by Microsoft for Windows Server environments. It supports various web technologies and integration with Microsoft services.
- LiteSpeed Web Server: A commercial web server known for its high performance and security features. It's often used in hosting environments.
- Caddy: A modern, open-source web server with automatic HTTPS by default. It's designed to be easy to configure and use.
- Tomcat: An open-source application server developed by the Apache Software Foundation for running Java Servlets and JavaServer Pages (JSP).
- Jetty: An open-source web server and servlet container often used for embedding in Java applications and for developing lightweight web services.
- Cherokee: An open-source web server and reverse proxy server known for its user-friendly configuration interface.
- Lighttpd (Lighty): An open-source web server known for its speed and efficiency, often used for serving static content and as a proxy server.
- CERN HTTPd: The original web server developed at CERN by Tim Berners-Lee, which laid the foundation for modern web servers.
- Gunicorn: A Python WSGI HTTP server for running Python web applications, commonly used with Django and Flask.
- Apache Traffic Server: An open-source caching proxy server and reverse proxy server developed by the Apache Software Foundation.
- Hiawatha: An open-source web server with a focus on security and ease of use.
- Monkey: A lightweight and high-performance open-source web server for Linux.