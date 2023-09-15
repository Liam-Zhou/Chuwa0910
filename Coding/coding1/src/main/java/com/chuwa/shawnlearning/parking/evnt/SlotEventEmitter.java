package com.chuwa.shawnlearning.parking.evnt;

public interface SlotEventEmitter {
    void emit(SlotEvent event);
    void on(String event, SlotEventListener listener);
    void off(String event, SlotEventListener listener);
    void once(String event, SlotEventListener listener);

}
