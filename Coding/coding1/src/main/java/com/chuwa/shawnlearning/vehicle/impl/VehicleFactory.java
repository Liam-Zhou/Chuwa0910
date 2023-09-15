package com.chuwa.shawnlearning.vehicle.impl;

import com.chuwa.shawnlearning.vehicle.Vehicle;
import com.chuwa.shawnlearning.vehicle.VehicleType;

public class VehicleFactory {

    private static VehicleFactory INSTANCE;

    public static VehicleFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehicleFactory();
        }
        return INSTANCE;
    }
    private VehicleFactory() {
    }

    public Vehicle createVehicle(VehicleType type) {
        return switch (type) {
            case CAR -> new SmallCar();
            case TRUCK -> new BigTruck();
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}
