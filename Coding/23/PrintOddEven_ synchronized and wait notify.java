public class PrintOddEven {
    private static final Object lock = new Object();
    private static int counter = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (counter <= 10) {
                synchronized (lock) {
                    while (counter % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    lock.notify();
                }
            }
        }, "Odd");

        Thread t2 = new Thread(() -> {
            while (counter <= 10) {
                synchronized (lock) {
                    while (counter % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;
                    lock.notify();
                }
            }
        }, "Even");

        t1.start();
        t2.start();
    }
}