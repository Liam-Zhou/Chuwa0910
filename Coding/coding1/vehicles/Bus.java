package Coding.coding1.vehicles;

import Coding.coding1.ParkingSpot;
import Coding.coding1.Vehicle;
import Coding.coding1.VehicleSize;

public class Bus extends Vehicle{
    public Bus(){
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is a Large, does NOT check num of spots
		return spot.getSize() == VehicleSize.Large;
	}
    
}
