
class Bus extends Vehicle {
    public Bus() {
        size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpace spot) {
        // Here you might check for 5 consecutive LARGE spots, etc.
        return spot.getSize() == VehicleSize.LARGE;
    }
}