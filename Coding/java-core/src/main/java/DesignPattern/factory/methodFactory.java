package DesignPattern.factory;

// 客户端代码
public class methodFactory {
    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        productA.operation(); // Output: Product A operation

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        productB.operation(); // Output: Product B operation
    }
}

// 具体产品类 A
class ConcreteProductAA implements Product {
    public void operation() {
        System.out.println("Product A operation");
    }
}

// 具体产品类 B
class ConcreteProductBB implements Product {
    public void operation() {
        System.out.println("Product B operation");
    }
}

// 抽象工厂接口
interface Factory {
    Product createProduct();
}

// 具体工厂 A
class ConcreteFactoryA implements Factory {
    public Product createProduct() {
        return new ConcreteProductAA();
    }
}

// 具体工厂 B
class ConcreteFactoryB implements Factory {
    public Product createProduct() {
        return new ConcreteProductBB();
    }
}


