# HW2 - Grace Hu

### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

#### i. Encapsulation
    public class Bank {
        public static void main(String[] args) {
            CheckingAccount user1 = new CheckingAccount("Grace", 100);
            user1.addFunds(5);
            System.out.println(user1.getBalance());
        }
    }

    // CheckingAccount Class
    class CheckingAccount {
        private String name;
        private int balance;

        public CheckingAccount(String inputName, int inputBalance) {
            name = inputName;
            balance = inputBalance;
        }

        public void addFunds(int fundsToAdd) {
            balance += fundsToAdd;
        }

        public int getBalance() {
            return balance;
        }
    }
    
#### ii. Polymorphism
    public class Noodle {
  
        protected double lengthInCentimeters;
        protected double widthInCentimeters;
        protected String shape;
        protected String ingredients;

        public Noodle(double lenInCent, double wthInCent, String shp, String ingr) {
            
            this.lengthInCentimeters = lenInCent;
            this.widthInCentimeters = wthInCent;
            this.shape = shp;
            this.ingredients = ingr;
        }
        
        public void cook() {
            System.out.println("Boiling.");
        }
        
        public static void main(String[] args) {
            Spaetzle spaetzle = new Spaetzle();
            spaetzle.cook();
            
        }
        
    }
    class Spaetzle extends Noodle {
        Spaetzle() {
            super(3.0, 1.5, "irregular", "eggs, flour, salt");
        }
        
        @Override
        public void cook() {
            System.out.println("Grinding or scraping dough");
        }
    }

#### iii. Inheritance
    public class Noodle {
        double lengthInCentimeters;
        double widthInCentimeters;
        String shape;
        String ingredients;

        public Noodle(double lenInCent, double wthInCent, String shp, String ingr) {
            this.lengthInCentimeters = lenInCent;
            this.widthInCentimeters = wthInCent;
            this.shape = shp;
            this.ingredients = ingr;
        }

        public static void main(String[] args) {
            Pho phoChay = new Pho();
            System.out.println(phoChay.shape);
        }
    }

    class Pho extends Noodle {
        Pho() {
            super(30.0, 0.64, "flat", "rice flour");
        }
    }



### 2. What is wrapper class in Java and Why we need wrapper class?
In Java, a wrapper class converts primitive data types like int, double, and char into objects, enabling you to treat them as objects and access additional functionality. 

This is useful for scenarios like working with null values, generics, and collections that require objects.

### 3. What is the difference between HashMap and HashTable?
i. **Hashtable** is synchronized, which means it is thread-safe. Multiple threads can access and modify a Hashtable concurrently without causing data corruption or unexpected behavior. **HashMap** is not synchronized by default, which means better performance in single-threaded scenarios.

ii. **Hashtable** does not allow null keys or values. **HashMap** allows one null key and any number of null values.

### 4. What is String pool in Java and why we need String pool?
The **String pool** in Java is a special area in the Java heap memory that stores a pool of string literals. It is a mechanism used by the Java Virtual Machine (JVM) to optimize memory usage and improve performance when working with strings.

i. Java can reuse the same memory location for multiple string literals with the same value,saving memory.

ii. String literals are immutable, Java can safely reuse the same string instance across multiple parts of code without worrying about unintended changes.


### 5. What is Java garbage collection?
Java **garbage collection** is an automatic process. Automatic garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects. 


### 6. What are access modifiers and their scopes in Java?
**Access modifiers** in Java are keywords that define the visibility and accessibility of classes, methods, variables, or other members within a Java program. They determine which parts of a program can access a particular class or member.

**Private**: Can access only within the same class and not from outside the class.

**Default**: Can access only within the same package and not from outside the package. And also, if we do not specify any access modifier it will automatically consider it as default.

**Protected**: Can access within the same package and also from outside the package with the help of the child class. If we do not make the child class, we cannot access it from outside the package. So inheritance is a must for accessing it from outside the package.

**Public**: Can access from anywhere.

