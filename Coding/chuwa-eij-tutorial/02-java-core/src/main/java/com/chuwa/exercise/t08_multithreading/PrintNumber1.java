package com.chuwa.exercise.t08_multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author b1go
 * @date 7/29/22 3:16 PM
 */
public class PrintNumber1 {
    private static int n = 1;

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintNumber1.class.notifyAll();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();

            for(int i=0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + ": " + n++);
            }

            lock.unlock();
        }
    }
}
