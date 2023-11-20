package kechen.exercise.Q25;

import java.util.concurrent.CompletableFuture;

public class Qa {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> a * b);

        cf1.thenAccept(sum -> System.out.println("Sum of " + a + " and " + b + " is: " + sum));
        cf2.thenAccept(product -> System.out.println("Product of " + a + " and " + b + " is: " + product));

        // Ensure main thread waits for completion of both futures to print the results
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(cf1, cf2);
        combinedFuture.join();
    }
}
