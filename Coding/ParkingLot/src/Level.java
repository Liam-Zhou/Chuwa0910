import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spots;
    private static final double DEFAULT_RATE_OF_REGULAR = 0.5;

    public Level (int numOfSpots) {
        this(numOfSpots, DEFAULT_RATE_OF_REGULAR);
    }

    public Level(int numOfSpots, double rateOfRegular) {
        List<ParkingSpot> list = new ArrayList<>();
        int i = 0;
        for (; i < numOfSpots * rateOfRegular; i++) {
            list.add(new ParkingSpot(VehicleSize.Regular));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        // list(spots) cannot be changed after initialization
        spots = Collections.unmodifiableList(list);
    }

    boolean hasSpot(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (park(v)) {
                return true;
            }
        }
        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == v) {
                spot.leave(v);
                return true;
            }
        }
        return false;
    }
}
