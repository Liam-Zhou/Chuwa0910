1. Practice collection

2. What is the checked exception and unchecked exception in Java, could you give one example?
    
    1. Checked Exceptions:

       Description: Checked exceptions represent conditions that, while exceptional, can reasonably be expected to occur and that callers should be prepared to catch. The Java compiler ensures that these exceptions are either caught using a try-catch block or declared to be thrown using the throws keyword. In other words, if our code might cause a checked exception, we’re "checked" by the compiler to handle it.

       Example: One of the most commonly known checked exceptions is IOException. Consider the case of reading from a file:
       ```
       public void readFile(String filename) throws IOException {
          FileInputStream fis = new FileInputStream(filename);
       }
       ```
       Here, since FileInputStream might throw an IOException (a checked exception), we either need to handle it with a try-catch block or declare the method to throw the exception with the throws keyword, as shown.

    2. Unchecked Exceptions:

       Description: Unchecked exceptions, also known as runtime exceptions, represent defects in the program—situations that are typically preventable by the programmer. As the name suggests, the compiler doesn't check to see if they're handled or declared. This means that while you can catch them, we’re not required to. They typically extend from RuntimeException.

       Example: A common unchecked exception is NullPointerException. It's thrown when the JVM tries to access an object or call a method on an object that is currently null.
       ```
       public void printLength(String str) {
          System.out.println(str.length()); // Throws  NullPointerException if str is null
       }
       ```
       In this example, if printLength is called with a null string, a NullPointerException (an unchecked exception) will be thrown.

       In brief, the main difference is:
       - We are required by the compiler to handle checked exceptions, either by catching them or declaring that your method throws them.
       - We are not required to handle unchecked exceptions, although it's often a good idea to prevent or handle them to avoid unexpected program termination.
    
3. Can there be multiple finally blocks?
    
    No, in Java's try-catch-finally construct, we cannot have multiple finally blocks associated with a single try block. Each try block can be followed by zero or more catch blocks, but at most one finally block.
    
    The finally block is executed after the try block completes, whether an exception was thrown or not. If a catch block executes, the finally block will run after the catch block completes.
    
    - A try block can exist without any catch blocks, but it must then be followed by a finally block.
    - If there's no exception thrown in the try block, the finally block will execute immediately after the try block.
    - If an exception is thrown and caught in a catch block, the finally block will execute immediately after the catch block.
    - If an exception is thrown but not caught, the finally block will still execute. After the finally block completes, the exception continues to propagate up to the next enclosing try-catch or the method's caller.
    
4. When both catch and finally return values, what will be the final result?
    
    If both the catch and finally blocks have a return statement, the value returned from the finally block will be the final result, effectively overshadowing the value returned from the catch block.
    
    However, it's essential to note that having return statements in both catch and finally blocks can be confusing and is generally considered poor practice. It makes the code harder to follow and understand. If possible, try to avoid such constructs in our programs.
    
5. What is **Runtime/unchecked exception**? What is **Compile/checked exception**?
    
    1. Runtime/Unchecked Exception:

       Description: These are exceptions that derive from RuntimeException and are not checked at compile-time. That is, the compiler doesn't mandate that we handle them using a try-catch block or declare them using the throws keyword. These exceptions often arise due to programming errors.

       Examples:
       - NullPointerException: Thrown when the JVM attempts to access an object or call a method on an object that is null.
       - ArithmeticException: Like when we divide by zero.
       - ArrayIndexOutOfBoundsException: When accessing an array element using an invalid index.

       Handling: Even though the compiler doesn't force us to handle unchecked exceptions, it's often a good practice to handle situations that might lead to such exceptions to ensure that our program is robust.

    2. Compile/Checked Exception:

       Description: These are exceptions that are checked at compile-time. Classes that extend Throwable but not RuntimeException or Error are considered checked exceptions. When our code might throw a checked exception (either directly or by calling a method that declares it), the compiler ensures that we either handle it using a try-catch block or declare it using the throws keyword.

       Examples:
       - IOException: Often thrown when dealing with input and output operations, such as reading from or writing to files.
       - ClassNotFoundException: Thrown when the JVM tries to load a class but can't find its definition.
       - SQLException: Thrown when dealing with database operations via JDBC.

       Handling: The compiler will give an error if a checked exception is not either caught or declared in a method's signature using the throws keyword.
    
