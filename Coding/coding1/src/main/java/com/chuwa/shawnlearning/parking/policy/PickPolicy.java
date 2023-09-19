package com.chuwa.shawnlearning.parking.policy;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.vehicle.Vehicle;

import java.util.List;

public interface PickPolicy<T extends ParkingSlot> {
    T pick(List<? extends T> matchedSlots);
}
