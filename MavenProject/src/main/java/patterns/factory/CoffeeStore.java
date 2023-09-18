package patterns.factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = null;
        if("Americano".equals(type)){
            coffee = new Americano();
        }else if("Latte".equals(type)){
            coffee = new Latte();
        }else{
            throw new RuntimeException("No type found");
        }
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
