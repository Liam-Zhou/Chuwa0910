# hw5 Difan Xue

1. Explain volatile variables in java? (we also use it in Singleton)

It is used in multi-thread. When one thread changes the volatile variable, the other thread would know the change simultaneously.
2. how to create a new thread(Please also consider Thread Pool case)?

Extend the thread class; implement the runnable; use the thread pool.
3. Difference between Runnable and Callable

Callable can return the variable, while runnable can not.
4. what is the diff between t.start() and t.run()?

t.start starts a new thread to execute the task; t.run() execute the task in the current thread.
5. Which way of creating threads is better: Thread class or Runnable interface?

Runnable interface is better. Because it has more flexibility and reusability. The Thread class is implemented by the Runnable. So you can directly implement Runnable to get more functions and concerns. 
6. what is the thread status?

new, runnable, waiting, timed_waiting, terminated, blocked
7. difference between wait() and sleep() method

wait() causes the waiting. sleep() causes the time_waiting, after the sleeping time, the thread would wake up automatically.
8. What is deadlock?

When several threads try to get the same locks, it causes a deadlock. Specifically, when thread t1 hold the lock l1 and want to get the lock2. While thread t2 hold the lock2 and want to get lock1. So each thread would never give up their lock and waiting the the lock to be released.
9. how do threads communicate with each other?

Use reentrantlock to communicate.
10. what is join() method?

When a thread calls the join() method on another thread, it will block until the joined thread has finished executing.
11. what is yield() method

yield() is a hint to the JVM that the current thread is willing to give up the CPU to allow other threads to run.
12. Explain thread pool

It creates a pool with several threads. When each task be created, the task could be submitted to the thread by using task queue. Each thread of thread pool could be reused.
13. What is Executor Framework in Java, its different types and how to create these
executors?

Executor is to create thread pool. ExecutorService is the interface. To create, we can call FixedThereadPool,  CachedThreadExecutor.
14. Difference between shutdown() and shutdownNow() methods of executor

Graceful shutdown with **`shutdown()`** is generally preferred when you want to ensure that tasks are completed properly, while **`shutdownNow()`** is used when you need to forcefully terminate the executor and get information about pending tasks.
15. What is Atomic classes? when do we use it?

Atomic classes offer the atomic and safe thread operation on variables. We can use it by creating AtomicInteger, AtomicLong and so on.
16. What is the cocurrent collections?

It is the collections with the thread-safe, like CopyOnWriteArrayList, ConcurrentHashMap.
17. what kind of locks you know?

ReentrantLock, ReadWriteLock, StampedLock
18. What is the difference between class lock and object lock?

Object lock is associated with an instance of a class. A class lock is associated with the class itself, it also known as static lock.
19. What is future and completableFuture?

Future is the interface that represents the result of thread. CompletableFuture supports **chaining operations** and **Non-blocking** asynchronous operations.
20. what is ThreadLocal?

It works like context, A thread-local variable is a variable that is local to a specific thread. Each thread that accesses a **`ThreadLocal`** variable has its own independent copy of that variable, and changes made by one thread to its copy do not affect the copies held by other threads.

1. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. 

Seeing the coding/hw5 folder

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

Seeing the coding/hw5 folder