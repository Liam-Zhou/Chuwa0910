# HW5- Ke Chen

## 1. Explain volatile variables in java? (we also use it in Singleton)
A volatile variable is basically a keyword that <u>is used to ensure and address the visibility of changes to variables in multithreaded programming</u>.

This keyword cannot be used with classes and methods, instead can be used with variables.

It is simply used to achieve thread-safety. 
If you mark any variable as volatile, then <u>all the threads can read its value directly from the main memory rather than CPU cache, so that each thread can get an updated value of the variable</u>.

## 2. how to create a new thread(Please also consider Thread Pool case)?
- extending the thread class
```
public class myThread extends Thread{
    @Override
    public void run(){
        System.out.println("start new thread using extends thread");
    }
}
public static void main(String args[]){
    Thread t = new myThread();    // JVM没有创建thread
    t.start();   // 此时JVM才创建新的thread
}
```

- implementing runnable interface
```
public class myRunnale implements Runnable{
    @Override
    public void run(){
        System.out.println("Start new thread using Runnable");
    }
}
public static void main(String args[]){
    Thread t = new myThread(new myRunnable());    
}
```

- implements callable interface
```
public class myCallable implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
```

- using a thread pool
Java provides the ExecutorService framework for this purpose.
```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            Runnable task = new MyRunnable(); // Replace MyRunnable with your task logic
            executor.submit(task);
        }

        // Shutdown the thread pool when you're done with it
        executor.shutdown();
    }
}
```

## 3. Difference between Runnable and Callable interface?
- return type

runnable has no return.

callable has return.

- method

runnable uses the run() method to define a task.

callable uses the call() method to define a task.

## 4. what is the diff between t.start() and t.run()?
- basic

t.start() <u>creates a new thread</u> to excute the task. And this newly created thread executes the task that is kept in the run() method.

t.run() <u>creates no new thread</u> and excute the task in the current thread.

- time

t.start(): One can call the start() method only once.  

t.run(): One can call the start() method multiple times.  

## 5. Which way of creating threads is better: Thread class or Runnable interface?
Runnable interface.
As implementing Runnable makes your code loosely coupled as the code of thread is different from the class that assign job to the thread. 
<u>It requires less memory and also allows a class to inherit any other class.</u>

## 6. what is the thread status?
A thread can have one of the following states during its lifetime:
1. New: 
In this state, <u>a Thread class object is created</u> using a new operator, <u>but the thread is not alive</u>. Thread doesn't start until we call the start() method.
2. Runnable: 
In this state, <u>the thread is ready to run after calling the start() method</u>. 
However, the thread is not yet selected by the thread scheduler.
3. Running: 
In this state, <u>the thread scheduler picks the thread from the ready state, and the thread is running</u>.
4. Waiting/Blocked: 
In this state, <u>a thread is not running but still alive</u>, or <u>it is waiting for the other thread to finish</u>.
5. Dead/Terminated: 
<u>A thread is in terminated or dead state when the run() method exits</u>.

## 7. difference between wait() and sleep() method
- defined class

wait() method is defined in Object class.

sleep() method is defined in Thread class.

- release lock

wait() method release the lock.

sleep() method doesn't release the lock.

## 8. What is deadlock?
Deadlock is <u>a situation where multiple threads are blocked forever</u>. 
It generally occurs when multiple threads hold locks on different resources and are waiting for other resources to complete their task.

For example:
Thread 1 is holding Object 1 but needs object 2 to complete processing whereas Thread 2 is holding Object 2 but needs object 1 first. In such conditions, both of them will hold lock forever and will never complete tasks.

## 9. how do threads communicate with each other?
Threads can communicate using three methods i.e., wait(), notify(), and notifyAll().

## 10. what is join() method?
join() method causes the currently running threads to stop executing until the thread it joins completes its task.

t1.join() 等待t1结束

## 11. what is yield() method
A yield() method is a static method of Thread class and it <u>can stop the currently executing thread and will give a chance to other waiting threads of the same priority</u>. 
If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution. 
The advantage of yield() method is to get a chance to execute other waiting threads so if our current thread takes more time to execute and allocate processor to other threads.

## 12. Explain thread pool.
Java Thread pool represents <u>a group of worker threads, which are waiting for the task to be allocated</u>. 等待分配任务
Threads in the thread pool are supervised by the service provider which pulls one thread from the pool and assign a job to it.
After completion of the given task, thread again came to the thread pool.
The size of the thread pool depends on the total number of threads kept at reserve for execution.

