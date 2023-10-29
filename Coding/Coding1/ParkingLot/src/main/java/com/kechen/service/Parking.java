package com.kechen.service;

import com.kechen.exception.InvalidVehicleNumberException;
import com.kechen.exception.ParkingFullException;
import com.kechen.module.Ticket;
import com.kechen.module.Vehicle;
// import com.kechen.strategy.ParkingChargeStrategy;
public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    // public int unpark(Ticket ticket, parkingChargeStrategy parkingCostStrategy) throws  InvalidVehicleNumberException;
}
