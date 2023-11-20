package kechen.exercise.Q23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter_b {
    private static final Lock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int value = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> printOdd());
        Thread evenThread = new Thread(() -> printEven());

        oddThread.start();
        evenThread.start();
    }

    public static void printOdd() {
        try {
            lock.lock();
            while (value <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + value++);
                evenCondition.signal();
                if (value <= 10) {
                    oddCondition.await(); // Wait for the even thread to print
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void printEven() {
        try {
            lock.lock();
            while (value <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + value++);
                oddCondition.signal();
                if (value <= 10) {
                    evenCondition.await(); // Wait for the odd thread to print
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
