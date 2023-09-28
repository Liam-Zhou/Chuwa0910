public class OddEven {

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
        public synchronized void run() {

                while (count <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    notifyAll();
                    try {
                        if (count < 11) {
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}