# Homework 5 (hw24 - multi-threading)

## 1. Explain volatile variables in java? (we also use it in Singleton)

## 2. how to create a new thread (Please also consider Thread Pool case)?

## 3. Difference between Runnable and Callable

- runnable has no return
- callable has return

## 4. what is the diff between t.start() and t.run()?

## 5. Which way of creating threads is better: Thread class or Runnable interface?

## 6. what is the thread status?

## 7. difference between wait() and sleep() method

## 8. What is deadlock?

It is a situation when a set of processes are blocked because each is holding a resource and waiting for another process to release another resource. And the processes cannot preempt or release the resource at that time.

## 9. how do threads communicate with each other?

## 10. what is join() method?

## 11. what is yield() method

## 12. Explain thread pool

## 13. What is Executor Framework in Java, its different types and how to create these executors?

## 14. Difference between shutdown() and shutdownNow() methods of executor

## 15. What is Atomic classes? when do we use it?

## 16. What is the cocurrent collections?

## 17. what kind of locks you know?

- ReentrantLock
- ReadWriteLock
- StampedLock

## 18. What is the difference between class lock and object lock?

## 19. What is future and completableFuture?

## 20. what is ThreadLocal?

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

Done.

## 22. Read those interview questions and pick some important questions to this homework.

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.

(solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
