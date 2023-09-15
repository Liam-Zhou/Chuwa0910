package com.chuwa.shawnlearning.parking;


import com.chuwa.shawnlearning.parking.policy.PolicyContext;
import com.chuwa.shawnlearning.vehicle.Vehicle;

import java.util.Optional;

public interface ParkingLot {

    void addSlot(ParkingSlot slot);
    Optional<ParkingSlot> park(Vehicle vehicle);
}
