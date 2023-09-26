package Problem21.Creat;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("t3 lambda overrides Run()"));
        t3.start();
//        My Thread cannot get callable;
//        Thread t3 = new Thread(new MyCallable());
//        t3.start();

        Callable<String> myCallable = new MyCallable();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> res = executor.submit(myCallable);
        try {
            res.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }

    }
}
