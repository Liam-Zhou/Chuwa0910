package com.chuwa.shawnlearning;

import com.chuwa.shawnlearning.parking.impl.FirstAvailablePickPolicy;
import com.chuwa.shawnlearning.parking.impl.ParkingLotManagement;
import com.chuwa.shawnlearning.parking.impl.ParkingSlotManagement;
import com.chuwa.shawnlearning.parking.impl.SizeFitFitPolicy;
import com.chuwa.shawnlearning.vehicle.VehicleType;
import com.chuwa.shawnlearning.vehicle.impl.VehicleFactory;


public class Main {
    public static void main(String[] args) {
        var pickPolicy = new FirstAvailablePickPolicy();
        var fitPolicy = new SizeFitFitPolicy();
        var lot = new ParkingLotManagement(fitPolicy, pickPolicy);
        for(int i=0; i < 10; i++) {
            lot.addSlot(new ParkingSlotManagement(String.valueOf(i)));
        }

        var factory = VehicleFactory.getInstance();
        var car = factory.createVehicle(VehicleType.CAR, "111111");

        var picked = lot.park(car);

        var slot = picked.get();

        System.out.println(slot.address());

        System.out.println(slot.getStatus());

        picked.get().leave();

        System.out.println(slot.address());

        System.out.println(slot.getStatus());

    }
}