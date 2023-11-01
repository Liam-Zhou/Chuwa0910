package com.pattern.factory.factory_method;


public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new AmericanCofeeFactory();
        store.setFactory(factory);

        Coffee coffee = store.orderCoffee("latee");

        System.out.println(coffee.getName());
    }
}
