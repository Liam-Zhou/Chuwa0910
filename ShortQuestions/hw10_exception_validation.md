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
