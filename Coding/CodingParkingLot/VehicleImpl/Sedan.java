package CodingParkingLot.VehicleImpl;
import CodingParkingLot.ParkingSpot;
import CodingParkingLot.Size;
import CodingParkingLot.Vehicle;
public class Sedan extends Vehicle {
    public Sedan(Size size, String brand, String model, String plate) {
        super(size, brand, model, plate);
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSize() == Size.Compact || spot.getSize() == Size.Large;
    }
}

