class Vehicle {
    void startEngine() {
        System.out.println("Engine started.");
    }
}

class Car extends Vehicle { // Inheritance
    void drive() {
        System.out.println("Car is moving.");
    }
}

public class Inh {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startEngine();
        myCar.drive();
    }
}
