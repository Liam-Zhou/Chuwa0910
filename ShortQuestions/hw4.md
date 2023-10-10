# Java 8 and Advanced Java Topics

## Questions & Answers

### 1. What is generic in Java?
Generics enable types (classes and interfaces) to be parameters when defining classes, interfaces, and methods. We can create classes, interfaces, and methods that operate on typed parameters. 

### 2. Java 8 Code Practice
Please refer to the [provided GitHub link](https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8) and type the code, one by one. Push the updated code to your branch.

### 3. Stream API Practice
Practice stream API at least 3 times. Refer to this [article](https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82) for exercises.

### 4.  Practice Optional methods at least 2 times
https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

### 5.  Write the Singleton design pattern include eager load and lazy load. 
    Done

### 6.  What is Runtime Exception? could you give me some examples?
    Throw exception during normal operation of JVM, not checked at compile but run time.
    EX:
    int[] arr = new int[5];
    int value = arr[5]; // This will throw an ArrayIndexOutOfBoundsException  


### 7. Could you give me one example of NullPointerException?
    String str = null;
    int length = str.length(); // This will throw a NullPointerException

### 8.  What is the Optional class?
    To avoid Null checks and run time NullPointerExceptions, 


### 9.  What are the advantages of using the Optional class?
    The overall code looks cleaner, increases readability, and avoids NPE more effectively


### 10. What is the @FunctionalInterface?
    The @FunctionalInterface annotation was introduced in Java 8 to indicate that a particular interface is intended to be a functional interface. A functional interface is an interface that contains just one abstract method, and it can have multiple default or static methods. The primary purpose of a functional interface is to be used as a lambda expression or a method reference.

### 11. what is lamda?
    To implement single abstract method for functional interface, use to Replace anonymous inner class

### 12. What is Method Reference?
    Method reference is a shorthand notation of a lambda expression to call a method, increase readability and make it more clear.

### 13. What is Java 8 new features?
    -- Stream API  
    -- Lambda & Functional Interface
    -- Optional

### 14. Lambda can use unchanged variable outside of lambda? what is the details?
    Yes. 
    - Final variable
    - Non-final variable however never changed
    - Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

### 15. Describe the newly added features in Java 8?
    Java 8's emphasis on functional programming concepts and the introduction of lambda expressions and streams marked a significant shift in the Java programming paradigm. This version made it easier for developers to write concise, efficient, and readable code, and also new feature for optional make code clear and readability.


### 16. Can a functional interface extend/inherit another interface?
    Yes it could be, but remind fllow single abstract method rule.


### 17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
    (parameters) -> expression_or_statements
    lambda expression provides the implementation of the abstract method in a functional interface.

### 18. In Java 8, what is Method Reference?
    method reference provides a way to refer directly to an existing method by name, without explicitly invoking it. It acts as a shorthand syntax for a lambda expression that executes just ONE method. Method references can make your code more concise and expressive.


### 19. What does the String::ValueOf expression mean?
    Refers ValueOf method to String. String.valueOf

### 20. What are Intermediate and Terminal operations?
    Intermediate: Intermediate operations are operations that transform a stream into another stream. 
    Terminal operations: produce a non-stream result, makes the stream pipeline execute and consumes the stream; after that, the stream cannot be reused.


### 21. What are the most commonly used Intermediate operations?
    -- filter
    -- map
    -- flatmap
    -- sort

### 22. What is the difference between findFirst() and findAny()?
    findFirst: Returns an Optional describing the first element of the stream.
    findAny: Returns an Optional describing some element of the stream, which may be any element that meets the criteria, not necessarily the first.

### 23. Difference between Collections and Stream?
- **Reusability**: 
  - **Collections**: Can be iterated multiple times.
  - **Streams**: Can be traversed only once. After that, they are consumed and cannot be reused.
  
- **Method Types**:
  - **Collections**: Have methods to add, remove, or modify elements.
  - **Streams**: Have a vast range of method types – intermediate operations (like map and filter) and terminal operations (like collect and reduce).

