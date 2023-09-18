public class Main {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());

        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}