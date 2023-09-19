## 1.	What is the checked exception and unchecked exception in Java, could you give one example?


Checked Exceptions: These are exceptions that the Java compiler requires you to either catch (handle) or declare (propagate) in your code.
They are usually used for situations where recovery is possible, and you should handle them explicitly. Example :

![sample1](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/bc78118d-0505-45be-a051-9b93ee5eb33e)

Unchecked Exceptions (Runtime Exceptions): These are exceptions that the compiler does not require you to catch or declare. 
They typically indicate programming errors or conditions that are not recoverable. Examples include NullPointerException and ArrayIndexOutOfBoundsException

![sample2](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/00136bc4-57cc-4624-abb2-0480b84001f8)

## 2.	Can there be multiple finally blocks?

Yes, you can have multiple finally blocks in a try-catch-finally construct. They will be executed in the order in which they appear, from top to bottom.

## 3.	When both catch and finally return values, what will be the final result?

If both the catch block and the finally block return values, the value returned by the finally block will take precedence.
The value returned by the catch block will be ignored.
   
## 4.	What is Runtime/unchecked exception? what is Compile/Checked Exception?

Runtime/Unchecked Exception: These are exceptions that are not checked at compile-time but can occur at runtime. 
They typically indicate issues in the code logic or unexpected situations. You do not have to catch or declare them explicitly. 
Examples include NullPointerException, ArithmeticException, and IllegalArgumentException.

Compile/Checked Exception: These are exceptions that the Java compiler requires you to either catch or declare in your code. 
They typically represent external factors or operations that may go wrong and should be handled gracefully.
Examples include IOException, SQLException, and ClassNotFoundException

## 5.	What is the difference between throw and throws?

throw: It is used to explicitly throw an exception in your code. You use the throw keyword followed by an exception object to raise an exception.
For example:

`throw new CustomException("This is a custom exception");`

throws: It is used in the method signature to declare that a method might throw a particular type of exception. 
It doesn't throw the exception itself but informs the caller that the method may throw that exception. For example:

`public void myMethod() throws IOException { // Method code that might throw an IOException }`

## 6. 

* For the first chunk of code, it prints `java.lang.ArithmeticException`

* For the second chunk of code, it prints `java.lang.NullPointerException`

* For the third chunk of code, it prints `java.lang.RuntimeException`
## 7.	What is optional? why do you use it? write an optional example. 

Optional is a class introduced in Java to deal with the problem of null values and the potential for NullPointerExceptions. It represents an optional value that may or may not be present. The primary purpose of using Optional is to make it explicit that a value can be absent and to provide a more structured and safe way of handling such cases.

You use Optional when you want to make it clear in your code that a value might not always be available and to encourage developers to handle the absence of that value gracefully, rather than relying on null checks.

Here's a simple example of how Optional can be used:

![sample3](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/567cd323-4595-4eb0-9b35-75da4998c53d)

In this example, we create an Optional with a value and another empty Optional. We then check if the optional has a value using isPresent() and retrieve the value using get(). If the optional is empty, we use orElse() to provide a default value.

## 8.	Why finally always be executed ?

The finally block in Java is used to define code that should be executed regardless of whether an exception occurred or not in the preceding try and catch blocks. It ensures that certain cleanup or finalization tasks are performed before control is passed out of the method, even if an exception is thrown.

There are several reasons for the finally block to always be executed:

* Exception Handling: If an exception occurs in the try block, the associated catch block may handle it, but the finally block will still execute, allowing you to clean up resources or perform necessary actions.

* Normal Flow: If no exception occurs, the finally block is still executed as part of the normal control flow after the try block.

* Uncaught Exceptions: If an exception occurs in the try block but is not caught by any catch block in the same method, the finally block still executes before the uncaught exception propagates up the call stack.

The primary purpose of the finally block is to ensure that essential cleanup or finalization tasks are performed, making it a crucial part of reliable exception handling and resource management in Java.

## 10. What is Java 8 new features ?

Java 8 introduced several significant features and enhancements, including:

* Lambda Expressions: Lambda expressions allow you to define and use small, inline functions, making it easier to work with functional programming constructs.
* Stream API: The Stream API provides a powerful way to work with sequences of elements, enabling operations like map, filter, and reduce on collections.
* Default Methods: Interfaces can have method implementations, reducing the need for abstract classes and making it easier to add methods to existing interfaces without breaking implementations.
* Method References: Method references provide a shorthand notation for calling methods, making code more concise and readable.
* Functional Interfaces: Functional interfaces are interfaces with a single abstract method, and they play a crucial role in lambda expressions and method references.
* New Date and Time API: The java.time package introduced a modern, comprehensive date and time API, addressing the shortcomings of the old java.util.Date and java.util.Calendar classes.
* Optional: The Optional class provides a way to handle the absence of a value more elegantly than using null.
* Nashorn JavaScript Engine: Java 8 included a new JavaScript engine called Nashorn, providing better performance for JavaScript execution in Java applications.
## 11. What are the types of design patterns in Java ?

Types of Design Patterns in Java:
There are several types of design patterns in Java, including:

* Creational Patterns: These patterns deal with object creation mechanisms. Examples include Singleton, Factory, Abstract Factory, Builder, and Prototype patterns.
* Structural Patterns: These patterns focus on the composition of classes or objects. Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy patterns.
* Behavioral Patterns: These patterns define how objects interact and communicate with each other. Examples include Observer, Strategy, Chain of Responsibility, Command, and State patterns.
* Concurrency Patterns: These patterns address multithreading and concurrent programming. Examples include Singleton, Immutable, and Double-Checked Locking patterns.

## 12. What are the SOLID Principles ?

SOLID is an acronym representing five design principles that help in creating maintainable and scalable software. They are:

* Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have only one responsibility.
Open-Closed Principle (OCP): Software entities (classes, modules, functions) should be open for extension but closed for modification.
* Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types without affecting the correctness of the program.
* Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. Keep interfaces small and focused.
* Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.
## 13. How can you achieve thread-safe singleton patterns in Java ?

There are various ways to achieve thread safety for a Singleton pattern in Java. One common approach is to use the "Double-Checked Locking" idiom in conjunction with the volatile keyword to ensure safe publication of the singleton instance. Here's an example:

![sample4](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/2253574a-361f-41cf-853c-e3c66a45e5f1)

## 14. What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle is one of the SOLID principles of object-oriented design. It states that software entities (classes, modules, functions) should be open for extension but closed for modification. In other words, you should be able to extend the behavior of a module without changing its source code.

The key idea behind the OCP is to promote a design that allows you to add new features or functionality by creating new classes or modules that inherit from or compose with existing ones, rather than modifying existing code. This helps maintain the stability of existing code and reduces the risk of introducing bugs when extending the system.

Achieving the OCP often involves the use of interfaces, abstract classes, and inheritance, allowing you to create new implementations or subclasses to introduce new behavior while keeping the existing code untouched. The use of polymorphism is a common technique to adhere to the OCP.

## 15.

The correct answer is:

`It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute the object of type A.`

Liskov's Substitution Principle (LSP) is one of the five SOLID principles of object-oriented programming. It states that objects of a derived class (subtype) must be substitutable for objects of the base class (supertype) without affecting the correctness of the program. In other words, if class B is a subtype of class A, then you should be able to replace an object of class A with an object of class B without changing the desired behavior of the program. This implies that class B should have the same interface (methods and properties) as class A and should adhere to the same contracts and invariants, ensuring that the substitution is safe and doesn't lead to unexpected behavior.
