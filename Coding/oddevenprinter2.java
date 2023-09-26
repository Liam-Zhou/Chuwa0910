package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class oddevenprinter2 {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String args[]){
        Printres tem = new Printres();
        new Thread(tem).start();
        new Thread(tem).start();
    }
    static class Printres implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                while (num < 11) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    lock.notify();
                    try {
                        if (num < 11) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
