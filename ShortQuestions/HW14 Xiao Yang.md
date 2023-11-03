# HW14 Xiao Yang
### 1.  List all of the annotations you learned from class and homework to annotaitons.md
[annotations.md](./annotations.md)

### 2.  Briefly reading: https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions

### 3.  What is the Aspect Oriented Programming?
Aspect-oriented programming (AOP) is a programming technique that supports the separation of cross-cutting concerns in order to increase modularity.

### 4.  What are the advantages and disadvantages of Spring AOP?
Advantages of Spring AOP

- It is easy to configure.
- Spring AOP is implemented in pure Java, so separate compilation unit or separate class loader are not required.
- It utilizes Spring's IOC container for dependency injection.
- Can create aspects using @Aspect annotation based or using XML based.
- It integrates cross-cutting concerns into the classes.

Disadvantages of Spring AOP

- Debugging the AOP framework-based application code is a little challenge.
- Only methods with a public visibility will be recommended, not those with a private, protected, or default visibility.
- Aspects cannot be advised by other aspects. This is because once a class is marked as an aspect (using XML or annotation), Spring prevents it from being auto-proxied.

### 5.  What is Aspect in Spring AOP?
An aspect is a Java class that defines one or more pieces of advice and one or more pointcuts. Advice is the action to be taken, and a pointcut specifies where in the application's execution to apply the advice.

### 6.  What is Pointcut in Spring AOP?
 A pointcut is an expression that specifies where advice should be applied in the application. It defines a set of join points. A join point is a specific point in the execution of a program, like the execution of a method or the handling of an exception.

### 7. What is the Join point in Spring AOP?
A join point is a specific point in the execution of a program where an aspect's advice can be applied. 
### 8.  What does it mean by Advice and its types in Spring AOP?
An advice is the code that you want to run at a specific join point in your application. Advice is associated with aspects and is the core behavior encapsulated by the aspect.

### 9.  Reading: https://www.javainuse.com/spring/sprbatch_interview

### 10. When to use Spring Batch?
Spring Batch is a versatile framework designed for batch processing and is particularly useful in scenarios where you need to process large volumes of data efficiently and reliably. 
### 11. How Spring Batch works?
Spring Batch works by providing a structured and efficient way to process large volumes of data in a batch-oriented manner. It does so through a set of well-defined components, configuration, and principles. 

- Job Configuration: Spring Batch begins with the configuration of a batch job. You define a job that consists of one or more steps. Each step defines a chunk-oriented processing unit.

- Step Configuration: Within each step, you configure the following components:
ItemReader: Specifies how data is read from the source (e.g., a file, database, or web service).

- ItemProcessor: Defines the logic to transform and process the read data.
- ItemWriter: Specifies how the processed data is written to a target destination (e.g., a database or file).
- Optional listeners: You can add listeners to handle events before and after step execution.
- Job Completion and Status: After the job execution is complete, Spring Batch provides information about the job's status, including whether it was successful, failed, or stopped.

### 12. How can we schedule a Spring Batch Job?
- Using Spring's @Scheduled Annotation:
You can use Spring's @Scheduled annotation in conjunction with the @EnableScheduling annotation to schedule batch jobs as part of a Spring Boot application.
Here's an example:
```java
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(cron = "0 0 2 * * ?") // Execute at 2 AM daily
    public void scheduleJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}
```
- Using Spring's TaskScheduler:

You can use Spring's TaskScheduler to schedule batch jobs programmatically. This approach allows for more flexibility in scheduling.
```java
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Component;

@Component
public class BatchJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private TaskScheduler taskScheduler;

    public void scheduleJob() {
        Trigger trigger = new DailyTrigger("2:00"); // Define your custom trigger

        taskScheduler.schedule(() -> {
            try {
                JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

                jobLauncher.run(job, jobParameters);
            } catch (Exception e) {
                // Handle exceptions
            }
        }, trigger);
    }
}
```


### 13. What is the cron expression?
A cron expression is a string representing a schedule that determines when a task or job should be executed. A cron expression consists of five or six fields, each specifying a time unit or a set of values. The fields, from left to right, represent:

Seconds (Optional): The seconds field specifies the seconds when the task should be executed. Valid values are from 0 to 59. This field is optional and is often omitted.

Minutes: The minutes field specifies the minutes when the task should be executed. Valid values are from 0 to 59.

