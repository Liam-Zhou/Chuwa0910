package kechen.learn.c08_future;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureVsCompletableFuture {
    @Test
    public void testFuture(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        /*
        testFuture() 使用了 Future 的 get() 方法获取异步计算的结果，这是一个阻塞方法，会等待异步任务完成并返回结果后再继续执行下面的代码。
        因此，testFuture() 方法会阻塞在 futureResult.get() 这一行，直到异步任务完成。
         */
        Future<Integer> futureResult = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);  //延迟
            return 10 + 20;
        });

        try{
            System.out.println("Performing other tasks...");

            int result = futureResult.get();
            System.out.println("Result from the future: " + result);

            System.out.println("----");
            for (int i = 0; i < 7; i++) {
                System.out.println("step " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

    @Test
    public void testCompletableFuture(){
        // 使用了 CompletableFuture 的 thenAccept() 方法处理异步计算的结果，这是一个非阻塞方法，不会阻塞主线程继续执行后续代码。
        // 在 testCompletableFuture() 中，thenAccept() 方法处理结果的操作是一个异步回调，会在异步任务完成后执行，但不会阻塞主线程。
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(5);  //延迟
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 10 + 20;
        });

        System.out.println("Performing other tasks...");

        // Handle the result from the CompletableFuture (non-blocking)
        completableFuture.thenAccept(result -> System.out.println("Result from the CompletableFuture: " + result));

        System.out.println("----");
        // Prevent the main thread from exiting immediately
        for (int i = 0; i < 7; i++) {
            System.out.println("step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
