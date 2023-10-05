package org.chuwa.entity;

import java.util.List;

public class CartContext {
    private String cartIntent;
    private String slotType;
    private List<ThresholdInfo> thresholdInfoLists;
    private List<Item> items;

    public String getCartIntent() {
        return cartIntent;
    }

    public void setCartIntent(String cartIntent) {
        this.cartIntent = cartIntent;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public List<ThresholdInfo> getThresholdInfoLists() {
        return thresholdInfoLists;
    }

    public void setThresholdInfoLists(List<ThresholdInfo> thresholdInfoLists) {
        this.thresholdInfoLists = thresholdInfoLists;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
