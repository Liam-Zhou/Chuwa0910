1. What is generic in Java? And type the generic code by yourself.
    
    In Java, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces, and methods. By using generics, we can create a single class, interface, or method that works with different data types while still providing type safety. This way, generics help to ensure that type mismatches are caught at compile-time rather than at runtime.
    
2. Read those codes and type it one by one by yourself. the push the code to your branch.
    
3. Practice stream API at least 3 times.  
    
4. Practice Optional methods at least 2 times. 
    
5. Write the Singleton design pattern include eager load and lazy load.

    ```
    //eager load
    public class Singleton {

       private Singleton() { }

       private static final Singleton instance = new Singleton();

       public static Singleton getInstance() {
           return instance;
       }
    }
    ```
    ```
    //lazy load
    public class Singleton {
       private Singleton() { }

       private static class SingletonHolder {
          private static final Singleton INSTANCE = new Singleton();
       }

       public static Singleton getInstance() {
          return SingletonHolder.INSTANCE;
       }
    }
    ```
    

6. What is Runtime Exception? Could you give me some examples?

    A RuntimeException is a type of exception in Java that indicates conditions that a reasonable application might want to catch. It is an unchecked exception, which means the compiler doesn't force the programmer to either handle the exception (using a try-catch block) or declare it (using the throws keyword).

    The rationale behind making RuntimeException unchecked is that these exceptions usually represent programming bugs, such as logic errors or improper use of an API. Checked exceptions generally represent invalid conditions in areas outside the immediate control of the program, like invalid user input, database issues, network outages, and missing files.

    Here are some common examples of RuntimeException:

    - NullPointerException: Occurs when we try to access a member on a reference variable that's currently pointing to null.
    ```
    String str = null;
    int length = str.length(); // Throws NullPointerException
    ```
    - ArithmeticException: Thrown when an exceptional arithmetic condition occurs, such as dividing by zero.
    ```
    int division = 10 / 0; // Throws ArithmeticException
    ```
    - ArrayIndexOutOfBoundsException: Thrown to indicate that an array has been accessed with an illegal index (either negative or greater than or equal to the size of the array).
    ```
    int[] array = {1, 2, 3};
    int value = array[5]; // Throws ArrayIndexOutOfBoundsException
    ```

7. Could you give me one example of NullPointerException?

    ```
    String str = null;
    int length = str.length(); // Throws NullPointerException
    ```

8. What is the Optional class?

    The Optional class is a container object introduced in Java 8 that may or may not contain a non-null value. By using Optional, we can better deal with cases that might have the possibility of null values without having to explicitly do null checks.

    The main motivation behind the Optional class is to provide a type-level solution for representing optional values instead of using null, which helps in writing more readable, maintainable, and clean code. It aims to reduce the number of null pointer exceptions in Java applications, which are a common source of runtime failures.

9. What are the advantages of using the Optional class?

    1. Improved Code Semantics: By using Optional, the intent of the code becomes clearer. When a method returns an Optional, it's a strong indication that there might not always be a value to return. This makes the API more expressive and allows developers to handle the potential absence of a value explicitly.

    2. Reduces Null Pointer Exceptions (NPEs): One of the most common runtime exceptions in Java is the NullPointerException. By using Optional to represent the absence of a value, the risk of encountering an unexpected null is reduced, leading to safer code.

    3. Encourages Proactive Handling of Absent Values: Since Optional forces you to explicitly deal with the case where a value might be absent, it promotes a more proactive approach to handling such scenarios, as opposed to deferring null checks or potentially overlooking them.

    4. Rich API for Dealing with Optional Values: Optional provides a variety of utility methods to deal with optional values, such as orElse(), ifPresent(), map(), and filter(). This allows for more expressive and fluent operations on potential values.

    5. Supports Functional Programming Patterns: Optional can be combined with Java's Streams and Lambda functions to write concise and functional-style code. Operations like map, filter, and flatMap on Optional are similar to those on Stream, which makes it easier to apply functional programming techniques.

    6. Better Code Readability: Handling potential null values with if-else checks can clutter the code. With Optional, you can streamline such checks and make the code more readable.

    7. Alternative to Null: In some functional programming languages, the absence of a value is represented by constructs similar to Optional, rather than using null. By providing an Optional class, Java offers a way to move towards this paradigm, even if it doesn't eliminate null values entirely.

    8. Enhanced API Design: When designing APIs, returning Optional for methods that might not always produce a value makes the API more user-friendly. The user of the API knows to expect an Optional and can handle the result accordingly.

10. What is the @FunctionalInterface?

    The @FunctionalInterface is an annotation introduced in Java 8, which indicates that the interface is intended to be a functional interface. A functional interface is an interface that has just one abstract method, and they can have multiple default or static methods. The primary purpose of functional interfaces is to facilitate lambda expressions and method references in Java.

11. What is lamda?

    Lambda expressions, often referred to as just "lambdas", were introduced in Java 8. They are a significant feature that brought a new way to write instances of single-method interfaces (functional interfaces) in a much more concise, expressive, and readable way. They are used primarily to define inline implementation of a functional interface.
    
    A lambda is characterized by the following syntax:
    ```
    (argument1, argument2, ...) -> { body }
    ```
    
