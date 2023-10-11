import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore2 {

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts())
                .exceptionally(ex -> {
                    System.out.println("Error fetching products: " + ex.getMessage());
                    return "Default Product List";
                });

        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews())
                .exceptionally(ex -> {
                    System.out.println("Error fetching reviews: " + ex.getMessage());
                    return "Default Reviews";
                });

        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory())
                .exceptionally(ex -> {
                    System.out.println("Error fetching inventory: " + ex.getMessage());
                    return "Default Inventory Data";
                });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        try {
            allOf.get();
            String products = productsFuture.get();
            String reviews = reviewsFuture.get();
            String inventory = inventoryFuture.get();

            processFetchedData(products, reviews, inventory);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Simulated API calls
    public static String fetchProducts() {
        sleep(1000);
        if (true) {
            throw new RuntimeException("Products API is down");
        }
        return "List of Products";
    }

    public static String fetchReviews() {
        sleep(1000);
        return "List of Reviews";
    }

    public static String fetchInventory() {
        sleep(1000);
        return "Inventory Data";
    }

    public static void processFetchedData(String products, String reviews, String inventory) {
        System.out.println("Processing fetched data...");
        System.out.println(products);
        System.out.println(reviews);
        System.out.println(inventory);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
