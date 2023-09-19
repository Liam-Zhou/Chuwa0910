1.  Practice  collection

     > In the Code file 

2.  What is the checked exception and unchecked exception in Java, could you give one example?
   
     >  Checked Exception, we should take care of by using catch or throws. In general, checked exception include IO Exception (read file, data doesn't exist) or SQL exception. For unchecked exception, it is about NullPointerException , IndexOutOfBoundsException.  

3.  Can there be multiple finally blocks? 

     > No 

4.  When both catch and finally return values, what will be the final result?

     > Only the final result will return result 

5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?

     > Runtime/unchecked exception: unchecked exception is something that has gone wrong with the program and is unrecoverable. Just because this is not a compile time exception, meaning you do not need to handle it.
     > Compile/Checked exception: the exception must be either caught or declared in the method in which it is thrown. 

6.  What is the difference between throw and throws?

     > throw: in the function; 
     > throws: in the signature. You don't need to write try && catch in the function. 

7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?  What is optional? why do you use it? write an optional example. 
   
     >  Since we can notice the null pointer, otherwise the every different exception willl be caught by the `catch(Exception e)`. The optional would be the null pointer, since it is the unchecked, we don't need to worry about. 

     ```Java 
     int a = 0; 
     int b = 3; 
     String s = null; 

     try{
          System.out.println(b/a);
          System.out.println(s.equals("aa"));
          throw new RuntimeException(); 
     } catch(ArithmeticException e) {....;}
     catch(RuntimeException e) {....;}
     ```

8.  Why finally always be executed ? 

     > Because it ensures if there is some unexpected exception happend. 

9.   What is Java 8 new features ?

     > Lambda, optional, Stream API. 


10.  What are the types of design patterns in Java ? 
    
     > Creational Design Pattern: Factory Pattern, Builder Pattern 
     > Structural Desgin Pattern: Adapter Pattern, Decorator Pattern 
     > Behaviroal Design Pattern: Observer Pattern, iterator Pattern  

11.  What are the SOLID Principles ?

     > Single Responsibility Principle: each calss responsible for single part of functionality 
     > Open-Closed Principle: Software components should be open for extension, but not for modification. 
     > Liskov Substitution Principle: objects for a superclass should be replaceable with objects of its subclass without breaking the system. 
     > Interface Segregation Principle: No client should be forced to depend on methods that it does not use. 
     > Dependency Inversion Principle: High-level moduels should not depend on low-level modules, both should depend on abstraction. 


12.  How can you achieve thread-safe singleton patterns in Java ?

     > by using `synchonized` can achieve the thread-safe singleton. 

13.  What do you understand by the Open-Closed Principle (OCP) ?

     > In general, we are not trying to change the code we have built and deployed, but we try to write code which has good structure for extension like subclass.

14.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
     1.  It mean that if the object of type A can do something, the object of type B could also be able tp 
     perform the same thing
     2.  It means that all the objects of type A could execute all the methods present in its subtype B
     3.  It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
     4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

     >  Choose (3). By the Liskov's substitution princile, we can notice that the scope of functionality would be larger than its super class. Hence we can replace type A with subtype B. Since all the functionality B can perform. 

15.  Watch the design pattern video, and type the code, submit it to MavenProject folder

     > In the code part. 