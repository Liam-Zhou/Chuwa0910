1:Explain volatile variables in java? (we also use it in Singleton)
```text
volatile is a keyword in Java which is used as an indicator to Java compiler and Thread that do not cache value of this variable and always read it from main memory. So basically it is used to prevent threads from caching variables.
```

2:how to create a new thread
```java
public class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread running");
    }
}
```
```java
public class ThreadPoolExample {
public static void main(String[] args) {
// Create a thread pool with 3 threads
ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new Task(i);
            executor.submit(task);
        }

        // Shutdown the thread pool when all tasks are done
        executor.shutdown();
    }
}
```
3: Difference between Runnable and Callable
```text
Runnable is an interface that is implemented by a class to be executed by a thread. It contains only one method run() that is called by the thread when it starts.
Callable is an interface that is implemented by a class whose instances are to be executed by an Executor. It contains only one method call() that returns a result.
```

4: what is the difference between t.start and t.run
```text
t.start() will create a new thread and call the run() method in the new thread.
t.run() will not create any new thread and call the run() method in the current thread.
```

5:  Which way of creating threads is better: Thread class or Runnable interface?
```text
The Runnable interface should be preferred over the Thread class because Java doesn’t support multiple inheritance. If you use the Thread class, you can’t extend any other class.
```
6: what is the thread status
```text
New: A thread that has not yet started is in this state.
Runnable: A thread executing in the Java virtual machine is in this state.
Blocked: A thread that is blocked waiting for a monitor lock is in this state.
Waiting: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
Timed Waiting: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
Terminated: A thread that has exited is in this state.
```
7: What is the difference between sleep() and wait()?
```text
sleep() is a static method of Thread class used to sleep a thread for specified amount of time. wait() is a non static method of Object class used to pause the thread until another thread completes its execution.
```

8: what is the deadlock
```text
Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
```

9: how do threads communicate with each other
```text
concurrent data structures
```

10: what is join
```text
The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.
```

11: what is yield() method
```text
The yield() method causes the currently executing thread object to temporarily pause and allow other threads to execute.
```

12: Explain thread pool
```text
A thread pool is a collection of threads that can be reused. In a thread pool, threads are created in advance and are put into the pool for later use. When a task is submitted, a thread is taken from the pool, and the task is executed. When the task is completed, the thread is returned to the pool and is available for another task.
```

13: what is Executor Framework in Java, its different type and how to create these exectuors
```text
Executor is an interface that is used to execute the submitted task in a different thread. ExecutorService is a subinterface of Executor. It is used to manage the thread pool. Executors is a utility class that provides factory methods to create different kinds of ExecutorService implementations.
```

14: Different between shutdown and shutdownNow
```text
shutdown() method doesn’t force the executor to shutdown immediately. It will wait until all running threads are finished their tasks. shutdownNow() method forces the executor to shutdown immediately. It will interrupt all running threads and stop the executor.
```

15: What is Atomic variable
```text
Atomic variables are used in concurrent programming to avoid data inconsistency issues caused by multithreading. Atomic variables are thread safe and they are used to implement lock-free algorithms.
```

16: what is concurrent collections
```text
Concurrent collections are thread-safe collections. They are used in concurrent programming to avoid data inconsistency issues caused by multithreading.
```

17: What kind of locks you know
```text
ReentrantLock
ReentrantReadWriteLock
```

18: What is the difference between class lock and object lock
```text
Class lock is used to synchronize static methods of a class. Object lock is used to synchronize instance methods and blocks.
```

19: What is future and completeable future
```text
Future is an interface that represents the result of an asynchronous computation. CompletableFuture is a class that implements Future and CompletionStage interfaces. It is used to perform asynchronous operations and wait for them to complete.
```


20: what is threadlocal
```text
ThreadLocal is a class that provides thread-local variables. It is used to create thread-local variables that are accessible only to the current thread.
```





