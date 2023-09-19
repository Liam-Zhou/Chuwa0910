### 1. Practice Collection
Please see the coding Part

### 2. What is the checked exception and unchecked exception in Java, could you give one example?
1. Checked Exceptions: These must be handled explicitly using 'try-catch' or declared with 'throws'. 
For example, 'IOException' or 'SQLException'
2. Unchecked Exceptions (Runtime Exception): They occur at runtime and often result  from programming errors. 
For exmaple, 'NullPointerException' or 'ArrayIndexOutOfBoundsException'

### 3. Can there be multiple finally blocks?
Yes

### 4. When both catch and finally return values, what will be the final result?
If both catch and finally return, the receiving method will get the returned value from the finally block.

### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Same question as question 2.

### 6. What is the difference between throw and throws?
'throw' is used to raise an exception explicitly within a method or block of code
'throws' is used in a method declaration to specify the types of of exceptions that the method may throw.

### 7. Based on the example code, why do we put the Null/Runtime exception before Exceptions?
If we have multiple catch blocks for different exception types, they are checked in the order they appear, and the first catch block that matches the exception
type is executed. Once a catch block is executed, subsequent catch blocks are skipped. This is why we should put more specific catch blocks
(NullPointerException, RuntimeException) before more general catch blocks (Exception.)

### 8. What is optional? why do you use it? write an optional example.
'Optional' is a class introduced in Java8. We can use 'Optional' to make the code more explicit about the possibility
of null values and to provide a way to handle null checks. 
For example, we can create an Optional with a non-null value and an Optional with a potentially null value
Optional<String> nonNullOptional = Optional.of("Hello");
String nullableValue = null;
Optional<String> optionalNullable = Optional.ofNullable(nullableValue);

and to check if the Optional has a value and getting it.
if (nonNullOptional.isPresent()){
    String message = nonNullOptional.get();
    System.out.println(message);
} else{
    System.out.println("Optional is empty);
}

### 9. Why finally always be executed ?
The finally block provides a place to put code that should execute regardless of whether an exception is thrown or caught. Besides, the finally block 
is executed even if a return statement is encountered inside the try or catch block. This allows you to perform cleanup operations before the method returns.

### 10. Practice collection problem
Please see the coding part

### 11. What is Java 8 new features ?
1. Lambda Expression, for example, use lambda expression fo sorting a list of string in descending order.
List<String> names = Arrays.asList("Alice", "Bob", "Charlie"); 
names.sort((s1, s2) -> s2.compareTo(s1));
2. Functional interface
interface Calculator {
    int calculate(int a, int b);
}
// using the functional interface with a lambda expression
Calculator add = (a, b) -> a + b;
int result = add.calculate(5, 3);
3. Streams
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filteredNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());

There are a lot of more features in Java8

### 12. What are the types of design patterns in Java ?
I think there are lots of design patterns, and we can implement them in multiple programming language. For example,
Factory Method Pattern, Abstract Factory Pattern, Builder Pattern, Prototype Pattern, Adapter Pattern, Decorator Pattern, Observer Pattern
and Singleton Pattern

### 13. What are the SOLID Principles ?
SOLID Principles is used in the Software Engineering.
1. Single Responsibility Principle (S)
Each class should have only one primary job and responsibility
Promotes focused and maintainable classes
2. Open/Closed Principle(O)
Software entities should be open for extension but closed for modification
Encourages the use of abstraction and inheritance for extensibility
3. Liskov Substitution Principle (L)
Subtypes should be substitutable for their based types without causing issues.
Ensures consistency in polymorphic behavior
4. Interface Segregation Principle (I)
Clients should not be forced to depend on interfaces they don't use
Suggests creating smaller, specialized interfaces.
5. Dependency Inversion Principle (D)
High-level modules should not depend on low-level modules. Both should depend on abstractions
Encourages decoupling through the use of abstractions and interfaces.

These principles provide guidelines for writing clean, modular, and maintainable code in OOP.

### 14. How can you achieve thread-safe singleton patterns in Java ?
You can use Lazy load with synchronization. Us synchronized to ensure only one thread creates the instance. Suitable when Singleton is rarely 
needed. Otherwise, you can use eager, load, create the singleton instance when the class is loaded. Suitable for cases where the Singleton is
always needed. We can also consider using Enum Singleton, use enum types, inherently thread-safe and safe from reflection and serialization isseus.

### 15. What do you understand by the Open-Closed Principle (OCP) ?
Software entities should be open for extension but closed for modification
Encourages the use of abstraction and inheritance for extensibility

### 16.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?
The answer should be 1. LSP states that if class B is a subtype of class A, objects of class B should be able to replace (substitute for) objects of class A without affecting the correctness of the program. 
In other words, class B should adhere to the contract established by class A, including the methods present in class A.