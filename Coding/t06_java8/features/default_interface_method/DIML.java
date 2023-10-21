package com.chuwa.tutorial.t06_java8.features.default_interface_method;

public interface DIML {
    static final String BLOG = "is Chuwa a";

    // abstract method
    int add(int a, int b);

    // default method
    default int substract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}

//public interface DIML {
//    int add(int a, int b);
//    default int substract(int a, int b) {
//        return a-b;
//    }
//    static final String BLOG = "helloooo";
//    static String name(){
//        return BLOG;
//    }
//}
//
//public class DIMLapi implements DIML {
//    @Override
//    int add(int a, int b) {
//        return a+b;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        DIMLapi dimmapi = new DIMLapi();
//        System.out.println(dimmapi.add(1,2));
//    }
//}
