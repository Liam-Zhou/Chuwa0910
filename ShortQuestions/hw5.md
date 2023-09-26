1. Explain volatile variables in java? (We also use it in Singleton).

    The volatile keyword in Java is used as an indicator to the Java compiler and the JVM that a particular variable might be accessed and updated by multiple threads simultaneously. It has specific semantics which ensure visibility and ordering of reads/writes.

    1. Visibility Guarantee:

       - One of the main challenges in multi-threaded programming is that due to various optimizations like CPU caching, the changes made by one thread to a shared variable might not be visible to other threads immediately.
       - When a variable is declared as volatile, it guarantees that any write to that variable will be immediately visible to all other threads. This is achieved by ensuring that the variable's value is read directly from main memory and not from any local CPU cache.

    2. Ordering Guarantee (Happens-Before Guarantee):

       - Another challenge in multi-threaded programming is the order in which operations are performed. Compilers and processors might reorder instructions for optimization.
       - With volatile, there is a happens-before guarantee: for any two accesses to a volatile variable, the first access will happen before the second one, from the perspective of any observing thread. This ensures a predictable order of operations.

    3. Not a Replacement for Synchronization:

       - It's essential to understand that volatile does not provide atomicity. For instance, if you have a compound operation like incrementing a counter (counter = counter + 1), marking counter as volatile will not make the increment operation atomic.
       - volatile only ensures that reads and writes to the variable are visible to other threads immediately. To ensure atomicity or to protect multi-statement operations, you'll still need to use synchronization mechanisms like synchronized blocks or java.util.concurrent locks and utilities.

    4. Usage in Singleton:

       - The Singleton pattern aims to ensure that a class has only one instance and provides a global point to access that instance.
       - In a multi-threaded environment, creating a Singleton instance can be tricky, as multiple threads might attempt to create an instance simultaneously.
       - A common method to ensure thread safety in Singletons is the Double-Checked Locking idiom, where the instance is checked twice before creation, once without locking (for performance) and once with locking (for thread safety). In this idiom, the Singleton instance variable is often marked as volatile to ensure that if one thread creates the instance, other threads can see that instance reliably and promptly.

2. How to create a new thread (Please also consider Thread Pool case)?

    1. Creating a New Thread:
       - Extending the Thread class:
         ```
         class MyThread extends Thread {
            public void run() {
               // code to execute in this thread
            }
         }

         // Usage:
         MyThread thread = new MyThread();
         thread.start();
         ```
       - Implementing the Runnable interface:
         ```
         class MyRunnable implements Runnable {
            public void run() {
               // code to execute in this thread
            }
         }

         // Usage:
         Thread thread = new Thread(new MyRunnable());
         thread.start();
         ```

    2. Using a Thread Pool:
       Java provides the Executor framework which can be used to create a pool of worker threads.

       - Using Executors utility class to create a thread pool:
         ```
         import java.util.concurrent.Executors;
         import java.util.concurrent.ExecutorService;

         // Creating a fixed thread pool with 10 threads
         ExecutorService executor = Executors.newFixedThreadPool(10);

         // Submitting a task for execution
         executor.submit(new MyRunnable());

         // Shutting down the executor
         executor.shutdown();
         ```
         There are other types of thread pools available, such as newCachedThreadPool(), newSingleThreadExecutor(), etc., in the Executors class.

3. Difference between Runnable and Callable.

    1. Runnable:
       - Return Type: Doesn't return a result (has void return type for the run() method).
       - Exception: Cannot throw a checked exception, only unchecked exceptions.
       - Usage: Used for tasks when you don't need to return a computation result.
       - Method: void run()

    2. Callable<V>:
       - Return Type: Can return a result of type V.
       - Exception: Can throw a checked exception.
       - Usage: Used for tasks that need to return a computed result.
       - Method: V call() throws Exception

    In addition, when we submit a Callable to an ExecutorService, it returns a Future<V> object, which represents the result of the computation and provides methods to fetch, wait for, or cancel the computation.

