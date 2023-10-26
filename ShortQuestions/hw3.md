### HW3 - Ke Chen

## 1. practice colletcion
see file in coding : Collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example.
***Checked Exception***: Checked exceptions are the one which <u>are checked at compile-time</u>. 
For example,SQLException, ClassNotFoundException, etc.

***Unchecked Exception***: Unchecked exceptions are the one which <u>are handled at runtime because they can not be checked at compile-time</u>. For example, ArithmaticException, NullPointerException,ArrayIndexOutOfBoundsException, etc.

## 3. Can there be multiple finally blocks?
No.

## 4. When both catch and finally return values, what will be the final result?
The value returned by the finally block takes precedence. 
The value returned by the catch block is effectively discarded.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
***Checked Exception = Compile Exception***: Checked exceptions are the one which <u>are checked at compile-time</u>. 
For example,SQLException, ClassNotFoundException, etc.

***Unchecked Exception = Runtime Exception***: Unchecked exceptions are the one which <u>are handled at runtime because they can not be checked at compile-time</u>. For example, ArithmaticException, NullPointerException,ArrayIndexOutOfBoundsException, etc.

## 6. What is the difference between throw and throws?
    1.basic
        the throw keyword is used to throw an exception explicitly.
        the throws keyword is  used to declare an exception.
    2.follow
        the throw keyword is followed by an instance and is used within the method
        the throws keyword is followed by class and is used with the method signature
    3.multiple exceptions
        cannot throw multiple exceptions
        can declare multiple exceptions
    4.checked exceptions
        the throw keyword cannot propagate checked exception only
        the throws keyword can propagate checked exception

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
Because the catch blocks should be ordered from the most specific (i.e., subclasses) exceptions to the most general (i.e., superclasses) exceptions.

In the code, ArithmeticException and NullPointerException are both more specific exceptions than RuntimeException and Exception. They are subclasses of RuntimeException, which is a subclass of Exception.

## 8. What is optional? why do you use it? write an optional example.
Java introduced a new class Optional in Java 8. 

It is a public final class which is used to <u>deal with NullPointerException</u> in Java application. It is designed to <u>help handle situations where a value might be absent or present, without the need for explicit null checks</u>.
We must import java.util package to use this class. It provides methods to check the presence of value for particular variable.

```
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Creating an Optional with a non-null value
        Optional<String> optionalString = Optional.of("Hello, World!");

        // Checking if a value is present
        if (optionalString.isPresent()) {
            String value = optionalString.get();
            System.out.println("Value is present: " + value);
        } else {
            System.out.println("Value is absent.");
        }

        // Creating an Optional with a null value
        Optional<String> emptyOptional = Optional.ofNullable(null);

        // Checking if a value is present using isPresent()
        if (emptyOptional.isPresent()) {
            String value = emptyOptional.get(); // This won't be executed because the Optional is empty
            System.out.println("Value is present: " + value);
        } else {
            System.out.println("Value is absent.");
        }

        // Using orElse() to provide a default value if the Optional is empty
        String result = emptyOptional.orElse("Default Value");
        System.out.println("Result: " + result); // This will print "Result: Default Value"
    }
}
```

## 9. Why finally always be executed ?
The finally block <u>is mainly used to place the cleanup code such as closing a file or closing a connection</u>. 

***Resource Cleanup***: The primary use of finally is to provide a place for resource cleanup, such as closing files, database connections, or network sockets. Regardless of whether an exception occurs in the try block or not, you want to make sure that these resources are properly released.

***Guaranteed Execution***: By executing the finally block, Java guarantees that any code placed there will be executed, even if an exception is thrown and caught higher up the call stack. This ensures that your program can gracefully handle exceptional situations and perform necessary cleanup.

***Predictable Behavior***: Having the finally block always execute makes the behavior of exception handling more predictable and reliable. It ensures that you have a consistent mechanism for cleanup, and it eliminates the need for special cases or workarounds to ensure resource cleanup.

## 10. What is Java 8 new features ?
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

## 11. What are the types of design patterns in Java ?
Design patterns are recurring solutions to common problems in software design.
设计模式是在面向对象软件设计中经常出现的特定解决方案的描述或模板。
有些模式可能比较复杂，所以理解基本的设计模式（如工厂模式、单例模式、装饰器模式等）可以作为良好的起点。

选择几个最常用的设计模式进行深入学习。比如创建型模式（如工厂模式、单例模式）、结构型模式（如适配器模式、装饰器模式）和行为型模式（如观察者模式、策略模式）。

Abstract Factory：抽象工厂是一种创建型设计模式，它提供了一种方式，可以封装一组具有共同主题的单个工厂，而无需指定它们的具体类。它帮助实现高级的封装性，当一个类的实现需要被替换时，客户端代码可以不受影响。
Builder：建造者是一种创建型模式，它提供了一种构建对象的有效方式。与使用多个构造函数的传统方式相比，使用Builder模式可以保证代码的可读性和稳定性。这种模式特别有用在创建复杂对象时。
Adapter：适配器是一种结构型设计模式，它允许对象使用不兼容的接口进行交互。适配器可以帮助我们将一个类的接口转换成客户端期望的另一个接口。
Decorator：装饰者是一种结构型设计模式，它允许将行为动态地添加到单个对象，而不影响从该类派生的其他对象。装饰者模式是一种替代继承的方法，提供了更好的灵活性。
Observer：观察者是一种行为型设计模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，这个主题对象在状态变化时，会通知所有观察者对象，使它们能够自动更新自己。
Singleton：单例是一种创建型设计模式，它保证一个类只有一个实例，并提供一个全局访问点。使用场景主要是对于频繁使用的对象，例如数据库连接池、日志对象等。
Strategy：策略模式是一种行为型模式，定义了一系列的算法，并将每一个算法封装起来，使它们可以相互替换，让算法的变化独立于使用算法的客户。

