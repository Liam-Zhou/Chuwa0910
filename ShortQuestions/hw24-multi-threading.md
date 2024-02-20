# Homework 5 (hw23 - multi-threading)

## 1. Explain volatile variables in java? (we also use it in Singleton)

'Volatile' makes the variable's change updated to the main thread, to make sure every thread have the same variable state.

## 2. how to create a new thread (Please also consider Thread Pool case)?

- extends Thread Class
  - Override run() function in the MyThread Class
  - thread t = new MyThread();
  - t.start();
- implements Runnable
  - Override run() function in the MyRunnable Class
  - Thread t = new Thread(new MyRunnable());
- implements Callable
  - Override call() function in the MyCallable Class
- Thread Pool
  - ExecutorService executor = Executors.newFixedThreadPool(int);
  - executor.submit(() -> "task1");

## 3. Difference between Runnable and Callable

- runnable has no return
- callable has return

## 4. what is the diff between t.start() and t.run()?

Different Thread status, start() would go into the RUNNABLE state, while run() would actually begin the thread and go into the RUNING state.

## 5. Which way of creating threads is better: Thread class or Runnable interface?

#### Runnable Interface.

While implementing Runnable interface we can extends any other class. Hence we are able to use the benefits of Inheritance. Because of the above reasons, implementing Runnable interface approach is recommended than extending Thread class.

## 6. what is the thread status?

A thread can be in only one state at a given point in time.

- NEW
- RUNNABLE
  - ready
  - running
- BLOCKED
- WAITING
- TIMED_WAITING
- TERMINATED

## 7. difference between wait() and sleep() method

wait() releases the lock or monitor, swhile sleep() doesn't releases the lock or monitor while waiting.

## 8. What is deadlock?

It is a situation when a set of processes are blocked because each is holding a resource and waiting for another process to release another resource. And the processes cannot preempt or release the resource at that time.

## 9. how do threads communicate with each other?

- synchronization primitives like locks and semaphores
- events like wait and notify
- through shared memory

## 10. what is join() method?

t.join(): Current thread would stop and wait for thread t completes its task, then continue

## 11. what is yield() method

t.yield(): t thread is not doing anything particularly important and if any other threads or processes need to be run, they should run. Otherwise, the current thread will continue to run.

## 12. Explain thread pool

A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing.

## 13. What is Executor Framework in Java, its different types and how to create these executors?

- Executor Framework in Java:

(In all of the previous examples, there's a close connection between the task being done by a new thread, as defined by its Runnable object, and the thread itself, as defined by a Thread object. This works well for small applications) In large-scale applications, it makes sense to separate thread management and creation from the rest of the application. Objects that encapsulate these functions are known as executors.

- different types:
  - Executor - a simple interface that supports launching new tasks.
  - ExecutorService - a subinterface of Executor, which adds features that help manage the life cycle, both of the individual tasks and of the executor itself.
  - ScheduledExecutorService - a subinterface of ExecutorService, supports future and/or periodic execution of tasks.
- How to create these executors?
  If r is a Runnable object, and e is an Executor object you can replace `(new Thread(r)).start();` with `e.execute(r);`

## 14. Difference between shutdown() and shutdownNow() methods of executor

The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

## 15. What is Atomic classes? when do we use it?

The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.

To Sum up, It's an alternate way of handling concurrency where disadvantages associated with locking can be avoided.

## 16. What is the concurrent collections?

Concurrent Collections in Java, are a set of classes that allow multiple threads to access and modify a collection concurrently, without the need for explicit synchronization.

And all operations of these write threads are thread-safe, but read operations do not have to be locked. Concurrent Collections use a more complex algorithm to ensure that the entire collection is never locked, and thus have better performance during concurrent writes.

## 17. what kind of locks you know?

- ReentrantLock
- ReadWriteLock
- StampedLock

## 18. What is the difference between class lock and object lock?

- Object Level Locks: When you want non-static method or non-static block of the code should be accessed by only one thread.

- Class Level locks: When we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.

## 19. What is future and completableFuture?

## 20. what is ThreadLocal?

The ThreadLocal class in Java allows programmers to create variables that are accessible only to the thread that created them. This is useful for creating thread-safe code, as it ensures that each thread has its own copy of a variable and can not interfere with other threads.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

Done.

## 22. Read those interview questions and pick some important questions to this homework.

#### Q1. What are the benefits of using Multithreading?

- Allow the program to run continuously even if a part of it is blocked.
- Improve performance as compared to traditional parallel programs that use multiple processes.
- Improves the responsiveness of complex applications or programs.
- Increase use of CPU resources and reduce costs of maintenance.
- Saves time and parallelism tasks.
- If an exception occurs in a single thread, it will not affect other threads as threads are independent.

#### Q2: What's the difference between thread and process?

Thread: It simply refers to the smallest units of the particular process. It has the ability to execute different parts (referred to as thread) of the program at the same time.

Process: It simply refers to a program that is in execution i.e., an active program. A process can be handled using PCB (Process Control Block).

#### Q3: What is daemon thread and how to create one?

JVM does not wait for daemon threads to finish their tasks before termination. To create daemon threads in java using the thread class setDaemon(true).

#### Q4: What’s the difference between notify() and notifyAll()?

notify(): It sends a notification and wakes up only a single thread instead of multiple threads that are waiting on the object’s monitor.

notifyAll(): It sends notifications and wakes up all threads and allows them to compete for the object's monitor instead of a single thread.

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.

(solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

Presented in the Coding folder

25. completable future:

- a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
- b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找 public api 去模拟，)
  - i. Sign In to Developer.BestBuy.com
  - ii. Best Buy Developer API Documentation
    (bestbuyapis.github.io)
  - iii. 可以用 fake api https://jsonplaceholder.typicode.com/
- c. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.
