package com.chuwa.shawnlearning.parking;

import com.chuwa.shawnlearning.parking.evnt.SlotEventEmitter;
import com.chuwa.shawnlearning.parking.evnt.SlotEventListener;
import com.chuwa.shawnlearning.parking.impl.ParkingSlotStatus;
import com.chuwa.shawnlearning.parking.policy.ParkingFitPolicy;
import com.chuwa.shawnlearning.parking.policy.PolicyContext;
import com.chuwa.shawnlearning.vehicle.Vehicle;

import java.util.EventListener;

public interface ParkingSlot extends SlotEventEmitter {


     boolean couldPark(Vehicle vehicle, PolicyContext context);
    ParkingSlotStatus getStatus();

    void park(Vehicle vehicle);

    void onLeave(SlotEventListener listener);
    void leave();


    String address();

    void setParkPolicy(ParkingFitPolicy policy);
}
