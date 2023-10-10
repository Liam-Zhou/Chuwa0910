package com.chuwa.learn.completableFuture;

public class ProductInfo {
    private String name;
    private int price;

    public ProductInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
