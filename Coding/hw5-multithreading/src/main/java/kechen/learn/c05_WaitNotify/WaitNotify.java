package kechen.learn.c05_WaitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException{
        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for(int i = 0; i< 5; i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    while(true){
                        try{
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);
        for(Thread t: ts){
            t.interrupt();
        }
    }
}

class TaskQueue{
    Queue<String> queue = new LinkedList<>();

    // 对于一个任务管理器，多个线程同时往队列中添加任务，可以用synchronized加锁解决多线程竞争的问题：
    public synchronized void addTask(String s){
        this.queue.add(s);
        this.notifyAll();   // 唤醒在this锁等待的线程
    }

    // 取出队列的第一个任务
    public synchronized String getTask() throws InterruptedException {
        /*
        while (queue.isEmpty()) {
        }
        上述代码看上去没有问题：getTask()内部先判断队列是否为空，
        如果为空，就循环等待，直到另一个线程往队列中放入了一个任务，while()循环退出，就可以返回队列的元素了。

        但实际上while()循环永远不会退出。因为线程在执行while()循环时，已经在getTask()入口获取了this锁，
        其他线程根本无法调用addTask()，因为addTask()执行条件也是获取this锁。
        因此，执行上述代码，线程会在getTask()中因为死循环而100%占用CPU资源。
         */
        /*
        wait()方法的执行机制非常复杂。
        首先，它不是一个普通的Java方法，而是定义在Object类的一个native方法，也就是由JVM的C代码实现的。
        其次，必须在synchronized块中才能调用wait()方法，因为wait()方法调用时，会释放线程获得的锁，
        wait()方法返回后，线程又会重新试图获得锁。
         */
        while (queue.isEmpty()) {
            // 改造getTask()方法，在条件不满足时，线程进入等待状态：
            // wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()
            // 调用wait()方法后，线程进入等待状态，wait()方法不会返回，
            // 直到将来某个时刻，线程从等待状态被其他线程唤醒后，wait()方法才会返回，然后，继续执行下一条语句。
            this.wait();
        }
        return queue.remove();
    }

}
