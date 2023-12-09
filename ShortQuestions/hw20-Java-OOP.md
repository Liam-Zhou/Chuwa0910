# # Homework 2 (Hw20-springboot-RUD)

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

- 1. Encapsulation;

tips: use getter / setter instead of direct access

```
public class EncapClazz {
    private String id;

    public String getId() { return id; };

    public void setId(String id) { this.id = id; }
}
```

- 2. Polymorphism;

```
public class Shape {
    public double getArea() {
        return 0;
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this radius = radius;
    }
    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
}

// Client
Shape[] shapes = new Shapes[2];
shapes[0] = new Rectangle(1, 2);
shapes[1] = new Circle(3);
```

- 3. Inheritance;

```
public interface Vehicle {
    static void clean() {
        System.out.println("clean vehicle");
    }
}

// another file
public Car implements Vehicle {
    @Override
    public clean() {
        System.out.println("clean car");
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?

- when the program demands working with an object instead of a primitive data type (object-oriented)
- Function: convert from primitive to object and from object to primitive data type

## 3. What is the difference between HashMap and HashTable?

- HashMap is non-sychronized. It's not thread safe and can't be shared between many threads whereas Hashtable is sychronized.
- HashMap allows one null key and multiple null values whereas Hashtable doesn't allow any null key or null value.

## 4. What is String pool in Java and why we need String pool?

- Difinition: a storage area in Java heap where all string stored in there
- Function: decrease the number of string objects created in the memory

## 5. What is Java garbage collection?

- Java programs perform automatic memory management. When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to free up memory.
  - Reference counting
  - Mark-and-Sweep
  - Stop-and-Copy

## 6. What are access modifiers and their scopes in Java?

|                                | Public | Protected | Default | Private |
| ------------------------------ | ------ | --------- | ------- | ------- |
| Same Class                     | Yes    | Yes       | Yes     | Yes     |
| Same Package Subclass          | Yes    | Yes       | Yes     | No      |
| Same Package Non-Subclass      | Yes    | Yes       | Yes     | No      |
| Different Package Subclass     | Yes    | Yes       | No      | No      |
| Different Package Non-Subclass | Yes    | No        | No      | No      |

- Public: everywhere
- Protected: package or all subclasses
- Default: within the package
- Private: within the class only

## 7. What is final key word? (Filed, Method, Class)

- final variable: constants
- final method: prevent override
- final class: prevent inheritance and make it immutable

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

- static variable / block: only one instance
- static Method: can be directly called by Class name
- static class：cannot contain an instance constructor. However, they can contain a static constructor.

## 9. What is the differences between overriding and overloading?

- Overloading: diff num of arguments, diff type arguments, same method name
- Overriding: the derived classes give their own specific implementations to inherited methods without modifying the parent class methods

## 10. What is the differences between super and this?

- super: parent class
- this: current class

## 11. What is the Java load sequence?

static variable/block -> constructor

## 12. What is Polymorphism ? And how Java implements it ?

Polymorphism: the same object exhibiting different forms and behaviors

- Static Polymorphism - Overload(same class) - compile time
- Dynamic Polymorphism - Override(child class) - run time

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation: binding the data and the methods to manipulate that data together in a single unit(class)

Implemented Way: use getter/setter instead of direct access

Function: restrict the direct access to specific method/variable to make instance private

## 14. What is Interface and what is abstract class? What are the differences between them?

Interface: a completely "abstract class" that is used to group related methods with empty bodies

Abstract Class: a restricted class that cannot be used to create objects

Differences:

- Method Type: Interface can have only abstract methods. Whereas, an abstract class can have abstract method and concrete methods.
- Final Variables: Variables declared in a Java interface are by default final. An abstract class can contain non-final variables.
- Inheritance Key Words: Interface's inheritance key word is "implements" whereas Abstract Class is "extend"
- One class can "implements" multiple interfaces whereas only can "extend" one abstract class

## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )

## 16. What are Queue interface implementations and what are the differences and when to use what?

The Queue interface is implemented by several ways in Java, including LinkedList, ArrayDeque, and PriorityQueue.

Difference between each way: ArrayDeque is faster than LinkedList on average because of overhead. And since there is no need for adding an element in the middle of a queue, so ArrayDeque is better than LinkedList.
