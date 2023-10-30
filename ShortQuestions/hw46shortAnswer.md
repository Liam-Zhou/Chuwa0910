### 3. Aspect oriented programming
aop is a programming paradigm to increase modularity by separating cross-cutting concerns. 
Cross-cutting concerns are those not central to the business logic of a program but still needs to be implemented. Developers would implement cross-cutting concerns in aspects, classes to define all aop self methods. It's used in logging method calls, security management, exception handling and tracing.

### 4. Advantages and disadvantages of Spring aop.
It allows modularization, making the code more reusable, maintainable, and extensible. It's also non-invasive, meaning that we don't need to change any exisiting code.
The disadvantgaes is that it would overheat the performance load because it needs creating and managing proxies for module classes.

### 5. Aspect 
Aspects are classes that defines all aop self methods. It has two main parts: advice: code that contains the cross-cutting concertn(logging, transaction, security). 

### 6. Pointcut
Expression to find all main application methods to insert the advice. It determines where in the application code the advice should be applied.

### 7. Join point
A join point is a point in execution of a program where an aspect can be plugged in. It's limited to method execution. You can inject additional behavior(via advice) without modifying the already executed code. 

### 8. Different types of advice
Before advice: runs before the join point and cannot prevent the execution flow proceeding to the join point.
After Returning Advice: runs after the join point completes normally, can be configured to have access tot he return value.
After throwing advice: runs if a method exists by throwing an exception.
After(Finally) advice: runs after the join point, regardless of how the join point exits.
Around advice: perform custom behavior both before and after method invocation. Also responsible for choosing whether to procced to the join point.

### 10. Spring batch
Spring batch is a framework used for processing large volumes of data.
We can use it for Data migration, like from one system to another, possibly transforming or processing it along the way. 
Or Data Processing, file processing, data backup.

### 11. How does spring batch work?
Spring Batch consists of several parts;
job: Batch process defined by to complete unit of work.
Step: independent part of a job focuses on a specific task(reading data, processing data, writing data.) 
ItemReader, ItemProcessor, ItemWriter: Provides data to be processed one at a time, provides business logic of each item, and writes the processed data to a specified destination.
And finally we have a JobRepository to store the persisting job status, statistics and step data.

### 12. How to schedule a spring batch job.
Use the @EnableScheduling annotations to enable scheduleing. Then, create a scheduled task using @Scheduled.
You will use the cron expression to schedule the duration of the batch. This will trigger the execution of the Spring Batch job. And then you start running the applications.

### 13. cron expression
cron expression is used to schedule time-based job. It's a 6 field separated by space and contains information about 'seconds', 'minutes', 'hours', 'date'. For example, "0 0 8 ? * MON-FRI" means evey weekday at 8:00.

### 14. Spring task
Spring task provides a way to execute tasks(pieces of code) at specific intervals or at scheduled times. 
It's often used in running background jobs that execute periodically, like database cleanup, sending emails, generating reports.

### 15. How to use spring task.
examples: 
fixed rate scheduling: 
```java
@EnableScheduling
@Component
public class MyScheduledTasks {
  
    @Scheduled(fixedRate = 5000) // 5 seconds
    public void runTask() {
        System.out.println("Task is running at: " + new Date());
    }
}

```
Cron Expression Scheduling:
```java
@EnableScheduling
@Component
public class MyScheduledTasks {

    @Scheduled(cron = "0 0 * * * ?") // every hour
    public void runTask() {
        System.out.println("Task is running at: " + new Date());
    }
}

```

### 16 filters:
Filters are standard part of Java servlets to handle responds to http requests. It's used in cross-cutting concerns such as logging, security, and input validation. Multiple filters can be trained together, each of them can either pass the request and response to the next filter. 
Example: 
```java
@Component
public class MyFilter implements Filter {
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Pre-processing logic
        System.out.println("Before processing the request");

        chain.doFilter(request, response);

        // Post-processing logic
        System.out.println("After processing the request");
    }
}

```
