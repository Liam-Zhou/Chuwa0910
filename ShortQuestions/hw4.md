# HW4. Xiao Yang
### 1.  Read those codes and type it one by one by yourself. the push the code to your branch

### 2. Write the Singleton design pattern include eager load and lazy load
[See Here](../MavenProject/src/main/java/patterns/singleton)

### 3. What is Runtime Exception? could you give me some example
Runtime Exceptions are typically not checked at compile time but rather are encountered at runtime when a program is actually running.
For example, the most frequently occurred is `NullPointerException`.
### 4. Could you give me one example of NullPointerException?

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String text = null;
        int length = text.length(); // This will throw NullPointerException
    }
}
```
### 5. What is the Optional class?
Optional class is a container class introduced as a new feature in Java 8, it helps to reduce common `NullPointerException`, 
without the explicit null check in codes. 
### 6. What are the advantages of using the Optional class?
- **Reduced Risk of NullPointerExceptions**: One of the primary advantages of Optional is that it helps reduce the likelihood of encountering NullPointerExceptions. By using Optional, you explicitly indicate whether a value is present or absent, avoiding the need for manual null checks.

- **Improved Code Clarity**: Optional makes your code more self-explanatory and expressive. When you see an Optional type in a method's return type or parameter list, it signals that the value can be absent, making the contract between methods and clients clearer.

- **Elimination of Null Values**: Optional encourages developers to eliminate the use of null values as a means of representing the absence of a value. This can lead to more predictable and safer code.

- **Functional Programming Support**: Optional provides functional-style methods for transforming, filtering, and working with values. This can lead to more concise and readable code when combined with lambda expressions and functional programming techniques.

- **Avoiding Deep Null Checks**: When working with nested objects or properties, Optional can help you avoid writing multiple nested null checks (e.g., if (obj != null && obj.getNested() != null && obj.getNested().getValue() != null)). Instead, you can chain Optional operations.
### 7. What is the @FunctionalInterface?
In Java, the `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a functional interface. A functional interface is an interface that has exactly one abstract method.
### 8. What is lambda?
In Java, lambda expression is a feature introduced in Java 8 that allows you to write concise, inline implementations of functional interfaces.
Lambdas enable you to express instances of single-method interfaces (functional interfaces) using a more compact syntax.
### 9. What is Method Reference?
In Java, a method reference is a shorthand notation that allows you to reference a method as if it were a lambda expression. 
Method references are often used in situations where a lambda expression would simply call a method with the same arguments and return type as the lambda.
### 10. What is Java 8 new features?
- **Lambda Expressions**: Lambda expressions allow you to write more concise and expressive code for working with functional interfaces (interfaces with a single abstract method). They enable you to treat functions as first-class citizens and are particularly useful when working with collections and streams.

- **Functional Interfaces**: Java 8 introduced the @FunctionalInterface annotation, which is used to declare that an interface is intended to be a functional interface. Functional interfaces are interfaces with a single abstract method and are designed for use with lambda expressions.

- **Method References**: Method references provide a shorthand notation for referring to methods as lambdas. They are useful when you want to pass a method as an argument to a higher-order function or use an existing method as a lambda expression.

- **Default Methods**: Java 8 introduced the concept of default methods in interfaces. These are methods that have a default implementation in the interface itself. Default methods enable you to add new methods to existing interfaces without breaking compatibility with classes that implement those interfaces.

- **Static Methods in Interfaces**: In addition to default methods, Java 8 allows interfaces to have static methods. These methods are associated with the interface itself and can be called without creating an instance of the interface.

- **Streams API**: The Stream API provides a powerful and expressive way to process sequences of data in a functional style. It allows you to perform operations like mapping, filtering, and reducing on collections in a more concise and readable manner.


### 11. Lambda can use unchanged variable outside of lambda? what is the details?

The variables should be declared as `final` or effectively behave as if they were `final`.
1. Effectively Final Variables: Lambda expressions can capture and use local variables that are effectively final. An effectively final variable is one that, once assigned a value, is not modified anywhere else in the code. You don't need to explicitly declare these variables as final, but they should meet the criteria of not being reassigned.
2. Access to Enclosing Scope: Lambda expressions can access variables from the enclosing scope, including method parameters, instance variables, and static variables.
3. No Reassignment: If you attempt to modify a captured variable inside a lambda expression, you will get a compilation error. Lambda expressions can read the value of captured variables, but they cannot modify them.

### 12. Describe the newly added features in Java
[see question 10](#10-what-is-java-8-new-features)
### 13. Can a functional interface extend/inherit another interface?
Yes, a functional interface in Java can extend or inherit another interface as long as it meet all requirements below:
Single Abstract Method (SAM) Requirement: A functional interface must have exactly one abstract method. If you extend another interface that already has one or more abstract methods, your interface will no longer be considered a functional interface unless you override and provide a concrete implementation for all but one of those abstract methods.
Default Methods: It's perfectly valid for a functional interface to extend an interface that contains default methods. Default methods provide concrete implementations and do not affect the "single abstract method" requirement.
### 14. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
[see question 8 & 9](#8-what-is-lambda)
### 15. What does the String::ValueOf expression mean?
It means a call of Method Reference. In other words, to return a value of String.ValueOf().
### 16. What are Intermediate and Terminal operation?
The intermediate and Terminal operations often refer to the processes in Stream API. 
- **Intermediate Operations**:
Intermediate operations are operations that are performed on a stream before a terminal operation is called. These operations transform a stream into another stream, allowing you to perform various data processing tasks in a pipeline. Intermediate operations are generally lazy, meaning they do not execute immediately but rather set up a sequence of transformations that will be applied when a terminal operation is invoked.

- **Terminal operations**:
Terminal operations are operations that trigger the processing of the stream and produce a result or a side effect. Once a terminal operation is invoked on a stream, no further intermediate operations can be applied to that stream. Terminal operations are eager, meaning they execute immediately when called.
### 17. What are the most commonly used Intermediate operation?
Common intermediate operations include:

`filter(Predicate<T> predicate)`: Filters the stream based on a given predicate, retaining only elements that satisfy the condition.

`map(Function<T, R> mapper)`: Transforms each element in the stream into another element using the provided mapping function.

`flatMap(Function<T, Stream<R>> mapper)`: Transforms each element in the stream into a stream of elements and then flattens the resulting streams into a single stream.

`distinct()`: Removes duplicate elements from the stream.

`sorted()`: Sorts the elements in the stream.

`limit(long maxSize)`: Truncates the stream to a specified maximum size.

`skip(long n)`: Skips the first n elements of the stream.

Intermediate operations can be chained together to create a pipeline of transformations.
### 18. What is the difference between findFirst() and findAny()?
findFirst() used to return the first element meet the rules, while the return element of findAny() is disordered. 
### 19. How are Collections different from Stream?
`Collections` is more likely to used as a storage, it supports many data structures, such as List, Map, and Set. 
While `Stream` is a set of API used to process data. There is no data storage functions in `Stream`, but it supports functional programming for users to customize their own ways of processing data. 