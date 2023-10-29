package com.kechen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kechen.exception.ParkingFullException;
import com.kechen.module.Slot;
import com.kechen.module.Ticket;
import com.kechen.module.Vehicle;
import com.kechen.module.VehicleSize;

public class ParkingLot implements Parking{
    private static ParkingLot parkingLot;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    public ParkingLot() {
        this.twoWheelerSlots = new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
    }

    public static ParkingLot getParkingLot(){
        if(parkingLot == null) {
            parkingLot = new ParkingLot();
        }
            return parkingLot;
        }


    public boolean initializeParkingSlots(int numberOfTwoWheelerParkingSlots, int numberOfFourWheelerParkingSlots){
        for(int i = 1; i <= numberOfTwoWheelerParkingSlots;i++){
            twoWheelerSlots.add(new Slot(i));
        }
        System.out.println("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSlots);
        for(int i = 1; i <= numberOfFourWheelerParkingSlots; i++){
            fourWheelerSlots.add(new Slot(i));
        }
        System.out.println("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSlots);
    }

    public Ticket park(Vehicle vehicle) throws ParkingFullException{
        Slot nextAvailableSlot;
        if(vehicle.getVehicleSize().equals((VehicleSize.FOURWHEELER)){
            nextAvailableSlot = getNextAvailableFourWheelerSlot();
        }else{
            nextAvailableSlot = getNextAvailableTwoheelerSlot();
        }
        nextAvailableSlot.occupySlot((vehicle));
        System.out.println("Allocated slot number: %d \n", nextAvailableSlot.getSlotNumber());

        Ticket ticket = new Ticket(nextAvailableSlot.getSlotNumber(), vehicle.getVehicleNumber(),vehicle.getVehicleSize(), new Date());
        return ticket;
    }

    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException{
        for(Slot slot : fourWheelerSlots){
            if(slot.isEmpty()){
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Four Slot available");
    }

    private Slot getNextAvailableTwoheelerSlot() throws ParkingFullException{
        for(Slot slot : twoWheelerSlots){
            if(slot.isEmpty()){
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Two Slot available");
    }
}
