package com.pattern.factory.simple_factory;

/*
使用simple factory，新增加一个createCoffee，就不需要每次都new
 */

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
     */
    public Coffee orderCoffee(String type){
        //业务代码不做改动，多加了一层
        SimpleCoffeeFactory simpleFactory = new SimpleCoffeeFactory();
        Coffee coffee = simpleFactory.createCoffe(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
