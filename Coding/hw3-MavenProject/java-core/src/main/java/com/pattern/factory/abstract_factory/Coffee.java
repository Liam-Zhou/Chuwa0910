package com.pattern.factory.abstract_factory;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar(){
        System.out.println("add sugur");
    }

    public void addMilk(){
        System.out.println("add mike");
    }
}
