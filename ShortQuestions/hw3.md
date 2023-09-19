2. What is the checked exception and unchecked exception in Java, could you give one example?


Checked Exceptions:
These are the exceptions that a programmer should handle in their code,If a method can throw such an exception, it must either handle it using a try-catch block or declare it using the thro
public void readFile(String filePath) throws FileNotFoundException {
    File file = new File(filePath);
    FileReader fr = new FileReader(file);
}ws clause.

Unchecked Exceptions:
public void displayLength(String str) {
    // Throws NullPointerException if str is null
    int length = str.length();
    System.out.println(length);
}



3. Can there be multiple finally blocks?
No, there cannot be multiple finally blocks associated with a single try block in Java.


4. When both catch and finally return values, what will be the final result?
In Java, if both the catch and finally blocks contain a return statement, the value from the finally block will be returned. The value from the catch block will be discarded. This can be a source of confusion for many developers, so it's usually advised to avoid having return statements in both catch and finally blocks.

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime/Unchecked Exceptions:
Definition: Unchecked exceptions are the exceptions that are checked at runtime rather than at compile-time.

Compile-time/Checked Exceptions:
Definition: Checked exceptions are exceptions that are checked at compile-time. This means that the Java compiler ensures there is a mechanism to handle these exceptions.


6. What is the difference between throw and throws?
throw:
Purpose: It is used to explicitly throw an exception from a method or any block of code.
Usage: You can use throw followed by an instance of the Throwable class or its subclasses (i.e., any exception or error).

throws:
Purpose: It is used to declare that a method might throw one or more types of exceptions. It tells the caller of the method about the exceptions that they might need to handle.
Usage: You can use throws followed by one or multiple exception types, separated by commas

.7. What is optional? why do you use it? write an optional example.

Optional is a container object introduced in Java 8, which may or may not contain a non-null value. By using Optional, you can better deal with cases that might result in null values without having to explicitly do null checks. It's a means of representing a value that might be absent, thereby helping to prevent NullPointerExceptions and leading to more expressive and readable code.

Why use Optional?

Explicitness: By using Optional, you're making it explicit in your method signature that there might not be a value.
Avoid NullPointerException: It provides a clear pattern to avoid null references and thus reduces the risk of runtime NullPointerExceptions.
API Design: For library or API developers, it's a clean way to indicate that a method might not always return a value.
Rich API for Alternative Logic: Optional provides various utility methods to handle values by alternative means (e.g., orElse, orElseGet, ifPresent).

Example:

public class OptionalSimpleExample {

    public static void main(String[] args) {
        System.out.println(getNickname("Alice"));  // Prints: Optional[Ally]
        System.out.println(getNickname("Bob"));    // Prints: Optional.empty
    }

    // This method returns an Optional<String> containing the nickname if one exists.
    public static Optional<String> getNickname(String name) {
        if ("Alice".equals(name)) {
            return Optional.of("Ally");
        } 
        return Optional.empty();
    }
}


8. Why finally always be executed ?

The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.


10. What is Java 8 new features ?


Lambda Expressions:

Allows you to express instances of single-method interfaces (functional interfaces) more concisely.
Streams API:

For processing sequences of elements (e.g., collections) in a functional style.
Default Methods:

Lets interfaces have methods with implementations without affecting existing classes.
Optional Class:

A container that can hold a value or be null, designed to address null references.
New Date and Time API:

Inspired by Joda-Time, brings a comprehensive date and time library to Java.
Nashorn JavaScript Engine:

Execute JavaScript code natively on the JVM.
CompletableFuture:

Represents a future result of an asynchronous computation.
New Collectors:

In the java.util.stream.Collectors class to work with streams, e.g., toList(), toSet(), groupingBy().
Functional Interfaces:

Introduced in java.util.function, they work hand in hand with lambdas.
@FunctionalInterface Annotation:

Indicates that an interface is intended to be a functional interface.

11.
Creational Patterns: 
Singleton
Factory
Abstract Factory
Builder
Prototype

Structural Patterns:
Adapter
Bridge
Composite
Decorator
Facade
Flyweight
Proxy

Behavioral Patterns: 
Observer
Strategy
Command
Template Method
Iterator
State
Chain of Responsibility
Mediator
Memento
Visitor

12.
S - Single Responsibility Principle (SRP):
A class should have only one reason to change. It should have only one responsibility.
O - Open/Closed Principle (OCP):
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
L - Liskov Substitution Principle (LSP):
Subtypes must be substitutable for their base types. Essentially, if a program is using a base class, it should be able to use any of its derived classes without knowing it.
I - Interface Segregation Principle (ISP):
No client should be forced to depend on methods it does not use. This often means that large interfaces should be split into smaller, more specific ones so that clients only need to know about the methods that are of interest to them.
D - Dependency Inversion Principle (DIP):
High-level modules should not depend on low-level modules. Both should depend on abstractions. Also, abstractions should not depend on details. Details should depend on abstractions.

13.
Eager Initialization:
By initializing the Singleton instance eagerly, you ensure thread safety without requiring synchronization.

java
Copy code
public class Singleton {
    private static final Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return instance;
    }
}

14.
"Software entities (such as classes, modules, functions, etc.) should be open for extension, but closed for modification." that is, such an entity can allow its behaviour to be extended without modifying its source code

15.
It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.
