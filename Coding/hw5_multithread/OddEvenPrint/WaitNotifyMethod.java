package hw5_multithread.OddEvenPrint;

/**
 * @Description: Implemented by synchronized and wait / notify
 * @Author: hyc
 */
public class WaitNotifyMethod {

    private static final Object monitor = new Object();
    private static int value = 1;


    static class WaitNotifyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitNotifyRunnable runnable = new WaitNotifyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
