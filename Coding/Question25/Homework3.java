package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Homework3 {

    private static final Logger logger = Logger.getLogger(Homework3.class.getName());


    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");

        CompletableFuture<Void> mergedDataFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenAcceptAsync((Void) -> {
                    try {
                        String productsData = productsFuture.get();
                        String reviewsData = reviewsFuture.get();
                        String inventoryData = inventoryFuture.get();

                        String mergedData = mergeData(productsData, reviewsData, inventoryData);
                        System.out.println("Merged Data: " + mergedData);

                        // Perform further processing here
                    } catch (InterruptedException | ExecutionException e) {
                        logger.log(Level.SEVERE, "Exception occurred during API calls: " + e.getMessage());
                        e.printStackTrace();
                    }
                });

        mergedDataFuture.join();
    }

    public static CompletableFuture<String> fetchDataFromApi(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (Math.random() < 0.5) {
                    throw new RuntimeException("API request failed");
                }
                Thread.sleep(1000);
                return apiName + " Data";
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "RuntimeException occurred" + e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }

    public static String mergeData(String productsData, String reviewsData, String inventoryData) {
        return "Merged Data: " + productsData + " | " + reviewsData + " | " + inventoryData;
    }
}
