1. What is Genetic in Java ? and type the genetic code by yourself
   
   In Java, "generic" refers to a feature that allows you to create classes, interfaces, and methods with parameters that can work with different types (or data types) in a type-safe manner.

   ```java
   public class GenericClass<T> {
    // T -> Integer, User, Product
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
   ```

2. Please refer to the coding file

3. Please refer to the coding file

4. Please refer to the coding file

5. Write the Singleton design pattern include eager load and lazy load.
   
    > Eager Loading Singleton:
   ```Java
    public class EagerSingleton {
    // Private static instance variable
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation from other classes
    private EagerSingleton() {
    }

    // Public method to provide access to the instance
    public static EagerSingleton getInstance() {
        return instance;
      }
     }
   ```
   > Lazy Loading Singleton:
   ```Java
    public class LazySingleton {
    // Private static instance variable
    private static LazySingleton instance;

    // Private constructor to prevent instantiation from other classes
    private LazySingleton() {
    }

    // Public method to provide access to the instance, creates it if needed
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
       }
     }

   ```

6. What is Runtime Exception? could you give me some examples?
   
   Runtime Exception is a type of exception in a programming language like Java that occurs during the execution (runtime) of a program, rather than at compile time.

   * ArrayIndexOutOfBoundsException: This occurs when you try to access an array element at an index that is outside the bounds of the array.
   ```jAVA
   int[] numbers = {1, 2, 3};
   int value = numbers[5]; // This will throw an ArrayIndexOutOfBoundsException
   
   ```

   * ArithmeticException: This occurs when there is an arithmetic error, such as dividing by zero.
   ```Java
   int result = 10 / 0; // This will throw an ArithmeticException
   ```

   * ClassCastException: This occurs when you try to cast an object to a class type that it is not an instance of.
   ```Java
   Object obj = new Integer(42);
   String str = (String) obj; // This will throw a ClassCastException
   ```

   * IllegalArgumentException: This is thrown when a method is passed an illegal or inappropriate argument.
   ```Java
   public void doSomething(int value) {
    if (value < 0) {
        throw new IllegalArgumentException("Value must be non-negative.");
    }
    // Rest of the code
   }
   ```

   * NumberFormatException: This occurs when you try to convert a string to a numeric type, but the string is not a valid numeric representation.
   ```Java
    String invalidNumber = "abc";
    int number = Integer.parseInt(invalidNumber); // This will throw a NumberFormatException
   ```

7. Could you give me one example of NullPointerException?
  
   * NullPointerException : This occurs when you attempt to access a method or field on an object that is null.
   ```Java
   String str = null;
   int length = str.length(); // This will throw a NullPointerException
   ```

8. What is the Optional class?
   
   The Optional class in Java is a container object that may or may not contain a non-null value.
   It was introduced in Java 8 to help developers avoid NullPointerExceptions

   > Example:
   ```Java
   // Old way:

   String name = customer.getName();
   if (name != null) {
   System.out.println("Hello, " + name);
   } else {
     System.out.println("Hello, there!");
    }

   // New way:

   Optional<String> nameOptional = customer.getName();
   nameOptional.ifPresent(name -> System.out.println("Hello, " + name));
   ```
9. What are the advantages of using the Optional class?
    * Avoid NullPointerExceptions: it helps prevent NullPointerExceptions
    * Improved Code Clarity: when you see an Optional variable, you know that it might not contain a value
    * Reduced Defensive Coding: With Optional, developers DON'T need to write defensive code to check for null values before using them
    * Forcing Explicit: You can't accidentally forget to check for null because the compiler enforces

10. What is the @FunctionalInterface?
    
    It is an annotation in Java is used to indicate that an interface is intended to be a functional interface, which is an interface that has exactly one abstract method.

11. What is lamda?

    In Java, short for lamda experession, it is a concise way to express instances of single-method interfaces . A lambda expression is a short block of code that can be passed as a parameter to a method or assigned to a variable. 

    The syntax is :
    `(parameters) -> expression or {statements}`

12. What is Method Reference?
    
    A method reference in Java is a concise way to refer to a method without having to use a lambda expression. Method references can be used in place of lambda expressions whenever the lambda expression is only calling a single method.

    To create a method reference, you use the following syntax:

    `ContainingClass::methodName`

    ***ContainingClass*** is the class that contains the method and ***methodName*** is the name of the method.

13. What is Java 8 new features?

    * `Lambda expressions`: Lambda expressions, also known as lambda functions, are a concise and expressive way to write code. A lambda expression is a short block of code that can be passed as a parameter to a method or assigned to a variable.
    * `Method references`: Method references are a concise way to refer to a method without having to use a lambda expression. Method references can be used in place of lambda expressions whenever the lambda expression is only calling a single method.
    * `Streams`: Streams are a powerful way to process data in Java. Streams provide a number of methods for filtering, mapping, and reducing data.
    * `Optional class`: The Optional class provides a safe way to handle null values. The Optional class can be used to avoid NullPointerExceptions.

14. Lambda can use unchanged variable outside of lambda? what is the details?

    Yes, a lambda expression can use an unchanged variable outside of the lambda, as long as the variable is effectively
    final. An effectively final variable is one whose value cannot be changed after it is first assigned.

    For instance: **name** is unchanged
    ```Java
    String name = "John Doe";
    Runnable runnable = () -> {
    System.out.println("Hello, " + name);
     };
    ```

    ***Counterexample***: `count` is **changed**
    ```Java
    int count = 0;
    Runnable runnable = () -> {
    count++;
    System.out.println("The count is " + count);
    };

    ```

    

    
