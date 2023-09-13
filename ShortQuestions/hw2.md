***********************************
Q1.

    public class Person{
        String name;
        public Person(String name){
            this.name = name;
        }
    }

    public class Student extends Person{                        //polymorphism
        int studentId;
        int age;
        double gpa;
        String name;
    
        public Student(int studentId, String name){   
            super();                                            //inheritence
            this.studentId = studentId;
        }

                                                                //encapsulation
        public void setName(String name){this.name = name;}
        public void setAge(int age){this.age = age};
        public void setStudentId(int id){this.id = id};
        public void setGpa(double gpa){this.gpa = gpa};
        public String getName(){return this.name};
        public int getAge(){return this.age};
        public int getStudentId(){return this.studentId};
        public int getGpa(){return this.gap};
    
    }

>请确认我标注的地方是否正确，谢谢。
***********************************
Q2.
Wrapper class is a way to use primitive data type as objects.

For example: `int` as object is `Integer`.

Sometimes, we must use wrapper class instead of using primitive data type, such
as in `Collections`, `ArrayList` only stores object and primitive data type
cannot be accepted.
***********************************
Q3.
`The main difference`: HashMap is not thread safe while HashTable is.
HashMap is not synchronized so it cannot be shared between threads without
synchronization. HashTable is synchronized and it can be shared between many threads.

`Second difference`: HashMap allows a null key with multiple null values.
But HashTable does not accept any null values.

`Performance difference`: By their properties, HashMap is more powerful and faster than
HashTable if we do not consider a thread safe issue. HashTable has to wait the thread.

***********************************
Q4.
`String pool` is a special memory management tool in `java heap `
that can store existing string literal. It `privately` maintained by `java string class`.
By default, String pool is empty. It can decrease the number of String objects created in `JVM`
so reduces the memory usage.

`补充疑问`: Why java string is immutable?
Immutable means it has a constant value. Even it's altered, a new object is created.
Therefore, `java string immutability is achieved from String pool`.

`补充疑问`: Does java string type primitive? Where is primitive type stored?
No. String is not a primitive data type in java. Only, int, double, float, char, boolean, byte, short, long
are stored in Stack memory, called `Stack memory allocation`. String and other non-primitive type are stored in `Heap`.
And a `reference` to this location is hold by Stack.
[Ref Link](https://www.scaler.com/topics/java/string-pool-in-java/)

***********************************
Q5. Java GC is a process to automated remove code that no longer used. This process can free
memory generally. Java GC scans `heap` looing for objects no longer used,  and we don't need to free memory manually as in C.

Java GC Algorithm > `Mark and Sweep`:
1. Mark: When object created, mark 0, means false.
2. Then GC traverses object tree starting at root,
   If an object (may be leaf? or children of the root) is reachable from the root, mark 1, means true.
3. Sweep: java GC traverses the heap and free memory when object are marked with 0.
***********************************
Q6.
Access modifiers are OOP in java that contains `private`, `default`, `public`, `protected`.
It controls the visibility of method, constructor, field in a class.

1. `Private`: only use in the same class, cannot be accessed by others.
2. `Public`: Access from anywhere including outside package.
3. `Protected`: Any Access from the same package. For outside package, we need to write a child class.
4. `Default`: Access from only same package.

`补充疑问`: How to make a child class for protected modifier access an outside package?
subclass
***********************************
Q7. Final is a non-access modifier that only used to a variable, method, or a class.
`Final variable`: variable with constant value.
`Final method`: prevent method overriding by a subclass.
`Final class`: prevent inheritance, no extending by a subclass

`补充疑问`：Why final class make final class immutable?
Immutable class means that once an object is created, we cannot change its content.

`补充疑问`：Difference between `final`, `finalize`, `finally`?
1. final : `Reserved` keyword. Just as above answer, it limits the variable, method and class
2. finalized: It just a method in GC that will always call. It will perform before delete an object in GC.
   It can be seemed as `CLEAN UP` method in GC. However, this word is `not reserved` in java, we can override this method in any class.
3. finally: `Reserved` keyword. In `try catch` function, finally guarantees a section of code will be executed,
   even if an error is thrown. `finally` is executed even if try block has a statement.
   [See](https://www.geeksforgeeks.org/g-fact-24-finalfinally-and-finalize-in-java/?ref=lbp)
***********************************
Q8.
Static keyword means this is a constant variable or a method that is the same for every instance of a class.
Static method can be overloaded but not overridden.
Static method or variable cannot access non-static variable or method.
Static method or variable is associated with the entire class, not an object.
Static class must be a nested class. Otherwise, we cannot declare a static modifier to a class.
***********************************
Q9. Method overriding is in `runtime`, Overloading is in `compile time`.

Overloading may or may not need inheritance, but overriding must inherit.

`Both` overloading and overriding must have `same method name`, but overloading can have
different signature, argument and return type, `overriding` must have `same signature, argument, and return type`.

Overriding has a better performance.

Private and final method can be overloaded, while it cannot be overridden.
***********************************
Q10. Super is used to call `constructor in parent class`, while this is used to call `constructor in current class`.
***********************************
Q11. In JVM, Static block > Constructor > Non-static block
***********************************
Q12. Polymorphism means `many form`. For example, a person can ba a father, a man, a teacher.
It allows us to `use one interface` to have many implements.

`Compile time polymorphism`: method overloading.

`Runtime polymorphism`: method overriding.
***********************************
Q13. Encapsulation means in OOP, bind the data and method to manipulate data in the same class.

By encapsulation, data cannot be accessed from outside class directly, (can access using getter and setter), that can help
this class own data validation rules to make sure its internal statement consistency.
***********************************
Q14. An abstract class is a class that cannot be instantiated, and it may contain non-abstract method.
An interface specifies some method that must be implemented.

A class can inherit from only one abstract class. However, a class can implement multiple interfaces.

`Why?` This is because an abstract class represents a type of object, while an interface represents a set of behaviors.

An interface must have public class for access modifiers, but there is no limit on abstract class.

***********************************
Q15. In Coding file
***********************************
Q16. Queue interface is a subtype of Collection interface with FIFO order. Since queue is an interface, we cannot directly use queue as a type.
We need a class to extend queue to create an objects. The common classes are: `PriorityQueue`, `LinkedList` which is not thread safe, `PriorityBlockingQueue` is thread safe.

1. add()/offer(): add an element at the end of queue. If queue fulls, `add` throws exception. `offer()` return false.
2. peek()/element(): pick the top element and return. If queue's empty, `element` throws exception. `peek` return null.
3. remove()/poll(): remove the top element and return; If queue's empty, `remove` throws exception. `poll` return null.
   When to use it?
   Queue interface is a useful for managing collections of elements in a `specific order` by its FIFO property.








