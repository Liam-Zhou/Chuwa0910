public class ParkingLot {
    private final int NUM_SPACES = 100;
    private ParkingSpace[] spaces = new ParkingSpace[NUM_SPACES];

    public ParkingLot() {
        // Initialize parking spaces
        for (int i = 0; i < NUM_SPACES; i++) {
            spaces[i] = new ParkingSpace(i, VehicleSize.COMPACT); // assuming all are compact for simplicity
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < NUM_SPACES; i++) {
            if (spaces[i].canFitVehicle(vehicle)) {
                spaces[i].park(vehicle);
                return true;
            }
        }
        return false; // No suitable spot found
    }

    public void leaveSpot(int spotNumber) {
        spaces[spotNumber].removeVehicle();
    }
}