# HW12 Xiao Yang

### 1. List all of the annotations you learned from class and homework to annotaitons.md

[See Here](./annotations.md)

### 2.  What is Spring and Springboot? What is the benfits of using Springboot?

- Spring and Spring Boot are popular frameworks in the Java ecosystem, primarily used for building Java-based applications. They simplify and streamline the development of Java applications, making it easier to create robust, scalable, and maintainable software.

- Spring Boot offers several advantages over the traditional Spring Framework, here are the key benefits of using Spring Boot over Spring:

  1. **Simplified Configuration:**

     Spring Boot provides a convention-over-configuration approach, reducing the need for extensive configuration. It sets up sensible defaults, which means less boilerplate code and configuration work for developers.

  2. **Preconfigured Starters:**

     Spring Boot comes with a wide range of pre-configured "starters" that provide templates for different types of applications (e.g., web applications, data-driven applications, messaging applications). These starters simplify the setup of common application components.

  3. **Production-Ready Features:**

     Spring Boot includes production-ready features such as health checks, metrics, and monitoring via Spring Boot Actuator. These features are readily available without additional configuration.

  ​

### 3.  What is IOC and What is DI?

**IOC (Inversion of Control)** and **DI (Dependency Injection)** are closely related concepts in software development, particularly in the context of object-oriented programming. They are fundamental principles that promote loose coupling and modularity in your code. 

**Inversion of Control (IoC):**Inversion of Control is a design principle that suggests a shift in the control flow of a program. In traditional software development, the main program or a central component controls the flow of execution, and it's responsible for creating and managing the objects it needs. With IoC, this control is "inverted," meaning that the framework or container takes control of managing the objects and their lifecycle.

IoC typically involves using a framework or container, like the Spring Framework in Java, to manage the components and their dependencies. Instead of the developer explicitly creating and managing objects, the framework takes over these responsibilities. The primary benefits of IoC include:

- **Decoupling:** IoC promotes decoupling of components, making it easier to change or replace components without affecting the rest of the system.
- **Reusability:** Components can be reused in different contexts since they are not tightly coupled to their dependencies.
- **Testability:** It simplifies unit testing, as dependencies can be easily replaced with mock objects for testing purposes.

**Dependency Injection (DI):**Dependency Injection is a specific technique used to implement Inversion of Control. It's a way to provide the necessary dependencies (other objects or services) to a class rather than having the class create its dependencies.

There are three common types of dependency injection:

- **Constructor Injection:** Dependencies are provided through the class's constructor. This is the most common and recommended form of DI, as it ensures that the required dependencies are available when the object is created.
- **Setter Injection:** Dependencies are set through setter methods on the class. While less common than constructor injection, it provides flexibility for changing or updating dependencies after the object is created.
- **Method Injection:** Dependencies are provided through specific methods or interfaces defined by the class. This approach is less common and is usually reserved for specific use cases.

### 4.  What is  @ComponentScan?

**@ComponentScan** is used to specify the base package(s) to scan for Spring-managed components, such as beans, services, controllers, and other Spring-managed objects.

Here's how `@ComponentScan` works and its main purpose:

1. **Component Scanning:** Spring uses component scanning to automatically discover and register Spring-managed components. These components are typically annotated with `@Component` or its specializations like `@Service`, `@Controller`, or `@Repository`.
2. **Base Package(s):** When you apply `@ComponentScan` to a configuration class, you specify one or more base packages as its attributes. Spring will then scan these packages and their subpackages for classes annotated with Spring component annotations.
3. **Auto-Detection:** Spring scans the specified packages and identifies classes that are annotated with component stereotypes (e.g., `@Component`, `@Service`, etc.). It then registers these classes as Spring beans in the application context.

Here's an example of how to use `@ComponentScan` in a Spring configuration class:

```java

@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Other configuration or bean definitions can go here
}

```

In this example, `@ComponentScan` is used to instruct Spring to scan the `com.example.myapp` package and its subpackages for Spring-managed components. Any classes annotated with `@Component`, `@Service`, `@Controller`, or `@Repository` within these packages will be automatically registered as beans in the Spring application context.

Using `@ComponentScan` can significantly reduce the need for manual bean configuration in your Spring application, as Spring can automatically discover and manage these components. It promotes a more flexible and modular architecture, making it easier to add, modify, or replace components without extensive configuration updates.

### 5.  How to define which package spring need to scan in xml and annotaiton? 

**1. XML Configuration:**

