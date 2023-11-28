package kechen.learn.c08_future;

import com.sun.security.jgss.GSSUtil;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class CompletableFutureApiLearn {

    /**
     * Using CompletableFuture as a Simple Future.
     */
    @Test
    public void demo1(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() ->{
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            /*
            方法用于手动完成（resolve） CompletableFuture 的计算，并将其结果设置为指定的值。
            在这个例子中，complete("Hello") 将 CompletableFuture 的结果设置为字符串 "Hello"。
             */
            completableFuture.complete("Hello");
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo02(){
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + ": Hello1");
            return "Hello1";
        });

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() ->
            System.out.println(Thread.currentThread() + ": Hello2"));

        try {
            /*
            因为在等待 1 秒的间隔内，cf2 任务尚未完成。这是因为异步任务的执行需要时间
            异步任务执行后，打印了 "Hello1" 和 "Hello2"。cf2.isDone() 返回 true，因为在主线程等待的 1 秒之后，cf2 已经完成。
             */
            System.out.println(cf2.isDone());
            Thread.sleep(1000);
            System.out.println(cf2.isDone());

            System.out.println(cf1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    output：
    false
    Thread[ForkJoinPool.commonPool-worker-1,5,main]: Hello1
    Thread[ForkJoinPool.commonPool-worker-2,5,main]: Hello2
    true
    Hello1
     */


    @Test
    public void demo3(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        /*
        当当前 CompletableFuture 执行完成后，将会执行指定的函数，并返回一个新的 CompletableFuture 对象，该对象包含函数执行后的结果。
        在这个例子中，completableFuture 是一个 CompletableFuture 对象，thenApply(s -> s + "World")
        表示对 completableFuture 中的结果应用一个函数，将结果与字符串 "World" 连接起来，并返回一个新的 CompletableFuture 对象 future。
         */
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + "World");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo4(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        /*
        它表示在当前 CompletableFuture 执行完成后，对其结果应用一个消费者函数，并在消费者函数中对结果进行处理，
        但不会返回一个新的 CompletableFuture 对象

        completableFuture 是一个 CompletableFuture 对象，thenAccept(s -> System.out.println("Computation returned: " + s))
        表示对 completableFuture 的结果应用一个消费者函数。这个消费者函数接受结果 s 并打印出 "Computation returned: " 以及 s 的值。
         */
        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo5(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo6(){
        /*
        将两个 CompletableFuture 对象进行连接（compose），并在一个 CompletableFuture 完成后，使用其结果去触发另一个 CompletableFuture 的执行。
         */
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        CompletableFuture<CompletableFuture<String>> future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        try {
            System.out.println(future1.get());

            System.out.println(future2.get());
            System.out.println(future2.get().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo7(){
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
                    System.out.println("1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("2");
                    return "Hello";
                })
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    System.out.println("3");
                    return " World";
                }), (s1, s2) -> s1 + s2);

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo8(){
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }

    @Test
    public void demo9(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            combinedFuture.get();

            assertTrue(future1.isDone());
            assertTrue(future2.isDone());
            assertTrue(future3.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo10(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            String combined = Stream.of(future1, future2, future3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));

            System.out.println(combined);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo11(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return 1;
        }).handle((f, e) -> {
            int i = 10 / 0;
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            System.out.println("complete");
            if (e == null) {
                System.out.println("calculate result： " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        try {
            completableFuture.get();
            //System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}