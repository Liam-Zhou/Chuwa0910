package com.chuwa.learn;
import java.util.Date;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private double hourRate;
    private ParkingLot(double hourRate){
        this.hourRate = hourRate;
    }

    public static ParkingLot getParkingLot(double hourRate) {
        if (parkingLot == null)
            parkingLot = new ParkingLot(hourRate);
        return parkingLot;
    }

    public boolean setHourRate() {
        if (parkingLot == null)
            return false;
        this.hourRate = hourRate;
        return true;
    }

    public Ticket park(String licensePlate, VehicleType vehicleType) {
        return new Ticket(licensePlate, vehicleType, new Date());
    }

    public double leave(Ticket ticket){
        if(ticket.getVehicleType() == VehicleType.Monthly){
            return 0;
        }
        double rate = hourRate * getHoursParked(ticket.getDate(), new Date());
        return rate;
    }

    private int getHoursParked(Date startDate, Date endDate) {
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        double hours = (double) secs / 3600;
        // Round up to the nearest whole hour
        int roundedHours = (int) Math.ceil(hours);
        return roundedHours;
    }
}
