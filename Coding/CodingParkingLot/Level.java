package CodingParkingLot;
import java.util.*;

public class Level {
    private List<ParkingSpot> parkingSpots;
    private int numberOfAvailableSpots;

    public Level(List<ParkingSpot> parkingSpots, int numberOfAvailableSpots) {
        this.parkingSpots = parkingSpots;
        this.numberOfAvailableSpots = numberOfAvailableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getAvailability() && (parkingSpot.parkVehicle(vehicle))) {
                    numberOfAvailableSpots -= 1;
                    return true;
            }
        }
        return false;
    }

    public int getNumberOfAvailableSpots() {
        return numberOfAvailableSpots;
    }

    public int getTotalSpotsCount() {
        return parkingSpots.size();
    }
}
