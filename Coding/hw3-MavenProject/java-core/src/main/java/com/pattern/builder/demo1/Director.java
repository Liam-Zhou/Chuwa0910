package com.pattern.builder.demo1;

public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装自行车功能
    public Bike constructor(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
