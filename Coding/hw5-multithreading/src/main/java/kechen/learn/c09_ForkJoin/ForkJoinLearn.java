package kechen.learn.c09_ForkJoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinLearn {
    @Test
    public void demo01(){
        ForkJoinTask forkJoinTask = new ForkJoinTask(1, 10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(forkJoinTask);

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
    /**
    - 类似于MapReduce. parallel operating system 也是用的这个原理，利用GPU的计算也是这个原理
    - Fork/Join是一种基于“分治”的算法：通过分解任务，并行执行，最后合并结果得到最终结果
    - Fork/Join任务的原理：判断一个任务是否足够小，如果是，直接计算，否则，就分拆成几个小任务分别计算。这个过程可以反复“裂变”成一系列小任务。
    - ForkJoinPool线程池可以把一个大任务分拆成小任务并行执行，任务类必须继承自RecursiveTask或RecursiveAction。
    - 使用Fork/Join模式可以进行并行计算以提高效率。
    - 使用ForkJoin: https://www.liaoxuefeng.com/wiki/1252599548343744/1306581226487842
    */

class ForkJoinTask extends RecursiveTask<Integer> {
    private final int threhold = 5;
    private int first;
    private int last;

    public ForkJoinTask(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threhold) {
            // small task calculate the result directly
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            // divide the big task into small ones
            int middle = first + (last - first) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(first, middle);
            ForkJoinTask rightTask = new ForkJoinTask(middle + 1, last);

            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }
}