线程池中的线程由服务提供商监督，服务提供商从池中提取一个线程并为其分配作业。
给定任务完成后，线程再次进入线程池。
线程池的大小取决于保留执行的线程总数。

## 13. What is Executor Framework in Java, its different types and how to create these executors?
<u>A framework having a bunch of components that are used for managing worker threads efficiently</u> is referred to as Executor Framework.

The Executor API reduces the execution of the task from the actual task to be executed through the Executors. The executor framework is an implementation of the Producer-Consumer pattern. The java.util.concurrent.Executors class provides a set of methods for creating ThreadPools of worker threads.

In order to use the executor framework, we have to create a thread pool for executing the task by submitting that task to that thread pool.

### types of executors and how to create them:
- SignleThreadExecutor
The SingleThreadExecutor is a special type of executor that has only a single thread. It is used when we need to execute tasks in sequential order. In case when a thread dies due to some error or exception at the time of executing a task, a new thread is created, and all the subsequent tasks execute in that new one.
```
ExecutorService executor = Executors.newSingleThreadExecutor()  
```
- FixedThreadPool(n)
FixedThreadPool is another special type of executor that is a thread pool having a fixed number of threads. By this executor, the submitted task is executed by the n thread. In case when we need to execute more tasks after submitting previous tasks, they store in the LinkedBlockingQueue until previous tasks are not completed. The n denotes the total number of thread which are supported by the underlying processor.
```
ExecutorService executor = Executors.newFixedThreadPool(4);  
```

- CachedThreadPool
The CachedThreadPool is a special type of thread pool that is used to execute short-lived parallel tasks. The cached thread pool doesn't have a fixed number of threads. When a new task comes at a time when all the threads are busy in executing some other tasks, a new thread creates by the pool and add to the executor. When a thread becomes free, it carries out the execution of the new tasks. Threads are terminated and removed from the cached when they remain idle for sixty seconds.
```
ExecutorService executor = Executors.newCachedThreadPool();  
```

- ScheduledExector
The ScheduledExecutor is another special type of executor which we use to run a certain task at regular intervals. It is also used when we need to delay a certain task.
```
ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);  
```
The scheduleAtFixedRate and scheduleWithFixedDelay are the two methods that are used to schedule the task in ScheduledExecutor. The scheduleAtFixedRate method executes the task with a fixed interval when the previous task ended. The scheduleWithFixedDelay method starts the delay count after the current task complete. The main difference between these two methods is their interpretation of the delay between successive executions of a scheduled job. Both the methods are used in the following way:
```
scheduledExecService.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)  
scheduledExecService.scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit)  
```

## 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() 方法在终止前允许执行以前提交的任务，而 shutdownNow() 方法阻止等待任务启动并试图停止当前正在执行的任务

- shutdown:
```
void shutdown()
```

<u>Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted</u>.  启动有序关闭，在此关闭中执行以前提交的任务，但不接受新任务

Invocation has no additional effect if already shut down.
This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that.

- shotdownNow():
```
List<Runnable> shutdownNow()

Returns:
list of tasks that never commenced execution
```

Attempts to <u>stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.</u> . 停止所有正在执行的任务，停止处理等待的任务，并返回等待执行的任务列表
This method does not wait for actively executing tasks to terminate. Use awaitTermination to do that.

There are no guarantees beyond best-effort attempts to stop processing actively executing tasks. For example, typical implementations will cancel via Thread.interrupt(), so any task that fails to respond to interrupts may never terminate.


## 15. What is Atomic classes? when do we use it?
- what is atomic classes
Java provides a java.util.concurrent.atomic package in which atomic classes are defined. 
The atomic classes <u>provide a lock-free and thread-safe environment or programming on a single variable</u>
(原子操作实现了无锁的线程安全).It also supports atomic operations. 
All the atomic classes have the get() and set() methods that work on the volatile variable. 
The method works the same as read and writes on volatile variables.

Java提供了一个Java.util.concurrent.atomic包，其中定义了原子类。
原子类提供了一个无锁和线程安全的环境或对单个变量进行编程。它还支持原子操作。所有原子类都有处理volatile变量的get（）和set（）方法。该方法的工作原理与对volatile变量的读写操作相同。

- when do we use it:
适用于计数器，累加器等

