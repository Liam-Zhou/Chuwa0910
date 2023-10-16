

1.  Explain volatile variables in java? (we also use it in Singleton)
    The volatile keyword is used to indicate that a variable may be changed unexpectedly by multiple threads. 

2.  how to create a new thread(Please also consider Thread Pool case)?
    -Basic method: 
        
        -Extends Thread class:

        public class MyThread extends Thread{
            @Override
            public void run(){
                System.out.println("start new thread");
            }
            public static void main(String []args){
                Thread t = new MyThread();
                t.start();
            }

        }

        -By implemant runnable:
        
        public class MyRunnable implements Runnable{
            public void run(){
                System.out.println("Start new thread using Runnable");
            }
            public static void main(String []args){
               Thread t1 = new Thread(new MyRunnable());
               t1.start();

            }
        }

    -Using Thread pool:

        -Fixed Thread pool:

        public void FixThreadPool(){
            ExecutorService exe = Executors.newFixedThreadPool(3);
            for(int i=0;i<10;i++){
                int task_id = i+1;
                exe.submit(()->System.out.print("task" + task_id + "run on" + Thread.currentThread().getName()));
            }

        }

        -Cached Thread Pool:

        ExecutorService executorService = Executors.newCachedThreadPool();

        -Single Thread Executor:
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        
        -scheduled Thread Pool
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);




3.  Difference between Runnable and Callable
    Runnable has no return, Callable has return 

4.  what is the diff between t.start() and t.run()?
    t.start() start new thread to execute the task.
    t.run() execute task in current thread.

5.  Which way of creating threads is better: Thread class or Runnable interface?
    Runnable, Runnable could pase by different executor service ot thread. Java does not support multiple inheritance. If you extend the Thread class, you cannot extend another class. However, if you implement the Runnable interface, your class can still extend another class. This is especially useful if you need to inherit behavior from another class. 

6.  what is the thread status?
    -NEW: Created a new thread object but start() method hasn't been called.
    -RUNNABLE: A thread in the runnable state is either executing in the Java virtual machine (JVM) or it's ready to run, waiting for CPU time. The thread scheduler will determine when it actually   runs.
    -BLOCKED: A thread blocked by another thread that currently holds the lock.
    -WAITING: A thread is waiting for another thread take action.
    -TIMED-WAITING: A thread is in this state due to calling methods like Thread.sleep(long millis), Object.wait(long timeout), or other timed methods.
    -TERMINATED: A thread is in this state when it has completed its execution or was explicitly terminated.


7.  difference between wait() and sleep() method
    wait() is method of Object class, sleep() method is part of Thread. 


8.  What is deadlock?
    Two or more threads blocked forever, each waiting for other release lock.

9.  how do threads communicate with each other?
    syncronized: wait & notify & notifyAll.
    ReentrantLock:  condition.await() & condition.signal() & condition.signalAll()


10. what is join() method?
    join() method is member of Thread class, its allow one thread wait for other threads completes its execution.


11. what is yield() method
    Give a hint to thread scheduler that current thread willing yiled its current use of processor.

12. Explain thread pool
    A thread pool is a collection of pre-initialized threads that stand ready to execute tasks. Using a thread pool can improve performance, especially when executing a large number of short-lived tasks, by reusing existing threads and minimizing the overhead of thread creation and destruction.


13. What is Executor Framework in Java, its different types and how to create these executors?
    Single thread executor:
        ExecutorService exe = Executor.newSingleThreadExecutor();
    
    Fixed thread executor:
        ExecutorService exe = Executor.newFixedThreadPool(n);
    
    Cached thread pool:
        ExecutorService exe = Executor.newCachedThreadPool();
    
    Scheduled thread pool:
        ExecutorService exe = Executor.newScheduledThreadPool(3); 




14. Difference between shutdown() and shutdownNow() methods of executor
    shutdown() stops the executor from accepting new tasks, but it allows queued tasks to complete.
    shutdownNow() attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed. Use it 


15. What is Atomic classes? when do we use it?
    atomic operations on single variables without the use of synchronization mechanisms like synchronized blocks. These classes use efficient machine-level instructions to ensure atomicity, which can offer better performance than traditional synchronization in some scenarios. Using it when we have simple atomic operations like incrementing a counter, using atomic classes can be more efficient than locking mechanisms.



