package com.chuwa.exercise.t08_multithreading;

public class Test {

    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNum()); // new Thread() inside represents the code block or runnable task that the thread will execute.
        Thread t2 = new Thread(() -> printNum());
        Thread t3 = new Thread(() -> printNum());

        t1.start();
        t2.start();
        t3.start();
    }

    public static synchronized void printNum() { // synchronized ensure only one thread can execute it at a time, preventing race conditions
        int count = 10;
        while(count-- > 0) {
            System.out.println(Thread.currentThread().getName() + " " + n++);
            try {
                Thread.sleep(1000); // a delay between each number print, still hold lock
            } catch(InterruptedException e) { //checked exception occurs if another thread interrupts the sleeping thread by invoking its interrupt method.
                e.printStackTrace();
            }
        }
        Test.class.notifyAll();
    }
}
