public class oddEvenPrinter implements Runnable {
    //write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
    // (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter
    //a. One solution use synchronized and wait notify
    //b. One solution use ReentrantLock and await, signal
    int counter = 1;
    @Override
    public void run(){
        synchronized (this){
            while(counter<10){
                System.out.println(Thread.currentThread().getName()+": "+counter++);
                this.notify();
                try{
                    if(counter<10){
                        this.wait();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