12. What is Method Reference?

    Method references in Java are a shorthand notation of a lambda expression to call a method. Introduced in Java 8, they provide an easy way to refer to a method without executing it, making the code more readable and concise.

    Method references are often used in contexts expecting a functional interface, such as with Streams or optionals.

    There are four main types of method references:

    - Reference to a static method: Uses the class name.
      
      ClassName::staticMethodName
      ```
      List<String> strings = Arrays.asList("a", "b", "c");
      strings.forEach(System.out::println);  // Method reference
      ```
      
     - Reference to an instance method of a particular object: Uses the object reference.
    
       objectReference::instanceMethodName
       ```
       String string = "Hello";
       Predicate<String> methodRef = string::startsWith;  // Method reference
       System.out.println(methodRef.test("He"));  // true
       ```
     
     - Reference to an instance method of an arbitrary object of a particular type: Uses the class name.
     
       ClassName::instanceMethodName
       ```
       List<String> strings = Arrays.asList("a", "b", "c");
       boolean allMatch = strings.stream().allMatch(String::isEmpty);  // Method reference
       ```

     - Reference to a constructor: Uses the new keyword.

       ClassName::new
       ```
       Supplier<List<String>> listSupplier = ArrayList::new;  // Method reference
       List<String> list = listSupplier.get();
       ```

13. What is Java 8 new features?

    1. Lambda Expressions:

       This feature allows us to write instances of single-method interfaces (functional interfaces) in a much more concise, expressive, and readable way.

       It also provides a way to use functional programming features in Java.

    2. Functional Interfaces:

       - Interfaces with just one abstract method, but they can have multiple default or static methods.
       - Common examples from Java's standard library are Runnable, Callable, Comparator, etc.

    3. Streams:

       - A new abstract layer introduced in Java 8. With streams, we can process data in a declarative way.
       - It supports different types of iterations like parallel and sequential.
       - Streams can work with lambdas and can support massive data sets.

    4. Default Methods:

       - Allow developers to add new methods to interfaces with keeping backward compatibility with classes that already use this interface.
       - Introduced to enhance the libraries in a backward-compatible way.

    5. Method References:

       - Used to call a method by referring to it with the help of its name and class/object.       
       - They behave exactly like lambda expressions but use a much shorter syntax.

    6. Optional:

       - A container that may or may not contain a non-null value.
       - Helps in writing programs that can handle null values without throwing a NullPointerException.

    7. CompletableFuture:
       
       - Used for asynchronous programming.
       - Represents a future result of an asynchronous computation.

14. Lambda can use unchanged variable outside of lambda? What is the details?
 
    Yes, in Java, lambda expressions can capture variables from their enclosing scopes, similar to how anonymous inner classes do. Such variables are referred to as "captured variables". However, there are some restrictions:

    - Final or Effectively Final Variables: Lambda expressions in Java can only capture (or "close over") variables that are final or "effectively final". An "effectively final" variable is one that is not modified after it's initialized. In other words, the variable doesn't have to be explicitly marked as final (though it can be), but you cannot modify it after we assign it a value if we want to use it inside a lambda.

    - No Shadowing: Lambda expressions do not allow parameter shadowing. This means that if we declare a parameter of the lambda with the same name as a variable from an outer scope, we will get a compiler error. This behavior differs from that of anonymous inner classes.

    - Instance and Static Variables: Lambda expressions can freely access instance variables and static variables from their enclosing classes without any restrictions, as these are always heap-allocated and can be shared among lambda and its enclosing instance.
 15. Describe the newly added features in Java 8?

    The same as problem 13.

16. Can a functional interface extend/inherit another interface?

    Yes, a functional interface can extend or inherit another interface, but there are some constraints:

    - The child interface must not have any additional abstract methods other than the parent interface. If it does, then the child interface will no longer be a functional interface.  A functional interface can only have one abstract method.

    - The parent interface being extended can either have an abstract method or no abstract methods at all.

17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

    A lambda expression is a concise representation of an anonymous function that can be passed around. It doesn't have a name but has a list of parameters, a body, a return type, and also possible thrown exceptions. Introduced in Java 8, lambda expressions primarily aim to promote functional programming and simplify the verbosity of anonymous inner classes.
    
    Relationship between Lambda Expression and Functional Interface:

    - Definition Link: A lambda expression in Java is essentially an instance of a functional interface. A functional interface is an interface that has just one abstract method (though it can have multiple default or static methods). The single abstract method's signature effectively defines the signature of the lambda expression.

    - Usage: Since a lambda is an instance of a functional interface, we can use lambdas wherever functional interfaces are expected. For example, commonly used functional interfaces from the java.util.function package include Predicate, Function, Consumer, and Supplier.

    - Type Inference: Java's type system determines the lambda's signature using the single method of the functional interface. The context in which the lambda is used (the target type) is inferred to match the single abstract method's signature.

18. In Java 8, what is Method Reference?

    See problem 13.

