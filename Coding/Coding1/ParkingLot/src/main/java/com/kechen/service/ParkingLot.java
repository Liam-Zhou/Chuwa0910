package com.kechen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kechen.exception.InvalidVehicleNumberException;
import com.kechen.exception.ParkingFullException;
import com.kechen.module.Slot;
import com.kechen.module.Ticket;
import com.kechen.module.Vehicle;
import com.kechen.module.VehicleSize;
import com.kechen.strategy.ParkingChargeStrategy;

public class ParkingLot implements Parking{

    /*
    定义了一个静态字段 parkingLot，并且没有立即对它进行初始化。这是一个常见的设计模式，通常用于实现单例模式。
    单例模式是一种创建模式，它确保类有且仅有一个实例，并提供一个全局访问点来访问该实例。
    在上述代码中，ParkingLot 类的设计可能意图将 ParkingLot 类限制为只有一个实例，以模拟一个唯一的停车场。
     */
    private static ParkingLot parkingLot;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    // constructor
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
        System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSlots);
        for(int i = 1; i <= numberOfFourWheelerParkingSlots; i++){
            fourWheelerSlots.add(new Slot(i));
        }
        System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSlots);
        return true;
    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException{
        Slot availableSlot;
        if(vehicle.getVehicleSize().equals(VehicleSize.FOURWHEELER)){
            availableSlot = getAvailableFourWheelerSlot();
        }else{
            availableSlot = getAvailableTwoheelerSlot();
        }
        availableSlot.occupySlot((vehicle));
        System.out.printf("Allocated slot number: %d \n", availableSlot.getSlotNumber());

        Ticket ticket = new Ticket(availableSlot.getSlotNumber(), vehicle.getVehicleNumber(),new Date(),vehicle.getVehicleSize());
        return ticket;
    }

    private Slot getAvailableFourWheelerSlot() throws ParkingFullException{
        for(Slot slot : fourWheelerSlots){
            if(slot.isEmpty()){
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Four Slot available");
    }

    private Slot getAvailableTwoheelerSlot() throws ParkingFullException{
        for(Slot slot : twoWheelerSlots){
            if(slot.isEmpty()){
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Two Slot available");
    }



    @Override
    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException {
        int costByHours = 0;
        Slot slot;
        try {
            if (ticket.getVehicleSize().equals(VehicleSize.FOURWHEELER)) {
                slot = getFourWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
            } else {
                slot = getTwoWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
            }
            slot.vacateSlot();
            int hours = getHoursParked(ticket.getDate(), new Date());
            costByHours = parkingCostStrategy.getCharge(hours);
            System.out.println(
                    "Vehicle with registration " + ticket.getVehicleNumber() + " at slot number " + slot.getSlotNumber()
                            + " was parked for " + hours + " hours and the total charge is " + costByHours);
        } catch (InvalidVehicleNumberException invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
        return costByHours;
    }

    public int getHoursParked(Date startDate, Date endDate){
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        int hours = (int) (secs / 3600);
        return hours;
    }

    private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException{
        for(Slot slot : fourWheelerSlots){
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }

    private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException{
        for(Slot slot : twoWheelerSlots){
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)){
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }
}
