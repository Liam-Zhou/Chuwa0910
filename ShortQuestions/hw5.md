***************************************
Q1. The `volatile`  in Java is used to indicate a variable's value may be modified by multiple threads simultaneously. 
It ensures that the variable is always read from and written to the main memory, rather than from thread-specific caches, 
ensuring visibility across threads. 
> Notifying all threads that a volatile variable's value has changed. 
***************************************
Q2. 
1. By extends `Thread Class` to our class and overrider `run()` method. We can create our own thread and assign
jobs in `run() method body`.
    public class myThread extends Thread{
        @Override 
        public void run(){
            //write thread job
        }
    }
    
    //implementation of our thread. And must run start() function to execute the task.
    Thread t = new myThread();
    t.start(); 

2. By implement `Runnable interface`: Override run(). Write job in run() method body.  
    public class myThread() implements Runnable(){
        @Override
        public void run(){
            //write thread job
        }
    }
    Thread t = new Thread(new myThread());
    t.start(); 

3. By implement `Callable interface<T>`: Override call() and throws exception. Write thread body in call().
    public class myCallable implements Callable<T> {
        @Override
        public T call() **throws Exception** {
            //write body
            return **T type**;
        }
    }
4. Using Thread Pool
***************************************
Q3. A callable interface throws the checked exception and returns the result. 
A runnable interface, on the other hand, does not return a result and cannot throw a checked exception.
***************************************
Q4. `t.start()`: starts a new thread to execute the task in run() method body. 
`t.run()`: executes the task in the current thread.
***************************************
Q5. Runnable interface is better. It enhances code reusability. And it has more flexibility. 
By implementing runnable, you can still choose to use a Thread class to create and manage the actual threads. 
This gives you more flexibility and control over thread management.
***************************************
Q6. Thread status:
NEW
A thread that has `not yet started` is in this state.
RUNNABLE
A thread `executing in the Java virtual machine` is in this state.
BLOCKED
A thread that is `blocked waiting` for a monitor lock is in this state.
WAITING
A thread that is `waiting indefinitely` for another thread to `perform a particular action` is in this state.
TIMED_WAITING
A thread that is waiting for another thread to perform an action for up to a `specified waiting time` is in this state.
TERMINATED
A thread that has `exited` is in this state.
***************************************
Q7. Wait(): Thread status changing from RUNNABLE to WAITING.
Sleep(long t): Thread status changing from RUNNABLE to TIMED_WAITING.
***************************************
Q8. A deadlock is when more than one threads are holding resources and waiting for another resource. However, the resource they wait 
has locked by each other. They will infinitely wait each other. 
***************************************
Q9. 
`synchronized( Object : this/ User/ Person/ Car .. )`: this is a lock, so when thread wants to come in, they check the lock existence. 

`notify()` and `notifyAll()`: If a thread unlocks a resource, it can notify a random available thread to wake up from WAITING status, or all of available threads. 

`wait()`: A thread goes into WAITING status. 

`TaskQueue`: this is the way they share info. 

***************************************
Q10. `t.join()`: means current thread wait for t thread end. Current thread's status is TIMED_WAITING.
***************************************
Q11. `yield()`: it can stop the currently executing thread and will give a chance to other waiting threads of the same priority.
***************************************
Q12. A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle 
overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.

> ![](https://media.geeksforgeeks.org/wp-content/uploads/tpinit.jpg)
***************************************
Q13. 
***************************************
Q14. `shutdown()` method will allow previously submitted tasks to execute before terminating (finished all job then shutdown) 
while the `shutdownNow()` method prevents waiting tasks from starting and attempts to stop currently executing tasks. (shutdown anyway)
***************************************
Q15. The atomic classes provide
a lock-free and thread-safe environment
or programming on a single variable.
It also supports atomic operations.

    private static AtomicInteger ati = new AtomicInteger(1); // init value
***************************************
Q16. For List interface, we have CopyOnWriteArrayList. In map interface, we have concurrentHashMap. For Set, we have CopyOnWriteArraySet.
Queue, ArrayBlockingQueue, Dequeue, LinkedBlockingDeque.
***************************************
Q17. Synchronized: Class level lock & Object level lock.

ReentrantLock, ReadWriteLock, StampedLock.
***************************************
Q18. 
Object Level Locks: When we want `non-static` method or non-static block of the code should be accessed by only one thread. (non-static)

Class Level locks: When we want to prevent multiple threads to enter the synchronized block in any of all available instances `on runtime`. (static)
***************************************
Q19. 
Future: A Future represents the result of an asynchronous computation.
CompletableFuture: It extends the basic functionality of Future to let us have a lot more control over the results of our asynchronous operations.
It also represents a future result of an asynchronous computation. It can be thought of as a container that holds the result of an asynchronous operation that is being executed in a different thread
***************************************
Q20. `ThreadLocal` is a special class in Java that helps us achieve thread safety by providing per-thread contexts and maintaining them separately for each thread. In other words, 
ThreadLocal is a Java class that can be used to define variables accessible solely by the thread that created them
***************************************
Q21. Coding/hw5/multithreadingLearn
***************************************
Q22. Difference between future and completableFuture: completableFuture includes future. Plus, It can `hold the result` of an asynchronous operation that is `BEING executed` in a different thread.
***************************************
Q23. Coding/hw5/oddEvenPrinter.java
***************************************
Q24. Coding/hw5/printNumber30.java
***************************************
Q25. Coding/hw5/CompletableFuture
***************************************