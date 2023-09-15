package com.chuwa.shawnlearning.parking.impl;

import com.chuwa.shawnlearning.parking.evnt.SlotEvent;
import com.chuwa.shawnlearning.parking.evnt.SlotEventListener;
import com.chuwa.shawnlearning.parking.stateful.SlotSM;
import com.chuwa.shawnlearning.parking.stateful.SlotStateGraph;

import java.util.HashMap;
import java.util.Map;

public final class ParkingSlotSM implements SlotSM<SlotEvent, ParkingSlotStatus, ParkingSlotSM.ParkingSlotGraph> {
    private final ParkingSlotGraph stateGraph = new ParkingSlotGraph();
    private ParkingSlotStatus currentState = stateGraph.getInitialState();

    record GraphEdge(ParkingSlotStatus from, ParkingSlotStatus to){}
    static class ParkingSlotGraph implements SlotStateGraph<SlotEvent, ParkingSlotStatus>{
        private final Map<GraphEdge, SlotEventListener> registry = new HashMap<>();


        @Override
        public ParkingSlotStatus getInitialState() {
            return ParkingSlotStatus.AVAILABLE;
        }

        @Override
        public void onTransit(ParkingSlotStatus start, ParkingSlotStatus end, SlotEvent event) {
            if(registry.containsKey(new GraphEdge(start, end))){
                registry.get(new GraphEdge(start, end)).onEvent(event);
            }
        }

        @Override
        public void when(ParkingSlotStatus start, ParkingSlotStatus end, SlotEvent event, SlotEventListener listener) {
            registry.put(new GraphEdge(start, end), listener);
        }


    }

    @Override
    public ParkingSlotGraph getStateGraph() {
        return stateGraph;
    }

    @Override
    public void transit(SlotEvent event) {
        ParkingSlotStatus to = (ParkingSlotStatus) getCurrentState().getNextState(event);
        stateGraph.onTransit(getCurrentState(), to, event);
        currentState = to;
    }

    @Override
    public ParkingSlotStatus getCurrentState() {
        return currentState;
    }
}
