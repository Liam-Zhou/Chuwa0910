# Homework 42 - Exception & Validation

## 1. List all of the annotations you learned from class and homework to annotaitons.md

## 2. what is the @configuration and @bean?

- @Configuration: a class-level annotation declaring a class as the source for bean definitions
- @Bean: is used to indicate that a method instantiates, configures, and initializes a new object to be managed by the Spring IoC container.

## 3. How do you handle the exception in Spring?

- Using `@ExceptionHandler` in Controllers
  - Method Level
  - used to handle the specific exceptions and sending the custom responses to the client
- Global Exception Handling with `@ControllerAdvice`
  - Class Level
  - make this class be a bean

## 4. How do you do the validations in Spring? And list some validation annotaitons you know.

- import dependecy `spring-boot-starter-validation`
- Add validation Rule to payload
- Add `@Valid` to controller to apply the Rule to `@RequestBody`

Some validation annotations:

- Check Nah
  - `@NotEmpty(message = "")`
  - `@NotNull`
  - `@NotBlank`
- Check Size
  - `@Size(min, max)`
  - `@Min(value)`
  - `@Max(value)`
- Check Format
- `@Pattern(regexp)`
- `@Email`
- `@DecimalMin(value)`
- `@DecimalMax(value)`

## 5. What is the actuator?

It's a tool for monitoring the spring application. The dependency is `spring-boot-starter-actuator`. Spring Boot Actuator includes several built-in endpoints that expose information about your application. Some of the commonly used endpoints include:

- `/actuator/health`: Provides information about the application's health. You can configure custom health checks to monitor various aspects of your application.

- `/actuator/info`: Allows you to expose arbitrary application information. You can use this endpoint to provide details about your application's version, description, or any other custom information.

- `/actuator/metrics`: Exposes a wide range of metrics about your application, such as memory usage, garbage collection stats, and request-response times. You can also create custom metrics.

- `/actuator/env`: Provides information about application properties, including configuration properties from application.properties or application.yml.

- `/actuator/loggers`: Allows you to view and configure logging levels for various loggers in your application.

- `/actuator/mappings`: Provides a list of all the Spring MVC controller mappings in your application.

- `/actuator/auditevents`: Exposes information about authentication and authorization events in your application.

- `/actuator/threaddump`: Dumps information about the threads in your application, which can be useful for diagnosing thread-related issues.

## 6. watch those videos(泛泛地看一遍，能理解多少是多少。没有必要看其它视频)

a. Spring 简介: https://www.youtube.com/watch?v=l0MqsOADAUE&list= PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmO n9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
c. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list= PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
d. Bean:
i. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
iii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
e. DI:
i. https://www.youtube.com/watch?v=MgTpBST9onM&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLm On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71
