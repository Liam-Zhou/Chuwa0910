import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printNumber30 implements Runnable {
    // create 3 threads
    // one thread ouput 1-10, one thread output 11-20, one thread output 21-22.
    // threads run sequence is random.
    // (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
    private volatile int value = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void run(){
        lock.lock();
        try{
            int count = 10;
            while(count-- > 0 && value<=22){
                System.out.println(Thread.currentThread().getName()+": "+value++);
            }
            condition.signalAll();
            try{
                condition.await();
            }catch(Exception e){
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }




}