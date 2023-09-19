1. Write up Example code to demonstrate the three foundamental concepts of OOP. (refrence Code Demo repo as example)

    1. Encapsulation;
       ```
       class BankAccount {
          private double balance;

          public BankAccount(double balance) {
             this.balance = balance;
          }
          
          public double getBalance() {
              return balance;
          }

          public void deposit(double amount) {
              if (amount > 0) {
                  balance += amount;
              }
          }

          public void withdraw(double amount) {
              if (amount > 0 && balance >= amount) {
                  balance -= amount;
              }
           }
        }
        ```
    2. Polymorphism;
       ```
       //Run-time
       class Animal {
          public void sound() {
             System.out.println("Animal makes a sound");
          }
       }

       class Dog extends Animal {
          @Override
          public void sound() {
             System.out.println("Dog barks");
          }
       }

       class Cat extends Animal {
          @Override
          public void sound() {
             System.out.println("Cat meows");
          }
       }
       ```
       ```
       //Compile-time
       class MathOperations {
          public int sum(int a, int b) {
             return a + b;
          }

          public int sum(int a, int b, int c) {
             return a + b + c;
          }
    
          public double sum(double a, double b) {
             return a + b;
          }
       }
       ```
    3. Inheritance;
       ```
       class Vehicle {
          public void start() {
             System.out.println("Vehicle starts");
          }
       }

       class Car extends Vehicle {
          @Override
          public void start() {
             System.out.println("Car starts with a key");
          }

          public void playMusic() {
             System.out.println("Playing car music");
          }
       }

       public class TestInheritance {
          public static void main(String[] args) {
             Car myCar = new Car();
             myCar.start();     
             myCar.playMusic();
          }
       }
       ```
       
2. What is **wrapper class** in Java and Why we need wrapper class?
   
    In Java, a wrapper class is a class that encapsulates a primitive data type (like int, char, double, etc.) into an object. The primitive data types are not objects, but sometimes they need to be used as if they were objects. This is where wrapper classes come into play.

    Why we need wrapper classes:
    - Object Representation: To use primitive data types as objects.

    - Collections: Java collections like ArrayList cannot store primitives, but they can store objects. For example, to store integers in an ArrayList, we use the Integer wrapper class.

    - Null Handling: Primitives cannot represent a null state, but their wrapper classes can.

    - Utilities: Wrapper classes provide utility methods to convert, compare, and perform other operations on the encapsulated primitive values.
   
3. What is the difference between **HashMap** and **HashTable**?
    
    1. Synchronization:
       - HashMap: Not synchronized. Multiple threads can access it concurrently. If such concurrent access is needed, external synchronization should be used.
       - Hashtable: Synchronized. Only one thread can access a table at a time, making it thread-safe by default.
       
    2. Null keys/values:
       - HashMap: Allows one null key and multiple null values.
       - Hashtable: Doesn't allow any null keys or null values.
       
    3. Performance:
       - HashMap: Generally faster because it's not synchronized.
       - Hashtable: Slower due to built-in synchronization.
       
    4. Inheritance:
       - HashMap: Extends the AbstractMap class.
       - Hashtable: Extends the Dictionary class.

    5. Iterators:
       - HashMap: Iterator of HashMap is fail-fast, which means it'll throw a ConcurrentModificationException if the map is modified while iterating.
       - Hashtable: Enumerator for the Hashtable is not fail-fast.

    6. Use:
       - HashMap: More commonly used in newer applications.
       - Hashtable: Considered legacy, and its use is discouraged in favor of ConcurrentHashMap for synchronized use cases or HashMap for unsynchronized ones.
    
4. What is **String pool** in Java and why we need String pool？
    
    In Java, the String pool is a special memory region inside the Heap memory where unique constant string values are stored. It primarily serves to optimize runtime memory usage.

    Why we need the String pool:
    - Memory Optimization: Reusing existing string literals ensures that no additional memory is wasted on duplicated values.
    - Speed: String operations like checking equality can be faster when identical strings are reference-equal due to them being the same object in memory.
    - Immutability: Strings are immutable in Java. Once a string is created in the pool, its value can't change, ensuring safe sharing of pooled string objects across the application without unexpected side-effects. 
    
5. What is Java **garbage collection**?
    
    Garbage collection in Java is the automatic process of identifying and reclaiming memory used by objects that are no longer reachable or needed by the application. This ensures that memory is used efficiently and prevents potential memory leaks.

    It includes:
    - Automatic Memory Management: Java handles memory deallocation automatically, so developers don't have to manually free unused objects.
    - Prevent Memory Leaks: Over time, unreclaimed memory could cause an application to slow down or crash. The garbage collector helps prevent this by freeing up memory.
    - Performance: While garbage collection automates memory management, it also introduces some overhead. Periodic garbage collection pauses can impact application performance, especially in systems requiring real-time responses.
    - Main Collectors: Java offers several garbage collectors, like the Serial Collector, Parallel Collector, CMS (Concurrent Mark-Sweep), and G1 (Garbage-First), each designed for specific use cases.
    
