# HW5 - Grace Hu

### 1. Explain volatile variables in java? (we also use it in Singleton)
**volatile** is used as a modifier for instance variables. 

**Volatile variables** indicates that any thread that reads the field sees the most recent write by any other thread to that field. It ensures visibility of changes across threads.

### 2. how to create a new thread(Please also consider Thread Pool case)?
**a. Extends Thread Class**

    public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("start new thread using extends thread");
        }
    }
    Thread t = new MyThread(); // JVM doesn't create thread yet!!
    t.start(); // JVM created new thread at this time

**b. Implements Runnable Interface**

    public class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Start new thread using Runnable");
        }
    }
    Thread t2 = new Thread(new MyRunnable());

**c. Using Thread Pool**

    // 创建固定⼤⼩的线程池:
    ExecutorService executor = Executors.newFixedThreadPool(4);
    // 提交任务:
    executor.submit(() -> "ganhuo");
    executor.submit(task2);
    executor.submit(task3);
    executor.submit(task4);
    executor.submit(task5);
    Thread t = new MyThread();
    <- vs -> ExecutorService executor =
    Executors.newFixedThreadPool(4);
    t.start(); executor.submit()


### 3. Difference between Runnable and Callable
**runnable** has no return.

**callable** has return.

### 4. what is the diff between t.start() and t.run()?
**t.start()** starts a new thread to excute the task(run()).
**t.run()** excute the task in the current thread.

### 5. Which way of creating threads is better: Thread class or Runnable interface?
**Runnable interface** is better.
- It extends any other class.
- It shares the same object to multiple threads


### 6. what is the thread status?
- **NEW**: A thread that has not yet started is in this state.
- **RUNNABLE**: A thread executing in the Java virtual machine is in this state.
- **BLOCKED**: A thread that is blocked waiting for a monitor lock is in this state.
- **WAITING**: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
- **TIMED_WAITING**: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
- **TERMINATED**: A thread that has exited is in this state.

### 7. difference between wait() and sleep() method
**wait()** is a non-static method that causes the current thread to wait and go to sleep until some other threads call the notify() or notifyAll() method for the object’s monitor (lock). It simply releases the lock and is mostly used for inter-thread communication. It is defined in the object class, and should only be called from a synchronized context. 

**sleep()** is a static method that pauses or stops the execution of the current thread for some specified period. It doesn’t release the lock while waiting and is mostly used to introduce pause on execution. It is defined in thread class, and no need to call from a synchronized context.  

### 8. What is deadlock?
**deadlock** is a situation where multiple threads are blocked forever. It generally occurs when multiple threads hold locks on different resources and are waiting for other resources to complete their task.

### 9. how do threads communicate with each other?
Threads can communicate using three methods wait(), notify(), and notifyAll().

### 10. what is join() method?
**join()** method is generally used to pause the execution of a current thread unless and until the specified thread on which join is called is dead or completed. It stops a thread from running until another thread gets ended. It joins the start of a thread execution to the end of another thread’s execution. It is considered the final method of a thread class.

### 11. what is yield() method
**yield()** is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. 

If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution.

### 12. Explain thread pool
**thread pool** is a managed pool of worker threads that are used to execute tasks concurrently. It is a way to efficiently manage and reuse a fixed number of threads, preventing the overhead of creating and destroying threads for each task. 

### 13. What is Executor Framework in Java, its different types and how to create these executors?

**Executor Framework** is used to run the Runnable objects without creating new threads every time and mostly re-using the already created threads. 

#### SingleThreadExecutor
    
    ExecutorService executor = Executors newSingleThreadExecutor();
    
#### FixedThreadPool(n)

    ExecutorService fixedPool = Executors.newFixedThreadPool(2);

#### CachedThreadPool

    ExecutorService executorService = Executors.newCachedThreadPool();

#### ScheduledExecutor

    scheduledExecService.scheduleAtFixedRate
(Runnable command, long initialDelay, long period, TimeUnit unit)

### 14. Difference between shutdown() and shutdownNow() methods of executor
**shutdown()** allows the executor to complete all the tasks that have been submitted or are currently executing, and then it shuts down the executor in an orderly manner.

**shutdownNow()** attempts to stop all tasks immediately, interrupting executing tasks and returning a list of tasks that were waiting to be executed.

### 15. What is Atomic classes? when do we use it?
Atomic classes are designed to be used in concurrent programming, where multiple threads may access and modify shared variables simultaneously. The atomic classes ensure that operations on these variables are atomic and thread-safe without the need for explicit synchronization.

### 16. What is the cocurrent collections?
All the classes present in **Concurrent Collections** are synchronized in nature, there is thread-safe. They are designed to handle concurrent access efficiently and safely, reducing the need for explicit synchronization in many scenarios. 

### 17. what kind of locks you know?
- synchronize
- ReentrantLock
- ReadWriteLock
- StampedLock

### 18. What is the difference between class lock and object lock?
**Class Lock**: Every class has a unique lock usually referred to as a class level lock. These locks are achieved using the keyword ‘**static synchronized**’ and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block. 

**Object Lock**: Every object has a unique lock usually referred to as an object-level lock. These locks are achieved using the keyword ‘**synchronized**’ and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.  

### 19. What is future and completableFuture?
**future** is basically placeholder for a result of an operation that hasn't finished yet. Once the operation finishes, the Future will contain that result. For example, an operation can be a Runnable or Callable instance that is submitted to an ExecutorService. The submitter of the operation can use the Future object to check whether the operation isDone(), or wait for it to finish using the blocking get() method.

**completableFuture** is Future that also allow us to string tasks together in a chain. We can use them to tell some worker thread to "go do some task X, and when you're done, go do this other thing using the result of X". Using CompletableFutures, we can do something with the result of the operation without actually blocking a thread to wait for the result.

### 20. what is ThreadLocal?
**ThreadLocal** allows programmers to create variables that are accessible **only** to the **thread** that created them.