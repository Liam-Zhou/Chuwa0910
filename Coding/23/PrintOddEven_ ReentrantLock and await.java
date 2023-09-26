import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEven {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int counter = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (counter <= 10) {
                lock.lock();
                try {
                    while (counter % 2 == 0) {
                        evenCondition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    oddCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Odd");

        Thread t2 = new Thread(() -> {
            while (counter <= 10) {
                lock.lock();
                try {
                    while (counter % 2 == 1) {
                        oddCondition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    evenCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Even");

        t1.start();
        t2.start();
    }
}