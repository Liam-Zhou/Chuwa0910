package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.concurrent.CompletableFuture;

public class Homework1 {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 7;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> calculateSum(num1, num2));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> calculateProduct(num1, num2));

        CompletableFuture<Void> combinedFuture = sumFuture.thenAcceptBoth(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });

        combinedFuture.join();
    }

    public static int calculateSum(int a, int b) {
        return a + b;
    }

    public static int calculateProduct(int a, int b) {
        return a * b;
    }
}
