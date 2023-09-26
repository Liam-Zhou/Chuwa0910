package Factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("americano".equals(type)) {
            coffee = new Americano();
        } else if ("latte".equals(type)) {
            coffee = new Latte();
        } else {
            throw new RuntimeException("Sorry, No existing coffee type!");
        }

        // Add Sugar or Milk
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
