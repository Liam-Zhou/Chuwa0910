package com.chuwa.pattern.factory.factory_method;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }
    public Coffee orderCoffee() {
        com.chuwa.pattern.factory.factory_method.Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
