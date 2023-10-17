public class ParkingSpot {
    private final VehicleSize spotSize;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize spotSize) {
        this.spotSize = spotSize;
    }

    public boolean fit(Vehicle v) {
        return currentVehicle == null && spotSize.getSize() >= v.getSize().getSize();
    }

    boolean park(Vehicle v) {
        if (fit(v)) {
            currentVehicle = v;
            return true;
        }
        return false;
    }

    void leave(Vehicle v) {
        currentVehicle = null;
    }

    Vehicle getVehicle() {
        return currentVehicle;
    }
}
