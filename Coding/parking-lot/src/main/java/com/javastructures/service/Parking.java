package com.javastructures.service;

import com.javastructures.exception.InvalidVehicleNumberException;
import com.javastructures.exception.ParkingFullException;
import com.javastructures.model.Ticket;
import com.javastructures.model.Vehicle;
import com.javastructures.strategy.ParkingChargeStrategy;

public interface Parking {

    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}
