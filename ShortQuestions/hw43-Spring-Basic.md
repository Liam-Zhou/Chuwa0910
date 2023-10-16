###### 2.  What is Spring and Springboot? What is the benfits of using Srpingboot?
Spring is a Java framework for building enterprise applications, while Spring Boot is an extension that simplifies and accelerates the development process by providing conventions and defaults. Benefits of Spring Boot include rapid development, reduced boilerplate code, an embedded server, and support for building microservices and production-ready applications.

###### 3.  What is IOC and What is DI?
- IoC (Inversion of Control): It's a design principle where control over object creation and management is shifted from your code to a framework or container.
- DI (Dependency Injection): It's a technique in IoC where dependencies required by a class are provided from the outside rather than created within the class itself.

###### 4.  What is  @CompnonentScan?
@ComponentScan is a Spring annotation used to specify the base package for component scanning. It tells Spring where to look for classes annotated with @Component, @Service, @Repository, etc., so they can be automatically registered as Spring beans.

###### 5.  How to define which package spring need to scan in xml and annotaiton? 
- XML Configuration: Use <context:component-scan> in your Spring XML configuration file to specify the package(s) to scan for components.
- Annotation Configuration: Use @ComponentScan annotation in a Java configuration class to specify the package(s) to scan for components.

###### 6.  What is  @SpringbootApplication?
@SpringBootApplication is a meta-annotation in Spring Boot that combines multiple annotations to simplify the configuration and bootstrapping of a Spring application. It's commonly used as the main annotation on the application's main class.

###### 7. How many ways wo can define a bean?
XML Configuration: Define beans in an XML file.
Java Configuration: Use @Configuration and @Bean annotations.
Component Scanning: Annotate classes with @Component or related annotations.
Factory Beans: Implement the FactoryBean interface.
Stereotype Annotations: Use @Service, @Repository, or other stereotype annotations.
Third-Party Libraries: Some libraries may provide their own ways to define beans.

###### 8.  What is default bean name for  @Component and  @Bean?
@Component: Default bean name is the uncapitalized class name (e.g., myComponent for class MyComponent).
@Bean: Default bean name is the method name (e.g., myBean for method myBean()).

###### 9.  What is the difference between  @component and  @service,@repository?
Use @Component for general-purpose beans or when you don't need the specific behaviors associated with @Service or @Repository.
Use @Service for service layer components that handle business logic.
Use @Repository for data access components that interact with databases or data sources.

###### 10. How many annotaitons we can use to inject the bean?
@Autowired: Injects a bean by type.
@Qualifier: Specifies the bean name when multiple beans of the same type exist.
@Resource: Allows injection by name or type (Java EE standard).
@Inject: Similar to @Autowired, part of Java Dependency Injection standard (JSR 330).
@Value: Injects property values from configuration files into beans.

###### 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
- Constructor Injection: Preferred for its safety and explicitness, ensuring valid object states upon construction.
- Setter Injection: Offers flexibility for changing or updating dependencies at runtime.
- Field Injection: Simpler and concise but can make dependency requirements less explicit. Constructor injection is often preferred as a default choice due to its benefits.

###### 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
To set a primary bean, use the @Primary annotation on the bean definition.
Spring will automatically inject the primary bean of a given type by default.
If no primary bean is set, you can use @Autowired with @Qualifier or Optional to handle the absence of a primary bean.

###### 13. What is the difference between BeanFactory and ApplicationContext in Spring?
- BeanFactory is a lightweight container with basic DI and bean management features, suitable for resource-constrained environments or scenarios where lazy initialization is important.
- ApplicationContext is a more feature-rich container that builds upon BeanFactory. It offers additional functionality, such as eager initialization, advanced AOP support, message propagation, event handling, and resource loading, making it the preferred choice for most Spring applications.

###### 14. What is the Scope of a Bean?  and list the examples for each scope.
Singleton: One instance per container (default). Suitable for stateless and shared beans.
Prototype: A new instance per request. Suitable for stateful, non-shared beans.
Request: A new instance per HTTP request in a web application.
Session: One instance per user session in a web application.
Application: One instance for the entire application in a web context.
WebSocket: A new instance per WebSocket session.
Custom Scopes: You can create custom scopes as needed for specialized use cases.
