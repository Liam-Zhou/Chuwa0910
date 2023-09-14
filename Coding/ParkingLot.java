public class ParkingLot {
    private int carSpaces = 50;
    private int motorcycleSpaces = 10;

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle.isCar() && carSpaces > 0) {
            carSpaces--;
            return true;
        } else if (!vehicle.isCar() && motorcycleSpaces > 0) {
            motorcycleSpaces--;
            return true;
        }
        return false; // Parking failed.
    }

    public int getCarSpaces() {
        return carSpaces;
    }

    public int getMotorcycleSpaces() {
        return motorcycleSpaces;
    }
}
