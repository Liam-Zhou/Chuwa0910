package com.chuwa.learn;

import java.util.Hashtable;

public class ParkingLot {
    private Hashtable<String,Car> carPool;
    private final int poolSize;
    private int currCar;

    public ParkingLot(int poolSize) {
        this.carPool = new Hashtable<>();
        this.poolSize = poolSize;
        this.currCar = 0;
    }

    public Hashtable<String, Car> getCarPool() {
        return carPool;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public boolean isFull() {
        return this.poolSize < this.currCar;
    }

    public boolean checkCar(Car car) {
        return this.carPool.containsKey(car.getId());
    }
    public boolean driveIn(Car car) {
        if(this.isFull()) {
            return false;
        }
        this.carPool.put(car.getId(),car);
        this.currCar ++;
        return true;
    }

    public void driveOut(Car car) {
        if (this.checkCar(car)) {
            this.currCar --;
            this.carPool.remove(car.getId());
        }
        return;
    }
}
