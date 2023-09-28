package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import com.chuwa.exercise.t08_multithreading.PrintNumber1;

public class ThreeThreadPrinter {


    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreeThreadPrinter.class.notifyAll();
    }


}
