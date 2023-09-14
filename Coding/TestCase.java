public class TestCase {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        Vehicle car1 = new Vehicle(true, "ABC-1234");
        Vehicle motorcycle1 = new Vehicle(false, "XYZ-5678");

        if (parkingLot.parkVehicle(car1)) {
            System.out.println("Car parked. Spaces left: " + parkingLot.getCarSpaces());
        }

        if (parkingLot.parkVehicle(motorcycle1)) {
            System.out.println("Motorcycle parked. Spaces left: " + parkingLot.getMotorcycleSpaces());
        }
    }
}
