package com.chuwa.learn.designPattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .memory("samsung")
                .screen("samsung")
                .build();
        System.out.println(phone);
    }
}
