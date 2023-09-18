package com.chuwa.pattern.builder.demo1;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Aluminum");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Caoutchouc");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
