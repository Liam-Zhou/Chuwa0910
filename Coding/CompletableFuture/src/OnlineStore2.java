import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore2 {

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchFakeData("https://jsonplaceholder.typicode.com/posts")
                .exceptionally(ex -> handleException(ex, "Default Products Data"));
        CompletableFuture<String> reviewsFuture = fetchFakeData("https://jsonplaceholder.typicode.com/comments")
                .exceptionally(ex -> handleException(ex, "Default Reviews Data"));
        CompletableFuture<String> inventoryFuture = fetchFakeData("https://jsonplaceholder.typicode.com/users")
                .exceptionally(ex -> handleException(ex, "Default Inventory Data"));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allOf.thenAcceptAsync(v -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                // Merge the fetched data for further processing
                String mergedData = mergeData(products, reviews, inventory);

                // Process the merged data
                processMergedData(mergedData);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }

    public static CompletableFuture<String> fetchFakeData(String url) {
        // Use CompletableFuture.supplyAsync to simulate asynchronous API calls
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the given URL
            // In real-world scenarios, you would issue an HTTP request here
            if (url.contains("comments")) {  // Simulate an error for reviews API
                throw new RuntimeException("Error fetching data from " + url);
            }
            return "Fake data from " + url;
        });
    }

    public static String handleException(Throwable ex, String defaultValue) {
        // Log the exception information
        System.err.println("Exception: " + ex.getMessage());
        return defaultValue;
    }

    public static String mergeData(String products, String reviews, String inventory) {
        // Simulate merging the data
        return products + " | " + reviews + " | " + inventory;
    }

    public static void processMergedData(String mergedData) {
        // Simulate processing the merged data
        System.out.println("Processing merged data: " + mergedData);
    }
}
