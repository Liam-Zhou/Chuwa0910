package Problem23;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWayB {

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        AtomicInteger n = new AtomicInteger(1);
        Thread t1 = new Thread(() -> {
            while(n.get() <10){
                lock.lock();
                System.out.printf("t1: %d\n",n.get());
                n.getAndIncrement();
                lock.unlock();
            }

        });

        Thread t2 = new Thread(() -> {
            while(n.get() < 10) {
                lock.lock();
                System.out.printf("t2: %d\n",n.get());
                n.getAndIncrement();
                lock.unlock();
            }

        });

        t1.start();t2.start();
        t1.join();t2.join();
    }
}
