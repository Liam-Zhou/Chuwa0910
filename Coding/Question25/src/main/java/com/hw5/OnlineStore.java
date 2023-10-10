package com.hw5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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

        System.out.println("Merged Data: " + mergedData);
    }

    private static CompletableFuture<String> fetchDataFromAPI(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the API
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return apiName + " data";
        });
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Simulate merging the data
        return "Merged: " + productsData + ", " + reviewsData + ", " + inventoryData;
    }
}