6. What is the difference between **throw** and **throws**?
    
    1. throw:

       Usage: throw is a statement used to explicitly raise a specific exception.
  
       Purpose: It's often used inside a method to indicate that a specific error has occurred which the method cannot handle itself, thereby passing the responsibility to the caller.

       Position: It is used inside the method body.

    2. throws:

       Usage: throws is used in the method signature to declare one or more exceptions that might be thrown by the method but are not handled within the method.

       Purpose: It provides a way to inform the caller of the method about the potential exceptions the caller might have to handle.

       Position: It is used at the end of a method declaration before the method's opening brace.
    
7. Run the below three pieces codes, Noticed the printed exceptions. Why do we put the Null Runtime exception before Exception?

    When using multiple catch blocks in Java exception handling, it's crucial to order them from most specific to most general. This is because the first catch block that matches the type of the exception thrown is executed, and the rest are skipped.

    If we have a catch block for a more general exception type (e.g., Exception) before a more specific exception type (e.g., NullPointerException), then the more specific exception will never be caught by its designated block. This is because the general Exception type can catch all exceptions, effectively overshadowing any specific exception types placed after it.
 
8. What is **optional**? Why do you use it? Write an optional example.
    
    Optional is a container object introduced in Java 8 that may or may not contain a non-null value. By using Optional, we can represent the idea of computation that might fail. It's designed to help in scenarios where we might have had null previously, aiming to reduce the number of null pointer exceptions in Java applications by encouraging developers to always think about the case where a value might be absent.

    Advantages of using Optional:

    - Null Safety: Reduces the risk of NullPointerException by forcing us to actively unwrap the Optional and consider the absent case.
    - Expressiveness: Clearly indicates in our method signature when a value might be absent, making the API more understandable.
    - Rich API: Provides a rich API for dealing with values that might be absent, allowing for more concise and readable code.
    
    Example:
    ```
    public class OptionalExample {
       public static void main(String[] args) {
          Optional<String> fullName = Optional.ofNullable(null);
          System.out.println("Full Name is set? " + fullName.isPresent());
          System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
          System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        
          Optional<String> firstName = Optional.of("Tom");
          System.out.println("First Name is set? " + firstName.isPresent());
          System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
          System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
       }
    }
    ```
    
9. Why finally always be executed?
    
    Here's why the finally block always gets executed:

    - Resource Cleanup: One of the primary reasons for using finally is to clean up resources like files, sockets, or database connections. Ensuring that the finally block always runs means you can reliably close these resources and prevent resource leaks.
    - Exception Handling: Whether an exception occurs in the try block and is caught, or even if it's not caught, the finally block will still run. This is important because there may be scenarios where an exception is unexpected or isn't caught by any of the catch blocks, but we still want some code to run (like logging or resource cleanup).
    - Non-exceptional Exits: The finally block will execute even if there's a return statement in the try or catch blocks. This ensures that the cleanup code runs even if the method returns a value before its natural end.
    - Clarity: By guaranteeing that the finally block will always run, Java offers a clear, predictable structure for writing cleanup code. Developers can be confident about where to place such code.
    - Exception in finally: If there's an exception within the finally block itself, that exception will propagate out, potentially overshadowing any exception from the try or catch blocks. This is a reason to be cautious and avoid error-prone code in finally.

    However, there are a few scenarios where the finally block won't execute:

    - If the JVM exits unexpectedly, either due to a call to System.exit() or a JVM crash.
    - If the thread running the try-catch-finally sequence is interrupted or killed.

    Outside of these exceptional cases, the finally block is designed to be reliably executed, making it a cornerstone of robust exception handling and resource management in Java.
     
11. What is **Java 8** new features?
    
    1. Lambda Expressions:

       - Enables us to express instances of single-method interfaces (functional interfaces) in a much more concise, expressive, and readable way.
       - Typically used to define inline implementations of functional interfaces.

    2. Functional Interfaces:

      - An interface with just one abstract method, and they can have multiple default or static methods. Some common examples from Java's standard library are Runnable, Callable, Comparator, etc.

    3. Streams:

       - A new abstraction of data manipulation using a functional approach.
       - The Java 8 Stream API lets you process data in a declarative way.
       - Can be parallelized to process data faster.

    4. Default Methods:

       - Allows the addition of methods to interfaces with maintaining backward compatibility with classes that already use this interface.
       - Known as "extension methods" in other contexts.

    5. Method References:

       - Used to call a method by referring to it with the help of its name directly. They behave exactly as lambda expressions.
       - The only difference it has from lambda expressions is that this uses a direct reference to the method by its name instead of providing a delegate to the method.

    6. Java Time API:

       - Comprehensive and immutable model for date-time manipulation, fixing many issues of the older Date and Calendar models.
       - Located in the java.time package.

    7. Optional:

       - A container that may or may not contain a non-null value.
       - By using Optional, we can better deal with cases having the possibility of null values without having to explicitly do null checks.

    8. Nashorn JavaScript Engine:

       - A much improved javascript engine is introduced, to replace the existing Rhino. Nashorn provides 2 to 10 times better performance, as it directly compiles the code in memory and passes the bytecode to JVM.

    9. New Collectors:

       - Collectors are introduced to reduce the boilerplate code. We can use methods like joining(), averagingInt(), summarizingInt(), etc., on the stream elements easily with Collectors.

    10. CompletableFuture:

        - Used for asynchronous programming in Java. It represents a future result of an asynchronous computation.
    
