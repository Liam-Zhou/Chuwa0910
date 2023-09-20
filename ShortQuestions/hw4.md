**********************************
Q1. Coding/hw4/q1
**********************************
Q2. Coding/hw4/q2
**********************************
Q3. Coding/hw4/q3
**********************************
Q4. Coding/hw4/q4
**********************************
Q5. Coding/hw4/q5
**********************************
Q6. Runtime exception is the super class that exceptions throws during normal operation in JVM.
1. NullPointerException: When the pointer heads to a null object that does not exist in a data structure. 
2. ArrayIndexOutOfBoundsException: Get a number in list which is over the list length. 
3. ClassCastException: a String object cannot be cast to an Integer object.
4. InvalidArgumentException: Thrown to indicate that a method has been passed an illegal or inappropriate argument.
**********************************
Q7. NullPointerException: When get a value from a hashmap, we need to check if the key is existing in the map, otherwise it may
throw a NPE if the key is not in the map.
**********************************
Q8. The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values.
The class was introduced in the java.util package to remove the need for multiple null checks to protect 
against the dreaded NullPointerExceptions during run-time.
**********************************
Q9. We can hold an object with null values. Avoid multiple null checks. Help us better read and understand the code. 
**********************************
Q10. @FunctionalInterface is a mark that help JVM to know this interface is a Funtional Interface and do a sanity check by this annotation.
**********************************
Q11. A lambda is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, 
but they do not need a name, and they can be implemented right in the body of a method.
**********************************
Q12. Method reference is used to refer method of functional interface. 
Method Reference is a clear version of lambda expression.  
The method references can only be used to replace a single method of the lambda expression.
**********************************
Q13. It contains: Lambda, functional interface, optional class, stream API, default method and static method in interface.
**********************************
Q14. Yes. Lambda(expression) can use unchanged variable outside of lambda. 
Or to say, a final variable or an effectively unchanged variable that can be a non-final variable. 
For defining an effectively unchanged variable, it must contain the save value during, before, and after the lambda. 
Or to say, a variable that stores in an unchanged address. 
**********************************
Q15. It contains: Lambda, functional interface, optional class, stream API, default method and static method in interface.
**********************************
Q16. A functional interface can extend another interface when it does not have any abstract method. 
**********************************
Q17. lambda expression is a short block of code which takes parameters and return a value. Lambda expression are similar to methods, but 
it does not have a method name, it can directly implement the method body. 

The Lambda expression is used to provide the implementation of an interface which has functional interface. 
It saves a lot of code. In case of lambda expression, 
we don't need to define the method again for providing the implementation.
**********************************
Q18. Same as Q12. 
**********************************
Q19. It means, x-> return String.valueOf(X) in lambda expression. 
**********************************
Q20. In java 8 new feature: Stream API, we can say there are three operations, Create stream object, Intermediate Operations, and Terminal operations. 
Intermediate operations is to filter and map values from a stream. And terminal operation is to collect the result stream to a java data type. 
**********************************
Q21. Intermediate operations has two steps commonly speaking. 
1. Filtering: 
    filter(Predicate p), We need a lambda that can return a boolean value to decide which value filtered out. 
    limit(n): we limit the filter value number to be n. 
    skip(n): skip first n elements. 
    distinct(): removing duplicated elements by hashCode and equals().
2. Mapping:
    map(function f) 
    flatmap(function f): element ->blackbox f -> return a new element
3. Sorting: 
    sort()
**********************************
Q22. 
1. findFirst(): return the first value in stream
2. findAny(): return a random value in stream 
**********************************
Q23. Collections will hold a data structure, so its length and type are fixed, while in stream API, no data hold, we can process as much as possible data we need. 
Collections can be traverse many times, but stream API can only go once. 
Collections' elements are easily to access whilc stream API does not have a direct way to access specific element.
Collection is a data store while stream API is an API to process data. Different meaning. 
**********************************

