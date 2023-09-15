package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.parking.policy.ParkingFitPolicy;
import com.chuwa.shawnlearning.parking.policy.PolicyContext;
import com.chuwa.shawnlearning.vehicle.Vehicle;

import java.util.Map;

public class SizeFitFitPolicy implements ParkingFitPolicy {
    @Override
    public  boolean couldPark(ParkingSlot s, Vehicle v, PolicyContext context) {
        return true;
    }
}
