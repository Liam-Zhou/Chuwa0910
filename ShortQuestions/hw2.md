1:
```text
Encapsulation: like the implementation of ParkingSlot class, which contains member variables and member functions
Polymorphism: like the implementation of Car class, same method name but different implementation
Inheritance: like BigTruck class which extends the VehicleBase class
```

2: wrapper class

```text
to wrap the primitive type to Object, because the primitive type is not Object in Java, 
and some class need Object Type as generics parameter
```

3: HashTable vs HashMap
```text
HashTable is synchronized, HashMap is not
HashTable does not allow null key or value, HashMap allows one null key and any number of null values
```

4: what is String pool
```text
String pool is a special storage area in Java heap. When a string is created and if the string already exists in the pool,
the reference of the existing string will be returned, instead of creating a new object and returning its reference.
```
5: what is garbage collection
```text
Garbage collection is the process of automatically freeing objects that are no longer referenced by the program.
```


6: what are access modifiers
```text
public: accessible everywhere
protected: accessible within the package and outside the package but through inheritance only
default: accessible within the package only
private: accessible within the class only
```

7: what is the final
```text
final variable: cannot be changed
final method: cannot be overridden
final class: cannot be extended
```

8: what is static keyword
```text
static variable: belongs to the class, not instance
static method: belongs to the class, not instance
static block: used to initialize static variables
static class: nested class, can access static data of outer class
```

9: what is the difference between overriding and overloading
```text
overriding: Concerns having multiple methods with the same name but different parameters in the same class.
overloading: Concerns modifying or redefining the implementation of an inherited method in a subclass.
```

10: what is difference between super and this
```text
super: refers to the parent class instance
this: refers to the current class instance
```

11: What is java load sequence
```text
1. static block and variable initialization
2. instance variable initialization and instance block
3. constructor
```

12: what is Polymorphism, and how java implement it
```text
Polymorphism is the ability of an object to take on many forms.
There are two types:
1. compile-time polymorphism: static overloading, it is decided at compile time
2. run-time polymorphism: method overriding for sub class, this is decided by runtime by jvm to check the actual object type
```

13: What is Encapsulation ? How Java implements it? And why we need encapsulation?
```text
Encapsulation is the mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit.
Java provides a way of creating fully encapsulated class by providing access modifiers such as private, protected and public.
Because we do not want to other classes to modify our data structure directly to avoid the efforts of refactor the code and debug when the data is changed
```

14: What is Interface ? What is abstract class, and what is the difference between them?
```text
Interface is a blueprint of a class. It has static constants and abstract methods only.
Abstract class is a class which is declared abstract. It can have abstract and non-abstract methods.
Interface supports multiple inheritance, abstract class does not.
Interface does not have constructor, abstract class can have.
Interface cannot have instance variables, abstract class can have.
Interface cannot have method body, abstract class can have.
```

16: What are Queue interface implementations in Java?
```text
LinkedList, PriorityQueue, ArrayDeque
LinkedList: when you need to add or remove items from both ends
PriorityQueue: when you need to process items based on priority
ArrayDeque: when you need to add or remove items from both ends. But it will need to relocate the items when the capacity is not enough, so suitable for not frequent add or remove
```