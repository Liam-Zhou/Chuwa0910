# hw2 Difan Xue

1. Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo repo as example)

### Encapsulation

```markdown
public class EncapTest{
 
   private String name;
   private String idNum;
   private int age;
 
   public int getAge(){
      return age;
   }
 
   public String getName(){
      return name;
   }
 
   public String getIdNum(){
      return idNum;
   }
 
   public void setAge( int newAge){
      age = newAge;
   }
 
   public void setName(String newName){
      name = newName;
   }
 
   public void setIdNum( String newId){
      idNum = newId;
   }
}
```

Polymorphism

```markdown
class Shape {
    void draw() {}
}
 
class Circle extends Shape {
    void draw() {
        System.out.println("Circle.draw()");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Square.draw()");
    }
}
```

Inheritance

```markdown
public class Animal { 
    private String name;  
    private int id; 
    public Animal(String myName, int myid) { 
        name = myName; 
        id = myid;
    } 
    public void eat(){ 
        System.out.println(name+"eat"); 
    }
}
public class Penguin extends Animal { 
    public Penguin(String myName, int myid) { 
        super(myName, myid); 
    } 
}
```

2. What is wrapper class in Java and Why we need wrapper class?

A wrapper class is a class that allows you to convert a primitive data type into an object and vice versa. Wrapper classes can represent null values. They provide methods to convert between primitive data types and their corresponding objects.
3. What is the difference between HashMap and HashTable?
HashMap: initial capacity is 16; allows one null key and multiple null values; not synchronized

HashTable: initial capacity is 11; not allow null keys or values; synchronized
4. What is String pool in Java and why we need String pool?

It is a special memory area where string literals are stored.
It can save memory by reusing common string values and etrieval is faster than creating new string objects.
5. What is Java garbage collection?
Java Garbage Collection is an automatic memory management process in the Java Virtual Machine (JVM) that automatically reclaims memory occupied by objects that are no longer referenced or needed by the program. Objects that are not reachable from the root of the application are considered garbage. The garbage collector identifies these objects and reclaims their memory, making it available for future allocations.
6. What are access modifiers and their scopes in Java?
Default, private, public, protected
7. What is final key word? (Filed, Method, Class)
Variable: to define constants

Method: prevent overrider

Class: prevent inheritance, make calss immutable
8. What is static keyword? (Filed, Method, Class). When do we usually use it?
It is used to define a member (field, method, or nested class) that belongs to the class itself, rather than to any specific instance of the class. After compiling, the static variable has been in the memory, not necessarily to new one.

9. What is the differences between overriding and overloading?
Overriding:happens at runtime; less performance because the binding is being done at run time; Private and final methods can NOT be overridden; Return type of method must be the same in the case of overriding.

Overloading: happens at compile time; better performance because the binding is being done at compile time; Private and final methods can be overloaded; Return type of method does not matter in case of method overloading
10. What is the differences between **super** and **this**?
Super: refers to the superclass and is used to access members of the superclass, call superclass constructors, or resolve ambiguity when there are members with the same name in both the superclass and subclass.

This: refers to the current instance of the class and is used to access or modify instance-specific members (fields and methods) of the current object.
11. What is the Java **load sequence**?
It load static variable or block before the constructor.
12. What is **Polymorphism** ? And how Java implements it?
It refers to the ability of objects of different classes to be treated as objects of a common superclass. It is is implemented through method overriding and method overloading.
13. What is **Encapsulation** ? How Java implements it? And why we need encapsulation?
It refers to the concept of bundling data (attributes or fields) and the methods (functions or procedures) that operate on that data into a single unit called a class.
14. What is **Interface** and what is **abstract** class? What are the differences between them?

Interface: a class that defines a set of abstract methods (methods without implementations) that must be implemented by any class that implements the interface.

Abstract:lass that cannot be instantiated (you cannot create objects of an abstract class) and may contain a mix of abstract (unimplemented) and concrete (implemented) methods.

Difference: In the interface, all methods are abstract by default and must be implemented by classes that implement the interface. In the abstract, we only need the methods and subclasses that override.
15. design a parking lot

16. What are Queue interface implementations and what are the differences and when to use what?

LinkedList: a doubly linked list-based implementation; for general use

ArrayDeque: resizable-array implementation; for high-performance queue

PriorityQueue: stores elements based on their natural order (or a specified comparator); for sorting the items