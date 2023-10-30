###### 3.  What is the Aspect Oriented Programming?
A programming technique that supports the separation of cross-cutting concerns in order to increase modularity. 

###### 4.  What are the advantages and disadvantages of Spring AOP?
Advantages of Spring AOP:

    It is easy to configure.
    Spring AOP is implemented in pure Java, so separate compilation unit or separate class loader are not required.
    It utilizes Spring's IOC container for dependency injection.
    Can create aspects using @AspectJ annotation based or using XML based.
    It integrates cross-cutting concerns into the classes,.

Disadvantages of Spring AOP:

    Debugging the AOP framework-based application code is a little challenge.
    Only methods with a public visibility will be recommended, not those with a private, protected, or default visibility.
    Aspects cannot be advised by other aspects. This is because once a class is marked as an aspect (using XML or annotation), Spring prevents it from being auto-proxied.


###### 5.  What is Aspect in Spring AOP?
A cross-cutting module that combines advice and pointcuts. A standard class tagged with the @Aspect annotation can be used to implement an aspect. 

###### 6.  What is Pointcut in Spring AOP?
An expression that chooses one or more join points at which advice is given. Pointcuts can be defined using expressions or patterns. It supports a number of expressions that correspond to the join points.

###### 7. What is the Join point in Spring AOP?
A place in the application where an AOP aspect is applied. It could also be a specific advice execution instance. A join point in AOP can be a method execution, exception handling, changing the value of an object variable, and so on. 

###### 8.  What does it mean by Advice and its types in Spring AOP?
The advice is an action which we take before or after the method execution. In the Spring AOP framework, there are five types of advice: before, after, after-returning, after-throwing, and around advice. Advice is taken at a specific join point.

###### 10. When to use Spring Batch?
Batch processing includes typical tasks like reading and writing to files, transforming data, reading from or writing to databases, create reports, import and export data and things like that. Often these steps have to be chained together or you have to create more complex workflows where you have to define which job steps can be run in parallel or have to be run sequentially etc.

###### 11. How Spring Batch works?
Spring Batch operates by breaking down batch processing into manageable steps, reading data with ItemReaders, applying transformations with ItemProcessors, and writing output using ItemStreamWriters. This framework is designed to handle large-scale batch jobs efficiently and can be used for a variety of data processing tasks.

###### 12. How can we schedule a Spring Batch Job?
Spring Batch can be scheduled using Cron Job.
Use Spring's scheduling mechanisms like @Scheduled annotation or Spring Task Scheduler. Configure a method to launch the job periodically based on a schedule (e.g., using a cron expression). When the scheduled task runs, it triggers the Spring Batch job, automating batch processing according to the specified schedule.

###### 13. What is the cron expression?
A cron expression is a format used to specify the schedule for recurring tasks in software. It consists of five fields (minute, hour, day of the month, month, day of the week) and allows you to define when a task should run.

###### 14. What is the spring task?
Spring Task refers to the task scheduling framework provided by the Spring Framework. It allows you to schedule and automate the execution of methods or tasks at specified intervals within a Spring application using features like the @Scheduled annotation, TaskScheduler, and @EnableScheduling. This is useful for automating recurring tasks and background processing.

###### 15. When to use Spring task? 
Use Spring Task (task scheduling in Spring) when you need to automate and schedule tasks or jobs in your application. It's suitable for recurring tasks, background processing, batch jobs, maintenance, timed execution, event-based processing, managing dependencies, resource cleanup, and dynamic scheduling.

###### 16. What is Filter and any filter example?
A filter in web development is a component that intercepts and processes HTTP requests and responses. It's used for tasks like logging, authentication, and input validation. Here's a simple Java filter example that performs pre-processing and post-processing on requests and responses.
```
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class RequestLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Pre-processing: Log the incoming request
        String ipAddress = request.getRemoteAddr();
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        System.out.println("Request received from IP: " + ipAddress + ", URL: " + url);

        // Continue the request/response chain
        chain.doFilter(request, response);

        // Post-processing (if needed)
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}

```

###### 17. What is the Interceptor? What we can do with interceptor?
An interceptor is a component in web development that allows you to intercept and perform tasks like logging, authentication, authorization, request/response modification, error handling, caching, validation, auditing, and more for HTTP requests and responses. 

###### 18. In Interceptor, What is preHandle? What is postHandle?
preHandle is used for tasks that need to be performed before the controller method is executed, such as security checks, while postHandle is used for tasks that need to be performed after the controller method is executed but before the response is generated, such as adding data to the model. 

###### 19. What is Swagger?
Swagger is an open-source framework for designing, documenting, and testing RESTful APIs. It provides tools like interactive documentation, code generation, and API testing, making API development more efficient and accessible.