## 1. What is generic in Java? and type the generic code by yourself.

https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic   (Same code seen as Coding/Java8/generic)

Generaic in Java: it is a way that allows you to write code that operates on different data types in a type-safe and reusable manner.

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

## 3. practice stream API at least 3 times

a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

## 4. Practice Optional methods at least 2 times

a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

## 5. Write the Singleton design pattern include eager load and lazy load.

```
// Eager Load
public class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

// Lazy Load
public class Singleton {
    private Singleton() {}
    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
```

## 6. What is Runtime Exception? could you give me some examples?

Runtime Exception: Exceptions that can be thrown during the normal operation of the JVM.
E.g. NPE, IndexOutOfBoundsException, SecurityException

## 7. Could you give me one example of NullPointerException?

```
Car car = CarDao.search(String plate);
car.run();  // specific car may not be found
```

## 8. What is the Optional class?

Optional Class is used to represent a value that may or may not be present. In other words, an Optional object can either contain a non-null(present) value or no value at all (empty).

## 9. What are the advantages of using the Optional class?

Better dealing with null value. Avoid NPE.

## 10. What is the @FunctionalInterface?

It's a annotation for Functional Interface which has one single abstract method. The annotation is for the sanity check.

## 11. what is lamda?

The Lambda expression is used to provide the implementation of an interface which has functional interface.

## 12. What is Method Reference?

Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

## 13. What is Java 8 new features?

- Default method and static method in Interface
- Lambda & Functional Interface
- Method Reference
- Optional
- Stream API
- CompletableFuture

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Yes. If a variable has not changed its reference / memory address, it can be used in lambda.

- Final variable
- Non-final variable however never changed
- Object variable (has not been reassigned to a new memory)

## 15. Describe the newly added features in Java 8?

Same as Q13.

## 16. Can a functional interface extend/inherit another interface?

No. It has a single abstract method.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

The Lambda expression is used to provide the implementation of an interface which has functional interface. It saves a lot of code. In case of lambda expression, we don't need to define the method again for providing the implementation. Here, we just write the implementation code.

## 18. In Java 8, what is Method Reference?

Same as Q12.

## 19. What does the String::ValueOf expression mean?

It's a method reference to the 'valueOf' method of the 'String' class.

## 20. What are Intermediate and Terminal operations?

In Java Streams, Intermediate operations are operations that are applied to a stream and produce another stream as their result. Whereas, Terminal operations are operations that produce a result or a side-effect and terminate the stream.

## 21. What are the most commonly used Intermediate operations?

- Match & Search
  - allMatch(Predicate p)
  - anyMatch(Predicate p)
  - nonMatch(Predicate p)
  - findFirst
  - findAny
  - count
  - max(Comparator c)
  - min(Comparator c)
  - forEach
- reduce
- collect(Collectors c)

## 22. What is the difference between findFirst() and findAny()?

"findFirst" would return the first element that matches the condition, whereas "findAny" would return any element that matches the condition (not necessarily the first one).

## 23. How are Collections different from Stream?

Collections are used for storing and managing data structures, while Streams are used for processing data in a more functional and declarative way. Streams provide benefits such as lazy evaluation, immutability, and easy parallelism, making them a powerful tool for data processing tasks.