## 16. What is the cocurrent collections?
Concurrent collection in Java refers to <u>a set of classes that allow multiple threads to access and modify a collection concurrently, without the need for explicit synchronization</u>.
These collections are part of the java.util.concurrent package and provide thread-safe implementations of the traditional collection interfaces like List, Set, and Map.

Interface   non-thread-safe         thread-safe
List        ArrayList               CopyOnWriteArrayList
Map         HashMap                 ConcurrentHashMap
Set         HashSet/TreeSet         CopyOnWriteArraySet
Queue       ArrayDeque/LinkedList   ArrayBlockingQueue/LinkedBlockingQueue
Deque       ArrayDeque/LinkedList   LinkedBlockingDeque

## 17. what kind of locks you know?
我们知道Java语言直接提供了synchronized关键字用于加锁，但这种锁一是很重，二是获
取时必须一直等待，没有额外的尝试机制。
java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁

- ReentrantLock 可重入锁, 和synchronized一样，一个线程可以多次获取同一个锁
```
private final Lock Rlock = new ReentrantLock();

try{
    count += n;    加锁内容
}finally{
    Rlock.unlock(); 必须先获取锁，然后在finally中正确释放锁
}
```

- ReadWriteLock  悲观锁

只允许一个线程写入（其他线程既不能写入也不能读取）。
没有写入时，多个线程允许同时读（提高性能）。
ReadWriteLock适合读多写少的场景。
悲观锁，因为读的过程中是不允许写的。
```
public class Counter{
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();   //读锁和写锁是分开的
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index){
        wlock.lock(); // 加写锁
        try{
            counts[index] += 1;
        }finally{
            wlock.unlock(); 释放写锁
        }
    }

    public int[] get(){
        rlock.lock(); // 加读锁
        try{
            return Arrays.copyOf(counts, counts.length);
        }finally{
            rlock.unlock(); // 释放读锁
        }
    }
}
```

- StampedLock 乐观锁

乐观锁，读的过程中允许写，但可能造成数据不一致的问题，所以需要写代码handle。

获得一个乐观读锁 --> 检查乐观读锁后是否有其他写锁发生 --> 获取一个乐观读锁  --> 释放乐观读锁
```
1. long stamp = stampedLock.tryOptimisticRead();
2. !stampedLock.validate(stamp)
3. stamp = stampedLock.readLock();
4. stampedLock.unlockRead(stamp);
```

## 18. What is the difference between class lock and object lock?
- class lock:
In java, <u>each and every class has a unique lock usually referred to as a class level lock</u>. 
These locks <u>are achieved using the keyword ‘static synchronized’</u> and can be used to make static data thread-safe. 
It is generally used when one wants to prevent multiple threads from entering a synchronized block
```
public class ClassLevelLockExample{    
    public void classLevelLockMethod(){       
        synchronized (ClassLevelLockExample.class){         
            //DO your stuff here       
        }    
    } 
} 
```
- Object Lock: 
In java, <u>each and every object has a unique lock usually referred to as an object-level lock</u>. 
These locks <u>are achieved using the keyword ‘synchronized’</u> and can be used to protect non-static data. 
It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.  
```
public class ObjectLevelLockExample{    
    public void objectLevelLockMethod(){   
        synchronized (this){     
            //DO your stuff here   
       } 
    }
} 
```

## 19. What is future and completableFuture?
### future interface
A Future interface provides methods <u>to check if the computation is complete, to wait for its completion and to retrieve the results of the computation</u>.

The result is retrieved using Future’s get() method when the computation has completed, and it blocks until it is completed. 

### completableFuture
使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。
从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
CompletableFuture is a class in java.util.concurrent package that implements the Future and CompletionStage Interface. 
It represents a future result of an asynchronous computation. It can be thought of as a container that holds the result of an asynchronous operation that is being executed in a different thread. It provides a number of methods to perform various operations on the result of the async computation. 

## 20. what is ThreadLocal?
这种在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。

给每个方法增加一个context参数非常麻烦，而且有些时候，如果调用链有无法修改源码的第三方库，User对象就传不进去了。

Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象。

ThreadLocal is a special class in Java that helps us achieve thread safety by providing per-thread contexts and maintaining them separately for each thread. 

In other words, ThreadLocal is a Java class that can be used to define variables accessible solely by the thread that created them. 

This can be useful in a number of situations, but the most common use case is when you need to store data that should not be shared between threads.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
done

## 22. Read those interview questions and pick some important questions to this home work.
done. The answers to above questions are according to interview questions

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
done
