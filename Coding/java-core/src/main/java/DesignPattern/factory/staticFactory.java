package DesignPattern.factory;

class staticFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        } else if (type.equals("B")) {
            return new ConcreteProductB();
        }
        return null;
    }
}

// 抽象产品类
interface Product {
    void operation();
}

// 具体产品类 A
class ConcreteProductA implements Product {
    public void operation() {
        System.out.println("Product A operation");
    }
}

// 具体产品类 B
class ConcreteProductB implements Product {
    public void operation() {
        System.out.println("Product B operation");
    }
}

// 客户端代码
class Client {
    public static void main(String[] args) {
        Product productA = staticFactory.createProduct("A");
        productA.operation(); // Output: Product A operation
    }
}