4. What is the difference between t.start() and t.run()?

    1. t.start():
       - Threading: Launches the thread's task in a new, separate thread of execution.
       - Method: Calls the run() method of the Thread object in this new thread.
       - Usage: Use when we want to execute the thread's task concurrently.

    2. t.run():
       - Threading: Executes the thread's task in the current thread, not in a new thread.
       - Method: Just a regular method call, like any other method.
       - Usage: Typically, we shouldn't call this directly unless we want to run the thread's task in the current thread (no multithreading).

5. Which way of creating threads is better: Thread class or Runnable interface?

    Using the Runnable interface is generally preferred over extending the Thread class:

    1. Java's Single Inheritance: Java doesn't support multiple inheritance for classes. So, if we extend the Thread class, our class cannot extend any other class. On the other hand, using Runnable allows our class to extend another class because it's an interface.

    2. Separation of Concerns: Implementing Runnable separates the task being performed from the thread mechanism, promoting cleaner, more modular code.

    3. Flexibility: We can execute the Runnable in different contexts. It doesn't have to run in a thread; it could be passed to a thread pool, be run within an ExecutorService, or even just be invoked as a regular method call.

    4. Reusability: Runnable tasks can be reused across multiple threads. The same Runnable instance can be passed to multiple thread constructors or to executors.

6. What is the thread status?

    1. NEW: The thread has been created but hasn't started yet.

    2. RUNNABLE: The thread is either running or ready to run but might be waiting for system resources to be available.

    3. BLOCKED: The thread is waiting to acquire a monitor lock to enter or re-enter a synchronized method or block.

    4. WAITING: The thread is indefinitely waiting for another thread to take a specific action. Methods that put a thread in this state include Object.wait() without timeout, Thread.join() without timeout, and LockSupport.park().

    5. TIMED_WAITING: Similar to WAITING, but the thread is waiting for another thread to take action for a specified waiting time. Methods that can put a thread in this state include Thread.sleep(), Object.wait() with timeout, and Thread.join() with timeout.

    6. TERMINATED: The thread has completed its execution.

7. Difference between wait() and sleep() method.

    wait() and sleep() are two methods in Java used for pausing the execution of threads, but they serve different purposes and have different behaviors.

    1. wait() method:

       - Location: Part of the Object class.
       - Usage: Often used in synchronization for inter-thread communication.
       - Behavior: When a thread executes wait() on an object, it releases the monitor lock on that object and enters the WAITING or TIMED_WAITING state.
       - Wake up: The waiting thread can be woken up by another thread calling notify() or notifyAll() on the same object or by the timeout duration expiring.
       - Note: wait() method should always be called within a synchronized block or method.

    2. sleep() method:

       - Location: Part of the Thread class.
       - Usage: Used to pause the execution of the current thread for a specified period.
       - Behavior: Unlike wait(), the sleep() method doesn't release any locks the thread might have on synchronized blocks or methods.
       - Wake up: The sleeping thread wakes up and moves to RUNNABLE state after the specified duration has passed or if it's interrupted.
       - Note: sleep() is a static method and affects the currently executing thread.

8. What is deadlock?

    Deadlock is a situation in multithreading where two or more threads are blocked forever, each waiting for the other to release a resource. It occurs when multiple threads need the same locks but obtain them in a different order. If a thread holds one lock and tries to acquire a second lock that is held by another thread, which in turn tries to acquire the lock held by the first thread, a deadlock arises. Essentially, it's a standstill where threads cannot proceed or complete their tasks due to mutual blocking. Avoiding inconsistent lock order and using timeouts are among the strategies to prevent deadlocks.