### 7. What is final key word? (Field, Method, Class)
**Field/Variable**

    public static final String APP_NAME=“testApp”
Purpose: define constants. Final fields must be initialized when they are declared or in a constructor. After initialization, their value cannot be modified.

**Method**
    
    public final int add(int a, int b){ return a + b; }
Purpose: the method cannot be overridden or modified by subclasses. Subclasses are prevented from providing their own implementation of the final method.

**Class**
    
    final class MyClass(){}
Purpose:
1. prevent inheritance, like Integer, String etc;
2. Make class immutable

### 8. What is static keyword? (Field, Method, Class). When do we usually use it?
**Static Fields** (Static Variables): only one Instance. Static variables are, essentially, global variables. All instances of the class share the same static variable. It is accessed using the class name.

**Static Method**: Can directly call static method using Class name. A static method can be accessed without creating an object of the class first. Can't be overridden.

**Static Class**: A static nested class is a class that is nested within another class but does not require an instance of the outer class to be instantiated.

### 9. What is the differences between overriding and overloading?
**Overriding**: It occurs when the method signature (name and parameters) are the same in the superclass and the child class. It happens at compile time.

**Overloading**: It occurs when two or more methods in the same class have the same name. diff num of arguments, diff type arguments, diff(derived data type)/same(primitive data type or void) return type, same method name. It happens at runtime.

### 10. What is the differences between super and this?
**super**: The super keyword is used to refer to members (fields, methods, and constructors) of the superclass (parent class) from within a subclass (child class).

**this**: The this keyword is used to refer to members of the current class, including fields, methods, and constructors. It is used to distinguish between instance variables or parameters with the same name as class fields, or to invoke constructors or methods within the current class.

### 11. What is the Java load sequence?

static variable/block -> constructor(used in Obj)

### 12. What is Polymorphism ? And how Java implements it ?
It refers to the same object exhibiting different forms and behaviors.

**Static Polymorphism** - Overload (same class) - compile time

**Dynamic Polymorphism** - Override (child class) - run time

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).

Java implements encapsulation through the use of access modifiers and getter and setter methods. 

Encapsulation helps protect the integrity of a class's data by preventing direct access and modification.

### 14. What is Interface and what is abstract class? What are the differences between them?

**interface**: An interface in Java is a contract or blueprint for a class. It defines a set of abstract methods (methods without a body) that must be implemented by any class that claims to implement the interface. Interfaces can also contain constant fields (implicitly public, static, and final), but they cannot contain instance fields.

**abstract**: An abstract class is a class that cannot be instantiated on its own. It may contain a mix of concrete (implemented) methods and abstract (unimplemented) methods. Abstract methods are marked with the abstract keyword and have no method body.

Diff:
1. Constructor: An abstract class can have constructors, while an interface cannot have constructors.

2. Method Implementation: An abstract class can provide both concrete and abstract methods. In an interface, all methods are implicitly abstract and have no implementation.

3. Fields: Abstract classes can have instance fields, while interfaces can only have constant (static and final) fields.

4. Inheritance: A class can extend only one abstract class, but it can implement multiple interfaces.

5. Access Modifiers: Abstract class members can have various access modifiers (public, protected, package-private, private), while interface members are implicitly public and abstract.

6. Use Cases: Use abstract classes when providing a common base class with some shared implementation. Use interfaces when defining a contract that multiple classes must adhere to, irrespective of their inheritance hierarchy.

### 16. What are Queue interface implementations and what are the differences and when to use what?

The **Queue interface** is part of the Java Collections Framework and represents a collection that holds elements in a linear order, typically following FIFO principle. 

- Use **LinkedList** when we need a general-purpose queue that allows elements to be inserted or removed from both ends and duplicates are allowed.

- Use **PriorityQueue** when we need to process elements based on their priority. It's useful for implementing a priority queue or any scenario where elements need to be processed in a specific order.

- Use **ArrayDeque** when we need a fast and efficient queue implementation. It's a good choice when we don't need to add or remove elements from the middle of the queue.