package com.pattern.singleton.demo1;

// 饿汉式-方式1（静态变量方式）
public class Singleton {

    //私有构造方法（因为私有的话，外界无法访问到构造方法，就无法创建对象）
    private Singleton(){}

    //外界如果访问不到的话，一个对象都创建不了，所以要在该类中创建一个本类的对象，供外界使用
    private static Singleton instance = new Singleton();

    //提供一个公共的访问方式，对外提供静态方法，让外界获取该对象
    public static Singleton getInstance(){
        return instance;
    }
}
