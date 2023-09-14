import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        spots = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            spots.add(new ParkingSpot(i + 1));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.parkVehicle(vehicle);
                System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " parked in spot: " + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("No available spots");
        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.removeVehicle();
                System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " removed from spot " + spot.getSpotNumber());
                return;
            }
        }
        System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " not found in the parking lot.");
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);

        Vehicle car1 = new Vehicle("111");
        Vehicle car2 = new Vehicle("222");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        parkingLot.removeVehicle(car1);

        Vehicle car3 = new Vehicle("333");
        parkingLot.parkVehicle(car3);

        Vehicle car4 = new Vehicle("444");
        parkingLot.parkVehicle(car4);

        Vehicle car5 = new Vehicle("555");
        parkingLot.parkVehicle(car5);

        parkingLot.removeVehicle(car2);
        parkingLot.removeVehicle(car3);
        parkingLot.removeVehicle(car4);
        parkingLot.removeVehicle(car5);
    }
}

class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.occupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

