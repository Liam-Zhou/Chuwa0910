package com.chuwa.shawnlearning.parking.stateful;

import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.evnt.SlotEventListener;

public interface SlotSM< E extends SlotEvent, S extends SlotStatus<? super E>, G extends SlotStateGraph<? super E, ? super S>> {

    G getStateGraph();

    void transit(E event);

    S getCurrentState();

}
