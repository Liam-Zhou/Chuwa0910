package PrintNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPrinter {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean oddTurn = true;

    public void printOdd(int number) {
        lock.lock();
        try {
            while (!oddTurn) {
                condition.await();
            }
            System.out.println("Odd Thread: " + number);
            oddTurn = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven(int number) {
        lock.lock();
        try {
            while (oddTurn) {
                condition.await();
            }
            System.out.println("Even Thread: " + number);
            oddTurn = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockPrinter printer = new ReentrantLockPrinter();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                printer.printOdd(i);
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                printer.printEven(i);
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
