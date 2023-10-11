import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore {

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts());
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews());
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());

        // Merge the fetched data for further processing
        CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        // This block is just to make sure main thread doesn't terminate prematurely
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
        // Simulate some delay
        sleep(1000);
        return "List of Products";
    }

    public static String fetchReviews() {
        // Simulate some delay
        sleep(1000);
        return "List of Reviews";
    }

    public static String fetchInventory() {
        // Simulate some delay
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
