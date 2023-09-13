package com.chuwa.learn;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ParkingLot {

    // size of the parking lot
    private int capacity;
    // queue that stores all empty spot
    private Queue<ParkingSpot> spotsFree;
    // map the parked vehicle with its corresponding spot
    private Map<Vehicle, ParkingSpot> spotsOccupied;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spotsFree = new LinkedList<>();
        this.spotsOccupied = new HashMap<>();
        while (capacity > 0) {
            spotsFree.offer(new ParkingSpot(capacity --));
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int spotLeft() {
        return spotsFree.size();
    }

    public boolean park(Vehicle vehicle, LocalDateTime time) {
        if (spotLeft() > 0) {
            ParkingSpot spot = spotsFree.poll();
            spot.setStartTime(time);
            spotsOccupied.put(vehicle, spot);
            return true;
        } else {
            return false;
        }
    }

    // return charge amount
    public void leave(Vehicle vehicle, LocalDateTime time) {
        try {
            // TODO: some charge function here, throw error if fail to pay or payment cancelled, with corresponding charge rate for different type of vehicle(if applicable)
            ParkingSpot spot = spotsOccupied.get(vehicle);
            spotsOccupied.remove(vehicle);
            spot.setStartTime(null);
            spotsFree.offer(spot);
        } catch (Exception e) {
            System.out.println("Pay before you leave");
        }
    }


}

class ParkingSpot {
    // the id of the current spot
    private int id;
    private LocalDateTime startTime;

    public ParkingSpot(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // get the start parking time for current vehicle
    public LocalDateTime getStartTime() {
        return startTime;
    }

    // set the start parking time
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}

// type of the vehicle, maybe key pair if different type of vehicle has different charge rate. 
// use enum instead of string to prevent some strange things(such as park a helicopter here) happen
enum VehicleType {
    type1,
    type2,
    moreType

}

class Vehicle {
    // the license plate, should not be changed once been instantiated
    private String licensePlate;
    // type of the vehicle
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}