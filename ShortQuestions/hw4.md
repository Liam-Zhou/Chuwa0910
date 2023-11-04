# HW4 - Ke Chen

## 1. What is generic in Java?  and type the generic code by yourself
generics <u>allow to create classes, interfaces, and methods</u> that <u>can work with different data types</u> while providing compile-time type safety.

Generic code is particularly useful for collections and data structures because it allows you to <u>create container classes that can hold elements of any type</u>.

```
public class Box<T> {
    private T value;

    public static void main(String[] args) {
        // Create a Box for Integer
        Box<Integer> integerBox = new Box<>(42);
        System.out.println("Integer Value: " + integerBox.getValue());

        // Create a Box for String
        Box<String> stringBox = new Box<>("Hello, Generics!");
        System.out.println("String Value: " + stringBox.getValue());
    }
}
```

## 2. Read those codes and type it one by one by yourself. then push the code to your branch
See file in Coding

## 3. practice stream API at least 3 times 
done

## 4. Practice Optional methods at least 2 times
done

## 5. Write the Singleton design pattern include eager load and lazy load. 
The Singleton design pattern is a creational pattern that ensures a class has only one instance and provides a global point of access to that instance.

It can be implemented in two main ways: eager loading and lazy loading.
Eager loading creates the instance at the time the class is loaded
Lazy loading creates the instance only when it's first requested.

***Eager Loading Singleton***
```
public class EagerSingleton {

    // Create an instance of the Singleton class at the time of class loading
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation from other classes
    private EagerSingleton() {}

    // Provide a global point of access to the Singleton instance
    public static EagerSingleton getInstance() {
        return instance;
    }
    
    // Add other methods and data members as needed
}
```

***Lazy Loading Singleton***
```
public class LazySingleton {

    // Declare the instance as volatile to ensure proper double-check locking
    private static volatile LazySingleton instance;

    // Private constructor to prevent instantiation from other classes
    private LazySingleton() {}

    // Provide a global point of access to the Singleton instance, creating it if needed
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
    
    // Add other methods and data members as needed
}
```

## 6. What is Runtime Exception? could you give me some examples?
Runtime Exception = Unchecked Exception: Unchecked exceptions are the one which are handled at runtime because they can not be checked at compile-time. 
For example, ArithmaticException, NullPointerException, ArrayIndexOutOfBoundsException, etc.
```
ArithmaticException:
int result = 10 / 0; // Throws ArithmeticException (division by zero)

NullPointerException:
String str = null;
int length = str.length(); // Throws NullPointerException

ArrayIndexOutOfBoundsException:
int[] numbers = {1, 2, 3};
int value = numbers[5]; // Throws ArrayIndexOutOfBoundsException
```

## 7. Could you give me one example of NullPointerException?
```
NullPointerException:
String str = null;
int length = str.length(); // Throws NullPointerException
```

## 8. What is the Optional class?
Java introduced a new class Optional in Java 8. 
It is <u>a public final class</u> which is used to <u>deal with NullPointerException</u> in Java application.
更优雅、更安全的方式处理可能为null的值。使用Optional对象，我们可以避免NullPointerException，并使代码更简洁、易读 

```
import java.util.HashMap;
import java.util.Map;
// We must import java.util package to use this class. 
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1,new User("Alice",new Address("Main Street")));
        userMap.put(2,new User("Bob",null));

        // Without Optional
        // 因为判断出 2的address == null，所以返回默认值：unknown
        String streetName = "Unknown";
        User user = userMap.get(2);
        if(user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: "+ streetName);

        /*
        It provides methods to check the presence of value for particular variable.
        Optional.ofNullable(T value): 根据一个值（可以为null）创建一个Optional对象。如果传入的值为
        null，它会创建一个空的Optional对象。这种方法适用于值可能为null的场景。
        orElse(T other): 如果Optional对象包含一个值，该方法返回这个值；如果Optional对象是空的，返回指定的默认值
        */
        streetName = Optional.ofNullable(userMap.get(2)).map(User::getAddress)
        .map(Address::getStreet).orElse("Unknown");
        System.out.println("Street name with Optional: "+streetName);
    }
}

output:
Street name without Optional: Unknown
Street name with Optional: Unknown
```

## 9. What are the advantages of using the Optional class?
It is <u>a public final class</u> which is used to <u>deal with NullPointerException</u> in Java application.
更优雅、更安全的方式处理可能为null的值。使用Optional对象，我们可以避免NullPointerException，并使代码更简洁、易读.

advantage:
1. Null-Safety:
Instead of returning null when a value may be absent, you can use Optional to indicate that a value may or may not be present, making it clear that the value is optional.
2. Expressive API:
Optional provides a clear and expressive API for working with optional values. 
You can use methods like isPresent(), ifPresent(), orElse(), and orElseGet() to work with optional values in a more readable and concise manner.

