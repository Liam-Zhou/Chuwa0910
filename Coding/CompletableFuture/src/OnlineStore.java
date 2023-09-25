import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore {

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchFakeData("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> reviewsFuture = fetchFakeData("https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> inventoryFuture = fetchFakeData("https://jsonplaceholder.typicode.com/users");
        CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);
        allOf.thenAcceptAsync(v -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                // Merge fetched data for further processing
                String mergedData = mergeData(products, reviews, inventory);

                // Process merged data
                processMergedData(mergedData);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }

    public static CompletableFuture<String> fetchFakeData(String url) {
        // Simulate an async API call with CompletableFuture.supplyAsync
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the given URL
            // In a real-world scenario, you would make an HTTP request here
            return "Fake data from " + url;
        });
    }

    public static String mergeData(String products, String reviews, String inventory) {
        // Simulate merging data
        return products + " | " + reviews + " | " + inventory;
    }

    public static void processMergedData(String mergedData) {
        // Simulate processing merged data
        System.out.println("Processed merged data: " + mergedData);
    }
}
