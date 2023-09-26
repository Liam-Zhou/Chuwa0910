package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class NumberPrinter implements Runnable {
    private final int start;
    private final int end;

    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter(1, 10));
        Thread thread2 = new Thread(new NumberPrinter(11, 20));
        Thread thread3 = new Thread(new NumberPrinter(21, 30));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

