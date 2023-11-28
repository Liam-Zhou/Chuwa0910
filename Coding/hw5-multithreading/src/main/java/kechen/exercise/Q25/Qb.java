package kechen.exercise.Q25;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Qb {
    public static void main(String[] args) {
        // Fetch data from three different APIs asynchronously
        /**
         * products = posts, reviews = comments, inventory = todos
         */
        CompletableFuture<String> productsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> reviewsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> inventoryFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos");

        // Merge data when all CompletableFuture tasks are completed
        CompletableFuture<Void> combinedFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        combinedFutures.thenRun(() -> {
            try {
                // Get the results of all CompletableFuture tasks
                String productsData = productsFuture.get();
                String reviewsData = reviewsFuture.get();
                String inventoryData = inventoryFuture.get();

                // Process the merged data (For demonstration, simply printing here)
                System.out.println("Products Data: " + productsData);
                System.out.println("Reviews Data: " + reviewsData);
                System.out.println("Inventory Data: " + inventoryData);

                // Perform further processing with merged data
                // ...

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Ensure main thread waits for completion of all CompletableFuture tasks
        combinedFutures.join();
    }

    // Method to fetch data from a fake API (simulated asynchronous call)
    public static CompletableFuture<String> fetchDataFromAPI(String apiUrl) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e) {
                // Log the exception information
                e.printStackTrace();
                System.err.println("Exception occurred while fetching data from API: " + e.getMessage());
                // Return a default value in case of an exception
                return "Error fetching data from API";
            }
        });
    }
}
