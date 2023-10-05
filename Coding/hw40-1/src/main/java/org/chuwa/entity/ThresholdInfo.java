package org.chuwa.entity;

import java.util.Date;

public class ThresholdInfo {
    private Date slotExpirationTime;
    private Date slotExpirationTime_SC;
    private boolean isUnScheduledPickUp;

    public Date getSlotExpirationTime() {
        return slotExpirationTime;
    }

    public void setSlotExpirationTime(Date slotExpirationTime) {
        this.slotExpirationTime = slotExpirationTime;
    }

    public Date getSlotExpirationTime_SC() {
        return slotExpirationTime_SC;
    }

    public void setSlotExpirationTime_SC(Date slotExpirationTime_SC) {
        this.slotExpirationTime_SC = slotExpirationTime_SC;
    }

    public boolean isUnScheduledPickUp() {
        return isUnScheduledPickUp;
    }

    public void setUnScheduledPickUp(boolean unScheduledPickUp) {
        isUnScheduledPickUp = unScheduledPickUp;
    }
}
