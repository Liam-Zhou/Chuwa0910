package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class Test {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable1 runnable = new PrintRunnable1();
        new Thread(runnable).start(); // no reference need like Thread t1 = new Thread()
        new Thread(runnable).start();
    }

    static class PrintRunnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
