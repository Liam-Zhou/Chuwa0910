package com.chuwa.shawnlearning.vehicle.impl;

import com.chuwa.shawnlearning.vehicle.Vehicle;
import com.chuwa.shawnlearning.vehicle.VehicleType;

public class SmallCar  extends VehicleBase implements Vehicle {

    SmallCar(String plateNumber) {
        super(plateNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
