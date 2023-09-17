# hw3  

1. Practice Collection  
    see `Coding/colection`
2. What is the checked exception and unchecked exception in Java, could you give one example?  
    Checked exception is also called Compile exception, is the exception that user can catch and handle, like `IOException` and `SQLException`.  
    Unchecked exception is also called Runtime exception, which cannot be handled by program, like `NullPointerException` and `ArrayIndexOutOfBoundsException`.
3.  Can there be multiple finally blocks?  
    No. Each `try` can only have one `finally` block.  
4.  When both catch and finally return values, what will be the final result?  
    The final result will be the one return by `finally`.  
5. What is Runtime/unchecked exception? what is Compile/Checked Exception?  
    see question 2.
6.  What is the difference between throw and throws?  
    `throw` is a keyword to explicitly throw an exception within a method;  
    `throws` is a keyword inside method declaration, to show what kinds of exception this method might throw.  
7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?   
    Code 1: 
    ```
    java.lang.ArithmeticException: / by zero
        at Main.main(Main.java:9)
    End ...
    ```
    Code 2:
    ```
    java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "s" is null
	    at Main.main(Main.java:10)
    End ...
    ```
    Code 3:
    ```
    java.lang.RuntimeException
        at Main.main(Main.java:11)
    End ...
    ```
    We can notice that the exception is always the first error line inside `try` part, and the lines after the first error will not be executed. We put Null/Runtime exception before Exception because we always have to catch the small error first, and leave the more generic error at behind, so that we can get more precise error details.
7. What is optional? why do you use it? write an optional example.  
    `optional` is designed to represent an optional value on a variable, which means the variable can have a value or to be `null`. We use this when a variable can sometime be `null`, and `optional` will force `null` to be handled and improve code readability.  
    ```java
    public class Main {
    public static void main(String[] args) {
        Optional<Integer> a = Optional.of(1);
        int b=2;
        int result;
        //result=a+b; //error
        if(a.isPresent()){
            result = a.get() + b;
            System.out.println(result);
        }
        else{
            result = b;
            System.out.println(result);
        }
    }
    }
    ```
8.  Why finally always be executed ?  
    No matter there is exception being caught or not, `finally` will be executed at last for cleanup work.   
9. Practice collection problems
   see `Coding/colection`
10. What is Java 8 new features ?  
     There are multiple new features, like lambda expressions, Streams API, default methods in interfaces, Optional, and more.
11.  What are the types of design patterns in Java?  
     * **Creational Design Pattern**  
         Factory Pattern  
         Abstract Factory Pattern  
         Singleton Pattern  
         Prototype Pattern  
         Builder Pattern.  
     * **Structural Design Pattern**  
         Adapter Pattern  
         Bridge Pattern   
         Composite Pattern  
         Decorator Pattern  
         Facade Pattern  
         Flyweight Pattern  
         Proxy Pattern  
     * **Behavioral Design Pattern**  
         Chain Of Responsibility Pattern  
         Command Pattern  
         Interpreter Pattern  
         Iterator Pattern  
         Mediator Pattern  
         Memento Pattern  
         Observer Pattern  
         State Pattern  
         Strategy Pattern  
         Template Pattern  
         Visitor Pattern.  

12.  What are the SOLID Principles?  
     - S: Single Responsibility Principle (SRP). A class should have a single, well-defined purpose, and all of its methods and properties should be closely related to that purpose.  
     - O: Open/Closed Principle (OCP). Entities (classes, modules, functions, etc.) should be open for extension but closed for modification, means you can add new functionality without modifying the existing codes.  
     - L: Liskov Substitution Principle (LSP). A class can be replaced by its subclass without altering any of the desirable properties of that program. 
     - I: Interface Segregation Principle (ISP). A class should not be forced to implement interfaces it doesn't want.
     - D: Dependency Inversion Principle (DIP). High-level modules should not depend on low-level modules; both should depend on abstractions and interfaces.   
13.  How can you achieve thread-safe singleton patterns in Java?  
   After Java 8, both Eager Load and Lazy Load are thread safe. If you want to double make sure, you can use Double-Checking lock to achieve thread safe like following:
   ```java
   public static Singleton getInstance() {
       if (instance == null) {
           synchronized (Singleton.class) {
               if (instance == null) {
                   instance = new Singleton();
               }
           }
       }
       return instance;
   }
   ```  
14.  What do you understand by the Open-Closed Principle (OCP)?  
    I understand that once we finish a class, we should not modify it to prevent adding bugs or disturbing the currently running module. If we want to add new features, we should write new class and extend the old one. 
15.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
        1.  It means that if the object of type A can do something, the object of type B could also be able to perform the same thing
        2.  It means that all the objects of type A could execute all the methods present in its subtype B
        3.  It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
        4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.  

I choose **C**. Class B should adhere to the same contract (method signatures and behavior) as class A, ensuring that all methods present in class A are also present in class B.
16.  Watch the design pattern video, and type the code, submit it to MavenProject folder  
     singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22  
     Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9  
     Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9  
     Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9  

See `Repo/MavenProject/com.chuwa.learn.designPattern`