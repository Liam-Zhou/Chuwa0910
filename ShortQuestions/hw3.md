************************************
Q1. Coding Folder
************************************
Q2. 
`Checked Exception` is all exceptions other than Runtime exception adn Error. This kind of exception will be checked by compiler
during compile time. For example, when we read a file from driver, the compiler forces us to handle the FileNotFoundException
since the file we need may not exist at all. 

`Unchecked Exception` is runtime exception, so the compiler will not force us to handle this kind of exception. Such as NullPointerException, we still 
need to solve it. 
************************************
Q3. No. There is at most one finally block.
************************************
Q4. The return statement in finally will be the final result.

`疑问`：what about the return statement in try block? Disappear? Or What? 
************************************
Q5. Duplicated question as Q2 answered. 

`Checked Exception` is all exceptions other than Runtime exception adn Error. This kind of exception will checked by compiler
during compile time. For example, when we read a file from driver, the compiler forces us to handle the FileNotFoundException
since the file we need may not exist at all.

`Unchecked Exception` is runtime exception, so the compiler will not force us to handle this kind of exception. Such as NullPointerException, we still
need to solve it.
************************************
Q6. Throw is in a method or class body and it can throw one exception at a time, while throws is in defining a class and it can `throws` multiple exceptions.
************************************
Q7. For catching multiple exception in catch blocks, we need to catch the exception in a small to large scope. Since `Exception` has a larger scope than 
`NULL/Runtime exception`, so we put then with high priority. 
************************************
Q7 ii. The purpose of `optional class` is to provide a type-level solution for representing optional values instead of null reference. 
To create an empty Optional object, use empty() static method. 

    public void createOptionalobject(){
        String name = "yifanzhang";
        Optional<String> opt = Optional.of(name);
        Optional<String> opt2 = Optional.empty();
        Optional<String> opt3 = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
        assertTrue(opt2.isPresent());
        assertTrue(opt3.isPresent());
    }

************************************
Q8. The `finally block` always executes when the try block exits. 
This ensures that the `finally block` is executed even if an unexpected exception occurs.
************************************
Q9. Coding Folder
************************************
Q10. 

Lambda Expression

Arrays.sorting() v.s. Arrays.parallelSorting()
> Arrays.parallelSort(). This sorting method is faster when the array size is large. 




************************************
Q11. There are Singleton, Composition, and Aggregation. 
`Singleton`: Eager load, and lazy load. 

`Composition`: the lifetime of the owned object depends on the lifetime of the owner. 

`Aggregation`: lifetime of the owned object does not depend on the lifetime of the owner.
************************************
Q12. 
1. Single Responsibility Principle
2. Open-Closed Principle
3. Liskov Substitution Principle 
4. Interface Segregation Principle 
5. Dependency Inversion Principle
************************************
Q13. Use lazy load. 

    public class Singleton{
        private Singleton(){}
        
        private static class SingletonHolder(){
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }
************************************
Q14. `Open-Closed Principle(OPC)` means classes should be open for extension but closed for modification.
> Open for extension: design your classes so that new functionality can be added as new requirements are generated.
> Close for modification: once you have developed a class you should never modify it, except to correct bugs.

************************************
Q15. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitude object
of type A.
************************************
q16. Coding folder.
