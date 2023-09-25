package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class oddevenprinter3 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int number = 1;
    private final int max;
    public oddevenprinter3(int max) {
        this.max = max;
    }
    public void printOdd() {
        try {
            lock.lock();
            while (number <= max) {
                while ((number % 2) == 0) {  // wait if the number is even
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;  // increment the number
                condition.signal();  // signal other thread
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    public void printEven() {
        try {
            lock.lock();
            while (number <= max) {
                while ((number % 2) != 0) {  // wait if the number is odd
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;  // increment the number
                condition.signal();  // signal other thread
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        oddevenprinter3 numberPrinter = new oddevenprinter3(10);
        Thread oddThread = new Thread(numberPrinter::printOdd);
        Thread evenThread = new Thread(numberPrinter::printEven);
        oddThread.start();
        evenThread.start();
    }
}
