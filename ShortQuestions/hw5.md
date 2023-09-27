# HW5

## 1.  Explain volatile variables in java? (we also use it in Singleton)
Any write to a volatile variable is immediately updated to main memory(program). No matter which thread you're on, reading from a votatile variable always reflects the most recent change.

## 2.  how to create a new thread(Please also consider Thread Pool case)?
- Implement Runnable and pass the instance (or lambda) to Thread constructor.
- Create user defined thread class that extends Thread class.
- Implement Callable and use Future.
- Create Executor (e.g. FixedThreadPool) and submit tasks.

## 3.  Difference between Runnable and Callable
Runnable does not return while Callable does.

## 4.  what is the diff between t.start() and t.run()?
t.start() spawns a new thread to run the code. t.run() runs the code in the current thread.

## 5.  Which way of creating threads is better: Thread class or Runnable interface?
Depends. Implementing Runnable is easier and more convenient in most cases. However by creating customized thread class we can override functions in java Thread class and add our own features. Basically it's a trade-off between easy-to-use and extensibility.

## 6.  what is the thread status?
- New: thread object is created but not started yet.
- Runnable: thread is either ready to run or running. 
- Blocked: thread is blocked by lock.
- Waiting: thread is waiting until other thread notify or join.
- Timed_waiting: similar to wating but stop waiting after a specified time_out.
- Terminated: thread has finished running.

## 7. difference between wait() and sleep() method
wait() makes the current thread wait until it's evoked by other thread (e.g. notify). Can wait forever if no time_out specified.\
sleep() pauses the current thread for a specified time. 

## 8.  What is deadlock?
In a group of threads, the lock (or resource in general) required by each thread to proceed is held by some other thread. For example, A needs lock1 to proceed and B needs lock2 to proceed, but A is holding lock2 and B is holding lock1.

## 9.  how do threads communicate with each other?
notify, notifyAll and wait

## 10. what is join() method?
Whenever the current thread calls t.join(), it pauses, waits for thread t to finish and then proceeds.

## 11. what is yield() method
It changes the status of the current thread from running to ready. It basically means that the current thread temporarily gives up the computation resource and it's okay to interrupt its execution.

## 12. Explain thread pool
Thread pool is a collection of threads that are ready to accept tasks. When a task is done, the thread will stay in the pool and wait for the next task. 

## 13. What is Executor Framework in Java, its different types and how to create these executors?
Executor consists of task queue and thread pool. When a task is submitted, the Executor puts it in the task queue and later hands it to an available thread in thread pool to run.\
Some common executors are: FixedThreadPool, CachedThreadPool, SingleThreadExecutor\
We can create them by Executors.new{ExecutorType} (e.g. Executors.newFixedThreadPool(10))

## 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() means the executor stops accepting new task. But it will finish the already submitted tasks.\
shutdownNow() stops any task immediately: running tasks are halted and waiting tasks are canceled.

## 15. What is Atomic classes? when do we use it?
Atomic classes are the thread-safe version of the original types or classes. It provides a series of operations (to update or access the variable) that are impossible to be interrupted. We usually use it when we want to achieve thread-safety without using locks.

## 16. What is the cocurrent collections?
They are the thread-safe counterpart of the original collections.

## 17.  what kind of locks you know? 
- Object
- ReentrantLock
- ReadWriteLock
- StampedLock

## 18. What is the difference between class lock and object lock?
Class lock is shared among all objects of the class. Therefore we can use class lock in static method. \
Object lock is unique to each object. 

## 19. What is future and completableFuture?
Future is a container that holds the result that may be computed and available in the future.\
CompletableFuture is an implementation of Future that supports non-blocking operations and operation chaining.

## 20. what is ThreadLocal?
ThreadLocal is a wrapper around a variable that makes it local to each thread. Each thread has its own independent ThreadLocal variable. It's similar to the concept of local variable in general in the sense that local variables in different scopes, despite having the same name, don't intefere with each other.\
It is often used to keep track of a state that is associated with each thread.
