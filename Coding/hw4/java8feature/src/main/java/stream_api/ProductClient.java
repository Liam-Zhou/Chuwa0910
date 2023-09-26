package stream_api;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.*;

public class ProductClient {
    static List<Product> productList = Arrays.asList(
            new Product(1, "Product 1", "Electronics", 99.99, 20),
            new Product(2, "Product 2", "Electronics", 199.99, 15),
            new Product(3, "Product 3", "Electronics", 299.99, 5),
            new Product(4, "Product 4", "Clothing", 49.99, 30),
            new Product(5, "Product 5", "Clothing", 29.99, 25),
            new Product(6, "Product 6", "Clothing", 59.99, 10),
            new Product(7, "Product 7", "Kitchen", 89.99, 8),
            new Product(8, "Product 8", "Kitchen", 120.99, 2),
            new Product(9, "Product 9", "Kitchen", 60.99, 15)
    );

    @Test
    public void toList() {
        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getStock() > 10)
                .toList();
    }

    @Test
    public void toSet() {
        Set<String> uniqueCategories = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    @Test
    public void joining() {
        String allProductNames = productList.stream().map(Product::getName).collect(Collectors.joining(" "));
    }

    @Test
    public void counting() {
        Map<String, Long> categoryCounts = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }


}