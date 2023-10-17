package hw5_multithread.OddEvenPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Implemented by ReentrantLock
 * @Author: hyc
 */
public class ReentrantLockMethod {

    private static int value = 0;

    static class ReentrantLockRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        @Override
        public void run() {
            lock.lock();    // 课件里面漏了
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signalAll();
                    try {
                        condition.await(); // 解锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockRunnable runnable = new ReentrantLockRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
