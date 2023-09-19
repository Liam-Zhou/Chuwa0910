package com.chuwa.learn.designPattern.singleton.demo4;

public class Singleton {
    private Singleton(){}

    private static Singleton instance;

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
