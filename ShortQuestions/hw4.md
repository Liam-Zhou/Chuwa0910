1. What is generic in Java?  and type the generic code by yourself

    > Generic methods in Java are used as a signle method declaration, and can them with arguments with different types.  

    ```Java
    public class GenericClass<T> {
        T obj; 
        public GenericClass(T obj) {
            this.obj = obj; 
        }
    }
    ```

2. Read those codes and type it one by one by yourself. then push the code to your branch

    > Done 

3. practice stream API at least 3 times 
   
   > Done 

4. Practice Optional methods at least 2 times
   
   > Done 

5. Write the Singleton design pattern include eager load and lazy load. 
   
   > Singleton (lazy load)
   ```Java
    public class SingletonLazy {
        private SingletonLazy() {
        }

        private static SingletonLazy instance;

        public static synchronized SingletonLazy getInstance() {
            if(instance == null){
                instance = new SingletonLazy();
            }
            return instance;
        }
    }
   ```
   > Singleton (eager load)
   ```Java
    public class SingletonDynamic {
        private SingletonDynamic() {}

        private static SingletonDynamic instance = new SingletonDynamic();


        public static SingletonDynamic getInstance() {
            return instance;
        }
    }

   ```

6. What is Runtime Exception? could you give me some examples?

    > From docs.oracle, the RuntimeException is the superclass of exceptions can be thrown during the normal operation of JVM. Like NullPOinterExcpetion, Arithmatic Exception. 

7. Could you give me one example of NullPointerException?
   
   ```Java
    String a = null;
    System.out.println(a.compareTo("hello"));
   ```

8. What are the advantages of using the Optional class?
   
   > Optional is to avoid null checks and runtime nullpointerexceptions. It is more safe and consice to deal with null object. 

9.  What is the @FunctionalInterface?
    
    > FunctionalInterface is a kind of interface with only one abstract method but a lot of default methods. @FunctionalInterface is for sanity check. 
    > `Runnable` `Comparator` and `FileFilter` have `@FunctionalInterface`

10. what is lambda?
    
    > It is a kind of termporary method. Lambda in java is to replace anonymous inner class which can work with the functional interface or the other functional interface. 

11. What is Java 8 new features?
    
    > Lambda & Functional interface
    > Method Reference 
    > Optional 
    > Stream api 

12. Lambda can use unchanged variable outside of lambda? what is the details?

    > Yes, lambda can use final, or any variable looks like final (haven't changed its data location) can be used in the lambda. 

15. Describe the newly added features in Java 8?
    
    > Lambda & Functional interface: anonymouns function for Java to replace the inner class function. 
    > Method Reference: a way for the lambda to call the cunction in the lambda. 
    > Optional: a class for object to deal with the null, make it more conscise and safe. 
    > Stream api: a way to write methods to manipulate data by functions. 

16. Can a functional interface extend/inherit another interface?

    > Yes, but only for interface with all default method. Since only functional interface will check the sanity for only one abstract method. 

17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
    
    > lambda expression is short block of code to get data and return data like normal method. By the functinal interface, lambda expression can override the abstract method in the interface. 

18. In Java 8, what is Method Reference?

    > Method Reference is for lambda to call existing method by name. 

19. What does the String::ValueOf expression mean?

    > Convert different types of Object to String. 

20. What are Intermediate and Terminal operations?

    > Intermediate operation in Stream is to manipulate data stream. However Terminal Operation is the end of the stream, to organize or collect data from the data stream. 

22. What is the difference between findFirst() and findAny()?

    > findFirst makes sure the first one. However findAny cannot make sure this. 

23. How are Collections different from Stream?
    
    > Collections are data stucture to store data. However Stream can not store data. Collections should be iterated outisde, but Stream does internal interation. Meanwhile Stream cannot be traversed by once. 
