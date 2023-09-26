# hw3 Difan Xue

1. see code file

2.  checked & unchecked exception

checked exception: must use `catch` or `throws`, such as IOException, FileNotFoundException, SQLException

unchecked exception: no need to use `catch` or `throws`, such as runtime exceptions

```java
// checked exception
Fille file = new File("example.txt");
try {
	FileReader reader = new FileReader(file);
}
catch(IOException e){
	e.printStackTrace();
}

// unchecked exception
int[] number = {1, 2, 3};
int i = numbers[3];
// throw the ArrayIndexOutOfBound
```

3. Can there be multiple finally blocks?

For one try-catch, there can only be one finally block.
4. When both catch and finally return values, what will be the final result?

The result is the finally return values.
5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

Checked exceptions are exceptions that the compiler requires you to handle explicitly using **`try-catch`** blocks or declare them using the **`throws`** clause in your method signature.

Unchecked exceptions, also known as runtime exceptions, do not need to be explicitly caught or declared in the method signature. These exceptions typically represent programming errors, such as null pointer dereference or array index out of bounds.
6. What is the difference between throw and throws?

`Throw`:

The keyword used to explicitly throw an exception.

```java
if (condition) {
    throw new CustomException("This is a custom exception.");
}
```

`Throws`:

Is used in a method declaration to specify that the method might throw one or more exceptions during its execution.

```java
public void getOrder(String orderId) throws OrderNotFoundException, DBException,Exception { //throws}
```

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

If we put the runtime exception after exception, we would never reach out to the runtime exception, because it’s an unchecked exception.

7. What is optional? why do you use it? write an optional example.

Optional is a container which can store null object.

```java
public static void main(String args[]){
   
      Java8Tester java8Tester = new Java8Tester();
      Integer value1 = null;
      Integer value2 = new Integer(10);
        
      Optional<Integer> a = Optional.ofNullable(value1);

      Optional<Integer> b = Optional.of(value2);
      System.out.println(java8Tester.sum(a,b));
   }
```

8. Why finally always be executed?

The **`finally`** block in Java is used in conjunction with a **`try-catch`** block to ensure that a particular block of code is always executed, regardless of whether an exception is thrown or not.

Some reason: to cleanup the resource or perform any necessary action in the final

9. Practice collection problems

10. What is Java 8 new features ?

Lambda; Optional Class, Method references, Default methods, Method parameter reflection; new Tools

11. What are the types of design patterns in Java ?

- Creational Design Pattern (separate the class and method)
    - Factory Pattern
    - Singleton Pattern
    - Abstract Factory Pattern
    - Prototype Pattern
    - Builder Pattern
- Structural Design Pattern
    - Adapter Pattern
    - Bridge Pattern
    - Composite Pattern
    - Decorator Pattern
    - Facade Pattern
    - Flyweight Pattern
    - Proxy Pattern

12. What are the SOLID Principles ?

The key of SOLID principles are the five design principles to design the relationships between classes, including inheritance, composition, aggregation.

The SOLID stands for:**ingle Responsibility Principle (SRP), Open/Closed Principle (OCP), Liskov Substitution Principle (LSP), Interface Segregation Principle (ISP), Dependency Inversion Principle (DIP)**

13. How can you achieve thread-safe singleton patterns in Java?

Static volatile variable, make constructor be private, static synchronized getInstance method.

When get the instance, need to make sure INSTANCE is null, to avoid multi threads create the instance at the same time.

```java
public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
```

14. What do you understand by the Open-Closed Principle (OCP) ?

Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

This principle encourages you to design your software in a way that allows you to add new features or behaviors without modifying existing, working code.

For example, if we have a sorting utility, we can define a sorting interface and having different sorting algo to implement it. So we can extend new sorting algo without changing the existing code

```java
Copy code
public interface SortAlgorithm {
    void sort(int[] array);
}

public class BubbleSort implements SortAlgorithm {
    public void sort(int[] array) {
        // Bubble sort implementation
    }
}

// Users can add new sorting algorithms by implementing SortAlgorithm.
```

15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

Answer is 1 (It mean that if the object of type A can do something, the object of type B could also be able tp).

1. Watch the design pattern video, and type the code, submit it to MavenProject folder