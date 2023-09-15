package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.ParkingSlot;
import com.chuwa.shawnlearning.parking.policy.PickPolicy;

import java.util.List;

public class FirstAvailablePickPolicy implements PickPolicy<ParkingSlot> {

    @Override
    public ParkingSlot pick(List<? extends ParkingSlot> matchedSlots) {
        if (matchedSlots.isEmpty()){
            return null;
        }
        return matchedSlots.get(0);
    }
}
