package kechen.learn.c03_syncronized;

/**
 * @description 用object当锁，
 * 不同thread用不同锁去访问同一变量，会失效。
 * 当多个线程对同一个共享变量进行访问时，应当使用相同的锁对象，以确保同一时刻只有一个线程能够修改这个共享变量。
 */

public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException{
        Thread[] ts = new Thread[]{
                new AddStudentThread(),
                new DecStudentThread(),
                new AddTeacherThread(),
                new DecTeacherThread()
        };
        for(Thread t:ts){
            t.start();
        }
        for(Thread t : ts){
            t.join();
        }
        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }
}

class Counter{
    public static final Object LOCK_STUDENT = new Object();   // studentCount变量的锁对象
    public static final Object LOCK_TEACHER = new Object();    // teacherCount变量的锁对象
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_STUDENT){
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_STUDENT){
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_TEACHER){
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_TEACHER){
                Counter.teacherCount -= 1;
            }
        }
    }
}