12. What are the types of design patterns in Java?
    
    1. Creational Patterns: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. They abstract the process of object creation and help make a system independent of how its objects are created, composed, and represented. Some common creational patterns include:

       - Singleton Pattern: Ensures that a class has only one instance and provides a global point of access to that instance.
       - Factory Method Pattern: Defines an interface for creating objects, but lets subclasses decide which class to instantiate.
       - Abstract Factory Pattern: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
       - Builder Pattern: Separates the construction of a complex object from its representation.
       - Prototype Pattern: Allows an object to create a copy of itself.

    2. Structural Patterns: These patterns concern class and object composition. They provide different ways to ensure that structures in the system are scalable, efficient, and easy to modify. Common structural patterns include:

       - Adapter Pattern: Allows classes with incompatible interfaces to work together by wrapping its specific interface around that of an already existing class.
       - Bridge Pattern: Separates an object's abstraction from its implementation, allowing the two to vary independently.
       - Composite Pattern: Lets you compose objects into tree structures to represent part-whole hierarchies.
       - Decorator Pattern: Allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects.
       - Facade Pattern: Provides a unified interface to a set of interfaces in a subsystem.
       - Flyweight Pattern: Reduces the cost of creating and manipulating a large number of small objects.
       - Proxy Pattern: Provides a placeholder for another object to control access to it.

    3. Behavioral Patterns: These patterns are concerned with algorithms and the assignment of responsibilities between objects. They define clear patterns of communication between different objects. Common behavioral patterns include:

       - Chain of Responsibility Pattern: Decouples the sender from the receiver by letting more than one object handle a request.
       - Command Pattern: Encapsulates a request as an object, thereby allowing users to parameterize other objects with different requests, queue requests, and log the requests.
       - Interpreter Pattern: Provides a way to evaluate language grammar or expressions for particular languages.
       - Iterator Pattern: Provides a way to access elements of a collection without exposing its underlying representation.
       - Mediator Pattern: Reduces the connections between multiple classes by centralizing external communications.
       - Memento Pattern: Allows for the ability to restore an object to its previous state.
       - Observer Pattern: Allows an object to publish changes to its state so that other objects can react accordingly.
       - State Pattern: Allows an object to change its behavior when its internal state changes.
       - Strategy Pattern: Allows selecting an implementation of an algorithm's interface at runtime.
       - Template Method Pattern: Defines the program skeleton in a method in an algorithm, but delays some steps to subclasses.
       - Visitor Pattern: Adds further operations to objects without having to modify them.
    
13. What are the **SOLID** Principles?
    
    1. S - Single Responsibility Principle (SRP)

       A class should have only one reason to change.
       
       This means a class should only have one job or responsibility. If a class has multiple responsibilities, it becomes more challenging to maintain and modify without introducing bugs.

    2. O - Open/Closed Principle (OCP)

       Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

       This promotes the idea that the behavior of a module can be extended without modifying its source code.

    3. L - Liskov Substitution Principle (LSP)

       Subtypes must be substitutable for their base types without altering the correctness of the program.

       In simpler terms, if a class B is a subtype of class A, then we should be able to replace A with B without disrupting the behavior of the program.

    4. I - Interface Segregation Principle (ISP)

       Clients should not be forced to depend on interfaces they do not use.
       
       This means that a class should not be forced to implement interfaces it does not use. Instead of one fat interface, multiple, specific ones are preferred.

    5. D - Dependency Inversion Principle (DIP)

       High-level modules should not depend on low-level modules. Both should depend on abstractions (interfaces).
 
       Additionally, abstractions should not depend on details. Details should depend on abstractions.

       This promotes decoupling in the system, making it more modular and easier to maintain.
    
