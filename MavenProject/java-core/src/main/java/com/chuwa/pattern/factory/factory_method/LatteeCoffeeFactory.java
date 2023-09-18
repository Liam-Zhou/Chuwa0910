package com.chuwa.pattern.factory.factory_method;

public class LatteeCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
