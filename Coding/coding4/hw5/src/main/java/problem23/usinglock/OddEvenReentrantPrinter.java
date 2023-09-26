package problem23.usinglock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenReentrantPrinter {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int count = 1;
    private final int max = 10;

    public void printOdd() {
        lock.lock();
        try {
            while (count <= max) {
                if (count % 2 == 0) {
                    condition.await();
                } else {
                    System.out.println(count);
                    count++;
                    condition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            while (count <= max) {
                if (count % 2 != 0) {
                    condition.await();
                } else {
                    System.out.println(count);
                    count++;
                    condition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenReentrantPrinter printer = new OddEvenReentrantPrinter();

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}

