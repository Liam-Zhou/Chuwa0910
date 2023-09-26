2: What is the checked exception and unchecked exception in Java, could you give one example?
```text
Checked exception:These are the exceptions that a program should anticipate and recover from. In other words, these are exceptional conditions that a well-written application should handle.

Unchecked exception: Exception that occurs at the time of execution.
These represent defects in the program (bugs) that are typically hard to anticipate and recover from. They usually result from programming mistakes.
Unchecked exceptions are subclasses of RuntimeException and they don't need to be explicitly caught or declared to be thrown.

```

```java
FileReader file = new FileReader("nonexistentfile.txt");
BufferedReader fileInput = new BufferedReader(file);
            
// Read and print each line
 for (int counter = 0; counter < 3; counter++)
     String ystem.out.println(fileInput.readLine());
```

```java
int divisor = 0;
try {
    int result = 100 / divisor;
} catch (ArithmeticException e) {
    e.printStackTrace();
}
```

3:  Can there be multiple finally blocks?
```text
In Java, within a single try-catch construct, you can have only one finally block. The finally block is used to place important code that must be executed whether an exception is thrown or not.
```

4:When both catch and finally return values, what will be the final result
```text
The value returned by the finally block will be the final result.
```

5:What is Runtime/unchecked exception? what is Compile/Checked Exception
```text
 Unchecked exceptions are the exceptions that are not checked at compile time. They are also known as runtime exceptions
 Checked exceptions are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword.
```

6:What is the difference between throw and throws?
```text
throw: is used to explicitly throw a single exception.
throws: is used to declare multiple exceptions.
```

7:Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
exception before Exception ?

- 1:
```java
java.lang.ArithmeticException: / by zero
```

- 2:
```java
java.lang.NullPointerException
```

-3:
```java
RuntimeException
```
They are the subclass of Exception, Catch will trigger the first matched the exception, once they were caught by General Exception, this catch routine will be ignored.

7: What is optional in Java 8?
```text
optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
```

8: Why finally always be executed?
```text
finally block will always be executed irrespective of whether an exception is thrown from try block or not.
jvm ensure this. However, jvm cannot ensure that the process will be terminated or not.
```

10: What is Java 8 new features
```text
1. forEach() method in Iterable interface
2. default and static methods in Interfaces
3. Functional Interfaces and Lambda Expressions
4. Java Stream API for Bulk Data Operations on Collections
5. Java Time API
6. Collection API improvements
7. Concurrency API improvements
8. Java IO improvements
9. Miscellaneous Core API improvements
```

11: What are types of design patterns in Java
```text
1. Creational Patterns
2. Structural Patterns
3. Behavioral Patterns
```

12: What are the SOLID Principles ?
```text
1. Single Responsibility Principle
2. Open Closed Principle
3. Liskov Substitution Principle
4. Interface Segregation Principle
5. Dependency Inversion Principle
```

13:How can you achieve thread-safe singleton patterns in Java ?
```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

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
}
```

14:  What do you understand by the Open-Closed Principle (OCP) ?
```text
Open for extension
Closed for modification
Using abstract class and interface
Strategy pattern
```

15: Liskov Substitution Principle (LSP)
```text
A
```

