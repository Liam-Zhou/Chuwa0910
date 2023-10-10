package Coding.coding1.vehicles;

import Coding.coding1.ParkingSpot;
import Coding.coding1.Vehicle;
import Coding.coding1.VehicleSize;

public class Motorcycle extends Vehicle {
    public Motorcycle(){
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is a compact, motorcycle or a large
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Motorcycle;
	}
}
