package com.chuwa.pattern.factory.simple_factory;

public class SimpleCoffeeFactory {
    public static Coffee createCoffee(String type) {
        switch (type) {
            case "Latte Coffee":
                return new LatteCoffee();
            case "American Coffee":
                return new AmericanCoffee();
            default:
                throw new UnsupportedOperationException("Unsupported coffee");
        }
    }
}
