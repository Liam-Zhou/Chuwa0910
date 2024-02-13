# Homework 43 - Spring Basic

## 1. List all of the annotations you learned from class and homework to annotaitons.md

## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?

They are both part of the Spring Framework in the Java APPLICATION. Spring Boot is an extension of the Spring Framework that simplifies the process of building production-ready applications.

## 3. What is IOC and What is DI?

- `IoC (Inversion of Control)`: a design principle that reverses the flow of control in a software application. In IoC, the control flow is inverted, and the framework or container manages the flow of the application. IoC is often implemented using a container or framework that manages the instantiation and lifecycle of components, as well as their dependencies.
- `Dependency Injection (DI)`: a specific technique used to implement IoC. It is a way to achieve IoC by injecting (passing) dependencies into a component from the outside, rather than having the component create its dependencies itself.

## 4. What is @ComponentScan?

`@ComponentScan`: used to specify the base package(s) for Spring to scan for Spring-managed components, such as Spring beans.

## 5. How to define which package spring need to scan in xml and annotaiton?

- xml: `<context:component-scan base-package="com.example.myapp"/>` element within your Spring XML configuration file.
- annotation: `@ComponentScan` annotation within a Java configuration class.

## 6. What is @SpringbootApplication?

`@SpringbootApplication`: annotate your main application class

## 7. How many ways we can define a bean?

- Class Level
  - @Component
  - @Service
  - @Repository
  - @Controller
  - @ControllerAdvice
- Method Level
  - @Bean (used with @Configuration together)
- XML

## 8. What is default bean name for @Component and @Bean?

Class name with the first letter in lowercase.

## 9. What is the difference between @component and @service,@repository?

Same function, but indicate different component in the Spring framework, to make it more readable for coder.

## 10. How many annotaitons we can use to inject the bean?

    - @Autowired
    - @Resource
    - @Inject

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

- Field Injection with `@Autowired`
- Constructor Injection (best): It ensures that the required dependencies are provided at the time of the object's creation, making the class ready for use immediately.
- Setter Injection

## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary.

`@Qualifier` > `@Primary` > By Name > throw exception

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?

Both are containers responsible for managing Spring beans.
`ApplicationContext` is used more frequently in Spring applications because of its additional features, such as eager initialization, support for internationalization, event handling, and enhanced resource loading. However, `BeanFactory` might be preferred in scenarios where you need more control over bean initialization and want to minimize resource usage.

## 14. What is the Scope of a Bean? and list the examples for each scope.

- Basic
  - **Singleton**: only one instance will be created per spring container(IoC). 
  - **Prototype**: A new instance will be created every time the bean is requested from the spring container
- Web
  - **Request**: definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.
  - **Session**:  definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.
  - **Application**
  - **Websocket**

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)

Use the `<bean>` element and specifying the bean's properties, constructor arguments, and references.

```
<bean id="myBean" class="com.example.MyBean">
    <!-- Configure properties -->
    <property name="name">John</property>
    <property name="age" value="30" />

    <!-- Configure constructor arguments -->
    <constructor-arg value="Some value" />

    <!-- Inject a reference to another bean -->
    <property name="dependencyBean" ref="dependencyBean" />
</bean>

<bean id="dependencyBean" class="com.example.DependencyBean">
    <!-- Configuration for the dependency bean -->
</bean>
```
