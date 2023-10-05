package org.chuwa.entity;

import java.util.Date;

public class PreOrder {
    private Date streetDate;
    private String streetDateDisplayable;
    private String streetDateType;
    private boolean isPreOrder;
    private String preOrderMessage;
    private String preOrderStreetDateMessage;

    public Date getStreetDate() {
        return streetDate;
    }

    public void setStreetDate(Date streetDate) {
        this.streetDate = streetDate;
    }

    public String getStreetDateDisplayable() {
        return streetDateDisplayable;
    }

    public void setStreetDateDisplayable(String streetDateDisplayable) {
        this.streetDateDisplayable = streetDateDisplayable;
    }

    public String getStreetDateType() {
        return streetDateType;
    }

    public void setStreetDateType(String streetDateType) {
        this.streetDateType = streetDateType;
    }

    public boolean isPreOrder() {
        return isPreOrder;
    }

    public void setPreOrder(boolean preOrder) {
        isPreOrder = preOrder;
    }

    public String getPreOrderMessage() {
        return preOrderMessage;
    }

    public void setPreOrderMessage(String preOrderMessage) {
        this.preOrderMessage = preOrderMessage;
    }

    public String getPreOrderStreetDateMessage() {
        return preOrderStreetDateMessage;
    }

    public void setPreOrderStreetDateMessage(String preOrderStreetDateMessage) {
        this.preOrderStreetDateMessage = preOrderStreetDateMessage;
    }
}
