package com.chuwa.learn.designPattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new AmericanCoffeeFactory();

        store.setFactory(factory);
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());

    }
}
