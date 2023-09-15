import java.util.*;

// design a basic parking lot system
class ParkingLot{
    private int capacity;
    public int remain;
    private Map<String, Vehicle> parkedVehicles;

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.remain = capacity;
        this.parkedVehicles = new HashMap<>();
    }

    public int getRemainSlot(){
        return this.remain;
    }

    public boolean parkVehicle(Vehicle newVehicle){
        if(map.containsKey(newVehicle.getLicense())){
            System.out.println("Vehicle already inside!");
            return false;
        }
        if(remain > 0){
            parkedVehicles.put(newVehicle.getLicense(), newVehicle);
            System.out.println("Parked Successful: " + newVehicle.getLicense());
            remain--;
            return true;
        }else{
            System.out.println("Parking lot is full, wait for anyone leaving");
            return false;
        }
    }

    public boolean leaveParkingLot(String licensePlate){
        if(!map.containsKey(licensePlate)){
            System.out.println("Vehicle not exist!");
            return false;
        }

        parkedVehicles.remove(licensePlate);
        remain++;
        System.out.println("Vehicle exit");
        return true;
    }
}

class Vehicle{
    private String licensePlate;

    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }
    public String getLicense(){
        return licensePlate;
    }
}

public class Main{
    public static void main(String[] args) {
        ParkingLot pkl = new ParkingLot(3);

        pkl.getRemainSlot();
        pkl.parkVehicle(new Vehicle("12345"));
        pkl.getRemainSlot();
        pkl.parkVehicle(new Vehicle("ABCDE"));
        pkl.parkVehicle(new Vehicle("GGGGG"));
        pkl.parkVehicle(new Vehicle("IIIII"));

        pkl.getRemainSlot();
        pkl.leaveParkingLot("IIIII");
        pkl.leaveParkingLot("GGGGG");
        pkl.getRemainSlot();

    }
}

