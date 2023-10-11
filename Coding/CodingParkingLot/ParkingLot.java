package CodingParkingLot;

import java.util.List;


public class ParkingLot {
    private List<Level> levels;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    public int checkAvailableCounts() {
        int result = 0;
        for (Level lvl : levels) {
            if (lvl.getNumberOfAvailableSpots() > 0) {
                result += lvl.getNumberOfAvailableSpots();
            }
        }
        return result;
    }

    public int checkTotalSpotsCount() {
        int result = 0;
        for (Level lvl : levels) {
            result += lvl.getTotalSpotsCount();
        }
        return result;
    }

    public int getTotalSpots() {
        return checkTotalSpotsCount();
    }

    public int getTotalLevels() {
        return levels.size();
    }

    public boolean checkAvailability() {
        return checkAvailableCounts() != 0;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}