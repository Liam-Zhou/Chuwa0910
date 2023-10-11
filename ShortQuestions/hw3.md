### 2. What is the checked exception and unchecked exception in Java, could you give one example?
* Checked Exception: These are exceptions that the compiler checks at compile-time, and the code must handle them, or declare them using the throws keyword. One common example of a checked exception is IOException.

* Unchecked Exception: These are exceptions that the compiler does not check at compile-time. They are usually under RuntimeException and its subclasses. One common example of an unchecked exception is NullPointerException.

### 3. Can there be multiple finally blocks?
No, there cannot be multiple finally blocks associated with a single try block. However, you can have nested try-catch-finally blocks.

### 4. When both catch and finally return values, what will be the final result?
If both catch and finally blocks have return statements, the value from the finally block will be returned, and the value from the catch block will be ignored.

### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
* Runtime/Unchecked Exception: These exceptions are not checked at compile-time but at runtime. They extend RuntimeException. Example: ArithmeticException.
* Compile/Checked Exception: These exceptions are checked at compile-time. They do not extend RuntimeException. Example: FileNotFoundException.

### 6. What is the difference between throw and throws?
* throw: It is used to explicitly throw an exception from a method or any block of code.
* throws: It is used to declare exceptions that a particular method might throw, allowing the caller of the method to handle or propagate them.

### 7. What is optional? why do you use it?
Optional is a container object used to contain not-null objects. 
It provides a clear and explicit way to deal with cases that might involve null values without having to use null checks. It offers methods to handle scenarios where data might or might not exist in a more functional and fluent way.

### 8. Why finally always be executed?
The finally block is always executed to ensure that resources are properly cleaned up, regardless of whether an exception was thrown in the try block or not. This provides a mechanism to guarantee that certain actions (like closing a file or a network connection) are performed no matter what.

### 10. What is Java 8 new features?
Java 8 introduced several new features, some of them are:
Lambda Expressions
Stream API
Optional Class
Default and Static Methods in Interfaces
New Date and Time API

### 11. What are the types of design patterns in Java?
Design patterns in Java are categorized into three types:

Creational Patterns (e.g., Singleton, Factory, Builder)
Structural Patterns (e.g., Adapter, Decorator, Composite)
Behavioral Patterns (e.g., Observer, Strategy, Command)

### 12. What are the SOLID Principles?
SOLID represents a set of design principles in object-oriented programming that, when combined, make it more likely that a system will be easy to maintain and scale over time. They are:

S: Single Responsibility Principle (SRP)
O: Open/Closed Principle (OCP)
L: Liskov Substitution Principle (LSP)
I: Interface Segregation Principle (ISP)
D: Dependency Inversion Principle (DIP)

### 13. How can you achieve thread-safe singleton patterns in Java?
Thread-safe singleton can be achieved using various approaches:

Using synchronized keyword with the getInstance method.
Using the "Bill Pugh Singleton" method which involves a private static inner class.
Using an enum to represent the singleton.

### 14. What do you understand by the Open-Closed Principle (OCP)?
The Open-Closed Principle states that classes should be open for extension but closed for modification. This means

### 15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?

It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.