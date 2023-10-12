### What is MVC pattern?

MVC stands for Model-View-Controller. It's a software architectural pattern commonly used for designing user interfaces. In the MVC pattern:

* Model: Represents the data and business logic of the application. It notifies views when there's a change in the data.
* View: Presents the data to the user and sends user commands to the controller.
* Controller: Processes the user input and performs interactions with the model and view based on that input.

### What is Front-Controller? 

A Front-Controller is a design pattern where a single controller handles all requests for a website.
It centralizes request handling, allowing for common operations to be applied to every request. This pattern is often used in web applications.

### What is DispatcherServlet? please decribe how it works.

The DispatcherServlet is a front controller implementation that is provided by Spring Boot. It is responsible for handling all incoming requests to a Spring Boot application.

The DispatcherServlet works by first mapping the request path to a controller. It then instantiates the controller and invokes the appropriate method on the controller. The controller then processes the request and returns a ModelAndView object.

The ModelAndView object contains the model data for the response and the name of the view to render. The DispatcherServlet then renders the view and returns the response to the user.

### What is JSP and What is ModelAndView

JSP stands for JavaServer Pages. It is a technology that allows you to embed Java code in HTML pages. This allows you to create dynamic web pages that can display data from the database or other sources.

A ModelAndView object is a Spring object that contains the model data for the response and the name of the view to render. The DispatcherServlet uses the ModelAndView object to render the view and return the response to the user.

### Could you please google any other servlets

Here are some other servlets:

* ServletContextListener: Listens for ServletContext events, such as context initialization and context destruction.
* HttpServletRequestListener: Listens for HttpServletRequest events, such as request initialization and request destruction.
* HttpSessionListener: Listens for HttpSession events, such as session creation and session destruction.
* Filter: Intercepts requests and responses, and can be used to modify them or to perform other tasks.

### How many web server do you know? (Tomcat, Jetty, Jboss)

* Apache Tomcat
* Eclipse Jetty
* JBoss WildFly
* GlassFish
* WebSphere Application Server
* Nginx
* OpenResty
* Caddy
