package question_23;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    public static void main(String[] args) {
        System.out.println("--------------Solution A");
        PrinterA printer_a = new PrinterA(10);
        Thread t1 = new Thread(printer_a::PrintOdd);
        Thread t2 = new Thread(printer_a::PrintEven);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------Solution B");
        PrinterB printer_b = new PrinterB(10);
        new Thread(printer_b::PrintOdd).start();
        new Thread(printer_b::PrintEven).start();
    }
}

class PrinterA {
    private int count = 1;
    private final int n;
    public PrinterA(int n) {
        this.n = n;
    }
    public synchronized void PrintOdd() {
        for (int i = 0; i < (n + 1) / 2; i++) {
            while (count % 2 == 0) {
                try {
                    this.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count++;
            this.notify();
        }
    }
    public synchronized void PrintEven() {
        for (int i = 0; i < n/2; i++) {
            while (count % 2 == 1) {
                try {
                    this.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count++;
            this.notify();
        }
    }
}

class PrinterB {
    private int count = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final int n;
    public PrinterB(int n) {
        this.n = n;
    }
    public void PrintOdd() {
        for (int i = 0; i < (n + 1) / 2; i++) {
            lock.lock();
            try {
                while (count % 2 == 0) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public void PrintEven() {
        for (int i = 0; i < n / 2; i++) {
            lock.lock();
            try {
                while (count % 2 == 1) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}