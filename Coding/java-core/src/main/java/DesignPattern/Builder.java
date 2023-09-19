package DesignPattern;

public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        BicycleBuilder builder = new MountainBikeBuilder();

        Bicycle mountainBike = director.build(builder);

        System.out.println("Mountain Bike Configuration:");
        System.out.println("Frame: " + mountainBike.getFrame());
        System.out.println("Wheels: " + mountainBike.getWheels());
        System.out.println("Gears: " + mountainBike.getGears());
        System.out.println("Brakes: " + mountainBike.getBrakes());
    }
}

class Bicycle {
    private String frame;
    private String wheels;
    private String gears;
    private String brakes;

    public Bicycle(String frame, String wheels, String gears, String brakes) {
        this.frame = frame;
        this.wheels = wheels;
        this.gears = gears;
        this.brakes = brakes;
    }

    public String getFrame() {
        return frame;
    }

    public String getWheels() {
        return wheels;
    }

    public String getGears() {
        return gears;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setGears(String gears) {
        this.gears = gears;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    // 添加其他方法和属性
}

interface BicycleBuilder {
    void buildFrame();
    void buildWheels();
    void buildGears();
    void buildBrakes();
    Bicycle getResult();
}

class MountainBikeBuilder implements BicycleBuilder {
    private Bicycle bicycle;

    public MountainBikeBuilder() {
        bicycle = new Bicycle("", "", "", "");
    }

    public void buildFrame() {
        bicycle.setFrame("Mountain Bike Frame");
    }

    public void buildWheels() {
        bicycle.setWheels("29-inch Wheels");
    }

    public void buildGears() {
        bicycle.setGears("21 Gears");
    }

    public void buildBrakes() {
        bicycle.setBrakes("Disc Brakes");
    }

    public Bicycle getResult() {
        return bicycle;
    }
}

class Director {
    public Bicycle build(BicycleBuilder builder) {
        builder.buildFrame();
        builder.buildWheels();
        builder.buildGears();
        builder.buildBrakes();
        return builder.getResult();
    }
}
