package com.pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        //通过构建者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("huawai")
                .memory("huawei")
                .mainboard("asus")
                .build();

        System.out.println(phone);
    }
}