9. How do threads communicate with each other?

    1. Shared Variables: Threads from the same process can access shared memory, which means they can read and write to the same variables. However, using shared variables requires synchronization mechanisms, like synchronized blocks or Locks, to prevent race conditions and ensure thread safety.

    2. Wait/Notify Mechanism: This is a traditional inter-thread communication mechanism in Java where a thread (wait() method) waits for a specific condition to be met and another thread (notify() or notifyAll()) signals when that condition has changed. This mechanism is used with the Object class's intrinsic lock methods.

    3. Pipes: Java provides a mechanism for threads to communicate using data streams. One thread writes data to a PipedOutputStream, and another reads from the corresponding PipedInputStream.

    4. Thread-safe data structures: Java's java.util.concurrent package offers several thread-safe data structures, like BlockingQueue, ConcurrentHashMap, CopyOnWriteArrayList, etc. Threads can use these to safely share and manage data.

    5. Semaphores and CountDownLatch: Semaphore is used to control the number of threads that can access a resource, while CountDownLatch lets one thread wait for one or more threads to complete their operations.

    6. Exchanger: The Exchanger class provides a synchronization point for two threads, where they can swap elements between them.

    7. ThreadLocal: While it doesn't allow threads to communicate directly, it helps threads to have their own isolated data which isn't shared with other threads.

10. What is join() method?

    The join() method in Java is a mechanism to allow one thread to wait for another thread to complete its execution. It's a way of introducing a "happens-before" relationship between threads.

    When we call the join() method on a thread, the calling thread goes into a waiting state. It remains in that state until the referenced thread terminates, either normally or via an exception.

11. What is yield() method?

    The yield() method in Java is a static method of the Thread class that provides a hint to the thread scheduler that the currently executing thread is willing to relinquish its current use of the processor, allowing other threads to be scheduled. However, it's important to note that yield() is merely a hint, and the thread scheduler is free to ignore it.

    In essence, when a thread invokes yield(), it transitions from the running state back to the runnable state, allowing other threads of the same or higher priority an opportunity to execute. But there's no guarantee about which thread will be executed next, including the possibility that the thread that just called yield() might be chosen to run again.

    Here's a brief overview:

    - Thread A is currently running.
    - Thread A calls Thread.yield().
    - The thread scheduler might choose another thread B to run, or it might choose thread A to continue running.

    It's worth mentioning that the actual behavior of yield() can vary between different JVM implementations and underlying operating systems. As a result, yield() is rarely used in real-world applications because it doesn't offer strong guarantees about thread scheduling behavior.

12. Explain thread pool.

    A thread pool is a collection of pre-instantiated, idle threads that stand ready to be given a task. These pooled threads are reused to execute multiple tasks, avoiding the overhead of thread creation and destruction, which can be significant in high-throughput applications.

    1. Efficiency: Spinning up a new thread for each task can be resource-intensive. With a thread pool, threads are recycled, reducing the overhead of thread creation.

    2. Resource Management: A thread pool provides a means to manage resources by controlling the number of threads that can be executed simultaneously. This ensures that the system doesn't become overloaded.

    3. Task Queue: Typically, a thread pool is associated with a task queue. When a task is submitted to the thread pool, it's queued up. Threads from the pool constantly check this queue and pick up tasks as they become available.

    4. Fixed Size: Often, the number of threads in a thread pool is fixed. If all threads are busy, new tasks wait in the queue. Some implementations also allow for dynamic resizing based on demand.

    5. Java's Executor Framework: In Java, the Executor framework, particularly the Executors utility class, provides factory methods for creating different types of thread pools, such as newFixedThreadPool, newCachedThreadPool, and newSingleThreadExecutor.

    6. Graceful Shutdown: Thread pools often provide mechanisms to shut down gracefully, ensuring that all active tasks are completed and no new tasks are started.

