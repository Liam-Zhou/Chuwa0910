package com.pattern.singleton.demo4;

// 懒汉式-方式2（线程安全）
// 如果是多线程的话，两个线程同时调用getInstance()方法，就会有2个instance对象: 加synchronized关键字
public class Singleton {

    private Singleton(){}

    private static Singleton instance; //不进行赋值，只有在首次使用该对象时才会创建

    public static synchronized Singleton getInstance(){
        // instance = new Singleton(); 每次调用getInstance()都会创建一个对象，所以不行，需要加一个判断
        //判断instance是否为null，如果为null，说明还没有创建singleton类的对象
        //如果没有，创建一个并返回，如果有，直接返回
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
