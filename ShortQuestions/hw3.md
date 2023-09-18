### 2.  What is the checked exception and unchecked exception in Java, could you give one example?
> - Checked exception: kind of exception that need to be caught or throws, such as IOException
> - Unchecked Exeception: Runtime Exception, exceptions that do not need to be explicitly caught or throws, such as NPE.
### 3.  Can there be multiple finally blocks? 
> - No, each try or try-catch block can only use once.
### 4.  When both catch and finally return values, what will be the final result?
> - The value from the finally block.
### 5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
> - Checked exceptions are caught at compile time where runtime or unchecked exceptions are at runtime. Checked exceptions must be handled, where unchecked isn't required to be handled.  
### 6.  What is the difference between throw and throws?
> - throw is the actual action to throw the exceptioin, where the throws is a kind of key word used to declare what kind of exceptions class may throw.
### 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
> - Always put the detailed exceptions before the general one.
### 7.  What is optional? why do you use it? write an optional example. 
> - A kind of container that could store T type value or null, to avoid the NPE.
> 
```
Map<Integer, User> userMap = new HashMap<>();
userMap.put(1, new User("Alice", new Address("Main Street")));
userMap.put(2, new User("Bob", null));
    
streetName = Optional.ofNullable(userMap.get(2))
                     .map(User::getAddress)
                     .map(Address::getStreet)
                     .orElse("Unknown");
System.out.println("Street name with Optional: " + streetName);
```
### 8.  Why finally always be executed ?
> - To ensuer the finally block is executed even if an unexpected exception orrcur.
### 10.  What is Java 8 new features ?
> - Reference
> - Default method and static method in interface
> - Lambda & Functional Interface
> - Method Reference
> - Optional
> - Stream API
> - CompletableFuture
### 11.  What are the types of design patterns in Java ?
> - Is a - Inheritance
> - Part-of: Composition
> - Has-a: Aggregation
### 12.  What are the SOLID Principles ?
> - Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. 
### 13.  How can you achieve thread-safe singleton patterns in Java ?
> - Put the initialization statements inside the static inner class, which will only be loaded once due to the loading mechanism of Java classes, ensuring thread safety.
### 14.  What do you understand by the Open-Closed Principle (OCP) ?
> - Entities such as classes functions should be open for extension, but closed for modification.
### 15.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
> - 1
##### - 1.  It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing
##### - 2.  It means that all the objects of type A could execute all the methods present in its subtype B
##### - 3.  It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
##### - 4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
