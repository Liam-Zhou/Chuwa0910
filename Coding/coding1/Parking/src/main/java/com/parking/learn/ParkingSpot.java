package com.parking.learn;

class ParkingSpot {
    private final ParkingSpotType type;
    private ParkingStatus status;
    private Vehicle vehicle;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
        this.status = ParkingStatus.EMPTY;
    }

    public boolean isAvailable() {
        return status == ParkingStatus.EMPTY;
    }

    public boolean park(Vehicle vehicle) {
        if (!isAvailable() || !canFit(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        status = ParkingStatus.OCCUPIED;
        return true;
    }

    public Vehicle leave() {
        if (isAvailable()) {
            return null;
        }
        Vehicle leftVehicle = this.vehicle;
        this.vehicle = null;
        status = ParkingStatus.EMPTY;
        return leftVehicle;
    }

    private boolean canFit(Vehicle vehicle) {
        switch (type) {
            case MOTORCYCLE_SPOT:
                return vehicle.getSize() == VehicleSize.MOTORCYCLE;
            case COMPACT_SPOT:
                return vehicle.getSize() == VehicleSize.MOTORCYCLE || vehicle.getSize() == VehicleSize.COMPACT;
            case LARGE_SPOT:
                return true;
            default:
                return false;
        }
    }
}


