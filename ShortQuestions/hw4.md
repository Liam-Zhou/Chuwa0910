### 6. Runtime Exception
RuntimeException is the parent class for all unchecked exceptions. Examples include NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, and ClassCastException.

### 7. NullPointerException Example
java

   String str = null;
   int length = str.length();  
### 8. Optional Class
   The Optional class in Java 8 is a container object which may or may not contain a non-null value. It is used to avoid NullPointerException.

### 9. Advantages of Optional
   Enhances code readability by clearly indicating that a value might be absent.
   Reduces chances of unexpected NullPointerException.
   Provides utility methods to handle scenarios where the actual value might be absent without having to perform explicit null checks.
### 10. @FunctionalInterface
It is an interface which is used to declare an interface as functional interface. It has just one abstract method, and can have multiple default or static methods.

### 11. Lambda
Lambda is a concise way to represent a functional interface using an expression. It's used to write instances of single-method interfaces (functional interfaces) in a much concise and expressive way.

### 12. Method Reference
Method reference is a shorthand notation of a lambda expression to call a method.

### 13. Java 8 New Features
Lambda expressions
Streams
Optional
Default and static methods in interfaces
New Date and Time API
Method references
@FunctionalInterface annotation
New collectors
New CompletableFuture for async programming
### 14. Lambda and Unchanged Variable
Lambda expressions in Java can capture (or "close over") variables from their enclosing scope. However, these variables must be effectively final. An effectively final variable is one whose value does not change after it's assigned.

### 15. Java 8 Newly Added Features
(See answer to question 13)

### 16. Functional Interface Inheritance
Yes, a functional interface can extend another interface, but the catch is that it should not have more than one abstract method in the total inheritance chain.

### 17. Lambda Expression Relation to Functional Interface
A lambda expression provides a concise representation to instantiate a functional interface. A functional interface has just one abstract method, and the lambda expression provides the implementation for that method.

### 18. Method Reference in Java 8
(See answer to question 12)

### 19. String::ValueOf Expression
This is a method reference. It refers to the static valueOf method of the String class.

### 20. Intermediate and Terminal Operations
In the Java 8 Stream API:

Intermediate Operations: Operations that transform a stream into another stream (e.g., filter, map). They're lazy and only execute when a terminal operation is invoked.

Terminal Operations: Operations that produce a result or side-effect (e.g., collect, forEach, reduce).

### 21. Commonly Used Intermediate Operations
map
filter
flatMap
sorted
distinct
### 22. Difference between findFirst() and findAny()
findFirst(): Returns an Optional describing the first element of the Stream.

findAny(): Returns an Optional describing some element of the Stream (useful in parallel streams as it's free to select any element in the stream).

### 23. Collections vs Stream
Collections: They are in-memory data structures that hold elements within it. They are primarily concerned with the efficient management and access of data.

Streams: They don't store elements. They just convey elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.