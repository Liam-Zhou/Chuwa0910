package com.kechen.module;

public class Slot {

    private int slotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;  //停入车的详细信息

    // constructor
    public Slot(int slotNumber, boolean isEmpty) {
        this.slotNumber = slotNumber;
        this.isEmpty = true;  // set the default is true
    }

    //getter and setter
    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    // methods
    public  void vacateSlot(){
        parkVehicle = null; //停入车的详细信息变为空
        this.isEmpty = true;
    }

    public void occupySlot(Vehicle parkVehicle){
        this.parkVehicle = parkVehicle;   //输入停入车的详细信息
        this.isEmpty = false;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotNumber=" + slotNumber +
                ", isEmpty=" + isEmpty +
                ", parkVehicle=" + parkVehicle +
                '}';
    }
}
