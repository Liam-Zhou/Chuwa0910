package com.chuwa.pattern.factory.abstract_method;

public class ItalianDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffe() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
