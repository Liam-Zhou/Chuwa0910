package homework.hw5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question23 {
    private static final Object lockA = new Object();
    private static final Lock lockB = new ReentrantLock();
    private static final Condition condition = lockB.newCondition();
    private static int value = 1;

    public static void main(String[] args) {
        solutionB runnable = new solutionB();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class solutionA implements Runnable{
        @Override
        public void run() {
            synchronized (lockA) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    lockA.notify();
                    try {
                        lockA.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    static class solutionB implements Runnable{
        @Override
        public void run() {
            lockB.lock();
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lockB.unlock();
            }
        }
    }
}
