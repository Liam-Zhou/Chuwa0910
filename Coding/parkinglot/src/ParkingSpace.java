class ParkingSpace {
    private int spotNumber;
    private VehicleSize spotSize;
    private Vehicle currentVehicle;

    public ParkingSpace(int num, VehicleSize size) {
        spotNumber = num;
        spotSize = size;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        // Check if spot is already occupied or if vehicle can fit in this spot size
        return currentVehicle == null && vehicle.canFitInSpot(this);
    }

    public void park(Vehicle v) {
        currentVehicle = v;
    }

    public void removeVehicle() {
        currentVehicle = null;
    }

    public VehicleSize getSize() {
        return spotSize;
    }
}