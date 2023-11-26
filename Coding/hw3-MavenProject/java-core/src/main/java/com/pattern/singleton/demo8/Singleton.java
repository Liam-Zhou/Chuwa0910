package com.pattern.singleton.demo8;

import java.io.Serializable;

// 懒汉式-方式4（静态内部类方式）
// 静态内部类单例模式中对象由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的,只有内部类的属性/方法被调用时
// 才会被加载, 并初始化其静态属性。静态属性由于被static 修饰，保证只被实例化一次，并且严格保证实例化顺序。（因为jvm只加载class一次）
public class Singleton {

    // 反射破坏单例模式 解决办法：
    private static boolean flag = false;

    private Singleton(){
        synchronized (Singleton.class) {
            //判断flag的值是否是true，
            //如果是true，说明非第一次访问，直接抛一个异常
            //如果是flase，说明第一访问
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            //将flag的值设置为true
            flag = true;
        }
    }

    //定义一个静态内部类
    private static class SingletonHolder{
        // 在内部类中声明并且初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton(); //因为有final就是一个常量，所以大写
    }

    // 提供公共的访问方式
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
