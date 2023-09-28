import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven_two {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        condition.signal();

                        if (count <= 10) {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                } finally {
                    lock.unlock();
                }
                if (count > 10) break;
            }
        }
    }
}
