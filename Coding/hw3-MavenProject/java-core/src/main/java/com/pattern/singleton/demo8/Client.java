package com.pattern.singleton.demo8;

import com.pattern.singleton.demo6.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

//使用静态内部类的方式 测试使用反射破坏单例模式
public class Client {
    public static void main(String[] args) throws Exception {
        //获取singleton的字节码对象
        Class<Singleton> singletonClass = Singleton.class;
        //获取Singleton类的私有无参构造方法对象
        //因为class里面的构造器是private的，所以需要用getDeclaredConstructor()来获取
        Constructor cons = singletonClass.getDeclaredConstructor();
        //取消访问检查（上面只是通过方法获取无参构造，但是没有访问权限）
        cons.setAccessible(true);

        //通过反射创建Singleton类的对象s1
        Singleton s1 = (Singleton) cons.newInstance();
        //通过反射创建Singleton类的对象s2
        Singleton s2 = (Singleton) cons.newInstance();
        //判断通过反射创建的两个Singleton对象是否是同一个对象
        System.out.println(s1 == s2);
    }

}
