package com.pattern.singleton.demo2;

// 饿汉式-方式2（静态代码块方式）
public class Singleton {
    //私有构造方法（因为私有的话，外界无法访问到构造方法，就无法创建对象）
    private Singleton(){}

    //创建该类的对象，但是并不赋值,初始值为null
    private static Singleton instance;

    //在静态块里面进行赋值
    static {
        instance = new Singleton();
    }

    //提供一个公共的访问方式，对外提供静态方法，让外界获取该对象
    public static Singleton getInstance(){
        return instance;
    }
}
