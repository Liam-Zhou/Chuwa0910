1. What is generic in Java? and type the generic code by yourself.
   a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core
   /src/main/java/com/chuwa/tutorial/t01_basic/generic
> generics in Java enable you to write code that works with multiple data types while maintaining type safety and code reusability.
2. Read those codes and type it one by one by yourself. then push the code to your
   branch.
   https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/mai
   n/java/com/chuwa/tutorial/t06_java8
3. practice stream API at least 3 times
   a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java�stream-api-3f9c86b1cf82
4. Practice Optional methods at least 2 times
   a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-cor
   e/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartU
   til.java
5. Write the Singleton design pattern include eager load and lazy load.
> public class EagerSingleton { <br>
> private static final EagerSingleton instance = new EagerSingleton();<br>
>     private EagerSingleton() {<br>
>     }<br>
>     public static EagerSingleton getInstance() {<br>
>         return instance;<br>
>     }<br>
> }<br>

> public class LazySingleton {<br>
> private static LazySingleton instance;<br>
>     private LazySingleton() {}<br>
>     public static LazySingleton getInstance() {<br>
>         if (instance == null) {<br>
>             instance = new LazySingleton();<br>
>         }<br>
>         return instance;<br>
>     }<br>
>}


6. What is Runtime Exception? could you give me some examples?
> Runtime exceptions are often caused by unexpected or exceptional conditions that the program encounters during execution. There are some common types like NullPointerException, NullPointerException, FileNotFound Exception.
7. Could you give me one example of NullPointerException?
> String str = null; <br>
> int length = str.length(); // Throws NullPointerException

8. What is the Optional class?
> The Optional class is a container class that provides a more explicit and safer way to handle situations where a value may or may not be present, thereby reducing the chances of NullPointerExceptions.
9. What are the advantages of using the Optional class?
> Null Safety: Avoids null pointer exceptions.<br>
> Explicit Intent: Clearly indicates the possibility of absent values.<br>
> Functional Support: Enables cleaner, functional-style code.<br>
> Avoids Defensive Checks: Reduces the need for explicit null checks.<br>
> Clear API Contracts: Defines clear expectations for API users.<br>
> Chaining: Allows concise operations on present values.<br>

10. What is the @FunctionalInterface?
> @FunctionalInterface is a Java annotation used to indicate that an interface is meant to have a single abstract method. It's primarily used with lambda expressions to simplify and enhance code readability for functional programming.
11. what is lambda expression?
> A lambda expression in Java is a concise way to define a small, anonymous function or block of code that can be passed as an argument to a method or stored in a variable.
12. What is Method Reference?
> Method reference in Java is a shorthand notation for invoking a method or referring to a method of a class or an object. It allows you to reuse existing method implementations and pass them around as function arguments.
13. What is Java 8 new features?
> Lambda Expressions<br>
> Functional Interfaces<br>
> Stream API<br>
> Default and Static Methods in Interfaces<br>
> Method References
14. Lambda can use unchanged variable outside of lambda? what is the details?
> Lambda expressions can access instance variables (i.e., fields of an object) from their enclosing class. These variables don't need to be declared as final or effectively final, but they must be accessible within the lambda's scope.
15. Describe the newly added features in Java 8?
> see question 13
16. Can a functional interface extend/inherit another interface?
> A functional interface can extend another interface as long as the resulting interface adheres to the single abstract method rule and doesn't introduce additional abstract methods.
17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
> A lambda expression in Java is a concise way to define and use an anonymous function. It's often used with functional interfaces, which are interfaces with a single abstract method. Lambda expressions allow you to provide a quick implementation for that single method, making your code more compact and enabling a more functional programming style in Java.
18. In Java 8, what is Method Reference?
> In Java 8, a method reference is a shorthand notation that allows you to refer to a method of a class or an instance of a class directly. It simplifies the use of lambda expressions when a lambda expression simply calls an existing method. Method references provide a more readable and concise way to express such calls.
19. What does the String::ValueOf expression mean?
> It refers to the valueOf method of the String class. This method is a static method and is used to convert various types of data into their string representations.
20. What are Intermediate and Terminal operations?
>  Intermediate operations in Java Streams are used to transform and filter data in a stream lazily, creating a pipeline of operations. Terminal operations triggers the execution of these operations and produce a final result.
21. What are the most commonly used Intermediate operations?
> map, filter, distinct, sorted, flatmap
22. What is the difference between findFirst() and findAny()?
> the main difference between findFirst() and findAny() is that findFirst() returns the first element in an ordered stream and is deterministic, while findAny() returns any element and is typically used when you don't need a specific element or when working with unordered streams, especially in parallel processing.
23. How are Collections different from Stream?
> collections are suitable for managing and manipulating a fixed set of objects in memory, whereas streams are designed for functional and often parallel data processing. Streams provide a more declarative and efficient way to work with data, especially for large or potentially infinite datasets.