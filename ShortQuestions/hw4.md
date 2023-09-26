5.
public class EagerLoad {

    // Create the instance at the time of class loading
    private static final EagerLoad INSTANCE = new EagerLoad();

    // Private constructor to prevent instantiation from outside
    private EagerLoad() {}

    // Provide a global point of access
    public static EagerLoad getInstance() {
        return INSTANCE;
    }
}


public class LazyLoad {

    // Declare the instance as volatile
    private static volatile LazyLoad instance;

    // Private constructor to prevent instantiation from outside
    private LazyLoad() {}

    // Provide a global point of access
    public static LazyLoad getInstance() {
        // Double-check locking
        if (instance == null) {
            synchronized (LazyLoad.class) {
                if (instance == null) {
                    instance = new LazyLoad();
                }
            }
        }
        return instance;
    }
}

6.
RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine. RuntimeException and its subclasses are unchecked exceptions.

7.
String str = null;
int length = str.length(); // Throws NullPointerException

8.
The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The primary purpose of the Optional class is to help in designing more comprehensible APIs so that by just reading the signature of a method, users can tell whether to expect an optional value. It also encourages developers to handle the absent value case.

9.
Reduces Null Pointer Exceptions, Clearer code format, Chaining

10.
A functional interface is an interface that contains only one abstract method.

11.
A lambda expression is a short block of code that takes in parameters and returns a value.Lambda expressions are similar to methods

12.
A method reference is the shorthand syntax for a lambda expression that contains just one method call

13.
Lambda Expressions.
Functional Interfaces.
Method Reference.
Streams.
Comparable and Comparator.
Optional Class.
Date/Time API.
Miscellaneous

14.
Yes, lambda expressions in Java can access variables from their enclosing scope. However, there are certain restrictions. The main rule is that any local variable accessed from within a lambda must be effectively final.

15.
Lambda Expressions.
Functional Interfaces.
Method Reference.
Streams.
Comparable and Comparator.
Optional Class.
Date/Time API.
Miscellaneous

16.
Yes, a functional interface can extend another interface, but there are specific rules to follow, like Single Abstract Method (SAM) Rule

17.
Lambda provides a concise way to write anonymous functions (i.e., functions without a name). The primary goal of lambda expressions is to bring the benefits of functional programming into Java, simplifying the syntax and structure of certain tasks.

18.
A method reference is the shorthand syntax for a lambda expression that contains just one method call

19.
The expression String::valueOf is a method reference in Java that points to the valueOf method of the String class. The String.valueOf method is a static method that can take various types of arguments and convert them to their string representation.

20.
Intermediate operations return a new stream. They are always lazy, which means they will not process the elements of the stream until a terminal operation is invoked on the stream pipeline. Since they return a new stream, you can chain multiple intermediate operations without consuming the stream.
Terminal operations produce a result or a side effect and thus, they consume the stream. Once a stream has been consumed, it cannot be reused.

21.
filter(Predicate<T> predicate)
map(Function<T, R> mapper)
flatMap(Function<T, Stream<R>> mapper)
distinct()
sorted()
peek(Consumer<T> action)



22.

findFirst():
Returns the first element of the stream.

findAny():

Returns any element from the stream. It does not guarantee which element will be returned.

23.
Collections are used to store and group the data in a particular data structure like List, Set, or Map. Whereas Streams are used to perform complex data processing operations like filtering, matching, mapping, etc on stored data such as arrays, collections, or I/O resources.


