package DesignPattern.factory;

public class abstractFactory {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();

        productA1.operation(); // Output: Product A1 operation
        productB1.operation(); // Output: Product B1 operation

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();

        productA2.operation(); // Output: Product A2 operation
        productB2.operation(); // Output: Product B2 operation
    }
}


interface ProductA {
    void operation();
}

interface ProductB {
    void operation();
}

// 具体产品类 A1
class ConcreteProductA1 implements ProductA {
    public void operation() {
        System.out.println("Product A1 operation");
    }
}

// 具体产品类 A2
class ConcreteProductA2 implements ProductA {
    public void operation() {
        System.out.println("Product A2 operation");
    }
}

// 具体产品类 B1
class ConcreteProductB1 implements ProductB {
    public void operation() {
        System.out.println("Product B1 operation");
    }
}

// 具体产品类 B2
class ConcreteProductB2 implements ProductB {
    public void operation() {
        System.out.println("Product B2 operation");
    }
}

// 抽象工厂接口
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// 具体工厂 1
class ConcreteFactory1 implements AbstractFactory {
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// 具体工厂 2
class ConcreteFactory2 implements AbstractFactory {
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}
