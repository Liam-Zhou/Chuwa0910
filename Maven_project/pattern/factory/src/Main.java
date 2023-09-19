public class Main {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("Latte");
        System.out.println(coffee.getName());
    }
}