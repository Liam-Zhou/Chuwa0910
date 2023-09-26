enum VehicleType {
    CAR, TRUCK, MOTORCYCLE
}

class Vehicle {
    String licensePlate;
    VehicleType vehicleType;
    long entryTime;
    long exitTime;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.vehicleType = type;
    }

    void enter() {
        entryTime = System.currentTimeMillis();
    }

    void exit() {
        exitTime = System.currentTimeMillis();
    }
}

class ParkingSpace {
    int spaceId;
    VehicleType type;
    boolean occupied;

    public ParkingSpace(int id, VehicleType type) {
        this.spaceId = id;
        this.type = type;
    }

    boolean occupy() {
        if (occupied) {
            return false;
        }
        occupied = true;
        return true;
    }

    void release() {
        occupied = false;
    }
}

class ParkingLot {
    List<ParkingSpace> listOfSpaces;
    double ratePerHour = 2.0; // example rate

    public ParkingLot() {
        listOfSpaces = new ArrayList<>();
        // Initialize spaces - example
        for (int i = 0; i < 100; i++) {
            listOfSpaces.add(new ParkingSpace(i, VehicleType.CAR));
        }
    }

    ParkingSpace park(Vehicle vehicle) {
        for (ParkingSpace space : listOfSpaces) {
            if (!space.occupied && space.type == vehicle.vehicleType) {
                space.occupy();
                vehicle.enter();
                return space;
            }
        }
        return null; // Parking lot is full or no appropriate space found
    }

    double leave(Vehicle vehicle, ParkingSpace space) {
        vehicle.exit();
        space.release();
        return calculateCharge(vehicle);
    }

    double calculateCharge(Vehicle vehicle) {
        long duration = vehicle.exitTime - vehicle.entryTime;
        double hours = duration / 3600000.0; // Convert milliseconds to hours
        return hours * ratePerHour;
    }
}
