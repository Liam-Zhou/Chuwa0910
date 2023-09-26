import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncComputation {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(sumFuture, productFuture);

        allOf.thenAcceptAsync(v -> {
            try {
                int sum = sumFuture.get();
                int product = productFuture.get();
                System.out.println("Sum: " + sum);
                System.out.println("Product: " + product);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }
}
