
### problem 5. Eager loading:
```java
public class EagerLoadedSingleton {//always create exactly one instance

    private static final EagerLoadedSingleton instance = new EagerLoadedSingleton();

    private EagerLoadedSingleton() {}

    public static EagerLoadedSingleton getInstance() {
        return instance;
    }
}
```

Lazy Loading: 
```java
public class LazyLoadedSingleton {//create exactly one instance until we need it

    private static LazyLoadedSingleton instance;

    private LazyLoadedSingleton() {}

    public static synchronized LazyLoadedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyLoadedSingleton();
        }
        return instance;
    }
}
```

### problem 6 
Runtime execeptions are errors that the compiler couldn't detect during compile time. The best example would be array index out of bound exception.

### problem 7
Nullpointer exception example: 
```java
new List<Integer> a = null;
a.add(0);
```

### problem 8 
Optional class: a container that contains a null or non-null object.

### problem 9 
By using optional class, in the case of some code might produce null exceptions, we can just use optional to substitue the expected null value.

### problem 10
@functionalInterface annotation marks an interface with only one abstract method, and multiple default method. You can override the methods in functional Interface in it's extended class.

### problem 11
Lambda expression is something we use to implement the functional interface without creating a class. It's also called anonymous functions, because it eliminates the functions name, signature, and return type, and only keeps what it does.

### problem 12
Method reference is if we treat method as a variable and pass them into a higher order functions, lambda expression is the implementation of Method reference. You can also pass method reference into stream API methods.

### problem 13
Java 8 new features that we covered in class: Optional class, lambda expression, stream API.

### problem 14
All the variables used in lambda expression must remains unchanged in it's outer scope. Java does this to insure the functional programming principle and avoid concurerency issues.

### problem 15
answered in 13.

### problem 16
Yes. The extended interface cannot create another abstract class, because the parent already has one. But it can add multiple default methods different than their parents.

### problem 17
Lambda expression is something we use to implement the functional interface without creating a class.

### problem 18
Same as problem 12.

### problem 19
String::valueOf is the method reference for string.valueof that transfer a an integer into a string. You can use this in stream API like .map(String::valueOf).

### problem 20
In Stream API, operations are categorized as Intermediate operations and Terminal operations. Intermediate operation is more for filtering, mapping or sort. Terminate operations are for to predict, search, or collect.

### problem 21
Filter() and map() are the most common used intermediate operations. Filter would filter out elements given the lambda expression condition. Map would transform every elements in the stream given the method reference.

### problem 22
Findmany returns an optional class object if any elements of the described condition is found. Find first returns an optional  class object if the first element in the collections is found.

### problem 23
Collections are just more advanced object data Storage, it stores data. Stream is data computations, and it's content will be removed after being used.