14. How can you achieve thread-safe singleton patterns in Java?
    
    1. Eager Initialization:

       This method ensures that the singleton instance is created during class loading. This approach is thread-safe but might not be efficient if the instance isn't used, because it's created whether or not it's required.
  
       ```
       public class Singleton {
          private static final Singleton instance = new Singleton();

          private Singleton() {}

          public static Singleton getInstance() {
             return instance;
          }
       }
       ```

    2. Synchronized Method:

       This approach uses a synchronized method to ensure only one thread can execute getInstance() at a time. It's thread-safe but can have performance issues due to the cost of synchronization.
  
       ```
       public class Singleton {
          private static Singleton instance;

          private Singleton() {}

          public static synchronized Singleton getInstance() {
             if (instance == null) {
                instance = new Singleton();
             }
             return instance;
          }
       }
       ```

    3. Double-Checked Locking:

       This method checks twice before initializing the instance, significantly improving performance over the synchronized method.

       ```
       public class Singleton {
          private static volatile Singleton instance;

          private Singleton() {}

          public static Singleton getInstance() {
             if (instance == null) {
                synchronized (Singleton.class) {
                   if (instance == null) {
                      instance = new Singleton();
                   }
                }
             }
             return instance;
          }
       } 
       ```

       Note that the volatile keyword is crucial here to make sure the instance is correctly published, avoiding partial initialization issues.
 
    4. Bill Pugh Singleton (Inner Static Helper Class):

       This method introduces an inner static helper class that holds the singleton instance. It ensures the instance is created only when requested, and it's thread-safe without synchronization.

       ```
       public class Singleton {

          private Singleton() {}

          private static class Holder {
             private static final Singleton INSTANCE = new Singleton();
          }

          public static Singleton getInstance() {
             return Holder.INSTANCE;
          }
       }
       ```

    5. Enum Singleton:

       Using an enum is the simplest way to create a thread-safe singleton in Java, and it also ensures protection against deserialization and reflection.

       ```
       public enum Singleton {
          INSTANCE;

          public void someMethod() {
             // some class member functions
          }
       }
       ```
       
15. What do you understand by the Open-Closed Principle (OCP)?
    
    Open for Extension: We should be able to add new features or components to the system without affecting existing code. That is, the behavior of modules can be extended. This is achieved typically through the use of interfaces, abstract base classes, or patterns like strategy, template method, etc.

    Closed for Modification: Once a module has been developed and tested, changes to that module can introduce risks. The idea is that we should not need to modify existing, working code to add new functionality. Instead, we create new code that is decoupled from the existing code.

    The benefits of the Open-Closed Principle include:

    - Flexibility and Maintenance: Since existing code isn't changed frequently, there's less risk of introducing new bugs in already-tested code. When requirements change, we introduce new code rather than changing old code that already works.

    - Reusability: By making components more generic (open for extension), they become more reusable in different contexts.

    - Scalability: It becomes easier to scale the application by adding new functionalities as new classes rather than modifying existing ones.

    An example to illustrate OCP:

    Imagine we have a class that calculates the area of shapes:
    ```
    class AreaCalculator {
       public double calculateArea(Rectangle[] shapes) {
          double area = 0;
          for (var shape : shapes) {
             area += shape.width * shape.height;
          }
          return area;
       }
    }
    ```
    If we wanted to add the ability to calculate the area of circles, the above design would require modifying the AreaCalculator class. This would violate OCP.

    A better design would be:
    ```
    interface Shape {
       double area();
    }

    class Rectangle implements Shape {
       public double width;
       public double height;
    
       @Override
       public double area() {
          return width * height;
       }
    }

    class Circle implements Shape {
       public double radius;
    
       @Override
       public double area() {
          return Math.PI * radius * radius;
       }
    }

    class AreaCalculator {
       public double calculateArea(Shape[] shapes) {
          double area = 0;
          for (var shape : shapes) {
             area += shape.area();
          }
          return area;
       }
    }
    ```
    Now, to add new shapes, we’d simply create new classes that implement the Shape interface, without modifying the existing AreaCalculator class.
    
16. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of typeB and objects of type A must be the same.
    
    The answer is option 1.

    This principle ensures that a derived class is substitutable for its base class without altering the correctness of the program. If class B is a subtype of class A, we should be able to use B wherever we use A without any unexpected behaviors.
    
17. Watch the design pattern video, and type the code, submit it to **MavenProject** folder.
    
    
