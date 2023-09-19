package patterns.builder;

public class OfoBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("Alumi");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Cao");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
