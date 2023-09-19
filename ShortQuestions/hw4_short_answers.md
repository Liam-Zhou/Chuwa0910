### 1~4.
Please see the coding part.

### 5. Write the Singleton design pattern include eager load and lazy load.
### 6. What is Runtime Exception? could you give me some examples?
Runtime exception is an exception that occurs at runtime and doesn't need to be explicitly declared in a method's or constructor's throws clause.
For example, NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException.

### 7. Could you give me one example of NullPointerException?
String name = null;
int length = name.length(); // NPE
### 8. What is the Optional class?
The Optional class is a container that may or may not contain a non-null value. It helps prevent 'NullPointerExceptions'

### 9.What are the advantages of using the Optional class?
1. Improve code readability, it indicates when a value may be absent
2. Reduced NPE (NullPointerExceptions)
3. Avoids excessive null checks
4. Better error handling (use map, filter, orElse)

### 10. What's the @FunctionalInterface?
A functional interface can only have one abstract method, and can be used with lambda expressions or method references.

### 11. What's Lambda?
It's a concise way to represent an anonymous function, it allows us to define a function in a more readable and compact form, often used
for implementing functional interface, and commonly used in the Stream API.

### 12. What's Method Reference
It allows you to refer to a method of a class or an instance of an object using a concise syntax, make code more readable and maintainable.

### 13. What are Java8 new features?
1. Lambda Expressions
2. Stream API
3. Default methods in interfaces
4. Method references
5. Functional interface
6. The 'java.time' package for date and time manipulation (new Data and Time API)
7. THe 'Optional' class

### 14. Lambda can use unchanged variable outside of lambda? what is the details?
Lambda expressions can use variables from the outside scope, but these variables must be effectively final (unchanged).
An effectively final variable is one that is not reassigned after its initial assignment.

### 15. Same as 13.

### 16. Can a functional interface extend/inherit another interface?
Yes, a functional interface (an interface with a single abstract method) can extend or inherit from another interface.
When an interface extends another interface, it inherits the abstract methods from the parent interface, but it still retains its status
as a functional interface as long as it has only one abstract method.

### 17. What is the lambda expression in Java, and how does a lambda expression relate to a functional interface?
Same as 11.

### 18.In Java 8, what is Method Reference?
Same as 12.

### 19. What does the String::ValueOf expression mean?
It's a method reference, it's a static method that converts various data types (integers, floats, objects) to their string representations.
int num = 20; String str = String.valueOf(num);

### 20. What are Intermediate and Terminal operations?
1. In Java Streams, operations are categorized as Intermediate and Terminal operations, intermediate transform one stream into another.
For example, filter, map, flatMap, distinct, sorted, peek, limit
Intermediate operations enable you to filter, transform, or modify the elements in a stream. They return a new stream, so you
can chain multiple intermediate operations together.
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
List<Integer> evenSquares = numbers.stream()
    .filter(n -> n % 2 == 0) // intermediate operation
    .map(n -> n * n) // intermediate operation
    .collect(Collectors.toList()); //Terminal operation
2. Terminal Operations produces a result, a stream can have only one terminal operation, and it's the final step in the stream
processing pipeline. For example, collect, forEach, reduce, count, min, max, toArray


### 21.What are the most commonly used Intermediate operations?
filter, map, flatMap (flatten nested streams into a single stream), distinct(remove duplicate elements)

### 22. What is the difference between findFirst() and findAny()?
'findFirst': This terminal operation return the first element encountered in the stream. If the stream has an encounter order (e.g. a list), it
will return the first element in that order. It's deterministic and is often used when you need a specific element.

'findAny': This terminal operations return any element encountered in the stream. It return the first available element. It's useful when you
need 'any' element from the stream without a specific preference.
(findAny 回傳第一個match的result, findFirst回傳第一個result)

### 23. How are Collections different from Stream?
1. Collections are mutable, you can add, modify or remove elements after creation; Streams are immutable, once created, elements can't be changed.
Stream operations produce new streams but don't modify the original data.
2. Collections store and manage data in memory, they are suitable for small to medium-sized datasets; Streams are often used processing large datasets 
or data from external source like files or databases. They provide a more declarative way to process data without loading it all into memory
3. Collections are eager evaluation, which means that data is computed and stored when the collection is created; Streams use lazy evaluation, means operations 
are deferred until a terminal operation is called. This allows for optimization and handling of infinite data.
4. Collections do not provide built-in support for parallelism; Streams can be easily parallelized using the parallel() method.