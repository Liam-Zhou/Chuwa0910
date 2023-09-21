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

    * `Lambda expressions`
    * `Method references`
    * `Streams`
    * `Optional class`

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
15. Describe the newly added features in Java 8?

    * `Lambda expressions`: Lambda expressions, also known as lambda functions, are a concise and expressive way to write code. A lambda expression is a short block of code that can be passed as a parameter to a method or assigned to a variable.
    * `Method references`: Method references are a concise way to refer to a method without having to use a lambda expression. Method references can be used in place of lambda expressions whenever the lambda expression is only calling a single method.
    * `Streams`: Streams are a powerful way to process data in Java. Streams provide a number of methods for filtering, mapping, and reducing data.
    * `Optional class`: The Optional class provides a safe way to handle null values. The Optional class can be used to avoid NullPointerExceptions.

16. Can a functional interface extend/inherit another interface?

    Yes, a functional interface in Java can extend/inherit another interface.

    `Example`

    ```Java
    public interface Converter<T, R> extends Function<T, R> {
    @Override
    R apply(T t);
     }
    ```
17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

    A lambda expression in Java is a short block of code that can be passed as a parameter to a method or assigned to a variable. Functional interfaces in Java are interfaces that have exactly one abstract method. Lambda expressions can be used to implement functional interfaces.

    `Functional Interfance` example :
    this interface has exactly one abstract method, convert(), which takes an input 
    value of type T and returns an output value of type R.

    ```Java
    @FunctionalInterface
    public interface Converter<T, R> {
    R convert(T t);
    }
    ```

    `an example of how to use a lambda expression to implement the Converter interface:`

    ```Java
    Converter<String, Integer> converter = (input) -> Integer.parseInt(input);

    Integer convertedValue = converter.convert("123");

    System.out.println(convertedValue); // Prints 123
    ```

    In this example, we create a Converter instance that converts strings to integers. We then use the convert() method to convert the string "123" to an integer.

18. In Java 8, what is Method Reference?

    Method references provide a concise way to refer to methods or constructors of classes and pass them around like lambda expressions.    

19. What does the String::ValueOf expression mean?

    The String::ValueOf expression in Java is a method reference to the valueOf() method on the String class. The valueOf() method converts a variety of data types to a String object.

    The String::ValueOf expression can be used in place of a lambda expression whenever the lambda expression is only calling the valueOf() method.

20. What are Intermediate and Terminal operations?

    Intermediate operations in Java streams are operations that transform a stream into another stream. They do not produce a result themselves.
   
    Terminal operations in Java streams are operations that produce a result from a stream. They terminate the stream and return a value.
   
    Intermediate operations can be chained together to form a pipeline of operations. The pipeline is executed when a terminal operation is invoked. Terminal operations can only be invoked once on a stream.

21. What are the most commonly used Intermediate operations?

    The most commonly used intermediate operations in Java streams are:

    * filter(): Filters the stream to only include elements that match a certain criteria.
    * map(): Transforms each element in the stream into a new element.
    * sorted(): Sorts the stream in a certain order.
    * limit(): Limits the stream to a certain number of elements.
    * skip(): Skips the first n elements of the stream.
    * distinct(): Removes duplicate elements from the stream.
    * flatmap(): Flattens a stream of streams into a single stream.
    * peek(): Performs a given operation on each element in the stream, but does not modify the stream itself.
   
22. What is the difference between findFirst() and findAny()?

    The findFirst() and findAny() methods in Java streams are both used to find a single element from a stream. However, there are some key differences between the two methods.

    The findFirst() method returns the first element in the stream, or an empty Optional if the stream is empty. The findAny() method returns any element from the stream, or an empty Optional if the stream is empty.

    Another difference between the two methods is that the findFirst() method is guaranteed to return the first element in the stream if the stream has an encounter order. The findAny() method is not guaranteed to return the first element in the stream, even if the stream has an encounter order.

    The findFirst() method is typically used when you need to find the first element in a stream that meets a certain criteria. The findAny() method is typically used when you need to find any element in a stream, regardless of its position in the stream.

    `Examples on how to use them` :

```Java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Find the first even number in the list
Optional<Integer> firstEvenNumber = numbers.stream().filter(n -> n % 2 == 0).findFirst();

// Find any even number in the list
Optional<Integer> anyEvenNumber = numbers.stream().filter(n -> n % 2 == 0).findAny();

if (firstEvenNumber.isPresent()) {
    System.out.println("The first even number in the list is: " + firstEvenNumber.get());
} else {
    System.out.println("There are no even numbers in the list");
}

if (anyEvenNumber.isPresent()) {
    System.out.println("Any even number in the list is: " + anyEvenNumber.get());
} else {
    System.out.println("There are no even numbers in the list");
}

```

23. How are Collections different from Stream?

    Collections and streams in Java are two different ways to represent and process data.
   
    Collections are data structures that store collections of elements. They are typically used to store data in a specific order, such as a list or a set. Collections are mutable, meaning that their elements can be added, removed, and modified.
   
    Streams are a pipeline of operations that can be performed on collections or other data sources. They are typically used to process data in a declarative way, without having to worry about the underlying implementation. Streams are immutable, meaning that they cannot be modified.

    `Here are some examples of how to use collections and streams:`

```Java
    // Collections
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Add an element to the collection
numbers.add(6);

// Remove an element from the collection
numbers.remove(3);

// Sort the collection
Collections.sort(numbers);

// Iterate over the collection
for (int number : numbers) {
    System.out.println(number);
}

// Streams
Stream<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0);

// Perform a map operation on the stream
Stream<Integer> squaredNumbers = evenNumbers.map(n -> n * n);

// Perform a reduce operation on the stream
int sumOfSquaredNumbers = squaredNumbers.reduce(0, (a, b) -> a + b);

// Print the sum of the squared even numbers
System.out.println(sumOfSquaredNumbers);

```
