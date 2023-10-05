package Coding.coding1.vehicles;

import Coding.coding1.ParkingSpot;
import Coding.coding1.Vehicle;
import Coding.coding1.VehicleSize;

public class Car extends Vehicle {
    public Car(){
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is a compact or a large
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
    
}
