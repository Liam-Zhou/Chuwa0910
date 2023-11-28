package kechen.learn.c03_syncronized;
/**
 * @description 用object当锁，
 * 不同thread用不同锁去访问同一变量，会失效。
 */

public class SynchronizedThreadsFailed {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[]{
                new AddThread(),
                new DecThread(),
                new AddThread2(),
                new DecThread2()
        };
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        // 永远在变， 因为加减锁的对象不一样
        System.out.println("永远在变， 因为用的不同的锁。       => " + Counter1.studentCount);
        // 永远为0，用的同一把锁。
        System.out.println("永远为0，因为用的同一把锁。         => " + Counter1.teacherCount);
    }
}

/**
 * Locker
 */
class Counter1 {
    public static final Object LOCK_STUDENT = new Object();    // studentCount变量的锁对象 (失效)
    public static final Object LOCK_TEACHER = new Object();    // studentCount变量的锁对象（失效）
    public static final Object LOCK_COMMON = new Object();    // teacherCount变量的锁对象
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.LOCK_STUDENT) {    // 此时两把不同的锁对象控制tudentCount变量，所以会失效
                Counter1.studentCount += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.LOCK_TEACHER) {
                Counter1.studentCount -= 1;
            }
        }
    }
}

class AddThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.LOCK_COMMON) {
                Counter1.teacherCount += 1;
            }
        }
    }
}

class DecThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.LOCK_COMMON) {
                Counter1.teacherCount -= 1;
            }
        }
    }
}
