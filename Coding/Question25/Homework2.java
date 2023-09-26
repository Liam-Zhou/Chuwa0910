package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.concurrent.CompletableFuture;

public class Homework2 {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/");

        CompletableFuture<Void> mergedDataFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenAcceptAsync((Void) -> {
                    String productsData = productsFuture.join();
                    String reviewsData = reviewsFuture.join();
                    String inventoryData = inventoryFuture.join();

                    String mergedData = mergeData(productsData, reviewsData, inventoryData);
                    System.out.println("Merged Data: " + mergedData);

                });

        mergedDataFuture.join();
    }

    public static CompletableFuture<String> fetchDataFromApi(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return apiName + " Data";
        });
    }

    public static String mergeData(String productsData, String reviewsData, String inventoryData) {
        return "Merged Data: " + productsData + " | " + reviewsData + " | " + inventoryData;
    }
}