6. What are **access modifiers** and their scopes in Java?
    
    Access modifiers in Java determine the visibility or accessibility of a class, constructor, variable, method, or data member. There are four main access modifiers:

    1. private:
       
       Scope: Restricted within the same class only.
       
       Cannot be accessed from outside the class.
       
    2. default (no modifier):

       Scope: Within the same package.

       Can be accessed from any class within the same package. If a class or its members do not have any access modifier, it uses this one by default.
       
    3. protected:

       Scope: Within the same package and subclasses.

       Can be accessed within the same package and by subclasses, even if they are in different packages.

    4. public:

       Scope: Everywhere.

       Can be accessed from any class in any package.
  
7. What is **final** key word? (Field, Method, Class).
    
    1. final Field (or Variable):

       Once a variable is declared as final, its value cannot be modified. Essentially, it becomes a constant.
       
       For reference types, the reference itself cannot be changed to point to another object, but the object's internal state can still be modified (unless the object itself is immutable).
       
     2. final Method:

        A method declared as final cannot be overridden in a subclass. This is often done to prevent unintended behavior change in derived classes.

     3. final Class:

        A class declared as final cannot be subclassed. This is done to prevent inheritance, usually because the class's behavior should not be altered or because it's designed to be immutable.
    
8. What is **static** key word? (Field, Method, Class). When do we usually use it?
    
    1. static Field (or Variable):

       Belongs to the class and not to any specific instance. All instances of the class share the same static variable.

    2. static Method:

       Can be called without creating an instance of the class. Can only access static variables of the class and invoke static methods, not the non-static members.

    3. static Inner Class:

       An inner class that's marked static. It can exist independently of an instance of the outer class.
    
     When do we usually use it?

     - Singleton Pattern: When we want to ensure that a class has only one instance.
     - Utility Methods: For methods that don't depend on instance variables, like methods in the Math class or custom utility classes.
     - Shared Data among Instances: When we want to have a common property shared among all instances, like a counter.
     - Performance: Sometimes, using static methods might offer slight performance advantages because there's no need to access instance data.
     - Stateless Operations: When operations are stateless and don't rely on instance-specific data.
     - Constants: With the combination of static and final for defining constant values that are shared across instances. 
    
9. What is the differences between **overriding** and **overloading**?
    
    In Java, overriding refers to a scenario where a subclass provides its own specific implementation for a method that's already defined in its parent class. Essentially, it allows the subclass to inherit a method from its superclass and then modify or enhance it. The method in the subclass must have the same name, return type, and parameters as the method in the parent class.

    On the other hand, overloading happens within a single class, where you have multiple methods with the same name but with different parameters. These parameters can vary in type, order, or number. The return type doesn't distinguish overloaded methods; it's all about the parameter list. It's a way of offering the same functionality in various ways, depending on the type or number of inputs.

    Think of overriding as giving a fresh coat of paint to an old car you inherited, while overloading is like having multiple models of a car, each with different features or capacities. 
    
10. What is the differences between **super** and **this**?
    
     In Java, this is a reference to the current object, the instance we’re currently working with. It's often used to differentiate between class attributes and method parameters when they have the same name, or to call a constructor from another constructor within the same class.

    On the flip side, super is all about reaching out to parent class. It's used to call a constructor of the parent class or to access methods and attributes of the parent class that might have been overridden.
    
11. What is the Java **load sequence**?
    
    1. Loading the Class: The very first step is for the Java ClassLoader to load the bytecode of the class. At this stage, the JVM checks the bytecode, ensuring its structure is correct, and allocates memory for the class's static members.

    2. Initializing Superclasses: Before initializing the current class, Java makes sure any parent or superclass is loaded and initialized first. It's like ensuring the foundation of a building is solid before setting up the upper floors.

    3. Static Initializers and Blocks: Within a class, if there are any static blocks or static variable initializers, they're executed in the order they appear in the code. This ensures that any setup or preparation steps are done before the class's other parts become active.

    4. Constructor: Finally, if we’re creating an object of the class, the constructor runs after all the static parts are set. By the time the constructor executes, all the static components and superclass constructors have already done their part.
    
12. What is **Polymorphism**? And how Java implements it?
    
     It's a fundamental concept in object-oriented programming and one of its key pillars. At its core, polymorphism allows objects of different classes to be treated as objects of a common superclass. 
    
     1. Compile-Time Polymorphism (Method Overloading): 
     
        This happens when two or more methods in the same class have the same name but different parameters. It's determined at compile-time, not runtime. The return type doesn't play a role here; it's all about the method signature. So, we can have multiple methods named draw in a class, but they might take different parameters.

     2. Runtime Polymorphism (Method Overriding): 
       
        This is the more common form people refer to when talking about polymorphism. It's when a subclass provides a specific implementation for a method that's already defined in its parent class. At runtime, Java uses the object's actual class (not the reference type) to determine which version of the method to execute. So, if we have a Shape reference pointing to a Circle object and you call the draw method, Java will run the Circle class's draw method, if it's been overridden.
    
