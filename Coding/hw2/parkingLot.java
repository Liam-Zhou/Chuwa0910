import java.util.ArrayList;

public class parkingLot{
    // Parking Lot: Current Vehicle, Total space, Parking Lot name
    int space;
    String name;

    ArrayList<Vehicle> list = new ArrayList<>();
    public parkingLot(String name){
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<Vehicle> list) {
        this.list = list;
    }
}
