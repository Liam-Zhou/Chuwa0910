public class Vehicle {
    // Vehicle: Brand, color, year, plate
    String brand;
    String color;
    int year;
    String plate;

    public Vehicle(String plate){
        this.plate = plate;
    }

    public Vehicle(String plate, String brand, String color, int year){
        this.plate = plate;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getPlate() {
        return plate;
    }
}
