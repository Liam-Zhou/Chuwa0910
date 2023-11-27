package com.pattern.factory.factory_method;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar(){
        System.out.println("add sugur");
    }

    public void addMilk(){
        System.out.println("add mike");
    }
}
