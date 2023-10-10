// Design a parking lot
// Assume we have 5 parking lots, each parking lots must have filled or empty state,
// and the time that this parking lot has been filled, and how much the driver needs to pay.
// Assume parking fee is $2.5 / hr

import java.util.ArrayList;
import java.util.List;

class ParkingSpace {
    private boolean isFilled;
    private long filledTimeMillis; // Time in milliseconds
    private double paymentRatePerHour;

    public ParkingSpace(double paymentRatePerHour) {
        this.paymentRatePerHour = paymentRatePerHour;
        this.isFilled = false;
        this.filledTimeMillis = 0;
    }

    public void occupy() {
        if (!isFilled) {
            isFilled = true;
            filledTimeMillis = System.currentTimeMillis();
        }
    }

    public void vacate() {
        if (isFilled) {
            isFilled = false;
            long currentTimeMillis = System.currentTimeMillis();
            long parkingDurationMillis = currentTimeMillis - filledTimeMillis;
            double parkingDurationHours = parkingDurationMillis / (1000.0 * 60 * 60);
            double parkingFee = parkingDurationHours * paymentRatePerHour;
            System.out.println("Parking duration: " + parkingDurationHours + " hours");
            System.out.println("Parking fee: $" + parkingFee);
        }
    }

    public boolean isFilled() {
        return isFilled;
    }
}

class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int numSpaces, double paymentRatePerHour) {
        parkingSpaces = new ArrayList<>();
        for (int i = 0; i < numSpaces; i++) {
            parkingSpaces.add(new ParkingSpace(paymentRatePerHour));
        }
    }

    public int getAvailableSpaces() {
        int count = 0;
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isFilled()) {
                count++;
            }
        }
        return count;
    }

    public void park() {
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isFilled()) {
                space.occupy();
                System.out.println("Parking space occupied.");
                return;
            }
        }
        System.out.println("No available parking spaces.");
    }

    public void leave() {
        for (ParkingSpace space : parkingSpaces) {
            if (space.isFilled()) {
                space.vacate();
                return;
            }
        }
        System.out.println("No parked cars to leave.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a parking lot with 5 parking spaces and a rate of $2.5 per hour
        ParkingLot parkingLot = new ParkingLot(5, 2.5);

        // Park two cars
        parkingLot.park();
        parkingLot.park();

        // Wait for some time (simulating parked cars)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Make the first car leave
        parkingLot.leave();

        // Park another car
        parkingLot.park();
    }
}
