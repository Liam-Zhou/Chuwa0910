package com.chuwa.pattern.singleton.demo7;

import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton() { }

    private static class SingletonHolder {
        private static final com.chuwa.pattern.singleton.demo7.Singleton INSTANCE = new com.chuwa.pattern.singleton.demo7.Singleton();
    }

    public static com.chuwa.pattern.singleton.demo7.Singleton getInstance() {
        return com.chuwa.pattern.singleton.demo7.Singleton.SingletonHolder.INSTANCE;
    }

    // When deserialization is performed, this method is automatically called to return the return value of the method directly.
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}

