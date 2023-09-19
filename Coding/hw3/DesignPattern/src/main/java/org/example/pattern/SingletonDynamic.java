package org.example.pattern;

public class SingletonDynamic {
    private SingletonDynamic() {}

    private static SingletonDynamic instance = new SingletonDynamic();


    public static SingletonDynamic getInstance() {
        return instance;
    }
}