13. What is Executor Framework in Java, its different types and how to create these executors?

    The Executor Framework in Java is an advanced framework that provides a higher-level replacement for the traditional way of managing threads. It decouples the task submission from the details of how each task will be executed.

    Here are the key components and types of Executors:

    - Executor: This is a simple interface with a execute(Runnable command) method, which takes in a Runnable task and executes it.
    - ExecutorService: An extended form of the Executor that provides lifecycle methods (like shutdown()), and the ability to submit tasks and receive Future objects in return.
    - ScheduledExecutorService: An extension of ExecutorService that supports delayed and periodic task execution.

    1. SingleThreadExecutor:

       - Description: Executes a single task at a time. If the thread dies due to an exception, a new one replaces it.
       - Creation:
         ```
         ExecutorService executor = Executors.newSingleThreadExecutor();
         ```
    2. FixedThreadPool:

       - Description: A fixed-size thread pool. If all threads are active, tasks will wait in a queue.
       - Creation:
         ```
         ExecutorService executor = Executors.newFixedThreadPool(int nThreads);
         ```
    3. CachedThreadPool:

       - Description: A dynamic thread pool that creates new threads as needed. Old threads are reused if available; otherwise, new ones are created. Idle threads are terminated after 60 seconds.
       - Creation:
         ```
         ExecutorService executor = Executors.newCachedThreadPool();
         ```
    4. ScheduledThreadPool:

       - Description: Can schedule tasks with fixed-rate or fixed-delay execution policies.
       - Creation:
         ```
         ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(int corePoolSize);
         ```
    5. WorkStealingPool (added in Java 8):

       - Description: Based on the Fork/Join framework. It creates a pool with all available processors and uses multiple queues to reduce contention.
       - Creation:
         ```
         ExecutorService executor = Executors.newWorkStealingPool();
         ```
    6. SingleThreadScheduledExecutor:

       - Description: Similar to SingleThreadExecutor but can also schedule tasks.
       - Creation:
         ```
         ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
         ```

    To use any executor, we typically:

    - Create the executor.
    - Submit tasks for execution.
    - Manage the lifecycle (for instance, shutting down the executor after its tasks are complete).

14. Difference between shutdown() and shutdownNow() methods of executor

    1. shutdown():

       1. Description: This method initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
       2. Behavior:
          - The executor will not accept any new tasks after shutdown() has been called.
          - Tasks that are already in the queue will be executed.
          - The executor will not be truly terminated until all active tasks finish and all tasks in the queue are processed.

    2. shutdownNow():

       1. Description: This method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.
       2. Behavior:
          - It tries to halt the execution of ongoing tasks, but it doesn't guarantee that they will be halted immediately.
          - It does not start processing any tasks that are queued but not started.
          - Returns a list of tasks that were in the queue but were not processed.

15. What is Atomic classes? When do we use it?

    Atomic classes are a part of the java.util.concurrent.atomic package in Java. They provide lock-free and thread-safe operations on single variables. These operations are "atomic", meaning they're executed in a single step without the interference of other threads. Common atomic operations include get, set, getAndSet, compareAndSet, and various arithmetic operations.

    Key Atomic Classes:

    - AtomicInteger: Represents an integer value and provides atomic operations on it.
    - AtomicLong: Represents a long value with atomic operations.
    - AtomicBoolean: Represents a boolean value with atomic operations.
    - AtomicReference<V>: Provides atomic operations for a reference to an object of type V.
    - AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray: Provide atomic operations on elements of arrays.
    - AtomicMarkableReference and AtomicStampedReference: Handle two pieces of data atomically, like a reference along with a version or mark.

    Usage:
    
    We would use atomic classes in scenarios where we need to perform simple, atomic operations on a single variable in a multi-threaded environment, and we want to avoid the overhead of synchronization.

    Example:

    Imagine a scenario where we want to increment a counter in a multi-threaded setting:
    ```
    // Without Atomic classes
    private int counter = 0;

    public synchronized void increment() {
       counter++;
    }

    // With Atomic classes
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    public void atomicIncrement() {
       atomicCounter.incrementAndGet();
    }
    ```
    In the atomic example, incrementAndGet is an atomic operation, so it's inherently thread-safe without needing explicit synchronization.

    When to use it:

    - Performance-critical scenarios: Atomic classes can offer better performance than synchronization in certain scenarios because they're implemented using low-level system primitives (e.g., compare-and-swap operations).
    - Simple atomic operations: They're suitable for operations that act on a single variable. For complex operations involving multiple variables, higher-level concurrency controls (like locks) might be needed.
    - Avoiding deadlock: Since they don't use traditional locking, there's no risk of deadlocks.

    However, it's worth noting that while atomic classes provide atomicity for individual operations, they don't provide a way to execute compound operations atomically. If we need multiple operations to be executed atomically as a unit, we’d typically resort to synchronization or other concurrency mechanisms.

