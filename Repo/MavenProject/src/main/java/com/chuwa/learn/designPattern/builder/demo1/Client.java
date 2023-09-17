package com.chuwa.learn.designPattern.builder.demo1;

public class Client {
    public static void main(String[] args) {

        Director director = new Director(new MoBuilder());
        Bike bike = director.construct();

        System.out.println(bike.getSeat());
        System.out.println(bike.getFrame());
    }
}
