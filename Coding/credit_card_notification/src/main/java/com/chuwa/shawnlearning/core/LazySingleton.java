package com.chuwa.shawnlearning.core;

public class LazySingleton {

    private LazySingleton() {
        // Private constructor to prevent instantiation from outside.
    }
    private static class LazySingletonHolder{
        public static final LazySingleton instance = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }
}