package com.chuwa.shawnlearning.parking.stateful;

import com.chuwa.shawnlearning.parking.evnt.SlotEvent;

public interface SlotStatus<E extends SlotEvent> {
    SlotStatus<E> getNextState(E event);
}
