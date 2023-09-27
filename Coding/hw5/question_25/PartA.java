package question_25;

import java.util.concurrent.CompletableFuture;

public class PartA {
    public static void main(String[] args) {
        int a = 3, b = 4;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
            return a+b;
        });
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
            } catch (Exception e) {}
            return a*b;
        });
        sumFuture.thenAccept(num -> System.out.println("Sum is " + num));
        productFuture.thenAccept(num -> System.out.println("Product is " + num));
        System.out.println("Computing in async");
        sumFuture.join();
        productFuture.join();
    }
}