## 10. What is the @FunctionalInterface?
Functional interface:
 1. <u>Has only one abstract method</u>
    2. @FunctionalInterface - for sanity check
    3. Can have a lot of default methods
    4. Lambda is the implementation of the abstract method.
    5. Functional interfaces are also known as Single Abstract Method Interfaces (SAM Interfaces).
    6. It can also declare methods of object class.
    
    之前学过的SAM接口中，标记了  @FunctionalInterface 注解的接口有：Runnable、Comparator、FileFilters
    
    作用：
    Functional interfaces <u>can be used as method parameter types and return value types</u>. And parameters and return values can use Lambda expressions to simplify the code. 
    可以使用函数式接口作为方法的参数类型和返回值类型使用

## 11. what is lamda?
same with Q17, see the answer in Q17

## 12. What is Method Reference?
Java 8 Method reference is <u>used to refer method of functional interface</u>.
方法引用是用来 直接访问 类或者实例的 已经存在的 方法或者构造方法。

语法：
实例对象名::实例方法
类名::静态方法
类名::实例方法

```
import java.util.Arrays;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        List<Integer> map = Arrays.asList(1, 2, 3, 4, 5);

        map.forEach(System.out::println);
    }
}

import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        String[] arr = {"hello", "world", "java", "c"};

        Arrays.sort(arr, String::compareToIgnoreCase);

        Arrays.asList(arr).forEach(System.out::println);
    }
}

import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
```

## 13. What is Java 8 new features?
### Default method and static method in interface

- Default methods:
Java provides a facility to create default methods inside the interface. Methods which are defined inside the interface and tagged with default keyword are known as default methods. These methods are non-abstract methods and can have method body.

### Lambda & Functional Interface -- 重点
- Lambda expressions:
    1. To replace anonymous inner class
    2. work with functional interface

    Lambda expression helps us to write our code in functional style.

- Functional interfaces:
    1. <u>Has only one abstract method</u>
    2. @FunctionalInterface - for sanity check
    3. Can have a lot of default methods
    4. Lambda is the implementation of the abstract method.
    5. Functional interfaces are also known as Single Abstract Method Interfaces (SAM Interfaces).
    6. It can also declare methods of object class.
    
    之前学过的SAM接口中，标记了  @FunctionalInterface 注解的接口有：Runnable、Comparator、FileFilters
    
    作用：
    Functional interfaces <u>can be used as method parameter types and return value types</u>. And parameters and return values can use Lambda expressions to simplify the code. 
    可以使用函数式接口作为方法的参数类型和返回值类型使用

### Method references
Java 8 Method reference is <u>used to refer method of functional interface</u>.
方法引用是用来 直接访问 类或者实例的 已经存在的 方法或者构造方法。

语法：
实例对象名::实例方法
类名::静态方法
类名::实例方法

引用静态方法                    ContainingClass::staticMethodName
引用某个对象的实例方法            containingObject::instanceMethodName
引用某个类型的任意对象的实例方法    ContainingType::methodName
引用构造方法                     ClassName::new
数组类型::new                    数组类型::new
```
import java.util.Arrays;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        List<Integer> map = Arrays.asList(1, 2, 3, 4, 5);

        map.forEach(System.out::println);
    }
}

import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        String[] arr = {"hello", "world", "java", "c"};

        Arrays.sort(arr, String::compareToIgnoreCase);

        Arrays.asList(arr).forEach(System.out::println);
    }
}

import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
```

### Optional class -- 重点
Java introduced a new class Optional in Java 8. 
It is <u>a public final class</u> which is used to <u>deal with NullPointerException</u> in Java application.
更优雅、更安全的方式处理可能为null的值。使用Optional对象，我们可以避免NullPointerException，并使代码更简洁、易读 

```
import java.util.HashMap;
import java.util.Map;
// We must import java.util package to use this class. 
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1,new User("Alice",new Address("Main Street")));
        userMap.put(2,new User("Bob",null));

        // Without Optional
        // 因为判断出 2的address == null，所以返回默认值：unknown
        String streetName = "Unknown";
        User user = userMap.get(2);
        if(user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: "+ streetName);

        /*
        It provides methods to check the presence of value for particular variable.
        Optional.ofNullable(T value): 根据一个值（可以为null）创建一个Optional对象。如果传入的值为
        null，它会创建一个空的Optional对象。这种方法适用于值可能为null的场景。
        orElse(T other): 如果Optional对象包含一个值，该方法返回这个值；如果Optional对象是空的，返回指定的默认值
        */
        streetName = Optional.ofNullable(userMap.get(2)).map(User::getAddress)
        .map(Address::getStreet).orElse("Unknown");
        System.out.println("Street name with Optional: "+streetName);
    }
}

output:
Street name without Optional: Unknown
Street name with Optional: Unknown

```

### Stream API  -- 重点
Java 8 java.util.stream package consists of classes, interfaces and an enum to allow functional-style operations on the elements. 
It performs lazy computation(惰性求值). So, it executes only when it requires.


‘’‘ https://www.yuque.com/fairy-era/yg511q/me04bd#8c67fb7b’‘’

Stream 是 JDK 8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
使用 Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询，当然，也可以使用 Stream API 来并行执行操作。
换言之，Stream API 提供了一种高效且易于使用的处理数据的方式。
Stream 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
“集合讲的是数据，负责存储数据，Stream 流讲的是计算，负责处理数据！

