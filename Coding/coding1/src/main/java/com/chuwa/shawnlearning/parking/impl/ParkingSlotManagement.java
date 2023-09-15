package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.evnt.SlotEventEmitter;
import com.chuwa.shawnlearning.parking.evnt.SlotEventEmitterBase;
import com.chuwa.shawnlearning.parking.evnt.SlotEventListener;
import com.chuwa.shawnlearning.parking.policy.ParkingFitPolicy;
import com.chuwa.shawnlearning.parking.policy.PolicyContext;
import com.chuwa.shawnlearning.vehicle.Vehicle;



public class ParkingSlotManagement implements ParkingSlot {

    private final ParkingSlotSM sm = new ParkingSlotSM();
    private ParkingFitPolicy parkingFitPolicy;

    private Vehicle vehicle =  null;

    private final SlotEventEmitter emitter = new SlotEventEmitterBase();

    private final String addr;

    public ParkingSlotManagement(String addr) {
        this.addr = addr;
    }
    @Override
    public boolean couldPark(Vehicle vehicle, PolicyContext context){
        if(sm.getCurrentState() != ParkingSlotStatus.AVAILABLE){
            return false;
        }
        if(parkingFitPolicy == null){
            return true;
        }
        return parkingFitPolicy.couldPark(this, vehicle, context);
    }

    @Override
    public ParkingSlotStatus getStatus() {
        return sm.getCurrentState();
    }

    @Override
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        var event = new ParkingSlotEvent(vehicle, this);
        sm.transit(new ParkingSlotEvent(vehicle, this));
        emit(event);
    }

    @Override
    public void onLeave(SlotEventListener listener) {
        sm.getStateGraph().when(ParkingSlotStatus.OCCUPIED, ParkingSlotStatus.AVAILABLE, new LeavingSlotEvent(vehicle, this), listener);
    }

    @Override
    public void leave() {
        sm.transit(new LeavingSlotEvent(vehicle, this));
    }

    @Override
    public String address() {
        return addr;
    }

    @Override
    public void setParkPolicy(ParkingFitPolicy policy) {
        this.parkingFitPolicy = policy;
    }

    @Override
    public void emit(SlotEvent event) {
        emitter.emit(event);
    }

    @Override
    public void on(String event, SlotEventListener listener) {
        emitter.on(event, listener);
    }

    @Override
    public void off(String event, SlotEventListener listener) {
        emitter.off(event, listener);
    }

    @Override
    public void once(String event, SlotEventListener listener) {
        emitter.once(event, listener);
    }
}
