public class Triple_threads {
    private static int count = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public synchronized void run() {
            int i = 1;
            while (i <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            notifyAll();

        }
    }
}
