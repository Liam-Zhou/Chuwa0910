package com.chuwa.learn.completableFuture;

import java.util.concurrent.*;

public class Hw1{
    static int num1 = 10;
    static int num2 = 5;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return num1 + num2;
        });
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return num1 * num2;
        });
        System.out.println(sumFuture.get() +" "+ productFuture.get());
    }
}