import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Simulation of Products, Reviews and Inventory data fetch

class ApiSimulator {
    static CompletableFuture<String> fetchProducts() {
        // Simulate fetching products from an API
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a successful API call
            return "Product Data";
        });
    }

    static CompletableFuture<String> fetchReviews() {
        // Simulate fetching reviews from an API
        return CompletableFuture.supplyAsync(() -> {
            // Simulate an exception during the API call
            throw new RuntimeException("Error fetching reviews");
        });
    }

    static CompletableFuture<String> fetchInventory() {
        // Simulate fetching inventory from an API
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a successful API call
            return "Inventory Data";
        });
    }
}

public class CompletableFutureExample {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("CompletableFutureExample");

        // Assume ApiSimulator can fetch the data by calling these three methods
        CompletableFuture<String> productsFuture = ApiSimulator.fetchProducts();
        CompletableFuture<String> reviewsFuture = ApiSimulator.fetchReviews();
        CompletableFuture<String> inventoryFuture = ApiSimulator.fetchInventory();

        // Handle exceptions using exceptionally()
        productsFuture.exceptionally(ex -> {
            logger.log(Level.WARNING, "Error fetching products: " + ex.getMessage());
            return "Default Product Data";
        });

        reviewsFuture.exceptionally(ex -> {
            logger.log(Level.WARNING, "Error fetching reviews: " + ex.getMessage());
            return "Default Reviews Data";
        });

        inventoryFuture.exceptionally(ex -> {
            logger.log(Level.WARNING, "Error fetching inventory: " + ex.getMessage());
            return "Default Inventory Data";
        });

        // Combine the results and process the data when all futures are completed
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        try {
            combinedFuture.get(); // Wait for all futures to complete
            // Merge and process the fetched data
            String productsData = productsFuture.get();
            String reviewsData = reviewsFuture.get();
            String inventoryData = inventoryFuture.get();

            // Process the merged data
            System.out.println("Merged Product Data: " + productsData);
            System.out.println("Merged Reviews Data: " + reviewsData);
            System.out.println("Merged Inventory Data: " + inventoryData);
        } catch (InterruptedException | ExecutionException e) {
            logger.log(Level.SEVERE, "Error processing data: " + e.getMessage());
        }
    }
}
