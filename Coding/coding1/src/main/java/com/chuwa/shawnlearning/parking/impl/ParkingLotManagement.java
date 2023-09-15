package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.ParkingLot;
import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.policy.ParkingFitPolicy;
import com.chuwa.shawnlearning.parking.policy.PickPolicy;
import com.chuwa.shawnlearning.parking.policy.PolicyContext;
import com.chuwa.shawnlearning.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotManagement implements ParkingLot {

    private final List<ParkingSlot> parkingLots = new ArrayList<>();

    private PolicyContext context;
    private final PickPolicy<ParkingSlot> pickPolicy;
    private final ParkingFitPolicy parkingFitPolicy;

    public ParkingLotManagement(ParkingFitPolicy policy, PickPolicy<ParkingSlot> pickPolicy) {
        this.pickPolicy = pickPolicy;
        this.parkingFitPolicy = policy;
    }


    @Override
    public void addSlot(ParkingSlot slot) {
        parkingLots.add(slot);
        slot.setParkPolicy(parkingFitPolicy);
        slot.on(SlotEvent.byEventType(ParkingSlotEvent.class), (event) -> {
            if(event instanceof ParkingSlotEvent e){
                System.out.println("slot " + e.slot().address() + " is parking " + e.vehicle().getPlateNumber());
            }
        });
        slot.onLeave((event) -> {
            if(event instanceof LeavingSlotEvent e){
                System.out.println("slot " + e.slot().address() + " is leaving " + e.vehicle().getPlateNumber());
            }
        });
    }

    @Override
    public Optional<ParkingSlot> park(Vehicle vehicle) {
        var list = new ArrayList<ParkingSlot>();
        for(var slot: parkingLots){
            if(slot.couldPark(vehicle, context)){
                list.add(slot);
            }
        }
        if (list.isEmpty()){
            return Optional.empty();
        }
        var picked = pickPolicy.pick(list);
        if (picked != null){
            picked.park(vehicle);
            return Optional.of(picked);
        }
        return Optional.empty();
    }


}
