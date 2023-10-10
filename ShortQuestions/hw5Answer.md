### 1. Explain volatile variables in java? (we also use it in Singleton) 
	
 applied to variables, meaning that this variable may be changed by multiple threads simultaneously.  
 Changes made to volatile variable by one thread are immediately visible to other threads. 
 
### 2. how to create a new thread(Please also consider Thread Pool case)? 

Extends thread class: 
```java
public class MyThread extends Thread{
  @Override
  public void run(){
    System.out.println("start new thread using extends thread");
  }
}

Thread t = new MyThread();
t.start()
```

Implements Runnable:
```java
public class MyRunnable implements Runnable{
  @Override
  public void run(){
    System.out.println("Start new thread using Runnable");
  }
}

Thread t2 = new Thread(new MyRunnable());
```

### 3. Difference between Runnable and Callable

Runnable method does not return a result. It cannot throw any compile time exceptions;
Callable can return a result. It can throw both compile and run time exceptions.

### 4. What is the diff between t.start() and t.run()? 

t.start() will create a new thread and then call the run method in this new thread.
t.run() is directly execute in the current thread, the code in the block wouldn't run
concurrently.

### 5. Which way of creating threads is better: Thread class or Runnable interface?

Creating thread from Runnable interface is better. It's more flexible because 
Runnable is an interface, so a class can implement other interface along with Runnable.
Also, if you're creating multiple threads, creating a new Thread object for each thread is way too much.
But for runnable, you can pass the same instance the multiple Thread objects. 

### 6. What is the thread status? 
Thread status is the lifecycle of a thread, it includes:
new: thread created but not used start(). Runnable: when start() is called, waiting to
be used by the CPU. Blocked: thread is locked by lock. Waiting: wait for the execution 
of other threads. Terminated: thread task completed.

### 7. Difference between wait() and sleep() method.
wait() is used in the synchronized block to allow threads collaborations, you can set some conditions
of the wait and unlock them when you want to.
sleep() is a hard dead pause. The thread will sleep for the time you set, you can't wake them up.

### 8. What is deadlock()
deadlock is when multiple threads are blocked forever, waiting for others to release their locks.
if one thread posses the exclusive resource that the other thread need, but it won't release it, and the other
thread has what it need and don't release it as well, a deadlock() is formed.

### 9. how does thread communicate with each other?
1. Using shared variables in the synchronized block.
2. Wait() will let current thread pause until the other thread call the notify() or notifyAll() method.
3. different locks to control the access to the resource, like semaphore, reetrantlock();

### 10. what is join() method?
It allows one thread to wait until another thread completes its task.
for example, say if you have two threads, t1 and t2; in the following code,
```java
t1.start();
t1.join();
t2.start();
```
t2 will start only after t1 is finished.

### 11. what is yield() method?
When a thread call the yield method, it gives up the use of the processor. 
Another waiting thread will run, when the other thread finishes, current thread will run continuely.

### 12. What is thread pool?
Thread pool is a collection of existing threads ready to execute tasks. This avoid the resource
used in creating too much threads. They're stored in the task queue, and worker threads could be
initialized to execute the tasks.
Below are three workers threads initialized by the executor.

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(task1);
executor.submit(task2);
executor.submit(task3);
```

### 13. What is Executor Framework in Java, its different types and how to create these executors? 
Executor is a high level thread managing interface. There are single or multiple threads executors 
like shown above, or like sheduled executor to run after delay. Creations of executors are like the
above code.

### 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() shuts tasks down in the order of submission and allow the incoming tasks to finish.
shutdownNow() will pause all the active case, it's a aggresive hard shut down.

### 15. What is Atomic classes? when do we use it?
Atomic class alows you to create synchronized variable for mulithreading concurrent tasks
without using the synchronized block.

### 16. What is the cocurrent collections?
They are concurrent thread-safe collections(just like arraylist, hashmap, queue, etc..)
but they're used for multithread tasks.

### 17. what kind of locks do you know?
ReetrantLock: a thread acuqiring and releasing the the same lock it possessed for multiple times. 
It's like a more advanced version of synchronized block. You can customized stuff like a counter variables
in it's try and finally(unlock) block.
ReadWriteLock: allow only one thread to write at a time, and multiple threads reading concurrently.
StampedLock: allowing read and write opperations and the same time, but it might cause data inconsistency.

### 18. Ojbect lock vs Class Lock:
very simple. Object lock is used for non static method, and class lock is used for static method.

### 19. Future and CompletableFuture:
Used in Callable, Future represents the result of an asynchronous computation. Whenever we submit a Callable task,
a Future object is obtained, and we can use it to check the completion status of this thread's task.

CompletableFuture is a stronger version of Future, it supports the chaining operations for easy combination and management 
of multiple asynchronus tasks. 

### 20. ThreadLocal
This class would create variable that's only accessed by its local thread. Even if two different
threads are accessing the same local variable, it's value would be different for the two threads.

### 21.
