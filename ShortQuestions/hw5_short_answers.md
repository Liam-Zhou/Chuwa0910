### 1.  Explain volatile variables in java? (we also use it in Singleton)
If a variable is declared as volatile, it ensures the changes made to the variable by one thread are visible to other threads.
It's often used in scenarios that multiple threads access a shared variables to prevent interference.

### 2.  how to create a new thread(Please also consider Thread Pool case)?
We can use 'Thread' class or implement 'Runnable' interface. When working with thread pools, we can use 'Executor'

### 3.  Difference between Runnable and Callable
Runnable doesn't have return value or throw checked exceptions. It's a functional interface used to define a task that can be executed asynchronously
in a separate thread.

Callable has return value and often used with ExecutorService to execute tasks and retrieve results.

### 4.  what is the diff between t.start() and t.run()?
t.start() is used to create a new thread and execute the run() method of the Thread object in a separate thread.
t.run() just calls the run() method on the current thread

### 5.  Which way of creating threads is better: Thread class or Runnable interface?
Implementing the Runnable interface is preferred over extending the Thread class because it has better separation of concern.

### 6.  what is the thread status?
Threads have various states, including NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED.

### 7. difference between wait() and sleep() method
wait() is used for synchronization, it causes the current thread to wait until another thread invokes notify() or 
notifyAll()
sleep() is a method provided by the Thread class and is used to pause the execution of the current thread.

### 8.  What is deadlock?
In multi-threading environment, two or more threads are waiting for the other to release a resource or a lock, so they are unable 
to proceed.

### 9.  how do threads communicate with each other?
Shared variables, synchronized methods, wait/notify mechanisms, Blacking Queue or CountDownLatch

### 10. what is join() method?
When you call join() on a thread, the current thread will block until the thread being joined has finished.

### 11. what is yield() method
The yield() method is a hint to the scheduler that the current thread is willing to yield its current execution 
in favor of other threads. It doesn't guarantee that the scheduler will switch to another thread.

### 12. Explain thread pool
A thread pool is a collection of pre-initialized threads that are ready to be used, it helps manage and reuse threads efficiently,
reducing the overhead of creating and destroying threads for each task.


### 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework in Java provides a high-level abstraction for managing and controlling the execution of 
tasks in a multi-threaded environment. For example, ThreadPoolExecutor, ScheduledExecutorService and ForkJoinPool.

### 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() shuts down the executor, allowing previously submitted tasks to complete while rejecting new tasks.
shutdownNow() stop all actively executing tasks, halts the processing of waiting tasks, and return a list of the tasks that
were waiting to be executed.

### 15. What is Atomic classes? when do we use it?
Atomic classes in Java provide atomic operations without the need for explicit synchronization. They are used in scenarious 
where you need to perform compound operations in a thread-safe manner.

### 16. What is the concurrent collections?
It's in the Java's java.util.concurrent package. They provide thread-safe operations and are optimized for concurrent access.

### 17.  what kind of locks do you know?
ReentrantLock, ReadWriteLock, StampedLock.
1. ReentrantLock: It's called "reentrant" because it allows a thread to acquire the same lock multiple times without blocking itself.
Provides method like "lock()" and "unlock()" for manual control of locking and unlocking(). Supports various lock acquisition methods, 
such as "tryLock()"
2. ReadWriteLock: It allows multiple threads to read concurrently but ensures that only one thread can write at a time, which means only one thread
can hold the exclusive write lock, ensuring exclusive access for writing. 
3. StampedLock: Support optimistic reading, allows multiple threads to read concurrently without acquiring a read lock, if a thread wants 
to write, it checks if the data has changed since the optimistic read and then acquires a read lock if needed. 

### 18. What is the difference between class lock and object lock?
Class lock(static lock) is associated with a class and is used for synchronizing static methods or code blocks. Object lock
is associated with an instance of a class and is used for synchronizing non-static methods or code block.

### 19. What is future and completableFuture?
Future is an interface used for asynchronous computations results. CompletableFuture is an implementation of Future interface 
that also allows you to manually complete the future or combine multiple future using various operations. 

### 20. what is ThreadLocal
It's a class in Java that allows you to creat thread-local variables. Each thread accessing a ThreadLocal variables get is own independent copy, 
avoiding synchronization issues in multi-threaded environment. It's often used to store thread-specific data.

### 21~25
See the coding Part