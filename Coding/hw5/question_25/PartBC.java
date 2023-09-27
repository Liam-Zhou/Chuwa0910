package question_25;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class PartBC {
    public static void main(String[] args) {
        CompletableFuture[] futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = CompletableFuture.supplyAsync(API::getRandNum)
                    .thenApplyAsync(API::getSqrt)
                    .thenApplyAsync(API::compare)
                    .thenAccept(result -> System.out.println("result: " + result))
                    .exceptionally(e -> {
                        System.out.println("Negative Sqrt");
                        return null;
                    });
        }
        CompletableFuture.allOf(futures).join();
    }

    static class API {
        public static Random rand = new Random();
        public static double getRandNum() {
            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {e.printStackTrace();}
            return rand.nextInt(-10, 100);
        }

        public static double getSqrt(double num) {
            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {e.printStackTrace();}
            double ret = Math.sqrt(num);
            if (Double.isNaN(ret)) {
                throw new ArithmeticException();
            }
            return ret;
        }

        public static boolean compare(double num) {
            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {e.printStackTrace();}
            return num < 7.0;
        }
    }
}
