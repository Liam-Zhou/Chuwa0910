package main.com.chuwa.learn.design_pattern.builder;

public abstract class Builder {
    protected Bike bike = new Bike();
    public abstract void buildFrame();
    public abstract void buildSeat();

    public Bike createBike() {
        return bike;
    }

}
