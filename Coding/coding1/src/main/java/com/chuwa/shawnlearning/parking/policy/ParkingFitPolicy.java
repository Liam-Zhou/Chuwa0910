package com.chuwa.shawnlearning.parking.policy;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.vehicle.Vehicle;

public interface ParkingFitPolicy {
    boolean couldPark(ParkingSlot s, Vehicle v, PolicyContext context);
}
