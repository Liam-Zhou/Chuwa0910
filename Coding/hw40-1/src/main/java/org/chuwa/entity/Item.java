package org.chuwa.entity;

import org.chuwa.entity.util.BadgeConstants;
import org.chuwa.entity.util.RequestTypeConstants;

import java.util.List;

public class Item {
    private Long id;
    private int availableQty;
    private String fulfillmentType;
    private double price;
    private double wasPrice;
    private String fulfillmentGroup;
    private List<BadgeConstants> badges;
    private List<RequestTypeConstants> requestType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public String getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWasPrice() {
        return wasPrice;
    }

    public void setWasPrice(double wasPrice) {
        this.wasPrice = wasPrice;
    }

    public String getFulfillmentGroup() {
        return fulfillmentGroup;
    }

    public void setFulfillmentGroup(String fulfillmentGroup) {
        this.fulfillmentGroup = fulfillmentGroup;
    }

    public List<BadgeConstants> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeConstants> badges) {
        this.badges = badges;
    }

    public List<RequestTypeConstants> getRequestType() {
        return requestType;
    }

    public void setRequestType(List<RequestTypeConstants> requestType) {
        this.requestType = requestType;
    }
}
