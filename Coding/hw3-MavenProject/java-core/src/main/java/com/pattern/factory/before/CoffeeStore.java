package com.pattern.factory.before;

/*
在java中，万物皆对象，这些对象都需要创建，如果创建的时候直接new该对象，就会对该对象耦合严重，
假如我们要更换对象，所有new对象的地方都需要修改一遍，这显然违背了软件设计的开闭原则。

如果我们使用工厂来生产对象，我们就只和工厂打交道就可以了，彻底和对象解耦，如果要更换对象，
直接在工厂里更换该对象即可，达到了与对象解耦的目的；所以说，工厂模式最大的优点就是：解耦。
 */

import com.pattern.factory.simple_factory.AmericanCoffee;
import com.pattern.factory.simple_factory.Coffee;
import com.pattern.factory.simple_factory.LatteCoffee;

public class CoffeeStore {
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
}
