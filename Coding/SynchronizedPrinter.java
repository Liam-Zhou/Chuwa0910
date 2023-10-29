package PrintNumber;


public class SynchronizedPrinter {

    private final Object lock = new Object();
    private boolean oddTurn = true;

    public void printOdd(int number) {
        synchronized (lock) {
            while (!oddTurn) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Odd Thread: " + number);
            oddTurn = false;
            lock.notifyAll();
        }
    }

    public void printEven(int number) {
        synchronized (lock) {
            while (oddTurn) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even Thread: " + number);
            oddTurn = true;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        SynchronizedPrinter printer = new SynchronizedPrinter();

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
