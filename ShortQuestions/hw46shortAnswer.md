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

### 10. 
