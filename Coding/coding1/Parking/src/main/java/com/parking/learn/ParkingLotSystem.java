package com.parking.learn;

import java.util.List;

public class ParkingLotSystem {
    private final List<ParkingSpot> spots;

    public ParkingLotSystem(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.park(vehicle)) {
                return true;
            }
        }
        return false; // Parking lot is full or no suitable spot found
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.leave() == vehicle) {
                return true;
            }
        }
        return false; // Vehicle not found in parking lot
    }
}
