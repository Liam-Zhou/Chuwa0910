1.  What is generic in Java?  and type the generic code by yourself.  
    a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic  

Generic is a feature that allow to create classes, interfaces, and methods with type as a parameter, so that it can accept and generate different data type while being used in the program.  
Done.
2.  Read those codes and type it one by one yourself. then push the code to your branch.  
    https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8
3.  practice stream API at least 3 times  
    a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82  

Done
4.  Practice Optional methods at least 2 times  
    a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java  

Done
5.  Write the Singleton design pattern include eager load and lazy load.  
```java
// eager load
public class Singleton {
    private Singleton(){}

    private static Singleton instance;

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
```java
// lazy load
public class Singleton {
    private Singleton(){}

    private static Singleton instance;

    public static synchronized Singleton getInstance(){
        if (instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
```
6.  What is Runtime Exception? could you give me some examples?  

Runtime exception is also called unchecked exception, is the exception that the program throw during execute and cannot be handled by the programmer. Like `NullPointerException`, `ArrayIndexOutOfBoundsException`, etc.  
7.  Could you give me one example of NullPointerException?  

```java
public static void main(String[] args){
    ArrayList<String> stringList = null;
    stringList.add("a");
}
```
8.  What is the Optional class?   

An `Optional` object can contain non-null value or `null`, and provides several methods to better dealing with the data.

9.  What are the advantages of using the Optional class?  

`Optional` can reduce the risk of `nullPointerException` and increase the code readability by providing several function methods so that to avoid redundant null check.

10. What is the @FunctionalInterface?  

`@FunctionalInterface` is an annotation that indicates that an interface is intended to be a functional interface. A functional interface is an interface that has exactly one abstract method. This interface can be used for code readability and syntax check.

11. what is lambda?  

`lambda` is a feature to easily define a functional interface in a concise syntax. It should look like `()->{};`
12. What is Method Reference?  

Method Reference is a way to simplify particular lambda expressions that simply delegate to an existing method. For example, `name -> name.length()` can be changed to method reference `String::length`.
13. What is Java 8 new features?  
    - Lambda expression and method reference;
    - Default method and static method in an interface;
    - Optional;
    - Stream api.  
14. Lambda can use unchanged variable outside of lambda? what is the detail?  

Yes, as long as the variable is final or never changed during the whole lambda scoop; it is ok that this variable is referring to an object, as long as the memory location stay still.  
15. Describe the newly added features in Java 8?  
    - you can use default method and static method in an interface;
    - you can use Lambda expression and method reference, which is a more concise way to define a functional interface;
    - you can use `Optional` to treat `nullPointerException` and null check more elegant and concise;
    - you can use stream api to do complicated data process in a concise and easy-read way.
16. Can a functional interface extend/inherit another interface?  

Yes, as long as the functional interface maintain only one abstract method, it can extend other interfaces.
17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?  

Lambda expression is a concise way to rewrite the abstract method of a functional interface. It can rewrite the abstract method inside other methods body in one line, to avoid a redundant rewrite syntax.
18. In Java 8, what is Method Reference?  

Method Reference is a way to simplify particular lambda expressions that simply delegate to an existing method. For example, `name -> name.length()` can be changed to method reference `String::length`.
19. What does the String::ValueOf expression mean?  

it means for an input `String string`, we return `string.ValueOf()`; It is the same as lambda expression `s -> s.Valueof()`.
20. What are Intermediate and Terminal operations?  

Intermediate operation is the operation that transform a stream into another stream or perform some kind of intermediate processing on the elements of the stream.  
Terminal operations is the operations that produce a result and terminate the stream process.
21. What are the most commonly used Intermediate operations?  

`filter()`, `map()`, `limit()`, `skip()`, `distinct()`, etc.
22. What is the difference between findFirst() and findAny()?  

`findFirst()` return the first element in the stream, while `findAny()` return any element from the stream, no specific order.
23. How are Collections different from Stream?  

`Collections` is a data structure used for data storage, while `Stream` is an api used for data processing with no data being stored. 