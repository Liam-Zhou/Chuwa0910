##  1. Explain volatile variables in java? (we also use it in Singleton)

    Volatile variables in Java are variables that can be changed by multiple threads at the same time. When a volatile variable is changed, all threads that are reading the variable will see the change immediately. This is in contrast to non-volatile variables, where the changes may not be visible to other threads immediately.
  
    Volatile variables are often used in multithreaded applications to ensure that all threads are using the same data. For example, a volatile variable could be used to store the current state of a Singleton object. This would ensure that all threads are always using the same instance of the Singleton object,
  	 even if the Singleton object is being created or destroyed by another thread.

## 2. How to create a new thread(Please also consider Thread Pool case)?

   You can create a new thread in Java by extending the Thread class or implementing the Runnable interface. Here's an example using both methods:
   
   * Using Thread class:

   ```Java
    class MyThread extends Thread {
			public void run() {
				// Code to be executed in the new thread
			}
		}

		// Create and start the thread
		MyThread myThread = new MyThread();
		myThread.start();
   ```

   * Using Runnable interface:

```Java
class MyRunnable implements Runnable { public void run() {
   // Code to be executed in the new thread } }
		  
		  // Create a Runnable object and a thread MyRunnable myRunnable = new
		  MyRunnable(); Thread thread = new Thread(myRunnable);
		  
		  // Start the thread thread.start();
```
## 3. Difference between Runnable and Callable

Runnable is a functional interface introduced in Java for creating threads. It represents a task that can be executed asynchronously.
Callable is also a functional interface, introduced in Java 5, similar to Runnable, but it can return a result and throw exceptions.

A Runnable does not return a result or throw checked exceptions directly; you need to handle exceptions within the run method.
A Callable returns a Future object representing the result of the computation and can throw checked exceptions.

## 4.	What is the diff between t.start() and t.run()?

t.start() is used to start a new thread of execution and invokes the run method on that thread asynchronously.

t.run() simply calls the run method on the current thread without creating a new thread. It runs the run method in the same thread, so it's a synchronous call.

## 5.	Which way of creating threads is better: Thread class or Runnable interface?

It is generally better to use the Runnable interface to create new threads. This is because the Runnable interface is more flexible and allows you to create threads that can return a value.

However, there are some cases where it may be necessary to extend the Thread class. For example, if you need to override a method that is specific to the Thread class, such as the start() method.

## 6.	What is the thread status?

A thread can be in one of the following states:

* New: The thread has been created but has not yet been started.
* Runnable: The thread is ready to run.
* Running: The thread is currently executing code.
* Blocked: The thread is waiting for a resource to become available.
* Waiting: The thread is waiting for another thread to notify it.
* Terminated: The thread has finished executing and has been destroyed.
  
You can use the getState() method to get the current state of a thread.

## 7.	Difference between wait() and sleep() method:

wait() is a method of the Object class and is used for synchronization. It releases the lock on the object and puts the calling thread in a waiting state until another thread notifies it.
sleep() is a method of the Thread class and is used for making a thread pause for a specified amount of time. It doesn't release any locks and is not related to synchronization.

## 8.	What is deadlock?

Deadlock is a situation in multithreading where two or more threads are unable to proceed because each is waiting for the other to release a resource. It's a state in which no progress can be made because the threads are effectively stuck.

## 9.	How do threads communicate with each other?
Thread Communication:
Threads can communicate with each other using mechanisms like wait(), notify(), notifyAll(), and join(). These methods allow threads to coordinate and synchronize their activities.

## 10.	What is join() method?

join() Method:
The join() method is used to wait for a thread to finish its execution. When one thread calls join() on another thread, it will block until the thread being joined has completed.

## 11.	What is yield() method

yield() Method:
The yield() method is used to hint to the scheduler that the current thread is willing to yield its current execution time to allow other threads to run. However, it doesn't guarantee that the thread will yield; it depends on the thread scheduler.

## 12. Explain thread Pool:
A thread pool is a managed group of threads that are available for performing tasks concurrently. It helps in reusing threads and managing their lifecycle efficiently. Java provides the Executor framework to work with thread pools.

## 13. What is Executor Framework in Java, its different types and how to create these executors?:
The Executor framework in Java provides a higher-level replacement for managing threads and thread pools. It abstracts the creation, management, and execution of threads. You can create various types of executors like ThreadPoolExecutor, ScheduledExecutorService, and more using factory methods in the Executors class.

## 14.	Difference between shutdown() and shutdownNow() methods of executor

shutdown(): Initiates an orderly shutdown of the executor, allowing previously submitted tasks to complete but not accepting new tasks. It doesn't forcefully terminate running tasks.
shutdownNow(): Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

## 15.	What is Atomic classes? when do we use it?
Atomic classes in Java, like AtomicInteger and AtomicBoolean, provide atomic operations on variables without the need for explicit synchronization. They are used when you need to perform atomic (indivisible) operations in a multithreaded environment.

## 16.	What is the cocurrent collections?
Concurrent collections are thread-safe collections introduced in Java to support concurrent access by multiple threads without the need for explicit synchronization. Examples include ConcurrentHashMap and ConcurrentLinkedQueue.

## 17.	What kind of locks you know? 
There are various types of locks in Java, including:

* synchronized blocks/methods
* ReentrantLock
* ReadLock and WriteLock in ReadWriteLock
* StampedLock

## 18.	What is the difference between class lock and object lock?

Class Lock: It's a lock on the class itself, ensuring that only one thread at a time can execute static synchronized methods of that class.
Object Lock: It's a lock on an instance of the class, ensuring that only one thread at a time can execute synchronized methods of that instance.


## 19.	What is future and completableFuture?

Future is a placeholder for a result that will be available in the future. It represents the result of an asynchronous computation.
CompletableFuture is a more flexible and feature-rich implementation of Future. It allows you to compose multiple asynchronous operations and handle exceptions and timeouts more effectively.

## 20.	What is ThreadLocal?
ThreadLocal is a class in Java that provides thread-local variables. Each thread accessing a ThreadLocal variable has its own independent copy of that variable, isolated from other threads. It's often used for storing thread-specific data.

## 22. Read those interview questions and pick some important question to this homework
   * how many ways can we create a thread for a task?
     new Thread(new Task("name"))
     es.submit( new Task("name"))
   * what is the main difference between synchronized reentrantLock?
     The main difference between synchronized and ReentrantLock is that ReentrantLock provides more functionality and control. Synchronized is a keyword that can be used to lock a block of code or an entire object. ReentrantLock is a class that implements the Lock interface. 
