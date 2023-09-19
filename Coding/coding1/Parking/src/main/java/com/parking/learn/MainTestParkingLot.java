package com.parking.learn;

import java.util.ArrayList;
import java.util.List;

public class MainTestParkingLot {

    public static void main(String[] args) {
        // Create some parking spots
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(ParkingSpotType.MOTORCYCLE_SPOT));
        spots.add(new ParkingSpot(ParkingSpotType.COMPACT_SPOT));
        spots.add(new ParkingSpot(ParkingSpotType.LARGE_SPOT));

        // Initialize parking lot system
        ParkingLotSystem parkingLot = new ParkingLotSystem(spots);

        // Create some vehicles
        Vehicle motorcycle = new Motorcycle();
        Vehicle car = new Car();
        Vehicle truck = new Truck();

        // Try parking the vehicles
        System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle));
        System.out.println("Parking car: " + parkingLot.parkVehicle(car));
        System.out.println("Parking truck: " + parkingLot.parkVehicle(truck));

        // Try removing the vehicles
        System.out.println("Leaving motorcycle: " + parkingLot.leaveVehicle(motorcycle));
        System.out.println("Leaving car: " + parkingLot.leaveVehicle(car));
        System.out.println("Leaving truck: " + parkingLot.leaveVehicle(truck));
    }
}
