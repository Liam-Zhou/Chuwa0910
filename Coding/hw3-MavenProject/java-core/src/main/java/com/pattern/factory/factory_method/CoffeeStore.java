package com.pattern.factory.factory_method;

public class CoffeeStore {
    /* factory_before
    public Coffee orderCoffee(String type){
        //声明coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latee".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("sorry");
        }

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }

    // static factory
    public static Coffee orderCoffee(String type){
        //业务代码不做改动，多加了一层
        //StaticCoffeeFactory staticFactory = new StaticCoffeeFactory();
        //Coffee coffee = staticFactory.createCoffe(type);
        Coffee coffee = StaticCoffeeFactory.createCoffe(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
     */

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee(String type){
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }

}
