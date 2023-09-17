package com.chuwa.learn.designPattern.factory.abstract_factory;

public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    public Dessert createDessert(){
        return new Mousse();
    }
}