Hours: The hours field specifies the hours when the task should be executed. Valid values are from 0 to 23.

Day of Month: This field specifies the day of the month when the task should be executed. Valid values are typically from 1 to 31.

Month: The month field specifies the month when the task should be executed. Valid values are from 1 to 12 or can be represented using three-letter abbreviations (e.g., "JAN" for January).

Day of Week: This field specifies the day of the week when the task should be executed. Valid values are from 0 (Sunday) to 6 (Saturday) or can be represented using three-letter abbreviations (e.g., "SUN" for Sunday). Both 0 and 7 are considered Sunday.

A cron expression allows you to specify a combination of values and wildcards to create flexible schedules. For example, the asterisk (*) is often used as a wildcard to match all possible values for a field. Here are some examples of cron expressions:
### 14. What is the spring task?
- Spring Task Execution through TaskScheduler:
Spring offers the TaskScheduler interface, which is used for scheduling tasks to run at specified intervals or times. The default implementation of this interface is ThreadPoolTaskScheduler.
You can configure a TaskScheduler bean in your Spring application context and use it to schedule tasks using annotations like @Scheduled or programmatically.
Here's an example of scheduling a task using the @Scheduled annotation:
```java
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void myTask() {
        // Your task logic here
    }
}
```

- Spring Batch for Batch Processing:
Spring Batch, as mentioned earlier, provides a framework for batch processing and is often used for scheduling and executing batch jobs.
Spring Batch allows you to define and configure batch jobs, steps, and job execution schedules. You can trigger these jobs using schedulers like @Scheduled or external schedulers like Quartz.
### 15. When to use Spring task? 
Use Spring Task when you need to schedule and automate recurring tasks or batch jobs. For example, you can schedule data cleanup, report generation, or system maintenance tasks to run at specific times or intervals.
### 16. What is Filter and any filter example?
In Spring Boot, a filter is a component that can be used to intercept and manipulate HTTP requests and responses as they flow through the application. Filters are a part of the Java Servlet API and are commonly used for tasks such as request logging, authentication, authorization, request modification, and response transformation. In a Spring Boot application, you can create custom filters to perform these tasks.

To create a custom filter in Spring Boot, you typically need to implement the javax.servlet.Filter interface and override the doFilter method. Here's a basic example of a custom filter in a Spring Boot application:

Create a Java class for your custom filter by implementing the Filter interface. For example:
```java
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyCustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code (if needed)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // This is where you can intercept and manipulate the request or response
        // For example, you can log information or modify the request or response

        // Proceed with the request-response chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code (if needed)
    }
}
```

### 17.  What is the Interceptor? What we can do with interceptor?
In Spring, an interceptor is a component that can intercept and process HTTP requests and responses before they reach the controller or after they leave the controller but before rendering the view. Interceptors are commonly used in web applications to perform cross-cutting concerns such as logging, authentication, authorization, request/response modification, and more.
### 18. In Interceptor, What is preHandle? What is postHandle?
In Spring Interceptors, the `preHandle` and `postHandle` methods are callback methods that allow you to perform actions before and after the execution of a controller method. These methods are invoked at specific points during the request processing lifecycle:

- preHandle Method:
The preHandle method is invoked before the controller method is executed.
It allows you to perform pre-processing tasks and can influence the flow of the request. You can use this method for tasks such as request validation, authentication, or checking preconditions.
The preHandle method is called with the HttpServletRequest, HttpServletResponse, and the handler (the controller method) as parameters.
You can return true to continue the request processing or false to stop further processing of the request.
```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // Pre-processing logic
    // Return true to continue request processing, or false to stop
    return true;
}
```

- postHandle Method:

The postHandle method is invoked after the controller method has been executed but before the view is rendered.
It allows you to perform post-processing tasks on the model and view. You can modify the model or add attributes to the view.
The postHandle method is called with the HttpServletRequest, HttpServletResponse, the handler, and the ModelAndView (the view that will be rendered) as parameters.
You can modify the model and view, or you can perform tasks such as logging.
```java
@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    // Post-processing logic, such as modifying the model or view
}
```
### 19. What is Swagger?
Swagger is an open-source framework for designing, building, documenting, and consuming RESTful web services. It provides a set of tools and specifications that allow developers to create, document, and test APIs quickly and efficiently.