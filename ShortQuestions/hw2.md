## 1.	Write up Example code to demonstrate the three foundmental concepts of OOP. ##

*	### `Encapsulation`

![encapsulation](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/67e4ed32-11cb-43c2-a493-2ecc3a31376c)

* ###	`Polymorphism`
   
![polymorphism](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/3a4e85e6-6868-4f1e-a566-fc323190a1f3)

* ###	`Inheritance`

![inheritance](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/012aaded-9bb1-4c1e-948d-b2d612955f2f)

## 2.	What is wrapper class in Java and Why we need wrapper class?  ##

The wrapper classes in Java are used to convert primitive types (int, char, float, etc) into corresponding objects.

Example: <br>
`Integer myInt = new Integer(42);` // Creating an Integer object <br>
`int primitiveInt = myInt.intValue();` // Converting Integer to int <br>

* They allow us to treat primitive data types as objects.
* They provide a way to perform operations on primitive data types, such as comparison and sorting.
* They provide a way to encapsulate the value of a primitive data type.

The following are the wrapper classes in Java:

* Boolean
* Byte
* Character
* Double
* Float
* Integer
* Long
* Short

## 3. What is the difference between HashMap and HashTable? ##

HashMap and Hashtable are both Map implementations in Java. They store key-value pairs. The main difference between HashMap and Hashtable is that HashMap is non-synchronized, while Hashtable is synchronized. This means that HashMap is not thread-safe, while Hashtable is thread-safe. 
HashMap allows null keys and values, while Hashtable does not. Due to synchronization, Hashtable may be slower than HashMap.

## 4. What is String pool in Java and why we need String pool? ##

The String pool is a memory area in the Java heap where all the literal strings are stored. This means that if you create two String objects with the same value, they will share the same instance in the String pool.

The String pool is used to improve the performance of string operations. When you create a new String object, the Java compiler first checks if the string already exists in the String pool. If it does, the compiler simply returns the reference to the existing string object. 
This avoids the need to create a new string object and copy the string data, which can be a time-consuming operation.

## 5. What is Java garbage collection? ##

Java garbage collection is the process of automatically deallocating memory that is no longer being used by your program. This frees up memory for your program to use for other tasks.

Garbage collection is a very important feature of Java. It allows you to focus on writing your program without having to worry about memory management.

## 6. What are access modifiers and their scopes in Java?

Access modifiers are keywords that control the accessibility of classes, methods, and variables. There are four access modifiers in Java:

public: accessible from anywhere
protected: accessible within the same package and subclasses
private: accessible only within the same class
default: accessible within the same package
The scope of an access modifier is the area in which the entity it is applied to can be accessed. For example, a public class can be accessed from anywhere, while a private variable can only be accessed within the same class.

## 7. What is final keyword? (Filed, Method, Class)

The final keyword is used to prevent a class, method, or variable from being modified.

A final class cannot be subclassed.
A final method cannot be overridden.
A final variable cannot be assigned a new value.
The final keyword can be used to improve the performance of your program and to prevent errors.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

The static keyword is used to define variables and methods that are shared by all instances of a class.

A static field is a field that is associated with the class itself, not with any particular instance of the class.
A static method is a method that can be called without creating an instance of the class.
A static class is a class that cannot be instantiated.
The static keyword is used when you want to share a variable or method among all instances of a class. For example, you can use a static variable to count the number of objects that have been created of a particular class.

## 9. What is the differences between overriding and overloading?

Overriding and overloading are two ways to create methods with the same name in a class.

Overriding occurs when a subclass defines a method with the same name and signature as a method in its superclass

## 10. What is the differences between super and this?

The super keyword refers to the superclass of the current class, while the this keyword refers to the current class.

The super keyword can be used to access the members of the superclass, such as its methods and variables. It can also be used to call the constructors of the superclass.

The this keyword can be used to access the members of the current class, such as its methods and variables. It can also be used to refer to the current object.

## 11. What is the Java load sequence?

The Java load sequence is the order in which Java classes are loaded into memory. The load sequence is as follows:

The Java class loader loads the class file into memory.
The Java compiler verifies the class file.
The Java interpreter executes the class file.
The Java load sequence is important because it ensures that all of the classes that a class depends on are loaded into memory before the class is executed.

## 12. What is Polymorphism ? And how Java implements it ?

Polymorphism is the ability of an object to take on different forms. In Java, polymorphism is implemented through inheritance and overloading.

Inheritance allows a subclass to inherit the methods and variables of its superclass. This means that a subclass can override the methods of its superclass and provide its own implementation.

Overloading allows a class to have multiple methods with the same name, but different signatures. This means that the method can be called with different arguments.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is the hiding of the implementation details of a class from the outside world. In Java, encapsulation is implemented through access modifiers.

Access modifiers control the accessibility of classes, methods, and variables. There are four access modifiers in Java:

public: accessible from anywhere
protected: accessible within the same package and subclasses
private: accessible only within the same class
default: accessible within the same package
Encapsulation is important because it helps to protect the data of a class from unauthorized access. It also helps to make the code more readable and maintainable.

## 14. What is Interface and what is abstract class? What are the differences between them?

An interface is a blueprint for a class. It defines the methods that a class must implement, but it does not provide any implementation for those methods.

An abstract class is a class that cannot be instantiated. It can only be extended by other classes.

The main difference between an interface and an abstract class is that an interface cannot have any fields, while an abstract class can have fields.

## 15. What are Queue interface implementations and what are the differences and when to use what?

In Java, the Queue interface represents a linear data structure for elements that follow the First-In-First-Out (FIFO) order. 

Here are the queue interface implementations in Java and their differences:

* LinkedList: This is the most commonly used queue implementation. It is a doubly linked list, which means that each node in the list has pointers to the previous and next nodes. This makes it easy to insert and remove elements from the queue.
* ArrayDeque: This is another queue implementation that is based on an array. It is a dynamic array, which means that it can grow and shrink as needed. This makes it a good choice for queues that need to be able to grow or shrink frequently.
* PriorityQueue: This is a queue implementation that orders the elements according to a priority. The element with the highest priority is always at the front of the queue. This makes it a good choice for queues where the order of the elements is important.
* LinkedBlockingQueue: This is a queue implementation that is thread-safe. This means that it can be accessed by multiple threads at the same time without causing conflicts. This makes it a good choice for queues that are accessed by multiple threads.
* ArrayBlockingQueue: This is another thread-safe queue implementation. It is based on an array, which makes it a good choice for queues that need to be able to grow or shrink frequently.

The choice of which queue implementation to use depends on the specific requirements of your application. If you need a queue that is easy to insert and remove elements from, then LinkedList is a good choice. 
If you need a queue that can grow or shrink frequently, then ArrayDeque is a good choice. If you need a queue where the order of the elements is important, then PriorityQueue is a good choice. 
If you need a queue that is accessed by multiple threads, then LinkedBlockingQueue or ArrayBlockingQueue are good choices.
