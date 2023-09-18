# HW3. Xiao Yang
### 1.  Practice Collection
to-do
### 2. What is the checked exception and unchecked exception in Java, could you give one example?
- Checked exceptions are exceptions that must be either handled or declared using the `throws` keyword in the method signature. 
This means that the compiler enforces you to either handle these exceptions or explicitly propagate them up the call stack.
For example, when working with file I/O, network communication, or database operations, you might encounter checked exceptions.
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();
            // Perform some operations
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
- Unchecked exceptions also known as runtime exceptions, do not need to be explicitly caught or declared in the method signature. 
They typically indicate programming errors or issues that are harder to anticipate.
```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String str = null;
        try {
            // This line will throw a NullPointerException
            int length = str.length();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
```

### 3. Can there be multiple finally blocks?
Each `try-catch` block only accept one `finally` block. But it is valid for a blocks with multiple `try-catch` and `finally` blocks. 
Each finally block will be executed in the order they appear, from top to bottom, after the associated try-catch block has completed its execution, whether an exception was thrown or not.
### 4.  When both catch and finally return values, what will be the final result?
It will only return values in `finally` block.
### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
* [See question 2.](#2-what-is-the-checked-exception-and-unchecked-exception-in-java-could-you-give-one-example)
### 6. What is the difference between throw and throws?
`throw` is used to throw an exception explicitly in the code, inside the function or the block of code.
`throws` is used in the method signature to declare an exception which might be thrown by the function while the execution of the code.
### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

### 8. What is optional? why do you use it? write an optional example
`Optional` class is used to provide a type-level solution for representing optional values instead of null references.

**example here**:
```java
public class Computer {
  private Optional<Soundcard> soundcard;  
  public Optional<Soundcard> getSoundcard() { ... }
  ...
}

public class Soundcard {
  private Optional<USB> usb;
  public Optional<USB> getUSB() { ... }

}

public class USB{
  public String getVersion(){ ... }
}
```

### 9. Why finally always be executed ?
The purpose of the finally block in Java is to ensure that certain code, such as cleanup operations or resource releases, 
always runs, regardless of whether an exception occurred in the preceding try or catch blocks.
### 10. What is Java 8 new features ?
Some important features are:
- **Lambda Expressions**
- **Functional Interfaces**
- **Method References**
- **Streams**
### 11. What are the types of design patterns in Java?
There are several types of design patterns, which can be categorized into three main groups:

**Creational Design Patterns:**
These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

- **Singleton Pattern**: Ensures that a class has only one instance and provides a global point of access to that instance.

- **Factory Method Pattern**: Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.

- **Abstract Factory Pattern**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

- **Builder Pattern**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

- **Prototype Pattern**: Creates new objects by copying an existing object, known as the prototype.

**Structural Design Patterns:**
These patterns focus on object composition, ensuring that classes and objects can work together in a flexible and extensible way.

- **Adapter Pattern**: Allows the interface of an existing class to be used as another interface.

- **Decorator Pattern**: Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

- **Proxy Pattern**: Provides a surrogate or placeholder for another object to control access to it.

- **Composite Pattern**: Composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly.

- **Bridge Pattern**: Separates an object's abstraction from its implementation so that the two can vary independently.

**Behavioral Design Patterns:**
These patterns are concerned with communication between objects, responsibilities of objects, and how they operate together.

- **Observer Pattern**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

- **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

- **Command Pattern**: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

- **State Pattern**: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

- **Chain of Responsibility Pattern**: Passes the request along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

- **Visitor Pattern**: Represents an operation to be performed on the elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates.

- **Interpreter Pattern**: Defines a grammar for a language and provides an interpreter to interpret the language grammar.

- **Memento Pattern**: Captures and externalizes an object's internal state so the object can be restored to this state later.

### 12. What are the SOLID Principles ?

- **Single Responsibility Principle (SRP):**
This principle states that a class should have only one reason to change, meaning it should have only one responsibility. In other words, a class should have only one job or function. This helps in keeping the code focused, easier to understand, and more maintainable.
- **Open/Closed Principle (OCP):**
The Open/Closed Principle states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. In other words, you should be able to add new functionality to a system without changing the existing code. This is often achieved through the use of abstractions (e.g., interfaces or abstract classes) and polymorphism.
- **Liskov Substitution Principle (LSP)**:
The Liskov Substitution Principle states that objects of a derived class should be able to replace objects of the base class without affecting the correctness of the program. In other words, if a class is a subclass of another class, it should be able to be used interchangeably with its parent class without causing issues.
- **Interface Segregation Principle (ISP):**
The Interface Segregation Principle suggests that clients should not be forced to depend on interfaces they do not use. It advocates for smaller, more specialized interfaces rather than large, monolithic ones. This helps in avoiding "interface pollution" and making classes and systems more flexible.
- **Dependency Inversion Principle (DIP)**:
The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details; details should depend on abstractions. This principle encourages the use of interfaces or abstract classes to define contracts and decouples the high-level and low-level components of a system.
### 13. How can you achieve thread-safe singleton patterns in Java?
1. **Eager Initialization**:
```java

public class ThreadSafeSingleton {
    private static class SingletonHolder {
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }

    private ThreadSafeSingleton() {
        // Private constructor to prevent instantiation from other classes.
    }

    public static ThreadSafeSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

```
In this approach, the Singleton instance is created eagerly during class loading, ensuring thread safety without the need for explicit synchronization.
2. **Lazy Initialization with Double-Check Locking**
```java
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // Private constructor to prevent instantiation from other classes.
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

```
In this approach, the Singleton instance is created lazily only when needed, and double-check locking is used to ensure thread safety.
3. **`enum`**
```java
public enum ThreadSafeSingleton {
    INSTANCE;

    // Add methods and fields here as needed.
}

```
The use of an enum to implement a Singleton pattern is considered the most thread-safe approach
### 14. What do you understand by the Open-Closed Principle (OCP) ?
The Open/Closed Principle states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. In other words, you should be able to add new functionality to a system without changing the existing code. This is often achieved through the use of abstractions (e.g., interfaces or abstract classes) and polymorphism.
### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
to-do
### 16. Design problem
to-do