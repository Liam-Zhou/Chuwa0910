package com.chuwa.learn.designPattern.factory.factory_method;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
