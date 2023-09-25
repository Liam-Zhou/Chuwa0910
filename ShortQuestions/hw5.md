1.
A volatile variable in Java is used to indicate that a variable's value will be modified by different threads.

2.
1). Extending the Thread Class
2).Implementing the Runnable Interface
3). thread pool

3.
A callable interface throws the checked exception and returns the result. A runnable interface, does not return a result and cannot throw a checked exception

4.
invoke the start() method on a Thread object, a new thread of execution is started, and the run() method of that object is called in the new thread.
Invoking the run() method directly just executes the run() method in the current thread, not in a new thread

5.
Runnable interface is preferable over extending the Thread class as it provides better separation of concerns, allows for greater flexibility, and fits better with modern Java concurrency practices.

6.
runnable, blocked, waiting,timed_waiting, terminated

7.
wait() releases the lock or monitor while sleep() doesn't releases the lock or monitor while waiting

8.
A deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process. 

9.
Shared Variables, Wait and Notify Mechanism, Blocking Queues


10.
The join() method is used in Java to wait for a thread to die (complete its execution). This method is called on a thread object and will block the calling thread until the referred thread terminates.

11.
Yield method can stop the currently executing thread and will give a chance to other waiting threads of the same priority

12.
A thread pool is a collection of worker threads that efficiently execute asynchronous tasks on behalf of the application. Thread pools manage a pool of worker threads, the scheduling of tasks, and the execution of these tasks

13.
The Executor Framework is a framework provided by Java that allows developers to manage and control thread execution in concurrent applications. 
Executor:
Executor executor = Executors.newSingleThreadExecutor();
executor.execute(new Runnable() {
    public void run() {
        System.out.println("Task is running.");
    }
});

ExecutorService:
ExecutorService executorService = Executors.newFixedThreadPool(5);
executorService.execute(new Runnable() {
    public void run() {
        System.out.println("Task is running.");
    }
});
executorService.shutdown();
CompletionService:
ExecutorService executorService = Executors.newFixedThreadPool(5);
CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

completionService.submit(new Callable<String>() {
    public String call() {
        return "Task result";
    }
});
try {
    Future<String> futureResult = completionService.take();
    String result = futureResult.get();
    System.out.println(result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

executorService.shutdown();

14.
The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.
15.
The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.

16.
Collections are designed for high-performance and scalable concurrent access, allowing multiple threads to safely access and modify the collection concurrently without explicit synchronization.

17.
Read-Write Locks, ReentrantLock, Stamped lock

18.
Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. 
Class Level locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime

19.
CompletableFuture is an extension to Java's Future API which was introduced in Java 5. A Future is used as a reference to the result of an asynchronous computation

20.
ThreadLocal is a utility class in Java used to create thread-local variables. Each thread accessing a variable via a ThreadLocal has its own independent copy, which is not shared with other threads

23.


