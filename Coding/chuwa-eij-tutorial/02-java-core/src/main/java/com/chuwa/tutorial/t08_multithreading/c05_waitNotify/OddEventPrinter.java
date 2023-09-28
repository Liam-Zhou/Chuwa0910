package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author b1go
 * @date 7/18/22 12:41 AM
 */
public class OddEventPrinter {
    private static int value = 1;

    public static void main(String[] args) {
        ReentrantPrintRunnable runnable = new ReentrantPrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (OddEventPrinter.class) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    OddEventPrinter.class.notify();
                    try {
                        if (value < 11) {
                            OddEventPrinter.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ReentrantPrintRunnable implements Runnable {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition cond = lock.newCondition();
        @Override
        public void run() {
            lock.lock();
            while(value <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + value++);
                cond.signalAll();
                try {
                    if (value < 11) {
                        cond.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            lock.unlock();
        }



    }
}
