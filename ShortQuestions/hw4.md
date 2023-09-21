### 1. What is generic in Java?  and type the generic code by yourself.
> - A generic type is a generic class or interface that is parameterized over types.
```
```
### 6. What is Runtime Exception? could you give me some examples?
> - Unchecked exceptions that are happened during running time, such as NPE
### 7. Could you give me one example of NullPointerException?
```
String str = null;
str.length();
```
### 8.  What is the Optional class?
> - A class that used to prevent the NPE, could hanlde the NPE by custome way.
### 9.  What are the advantages of using the Optional class?
> - Doesn't need to do the check for the NPE, able to process the data as you like when the corresponding data is empty or null.
### 10. What is the @FunctionalInterface?
> - Annotation that state an interface that have only one abstract method, no more no less, enable the sanity check.
### 11. what is lamda?
> - A kind of way to replace anonymous inner class(SAM only) 
### 12. What is Method Reference?
> - A way to use the corresponding method without calling it.
### 13. What is Java 8 new features?
> - Default method and static method in interface
> - Lambda & Functional Interface
> - Method Reference
> - Optional
> - Stream API
> - CompletableFuture
### 14. Lambda can use unchanged variable outside of lambda? what is the details?
> - Any final variables or any variables that doesn't change the address once they been inited 
### 15. Describe the newly added features in Java 8?
> - Default method and static method in interface: Allow methods in interfaces with default implementations and static methods.
> - Lambda & Functional Interface: Lambdas are concise functions for functional interfaces.
> - Method Reference: Short syntax for invoking methods.
> - Optional: Safely handles nullable values.
> - Stream API: Functional data processing for collections.
> - CompletableFuture: Enables asynchronous programming.
### 16. Can a functional interface extend/inherit another interface?
> - Yep but it shuold be the SAM only.
### 17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
> - Can use lambda expression to pass actions or parameters, can replace the functional interface while using.
### 18. In Java 8, what is Method Reference?
> - A way to use the corresponding method without calling it.
### 19. What does the String::ValueOf expression mean?
> - The method ValueOf in the String class, just the method, not call it.
### 20. What are Intermediate and Terminal operations?
> - Operations that transform a stream into a new one.
### 21. What are the most commonly used Intermediate operations?
> - filter(), distinct(), limit(), skip(), peek(), sorted(), map()
### 22. What is the difference between findFirst() and findAny()?
> - findFirst() would return the first element in the stream.
> - findAny() would return any of the elements in the stream.
### 23. How are Collections different from Stream?
> - Collections do store data but stream don't.
> - Collection is external interation while the stream is internal
> - Collection can be processd any number of times while stream only once 
> - Collection can acess any data easily, while stream can't access to data directly
