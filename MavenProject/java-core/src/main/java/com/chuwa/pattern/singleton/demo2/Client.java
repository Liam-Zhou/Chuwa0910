package com.chuwa.pattern.singleton.demo2;

public class Client {
    public static void main(String[] args) {
         Singleton instance_1 = Singleton.getInstance();
         Singleton instance_2 = Singleton.getInstance();

        System.out.println(instance_1 == instance_2);
    }
}
