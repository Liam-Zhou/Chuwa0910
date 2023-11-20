package com.pattern.builder.demo1;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        //让指挥者组装自行车
        Bike bike = director.constructor();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
