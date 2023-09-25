# HW3

1. **Practice collection**
    - Done

2. **What is the checked exception and unchecked exception in Java, could you give one example?**
    - Checked exception: Exceptions checked while compile, using try-catch or throw.
    - Unchecked exception: means not checket at compile-time. checked at run time. 

    **Checked/Compile Example:**
    ```java
    public class CheckedExceptionExample {
        public static void main(String[] args) {
            File file = new File("somefile.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    ```
    
    **Unchecked/Runtime Example:**
    ```java
    public class UncheckedExceptionExample {
        public static void main(String[] args) {
            int[] arr = new int[10];
            int num = arr[10];
        }
    }
    ```

3. **Can there be multiple finally blocks?**
    - No, we can have zero or multiple "catch" blocks but just one "finally" block could exist, and "finally" block always executed.

4. **When both catch and finally return values, what will be the final result?**
    - In both "catch" and "finally" blocks contains "return", the final result will return by "finally" block.

5. **What is Runtime/unchecked exception? what is Compile/Checked Exception?**
    - For examples, see point 2.

6. **What is the difference between throw and throws?**
    - throw: It's a statement that is used to actually throw an exception from a method or any block of code.
    - throws: It's a keyword used in method signatures to declare the exceptions that a particular method might throw but doesn't handle itself.

7. **Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?**
    - both printed "End ..."
    - When using multiple `catch` blocks, it's essential to order them from most specific exception types to most general exception types. The reason for this is due to the way Java handles exception catching: it will execute the first catch block that matches the type of the exception thrown or any of its superclasses.

8. **Why finally always be executed?**
    - ensure resources are cleaned up. This includes closing files, releasing database connections, or other resources that might lead to system leaks if not properly closed or released.

9. **Practice collection problems here:**
    - [Practice Link](https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection)

10. **What is Java 8 new features?**
    - Optional
    - Stream api
    - Lambda && functional interface
    - Method reference 

11. **What are the types of design patterns in Java?**
    - Creational Patterns
    - Structural Patterns
    - Behavioral Patterns

12. **What are the SOLID Principles?**
    - S - Single Responsibility Principle (SRP)
    - O - Open/Closed Principle (OCP)
    - L - Liskov Substitution Principle (LSP)
    - I - Interface Segregation Principle (ISP)
    - D - Dependency Inversion Principle (DIP)

13. **How can you achieve thread-safe singleton patterns in Java?**
    - static volatile variable
    - make constructor be private
    - static synchronized getInstance method
    - make sure thread safe

14. **What do you understand by the Open-Closed Principle (OCP)?**
    - Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

15. **Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA) choose your answer.**
    1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing.
    2. It means that all the objects of type A could execute all the methods present in its subtype B.
    3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

    -  3 is correct cause if a method exists in class A, the expectation is that it should also exist and behave correctly in class B if B is a subtype of A. 

16. **Next Steps**
    - Watch the design pattern video, and type the code, submit it to MavenProject folder













