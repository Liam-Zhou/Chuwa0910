class Car extends Vehicle {
    public Car() {
        size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpace spot) {
        return spot.getSize() == VehicleSize.COMPACT || spot.getSize() == VehicleSize.LARGE;
    }
}