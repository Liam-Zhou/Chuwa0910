package com.hw5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreWithExceptionHandling {
    private static final Logger LOGGER = Logger.getLogger(OnlineStoreWithExceptionHandling.class.getName());

    public static void main(String[] args) {
        try {
            // Fetch data from three APIs asynchronously
            CompletableFuture<String> productsFuture = fetchDataFromAPI("Products API");
            CompletableFuture<String> reviewsFuture = fetchDataFromAPI("Reviews API");
            CompletableFuture<String> inventoryFuture = fetchDataFromAPI("Inventory API");

            // Combine all futures
            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

            // Wait for all futures to complete
            combinedFuture.get();

            // Get the results from the futures
            String productsData = productsFuture.get();
            String reviewsData = reviewsFuture.get();
            String inventoryData = inventoryFuture.get();

            // Merge and process the data
            String mergedData = mergeData(productsData, reviewsData, inventoryData);

            // Print the merged data
            System.out.println("Merged Data: " + mergedData);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.SEVERE, "Exception occurred: " + e.getMessage(), e);
        }
    }

    private static CompletableFuture<String> fetchDataFromAPI(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate fetching data from the API
                if (apiName.equals("Reviews API")) {
                    // Simulate an exception for the "Reviews API"
                    throw new RuntimeException("Exception in Reviews API");
                }
                Thread.sleep(2000);
                return apiName + " data";
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "InterruptedException occurred: " + e.getMessage(), e);
                return "Default Data";
            }
        });
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Simulate merging the data
        return "Merged: " + productsData + ", " + reviewsData + ", " + inventoryData;
    }
}