16. What is the cocurrent collections?

    Concurrent collections are thread-safe collection classes in Java that are designed for concurrent access, allowing you to perform non-blocking operations and achieve higher performance in multi-threaded environments. They are part of the java.util.concurrent package.

    1. ConcurrentHashMap: A thread-safe version of HashMap. It allows concurrent reads and writes without blocking the entire map.
    2. CopyOnWriteArrayList: A list designed for situations where iteration is more common than modification. It creates a copied version of the underlying array upon modification, ensuring safety during iteration.
    3. CopyOnWriteArraySet: A set based on CopyOnWriteArrayList.
    4. ConcurrentLinkedQueue: A thread-safe, non-blocking, FIFO (First-In-First-Out) queue.
    5. ConcurrentLinkedDeque: A thread-safe double-ended queue.
    6. BlockingQueue implementations like ArrayBlockingQueue, LinkedBlockingQueue, and SynchronousQueue: Thread-safe queues that provide blocking operations to wait for the queue to become non-empty when retrieving an element and to wait for space to become available in the queue when storing an element.

17. What kind of locks you know?

    1. Reentrant Lock: Allows a thread to acquire the same lock multiple times. Java's ReentrantLock class from the java.util.concurrent.locks package is an example.

    2. Spin Lock: Instead of a thread going to sleep when it can't acquire a lock, it keeps trying (spinning) until the lock is available. Useful in scenarios where the wait time is expected to be short.

    3. Read-Write Lock: Allows multiple threads to read shared data simultaneously but restricts write access to only one thread at a time. Java's ReadWriteLock interface and its implementation, ReentrantReadWriteLock, provide this functionality.

    4. Stamped Lock: Introduced in Java 8, this lock offers capabilities like optimistic reading, which can improve the performance in some scenarios compared to ReentrantReadWriteLock.

    5. Fair Lock: Ensures that threads acquire the lock in the order they requested it. The ReentrantLock class in Java can be configured to act as a fair lock.

    6. Recursive Lock: A subtype of reentrant lock, allowing a thread to acquire the same lock based on some criterion, usually a recursion depth.

    7. Shared Lock: Allows multiple threads to hold the lock at the same time, typically used for read operations.

    8. Exclusive/Binary Lock: Only one thread can hold the lock at any given time, usually used for write operations.

    9. Advisory Lock: Not enforced by the system but instead relies on all threads/processes to cooperate (often seen in database systems).

    10. Mutex (Mutual Exclusion) Lock: Ensures that only one thread can execute a specific section of code at a time.

    11. Semaphore: Not exactly a lock, but a related synchronization mechanism that controls access based on the number of available permits.

18. What is the difference between class lock and object lock?

    In Java, synchronization mechanisms are often associated with two primary entities: classes and objects. The difference between class lock and object lock pertains to which entity the lock is associated with and the scope of the lock. Here's a brief explanation:

    1. Object Lock:

       - It is tied to a particular instance of a class.
       - When a method is synchronized using an instance method (i.e., without the static keyword), the lock is taken on the current instance of the object.
       - Multiple threads can execute synchronized instance methods on different instances simultaneously because each instance has its own lock.
       - Commonly used when we need to protect the state of individual objects.
       ```
       public class MyClass {
          public synchronized void instanceMethod() {
             // body of method
          }
       }
       ```
   
    2. Class Lock:

       - It is tied to the class itself, not any particular instance.
       - When a method is synchronized using a static method, the lock is taken on the class's Class object.
       - Multiple threads cannot execute synchronized static methods on the same class simultaneously because the class itself has only one lock.
       - Commonly used when we need to protect shared resources or state that's common across all instances.
       ```
       public class MyClass {
          public static synchronized void staticMethod() {
             // body of method
          }
       }
       ```

