> ### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
1.  Encapsulation
```
public class Encap {
    private int value;

    public void valueSetter(int value) {
        this.value = value;
    }
    public int valueGetter() {
        return this.value;
    }
}
```
2.  Polymorphism and Inheritance
```
public class PolyF {
    public int value;
    public void printSomething() {
        System.out.println("Print something");
    }
    public void printSomething(String something) {  
        System.out.println(something);
    }
}
public class PolyC extends PolyF {
    @Override
    public void printSomething() {
        System.out.println("Print something else" + super.value);
        super.prinSomething("something");
    }
}
```

> ### 2. What is wrapper class in Java and Why we need wrapper class?
- _Wrapper calsses provide a way to use primative data types as object (both wrap and unwrap)_
- _Some data structures need obejct instead of primitive types, such as List and Map. And it can represent null value if necessary_

> ### 3.  What is the difference between HashMap and HashTable?
- _HashTable is synchronized while HashMap is not_
- _HashMap allows null keys and values whiele HashTable doesn't allow_

> ### 4.  What is String pool in Java and why we need String pool? 
- _String pool is a kind of area in the meomary that store strings_
- _It's used for saving memory, and it could make the comarision between strings faster_

> ### 5.  What is Java garbage collection?
- _A kind of buildin funciton that used to collect and remove the garbage(local variables or obejcts that is no longer been pointed to)_

> ### 6.  What are access modifiers and their scopes in Java? 
- _Public: allow access from anywhere_
- _Private: allow access from same class_
- _Protected: allow access from same package or subclass_
- _Default: allow access from same package_

> ### 7.  What is final key word? (Filed, Method, Class)
- _Filed: can't be modified, like a constant_
- _Method: can't be overridden_
- _Class: can't be extended_

> ### 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
- _Filed: this filed now belong to the class instead of any instance, used when those filed used like global variables_
- _Method: this method now belong to the class instead of any instance, used when those methods are utils or it doesn't need any obejct state_
- _Class: this class now belong to the outter class instead of any instance, used when it's a nested class_

> ### 9.  What is the differences between overriding and overloading?
- _overriding: happened when a class is been extended or implemented, rewrite the function with same name, variables and return type._
- _overloading: happened inside the class, two method with same name but different parameters_

> ### 10.  What is the differences between super and this?
- _super: refer to the superclass if there is any, used to access superclass's fields or methods_
- _this: refer to current instace of class, used to access fields or methods_

> ### 11.  What is the Java load sequence?
- _static block => static fields => constructor => non-static fields_

> ### 12.  What is Polymorphism ? And how Java implements it ? 
- _Refers to the same object exhibiting different forms and behaviors_
- _Overload in the same class and override by extend or implement_

> ### 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 
- _Refers to binding the data and the methods to manipulate that data together in a 
single unit (class)_
- _Private fields and public getter and setter_
- _Prevent the directly access to field, and promoting maintainability_

> ### 14.  What is Interface and what is abstract class? What are the differences between them?
- _Both of them can't be instantiated_
- _Interface: defines a contract of method that need to be overrided by child class(doesn't need to override default if necessary), support multiple inhertance(implement), can't have constructor and concrete method (except the default method)_
- _abstract class: Can have both abstract and concrete methods, only single inheritance(extend)_

> ### 16.  What are Queue interface implementations and what are the differences and when to use what? 
- _LinkedList: Queue with FIFO order_
- _PriorityQueue: Queue with order based on the natural order or custom comparator_
- _Depends on the use case, where LinkedList is a general queue, PriorityQueue for priority-related situation_
