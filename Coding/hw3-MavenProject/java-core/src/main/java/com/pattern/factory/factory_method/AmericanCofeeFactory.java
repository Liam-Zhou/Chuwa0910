package com.pattern.factory.factory_method;

public class AmericanCofeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
