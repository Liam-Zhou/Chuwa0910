package com.chuwa.pattern.singleton.demo8;

import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) throws Exception {
        // Get bytecode instance of Singleton
        Class clazz = Singleton.class;
        // Get constructor instance of no parameter
        Constructor cons = clazz.getDeclaredConstructor();
        //
        cons.setAccessible(true);
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();

        System.out.println(s1 == s2);
    }
}
