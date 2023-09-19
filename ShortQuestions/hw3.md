1. Practice  collection
> see coding part
2. What is the checked exception and unchecked exception in Java, could you give one example?
> Checked Exceptions (Compile-Time Exceptions): <br>
Checked exceptions are exceptions that must be explicitly handled in your code using try-catch or declared in the throws clause.
Examples include IOException and SQLException.<br>
> Unchecked Exceptions (Runtime Exceptions):<br>
Unchecked exceptions are not required to be explicitly handled and often indicate programming errors.
Examples include NullPointerException and ArrayIndexOutOfBoundsException.<br>

3. Can there be multiple finally blocks?
>  you can have multiple finally blocks associated with a single try block. However, each try block should have at most one finally block.
4. When both catch and finally return values, what will be the final result?
> the value returned by the finally block will override the value returned by the catch block.
5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
> reference to question 2
6. What is the difference between throw and throws?
> throw is used to raise and throw an exception within code. <br>
throws is used in a method declaration to specify the exceptions that the method may throw.
7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
> because they are more specific and typically represent programming errors or unexpected conditions. Handling them first allows for more precise and focused error handling.
8. What is optional? why do you use it? write an optional example.
> Optional is a class in Java that represents an optional value, meaning it may or may not contain a non-null value. It's used to handle cases where a value could be absent, helping to prevent NullPointerExceptions and clearly express the absence of a value.
9. Why finally always be executed ?
> The finally block in Java always executes to ensure cleanup or resource release, regardless of whether an exception is thrown in the try block or not.
10. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
> See coding part
11. What is Java 8 new features ?
> Optional class<br>
> Lambda expression<br>
> Functional Interface<br>
> Default Method<br>
> Stream API<br>
> Method Reference<br>
> Date Time API<br>
12. What are the types of design patterns in Java ?
> Creational Patterns:<br>
Singleton Pattern: Ensures a class has only one instance and provides a global point of access to it.<br>
Factory Method Pattern: Defines an interface for creating objects, with subclasses deciding which class to instantiate.<br>
Structural Patterns:<br>
Adapter Pattern: Allows the interface of an existing class to be used as another interface.<br>
Decorator Pattern: Attaches additional responsibilities to objects dynamically.<br>
Proxy Pattern: Provides a surrogate or placeholder for another object to control access to it.<br>
Behavioral Patterns:<br>
Observer Pattern: Defines a one-to-many dependency between objects, so when one object changes state, all its dependents are notified and updated automatically.<br>
Strategy Pattern: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.<br>
Concurrency Patterns:<br>
Singleton Pattern (Concurrency): Ensures a single instance of a class in a multithreaded environment.<br>
Immutable Object Pattern: Guarantees that an object's state cannot be modified after it is created.<br>
Producer-Consumer Pattern: Coordinates the producer and consumer threads to efficiently exchange data.<br>
13. What are the SOLID Principles ?
> SOLID is an acronym representing a set of five design principles that help guide software design to produce maintainable and scalable code. These principles were introduced by Robert C. Martin and are widely adopted in the software development industry.<br>
> Single Responsibility Principle (SRP): A class should have one reason to change, promoting focused responsibility.<br>
Open/Closed Principle (OCP): Software entities should be open for extension but closed for modification, encouraging reusable and extendable code.<br>
Liskov Substitution Principle (LSP): Subtypes should be substitutable for their base types without altering program correctness.<br>
Interface Segregation Principle (ISP): Clients should not be forced to depend on unnecessary interfaces, advocating specific interfaces for specific clients.<br>
Dependency Inversion Principle (DIP): High-level modules should depend on abstractions, not concrete details, for loose coupling.<br>

14. How can you achieve thread-safe singleton patterns in Java ?
>Eager Initialization: This approach ensures thread safety but creates the instance eagerly when the class is loaded, which may not be efficient if the instance is not always needed.<br>
Lazy Initialization with Synchronization: It is simple and thread-safe, but synchronization can introduce performance overhead, especially in high-concurrency scenarios.<br>
Double-Checked Locking: Provides both thread safety and efficiency by minimizing synchronization overhead.<br>

15. What do you understand by the Open-Closed Principle (OCP) ?
> The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented software design<br>
> Definition: Software entities (classes, modules, functions) should be open for extension but closed for modification.<br>
> To adhere to the Open-Closed Principle, you typically use techniques like inheritance, interfaces, and polymorphism to allow for extension through subclassing or implementing new interfaces. This approach promotes code reusability and maintainability by reducing the risk of introducing bugs or breaking existing functionality when making changes.
16. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
> It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing
17. Watch the design pattern video, and type the code, submit it to MavenProject folder
> Ok, see coding part!<br>
> Pros and Cons:<br>
> 1 Simple Factory Pattern:<br>
Pros: Simple to understand and use. Centralizes object creation.<br>
Cons: Violates Open-Closed Principle. May lead to a large factory class.<br>
2 Factory Method Pattern:<br>
Pros: Follows Open-Closed Principle. Provides extensibility.<br>
Cons: Requires multiple factory classes. Clients need to know the factory to use.<br>
3 Abstract Factory Pattern:<br>
Pros: Creates related product families. Follows Open-Closed Principle. Reduces coupling.<br>
Cons: Requires creating many factory classes for new families.<br>