In XML-based configuration, you typically use the `<context:component-scan>` element to define the packages to be scanned. Here's an example of how to configure component scanning in an XML configuration file:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Enable component scanning -->
    <context:component-scan base-package="com.example.myapp"/>

    <!-- Other bean definitions can go here -->

</beans>

```

In this XML configuration, the `<context:component-scan>` element specifies the base package to scan for Spring-managed components. You can also specify multiple base packages by separating them with commas.

**2. Annotations:**

In annotation-based configuration, you can use the `@ComponentScan` annotation to specify the base package(s) to scan. This annotation can be placed on a Java configuration class annotated with `@Configuration`. Here's an example:

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Other configuration or bean definitions can go here
}

```

In this example, the `@ComponentScan` annotation specifies that Spring should scan the `com.example.myapp` package for components.

### 6.  What is  @SpringbootApplication?

`@SpringBootApplication` is a special annotation in the Spring Boot framework. It's often used to mark the main class of a Spring Boot application. This annotation combines several other annotations and is a convenient way to enable a variety of features and configurations for your Spring Boot application. It includes the following annotations:

1. `@Configuration`: Indicates that the class has Spring Bean configuration methods. These methods are used to configure and initialize Spring application context.
2. `@EnableAutoConfiguration`: Enables Spring Boot's automatic configuration. It attempts to automatically configure your Spring application based on the JAR dependencies you have added.
3. `@ComponentScan`: Instructs Spring to scan for and register Spring components (e.g., beans, services, controllers) within the package of the main application class and its subpackages.

### 7.  How many ways we can define a bean?

1. **XML Configuration:**

   - You can define beans in an XML configuration file, typically with the `<bean>` element. These XML files are often named something like `applicationContext.xml`. Here's an example:

   ```xml
   <bean id="myBean" class="com.example.MyBeanClass"/>
   ```

2. **Component Scanning in XML:**

   - In XML configuration, you can enable component scanning using `<context:component-scan>`. This will scan for classes annotated with Spring stereotypes and register them as beans.

   ```xml
   <context:component-scan base-package="com.example"/>
   ```

