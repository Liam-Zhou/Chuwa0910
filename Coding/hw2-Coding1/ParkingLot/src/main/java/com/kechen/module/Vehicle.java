package com.kechen.module;

public class Vehicle {
    private String vehicleNumber;
    private VehicleSize vehicleSize;

    // constructor
    public Vehicle(String vehicleNumber, VehicleSize vehicleSize) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleSize = vehicleSize;
    }

    // getter and setter
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleSize=" + vehicleSize +
                '}';
    }
}
