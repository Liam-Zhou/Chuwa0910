package com.chuwa.pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("Samsung")
                .memory("Kingston")
                .mainboard("Asus")
                .build();

        System.out.println(phone);
    }

}