16. What is the cocurrent collections?
    thread-safe collection
    Map<String, String> map = new ConcurrentHashMap<>();

17. what kind of locks you know? 
    -Monitor lock: When a thread acquires a monitor lock for an object, no other threads can enter "synchronized" method or block that object
    -ReadWrite lock: Sperate locks as read lock an write lock.
    -Reentrant lock: A reentrant mutual exclusion lock with the same basic behavior and semantics as the intrinsic locks, but with extended capabilities like timed lock waits, lock polling, and interruptible lock waits.
    -Stampted lock: it provides a capability similar to ReadWriteLock but offers a mode called optimistic reading, which can potentially reduce contention further.
    -Dead Lock: Not a type of lock, Two or more threads blocked forever, each waiting for other release lock.

18. What is the difference between class lock and object lock?
    Operate on different scopes and used in different scenarios. 
    Object Lock: 
        Locks on an instance of the class. 
        Different instances have different locks.
        Used for synchronizing instance methods or blocks that synchronize on instance references.

    Class Lock:
        Locks on the class itself.
        There's only one lock for the entire class, regardless of the number of instances.
        Used for synchronizing static methods or blocks that synchronize on the class reference 

19. What is future and completableFuture?
    Future and CompletableFuture are both interfaces in Java that represent the result of an asynchronous computation. They help manage and handle results that will become available in the future.
    Future: 
        A basic representation of the result of an asynchronous computation, but with limited capabilities in terms of handling the result without blocking or chaining multiple operations.
    CompletableFuture: 
        An advanced and flexible tool for asynchronous programming in Java. It allows for non-blocking operations, chaining, combining, and handling asynchronous tasks in a more expressive manner.
    

20. what is ThreadLocal?
    Thread Isolation: Each thread accessing a ThreadLocal sees only its own value. Changes made in one thread will not affect other threads.

    No Synchronization: Since the data is local to the specific thread, you don't need to use synchronization mechanisms to access or modify it.

    Garbage Collection: The thread-local values are subject to garbage collection once the thread is no longer alive and there are no other references to the thread-local value.   

21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
    In coding folder

22. Read those interview questions and pick some important questions to this home work.
    Question: can we use lambda for runnable?
    use the @FunctionalInterface
    only one method: public abstract void run();
    so we can use lambda function

    Basic Thread Handling
    `t.join()`
        The thread A which call t.join() will suspend its execution and t thread would start to execute. A will continue after t is executed successfully.
    `t.setDaemon(true)`
        A daemon thread runs in the background but as soon as the main application thread exits, all daemon threads are killed by the JVM. Note that in case a spawned thread isn’t marked as a daemon then even if the main thread finishes execution, JVM will wait for the spawned thread to finish before tearing down the process.
    `Thread.sleep(1000)`
        the thread which call Thread.sleep(1000) would sleep
    `t.interrupt()`
        can interrupt sleep()
        can not interrupt while(true)
        can interrupt !isInterrupted()

23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
    a. One solution use synchronized and wait notify 
    b. One solution use ReentrantLock and await, signal

    Thread-0: 1
    Thread-1: 2
    Thread-0: 3
    Thread-1: 4
    Thread-0: 5
    Thread-1: 6
    Thread-0: 7
    Thread-1: 8
    Thread-0: 9
    Thread-1: 10
    Process finished with exit code 0

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading PrintNumber1)


    Thread-0: 1
    Thread-0: 2
    Thread-0: 3
    Thread-0: 4 
    Thread-0: 5
    Thread-0: 6
    Thread-0: 7
    Thread-0: 8
    Thread-0: 9
    Thread-0: 10
    Thread-2: 11
    Thread-2: 12
    Thread-2: 13
    Thread-2: 14
    Thread-2: 15
    Thread-2: 16
    Thread-2: 17
    Thread-2: 18
    Thread-2: 19
    Thread-2: 20
    Thread-1: 21
    Thread-1: 22
    Thread-1: 23
    Thread-1: 24
    Thread-1: 25
    Thread-1: 26
    Thread-1: 27
    Thread-1: 28
    Thread-1: 29
    Thread-1: 30


25. completable future:
    a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
    b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
        i.  Sign In to Developer.BestBuy.com
        ii. Best Buy Developer API Documentation (bestbuyapis.github.io)
        iii.  可以用fake api https://jsonplaceholder.typicode.com/
    c.  Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.
 
