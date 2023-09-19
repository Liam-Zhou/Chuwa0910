1.  Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo repo as example)  
- Encapsulation;
```java
class Student {
 private String name;
 private int age;

 public Student(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 public void displayStudentInfo() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}
public class Main {
 public static void main(String[] args) {
     // Encapsulation Example
     Student student = new Student("Alice", 20);
     student.displayStudentInfo();
 }
}
```
- Polymorphism;
```java
class Animal {
 public void makeSound() {
     System.out.println("Animal makes a sound");
 }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat() };
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
```
   - Inheritance;
```java
class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }
}
```
2.  What is wrapper class in Java and Why we need wrapper class?  
    A wrapper class is a wrap for primitive data type, like `Integer` to `int` and `Float` to `float`. The main reason we need this is that it convert primitive data type to a class, which provide with us multiple utility methods like `.toString()`. Besides, wrapper class can be used in advanced data structure like `Hashmap` and `ArrayList`. Wrapper class can be `null`, primitive data type can not.
3.  What is the difference between HashMap and HashTable?  
   They both store key-value pair. `HashMap` is not synchronized, is not thread-safe; `HashTable` is synchronized, is thread-safe by default. Thus, in a singe-thread program we should use `HashMap` for better performance, and use `HashTable` in a multi-thread program. Besides, `HashMap` allow one `null` in key and any `null` in value; `HashTable` does not support `null`.
4.  What is String pool in Java and why we need String pool?
    String pool is a special space in Java heap that store String. It is immutable, once created cannot be changed. Java use String pool to optimize memory usage and improve the efficiency. When you create a String that already in the String pool, Java will not create a new String but return the reference of the existed one. Also, when you compare two Strings, Java doesn't have to compare each character but the reference location. 
5.  What is Java garbage collection?
    Java GC is a process in Java where the JVM automatically manages memory by identifying and recycling memory that is no longer needed. When creating a object with `new`, JVM allocate memory on heap, and keep tracking the references number to this location. When no reference to it from a live (in-use) part of the program, it becomes garbage, and GC will recycle it. 
6.  What are access modifiers and their scopes in Java?  
    Access modifiers in Java are keywords that define the visibility and accessibility of classes, methods, variables, and other members of a Java class. They control which parts of a Java program can access these members and where they can be accessed from.   
    - `public`: any class or package. 
    - `protected`: within the same package and all the subclasses.
    - `private`: only within the same class.
    - Default(No access modifiers): only within the same package.
7.  What is **`final`** key word? (Filed, Method, Class)
    - Field: makes the field a constant.
    - Method: cannot be overridden by subclasses.
    - Class: the class cannot be inherited using `extends`.
8.  What is **`static`** keyword? (Filed, Method, Class). When do we usually use it?  
    - Field:  there will be only one instance of this field for every object of this class. Used when you want to share the same data among all instances. Use `static final` on constants.
    - Method: a method that is associated with the class itself, rather than with instances of the class. It can be called using the class name, without creating an object of the class. Used when this method is some Utils/helper method that do not interact with the instance-specific data.
    - Class: You can define a static nested class inside another class. It can be created by outer class's name and itself's name without a `new()`.
9.  What is the differences between overriding and overloading?  
    **Overload** happens inside one class at compile time. It defines a same function with different arguments, and return whatever types. All method can be overloaded. Mostly used to increase the readability of the code.  
    **Override** happens when one class inherited another. In subclass, you can rewrite a function that has same arguments and return type as the father class. Overriding happens at runtime. Private and final methods can not be overridden. Mostly used to provide a new implementation of the method that is already provided by its base class.
10.  What is the differences between super and this?  
     `this` is used to refer to the current instance and to distinguish between instance variables and parameters within a class.  
     `super` is used to access members of the superclass(parent class) and to invoke superclass constructors in a subclass.  
11.  What is the Java load sequence?  
    
12.  What is Polymorphism ? And how Java implements it ?
 Polymorphism is the ability for different objects to respond to the same method in different ways to their individual types. Java implements it with Overriding. Subclass can override Methods from their supper class when inheritance; also class can override Methods when they implement other interface.
13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?  
     Encapsulation is a way to avoid direct access to the data and only use according methods to get and change the data. Java implements it by using access modifiers `private` and `protected` on the data, and `public` on the method corresponding to it. We need encapsulation for data safety, code organization, and re-usability.
14.  What is Interface and what is abstract class? What are the differences between them?  
    Interface is a contract for unrelated classes to implement common behaviors. It doesn't contain constructor thus cannot be instantiated. Methods are abstract by default and must be implemented by implementing classes. It can be extended by other interface or implemented by a class.  
    Abstract class is a class that cannot be instantiated and can contain both abstract and concrete methods. Can be extended by other class. Child classes must implement all the abstract methods declared in the parent abstract class. 
    The difference between them are:  
        - Interface has no constructor, Abstract class has;
        - Methods in Interface are abstract by default, Abstract Class can have both abstract and concrete methods;
        - Interface supports multiple inheritance, while class can only be single inheritance;
        - Interface can only have `public static final` field, while abstract class can have more.
15.  design a parking lot (put the code to codingQuestions/coding1 folder). If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)   
        see `Coding/coding1`
16.  What are Queue interface implementations and what are the differences and when to use what?   
    There are `PriorityQueue`, `LiknedList`, and `ArrayDeque`.   
     `LiknedList` is the most basic queue, and it supports add and delete from both front and end in O(1) time.  
     `ArrayDeque` also supports add and delete from both ends in O(1), however typically more memory-efficient than `LiknedList`. Both `LiknedList` and `ArrayDeque` are thread-unsafe.
     `PriorityQueue` orders elements based on their nature or custom comparator, named priority. Elements with higher priority are dequeued first. Should be used when you need to deque element in certain order.