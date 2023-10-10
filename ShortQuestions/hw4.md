# hw4 Difan Xue

1. What is generic in Java? and type the generic code by yourself.
In Java, "generic" refers to a feature of the language that allows you to write classes, interfaces, and methods in a way that can work with different data types while maintaining type safety.
2. Read those codes and type it one by one by yourself. the push the code to your
branch.
see the coding folder
3. practice stream API at least 3 times
see the coding folder
4. Practice Optional methods at least 2 times
see the coding folder
5. Write the Singleton design pattern include eager load and lazy load.

Eager Load

```jsx
public class Singleton{
	private static Singleton instance = new Singleton();
	private Singleton(){
	}
	public static Singleton getInstance(){
		return instance;
	}
}
```

Lazy Load

```java
public class Singleton{
	private Singleton(){
	}
	private static class SingletonHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
```

6. What is Runtime Exception? could you give me some examples?

A runtime exception, also known as a runtime error or an unhandled exception, is an error that occurs while a program is running, rather than during its compilation or build process.

NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, FileNotFoundException,…
7. Could you give me one example of NullPointerException?

```java
String str = null;
int length = str.length();
```

8. What is the Optional class?

The **`Optional`** class is a container class in Java (introduced in Java 8) that is used to represent an optional value, which can be either present or absent. It is designed to help avoid the pitfalls of dealing with null values, which can lead to **`NullPointerException`** errors if not handled properly. **`Optional`** provides a more explicit and safer way to handle cases where a value might be missing.
9. What are the advantages of using the Optional class?

Avoiding `NullPointerException`, Reduced Conditional Logic, Functional Programming
10. What is the @FunctionalInterface?

Has one single Abstract method but can have a lot of default methods. Lambda is the implementation of the abstract method.
11. what is lamda?

A lambda expression (or lambda function) is a feature introduced in Java 8 and many other programming languages that allows you to define and pass around small, anonymous functions.
12. What is Method Reference?

A method reference in Java is a shorthand notation that allows you to refer to a method as if it were a lambda expression. It provides a way to make your code more concise and readable when you want to pass a method as an argument to a higher-order function, such as a functional interface method.

`Class::MethodName`
13. What is Java 8 new features?

Optional, Lambda, Stream API, Method Reference
14. Lambda can use unchanged variable outside of lambda? what is the details?

As long as the memory location of variable don’t change, it can be used.

- Final
- Never changed
- Object Variable

15. Describe the newly added features in Java 8?

Optional, Lambda, Stream API, Method Reference
16. Can a functional interface extend/inherit another interface?

Yes, a functional interface in Java can extend or inherit another interface, but with certain conditions. A functional interface is an interface that has exactly one abstract (unimplemented) method, known as the functional method.
17. What is the lambda expression in Java and How does a lambda expression relate
to a functional interface?

A lambda expression in Java is a concise way to represent an anonymous function—a function without a name—that can be used to pass behavior as an argument to methods or to define inline functions.

A lambda expression can be used to provide an implementation of the single abstract method (SAM) defined by a functional interface.
18. In Java 8, what is Method Reference?

A method reference in Java is a shorthand notation that allows you to refer to a method as if it were a lambda expression. It provides a way to make your code more concise and readable when you want to pass a method as an argument to a higher-order function, such as a functional interface method.
19. What does the String::ValueOf expression mean?

The **`String::valueOf`** expression is an example of a method reference in Java. Specifically, **`String::valueOf`** is a method reference to the **`valueOf`** method of the **`String`** class.
20. What are Intermediate and Terminal operations?

**Intermediate operations** are operations that are applied to a stream to transform or manipulate its elements. **Terminal operations** are operations that trigger the processing of a stream and produce a final result or a side effect.
21. What are the most commonly used Intermediate operations?

filter()
22. What is the difference between findFirst() and findAny()?

findFirst() is to find the first element, findAny() is to find the random element. In the most case, we can use findFirst() instead.
23. How are Collections different from Stream?

Collection is data structure holds all the data elements.

Stream cannot store the data, but has the capacity to process an infinite number of elements on demand.