### Creational Patterns:
These patterns deal with object creation mechanisms, trying to create objects in a manner suitable for the situation.
Examples include Singleton, Factory Method, Abstract Factory, Builder, and Prototype patterns.
Structural Patterns:
Structural patterns focus on the composition of classes and objects to form larger structures. They often involve interfaces and inheritance.
Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy patterns.
### Behavioral Patterns:
Behavioral patterns are concerned with how objects interact and communicate with one another. They deal with the responsibilities and collaborations between objects.
Examples include Observer, Strategy, Command, Chain of Responsibility, State, Interpreter, Memento, Template Method, and Visitor patterns.
### Concurrency Patterns:
Concurrency patterns address multi-threading and concurrent programming challenges. They help manage and coordinate concurrent tasks effectively.
Examples include Producer-Consumer, Reader-Writer, and Mutex patterns.
### Architectural Patterns:
Architectural patterns define the overall structure and organization of software systems. They provide guidelines for building large-scale applications.
Examples include Model-View-Controller (MVC), Model-View-Presenter (MVP), Model-View-ViewModel (MVVM), and Layered Architecture patterns.
### J2EE (Java 2 Platform, Enterprise Edition) Patterns:
These patterns are specific to enterprise-level Java applications and address concerns related to distributed systems, scalability, and performance.
Examples include Business Delegate, Service Locator, Data Access Object (DAO), and Transfer Object patterns.
### Other Patterns:
In addition to the standard categories mentioned above, there are other specialized patterns that address unique design problems.
Examples include Dependency Injection (DI) patterns (e.g., using frameworks like Spring), Aspect-Oriented Programming (AOP) patterns, and Anti-Patterns (common design mistakes to avoid).

## 12. What are the SOLID Principles ?
The SOLID principles are a set of five design principles that aim to help software developers create more maintainable, flexible, and understandable code. 

The SOLID acronym stands for:
### Single Responsibility Principle (SRP):
A class should have only one reason to change, meaning it should have only one responsibility.
In Java, this principle suggests that <u>a class should have only one primary purpose</u>, and if you find that a class is doing multiple unrelated things, consider splitting it into smaller, more focused classes.
### Open/Closed Principle (OCP):
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
In Java, you should design <u>your classes and modules in a way that allows you to add new functionality through extension (e.g., subclassing or implementing interfaces) without modifying the existing code</u>.
### Liskov Substitution Principle (LSP):
Subtypes must be substitutable for their base types without altering the correctness of the program.
In Java, this means that <u>derived classes (subtypes) should be able to replace their base classes (superclasses) without causing unexpected behavior</u>.
### Interface Segregation Principle (ISP):
Clients should not be forced to depend on interfaces they do not use.
In Java, this principle suggests that you should define small, focused interfaces rather than large, monolithic ones. Clients should only implement the methods they need.
### Dependency Inversion Principle (DIP):
High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.
In Java, this principle <u>encourages the use of interfaces and abstract classes to define abstractions that high-level modules depend on</u>, allowing for flexibility and ease of testing.

## 13. How can you achieve thread-safe singleton patterns in Java ?
thread-safe singleton patterns: only one instance of a class is created even in a multithreaded environment.

### Eager Initialization (Thread-Safe):
In this approach, the Singleton instance is created eagerly, which means it's created at the time the class is loaded.
It's inherently thread-safe because the JVM guarantees that class loading is a synchronized operation.
```
public class Singleton {
    // Eagerly create the Singleton instance
    private static final Singleton instance = new Singleton();

    // Private constructor to prevent instantiation from other classes
    private Singleton() { }

    // Provide a public method to access the Singleton instance
    public static Singleton getInstance() {
        return instance;
    }
}
```

### Lazy Initialization with Double-Checked Locking (Thread-Safe):
This approach creates the Singleton instance lazily when it is first requested. It uses double-checked locking to ensure thread safety.
It's efficient because it avoids creating the instance until it's needed.
```
public class Singleton {
    private static volatile Singleton instance; // Volatile is important for visibility

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

## 14. What do you understand by the Open-Closed Principle (OCP) ?
Open/Closed Principle (OCP):
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
In Java, you should design your classes and modules in a way that allows you to add new functionality through extension (e.g., subclassing or implementing interfaces) without modifying the existing code.

## 15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able tp 
perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of 
type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

The correct answer is: 3
Liskov's Substitution Principle (LSP) states that if class B is a subtype of class A, then objects of type A should be replaceable with objects of type B without affecting the correctness of the program. This implies that class B should adhere to the contract established by class A, including having compatible methods and behaviors. Therefore, option 3 accurately describes the essence of the Liskov Substitution Principle.

## 16. Watch the design pattern video, and type the code, submit it to MavenProject folder
see file in MavenProject: designPattern

