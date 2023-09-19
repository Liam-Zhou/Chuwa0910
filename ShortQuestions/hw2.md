# Java Concepts and Code Examples

In this repository, you will find detailed answers to common Java interview questions as well as coding examples demonstrating key object-oriented programming (OOP) concepts.

## Topics Covered

- Object-Oriented Programming (OOP) fundamental concepts 
- Wrapper class in Java 
- Differences between HashMap and Hashtable 
- The Java String pool 
- Java garbage collection 
- Access modifiers in Java 
- The `final` keyword in Java 
- The `static` keyword in Java 
- Method overriding vs overloading in Java 
- The `super` and `this` keywords in Java 
- The Java class loading sequence 
- Polymorphism in Java 
- Encapsulation in Java 
- Interfaces and abstract classes in Java 
- Designing a parking lot system 
- Queue interface implementations in Java 

### 1. OOP Fundamental Concepts

See the `/codingQuestions` folder for code examples demonstrating the three fundamental OOP concepts:
- Encapsulation
- Polymorphism
- Inheritance

### 2. Wrapper Class in Java

    wrapper class is a class that encapsulates a primitive data type within an Object:
    byte - Byte
    short - Short
    int - Integer
    long - Long
    float - Float
    double - Double
    char - Character
    boolean - Boolean

    OOP feature, warapper class allow us use it as object.

### 3. HashMap vs Hashtable

-HashMap is non-synchronization, which means its not thread safe. Hashtable is synchronization, which means is safe thread.
-HashMap could provide better performance cause non-synchronization. HashTable provide worse performance then HashMap cause its synchronization.
-HashMap allows one null key and multiple null values, HashTable does not allow any null key and values.

### 4. String Pool in Java

-In Java, string pool is a special stroage area in heap memory to store the String.
    String Pool helps save memory and potentially increase performance by reusing immutable String instances.

### 5. Java Garbage Collection

Java garbage is a process within JVM that could deallocates memory that is no longer use, its could help us reclaim memory and avoid pential memory leak.

### 6. Access Modifiers in Java

There are various access modifiers in Java, including:
-   Private:
        Scope: Within the same class only.
        Usage: When you want to restrict the access to a member to the current class only.
        Keyword: private

-   Default(Package-Private):
        Scope: Within the same package only (if no access modifier is specified, it's considered to have package-private access).
        Usage: When you want to allow access to members for classes that are in the same package.
        Keyword: No keyword is used.
    
-   Protected:
        Scope: Within the same package and also available to any subclasses, including those in different packages.
        Usage: When you want to allow access to members in classes that are either in the same package or are subclasses, potentially in different packages.
        Keyword: protected

-   Public:
        Scope: Everywhere, including in different packages.
        Usage: When you want to allow unrestricted access to a member from any class and any package.
        Keyword: public

### 7. The `final` Keyword in Java

The `final` keyword can be applied in various contexts:
- In filed: Declear variable as immutable, its can not change once variable initialized.
- In method: Once declear as final, subclass can not override.
- In class: its can not be subclassed.

### 8. The `static` Keyword in Java

The `static` keyword can be applied to:
- Filed: The static variable shared among in all instance. Usually used for properties that should be common to all objects of a class. 
- Method: Static methods can access static data members and static data methods directly. Usually used for method that related to class as whole, no need to access any instance.
- Class: Inner static class, the nested static class can access all static data members of the outer class. Usually used when inner class just used by outer class.


### 9. Overriding vs Overloading

    - Static Polymorphism - Overload (same class) - compile time.
    - Dynamic Polymorphism - Override (child class) - run time.
    - Constructor: Constructors can be overloaded but not overridden.
    - Dynamic Dispatch: Method overriding is a runtime phenomenon (dynamic dispatch), while method overloading is a compile-time phenomenon.


### 10. `super` vs `this` in Java

'this' is a reference to the current object — the object whose method or constructor is being called. 'super' is used to call methods and access variables defined in the superclass. Inside constructors, 'this' can be used to call another constructor in the same class. 'super' can be used to call a constructor in the superclass.


### 11. Java Load Sequence

The Java load sequence involves the following steps:
- Loading
- Initialization
- Loading of Superclass
- Loading of subclass
- Main method execution

### 12. Polymorphism in Java

    There are two different type of Polymorphism:
        Static Polymorphism - Overload (same class) - compile time.
        Dynamic Polymorphism - Override (child class) - run time.

### 13. Encapsulation in Java

    Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in asingle unit (class). 
    Java leverages encapsulation primarily through access modifiers and getter and setter methods.
    We use encapsulation cause it provides a way to protect the object's integrity by restricting unauthorized access and modification to its components, and use it also could increase security.

### 14. Interface and Abstract Class in Java
    
    Interface: It provides a way to achieve abstraction and multiple inheritances in Java.    
    Abstract: An abstract class in Java is a class that cannot be instantiated and can have abstract and non-abstract methods.


    1. Instantiation:
        Interface: Cannot be instantiated.
        Abstract Class: Cannot be instantiated.
    2. Inheritance:
        Interface: A class can implement multiple interfaces, achieving a form of multiple inheritances.
        Abstract Class: A class can extend only one abstract class due to single inheritance in Java.
    3. Access Modifiers:
        Interface: Methods are implicitly public.
        Abstract Class: Methods can have any access modifier.

### 15. Parking Lot Design

See the `codingQuestions/coding1` folder for a coding example demonstrating how to design a parking lot system.

### 16. Queue Interface Implementations in Java

    1. LinkedList
        Queue<Integer> queue = new LinkedList<>();
        Properties:
            Implements List and Deque interfaces besides Queue.
            Internally uses a doubly-linked list.
            Allows null elements.
        Use cases:
            Use when you need a FIFO queue with the ability to easily add/remove elements at both ends.
            Suitable for a queue with a variable size.

    2. ArrayDeque
        Queue<Integer> queue = new ArrayDeque<>();
        Properties:
            Implements Deque interface.
            Internally uses a resizable array.
            Faster than LinkedList for queue operations.
            Does not allow null elements.
        Use cases:
            Ideal for a stack or a deque (double-ended queue) when you don't require capacity-restricted deques.
            Generally faster than LinkedList for queue operations.

    3. PriorityQueue
        Queue<Integer> queue = new PriorityQueue<>();
        Properties:
            Does not guarantee the order of iteration.
            The head of this queue is the least element with respect to the specified ordering.
            to prioritize elements based on their natural ordering or a custom comparator.
            Does not allow null elements.
        Use cases:
            Use when you need a priority queue which orders the elements according to their natural ordering or a custom comparator.
            Suitable for algorithms like Dijkstra's where priority of elements matter.