### 1.  Explain volatile variables in java? (we also use it in Singleton)
> - It will notice all threads once the value of the variabels change.
### 2.  how to create a new thread(Please also consider Thread Pool case)?
```
Thread t = new Thread(() -> System.out.println("Thread Running"));
ExecutorService executor = Executors.newFixedThreadPool(capacity);
```
### 3.  Difference between Runnable and Callable
> - Runnable doesn't return value but Callable does 
### 4.  what is the diff between t.start() and t.run()?
> - t.start() will start the thread t and run it correesponding method, t.run() will run the method within current thread.
### 5.  Which way of creating threads is better: Thread class or Runnable interface?
> - Runnable interface would be better since you can extend other class if you need
### 6.  what is the thread status?
> - NEW: A thread object is created, but not started yet
> - RUNNABLE: ready and running 
> - BLOCKED: waiting for a lock to enter a synchronized blcok/method
> - WAITING: waiting for some external trigger
> - TIMED_WAITING: similiar to the waitting, but could back within specific time.
> - TERMINATED: complete the execution adn terminated. Happened when its run method finish or by Thread.stop()
### 7. difference between wait() and sleep() method
> - wait() is used for thread synchronization and inter-thread communication, where sleep() is used to make a delay or pause in the execution of a thread.
### 8.  What is deadlock?
> - Two thread need each other's holding resources, then deadlock.
### 9.  how do threads communicate with each other?
> - notify() and wait()
### 10. what is join() method?
> - the current thread wait until the specified thread end.
### 11. what is yield() method
> - stop current executing thread and allow other waiting threads of equal priority to run
### 12. Explain thread pool
> - collection of threads. Management the resources and number threads
### 13. What is Executor Framework in Java, its different types and how to create these executors?
> - contains a bunch of components that are used to efficiently manage multiple threads.
```
ExecutorService executor = Executors.newSingleThreadExecutor();
ExecutorService executor = Executors.newFixedThreadPool(4); // Creates a pool with 4 threads
ExecutorService executor = Executors.newCachedThreadPool();
ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); // Creates a pool with 2 threads
ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
```
### 14. Difference between shutdown() and shutdownNow() methods of executor
> - shutdown() allow executor to finish any tasks that have been submitted, but does not accept ay new tasks.
> - shutdownNow(), stop all actively executing tasks abruptly.
### 15. What is Atomic classes? when do we use it?
> - provide lock-free and thread safe on a single variable. Used when multiple threads might access and modify shared variables concurrently.
### 16. What is the cocurrent collections?
> - a set of classes that support safe and efficient concurrent access by multiple threads.
### 17.  what kind of locks you know? 
> - Reentrant Lock, Read-Write Lock, Semaphore, Condition Variable
### 18. What is the difference between class lock and object lock?
> - class lock associated with class itself, used for static method and data thread sage, where object lock associated with individual instances, used for non-static method or data.
### 19. What is future and completableFuture?
> - future is an interface represent the result of an asynchronous computation, will block current thread. completableFuture can be thought of as a container that holds the result of an asynchronous operation that is being executed in a different thread, won't block other threads, and support chain operations.
### 20. what is ThreadLocal?
> - pass the variable within the thread. Thread-specific data.