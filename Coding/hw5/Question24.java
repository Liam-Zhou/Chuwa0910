package homework.hw5;

import java.util.concurrent.Semaphore;

public class Question24 {
    private static int value = 1;
    private static Semaphore lock = new Semaphore(1);

    public static void main(String[] args) {
        solution runnable = new solution();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class solution implements Runnable{
        @Override
        public void run() {
            if (value <= 30) {
                try {
                    lock.acquire();
                    for (int i = 0; i < 10 && value <= 30; i++) {
                        System.out.println(Thread.currentThread().getName() + ": " + value ++);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.release();
                }
            }
        }
    }

}
