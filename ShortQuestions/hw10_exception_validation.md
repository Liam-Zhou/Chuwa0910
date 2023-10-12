### What is the @configuration and @bean?

@Configuration

The @Configuration annotation is used to mark a class as a configuration class. A configuration class is a class that contains bean definitions. 
Bean definitions are used to create and configure the objects that are used by the Spring Boot application.

@Bean

The @Bean annotation is used to mark a method as a bean definition. A bean definition is a blueprint for creating an object. 
The @Bean annotation specifies the type of object that should be created, the scope of the object, and any dependencies that the object has.

### How do you handle the exception in Spring?

There are two main ways to handle exceptions in Spring:

* Try-catch blocks: This is the traditional way to handle exceptions in Java. You would surround the code that could throw an exception with a try-catch block. If an exception is thrown, the catch block will be executed.

* @ExceptionHandler annotation: This is a Spring annotation that allows you to handle exceptions at the method or class level. To use the @ExceptionHandler annotation, you would annotate a method with the @ExceptionHandler 
annotation and specify the type of exception that you want to handle. If an exception of that type is thrown, the method will be executed.

Here is an example of how to handle an exception using a try-catch block:

```Java
try {
    // Code that could throw an exception
} catch (Exception e) {
    // Handle the exception
}
```

Here is an example of how to handle an exception using the @ExceptionHandler annotation:

```Java
@ExceptionHandler(Exception.class)
public void handleException(Exception e) {
    // Handle the exception
}
```
In addition to the two methods above, there are other ways to handle exceptions in Spring. 
For example, you can use the Spring AOP framework to intercept exceptions and handle them in a centralized way.

### How do you do the validations in Spring? And list some validation annotaitons you know


There are two main ways to do validations in Spring:

Bean validation: This is a JSR-303 standard that provides a set of annotations for validating Java beans. To use bean validation, you would annotate your bean properties with the appropriate validation annotations. Spring Boot will automatically validate your beans when they are created.

Method validation: This is a Spring-specific feature that allows you to validate the arguments to a method. To use method validation, you would annotate the method parameters with the appropriate validation annotations. Spring Boot will automatically validate the method arguments before the method is executed.

Here is an example of how to use bean validation:

```JAVA
public class User {

    @NotNull
    private String name;

    @Min(18)
    private int age;

    // getters and setters
}
```

Here is an example of how to use method validation:

```JAVA
@Controller
public class MyController {

    @PostMapping("/users")
    public String createUser(@Valid User user) {
        // Save the user object to the database
        return "redirect:/users";
    }
}
```

### What is the actuator?

Actuator is a Spring Boot feature that provides a set of endpoints for monitoring and managing your application. You can use Actuator to get information about your application's health, metrics, and environment. You can also use Actuator to perform actions on your application, such as restarting it or dumping its thread stack.

Actuator is enabled by default in Spring Boot applications. You can access the Actuator endpoints at the following URL:

```http://localhost:8080/actuator```
