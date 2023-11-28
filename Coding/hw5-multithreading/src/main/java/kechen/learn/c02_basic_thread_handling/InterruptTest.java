package kechen.learn.c02_basic_thread_handling;

import org.junit.Test;

/**
 * @description 中断线程就是其他线程给该线程发一个信号，该线程收到信号后结束执行run()方法，使得自身线程能立刻结束运行。
 */
public class InterruptTest {
    /**
     * @description 仔细看上述代码，main线程通过调用t.interrupt()方法中断t线程，但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”，
     * 至于t线程是否能立刻响应，要看具体代码。而t线程的while循环会检测isInterrupted()，所以上述代码能正确响应interrupt()请求，
     * 使得自身立刻结束运行run()方法。
     */
    @Test
    public void testIsInterreputed() throws InterruptedException{
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);
    }
    private void execute(Thread t) throws InterruptedException{
        t.start();
        Thread.sleep(2000);
        // 暂停2毫秒. Question, who sleep?
        // the main thread (the thread executing the execute method) sleeps for 2 milliseconds.
        // Thread.sleep(2000) 是 execute 方法所在的主线程调用的，所以主线程sleep

        t.interrupt();
        // 中断t线程. Question, who is interrupted? 一定会被成功中断么？
        // the t.interrupt() call sends an interrupt signal to the t thread (instance of MyThreadWithIsInterrupted).
        // t线程被打断

        // Whether the thread t is successfully interrupted or not：
        // depends on the state of the thread and the specific logic within its run method.

        // 对于testIsInterreputed():t线程被interrupt. run method里面是检测!isInterrupted()，不会立刻停止，在interrupt()之前完成正在运行的迭代
        // 对于testInterruptWhileTrue()：run method里面是判断true，一直都是true，所以interrupt()没有成功，进入死循环
        // 对于testInterruptSleep(): t线程正在睡眠，可以成功地响应 interrupt() 调用，，从而退出睡眠状态并抛出InterruptedException异常。
        System.out.println("start join");
        t.join();
        // 等待t线程结束. Question, who is running, and who stopped?
        // After calling t.join(), the main thread (the one running execute method) waits for the t thread to finish.

        //对于testIsInterreputed()：t加入，main is running执行sout：end， t stopped.
        // 对于testInterruptWhileTrue()：t线程在无限循环，main线程永远等待
        // 对于testInterruptSleep(): 由于t线程已经被成功中断并退出，所以主线程不会等待超时，而是继续执行后续代码， main is running执行sout：end， t stopped.

        System.out.println("end");
    }

    @Test
    public void testInterruptWhileTrue() throws InterruptedException{
        Thread t = new WhileTrue();
        execute(t);
    }

    @Test
    public void testInterruptSleep() throws InterruptedException{
        Thread t = new SleepForver();
        execute(t);
    }

}

class SleepForver extends Thread{
    @Override
    public void run() {
        int n = 0;
        try{
            // 由于 t 线程正在睡眠，它会抛出 InterruptedException 并清除中断状态，
            // 从而退出睡眠状态并抛出异常。
            Thread.sleep(5000 * 1000);
        }catch (InterruptedException e){
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}

class WhileTrue extends Thread{
    @Override
    public void run() {
        int n = 0;
        while(true){
            n++;
            System.out.println(n + " hello!");
        }
    }
}
class MyThreadWithIsInterrupted extends Thread{
    @Override
    public void run() {
        int n = 0;
        while(!isInterrupted()){
            n++;
            System.out.println(n + " hello!");   // 如果没有interrupt()将会一直n++
        }
    }
}


