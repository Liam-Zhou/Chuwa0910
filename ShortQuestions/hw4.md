5:Write the Singleton design pattern include eager load and lazy load. 
```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
        // Private constructor to prevent instantiation from outside.
    }
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

```java
public class LazySingleton {

    private LazySingleton() {
        // Private constructor to prevent instantiation from outside.
    }
    private static class LazySingletonHolder{
        public static final LazySingleton instance = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }
}
```

6: What is Runtime Exception? could you give me some examples?
```text
NULLPointerException
ArrayIndexOutOfBoundsException
```

7: Could you give me one example of NullPointerException?
```java
String s = null;
System.out.println(s.length());
```

8:  What is the Optional class
```text
Basically a functor that is used to avoid nullptr
```

9:What are the advantages of using the Optional class?
```text
Avoid NullPointerException
```

10: What is @FunctionalInterface?
```text
An interface with only one abstract method
```

11: What is lambda:
```text
A function without a name
```

12: What is Method Reference
```text
Method reference in Java is a shorthand notation that allows you to reference methods or constructors directly using their names, without invoking them explicitly.
```

13: What is Java 8 new features
```text
- lambda Expressions:
- Functional Interface
- Streams
- Default methods
- Method References
- New Data and Time API

14: Lambda can use unchanged variable outside of lambda? what is the details?
```text
Yes, but the variable must be final or effectively final
```

15: Describe the newly added features in Java 8?
```text
- lambda Expressions: method shorthand
- Functional Interface: add abstraction over the lambda being compliant with java framework
- Streams: Copy from scala
- Default methods: add default implementation to interface to avoid breaking existing code for supporting functional interface
- Method References: method shorthand
```

16: Can a functional interface extend/inherit another interface?
```text
Yes
```

17: What is the lambda expression in Java and How does a lambda expression relate
to a functional interface?
```text
A function without a name. Many methods need to take a function but also it needs to be restricted by its input and output type, which
the functional interface can provide this signature.
```

18: In Java 8, what is Method Reference?
```text
Method reference in Java is a shorthand notation that allows you to reference methods or constructors directly using their names, without invoking them explicitly.
```

19: What does the String::ValueOf expression mean?
```text
A method reference to the static method valueOf of the class String
```

20: What are Intermediate and Terminal operations?
```text
Intermediate operations return a new stream. They are always lazy; executing an intermediate operation such as filter() does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate. Traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed.
```

21: What are the most commonly used Intermediate operations?
```text
filter, map, flatMap, distinct, sorted, peek
```
22: What is the difference between findFirst() and findAny()?
```text
findFirst() returns the first element in the stream, whereas findAny() returns any element in the stream.
```

23: How are Collections different from Stream?
```text
Collections are in-memory data structures, whereas Stream is a pipeline of computational operations.
```



