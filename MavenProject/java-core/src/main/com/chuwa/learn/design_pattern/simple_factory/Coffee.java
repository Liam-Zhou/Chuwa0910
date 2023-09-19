package main.com.chuwa.learn.design_pattern.simple_factory;

public abstract class Coffee {
    public abstract String getName();

    public void addMilk() {
        System.out.println("add milk");
    }
    public void addSugar() {
        System.out.println("add sugar");
    }
}
