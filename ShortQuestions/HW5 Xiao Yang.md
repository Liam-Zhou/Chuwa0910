# HW5 Xiao Yang

### 1.  Explain volatile variables in Java(we also use it in Singleton)

`volatile` is a keyword to indicate those variables may be modified by multiple threads simultaneously. by applying `volatile` , once the variables changed, all of the threads would get the updated value of it.

### 2.  How to create a new thread

- Extend `Thread` class
 ```java
class MyThread extends Thread{
  public void run(){...};
  public static void main(String[] args){
    	MyThread t = new MyThread();
    	t.start();
  }
}

 ```

- Implements `Runnable` interface

  ```java
  class MyThread implements Runnable{
    public void run(){...};
    
    public static void main(String[] args){
      Thread t = new Thread(new MyThread());
      t.start();
    }
  }
  ```

  ​

- Implements `Callable` interface

  ```java
  class MyThread implements Callable{
    public <T> call(){
      return ...;
    }
    public static void main(String[] args){
      Thread t = new Thread(new MyThread());
      t.start();
    }
  }
  ```

  ​

- Use Thread Pool

  ```java
  ExecutorService executor = Executors.newFixedThreadPool(size);
  executor.submit(()->{});
  ```

  ​

### 3. Difference between Runnable and Callable

There is no return value for run() method in Runnable interface, while you can define your own return for overriding Call() if implements Callable. 

### 4. Difference between t.start() and t.run()

t.start() will use the new create thread t to execute run(), but t.run() will make current thread to execute run() directly.

### 5. Which way of creating threads is better? Thread class or Runnable interface?

Runnable interface is better, because when you extends Thread class, there is no way to extend other classes which are required, while apart from implements Runnable, it can be implements other interfaces when needed. So Implements Runnable interface is more scalable.

### 6. What is thread status?

A thread can be in one of the following states:
- **_NEW_** : 
A thread that has not yet started is in this state.
- **_RUNNABLE_**:
A thread executing in the Java virtual machine is in this state.
- **_BLOCKED_** :
A thread that is blocked waiting for a monitor lock is in this state.
- _**WAITING**_ :
A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
- _**TIMED_WAITING**_ :
A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
- _**TERMINATED**_ :
A thread that has exited is in this state.

A thread can be in only one state at a given point in time. These states are virtual machine states which do not reflect any operating system thread states.



### 7. What is deadlock?
Deadlock is a situation where a set of processes(Threads) are blocked because each process is holding a resource(lock) and waiting for another resource acquired by some other process.
### 8. Difference between wait() and sleep()
`wait()` will release the lock while `sleep()` will keep the lock and block.

### 9. How do threads communicate with each other?
Use `object.wait()` to release lock to other threads, and turn status from Runnable to Waiting.
use `object.notifyAll()` to broadcast, and turn status from Waiting to Runnable.

### 10. What is join() method?
`join()` used to allows one thread to wait until another thread completes its execution
### 11. What is yield() method?
`yield()` used to stop the currently executing thread and will give a chance to other waiting threads of the same priority.
### 12. Explain thread pool
A Thread Pool is a collection of worker threads that efficiently execute asynchronous callbacks on behalf of the application.
### 13. What is Executor Framework in Java, its different types and how to create these executor
Executor Framework is used to run the Runnable objects without creating new threads every time and mostly re-using the already created threads.
```java
ExecutorService fixedPool = Executors.newFixedThreadPool(2);
fixedPool.submit(()->{...});
```
- **_SingleThreadExecutor_** : This executor has only one thread and is used to execute tasks in a sequential manner. If any thread dies due to an exception while executing the task, a new thread is created to replace the old thread and the subsequent tasks are executed in the new thread.
- **_FixedPoolExecutor_** : This is a pool of a fixed number of threads. The tasks submitted to the executor are executed by the “n” threads and suppose if there is more task to finish, they are stored on a LinkedBlockingQueue.
- **_CachedThreadExecutor_** : This is mainly used when there are lots of short-lived parallel tasks on the line waiting to be executed. When compared with the fixed thread pool, here, the number of threads of this executor pool is not bounded. If all the threads are busy executing the assigned tasks and when there is a new task, it will create and add a new thread to the executor. If a thread remains idle for close to sixty seconds, they are terminated and removed from the cache.
- **_ScheduledExecutor_** : This executor is used when you have a task that needs to be run at regular intervals or if in case you wish to delay a certain task. The tasks can be scheduled in ScheduledExecutor using either of the two methods `scheduleAtFixedRate` or `scheduleWithFixedDelay`.
### 14. Difference between shutdown() and shutdownNow()
`shutdown()` will allow previously submitted tasks to execute before terminating, while `shutdownNow(`) prevents waiting tasks from starting and attempts to stop currently executing tasks.
### 15. What is Atomic classes? When do we use it?
The Atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations.
All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.
### 16. What is cocurrent collections?
Concurrent collections refer to a set of classes that allow multiple threads to access and modify a collection concurrently, without the need for explicit synchronization.
### 17. What kind of locks do you know?

### 18. What is the difference between class lock and object lock?

### 19. What is future and completableFuture?

### 20. What is ThreadLocal?

### 21. Read those interview questions and pick some important questions to this homework.

### 22. Completable Future:


