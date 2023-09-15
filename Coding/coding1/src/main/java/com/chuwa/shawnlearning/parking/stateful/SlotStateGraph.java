package com.chuwa.shawnlearning.parking.stateful;

import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.evnt.SlotEventListener;

public interface SlotStateGraph<E extends SlotEvent, S extends SlotStatus<? super E> > {
    S getInitialState();
    void onTransit(S start, S end, E event);

    void when(S start, S end, E event, SlotEventListener listener);

}
