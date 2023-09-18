package com.chuwa.pattern.factory.abstract_method;

public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffe() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
