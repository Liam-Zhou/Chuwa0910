package kechen.learn.c01_create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // use extends Thread
        Thread t = new MyThread();
        t.start();
        System.out.println("***********");

        // use implements Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // use lambda
        Thread t3 = new Thread(() -> System.out.println("Start new thread by implementing Runnable with lambda"));
        t3.start();

        // use implements Callable
        Callable<String> callable = new MyCallable();
        ExecutorService es = Executors.newFixedThreadPool(10);  // 创建固定的线程池
        List<Future<String>> list =  new ArrayList<Future<String>>();  // 把返回结果加入到list中，因为当我们提交一个Callable任务后，我们会同时获得一个Future对象
        Future<String> future = es.submit(callable);
        list.add(future);
        Future<String> stringFuture = list.get(0);

        for(int i = 0; i < 5; i++){
            Thread.sleep(1000);
            String s = future.get();
            System.out.println(s);
        }

        es.shutdown();
    }
}
