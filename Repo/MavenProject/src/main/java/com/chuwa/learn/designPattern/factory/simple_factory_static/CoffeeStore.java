package com.chuwa.learn.designPattern.factory.simple_factory_static;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
