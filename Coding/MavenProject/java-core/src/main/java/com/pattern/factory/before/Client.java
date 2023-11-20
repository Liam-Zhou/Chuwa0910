package com.pattern.factory.before;

import com.pattern.factory.simple_factory.Coffee;
import com.pattern.factory.simple_factory.CoffeeStore;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latee");

        System.out.println(coffee.getName());
    }
}
