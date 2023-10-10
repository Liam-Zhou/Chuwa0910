1.  Explain volatile variables in java? (we also use it in Singleton)  

When a variable is declared as volatile, it tells the Java compiler and the Java Virtual Machine (JVM) that the variable's value may be changed by multiple threads concurrently. This means that any read or write operation on a volatile variable is atomic, which ensures that the variable's value is visible to all threads immediately after it's changed by one thread. 

In singleton, we declare the singleton as volatile so that to avoid any race condition.
2.  how to create a new thread(Please also consider Thread Pool case)?

   - extend `thread` and rewrite `run()`;
   - implements `Runnable` and rewrite `run()`;
   - implements `Callable` and rewrite `call()`;
   - thread pool: `ExecutorService executor = Executors.newFixedThreadPool(n);`
3.  Difference between Runnable and Callable

implements `Runnable` has to rewrite `run()`, implements `Callable` has to rewrite `call()`; `Runnable` return nothing, while `Callable` can return specific type.
4.  what is the diff between t.start() and t.run()?

`t.start()` start a thread and automatically execute `run()` in new thread; `t.run()` does not start a new thread, just uses current thread to execute `run()`.
5.  Which way of creating threads is better: Thread class or Runnable interface?

`Thread` is better since `Thread` is implement on `Runnable` with lots of help functions, which can make code more concise and easy. 
6.  what is the thread status?

thread status means the status of a thread. It has new, runnable, blocked, timed waiting, and terminated.
7.  difference between wait() and sleep() method

`wait()` is function used in multi threading program, means to wait until other thread notify to wakeup. However, `sleep()` is just to wait for set time and then continue.
8.  What is deadlock?  

Deadlock is the scenario that two or more threads or processes are unable to proceed with their execution because they are each waiting for the others to release resources or locks, effectively causing all of them to become stuck or unresponsive.
9.  how do threads communicate with each other?
    - through shared variables, like variables inside `synchronized` or declared `atomic`;
    - using `wait()`, `notify()` and `notifyAll()` to notify others when using synchronized.
    - using `condition.await()` and `condition.signal()` within ReentrantLock to communicate.

10. what is join() method?

`join()` is used to wait for another thread finish and then continue running.
11. what is yield() method

`yield()` allows a running thread to voluntarily give up the CPU and allow other threads to run.
12. Explain thread pool

A thread pool is a managed pool of worker threads that are used to execute tasks asynchronously in a multithreaded environment. There should be a task queue, and whenever a thread in the pool is free, it can get a task from queue and do work.
13. What is Executor Framework in Java, its different types and how to create these executors?

The Executor is a framework provided by the `java.util.concurrent` package for managing and controlling the execution of concurrent tasks in a multithreaded application. It abstracts the details of thread creation, management, and scheduling, making it easier to write efficient and scalable concurrent code.
14. Difference between shutdown() and shutdownNow() methods of executor

When you call `shutdown()`, the executor will continue to execute any previously submitted tasks that are still running but will not accept any new tasks for execution. However, `shutdownNow()` will force shutdown everything.
15. What is Atomic classes? when do we use it?

`Atomic` is a thread-safe variable, can guarantee a variable to be accessed by one thread at one time only.
16. What is the concurrent collections?

Concurrent collections in Java are specialized data structures that are designed to be thread-safe for concurrent access by multiple threads.
17. What kind of locks you know?

ReadWriteLock, ReentrantLock, StampedLock, Semaphore.
18. What is the difference between class lock and object lock?

Class lock synchronizes access to static methods or static blocks at the class level.
Object lock synchronizes access to instance methods or instance blocks at the instance (object) level.
19. What is future and completableFuture?

Future is an interface that represents the result of an asynchronous computation or task that may not have completed yet. It provides a way to retrieve the result of an asynchronous computation when it becomes available or to check if the computation is complete.

CompletableFuture extends the capabilities of Future by allowing you to explicitly complete or exceptionally complete a computation, chain multiple asynchronous operations together, apply transformations to the result, and define callbacks.
20. what is ThreadLocal?

ThreadLocal class provides a way to create thread-local variables. A thread-local variable is a variable that is local to a particular thread, and each thread has its own independent copy of that variable. ThreadLocal is always used to pass context in single thread.
21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)  

See `Coding/multithreading`
22. Read those interview questions and pick some important questions to this homework.
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
    - One solution use synchronized and wait notify  
        See `Coding/hw5/OddEventPrinter`  
    - One solution use ReentrantLock and await, signal  
        See `Coding/hw5/OddEvenReentrantLock`
24. create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)  

See `Coding/hw5/Print10NumberX3`
25. completable future:
    - Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
    - Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing.
    -  Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.

See `Repo/MavenProject/com.chuwa.learn.completableFuture`