This implementation we will be dividing in 3 parts: 
- Discuss how we will be simulating the elevator design
- Parking Design Code — Iteration-1 — Park Vehicle
- Parking Design Code — Iteration-2 — Unpark Vehicle

### Simulate the Parking Lot design:

We will be simulating the scenario — A vehicle to be parked can be either a two-wheeler or a four-wheeler.
![Simulate the Parking Lot design](images/hw2/Simulate%20the%20Parking%20Lot%20design.png)

When the vehicle is to be parked, the owner will be provided a ticket. If there are no parking slots available, then a parking full exception will be thrown. When the vehicle is to be unparked, the owner must provide the ticket.

The parking charges will depend on:
- If it is a weekend or a weekday
- If the vehicle is a two-wheeler or a four-wheeler

### Parking Design Code — Iteration-1 — Park Vehicle:
- implementing the code to park the vehicle

#### module: Classes

1. **Enum VehicleSize 汽车类型** — This enum will have two values TWOWHEELER and FOURWHEELER.
    ![Enum VehicleSize](images/hw2/Enum%20VehicleSize.png)
2. **Class Vehicle 汽车** — The vehicle to be parked.
    - It has the vehicle number and the type of vehicle i.e. two-wheeler or four-wheeler.
    - vehicle的基本信息，定义了String vehicleNumber，VehicleSize vehicleSize 2个variables。

    ![Class Vehicle](images/hw2/Class%20Vehicle.png)
3. **Class Slot 停车位** — This class represents the space in the parking lot which will be used to park the vehicle. 
    
    - A Parking lot will have a finite number of parking slots. This number will be initialized. 

    - The parking lot will have two types of slots:
        - Two Wheeler Parking Slots
        - Four Wheeler Parking Slots
    
    - Each slot will be having a unique slot number.
    - 停车位的基本信息，定义了int slotNumber，boolean isEmpty，Vehicle parkVehicle 3个variables.

    ![Class Slot](images/hw2/Class%20Slot.png)

    - 2 methods:
        - public  void vacateSlot()   //清空停车位
        - public void occupySlot(Vehicle parkVehicle)  //占用停车位

4. **Class Ticket 小票** — Once the vehicle has been parked, the owner will be provided with the Ticket. 
    - It will have the slotNumber, vehicle number, time at which the vehicle has been parked and the vehicle size.
    - 小票的基本信息，定义了int slotNumber，String vehicleNumber，Date date，VehicleSize vehicleSize

    ![Class Ticket](images/hw2/Class%20Ticket.png)

#### exception:

**Class ParkingFullException 停车位已满** - creating a custom exception named ParkingFullException.
    ![exception](images/hw2/exception.png)

#### service: Interfaces

1. **Interface Parking** - an interface named Parking which will have park method
    ![Interface Parking](images/hw2/Interface%20Parking.png)

    implementing the above interface to write the logic for parking the vehicle and returning the ticket. This class will be a singleton class.
    ![implementing the interface](images/hw2/implementing%20the%20interface.png)

    - parking：创建一个interface Parking: 
        - public Ticket park(Vehicle vehicle) throws ParkingFullException;

2. **class ParkingLot**

    通过class ParkingLot implement Parking具体实现：
    - 定义了ParkingLot parkingLot，List<Slot> twoWheelerSlots， List<Slot> fourWheelerSlots.
    - 方法：
        - public static ParkingLot getParkingLot()  //获得停车位，首先判断是否位空，就返回ParkingLot的实例
        - public boolean initializeParkingSlots(int numberOfTwoWheelerParkingSlots, int numberOfFourWheelerParkingSlots) 初始化停车位
        - public Ticket park(Vehicle vehicle) . //停车，首先判断是否有available slot，然后根据类型返回小票活exception
        - private Slot getAvailableFourWheelerSlot()
        - private Slot getAvailableTwoheelerSlot()

#### test
**class TestParking** : 分别创建2轮和4轮的object, test the park logic


### ParkingLot Design Code — Iteration-2
- implementing the code to unpark the vehicle and calculate the charges.

#### exception:

**Class InvalidVehicleNumberException**

Create an exception class named InvalidVehicleNumberException. This exception will be thrown if due to some reason the vehicle to be unparked cannot be found in the parking lot.（由于某些原因在停车场找不到要未停车的车辆）

#### strategy: Interfaces

implementing classes to calculate the parking charges for the parked vehicles

1. **interface ParkingChargeStrategy**
    - int getCharge(int parkHours)
    - For this interface we will provide four implementations as follows:
        - If the parked vehicle is a four wheeler and it is parked on a weekday.
        - If the parked vehicle is a four wheeler and it is parked on a weekend.
        - If the parked vehicle is a two wheeler and it is parked on a weekday.
        - If the parked vehicle is a two wheeler and it is parked on a weekend.
    ![interface ParkingChargeStrategy]()

2. **4 classes**
    - class FourWheelerWeekDayChargeStrategy
    - class FourWheelerWeekendChargeStrategy
    - class TwoWheelerWeekDayChargeStrategy
    - class TwoWheelerWeekendChargeStrategy

#### service: Interfaces

1. **Interface Parking** - an interface named Parking which will have park method

    add a new method named unpark in the Parking interface
    - public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy)

2. **class ParkingLot** 除了之前的park logic， add unpark logic:
    - public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy)   //implement the logic to unpark the vehicle: 
    - public int getHoursParked(Date startDate, Date endDate) 
    - private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber)
    - private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber)

#### test
**class TestParking** : test the unpark logic


### Code:
see the Coding file: coding1
![syllabus]()

test park and unpark:
![test park and unpark]()