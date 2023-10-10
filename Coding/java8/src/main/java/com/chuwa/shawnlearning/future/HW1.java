package com.chuwa.shawnlearning.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HW1 {
    public static void main(String[] args)  {
        int a = 5;
        int b = 3;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        var fa=  sumFuture.thenAcceptAsync((sum)->System.out.println("Sum: "+sum));
        var fb = productFuture.thenAcceptAsync((product) -> System.out.println("Product: "+product));

        // Wait for both to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(fa, fb);

        allOf.join();
    }
}
