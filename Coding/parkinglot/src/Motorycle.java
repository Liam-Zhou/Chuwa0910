class Motorcycle extends Vehicle {
    public Motorcycle() {
        size = VehicleSize.MOTORCYCLE;
    }
    @Override
    public boolean canFitInSpot(ParkingSpace spot) {
        return true;
    }
}