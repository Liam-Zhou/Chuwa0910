package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class OddEvenPrinterA {
    private static final Object lock = new Object();
    private static volatile int currentNumber = 1;

    public static void main(String[] args){
        Thread oddThread = new Thread(() -> printOdd(10));
        Thread evenThread = new Thread(() -> printEven(10));

        oddThread.start();
        evenThread.start();
    }
    private static void printOdd(int max){
        synchronized (lock){
            while (currentNumber <= max){
                if (currentNumber %2 == 1){
                    System.out.println(Thread.currentThread().getName() + ":" + currentNumber);
                    currentNumber++;
                    lock.notify();
                }
                else{
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private static void printEven(int max){
        synchronized (lock){
            while (currentNumber <= max){
                if (currentNumber %2 == 0){
                    System.out.println(Thread.currentThread().getName() + ":" + currentNumber);
                    currentNumber++;
                    lock.notify();
                }
                else{
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
