package org.chuwa.entity;

import java.util.Date;

public class Schedule {
    private Date start;
    private Date end;
    private int priority;
    private boolean expEnabled;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isExpEnabled() {
        return expEnabled;
    }

    public void setExpEnabled(boolean expEnabled) {
        this.expEnabled = expEnabled;
    }
}
