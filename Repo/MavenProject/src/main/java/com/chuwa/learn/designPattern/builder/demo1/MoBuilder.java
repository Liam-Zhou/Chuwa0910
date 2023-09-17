package com.chuwa.learn.designPattern.builder.demo1;

public class MoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("moFrame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("moSeat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
