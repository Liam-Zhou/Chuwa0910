1.
Encapsulation
public class Person{
    private String name;
    private int age;
​
    public int getAge(){
      return age;
    }
​
    public String getName(){
      return name;
    }
​
    public void setAge(int age){
      this.age = age;
    }
​
    public void setName(String name){
      this.name = name;
    }
}

Polymorphism
public class Shape{
	public double area();
}
public class Circle extends shape{
	private double radius;
	public Circle(double radius){
		this.radius = radius;
	}
	@override
	public double area(){
		return Math.PI * radius * radius;
	}
}
public class Main{
	public static void main(String[] args){
		Shape circle = new Circle(5); 
		System.out.println("Area = " + circle.area());
	}
}

Inheritance
public class Vehicle {
    private String brand;
    public Vehicle(String brand) {
        this.brand = brand;
    }
    public void honk() {
        System.out.println(brand + " says honk!");
    }
}

public class Car extends Vehicle {
    private int doors;
    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }
    public void displayInfo() {
        System.out.println("This " + brand + " car has " + doors + " doors.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 4);
        myCar.honk();
        myCar.displayInfo();
    }
}

2.
A wrapper class in Java refers to one of the eight classes provided in the java.lang package to represent each of the eight primitive data types in Java in an object form. 

Byte for byte
Short for short
Integer for int
Long for long
Float for float
Double for double
Character for char
Boolean for boolean

Wrapper classes are fundamental in Java because they help a Java program be completely object-oriented. The primitive data types in java are not objects, by default. They need to be converted into objects using wrapper classes

3.
HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value

4.
string pool is kind of a "cache" area in the heap memory that sotres the recent use string, when the compiler encounters a string, it check the string pool first to see if the string is exist, it match, will return the reference of the existing string, else a new string will creat.
string pool can lead a efficient memory speed and security

5.
Java garbage collection is a process within the Java Virtual Machine (JVM) that automatically reclaims memory by identifying and disposing of objects that are no longer reachable or needed by the application. This process helps ensure efficient memory usage and reduces the risk of memory leaks

6.

Access modifiers in Java determine the visibility or accessibility of a class, constructor, variable, method, or inner class. By setting the access level, you can restrict the scope of a variable, method

7.
The final keyword is a modifier that can be applied to classes, methods, and variables. Once an entity (be it a class, method, or variable) is declared as final, its behavior or value cannot be modified further

8.
the static keyword is used to indicate that a particular member (field, method, or inner class) belongs to the type itself, rather than to instances of the type. 

9.
overloading is when two or more methods in the same class have the same name but different parameters.It allows a class to define multiple methods with the same name but with different parameter lists

class Main {
    void display(int a) {
        // code
    }

    void display(String s) {
        // code
    }

    void display(int a, String s) {
        // code
    }
}

overriding is when a subclass provides a specific implementation for a method that is already defined in its superclass.It allows a subclass to provide a specific behavior for a method, different from the superclass's implementation

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

10.
The super keyword can be used to invoke the parent class methods and constructors. It can also be used to access the fields of the parent class. The this keyword is used to represent the current instance of a class. It is used to access the instance variables and invoke current class methods and constructors.

11.
The static components (variables and blocks) are initialized and executed once when the class is first loaded, while instance components (variables, blocks, and constructors) are executed each time an instance of the class is created.

12.
polymorphism refers to the ability of a single function or method to work in different ways based on the object it's acting upon or, more broadly, the ability of different classes to be treated as instances of the same class through inheritance.
Java implement poly by Inheritance,overloading,orerridding,upcasting and interfaces.

13.
Encapsulation refers to the bundling of data (attributes) and methods (functions) that operate on the data into a single unit, often called a "class". Moreover, it restricts direct access to certain components of an object, ensuring that unwanted changes to attributes are prevented.
Java Implements Encapsulation by access modifiers, Constructors and Packages
Why we need Encapsulation: Encapsulation gives control over the data, makes it possible to change the internal implementation of class without affecting the class that use it, helps bundling the data and methods that operate on them into a single unit.

14.
An interface is a reference type in Java, similar to a class. It is a collection of abstract methods (methods without a body). It can also contain static methods, default methods, and static final variables (constants).

An abstract class is a class that cannot be instantiated on its own. It can have both abstract (without implementation) and non-abstract methods (with implementation).

Differences: Interfaces are a kind of code contract, which must be implemented by a concrete class. Abstract classes are similar to normal classes, with the difference that they can include abstract methods, which are methods without a body. Abstract classes cannot be instantiated

15.

LinkedList:

Implements both List and Queue interfaces.
Doubly-linked list implementation.
Supports insertion and removal of elements at both ends in constant time.
Use When: You need a doubly-linked list structure that can function as a queue and also requires the capabilities of a list (e.g., adding an element at a specific index).
ArrayDeque:

Resizable-array implementation.
Faster than LinkedList for queue operations.
Can be used as both a queue and a stack (double-ended queue).
Use When: You need a double-ended queue with fast and constant time operations for adding/removing at both ends, and you don't require the capabilities of a list.
PriorityQueue:

Elements are ordered according to their natural ordering or by a specified comparator.
Does not permit null values.
Implements a priority heap, meaning that the element with the lowest value (or highest priority) is at the head of the queue.
Use When: You want a queue where elements are processed based on priority rather than the order in which they were added.
ConcurrentLinkedQueue:

Thread-safe implementation.
Uses a non-blocking algorithm for its operations.
Suitable for highly concurrent environments.
Use When: You require a thread-safe queue and can tolerate that the exact state of the queue may change dynamically due to concurrent operations.
LinkedBlockingQueue:

Implements both Queue and BlockingQueue interfaces.
Capacity can be bounded or unbounded.
Supports blocking operations, which means operations can wait for the queue to become non-empty when retrieving an element or non-full when storing an element.
Use When: You are in a multi-threaded environment and need a thread-safe queue with blocking operations, typically in producer-consumer scenarios.
ArrayBlockingQueue:

A bounded blocking queue backed by an array.
Once created, the capacity cannot be increased.
Supports blocking operations similar to LinkedBlockingQueue.
Use When: You need a fixed-size, thread-safe queue with blocking capabilities.
PriorityBlockingQueue:

Extends PriorityQueue and implements the BlockingQueue interface.
Provides thread-safe operations with blocking capabilities.
Elements are ordered based on priority.
Use When: You require a priority queue that also supports concurrent operations and blocking functionalities.
SynchronousQueue:

Each insert operation must wait for a corresponding remove operation by another thread, and vice versa.
Essentially, it's a blocking queue with a capacity of zero.
Use When: You want direct handoffs between producing and consuming threads and don't need to store any elements inside the queue.



