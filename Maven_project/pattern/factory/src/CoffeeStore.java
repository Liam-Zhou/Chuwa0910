public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = null;
        if("Americano".equals(type)){
            coffee = new Americano();
        }else if("Latte".equals(type)){
            coffee = new Latte();
        }else{
            throw new RuntimeException("没有对应类型");
        }
        coffee.addmilk();
        coffee.addsugar();
        return coffee;
    }
}
