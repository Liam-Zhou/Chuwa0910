package com.chuwa.pattern.factory.abstract_method;

public class Client {
    public static void main(String[] args) {
        ItalianDessertFactory factory = new ItalianDessertFactory();

        Coffee coffee = factory.createCoffe();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
