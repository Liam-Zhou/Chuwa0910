import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) {
        int a = 5, b = 7;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAccept(sum -> System.out.println("Sum of " + a + " and " + b + " is: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product of " + a + " and " + b + " is: " + product));

        // Waiting for both tasks to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(sumFuture, productFuture);
        allOf.join();
    }
}
