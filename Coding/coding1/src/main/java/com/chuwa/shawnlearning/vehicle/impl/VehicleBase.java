package com.chuwa.shawnlearning.vehicle.impl;

import com.chuwa.shawnlearning.vehicle.Vehicle;
import com.chuwa.shawnlearning.vehicle.VehicleType;

public abstract class VehicleBase implements Vehicle {
    protected final String PlateNumber;
    VehicleBase(String plateNumber)
    {
        this.PlateNumber = plateNumber;
    }

    @Override
    public String getPlateNumber() {
        return PlateNumber;
    }

}
