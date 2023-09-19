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

    public Vehicle createVehicle(VehicleType type, String plateNumber){
        return switch (type) {
            case CAR -> new SmallCar(plateNumber);
            case TRUCK -> new BigTruck(plateNumber);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}
