1. Explain volatile variables in java? (we also use it in Singleton)
> volatile in Java ensures: <br>
> Visibility: Immediate updates visible to all threads.<br>
Atomicity: Reads/writes are indivisible.<br>
No Caching: Always accessed from main memory.<br>
> When used in the context of a Singleton design pattern, volatile ensures that only one instance of the Singleton is created and accessed correctly by multiple threads.
2. how to create a new thread(Please also consider Thread Pool case)?
> extending thread class<br>
> implementing callable
> implementing runnable
> using thread pool
3. Difference between Runnable and Callable
> Runnable: Used for tasks that perform actions without returning a result. Its run method has a void return type and cannot throw checked exceptions.<br>
> Callable: Used for tasks that return a result. Its call method has a generic return type and can throw checked exceptions. It's suitable for scenarios where you need both a result and better exception handling.
4. what is the diff between t.start() and t.run()?
> t.start() is used to start a new thread and run its run method concurrently with other threads.<br>
> t.run() simply calls the run method of the thread in the current thread, without creating a new thread or achieving concurrency.
5. Which way of creating threads is better: Thread class or Runnable interface?
> In general, using the Runnable interface is often considered a better practice because it provides more flexibility and promotes better code organization. It separates the task or behavior from the thread management itself, allowing you to create multiple threads with the same behavior easily.
6. what is the thread status?
> NEW: A newly created thread, not yet started.<br>
RUNNABLE: A thread that is ready to run or actively running.<br>
BLOCKED: A thread waiting for a lock to access a synchronized block.<br>
WAITING: A thread waiting indefinitely for another thread's action.<br>
TIMED_WAITING: A thread waiting for a specified time duration.<br>
TERMINATED: A thread that has finished its execution and cannot be restarted.<br>

7. difference between wait() and sleep() method
> wait():<br>
wait() is a method provided by the Object class, and it is used for thread synchronization and inter-thread communication.<br>
When a thread calls wait(), it releases the lock on the object it is called on (typically within a synchronized block) and enters a "waiting" state. It remains in the waiting state until another thread calls notify() or notifyAll() on the same object, which wakes up the waiting thread.<br>
wait() is often used for implementing producer-consumer scenarios or for coordination between multiple threads.<br>
> 
> sleep():<br>
sleep() is a method provided by the Thread class and is used to introduce a pause in the execution of a thread.<br>
When a thread calls sleep(), it does not release any locks or monitors. It simply goes into a "sleep" state for the specified amount of time and then wakes up and continues execution. Other threads can continue to run while one thread is sleeping.<br>
sleep() is commonly used for introducing delays or timeouts in a program.<br>
8. What is deadlock?
> Deadlock is a situation in concurrent programming where multiple threads or processes are stuck because they're each waiting for a resource that another has locked. This causes a standstill, and none of them can make progress. It occurs when four conditions are met: mutual exclusion, hold and wait, no preemption, and circular wait.
9. how do threads communicate with each other?
> Threads communicate with each other through shared variables, signaling (e.g., wait() and notify()), message passing, synchronization primitives, futures/promises, thread pools, events/callbacks, atomic operations, and publish-subscribe patterns. The choice depends on the specific needs of the application.
10. what is join() method?
> In Java, the join() method is used to make one thread wait for another thread to finish its execution.
11. what is yield() method
> In Java, the yield() method is a static method of the Thread class. It's used to suggest to the Java Virtual Machine (JVM) that the current thread is willing to yield its current processor time, allowing other threads of the same priority to run.
12. Explain thread pool
> A thread pool is a group of reusable threads managed for efficient task execution. It helps reduce overhead by recycling threads, controls the number of concurrent threads, and manages task queues, making it ideal for executing multiple tasks concurrently, such as in web servers or parallel processing. Java's ExecutorService is a common example.
13. What is Executor Framework in Java, its different types and how to create these executors?
> Executor Interface:<br>
The Executor interface defines a single method, 'execute(Runnable command)', which accepts a Runnable task and submits it for execution. Implementations of this interface provide various ways to manage and execute tasks.<br>
Executor Types:<br>
The Executor Framework includes several types of executors to suit different concurrency needs:<br>
ThreadPoolExecutor: A general-purpose executor that manages a pool of worker threads. You can configure parameters like the core pool size, maximum pool size, and task queue capacity.<br>
ScheduledExecutorService: Extends ExecutorService and supports scheduling tasks to run at fixed intervals or with delays.<br>
FixedThreadPool: A type of ThreadPoolExecutor with a fixed number of threads in the pool.<br>
CachedThreadPool: A type of ThreadPoolExecutor that creates new threads as needed and reuses idle threads.<br>
SingleThreadExecutor: An executor that uses a single worker thread to execute tasks sequentially.<br>
ForkJoinPool: Introduced in Java 7, optimized for recursive, divide-and-conquer-style parallelism.<br>
WorkStealingPool: A variation of ForkJoinPool that employs a work-stealing algorithm for load balancing.<br>

14. Difference between shutdown() and shutdownNow() methods of executor
> Use shutdown() when you want to gracefully shut down the ExecutorService, allowing submitted tasks to complete their execution.<br>
Use shutdownNow() when you want to forcefully stop the ExecutorService, potentially interrupting actively executing tasks and preventing pending tasks from starting. It returns a list of pending tasks that were not executed.<br>
15. What is Atomic classes? when do we use it?
> atomic classes are a group of classes that provide atomic operations, meaning operations that are executed as a single, indivisible unit, without the possibility of interference from other threads.Some commonly used atomic classes include AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference.<br>
> However, for more complex operations or when you need to maintain consistency across multiple variables or data structures, you may still need to use traditional synchronization mechanisms like locks or synchronized blocks.<br>
16. What is the concurrent collections?
> Concurrent collections simplify the development of concurrent applications by providing thread-safe alternatives to their non-concurrent counterparts.
17. what kind of locks you know?
> Types of locks in concurrent programming include ReentrantLock, ReadWriteLock, StampedLock, Semaphore, CountDownLatch, CyclicBarrier, Phaser, locks in concurrent collections, locks in file I/O, and custom locks. They control access to shared resources in multithreaded applications.
18. What is the difference between class lock and object lock?
> Class locks are used to synchronize access to class-level resources shared among all instances of a class.<br>
Object locks are used to synchronize access to instance-specific resources associated with individual object instances.
19. What is future and completableFuture?
> Both Future and CompletableFuture are used for asynchronous programming, CompletableFuture provides more advanced features for composing, combining, and controlling asynchronous operations.
20. what is ThreadLocal?
> ThreadLocal ensures each thread has its own independent copy of a variable, commonly used for storing thread-specific data like user sessions or database connections.
21. completable future:
       a. Homework 1: Write a simple program that uses CompletableFuture to
       asynchronously get the sum and product of two integers, and print the
       results.
       b. Homework 2: Assume there is an online store that needs to fetch data
       from three APIs: products, reviews, and inventory. Use
       CompletableFuture to implement this scenario and merge the fetched
       data for further processing. (需要找public api去模拟，)
       i. Sign In to Developer.BestBuy.com
       ii. Best Buy Developer API Documentation
       (bestbuyapis.github.io)
       iii. 可以⽤fake api https://jsonplaceholder.typicode.com/
       c. Homework 3: For Homework 2, implement exception handling. If an
       exception occurs during any API call, return a default value and log the
       exception information.
> see coding in Chuwa0910\Coding\java-core\src\main\java\hw5