3. **Java Configuration with @Configuration:**

   - You can define beans using Java configuration classes annotated with `@Configuration`. Within these classes, you use `@Bean` methods to define and configure beans. Here's an example:

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public MyBeanClass myBean() {
           return new MyBeanClass();
       }
   }
   ```

4. **Component Scanning with @Component and Related Annotations:**

   - You can define beans by annotating your classes with Spring stereotype annotations like `@Component`, `@Service`, `@Repository`, and `@Controller`. Spring scans for these annotated classes and automatically registers them as beans.

   ```java
   @Component
   public class MyBeanClass {
       // Bean definition
   }
   ```

### 8.  What is default bean name for  @Component and  @Bean?

**@Component Classes:**

- If the `@Component` annotation is used to define a Spring component, the default bean name is generated based on the simple, unqualified class name with the initial letter in lowercase. For example, if you have a class `MyComponentClass`, the default bean name will be `myComponentClass`.

- For `@Component` classes, you can use the `value` or `name` attribute to specify a custom name:

  ```java
  @Component("customComponentName")
  public class MyComponentClass {
      // Bean definition
  }
  ```

  In this case, the bean is named "customComponentName" instead of the default based on the class name.

**@Bean Methods:**

- When you define a bean using the `@Bean` annotation within a `@Configuration` class, the default bean name is generated based on the method name. For instance, if you have a method `myBean()` annotated with `@Bean`, the default bean name will be `myBean`.

It's important to note that these default bean names are case-sensitive. You can use the `name` attribute of the `@Component` or `@Bean` annotation to specify a custom bean name if the default name doesn't suit your needs. Here's an example of customizing the bean name with the `@Bean` annotation:

```java
@Configuration
public class AppConfig {
    @Bean(name = "customBeanName")
    public MyBeanClass myBean() {
        return new MyBeanClass();
    }
}
```

In this example, the bean will be named "customBeanName" instead of the default "myBean."

### 9.  What is the difference between  @component and  @service,@repository?

`@Component`, `@Service`, and `@Repository` are all specializations of the `@Component` annotation, and they are used to define Spring-managed beans. While they are similar in that they all mark a class as a Spring bean, they are often used with the intent of providing additional information about the role or purpose of the bean. The primary difference between them lies in the semantics and intended use cases:

**@Component:**

- The `@Component` annotation is a generic stereotype annotation for any Spring-managed component. It indicates that a class is a Spring bean and should be automatically discovered and registered as a component.
- It doesn't specify a particular role for the class, and it is a general-purpose annotation.
- You can use `@Component` to define any type of bean, such as service, repository, or controller, based on your project's requirements.

**@Service:**

- The `@Service` annotation is a specialization of `@Component` and is typically used to annotate service classes. It indicates that a class represents a service or business logic layer in your application.
- Using `@Service` helps clarify the role and intent of the class and is commonly used for service classes, such as those responsible for implementing business logic or service layer operations.

**@Repository:**

- The `@Repository` annotation is another specialization of `@Component` and is used to annotate classes that interact with databases, such as data access objects (DAOs) or repositories.
- It indicates that a class represents a data repository or a data access component. When using `@Repository`, Spring provides exception translation for database-related exceptions, making it useful for Spring Data access.

### 10.  How many annotaitons we can use to inject the bean?

1. **@Autowired:**

   - The `@Autowired` annotation is a core Spring annotation used for automatic bean injection. It can be applied to fields, constructor parameters, setter methods, and methods with arbitrary names.
   - It is commonly used for dependency injection in Spring-managed components and works well with `@Component`, `@Service`, and `@Repository` classes.

   Example:

   ```java
   @Autowired
   private MyDependency myDependency;
   ```

2. **@Qualifier:**

   - When you have multiple beans of the same type and need to specify which one to inject, you can use the `@Qualifier` annotation in conjunction with `@Autowired`. It specifies the name of the bean to inject.

   Example:

   ```java
   @Autowired
   @Qualifier("specificBean")
   private MyDependency myDependency;
   ```

3. **@Resource:**

   - The `@Resource` annotation is a Java EE standard for bean injection. It can be used to inject beans by name, type, or a combination of both.

   Example:

   ```java
   @Resource(name = "specificBean")
   private MyDependency myDependency;
   ```

4. **@Value:**

   - The `@Value` annotation is used to inject values from property files, environment variables, or other external sources into beans.

   Example:

   ```java
   @Value("${my.property}")
   private String myProperty;
   ```

5. **@Inject:**

   - The `@Inject` annotation is part of the Java Dependency Injection (JSR-330) standard and serves a similar purpose to `@Autowired`. It can be used for field, constructor, or method injection.

   Example:

   ```java
   @Inject
   private MyDependency myDependency;
   ```

6. **@Lazy:**

   - The `@Lazy` annotation can be used with `@Autowired` or `@Value` to specify that the bean should be injected lazily, meaning it's created and initialized only when first accessed.

   Example:

   ```java
   @Autowired
   @Lazy
   private MyDependency myDependency;

   ```

7. **@Primary:**

   - The `@Primary` annotation is used to specify a primary bean when there are multiple beans of the same type. The primary bean is the one that gets injected by default.

   Example:

   ```java
   @Primary
   @Bean
   public MyDependency primaryBean() {
       // Bean definition
   }
   ```

### 11.  Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

- **Constructor Injection**

  ```java
  @Autowired
  private MyBean myBean;
  public Constructor(MyBean myBean){
    this.myBean = myBean;
  }
  ```

  ​

- **Setter Injection**

  ```java
  @Autowired
  private MyBean myBean;
  public void setMyBean(MyBean myBean){
    this.myBean = myBean;
  }
  ```

- **Field Injection**

  ```java
  @Autowired
  private MyBean myBean;
  ```

Using Constructor injection is the best way. Here are the benefits:

1. **Immutability**: Constructor injection allows you to create immutable objects, 

   where the object's state does not change after it is created. Immutable objects 
   are easier to understand and maintain because they do not have unexpected 
   state changes. Field injection cannot provide immutability, as it requires setting 
   dependencies after the object is created.

2. **Explicit Dependencies**: Constructor injection requires all dependencies to be 
  explicitly declared in the constructor. This makes dependencies easier to 
  understand and helps ensure the object always has a valid state when it is 
  created. In contrast, field injection may lead to dependencies being unsatisfied 
  at runtime, as they might be less obvious in the class definition.

3. **Test-Friendliness**: Constructor injection makes it easier to provide alternative 
  implementations (e.g., using test doubles) in unit tests. Simply pass the 
  alternative implementations through the constructor to set up dependencies for 
  a specific test case. In contrast, field injection might require using reflection or 
  other methods to change private fields, which can make test code more complex.

### 12.  If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary.

In Spring, if you have multiple beans of the same type and you want to specify one of them as the primary bean, you can use the @Primary annotation. The @Primary annotation indicates that a particular bean should be considered as the primary candidate for autowiring when multiple beans of the same type exist. 
```java
@Component
@Primary
public class PrimaryBean implements MyInterface {
    // ...
}
```

In this example, the PrimaryBean is marked as the primary candidate. If you have multiple beans of type MyInterface, Spring will prioritize injecting the PrimaryBean when autowiring by type.

If you have multiple beans of the same type, and none of them are marked as primary, Spring will throw an exception during autowiring because it won't know which bean to choose as the primary candidate.

To provide a default bean to be injected when there's no primary candidate, you can use the @Qualifier annotation to specify the bean to be injected by name. 

```java
@Component
public class BeanA implements MyInterface {
    // ...
}

@Component
public class BeanB implements MyInterface {
    // ...
}
```
To specify that BeanA should be injected by default, you can use the @Qualifier annotation with the bean's name:
```java
@Autowired
@Qualifier("beanA")
private MyInterface myBean;
```

### 13.  What is the difference between BeanFactory and ApplicationContext in Spring?

`BeanFactory` and `ApplicationContext` are two important interfaces in the Spring Framework for managing and accessing Spring beans (components). While they both serve the purpose of managing beans and providing dependency injection, they differ in their features and capabilities.

Here are the key differences between BeanFactory and ApplicationContext:

- Container Loading and Initialization:
`BeanFactory` is the simplest and lightest container. It is responsible for loading and initializing beans on-demand. Beans are created when they are first requested.
`ApplicationContext`, on the other hand, eagerly initializes and preloads singleton beans during the container's startup, which makes them available for immediate use. This can improve application startup time but consumes more memory.

- Bean Lifecycle Management:
`BeanFactory` primarily focuses on bean instantiation and wiring. It doesn't provide advanced features like internationalization, event propagation, and application context publishing.
`ApplicationContext` extends BeanFactory and adds support for advanced features and bean lifecycle management, such as event publishing, internationalization (i18n), resource loading, and AOP (Aspect-Oriented Programming).

In practice, ApplicationContext is more commonly used in Spring applications because it provides a richer set of features, including internationalization, event handling, AOP, and resource loading. However, if you have very specific memory constraints and need to minimize resource usage, you may opt for BeanFactory to load beans only when they are explicitly requested.

### 14.  What is the Scope of a Bean?  and list the examples for each scope.
In Spring, the scope of a bean defines the lifecycle and visibility of instances created from that bean definition. Different scopes determine when a new instance is created and when it's reused. 
- Singleton:
Singleton scope creates a single instance of the bean for the entire application context.
This is the default scope if not specified.
Example: A database connection pool, logging service, or a service that should be shared globally.

- Prototype:
Prototype scope creates a new instance of the bean every time it's requested.
This results in a new object for each request, making it stateful.
Example: A shopping cart or a form-backing object in a web application, where each user needs their own instance.

- Request:
Request scope creates a new instance of the bean for each HTTP request in a web application.
The bean is created when an HTTP request is made and destroyed when the request ends.
Example: Storing user-specific data for the duration of an HTTP request.

- Session:
Session scope creates a new instance of the bean for each user session in a web application.
The bean is created when a user session starts and destroyed when the session ends.
Example: Storing user-specific data for the duration of a user's session, like user preferences.

- Global Session (Portlet-specific):
Global Session scope creates a new instance of the bean for each user session but at the application scope in a portlet environment.
Example: Portlet-specific equivalent of the Session scope.

- Application:
Application scope creates a single instance of the bean for the entire lifetime of the web application.
The bean is created when the application starts and destroyed when it shuts down.
Example: Storing application-wide configuration or shared resources.

- WebSocket (Spring 4.0+):
WebSocket scope creates a new instance of the bean for each WebSocket session.
The bean is created when a WebSocket session is established and destroyed when the session is closed.
Example: Managing WebSocket-related state for each connected client.

- Custom Scopes:
Spring allows you to define custom bean scopes to meet specific application requirements. You can implement custom scope handling by implementing the Scope interface and registering it in the Spring application context.

Using @Scope annotation:
```java
@Component
@Scope("singleton")
public class MySingletonBean { /* ... */ }
```

Using scope attribute in XML configuration:
```xml
<bean id="mySingletonBean" class="com.example.MySingletonBean" scope="singleton" />
```


### 15.  Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old,  I am not sure if I need to exaplain it in class)