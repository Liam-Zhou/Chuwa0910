public class Client {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        // Creating ProductA
        Product productA = productFactory.createProduct("A");
        productA.createProduct();

        // Creating ProductB
        Product productB = productFactory.createProduct("B");
        productB.createProduct();
    }
}
