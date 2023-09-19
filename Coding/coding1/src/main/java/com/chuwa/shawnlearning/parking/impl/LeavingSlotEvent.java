package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.vehicle.Vehicle;

public record LeavingSlotEvent(Vehicle vehicle, ParkingSlot slot) implements SlotEvent {
}
