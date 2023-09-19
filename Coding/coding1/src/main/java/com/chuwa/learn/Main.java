package com.chuwa.learn;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLot(4.5);
        Ticket t1 = parkingLot.park("ABC446", VehicleType.Temp);
        Ticket t2 = parkingLot.park("UFB365", VehicleType.Monthly);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        double cost1 = parkingLot.leave(t1);
        System.out.print(cost1+"\n");
        double cost2 = parkingLot.leave(t2);
        System.out.print(cost2+"\n");


    }
}