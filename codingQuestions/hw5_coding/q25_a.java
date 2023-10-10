import java.util.concurrent.CompletableFuture;

// Async get the sum and product of two integers
public class CompletableFutureExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        // Combine the results of both futures
        CompletableFuture<Void> combinedFuture = sumFuture.thenCombine(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            return null; // CompletableFuture<Void> requires a return value of null
        });

        // Wait for the combinedFuture to complete
        combinedFuture.join();
    }
}
