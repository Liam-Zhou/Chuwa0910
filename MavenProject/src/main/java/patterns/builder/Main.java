package patterns.builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());

        Director director2 = new Director(new OfoBuilder());
        Bike bike2 = director2.construct();
        System.out.println(bike2.getFrame());
        System.out.println(bike2.getSeat());
    }
}
