package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.stateful.SlotStatus;

public enum ParkingSlotStatus implements SlotStatus<SlotEvent> {
    AVAILABLE {
        @Override
        public SlotStatus<SlotEvent> getNextState(SlotEvent event) {
            return OCCUPIED;
        }
    },
    OCCUPIED {
        @Override
        public SlotStatus<SlotEvent> getNextState(SlotEvent event) {
            return AVAILABLE;
        }
    };

}
