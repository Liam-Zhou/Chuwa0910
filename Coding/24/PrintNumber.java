
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    private static final Condition condition3 = lock.newCondition();
    private static int counter = 1;
    private static int currentThread = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (counter <= 30) {
                lock.lock();
                try {
                    while (currentThread != 1) {
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    currentThread = 2;
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            while (counter <= 30) {
                lock.lock();
                try {
                    while (currentThread != 2) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    currentThread = 3;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread 2");

        Thread t3 = new Thread(() -> {
            while (counter <= 30) {
                lock.lock();
                try {
                    while (currentThread != 3) {
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    currentThread = 1;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

