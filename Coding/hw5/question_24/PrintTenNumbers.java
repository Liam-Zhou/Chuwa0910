package question_24;

public class PrintTenNumbers {
    private static int count = 1;
    public static void print() {
        synchronized (PrintTenNumbers.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + count++);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(PrintTenNumbers::print).start();
        new Thread(PrintTenNumbers::print).start();
        new Thread(PrintTenNumbers::print).start();
    }
}
