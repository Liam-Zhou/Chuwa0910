# HW3 - Grace Hu

### 1. Practice collection
See coding

### 2. What is the checked exception and unchecked exception in Java, could you give one example?
**Checked Exception** - compiler checks at compile-time, must use try-catch block or throws keyword
- IOException (e.g. FileNotFound)
- SQLException (e.g. Id/data does not exits)

**Unchecked Exception** - Runtime Exception, often represent issues within the code, such as logic errors or invalid operations, rather than external factors
- NullPointerException (NPE)
- IndexOutOfBoundsException (e.g. List/Array)

### 3. Can there be multiple finally blocks?
No, there can only be one finally clause per try/catch/finally statement, but can be multiple such statements, either in the same method or in multiple methods.

### 4. When both catch and finally return values, what will be the final result?
If both catch and finally return, the receiving method will get the returned value from the **finally** block.

### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

**Runtime/unchecked Exception**:
It occurs during the execution of a program, often due to errors in the program's logic or unexpected conditions. 
- DO NOT require a try-catch block or a throws declaration, Optional Handling.
- Common examples: NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException.
- Subclasses of the RuntimeException class.


**Compile/checked Exception**: Java compiler checks it at compile-time. 
- Require a try-catch block or a throws declaration
- Common examples: IOException, SQLException, and ClassNotFoundException.
- Subclasses of the Exception class but not subclasses of RuntimeException.


### 6. What is the difference between throw and throws?
They are two keywords in Java related to exception handling.

**throw**:
- inside a function
- throw an exception explicitly, only one exception at a time.

**throws**:
- in the function signature
- declare multiple exceptions, throw matched ones automatically

### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

Because catch blocks are evaluated from top to bottom, and the first catch block that matches the type of the thrown exception will be executed. 

Order catch blocks from the most specific exception type to the most general one.

### 8. What is optional? why do you use it? write an optional example.
**Optional** is a container class introduced in Java 8 to represent an optional value, to handle scenarios where a value might be missing, without null checks and run time NullPointerExceptions.

**Why?** It encourages safer and more readable code by explicitly addressing the presence or absence of a value.

Example:

    public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street ")));
        userMap.put(2, new User("Bob", null));


        // Without Optional
        String streetName = "Unknown"; 
        User user = userMap.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + streetName);


        // With Optional
        streetName = Optional.ofNullable(userMap.get(2))
        .map(User::getAddress)
        .map(Address::getStreet)
        .orElse("Unknown"); System.out.println("Street name with Optional: " + streetName);
    }
}

### 9. Why finally always be executed ?
**Resource Cleanup**: One of the primary purposes of the finally block is to provide a place for resource cleanup, such as closing files, releasing database connections, or freeing up any resources acquired during the execution of the try block. By executing the finally block, Java ensures that resources are released, even if an exception occurs.

**Exception Handling**: If an exception is thrown within the try block, the finally block is still executed after the exception is caught and handled. Because it allows you to clean up resources and perform any necessary cleanup operations, regardless of whether an exception occurred.

### 10. What is Java 8 new features ?
- Functional Interface
- Lambda Expression
- Method Reference
- Optional
- Stream API

### 11. What are the types of design patterns in Java ?
- **Aggregation**: the lifetime of the owned object does not depend on the lifetime of the owner.
- **Composition**: the lifetime of the owned object depends on the lifetime of the owner.
- **Singleton Pattern**: Ensures that a class has only one instance and provides a global point of access to that instance.

### 12. What are the SOLID Principles ?
- **Open-Closed Principle**: Software components should be open for extension, but not for modification.
- **Liskov Substitution Principle**: Objects of a superclass should be replaceable with objects of its subclasses without breaking the system.
- **Interface Segregation Principle**: No client should be forced to depend on methods that it does not use.
- **Dependency Inversion Principle**: High-level modules should not depend on low-level modules, both should depend on abstractions.

### 13. How can you achieve thread-safe singleton patterns in Java ?
**Lazy Load**

    public class Singleton {
        // Private constructor to prevent instantiation from outside the class
        private Singleton() {
        }

        // Static inner class to hold the Singleton instance
        private static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }

        // Public static method to get the Singleton instance
        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }
In this implementation, the Singleton instance is created when the SingletonHolder class is loaded and initialized. This occurs only when the getInstance() method is called for the first time, ensuring lazy initialization. Since class loading and initialization are thread-safe in Java, this approach guarantees that the Singleton instance is created only once, even in a multi-threaded environment.

### 14. What do you understand by the Open-Closed Principle (OCP) ?
**Open-Closed Principle**: Software entities (e.g., classes, modules, functions) should be open for an extension, but closed for modification.

Example:

    public class VehicleCalculations {
        public double calculateValue(Vehicle v) {
            if (v instanceof Car)
                return v.getValue() * 0.8;
            if (v instanceof Bike)
                return v.getValue() * 0.5;

        }
    }
Suppose we now want to add another subclass called Truck. We would have to modify the above class by adding another if statement, which goes against the Open-Closed Principle.
A better approach would be for the subclasses Car and Truck to override the calculateValue method:

    public class Vehicle {
        public double calculateValue() {...}
    }
    public class Car extends Vehicle {
        public double calculateValue() {
            return this.getValue() * 0.8;
        }
    }
    public class Truck extends Vehicle{
        public double calculateValue() {
            return this.getValue() * 0.9;
        }
    }
Adding another Vehicle type is as simple as making another subclass and extending from the Vehicle class.

### 15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

Choose 3