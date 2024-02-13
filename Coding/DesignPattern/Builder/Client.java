package DesignPattern.Builder;

public class Client {
    public static void main(String[] args) {
        Director dir = new Director(new MobileBuilder());
        Bike bike = dir.constructBike();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
