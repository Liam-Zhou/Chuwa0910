package kechen.learn.c08_future.batch_payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用 Future 版本:
 *
 * 优势：
 *
 * 性能较好，因为可以利用多线程并行执行查询订单、支付和发送邮件等操作。
 * 使用线程池有效地管理线程资源。
 * 弊端：
 *
 * 代码较复杂，需要处理线程池、Future对象和异常处理。
 * 仍然需要使用阻塞的get()方法等待结果，这可能导致线程阻塞，从而影响程序性能。
 */

public class BatchPaymentFuture {

    /**
     * 并发查询订单：      ｜｜｜
     * 订单并发查询完成    -------
     * 并发支付订单：      ｜｜｜
     * 订单支付完成       -------
     * 并发发送邮件：      ｜｜｜
     * 邮件发送完成       -------
     */

    /**
     * 问题：
     * 在多个订单情况，future版本是先处理完所有order，再处理完所有payment，再处理完sendEmail?
     * 还是三个步骤同时并发处理？
     * 在使用Future版本的多个订单场景中，顺序是：
     *
     * 答案：
     * 先并发处理所有订单的查询（queryOrder）操作。
     * 然后在所有订单查询完成后，开始并发处理所有订单的支付（makePayment）操作。
     * 最后，在所有支付操作完成后，开始并发处理所有订单的发送邮件（sendEmail）操作。
     * 这意味着，在Future版本中，查询、支付和发送邮件操作是分阶段进行的。在每个阶段，操作会并发执行，但下一个阶段的操作需要等待上一个阶段的所有操作完成才能开始。
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Order>> orderFutures = new ArrayList<>();
        for(String orderId : orderIds){
            Future<Order> future = executorService.submit(() -> OrderProcessUtil.queryOrder(orderId));
            orderFutures.add(future);
        }

        List<Future<Boolean>> paymentFutures = new ArrayList<>();
        for (Future<Order> orderFuture : orderFutures) {
            Order order = orderFuture.get();
            Future<Boolean> future = executorService.submit(() -> OrderProcessUtil.makePayment(order));
            paymentFutures.add(future);
        }

        for (int i = 0; i < paymentFutures.size(); i++) {
            boolean paymentResult = paymentFutures.get(i).get();
            OrderProcessUtil.sendEmail(orderFutures.get(i).get(), paymentResult);
        }

        executorService.shutdown();
    }

}
