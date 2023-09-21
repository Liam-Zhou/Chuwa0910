## 1. Practice collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

- Checked Exception: exceptions that are checked at compile time. E.g. IOException
- Unchecked Exception: exceptions that are checked at runtime. E.g. NullPointerException

## 3. Can there be multiple finally blocks?

No. can be multiple catch blocks but only one finally block.

## 4. When both catch and finally return values, what will be the final result?

return the finally value

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Checked(Compile) Exception: exceptions that are checked at compile time. E.g. IOException
- Unchecked(Runtime) Exception: exceptions that are checked at runtime. E.g. NullPointerException

## 6. What is the difference between throw and throws?

```
// throw
throw new IOException();

// throws
public void getOrder(String id) throws Exception {}
```

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
}
        System.out.println("End ...");
    }
}
```

Throw ArithmeticException

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
```

Throw NullPointerException

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
}
        System.out.println("End ...");
    }
}
```

Throw RuntimeException

why do we put the Null/Runtime exception before Exception? Because 'catch' scope should be from shall to large

## 8. What is optional? why do you use it? write an optional example.

Optional is used to represent a value that may or may not be present. In other words, an Optional object can either contain a non-null(present) value or no value at all (empty).

## 9. Why finally always be executed ?

Some Aftercare operations need to be done even exception happens. E.g. Open a file, get an exception, but never close. It is wrong so we need 'finally'.

## 10. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

## 11. What is Java 8 new features ?

- Default method and static method in Interface
- Lambda & Functional Interface
- Method Reference
- Optional
- Stream API
- CompletableFuture

## 12. What are the types of design patterns in Java ?

- Creational Design Pattern
  - Factory Pattern
  - Abstract Factory Pattern
  - Singleton Pattern
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
- Behavioral Design Pattern
  - Chain Of Responsibility Pattern
  - Command Pattern
  - Interpreter Pattern
  - Iterator Pattern
  - Mediator Pattern
  - Memento Pattern
  - Observer Pattern
  - State Pattern
  - Strategy Pattern
  - Template Pattern
  - Visitor Pattern

## 13. What are the SOLID Principles ?

SOLID Principles are:

- Single-responsibility principle: "There should never be more than one reason for a class to change."
- Open–closed principle: "Software entities ... should be open for extension, but closed for modification."
- Liskov substitution principle: "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it." See also design by contract.
- Interface segregation principle: "Clients should not be forced to depend upon interfaces that they do not use."
- Dependency inversion principle: "Depend upon abstractions, concretions."

## 14. How can you achieve thread-safe singleton patterns in Java ?

Three different ways:

- Create the instance variable at the time of class loading
- Synchronize the getInstance() method
- Use synchronized block inside the if loop and volatile variable

## 15. What do you understand by the Open-Closed Principle (OCP) ?

The code should be extensible, like Inferface declared a function that some class possess. It won't need to modify the existing code but can extend to new code(detailed function).

## 16. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

- A. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing

- B. It means that all the objects of type A could execute all the methods present in its subtype B

- C. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

- D. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

Choose A.

## 17. Watch the design pattern video, and type the code, submit it to MavenProject folder

- singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
- Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
- Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
- Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9
