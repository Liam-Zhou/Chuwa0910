package org.example.pattern;

public class SingletonLazy {
    private SingletonLazy() {
    }

    private static SingletonLazy instance;

    public static synchronized SingletonLazy getInstance() {
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
