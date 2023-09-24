package hw5;
import java.net.URI;
import java.net.http.HttpClient;
        import java.net.http.HttpRequest;
        import java.net.http.HttpResponse;
        import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class h2 {
    private static final String BASE_URL = "https://api.bestbuy.com";
    private static final String API_KEY = "123456abcdef";
    private static final Logger LOGGER = Logger.getLogger(h2.class.getName());

    public static CompletableFuture<String> fetchDataFromApi(String apiEndpoint) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + apiEndpoint))
                .header("Authorization", "Bearer " + API_KEY)
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Handle exceptions and return a default value
        return responseFuture.thenApply(response -> {
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                LOGGER.log(Level.WARNING, "API request failed with status code: " + response.statusCode());
                return "Default Value"; // Return a default value in case of error
            }
        }).exceptionally(ex -> {
            LOGGER.log(Level.SEVERE, "Exception occurred during API request: " + ex.getMessage(), ex);
            return "Default Value"; // Return a default value in case of exception
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> productsData = fetchDataFromApi("/products/8880044.json");
        CompletableFuture<String> reviewsData = fetchDataFromApi("/reviews");
        CompletableFuture<String> inventoryData = fetchDataFromApi("/inventory");

        CompletableFuture<Void> mergedData = CompletableFuture.allOf(productsData, reviewsData, inventoryData);

        mergedData.thenRun(() -> {
            String productsJson = productsData.join();
            String reviewsJson = reviewsData.join();
            String inventoryJson = inventoryData.join();

            System.out.println(productsJson);
            System.out.println(reviewsJson);
            System.out.println(inventoryJson);

            // Perform further processing with the merged data
            // Parse JSON, combine, and work with the data as needed
        }).join(); // Wait for all data to be fetched and processed
    }
}