19. What does the String::ValueOf expression mean?

    The expression String::valueOf is a method reference in Java. Method references provide a way to refer to methods without invoking them and are often used in conjunction with Java's functional programming constructs, especially streams and lambdas.

    The String::valueOf expression refers to the valueOf method of the String class. This method is overloaded to accept different types of arguments, and it returns the string representation of the given argument.

    For instance, the String.valueOf method can take an int, a double, a char, an Object, etc., and it will return the string representation of that argument.

20. What are Intermediate and Terminal operations?

    1. Intermediate Operations:

       1. These operations are used to transform the stream into another one. They are always lazy, meaning they won't execute until a terminal operation is invoked on the stream.
       2. They return a new stream, allowing operations to be chained.
       3. Examples include:
         - filter(Predicate<T> predicate): Returns a stream that matches the given predicate.
         - map(Function<T, R> mapper): Transforms each element in the stream using the given function.
         - sorted(): Returns a stream sorted according to the natural order.
         - distinct(): Returns a stream with unique elements (according to their hashCode and equals methods).
         - peek(Consumer<T> action): Returns a stream that is identical to the original, but performs a specified action on each element as they are consumed from the resulting stream.
       
        These operations are not executed until a terminal operation is called. This is called "lazy processing" and allows for optimization, such as short-circuiting.

     2. Terminal Operations:

        1. These operations produce a result or a side-effect. Once invoked, the stream pipeline processes the data and the stream can no longer be used.
        2. Examples include:
           - forEach(Consumer<T> action): Performs an action for each element in the stream.
           - collect(Collector<T, A, R> collector): Mutates the elements of the stream into a different shape or type, commonly used to produce collections.
           - reduce(BinaryOperator<T> accumulator): Performs a reduction on the elements of the stream.
           - sum(), average(), min(), max(): Common reduction operations on streams of numbers.
           - allMatch(Predicate<T> predicate), anyMatch(Predicate<T> predicate), noneMatch(Predicate<T> predicate): Returns boolean values based on the predicates provided.
           - findFirst(), findAny(): Return an Optional describing some element of the stream.
           - count(): Returns the number of elements in the stream.

21. What are the most commonly used Intermediate operations?

    See problem 20.

22. What is the difference between findFirst() and findAny()?

    1. findFirst():

       Returns an Optional describing the first element of the stream, or an empty Optional if the stream is empty.
       
       In a parallel stream, it will return the first element in the encounter order (which is the order the elements appear in the source data structure).
       
       Because it respects the encounter order, it can be somewhat less efficient in parallel streams as the processing might need to wait for earlier elements to be processed.

     2. findAny():

        Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
        
        It doesn't guarantee any specific element will be returned, just one of the elements of the stream.
        
        In a parallel stream, it might return any element that is processed, not necessarily the first one in the encounter order. This makes it more free in terms of optimization, and it might be more efficient in parallel streams as it can return any element that finishes processing first.

23. How are Collections different from Stream?

    1. Purpose:

       - Collections: The primary purpose of a collection is to store and manage a group of elements (of the same type). Common operations on collections include adding, removing, fetching, and modifying elements.
       - Streams: The primary purpose of a stream is to describe computations on sequences of elements, particularly in a functional style. They provide a high-level abstraction for processing sequences of elements.

    2. Storage:

       - Collections: Collections are primarily about data storage. The data is stored in memory in data structures like arrays, linked lists, trees, etc.
       - Streams: Streams don't store elements. Instead, they convey elements from a source (like collections, arrays, or I/O resources) through a pipeline of computational operations.

    3. Mutability:

       - Collections: Collections are often mutable, meaning elements can be added, removed, or modified.
       - Streams: Streams are inherently immutable. They don't modify the underlying data source. Instead, they return a new stream that, when traversed, contains the elements resulting from the operations.

    4. Usability:

       - Collections: Can be used multiple times.
       - Streams: Can be traversed only once. Once we consume elements from a stream, it cannot be reused.

    5. Iterating:

       - Collections: External iteration is used, where the user or the programmer explicitly iterates over the collection.
       - Streams: Internal iteration is used, where the system controls the iteration. This allows for optimization opportunities, such as parallelization.

    6. Parallel Execution:

       - Collections: The framework has the parallel prefix versions of the data structures (like ParallelArray), but parallel computation on collections can be manually intensive.
       - Streams: They have built-in capabilities for parallel execution using the parallelStream() method. This simplifies the parallelization of operations on data.

    7. Performance Considerations:

       - Collections: Performing multiple operations (especially modifications) on large collections can be costly.
       - Streams: Operations on streams, especially with lazy evaluations, can be optimized to process data more efficiently. They also allow for pipelining and short-circuiting operations.

    8. Laziness:

       - Collections: Eager in nature.
       - Streams: Many stream operations are lazy, meaning they're not executed until a result of a processing pipeline is actually needed.

    9. Use Cases:

       - Collections: Best suited for managing and storing data.
       - Streams: Best suited for describing data manipulations using a functional approach, especially for parallel processing or when dealing with large data sources.
