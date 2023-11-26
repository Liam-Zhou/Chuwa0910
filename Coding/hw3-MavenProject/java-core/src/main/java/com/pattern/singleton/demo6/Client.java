package com.pattern.singleton.demo6;

/*
//测试类 静态内部类单例模式的运行
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
 */

import jdk.jshell.Snippet;

import java.io.*;

//使用静态内部类的方式 测试使用序列化+反序列化破坏单例模式
public class Client{
    public static void main(String[] args) throws Exception {
        // writeObject2File();

        readObjectFromFile();
        readObjectFromFile();
    }

    //从文件中读数据（对象）
    public static void readObjectFromFile() throws Exception {
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/kechen/Desktop/work/Chuwa0910/Coding/MavenProject/a.txt"));
        //读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        //释放资源
        ois.close();
    }

    //想文件中写数据（对象）
    public static void writeObject2File() throws Exception{
        // 获取singleton对象
        Singleton instance = Singleton.getInstance();
        // 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/kechen/Desktop/work/Chuwa0910/Coding/MavenProject/a.txt"));
        // 写对象
        oos.writeObject(instance);
        //释放资源
        oos.close();
    }
}
