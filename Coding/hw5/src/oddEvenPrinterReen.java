import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class oddEvenPrinterReen implements Runnable {
    private final Lock l = new ReentrantLock();
    private final Condition condition = l.newCondition();
    private volatile int value = 1;

    @Override
    public void run(){
        l.lock();
        try{
            while(value<10){
                System.out.println(Thread.currentThread().getName()+": "+value);
                value++;
                condition.signalAll();
                try{
                    condition.await();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }finally {
            l.unlock();
        }
    }
}
