import java.util.ArrayList;
import java.util.List;


//define different types of vehicles
enum VehicleSize {
    SMALL, MEDIUM, LARGE;
}

// Abstract class representing a vehicle. Can be extended to create classes for specific types of vehicles
abstract class Vehicle {
    protected VehicleSize size;
    protected String licensePlate;

    public VehicleSize getSize() {
        return size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public abstract double calculateParkingFee();
}

// Classes representing different types of vehicles
class Motorcycle extends Vehicle {
    public Motorcycle() {
        size = VehicleSize.SMALL;
    }

    @Override
    public double calculateParkingFee() {
        return 100.0;
    }
}

class Car extends Vehicle {
    public Car() {
        size = VehicleSize.MEDIUM;
    }

    @Override
    public double calculateParkingFee() {
        return 200.0;
    }
}

class Bus extends Vehicle {
    public Bus() {
        size = VehicleSize.LARGE;
    }

    @Override
    public double calculateParkingFee() {
        return 300.0;
    }
}

// Class representing an individual parking spot
class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public boolean fit(Vehicle v) {
        return currentVehicle == null && v.getSize().ordinal() <= size.ordinal();
    }

    public void park(Vehicle v) throws Exception {
        if (!fit(v)) {
            throw new Exception("The vehicle can't fit in the spot");
        }
        currentVehicle = v;
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}

// Class representing the parking lot
class ParkingLot {
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLot(int numSmall, int numMedium, int numLarge) {
        for (int i = 0; i < numSmall; i++) {
            spots.add(new ParkingSpot(VehicleSize.SMALL));
        }
        for (int i = 0; i < numMedium; i++) {
            spots.add(new ParkingSpot(VehicleSize.MEDIUM));
        }
        for (int i = 0; i < numLarge; i++) {
            spots.add(new ParkingSpot(VehicleSize.LARGE));
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                try {
                    spot.park(v);
                    System.out.println("Parking fee: " + v.calculateParkingFee());
                    return true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }
}

// Main class to demonstrate the parking lot system
public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10, 10, 10);
        Vehicle bike = new Motorcycle();
        Vehicle car = new Car();
        Vehicle bus = new Bus();

        System.out.println("Bike parked: " + lot.parkVehicle(bike));
        System.out.println("Car parked: " + lot.parkVehicle(car));
        System.out.println("Bus parked: " + lot.parkVehicle(bus));
    }
}
