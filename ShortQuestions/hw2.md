1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo
    repo as example)
> please see coding part
2. What is wrapper class in Java and Why we need wrapper class?
> Wrapper classes in Java are classes that wrap primitive data types to allow them to be used as objects. They are needed for tasks like storing null values, working with collections that require objects, using methods that expect objects, and providing utility methods for primitive types. They include Integer, Double, Boolean, and others, with each corresponding to a primitive type.
3. What is the difference between HashMap and HashTable?
> * Safety: <br>
> HashMap: Not safe for many people (threads). <br>
> HashTable: Safe for many people (threads). <br>
> * Nulls: <br>
> HashMap: OK with empty slots. <br>
> HashTable: Doesn't like emptiness (throws a fit). <br>
> * Speed: <br>
> HashMap is faster for most tasks. <br>
> HashTable can be slower when many people are involved. <br>
> * Age: <br>
> HashMap is the new kid. <br>
> HashTable is the older one, not used much anymore. <br>

4. What is String pool in Java and why we need String pool?
> The String pool in Java is a space where the program stores and reuses identical string values to save memory and improve performance when working with strings. It's like a shared storage for commonly used strings, making programs more efficient.
5. What is Java garbage collection?
> Java garbage collection is an automatic memory management process where the Java Virtual Machine (JVM) identifies and reclaims memory occupied by objects that are no longer in use by the program. It prevents memory leaks and manual memory management errors by tracking and freeing up memory automatically. The process involves identifying unreferenced objects, marking them as garbage, and then reclaiming their memory. Java provides various garbage collection algorithms to optimize memory usage and application performance. Developers don't need to explicitly deallocate memory, as the JVM takes care of this task, enhancing code simplicity and reliability.
6. What are access modifiers and their scopes in Java?
> Public: Accessible from anywhere, both within and outside the class.<br>
> Protected: Accessible within the class, its subclasses, and in the same package.<br>
> Default (Package-private): Accessible only within the same package.<br>
> Private: Accessible only within the same class.<br>

7. What is final key word? (Filed, Method, Class)

> Final Field: A final field cannot be reassigned after initialization, making it a constant.<br>
> Final Method: A final method in a class cannot be overridden by subclasses, ensuring it retains its behavior.<br>
> Final Class: A final class cannot be extended, preventing the creation of subclasses.<br>

8. What is static keyword? (Filed, Method, Class). When do we usually use it?
> Static Field: A static field is shared among all instances of the class and is accessed using the class name. It's used for constants or shared data.<br>
> Static Method: A static method is associated with the class rather than instances. It's often used for utility methods that don't require access to instance-specific data.<br>
> Static Nested Class: A static nested class is a class that is nested within another class but is not tied to instances of the outer class. It's used for grouping related functionality.<br>
9. What is the differences between overriding and overloading?
> Overriding is about providing a new implementation for a method in a subclass, maintaining the method signature from the superclass. Overloading is about having multiple methods in the same class with the same name but different parameters.
10. What is the differences between super and this?
> "Super" is used for accessing superclass members, while "this" is used for current instance members.
11. What is the Java load sequence?
> Loading: The JVM finds and loads the class bytecode from the classpath.<br>
> Linking: This involves verification, preparation (memory allocation), and resolution of class references.<br>
> Initialization: The class is initialized, executing static initialization blocks and initializing static fields.<br>
12. What is Polymorphism ? And how Java implements it ?
> Polymorphism in Java allows objects of different classes to be treated as if they belong to a common superclass or interface. It's implemented through method overriding and interfaces, enabling more flexible and reusable code by allowing objects to respond to method calls based on their actual types.
13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
> Encapsulation in Java is the practice of bundling data and methods within a class and controlling access to them using access modifiers (like private). It promotes data protection, abstraction, flexibility, and security by hiding implementation details and providing controlled access through getter and setter methods. This helps ensure data integrity and simplifies code maintenance.
14. What is Interface and what is abstract class? What are the differences between them?
>    1)Abstract Class can have constructor but interface doesn’t.<br>
>    2)Abstract Class can have non-abstract method. But before Java8 each method in interfaced must be public abstract. But After Java8 interface can have default and static method.<br>
>    3)Abstract Class use variable named: final, non-final, static, non-static but Interface only have static and final variable.<br>
>    4)A class use key word extends to inherit the Abstract Class, use implement to implement an interface.<br>
>    5)If the child class inherit the Abstract Class but not override the abstract method then the child class should be defined with key word Abstract. If the child class implement an interface but not override the method then it would not pass the compilation<br>
>    6)All methods in an interface are implicitly public and abstract. Abstract methods can have various access modifiers (public, protected, or default package-level access).<br>
>    7)Interfaces cannot have constructors because they cannot be instantiated directly.Abstract classes can have constructors.<br>
15. design a parking lot (put the code to codingQuestions/coding1 folder, )
> see coding part
16. What are Queue interface implementations and what are the differences and when to use what?
> Queue interface is part of the Java collections framework and represents a collection of elements with a specific order for processing. It has several implementations:
> LinkedList: Use for basic FIFO queues with both front and rear insertions/removals.<br>
> ArrayDeque: Suitable for efficient FIFO queues with constant-time operations.<br>
> PriorityQueue: Use when processing elements based on a specific order or priority is needed.<br>