package problem24;

public class PrintNumbers {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(PrintNumbers::printNumber);
        Thread t2 = new Thread(PrintNumbers::printNumber);
        Thread t3 = new Thread(PrintNumbers::printNumber);

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        try {
            while (count-- > 0) {
                System.out.println(Thread.currentThread().getName() + ": " + n++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintNumbers.class.notifyAll();
    }
}