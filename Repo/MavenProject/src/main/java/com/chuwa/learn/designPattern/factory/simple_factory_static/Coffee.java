package com.chuwa.learn.designPattern.factory.simple_factory_static;

public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {System.out.println(("add sugar."));}

    public void addMilk() {System.out.println(("add milk."));}
}
