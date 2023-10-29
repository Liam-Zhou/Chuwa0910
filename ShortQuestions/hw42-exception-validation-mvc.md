# 2. what is the @configuration and @bean?
@Configuration: This annotation is used at the class level and indicates that the class can be used by the Spring IoC container as a source of bean definitions.
Classes annotated with @Configuration will have their methods scanned for @Bean annotations.

@Bean: This annotation is used at the method level and indicates that the method will produce a bean to be managed by the Spring IoC container.

# 3. How do you handle the exception in Spring?
Use @ControllerAdvice to define a global exception handler bean where all the exception handlers can be found and @ExceptionHandler annotation to define each individual handler for each exception

# 4. How do you do the validations in Spring? And list some validation annotations you know.
Use @Valid in controller to apply the rule for each parameter. For each parameter, you can add rule like @NotEmpty for their fields.
Additional annotation for the rule: @Size, @Email 

# 5. What is the actuator?
the actuator in Spring is a library that contains methods to monitor the health of the spring application.
It exposes many apis like /health /info, and /metrics that provides insights about application status and behavior.

# 6. What is MVC pattern?
MVC pattern includes Controller, Model and View
Controller: The front controller maps the incoming request to a controller. Controllers contain the business logic of the application.
Model: Model is a container for data. It is used to transfer data from one part of the Spring MVC application to another.
View: View template receives the model containing data. It reads the model and displays the data.

# 7. What is frontend controller?
The front controller maps the incoming request to a controller and also returns the formatted response from View template to the client.

# 8. What is DispatcherServlet? please decribe how it works.
DispatcherServlet abstracts away the following tedious and boilerplate tasks and focus on useful business logic:
Mapping an HTTP request to a certain processing method
Parsing of HTTP request data and headers into data transfer objects (DTOs)or domain objects
Model-view-controller interaction
Generation of responses from DTOs, domain objects, etc.

# 9. What is JSP and What is ModelAndView？
JSP: JSP is a technology used for building web pages that support dynamic content. It is part of the Java EE suite of technologies, allowing developers to write HTML with embedded Java code. JSP can be thought of as an extension to servlets, offering a more convenient way to generate dynamic HTML content.
ModelAndView: is a container object that holds both the Model and the View. When a controller in Spring MVC handles a request, it can return a ModelAndView object, indicating which view should be used (like a specific JSP page) and what data (model) should be given to that view for rendering the response.

# 10. Could you please google any other servlets?
HttpServlet

# 11. How many web server do you know? 
Tomcat, Jetty, Nginx


