# 2. What is wrapper class in Java and Why we need wrapper class? 
#### In Java, a wrapper class is a class whose object wraps or contains a primitive data type. There are eight wrapper classes in Java, corresponding to the eight primitive data types: Byte, Short, Integer, Long, Float, Double, Character, and Boolean. They come with a lot of utility functions.
#### The reason to use wrapper class have:
#### 1. there are many places in java applications where you need objects instead of primitives and wrapper class treat these primitives as object
#### 2. Java's Collection framework like ArrayList, for example, works with objects and do not support primitive types, if you want to put int in it, you need to wrap it as Integer
#### 3. primitive types cannot be null, but their wrapper object can be
#### 4. wrapper class offers method to convert between data types and also serialization/deserialization of objects.

# 3. What is the difference between HashMap and HashTable?
#### 1. Hashmap is not thread-safe and HashTable is thread-safe, because hashmap is non-synchronized where hashtable is synchronized
#### 2. Hashmap allows null key and values, where HashTable doesn't and it will throw NullPointerException

# 4. What is String pool in Java and why we need String pool? 
#### string pool is a special area in memory where JVM stores string literals. The reason to use String pool for java is that it provides with memory efficiency and performance efficiency because only one instance of same string will be stored in the memory but can be assigned to multiple references, offering reusability.

# 5. What is Java garbage collection?
#### garbage collection in java refers to the process by which JVM automatically manages memory by reclaiming memory that is no longer in use or referenced by any part of a Java program

# 6. What are access modifiers and their scopes in Java? 
#### public: The most permissive access modifier. Members declared as public are accessible from any other class or package. There are no restrictions on their visibility.
#### protected: Members declared as protected are accessible within their own class, within the same package, and by subclasses (even if those subclasses are in different packages). However, they are not accessible from outside the package unless the subclassing relationship is established.
#### private: The most restrictive access modifier. Members declared as private are accessible only within their own class. They are not visible or accessible from any other class, even within the same package.
#### default (package-private): If no access modifier is specified (i.e., no modifier is used), the default access modifier is applied. Members with default access are accessible only within their own package. They are not visible to classes outside the package.

# 7. What is final key word? (Filed, Method, Class)
#### Final Fields: When you declare a field as final, you are indicating that it cannot be modified (i.e., it becomes a constant). It must be initialized when declared or within the constructor of the class, and once initialized, its value cannot be changed.
#### Final Methods: When you declare a method as final, you are preventing it from being overridden by subclasses. Subclasses cannot provide their own implementation of a final method; they must use the method as-is.
#### Final Classes: When you declare a class as final, you are indicating that it cannot be extended by other classes. In other words, no subclass can be created for a final class.

# 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
#### The static keyword in Java is used to define members (fields, methods, and nested classes) that belong to the class itself, rather than to instances of the class. When a member is declared as static, it means that there is only one instance of that member for the entire class, regardless of how many instances (objects) of the class are created

# 9. What is the differences between overriding and overloading?
#### overriding: Overriding refers to providing a new implementation for a method that is already defined in the superclass of a subclass. It is used in inheritance to change the behavior of a method in a subclass.
#### Overloading: Overloading involves defining multiple methods in the same class with the same name but different parameter lists. These methods have the same name but different signatures (i.e., different types or numbers of parameters).

# 10. What is the differences between super and this?
#### super: is used to to call the constructor, method, or field in the parent class
#### this: is used to call the constructor, method, or field in the same class

# 11. What is the Java load sequence?
#### The sequence of loading Java class is: static field > static block > constructor > method

# 12. What is Polymorphism ? And how Java implements it?
#### Polymorphism is the ability of an object to have multiple forms.
#### Java implements polymorphism by using method overloading and method overriding.

# 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
#### Encapsulation is the feature that wraps data and code together as a single unit, but hides the implementation details from the user.
#### Java use different access modifier for encapsulation
#### We need encapsulation to prevent the user from accessing and modifying the sensitive data directly, making it maintainable and secure.

# 14. What is Interface and what is abstract class? What are the differences between them?
#### Interface is a contract that specifies methods that its implementing classes must provide.
#### Abstract class is a class that cannot be instantiated and can serve as a base for other classes.
#### Differences: Interface can only have abstract methods, while abstract class can have both abstract and non-abstract methods. Multiple interfaces can be implemented by a class, while a class can only inherit from one abstract class. All interface methods are implicitly public; abstract class methods can have different access modifiers. Abstract classes can provide some method implementations, while interfaces cannot (until Java 8).

# 16. What are Queue interface implementations and what are the differences and when to use what?
#### Queue interface implementations: LinkedList, PriorityQueue, ArrayDeque
#### Differences:
#### LinkedList: doubly linked list, can be used as a queue, stack, or list, O(1) insertion and deletion, O(n) access (not random access)
#### PriorityQueue: priority queue, elements are ordered by their natural ordering or by a Comparator, O(log(n)) insertion and deletion, O(1) access
#### ArrayDeque: resizable array, can be used as a queue, stack, or deque, O(1) insertion and deletion, O(1) access
#### When to use what:
#### LinkedList: when we need to insert or delete elements frequently
#### PriorityQueue: when we need to get the smallest or largest element frequently
#### ArrayDeque: when we need to insert or delete elements frequently, but we also need random access