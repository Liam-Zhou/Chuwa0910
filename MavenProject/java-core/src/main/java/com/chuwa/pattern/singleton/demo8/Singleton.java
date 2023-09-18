package com.chuwa.pattern.singleton.demo8;

import java.io.Serializable;

public class Singleton {
    private static boolean flag = false;
    private Singleton() {
        synchronized (Singleton.class) {
            if(flag) throw new RuntimeException("Can't create multiple instance!");
            flag = true;
        }
    }

    private static class SingletonHolder {
        private static final com.chuwa.pattern.singleton.demo8.Singleton INSTANCE = new com.chuwa.pattern.singleton.demo8.Singleton();
    }

    public static com.chuwa.pattern.singleton.demo8.Singleton getInstance() {
        return com.chuwa.pattern.singleton.demo8.Singleton.SingletonHolder.INSTANCE;
    }
}
