import java.util.ArrayList;
import java.util.List;

// Enum representing the types of vehicles
enum VehicleType {
    CAR, MOTORCYCLE, TRUCK
}

// Abstract class for vehicles
abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}

// Concrete classes for different types of vehicles
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}

// Class representing a parking space
class ParkingSpace {
    private int number;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSpace(int number) {
        this.number = number;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (!occupied) {
            parkedVehicle = vehicle;
            occupied = true;
        } else {
            System.out.println("Parking space " + number + " is already occupied.");
        }
    }

    public void vacate() {
        if (occupied) {
            parkedVehicle = null;
            occupied = false;
        } else {
            System.out.println("Parking space " + number + " is already vacant.");
        }
    }
}

// Class representing the parking lot
class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int numberOfSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= numberOfSpaces; i++) {
            parkingSpaces.add(new ParkingSpace(i));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                space.parkVehicle(vehicle);
                System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() +
                        " parked in space " + space.getNumber());
                return true;
            }
        }
        System.out.println("No available parking spaces for vehicle with license plate " + vehicle.getLicensePlate());
        return false;
    }

    public void vacateSpace(int spaceNumber) {
        for (ParkingSpace space : parkingSpaces) {
            if (space.getNumber() == spaceNumber) {
                space.vacate();
                System.out.println("Parking space " + spaceNumber + " is now vacant.");
                return;
            }
        }
        System.out.println("Invalid parking space number: " + spaceNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);

        Car car1 = new Car("ABC123");
        Car car2 = new Car("XYZ789");
        Motorcycle moto1 = new Motorcycle("DEF456");
        Truck truck1 = new Truck("GHI789");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(moto1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck1);

        parkingLot.vacateSpace(2);
        parkingLot.vacateSpace(5);
    }
}
