//Encapsulation
class Car{
    private String brand;
    private int years;

    public Car(String brand, int years){

        this.brand = brand;
        this.years = years;

    }

    public String getBrand(){
        return brand;
    }

    public int getYears(){
        return years;
    }

    public void setBrand(String brand){

        this.brand = brand;
    } 

    public void setYears(int years){
        this.years = years;
    }

    public int loadSize() {
        return years;
    }

}


//Inheritance
class Vehicle extends Car{
    
    private int doors;

    public Vehicle(String brand, int years, int doors){

        super(brand,years);
        this.doors = doors;

    }

    public int getDoors(){
        return doors;
    }

    @Override
    public int loadSize(){
        return getYears();
    }

    
}



//polymorphism

class Loadable extends Vehicle{

    private int weight;

    public Loadable(String brand, int years, int doors, int weight){
        super(brand, years, doors);
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public int loadSize(){
        return weight*getYears();
    }



}



public class oop_test{

    public static void main(String []args){

        Car car = new Car("Benz",15);
        Vehicle vehicle = new Vehicle("BMW", 7, 4);
        Loadable loadable = new Loadable("audi", 11, 2, 3000);

        System.out.println("Car brand: " + car.getBrand());
        System.out.println("Car doors: " + vehicle.getDoors());
        System.out.println("Loadsize: " + loadable.loadSize());


    }

}