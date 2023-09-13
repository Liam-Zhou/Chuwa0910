# HW02 Haotian Zhang

1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

   1. Encapsulation;

        ```Java
        class Node {
            private int key; 
            private int value; 
            
            public void setKey(int val) {this.key = val;}
            public void setValue(int val) {this.value = val;}
            public void check(int val) {return;}
        }
        ```

   2. Polymorphism;

        ```Java
        class sonNode extends Node {
            ...
        }

        class grandsonNode extends sonNode {
            ... 
        }
        ```

   3. Inheritance;

        ```Java
        class sonNode extends Node {
            @Override
            public void check(int val) {System.out.println("hello son.");}

            @Overload
            public void check(int val, int key) {return;}

        }
        ```

2. What is wrapper class in Java and Why we need wrapper class?

    > Wrapper class in java is a way to  use primitive data types as objects. First, what is primitive data types, they are data typed directly save on the stack not the heap, by using the wrapper class, you can directly use it as OOP.

3. What is the difference between HashMap and HashTable?

    > Hashmap is non-synchronized, and it is not thread-safe.
    > Hashtable is synchronized, and it is thread-safe.

4. What is String pool in Java and why we need String pool?

    > String pool is a container in the heap to storage the data of String. Every new String data will be saved in the pool. The reason to use String pool is to save the size of data for multi-use.

5. What is Java garbage collection?

   > Java garbage collection is a function built in the JRE. In general, it is used to collect all data which will not be used in the run time and delete them for the time and space efficiency.

6. What are access modifiers and their scopes in Java?

    > Access modifiers are use to control the accessbility of certain variable / function / value from the other object.

    | Modifier  | Discription                                |
    | -|------------------------------------------- |
    | Default   | visible in the package                     |
    | Private   | visible in the class                       |
    | Protected | visible within the package or all subclass |
    | Public    | visible everywhere                         |

7. What is final key word? (Filed, Method, Class)

    > Final key word is used to indicate that the field , method or class is not changeable.

8. What is static keyword? (Filed, Method, Class). When do we usually use it?

    > static keyword is to identify a kind of filed , method, class to become singleton, you don't need to objecize it, during the compile time, it will be created first. It is for some data you don't want to change, or you want to preload some kind of data.

9. What is the differences between overriding and overloading?

    > overriding happens in the inheritance, you want to change a function which is in your parent class. 
    > overloading happens in the same scope / same class. You want to change the parameters / signature for some functions .

10. What is the differences between super and this?

    > super means your parent clas. this means you (current class).

11. What is the Java load sequence?

    > load sequence: it will first load the static data, and later it can run the non-static data. 

12. What is Polymorphism ? And how Java implements it ?

    > Polymorphism: subclass inheritage functions, filed from this previous class by `extends`. However, java doesn't not allow multiple inheritance.

13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

    > Encapsulation: is to package all the data in the class, all variables are protected by class and go through certain functions. It will protect the data from abuse. In java, you can write some setter and getter function to access the private data.

14. What is Interface and what is abstract class? What are the differences between them?

    > Interface: it is not class, but also have functions, fields and varaibles, it can extends other intefaces.
    > Abstract class: it is kind of abstract (cannot be objectized) with abstract/normal functions, and variables. child class must be implement all abstract functions.
    > You can implements multiple interface but only extend one abstract class.

15. design a parking lot (put the code to codingQuestions/coding1 folder, )

    1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

    > In the Chuwa0910/Coding.

16. What are Queue interface implementations and what are the differences and when to use what? 

    > Queue is a container/ data structure which follow First in First out. Threre are several differnt kind of queue. 
    > LinkedList: Normal use 
    > PriorityQueue: for sort and leetcode use. 
    
