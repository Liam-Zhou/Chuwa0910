public class ProductFactory {
    public Product createProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ProductB();
        }
        throw new IllegalArgumentException("No such product");
    }
}
