package kechen.learn.c05_WaitNotify;

public class OddEventPrinter {
    private static final Object monitor = new Object();
    private  static int value = 1;

    public static void main(String[] args) {
        PrintRunnale runnale = new PrintRunnale();
        new Thread(runnale).start();
        new Thread(runnale).start();
    }

    static class PrintRunnale implements Runnable{

        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();  //释放锁
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
