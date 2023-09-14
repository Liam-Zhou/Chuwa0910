# HW2- Ke Chen

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP.(reference Code Demo repo as example))

```
public class Main {
    public static void main(String[] args) {

        // test the encapsulation + polymorphism
        Animal animal = new Animal("Lili", 2);
        System.out.println(animal.getName());
        Animal animal2 = new Animal("Lili", 2, "Mike");
        System.out.println(animal2.getName());

        // test the inheritance
        Animal animal3 = new Dog("Coco", 3);
        animal3.outPut();
    }

}

class Animal{

    // Encapsulation step1:
    // Use the private access modifier to declare all variables/fields of class as private.
    private String name;
    private int age;
    private String hostName;

    // Polymorphism : use 2 constructors with different signatures
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Animal(String name, int age, String hostName) {
        this.name = name;
        this.age = age;
        this.hostName = hostName;
    }

    // Encapsulation step2:
    // Define public getter and setter methods to read and modify/set the values of the abovesaid fields.
    public String getName() {

        return name;
    }

    public void outPut(){
        System.out.println("Animal~~~");
    }
 }

// Inheritance: using keyword extends and override the outPut method that also appears in parent class
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    public void outPut(){
        System.out.println("Dog~~~");
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?
   Wrapper classes are classes that allow primitive types to be accessed as objects.
   In other words, we can say that wrapper classes <u>are built-in java classes which allowthe conversion of objects to primitives and primitives to objects.</u>

   The process of converting primitives to objects is called autoboxing, and the process of converting objects to primitives is called unboxing. There are eight wrapper classes present in java.lang package is given below.

## 3. What is the difference between HashMap and HashTable?
    1.synchronized
        HashMap is not synchronized so is not thread-safe
        HashTable is synchronized so is thread-safe
    2.null 
        HashMap can contian one null key and multiple null values
        HashTable cannot contain any null key or null value
    3.inherit class
        HashMap inherits the AbstractMap class
        HashTable inherits the Dictionary class

## 4. What is String pool in Java and why we need String pool?
  ### What is String pool
   String pool is the <u>space reserved in the heap memory that can be used to store the strings.</u>
  
  ### why we need String pool?
   The main advantage of using the String pool is whenever we create a string literal; the JVM checks the "string constant pool" first. 
   If the string already exists in the pool, a reference to the pooled instance is returned. 
   If the string doesn't exist in the pool, a new string instance is created and placed in the pool. 

   Therefore, it saves the memory by avoiding the duplicacy.

## 5. What is Java garbage collection?
   Garbage collection is <u>a process</u> of <u>reclaiming the unused runtime objects</u>.
   回收未使用的运行时对象的过程.

   It is performed for memory management. In other words, we can say that It is the process of <u>removing unused objects from the memory to free up space and make this space available for Java Virtual Machine.</u>

## 6. What are access modifiers and their scopes in Java?
   - Public： The classes, methods, or variables which are defined as public, <u>can be accessed by any class or method.</u>
   - Private： The private class, methods, or variables defined as private <u>can be accessed within the class only.</u>
   - Default： Default <u>can be accessed within the package only. By default, all the classes, methods, and variables are of default scope.</u>
   - Protected： Protected <u>can be accessed by the class of the same package, or by the sub-class of this class, or within the same class.</u>

## 7. What is final key word? (Filed, Method, Class)
   the final variable is used to <u>restrict the user from updating it.</u>
   <u>For value: stop value change, for method: stop overriding, for class: stop inheritance.</u>
    
   If we initialize the final variable, we can't change its value. 
   In other words, we can say that the final variable once assigned to a value, can never be changed after that. The final variable which is not assigned to any value can only be assigned through the class constructor.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
   ### Static Field:
   <u>The static variables are used to refer to the common property of all objects.</u>
   <u>Static variable belongs to the class rather than the object.</u>

   ### Static Method:
   - A static method belongs to the class rather than the object.
   - There is no need to create the object to call the static methods.
   - A static method can access and change the value of the static variable.

   ### Static Class:
   <u>A class</u> in the java program <u>cannot be static except if it is the inner class.</u>
   If it is an inner static class, then it exactly works like other static members of the class.

## 9. What is the differences between overriding and overloading?
    1.basic
        overloading: a polymorphism technique to create multiple methods with the same name but different signature
        overriding: two methods having the same method signature are present in two different classes in which an inheritance relationship is present
    2.occurs
        overloading occurs within the class
        overriding occurs in 2 classes that have IS-A relationship between them.
    3.parameters
        overloading: the parameters must be different
        overriding: the parameters must be same.

## 10. What is the differences between super and this?
    1. basic
   this keyword always points to the <u>current</u> class context.
   super keyword always points to the <u>parent</u> class contexts 
    2. use
   this keyword primarily used to <u>differentiate between local and instance variables</u> when passed in the class constructor.
   super keyword is primarily used to <u>initialize the base class variables</u> within the derived class constructor.
        this关键字主要用于在类构造函数中传递时区分局部变量和实例变量。
        super关键字主要用于初始化派生类构造函数中的基类变量

## 11. What is the Java load sequence? 类加载顺序
   The class loading sequence refers to the order in which classes are loaded and initialized when a Java program is executed. 

   The class loading sequence typically involves the following steps:
   1. **Loading**: 
   The Java ClassLoader loads classes into memory as they are needed.
   When a class is first referenced in the code (e.g., <u>when it is instantiated with new or when a static member is accessed)</u>, the ClassLoader attempts to find and load the class's bytecode (.class file). 
   If the class has not been loaded before, it is loaded into memory.
   
   2. **Linking**:

        <u>Verification</u>: 
        The class loader verifies the loaded bytecode to ensure it adheres to Java's safety and security requirements. This includes checking for proper format, bytecode validity, and various security constraints.

        <u>Preparation</u>: 
        Static variables (class variables) in the class are allocated memory and initialized with their default values. These variables are initialized to zero, null, or appropriate default values depending on their data types.

        <u>Resolution</u>: 
        Any symbolic references in the class are resolved to direct references. This step involves replacing symbolic references (such as method and field references) with direct references to the actual methods or fields in other classes. Resolution can occur at compile-time or runtime.

   3. **Initialization**: 
   In this step, static initializers (static blocks and variable initializations) in the class are executed. Static initializers run in the order they appear in the class and only once, when the class is first initialized. 
   Initialization also occurs in a thread-safe manner, ensuring that it is done only once, even in a multi-threaded environment.

## 12. What is Polymorphism ? And how Java implements it ? 
   ### what is polymorphism:
   Polymorphism refers to <u>the ability</u> of objects to <u>take on multiple forms or behaviors</u> depending on the context. 

   ### compile-time polymorphism vs runtime polymorphism
   <u>compile-time polymorphism</u>: a process that <u>a call to method is resolves at compile-time (the type of the object is determined at compile-time).</u>
   compile-time polymorphism is also known as <u>static binding*, early binding, or *overloading</u>.

   <u>runtime polymorphism</u>: a process that <u>a call to an overridden method is resolves at runtime (the type of the object is determined at runtime).</u>
   runtime polymorphism is also known as <u>dynamic binding</u>, late bingding, <u>overriding</u> or dynamic method dispatch.

   ### how to implements: 
   by overriding and overloading

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
   ### what is encapsulation:
   Encapsulation: wraps code and data into a single unit.

   ### how to implement it:
   We need to perform two steps to achieve the purpose of Encapsulation in Java.
   1. Use the private access modifier to declare all variables/fields of class as private.
   2. Define public getter and setter methods to read and modify/set the values of the abovesaid fields.

   ### advantage
   - By providing only the setter or getter method, you can <u>make the class read-only or write-only</u>. 
   In other words, you can skip the getter or setter methods.
   - It provides the <u>control over the data</u>. 
   Suppose you want to set the value of id which should be greater than 100 only, you can write the logic inside the setter method. You can write the logic not to store the negative numbers in the setter methods.
   - It is a way to <u>achieve data hiding</u> in Java because other class will not be able to access the data through the private data members.

## 14. What is Interface and what is abstract class? What are the differences between them?
   ### what is interface:
   The <u>interface</u> is a blueprint for <u>a class that has static and final constants and abstract methods.</u>
   It can be used to achieve full abstraction and multiple inheritance. 
   In other words, you can say that interfaces can have abstract methods and variables. 
   <u>after Java8, an interface may also contain constants, default methods, static methods, and nested types.</u>

   ### what is abstract class:
   1. <u>A class that is declared as abstract</u> is known as an abstract class.
   2. <u>It needs to be extended and its method needs to be implemented.</u>
   需要对其进行扩展并实现其方法。
   3. <u>It cannot be instantiated.</u>
   它无法实例化。
   4. It can <u>have abstract and non-abstract methods, constructors, and static methods.</u>
   5. It can also have the <u>final methods</u> which will force the subclass not to change the body of the method. 

   ### interface vs abstract class
    1.implementation
        an abstract class can be extended using keyword extends
        an interface class can be implemented using keyword implements
    2.abstract method
        an abstract class can have non-abstract method.
        an interface class has only abstract methods.
    3.instance variable, constructor, static methods
        an abstract class can have instance variables, constructor
        an interface class cannot have instance variables, constructor

## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )
   ### Objects:
   The objects present in our design are the Vehicles, ParkingLot, Slots, and Levels.
   
   **Vehicles**: 
        Object with the company name, vehicle number, and their type. 

   **ParkingLot**: 
        There are 'x' levels or floors and 'y' slots per floor.
        
   **Slots**: 
        One slot is independent of the other slot. 
        The slot size matters for a vehicle to fill the slot. 
        For example, a small slot cannot be filled by a large vehicle.

   **Levels**: 
        Each level is an independent entity with a floor number, its slots and the lanes within it.
        The number of lanes is designed on the basis of number of slots. 
        In our case, 10 Slots comprise 1 lane.
   
   ### Methods:
   **parkVehicle()**: The parkVehicle() method parks a vehicle accordingly, also take into consideration the company that has made the vehicle.

   **leaveOperation()**: The operation exits a vehicle 'V' at a level 'x'.

   **companyParked()**: The CompanyParked() method facilitates the user to observe the list of vehicles parked by a specific company.
    
   ### Code:
   see the code file

## 16. What are Queue interface implementations and what are the differences and when to use what? 
   In Java, the Queue interface represents a collection of elements that <u>follows the First-In-First-Out (FIFO) order</u>. 

   - LinkedList:

    - Implementation: java.util.LinkedList<E>
    - It is a doubly-linked list that can be used as a queue by adding elements at the end (enqueue) and removing elements from the front (dequeue).
    - Efficient for adding and removing elements at both ends (front and rear).

   - PriorityQueue:

    - Implementation: java.util.PriorityQueue<E>
    - It is an unbounded priority queue based on a priority heap.
    - Elements are ordered based on their natural order or a specified comparator.
    - Suitable for scenarios where elements need to be processed based on their priority.