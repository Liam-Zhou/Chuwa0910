package com.chuwa.shawnlearning.parking.evnt;

public interface SlotEvent {
    default String name(){
        return this.getClass().getSimpleName();
    }

    static String byEventType(Class<? extends SlotEvent> clazz){
        return clazz.getSimpleName();
    }
}

