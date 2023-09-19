package com.chuwa.learn.designPattern.builder.demo1;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("ofoFrame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("ofoSeat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
