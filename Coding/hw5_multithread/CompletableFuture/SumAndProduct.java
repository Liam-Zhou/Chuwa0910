package hw5_multithread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: hyc
 */
public class SumAndProduct {
    private static int a = 3, b = 15;

    public static void main(String[] args) {
        CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> prod = CompletableFuture.supplyAsync(() -> a * b);

        sum.thenAccept((result) -> System.out.println("the sum is: " + result));
        prod.thenAccept((result) -> System.out.println("the product is: " + result));
    }
}
