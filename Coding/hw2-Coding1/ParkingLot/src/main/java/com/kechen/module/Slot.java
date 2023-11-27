package com.kechen.module;

public class Slot {

    private int slotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;  //停入车的详细信息


    // constructor
    public Slot(int slotNumber) {  //因为ParkingLot的initializeParkingSlots方法用到的参数只有slotNumber，isEmpty默认为true
        this.slotNumber = slotNumber;
        isEmpty = true;
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
