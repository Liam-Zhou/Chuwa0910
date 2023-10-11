package CodingParkingLot;
public abstract class Vehicle {
    private Size size;
    private String brand;
    private String model;
    private String plate;

    public Vehicle(Size size, String brand, String model, String plate) {
        this.size = size;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }
    public abstract boolean canFit(ParkingSpot spot);
}
