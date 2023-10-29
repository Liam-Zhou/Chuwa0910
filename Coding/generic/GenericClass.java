package com.chuwa.tutorial.t01_basic.generic;

/**
 * @author b1go
 * @date 7/25/22 12:17 AM
 */
public class GenericClass<T> {
    // T -> Integer, User, Product
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}

//    public static void main(String[] args) {
//        GenericClass<Integer> myobj1 = new GenericClass<>(5);
//        System.out.println(myobj1.getObj());
//
//        GenericClass<String> myobj2 = new GenericClass<>("Banana");
//        System.out.println(myobj2.getObj());
//
//        GenericClass<User> user1 = new GenericClass<User>(new User("Grace", 18));
//        User userValue = user1.getObj(); // Retrieve the User object
//        System.out.println("Name: " + userValue.name + ", Age: " + userValue.age);
//        //System.out.println(user1.getObj()); // print user object's address
//    }
//}
//class User{
//    String name;
//    int age;
//    User(String name, int age) {
//        this.name=name;
//        this.age=age;
//    }
//}