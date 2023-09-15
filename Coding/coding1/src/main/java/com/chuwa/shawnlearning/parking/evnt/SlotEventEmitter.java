package com.chuwa.shawnlearning.parking.evnt;

public interface SlotEventEmitter {
    void emit(SlotEvent event);
    void on(SlotEvent event, SlotEventListener listener);
    void off(SlotEvent event, SlotEventListener listener);
    void once(SlotEvent event, SlotEventListener listener);

}
