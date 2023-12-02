package kechen.learn.c02_basic_thread_handling;

/**
 * @description 守护线程是低优先级的线程，它的作用仅仅是为用户线程（非守护线程）提供服务。
 * 正是由于守护线程是为用户线程提供服务的，仅仅在用户线程处于运行状态时才需要守护线程。
 * 另外，一旦所有的用户线程都运行完毕，那么守护线程是无法阻止JVM退出的。即当程序只剩下守护线程的时候程序就会退出。
 *
 * 守护线程的作用类似在后台静默执行 ，最典型的就是JVM的垃圾回收机制, 这个就是一个守护线程。
 *
 * 在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
 */

public class Daemon {
    public static void main(String[] args) {
        // question: 当其它线程都运行完后，守护线程会结束么？
        // 守护线程是指 tGod 和 tGod2。当主线程 main 运行完毕后，tGod 和 tGod2 作为守护线程将会被中止（即 JVM 退出），
        // 即使它们自己的任务（打印"上帝守护你"）还没有完成。
        // question: 当main 运行完后，守护线程会结束么？
        // 当 main 方法执行完毕时，Java 程序会终止。因为 tGod 和 tGod2 都是守护线程，
        // 当 main 方法结束时，它们会随着主线程的结束而立即停止，而不管它们的任务是否完成。
        Thread tPp1 = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God());

        tGod.setDaemon(true);
        tGod.start();
        tPp1.start();
        tGod2.setDaemon(true);
        tGod2.start();
        System.out.println("Main end");
        // main 方法启动了所有线程后，首先打印了 "Main end"。由于 main 方法的快速执行完毕，它立即结束并且程序终止。
        // tPp1 持续执行 People 类的任务，每 5 秒打印一次 "ppl live"，直到打印完成 5 次后结束。
        // tGod 和 tGod2 作为守护线程，无限循环地打印 "上帝守护你"，但由于 main 方法已经结束，程序退出，它们立即终止。

    }
}

class People implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("ppl live");   // 每隔 5 秒打印一次 "ppl live"，总共打印 5 次，然后线程结束。
        }
        System.out.println("People thread end");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);   // 无限循环，每隔 1 秒打印一次 "上帝守护你"。
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}
