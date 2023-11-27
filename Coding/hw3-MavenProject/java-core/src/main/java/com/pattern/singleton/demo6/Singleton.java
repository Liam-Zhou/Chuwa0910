package com.pattern.singleton.demo6;

import java.io.Serializable;

// 懒汉式-方式4（静态内部类方式）
// 静态内部类单例模式中对象由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的,只有内部类的属性/方法被调用时
// 才会被加载, 并初始化其静态属性。静态属性由于被static 修饰，保证只被实例化一次，并且严格保证实例化顺序。（因为jvm只加载class一次）
public class Singleton implements Serializable {

    private Singleton(){}

    //定义一个静态内部类
    private static class SingletonHolder{
        // 在内部类中声明并且初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton(); //因为有final就是一个常量，所以大写
    }

    // 提供公共的访问方式
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    // 序列化、反序列方式破坏单例模式的解决方法:
    //在Singleton类中添加 readResolve() 方法，在反序列化时被反射调用，
    // 如果定义了这个方法，就返回这个方法的返回值，如果没有定义，则返回新new出来的对象。
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
