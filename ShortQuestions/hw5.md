### 1. Volatile variables in Java
The volatile keyword in Java is used to mark a variable as being stored in main memory. It ensures changes made by one thread to a shared variable are immediately made visible to other threads. This provides a guarantee about the visibility of variables.
In the Singleton pattern, volatile is often used to ensure that multiple threads handle the singleton instance correctly.

### 2. Create a new thread (including Thread Pool)
Using Thread class:

java

Thread thread = new Thread(() -> System.out.println("Running a new thread!"));
thread.start();
Using ExecutorService for Thread Pool:

java

ExecutorService executor = Executors.newFixedThreadPool(10); // pool of 10 threads
executor.execute(() -> System.out.println("Running thread from pool!"));
executor.shutdown();
### 3. Difference between Runnable and Callable
Runnable: Represents a task which can be executed asynchronously. It has a run method which does not return a result.

Callable: Represents a task that can be executed asynchronously. It has a call method which returns a result.

### 4. Difference between t.start() and t.run()
t.start(): Creates a new thread and runs the code in the thread's run method.
t.run(): Just calls the run method in the same thread without starting a new thread.
### 5. Which way of creating threads is better: Thread class or Runnable interface?
Using the Runnable interface is generally preferable because it allows the class to extend another class (Java doesn’t support multiple inheritance). It provides better separation of the thread code and the task code.

### 6. Thread Status
Threads can be in one of the following states:

NEW: The thread has been created but has not started.
RUNNABLE: The thread is running or ready to run.
BLOCKED: The thread is waiting to obtain a lock.
WAITING: The thread is waiting indefinitely for another thread to perform a particular action.
TIMED_WAITING: The thread is waiting for another thread to perform an action for up to a specified waiting time.
TERMINATED: The thread has completed execution.
### 7. Difference between wait() and sleep()
wait(): Causes the current thread to wait until another thread invokes the notify() or notifyAll() method for the same object. It's called on an object, not a thread.
sleep(): Causes the current thread to suspend execution for a specified period. It always affects the current thread.
### 8. Deadlock
A deadlock occurs when two or more threads are blocked forever, each waiting for the other to release a lock.

### 9. Threads communication
Threads can communicate with each other using methods like wait(), notify(), and notifyAll().

### 10. join() method
The join() method allows one thread to wait for the completion of another thread.

### 11. yield() method
The yield() method causes the currently executing thread to temporarily pause and allow other threads to execute.

### 12. Thread Pool
A thread pool is a collection of pre-initialized threads. It's a way to manage the number of threads used by a system. Thread pools can improve performance by managing a set number of threads that can be reused for multiple tasks.

### 13. Executor Framework in Java
The Executor Framework is a framework that provides a higher-level replacement for the traditional way of managing threads in Java. It provides a pool of threads that can be used to execute tasks concurrently.
Types:

FixedThreadPool
CachedThreadPool
ScheduledThreadPool
SingleThreadExecutor
### 14. Difference between shutdown() and shutdownNow()
shutdown(): Initiates a graceful shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
shutdownNow(): Attempts to stop all actively executing tasks and halts the processing of waiting tasks.
### 15. Atomic Classes
Atomic classes, like AtomicInteger or AtomicReference, support lock-free thread-safe programming on single variables. They can be used when you need to change a single variable frequently and require it to be thread-safe.

### 16. Concurrent Collections
Concurrent Collections like ConcurrentHashMap, CopyOnWriteArrayList are thread-safe collections that provide better scalability and performance compared to synchronized collections.

### 17. Types of Locks
ReentrantLock
ReadWriteLock: ReadLock and WriteLock
StampedLock

### 18. Difference between class lock and object lock
Class Lock: Lock on the class itself. It locks static methods or blocks and is held on the Class object associated with the class.

Object Lock: Lock on an instance of the class. It locks instance methods or blocks and is held on the specific instance of the object.

### 19. Future and CompletableFuture
Future: Represents a result of an asynchronous computation. You can retrieve the result using the get() method, but this method blocks until the computation is done.

CompletableFuture: An enhancement over Future that provides methods to combine multiple asynchronous computations, handle exceptions, and do further processing or action upon completion of the computation.

### 20. ThreadLocal
ThreadLocal is a class that provides thread-local variables. Each thread accessing a ThreadLocal variable has its own independent copy, which is not shared with other threads. It's useful when you want to store data that is specific to a particular thread.
