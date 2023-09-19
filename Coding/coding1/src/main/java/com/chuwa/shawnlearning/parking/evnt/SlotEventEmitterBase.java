package com.chuwa.shawnlearning.parking.evnt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotEventEmitterBase implements SlotEventEmitter {

    protected enum EventRegistryMode {
        ONCE,
        FOREVER
    }
    protected record RegistryEntry(EventRegistryMode mode, SlotEventListener listener) {
    }
    protected Map<String, List<RegistryEntry>> entries = new HashMap<>();

    @Override
    public void on(String event, SlotEventListener listener) {
        if(!entries.containsKey(event)){
            entries.put(event, new ArrayList<>());
        }
        entries.get(event).add(new RegistryEntry(EventRegistryMode.FOREVER, listener));
    }

    @Override
    public void off(String event, SlotEventListener listener) {
        for (RegistryEntry entry : entries.getOrDefault(event, new ArrayList<>())) {
            if (entry.listener.equals(listener)) {
                entries.get(event).remove(entry);
                return;
            }
        }
    }

    @Override
    public void once(String event, SlotEventListener listener) {
        if(!entries.containsKey(event)){
            entries.put(event, new ArrayList<>());
        }
        entries.get(event).add(new RegistryEntry(EventRegistryMode.FOREVER, listener));
    }

    @Override
    public void emit(SlotEvent event) {
        for (RegistryEntry entry : entries.getOrDefault(event.name(), new ArrayList<>())) {

            entry.listener.onEvent(event);
        }
        entries.getOrDefault(event.name(), new ArrayList<>()).removeIf(entry -> entry.mode == EventRegistryMode.ONCE);
    }
}
