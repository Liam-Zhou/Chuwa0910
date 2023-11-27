package com.pattern.singleton.demo3;

import com.pattern.singleton.demo1.Singleton;

//测试类
public class Client {
    public static void main(String[] args) {
        //创建singleton类的对象,因为无法直接new，所以需要用提供的公共方法
        Singleton instance = Singleton.getInstance();

        //判断获取到的2个instances是否是同一个对象
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        // output: true 说明是同一个对象，保证Singleton这个类只能够创建一个对象

    }
}
