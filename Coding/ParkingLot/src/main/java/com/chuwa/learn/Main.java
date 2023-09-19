package com.chuwa.learn;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int poolSize = 5;
        ParkingLot parkinglot = new ParkingLot(poolSize);
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0; i< 10;i++) {
            cars.add(new Car(Integer.toString(i)));
        }

        for(int i=0; i<10;i++){
            Car tmp = cars.get(i);
            Boolean result = parkinglot.driveIn(tmp);
            System.out.printf("Car ID: %s trys to drive into the parkinglot,and then it %s\n",tmp.getId(),result);

            if(result) {
                if(i%2 == 0) {
                    parkinglot.driveOut(tmp);
                }
            }
        }
    }
}