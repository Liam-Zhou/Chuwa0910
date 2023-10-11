package CodingParkingLot;

public class ParkingSpot {
    private Level level;
    private int number;
    private Size size;
    private boolean availability;
    private Vehicle vehicle = null;
    private long enroutTime;

    public ParkingSpot(Level level, int number, Size size, boolean availability, long enroutTime) {
        this.level = level;
        this.number = number;
        this.size = size;
        this.availability = availability;
        this.enroutTime = enroutTime;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (getAvailability() && vehicle.canFit(this)) {
            setVehicle(vehicle);
            setAvailability(false);
            setEnrouteTime(System.currentTimeMillis());

            return true;
        }
        return false;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setEnrouteTime(long time) {
        this.enroutTime = time;
    }

    public float getEnrouteTime() {
        return enroutTime;
    }

    public Size getSize() {
        return size;
    }
}
