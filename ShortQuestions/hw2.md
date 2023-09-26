### 1.Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
1. Encapsulation;
```bash
public class Person {
    private String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```
2. Polymorphism;
```bash
abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return 3.14 * radius * radius; }
}

class Square extends Shape {
    private double side;
    public Square(double side) { this.side = side; }
    public double area() { return side * side; }
}

```
3. Inheritance;
```bash
class Animal {
    void eat() { System.out.println("Eating..."); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking..."); }
}

```

### 2.What is wrapper class in Java and Why we need wrapper class?
Wrapper classes in Java provide a way to use primitive data types as objects.
They are used for: converting primitives to objects, converting strings to primitives and vice versa, for use in collection classes, etc. 
Examples include Integer, Character, Double.

### 3.What is the difference between HashMap and HashTable?
HashMap is non-synchronized whereas Hashtable is synchronized.
HashMap allows one null key and multiple null values, whereas Hashtable doesn't allow any null key or value.

### 4.What is String pool in Java and why we need String pool?
String pool is a special storage area in the heap memory where strings are stored. 
We need the String pool because it helps in saving memory as strings are reused.

### 5.What is Java garbage collection?
It is a process in Java's memory management system which automatically deletes objects that are no longer reachable in the application, freeing up memory.

### 6.What are access modifiers and their scopes in Java? 
They determine the visibility of a class, constructor, method, or field.
* private: accessible within the class only.
* default (no modifier): accessible within the package.
* protected: accessible within the package and outside the package through inheritance.
* public: accessible from any other class.

### 7.What is final key word? (Filed, Method, Class）
* Field: Value can't be modified.
* Method: Can't be overridden.
* Class: Can't be inherited.

### 8.What is static keyword? (Filed, Method, Class). When do we usually use it？
* Field: Belongs to the class rather than the object.
* Method: Belongs to the class and can't access non-static members.
* Class: Static nested class.
* It's typically used for constants, utility methods, or nested static classes.

### 9.What is the differences between overriding and overloading?
Overriding is when a child class provides a specific implementation for a method that is already provided by its parent class. 
Overloading is when a single class has multiple methods with the same name but different parameters.

### 10.What is the differences between super and this?
‘super’ refers to the parent class instance, and is used to call the parent class's methods or constructors. 
‘this’ refers to the current class instance and is used to call the current class's methods or constructors.

### 11.What is the Java load sequence?
The typical load sequence is static blocks/variables → instance variables → constructors.

### 12.What is Polymorphism ? And how Java implements it ?
It allows objects to be treated as instances of their parent class rather than their actual class. 
Java implements it using method overriding.

### 13.What is Encapsulation ? How Java implements it? And why we need encapsulation?
It's the wrapping up of data and methods into a single unit (class). 
Java implements it using private variables and public methods.

### 14.What is Interface and what is abstract class? What are the differences between them?
* Interface: Can't have implementation of methods (until Java 8 introduced default methods). All methods are public. Variables are public, static, and final.
* Abstract Class: Can have both abstract and concrete methods. Can have access modifiers.

### 16.What are Queue interface implementations and what are the differences and when to use what?
There are several kinds: LinkedList, PriorityQueue, ArrayDeque, ConcurrentLinkedQueue...
Choose based on requirements: FIFO order, thread safety, priority-based retrieval, or advanced thread coordination.
The choice of queue implementation greatly depends on the specific use case:
* For simple FIFO operations without a need for thread-safety, ArrayDeque is usually the best choice due to its efficiency.
* For a thread-safe FIFO operation, consider ConcurrentLinkedQueue or LinkedBlockingQueue.
* When order of processing matters (priority-based), PriorityQueue is the way to go.
* For advanced thread coordination, you might choose specialized queues like SynchronousQueue or LinkedTransferQueue.
