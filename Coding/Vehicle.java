public class Vehicle {
    private boolean isCar; // true for car, false for motorcycle
    private String plateNumber;

    public Vehicle(boolean isCar, String plateNumber) {
        this.isCar = isCar;
        this.plateNumber = plateNumber;
    }

    public boolean isCar() {
        return isCar;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
