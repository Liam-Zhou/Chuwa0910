package com.kechen.test;

import com.kechen.exception.InvalidVehicleNumberException;
import com.kechen.exception.ParkingFullException;
import com.kechen.module.Ticket;
import com.kechen.module.Vehicle;
import com.kechen.module.VehicleSize;
import com.kechen.service.Parking;
import com.kechen.service.ParkingLot;
import com.kechen.strategy.FourWheelerWeekDayChargeStrategy;
import com.kechen.strategy.TwoWheelerWeekDayChargeStrategy;

public class TestParking {
    public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10,10);

        Vehicle vehicle = new Vehicle("XC555", VehicleSize.TWOWHEELER);
        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("AD777", VehicleSize.FOURWHEELER);
        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

        int cost1 = parkingLot.unPark(ticket2, new TwoWheelerWeekDayChargeStrategy());
        System.out.println(cost1);

        int cost2 = parkingLot.unPark(ticket2, new FourWheelerWeekDayChargeStrategy());
        System.out.println(cost2);
    }
}
