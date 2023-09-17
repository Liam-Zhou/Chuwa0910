package com.chuwa.learn.designPattern.factory.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee =CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());
    }
}