Stream的使用主要由三部分构成：
1.  Start: 构建stream 对象
2.  Intermediate operation: process数据，比如filter筛选，map转换数据
3.  Terminate operation：对数据搜集。 一旦有终止操作，该stream pipeline会终止。

## 14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes, by variable capture.
In Java, <u>lambda expressions can capture (or "close over") variables from their surrounding scope</u>. These variables are called "captured variables" or "lexical variables." 

The ability to access and use variables from the enclosing scope is known as <u>"variable capture."</u> 

***Effectively Final Variables***: 

Lambda expressions <u>can capture variables from the enclosing scope as long as those variables are effectively final</u>. If you attempt to modify an effectively final variable inside a lambda expression, it will result in a compilation error.

Example:
```
int x = 10;        // effectively final
Runnable r = () -> {
    // Accessing the effectively final variable 'x'
    System.out.println(x);
    // x++; // This would be an error because 'x' is effectively final
};
```
***Access to Non-Final Variables***: 

lambda expressions can also <u>access instance variables and static variables</u> from the enclosing class. The lambda expression captures a reference to the variable, so any changes made to the variable's state inside the lambda will be reflected in the enclosing scope. 在lambda内部改变的也会影响外面的variable
Example:
```
public class LambdaExample {
    private int count = 0;
    
    public void doSomething() {
        Runnable r = () -> {
            // Accessing the instance variable 'count'
            System.out.println(count);
            count++; // Modifying 'count'
        };
        r.run();
    }
}
```
***Accessing Method Parameters***: 

Lambda expressions <u>can also capture method parameters (as long as the parameters are effectively final or final)</u>. This can be useful when you want to use the parameters within the lambda expression.
Example:
```
public void process(int value) {
    Runnable r = () -> {
        // Accessing the method parameter 'value'
        System.out.println("Processing: " + value);
    };
    r.run();
}
```

## 15. Describe the newly added features in Java 8?
the smae as Q13

## 16. Can a functional interface extend/inherit another interface?
Yes, a functional interface in Java can extend or inherit from another interface. 
When you extend an interface to create a functional interface, you ensure that the extended interface has only one abstract method (the one required for it to be considered a functional interface).
```
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}

// Another interface that extends MyFunctionalInterface
interface AnotherInterface extends MyFunctionalInterface {
    void anotherMethod();
}

```
## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
a lambda expression is <u>a concise way to represent a block of code (a function)</u> that <u>can be passed as an argument to a method or stored as a variable</u>.
functional interface has only one abstract method and Lambda is the implementation of the abstract method.

Here's an example of a lambda expression used with the Comparator interface to sort a list of strings in ascending order:
```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Sorting using a lambda expression
names.sort((str1, str2) -> str1.compareTo(str2));
```
In this case, the lambda expression (str1, str2) -> str1.compareTo(str2) represents the comparison logic for sorting strings.

## 18. In Java 8, what is Method Reference?
same as Q12

## 19. What does the String::ValueOf expression mean?
It is an example of method reference to call the valueOf method from String class.
```
// Using a lambda expression
Function<Integer, String> intToString = (x) -> String.valueOf(x);

// Using a method reference
Function<Integer, String> intToStringReference = String::valueOf;

// Using the method reference to convert an integer to a string
String result = intToStringReference.apply(42);
System.out.println(result); // Prints "42"
```

## 20. What are Intermediate and Terminal operations?
***Intermediate operations*** are operations that transform one stream into another but do not produce a final result. 

***Terminal operations*** are operations that produce a final result or a side effect.

stream流的操作步骤：

① 创建 Stream ：通过一个数据源（如：集合、数组），获取一个流。

② 中间操作：中间操作是个操作链，对数据源的数据进行 n 次处理，但是在终结操作前，并不会真正的执行。

③ 终止操作：一旦执行终止操作，就执行中间操作链，最终产生结果并结束 Stream 。

## 21. What are the most commonly used Intermediate operations?
- filter(Predicate<T> predicate): 
    Filters elements based on a given predicate.
- map(Function<T, R> mapper): 
    Transforms elements using a provided function.
- flatMap(Function<T, Stream<R>> mapper): 
    Flattens nested streams into a single stream.
- distinct(): 
    Removes duplicates from the stream.
- sorted(): 
    Sorts the stream elements.
- peek(Consumer<T> action): 
    Performs an action on each element without consuming the stream.

## 22. What is the difference between findFirst() and findAny()?
both findFirst() and findAny() are terminal operations used to retrieve elements from a stream.

findFirst() returns the first element of the stream
findAny() returns any element from the stream, not necessarily the first one. 

## 23. How are Collections different from Stream?
集合讲的是数据，负责存储数据，Stream 流讲的是计算，负责处理数据！
1. data stored
Collections: Data structure holds all the data element
Streams: No data is stored. Have the capacity to process an infinite number of elements on demand.
2. Iteration
Collections: external iteration
Streams: internal iteration
3. times
Collections: can be processed any number of times
Streams: traversed only once
4. element access
Collections: elements are easy to access
Streams: no direct way of accessing specific elements
5. basic
Collections: is a data store
Streams: is an API to process the data