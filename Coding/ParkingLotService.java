public interface ParkingLotService{

    public double calculateFee(int totalHours,int perHourFee);

    public void callTowService(int parkingLotNumber,String TowCompany);

    public String findManager(int parkingLotNumber);

    public String findPhoneNumber(int parkingLotNumber);


}