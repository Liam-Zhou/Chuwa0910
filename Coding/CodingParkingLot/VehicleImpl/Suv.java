package CodingParkingLot.VehicleImpl;
import CodingParkingLot.ParkingSpot;
import CodingParkingLot.Size;
import CodingParkingLot.Vehicle;
public class Suv extends Vehicle {
    public Suv(Size size, String brand, String model, String plate) {
        super(size, brand, model, plate);
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSize() == Size.Large;
    }
}