19. What is future and completableFuture?

    1. Future:

       - Introduced in Java 5.
       - Represents the result of an asynchronous computation. This result can be obtained using the get() method.
       - The problem with Future is that it provides no way to explicitly complete the future or further process the result without blocking. We’d typically have to resort to polling or blocking with the get() method.
       - Lacks built-in capabilities for combining multiple asynchronous computations or defining a computation pipeline.
       
       ```
       ExecutorService executor = Executors.newFixedThreadPool(2);
       Future<Integer> future = executor.submit(() -> {
          return 5 + 5;
       });
       // This will block until the computation is done
       int result = future.get();
       ```
       
    2. CompletableFuture:

       - Introduced in Java 8.
       - Extends Future and implements the CompletionStage interface, providing a richer API for dealing with asynchronous computations.
       - Offers non-blocking ways to combine multiple asynchronous computations, react to their completion, or apply transformations to the result.
       - Provides methods for explicit completion (complete(), completeExceptionally()) and methods for combining multiple asynchronous computations (e.g., thenCombine, thenCompose).
       - Has support for creating asynchronous computation pipelines using methods like thenApply, thenAccept, and thenRun.

       ```
       CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
          return 5 + 5;
       }).thenApply(result -> {
          return result * 2;
       });
       
       // This will not block; the result will be processed once it's available
       completableFuture.thenAccept(finalResult -> {
          System.out.println(finalResult); // 20
       });
       ```

20. What is  ThreadLocal? 

    ThreadLocal is a Java class that provides thread-local variables. Each thread accessing a ThreadLocal variable has its own independent copy, which is not shared with other threads. This allows each thread to have its own instance of a variable, isolated from others.

    1. Purpose:

       ThreadLocal is useful when you need to store data that is specific to a particular thread, such as user sessions, database connections, or other thread-specific configurations.

    2. Isolation:

       The value stored in a ThreadLocal variable is accessible only by the specific thread that set the value. Other threads cannot see this value.

    3. Usage:

       We typically extend ThreadLocal and override the initialValue method to specify the initial value for the variable, or we can use the withInitial method since Java 8.

    4. Example:

       ```
       ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

       // In Thread 1
       threadLocal.set(42);
       int valueForThread1 = threadLocal.get();  // This will return 42

       // In Thread 2
       int valueForThread2 = threadLocal.get();  // This will return the initial value, 0
       ```
       
    5. Memory Leaks:

       If not used carefully, ThreadLocal can lead to memory leaks, especially in scenarios involving long-lived threads like those in thread pools. It's essential to remove values once they are no longer needed using the remove method.

    6. Common Use Cases:

       - Used in frameworks like Spring for transaction management.
       - Storing user sessions in web applications.
       - Handling database connection sessions in persistence frameworks.

21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading).

22. Read those interview questions and pick some important questions to this home work.

23. Write a code to create 2 threads, one thread print 1, 3, 5, 7, 9, another thread print 2, 4, 6, 8, 10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter).
No. 1 / 3
     a. One solution use synchronized and wait notify.
 
    b. One solution use ReentrantLock and await, signal.
    
24. Create 3 threads, one thread ouput 1 - 10, one thread output 11 - 20, one thread output 21 - 22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1).

25. completable future:
    
    a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.

    b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (Need to find public api to imitate).
    
    1. Sign In to Developer.BestBuy.com
    2. Best Buy Developer API Documentation (bestbuyapis.github.io)
    3. Use fake api https://jsonplaceholder.typicode.com/
    
    c. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.

