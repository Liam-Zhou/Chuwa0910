package com.hw5;

import java.util.concurrent.ExecutionException;

public class CompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num1 = 5;
        int num2 = 7;

        java.util.concurrent.CompletableFuture<Integer> sumFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> calculateSum(num1, num2));
        java.util.concurrent.CompletableFuture<Integer> productFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> calculateProduct(num1, num2));

        // Combine both futures
        java.util.concurrent.CompletableFuture<Void> combinedFuture = java.util.concurrent.CompletableFuture.allOf(sumFuture, productFuture);

        // Wait for both futures to complete
        combinedFuture.get();

        // Get the results from the futures
        int sumResult = sumFuture.get();
        int productResult = productFuture.get();

        System.out.println("Sum: " + sumResult);
        System.out.println("Product: " + productResult);
    }

    private static int calculateSum(int a, int b) {
        return a + b;
    }

    private static int calculateProduct(int a, int b) {
        return a * b;
    }
}
