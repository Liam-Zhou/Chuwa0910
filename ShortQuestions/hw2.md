# HW2. Xiao Yang
### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
1. **Encapsulation**;
```
class Person{
  private int age;
  private String birthday;

  public void setAge(int val){
    this.age = val;
  }

  public void setBirthday(String dob){
    this.birthday = dob;
  }

  public int getAge(){
    return this.age;
  }

  public String getBirthday(){
    return this.birthday;
  }
}
```

In this simple example, the fields "age" and "birthday" have been encapsulated, which means that when outer wants to get or revise these fields, it has to call get or set methods other than directly get them by "obj.age" or "obj.birthday". 

2. **Polymorphism**;

- `Static overload` 
```
public int addNumber(int a, int b){
    return a + b;
}

public double addNumber(double a, double b){
    return a + b;
}
```
- `Dynamic override`
```
class Student extends Person{
    @override
    public int getAge(){
        System.out.println("Student");
        return this.age;
    }
}
```
3. **Inheritance**;
```
class Student extends Person{
    
}

Person obj = new Student();
obj.getAge()  // return this.age;
obj.getBirthday() // return this.birthday.
```

### 2. What is wrapper class in Java and Why we need wrapper class?
- Wrapper class encloses around data type and gives it an object appearance. 
In other words, wrapper class can be used to convert any data type into an object.
- They convert primitive data types into objects. Objects are needed if we wish to modify the arguments passed into a method (because primitive types are passed by value).
The classes in java.util package handles only objects and hence wrapper classes help in this case also.
Data structures in the Collection framework, such as ArrayList and Vector, store only objects (reference types) and not primitive types.
An object is needed to support synchronization in multithreading.

### 3. What is the difference between HashMap and HashTable?

- HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
- HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
- HashMap is generally preferred over HashTable if thread synchronization is not needed.

### 4. What is String pool in Java and why we need String pool?
String pool is a storage space in the Java heap memory where string literals are stored.
String pool decreases the number of String objects created in the JVM, thereby reducing memory load and improving performance.

### 5. What is Java garbage collection?
Garbage collection in Java is the automated process of deleting code that's no longer needed or used. 
This automatically frees up memory space and ideally makes coding Java apps easier for developers.


### 6. What are access modifiers and their scopes in Java?
Access modifiers in Java are the keywords that are used for controlling the use of the methods, constructors, fields, and methods in a class.

![img.png](img.png)

### 7. What is final key word? (Filed, Method, Class)
the final keyword in a method declaration to indicate that the method cannot be overridden by subclasses.
`Final Variable` to create constant variable.
`Final Methods` to prevent Method overriding, this is useful for methods that are part of a class’s public API and should not be modified by subclasses.
`Final Classes` to prevent inheritance, this is useful for classes that are intended to be used as is and should not be modified or extended.
### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
The keyword static means that the particular member belongs to a type itself, rather than to an instance of that type.
This means we’ll create only one instance of that static member that’s shared across all instances of the class.
`static varibles` same copy for every object of this class that we instantiate. 
`static methods` Similar to static fields, static methods also belong to a class instead of an object. So, we can call them without creating the object of the class in which they reside.
`static class` Basically, a static nested class doesn’t have access to any instance members of the enclosing outer class. It can only access them through an object’s reference.
static nested classes can access all static members of the enclosing class, including private ones.
Java programming specification doesn’t allow us to declare the top-level class as static. Only classes within the classes (nested classes) can be made as static.
### 9. What is the differences between overriding and overloading?
![img_1.png](img_1.png)

### 10. What is the differences between super and this?
`super` is used to call the base class methods or variables, while `this` is used for current instance of the class.
`this` can be referred to from a static context. It means it can be invoked from the static context, while `super` can not.

### 11.  What is the Java load sequence?
Java follows a dynamic class loading mechanism to ensure that classes are loaded into memory only when they are needed. The class loading sequence typically involves several steps:
- **Loading**: During this phase, the class loader loads the bytecode of a class into memory.
- **Linking**: Linking is the process of combining the loaded class with other classes and resources it depends on.
- **Initialization**: During this phase, the static initializers (static blocks) of the class are executed. Static fields are initialized with their assigned values. This phase occurs only once per class, typically when the class is first accessed or instantiated.
### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. It enables you to write more generic and flexible code by allowing you to work with objects in a more abstract way, without needing to know their specific types.
Polymorphism is achieved through method `overriding` and method `overloading` in Java.
### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is the concept of bundling variables and methods that operate on that variables into a single unit called a class. In encapsulation, the internal state of an object is hidden from the outside world, and access to that state is controlled through well-defined methods. This allows for better control over the behavior of objects and helps maintain the integrity and consistency of data.
In Java, encapsulation is implemented using access modifiers and getters and setters to control access to the variables of a class.
### 14. What is Interface and what is abstract class? What are the differences between them?
An `interface` in Java is a blueprint of a class that defines a set of abstract methods that any class implementing the interface must provide concrete implementations for.
An `abstract` class in Java is a class that cannot be instantiated on its own and may contain a mix of abstract methods and concrete (implemented) methods.

Key Differences:

- **Multiple Inheritance**: Interfaces support multiple inheritance (a class can implement multiple interfaces), while abstract classes support single inheritance (a class can extend only one abstract class).

- **Method Definitions**: All methods in an interface are implicitly abstract and must be implemented by implementing classes. Abstract classes can have a mix of abstract and concrete methods.

- **Constructor**: Abstract classes can have constructors, while interfaces cannot.

- **Fields**: Abstract classes can have instance variables (fields) with various access modifiers, whereas fields in interfaces are implicitly public, static, and final.

- **Purpose**: Interfaces are typically used to define contracts that multiple unrelated classes can adhere to, promoting code flexibility and polymorphism. Abstract classes are used to provide a common base for related classes, sharing common functionality while allowing for extension.
### 15. Design a parking lot (put the code to codingQuestions/coding1 folder)
see details 

### 16. What are Queue interface implementations and what are the differences and when to use what?

In Java, the `Queue` interface is part of the Java Collections Framework and defines a standard set of methods for working with a queue data structure. A queue is a linear data structure that follows the First-In-First-Out (FIFO) order, where the element that is added first is the one that is removed first. The Queue interface does not have concrete implementations, but there are several classes in Java that implement it.
- LinkedList
- PriorityQueue
- ArrayDeque
- ConcurrentLinkedQueue
- LinkedBlockingQueue
- ArrayBlockingQueue

_When to Use What:_

Use `LinkedList` when you need a simple, general-purpose queue, or if you want to implement a double-ended queue (Deque).

Use `PriorityQueue` when you need to process elements based on their priority.

Use `ArrayDeque` when you need a versatile queue that supports fast insertions and removals from both ends.

Use `ConcurrentLinkedQueue` when you require thread-safe queue operations in a multi-threaded environment.

Use `LinkedBlockingQueue` or `ArrayBlockingQueue` when implementing producer-consumer scenarios in multi-threaded applications, and you need to control the capacity of the queue.