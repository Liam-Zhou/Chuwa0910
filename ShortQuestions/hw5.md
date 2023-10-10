1.  Explain volatile variables in java? (we also use it in Singleton)

    > volatile variables look like a global variable in multithread. Everything changed in the thread will be broadcasted to the other thread and the main thread. 

2.  how to create a new thread(Please also consider Thread Pool case)?

    > there are three ways to create thread: Using extension thread, Using `Runnable` to Override the run() function, Using `Callable` to overrride the call function But will be used by the thread pool. 

3.  Difference between Runnable and Callable. 

    > `Runnable` can be used as thread. But Callable can not be used in the thread pool. In addition, `Runnable` does not have return, but `Callable` can return `Feature`. 

4.  what is the diff between t.start() and t.run()? 

    > t.start() will start a new thread and then run the `run()` method. However, `t.run()` will only run the function but will not create the thread. 

5.  Which way of creating threads is better: Thread class or Runnable interface?

    > ?? In general, by creating thread class is better, since you can access thread data and the other functions. The power of Runnable is limited. 

6.  what is the thread status?

    > NEW: Just created/Initialized, but haven't used the `start()`
    > RUNNABLE: it included running and ready. 
    > BLOCKED: it is blocked by lock. 
    > WAITING: it is waiting and wait for `notify`
    > TIMED_WAITING: same as WAITING but has a clock 
    > TERMINATED: tasks are finished. 

7. difference between wait() and sleep() method

    > wait() needs to get notification to run the code and will lose the lock, but sleep is a self-motivated action and will recover from the sleep will not lose the lock. 

8.  What is deadlock?

    > In general, there are two locks, and tasks will require two locks to finish the operation. One thread hold one lock and another thread hold another lock. They all wait the other way to unlock the lock and they wait infinite time.

9.  how do threads communicate with each other?

    > In general, they are using `wait()` , `notify()` , `join()` to do the communication. 
    > In advanced, they are using `TaskQueue` to transfer data with each other. 

10. what is join() method?

    > join() is a block method for one thread (like main) to wait the other thread. 

11. what is yield() method

    > yield is a static method, it will yield current thread and left the other method to run. 

12. Explain thread pool

    > It is a thread manager, it can create multiple threads and help threads to assign tasks and help them to be used in multiple time. 

13. What is Executor Framework in Java, its different types and how to create these executors?

    > like `FixedThreadPool` and `CachedThreadPool` can dynamic arrange number of threads and `SingleThreadExecutor` only one thread. 
    ``` Java 
    ExecutorService es1 = Executors.newFixedThreadPool(4); 
    ExecutorService ex2 = Executors.newCachedThreadPool(); 
    ExecutorService ex3 = Executors.newSingleThreadExecutor(); 
    ```

14. Difference between shutdown() and shutdownNow() methods of executor 

    > shutdown() will not accept new tasks and wait till ongoing tasks finished. 
    > shutdownNow() will interrupt ongoing thread and shut them down. 

15. What is Atomic classes? when do we use it?

    > atomic classes are class with built-in lock to protect the multiple thread operation. When we want some object can be used in mutiple threads, we can use the atomic classes. 

16. What is the cocurrent collections?

    > like atomic classes, it is collections for thread to use in the multiple thread and can keep the thread-safe. 

17.  what kind of locks you know? 

    > ReentrantLock: can be multiple use. 
    > ReadWriteLock: can be separated into read lock and write lock. When write, no read no write. When read, mutliple read. 

18. What is the difference between class lock and object lock?
    
    > object lock: object can only be accessed by one thread. 
    > class lock: prevent multiple threads enter one synchronzied block. 

19. What is future and completableFuture?

    > future is a return object from the executor after the thread tasks finished. but it will create block. 
    > completableFuture can wait and write Asynchrony chain function to finish tasks. 

20. what is ThreadLocal?

    > ThreadLocal is creating a global variable for multiple threads to use. 

21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

    > In Code.hw5

22. Read those interview questions and pick some important questions to this home work.
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.(solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrint)
    a. One solution use synchronized and wait notify. 
    b. One solution use ReentrantLock and await, signal 

    > In Code.hw5

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

    > In Code.hw5