import java.util.concurrent.locks.*;

public class OddEvenReentrantLock{
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int count = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try{
                while (count <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    condition.signal();
                    if (count < 11) condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {lock.unlock();}
        }
    }
}
