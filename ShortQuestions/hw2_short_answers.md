### 1. Examples of OOP
Please see the coding part

### 2.  What is wrapper class in Java and Why we need wrapper class? 
Wrapper classes in Java are used to convert primitive data types (e.g., int, float) into objects. They are needed because some Java libraries and APIs require objects rather than primitive data types.

### 3. What is the difference between HashMap and HashTable?
Both are data structures used to store key-value pairs. However, HashMap is not synchronized and allows null values, while HashTable is synchronized and doesn't allow null values. Synchronized means
means it is thread-safe. Multiple threads can access and modify a HashTable concurrently without causing data corruption.

### 4. What is String pool in Java and why we need String pool?
String pool in Java is a pool of unique string objects. It is used to optimize memory usage by reusing common string values.
It is especially useful when working with a large number of String objects with the same content

### 5. What is Java garbage collection?
Java's garbage collection is an automated process where the JVM identifies and reclaims memory that is no longer in use by objects, helping to manage memory efficiently.

### 6. What are access modifiers and their scopes in Java? 
Access modifiers control the visibility and accessibility of classes, fields, and methods in Java. The four main modifiers are public, private, protected, and default.

### 7. What is final key word? (Filed, Method, Class)
final can be used with fields, methods, and classes. It indicates that the entity is unchangeable (constant). It prevents method overriding, field reassignment, and class extension.

### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
static can be used with fields, methods, and inner classes. It indicates that the entity belongs to the class rather than an instance. It's used for class-level members and utility methods.

### 9. What is the differences between overriding and overloading?
Overriding occurs in inheritance when a subclass provides a specific implementation for a method inherited from a superclass. Overloading involves having multiple methods in the same class with different parameter lists.

### 10. What is the differences between super and this?
super refers to the superclass or parent class. this refers to the current instance of the class.

### 11. What is the Java load sequence?
The Java class loading sequence involves loading, linking, and initialization. Classes are loaded when they are referenced, linked to resolve dependencies, and initialized when the class is first used.

### 12. What is Polymorphism ? And how Java implements it ? 
Polymorphism is the ability of objects of different types to be treated as objects of a common super type. In Java, it's achieved through method overriding and interfaces.
Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. The method signature (name, return type, and parameters) must be the same. This allows the subclass to provide its own behavior for the inherited method.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 
Encapsulation is the concept of wrapping data (fields) and methods into a single unit (class) while controlling access to the data through access modifiers. It enhances data security and maintains code integrity.
(Getter and Setter functions are good examples)

### 14. What is Interface and what is abstract class? What are the differences between them?
s: An interface is a contract that defines method signatures without implementation. An abstract class can have method implementations and cannot be instantiated directly. Interfaces support multiple inheritance, while classes do not.
1. Abstract can have constructor, interface can't have constructor
2. Abstract can implement abstract methods or concrete methods, but interface can only have abstract methods, unless default or static methods are used.
3. A class can extend only one abstract class, but a class can implement multiple interfaces. 
4. Abstract classes are typically used when you want to provide a common base class with some shared functionality among subclasses; Interfaces are used to achieve abstraction and define a common API for unrelated classes.


### 15. Please see the coding part

### 16. What are Queue interface implementations and what are the differences and when to use what?
There are multiple data type we can implement Queue interface. Most common are PriorityQueue and LinkedList.
1. java.util.LinkedList implements both the Queue and Deque interfaces. It allows elements to be added or removed from both ends. Useful when you need a general-purpose queue or deque.
2. java.util.PriorityQueue is an implementation of a priority queue. Elements are ordered based on their natural ordering (or a custom comparator). Useful when you need elements to be processed in a specific order, such as processing tasks with different priorities.

