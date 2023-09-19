package com.chuwa.learn;
import java.util.Date;

public class Ticket extends Vehicle{
    private Date date;

    public Ticket(String licensePlate, VehicleType vehicleType, Date date){
        super(licensePlate, vehicleType);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
