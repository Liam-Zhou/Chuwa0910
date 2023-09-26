package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

import java.util.Random;

public class Question24 {
    public static void main(String[] args) {
        Thread thread1 = new NumberThread(1, 10);
        Thread thread2 = new NumberThread(11, 20);
        Thread thread3 = new NumberThread(21, 22);

        Thread[] threads = { thread1, thread2, thread3 };

        shuffleArray(threads);

        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have finished.");
    }

    private static void shuffleArray(Thread[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Thread temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}



class NumberThread extends Thread {
    private int start;
    private int end;

    public NumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        Random random = new Random();
        for (int i = start; i <= end; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