13. What is **Encapsulation**? How Java implements it? And why we need encapsulation?
    
     Encapsulation is a foundational concept in object-oriented programming. It's all about bundling data (attributes) and methods (functions) that operate on the data into a single unit, or class, and controlling the access to that data.
     
     Java provides access modifiers to help with encapsulation: private, protected, public, and package-private (default). By making an attribute private, we ensure that it cannot be accessed or modified directly from outside its class. Instead, we’d typically provide public methods (often known as getters and setters) to access or modify these private attributes. This way, the internal workings are hidden, and we have control over how external entities interact with the data.
     
     Why do we need Encapsulation?
     - Control: It gives us control over the data. For instance, using setters, we can validate data before setting an attribute.
     - Flexibility & Maintenance: We can change the internal implementation without affecting classes that use it. If we decide to change how we store the name in the Person class above, classes that use Person won't need to change as long as the getter and setter method signatures remain the same.
     - Increased Security: It protects the integrity of the data by only allowing it to be changed in well-defined ways.
     - Abstraction: Encapsulation helps in building a clear boundary between a class's internal workings and the way others see and use it, which is a step towards another OOP concept, abstraction.
    
14. What is **Interface** and what is **abstract class**? What are the differences between them?
    
     1. Interface:

        An interface is a pure abstraction in Java. It can only contain abstract methods (methods without bodies) and constants (public, static, final variables).

        An interface cannot be instantiated, meaning you can't create an object of an interface.

        A class can implement multiple interfaces, which helps Java get around the limitation of single inheritance.

        With Java 8 and later, interfaces can have default and static methods, allowing a limited form of method implementation.

     2. Abstract Class:

        An abstract class is a class that can't be instantiated and is meant to be subclassed. It can act as a template for its derived classes.

        Unlike interfaces, abstract classes can have both abstract (without implementation) and concrete (with implementation) methods.

        Abstract classes can have instance variables (state) and constructors, whereas interfaces can't.

        A class can extend only one abstract class, adhering to Java's single inheritance model.

     Differences:
     - Nature of Methods: Interfaces traditionally had only abstract methods, while abstract classes can have both. However, Java 8 introduced default and static methods in interfaces, slightly blurring this distinction.
     - State: Abstract classes can maintain state (have instance variables), while interfaces cannot.
     - Inheritance: A class can implement multiple interfaces but can inherit from only one abstract class.
     - Constructors: Abstract classes can have constructors, even though they can't be instantiated directly. Interfaces don't have constructors.
     - Access Modifiers: In an interface, all methods are implicitly public, and all fields are public, static, and final. In an abstract class, we have the flexibility to define access modifiers as we see fit.
    
15. Design a parking lot (put the code to **codingQuestions**/coding1 folder).
    
16. What are Queue interface implementations and what are the differences and when to use it?
    
     In Java, the Queue interface is part of the Java Collections Framework and represents a collection designed for holding elements prior to processing. Elements in a queue are typically processed in a First-In-First-Out (FIFO) manner, but not always.

     1. LinkedList:
        - Features: LinkedList is a doubly-linked list that implements both List and Queue interfaces.
        - When to Use: When we need a simple FIFO structure and might also require list-like capabilities.
        
     2. ArrayDeque:
        - Features: A resizable array that can function as a queue and a stack. It's typically faster than LinkedList for queue operations.
        - When to Use: When we need a double-ended queue (Deque) and don’t have null elements, as ArrayDeque doesn't allow nulls.

     3. PriorityQueue:
        - Features: It doesn’t order elements in FIFO manner but instead orders them according to their natural ordering or according to a comparator provided at queue construction time.
        - When to Use: When we need elements to be processed in a priority order.

     4. SynchronousQueue:
        - Features: Each insert operation must wait for a corresponding remove operation by another thread, and vice versa.
        - When to Use: In scenarios where handoff between threads is required, often used in thread pool implementations.

     5. LinkedBlockingQueue:
        - Features: A FIFO queue with size limits. It provides blocking operations, making it useful for producer-consumer scenarios.
        - When to Use: When we need a thread-safe queue that blocks when the queue is empty (during retrieval) or full (during storage).

     6. ArrayBlockingQueue:
        - Features: A bounded blocking queue backed by an array. It's very similar to LinkedBlockingQueue, but backed by an array.
        - When to Use: In multi-threaded scenarios where we prefer a pre-allocated, fixed-size structure.

     7. PriorityBlockingQueue:
        - Features: A thread-safe priority queue with unbounded concurrency.
        - When to Use: When we need a thread-safe priority queue and potential scalability for large numbers of concurrent operations.

     8. DelayQueue:
        - Features: A time-based scheduling queue. Only allows removal of elements when they're expired based on their delay time.
        - When to Use: For tasks that should be executed or processed after a certain delay.

     9. LinkedTransferQueue:
        - Features: A kind of hybrid between SynchronousQueue and LinkedBlockingQueue.
        - When to Use: In high-throughput scenarios where we need a scalable, thread-safe queue.
