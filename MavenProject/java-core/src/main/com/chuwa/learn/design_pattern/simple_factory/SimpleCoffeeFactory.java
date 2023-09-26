package main.com.chuwa.learn.design_pattern.simple_factory;

public class SimpleCoffeeFactory {
    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if (type.equals("American")) {
            coffee = new AmericanCoffee();
        }
        else if(type.equals("Latte")) {
            coffee = new LatteCoffee();
        }
        return coffee;
    }
}
}
