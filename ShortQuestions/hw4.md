# HW4 - Grace Hu

### 1. What is generic in Java? and type the generic code by yourself.
**Generics** enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs.

### 5. Write the Singleton design pattern include eager load and lazy load.
**Eager Load**:
    
    public class Singleton {
        private static Singleton instance = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return instance;
        }
    }

**Lazy Load**:

    public class Singleton {
        private Singleton(){
        }

        public static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }


### 6. What is Runtime Exception? could you give me some examples?
It's also called Unchecked Exception. It often represent issues within the code, such as logic errors or invalid operations, rather than external factors
- NullPointerException (NPE)
- IndexOutOfBoundsException (e.g. List/Array)

### 7. Could you give me one example of NullPointerException?

    public class OptionalDemo {
        public static void main(String[] args) {
            Map<Integer, User> userMap = new HashMap<>();
            userMap.put(1, new User("Alice", new Address ("Main Street")));
            userMap.put(2, new User("Bob", null));
            
            User user = userMap.get(2);
            System.out.println("Street name without Optional: " + streetName);
        }
    }
The code is attempting to retrieve a User object from a Map and then access an Address object within it. However, the user with a null address in the map, which can lead to a NullPointerException when trying to access the address.

### 8. What is the Optional class?/ 9. What are the advantages of using the Optional class?
**Optional class** is a container class introduced in Java 8 to represent an optional value, to handle scenarios where a value might be missing, without null checks and run time NullPointerExceptions.

**advantages** It encourages safer and more readable code by explicitly addressing the presence or absence of a value.

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

### 10. What is the @FunctionalInterface?
**@FunctionalInterface** is an annotation for sanity check and working with lambda expressions. 

**Functional Interface**:
- Has only one single Abstract method
- Has any number of default, static methods
- Can declare methods of object class
- @FunctionalInterface - for sanity check
- Lambda is the implementation of the abstract method

### 11. what is lambda?
A **lambda expression** is a short block of code which takes in parameters and returns a value. Lambda expressions basically express instances of functional interfaces. It is the implementation of the single abstract method(SAM). 
- To replace anonymous inner class
- Work with functional interface

### 12. What is Method Reference?
A method reference is the shorthand syntax for a lambda expression that contains just one method call.

### 13. What is Java 8 new features ?
- Functional Interface
- Lambda Expression
- Method Reference
- Optional
- Stream API

### 14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes, the unchanged variable can be used by lambda as long as the address of the variable is unchanged.

Lambda can use variable if:
- Final variable
- Non-final variable however never changed
- Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)


### 15. Describe the newly added features in Java 8?
- Functional Interface
- Lambda Expression
- Method Reference
- Optional
- Stream API
- CompletableFuture

### 16. Can a functional interface extend/inherit another interface?
A **functional interface** can extends another interface only when it does not have any abstract method.

### 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
A **lambda expression** is a short block of code which takes in parameters and returns a value. 

Lambda expressions basically express instances of functional interfaces. It is the implementation of the single abstract method(SAM). 

### 18. In Java 8, what is Method Reference?
A **method reference** is the shorthand syntax for a lambda expression that contains just one method call.

### 19. What does the String::ValueOf expression mean?
**String::ValueOf** is a method reference that refers to the valueOf method of the String class, which converts various types into their string representations.

### 20. What are Intermediate and Terminal operations?
**Intermediate operations** process elements in a stream, returning a new stream.

**Terminal operations** produce a result or side effect, marking the end of a stream. Examples: forEach, collect, reduce, count, min, max, anyMatch, allMatch, noneMatch.


### 21. What are the most commonly used Intermediate operations?
filter, map, distinct, sorted, limit

### 22. What is the difference between findFirst() and findAny()?
**findFirst()** return the first elements of the stream.

**findAny()** is free to select any element in the stream. 

In parallel mode the findAny does not guaranteed order, but the findFirst does.

### 23. How are Collections different from Stream?
**Collections** is a data structure holds all the
data elements and store data.

**Stream** is an API to process the data, no data is stored.
