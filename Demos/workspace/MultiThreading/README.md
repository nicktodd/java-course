# Java Multithreading Demos

A comprehensive set of Java threading demos organised by topic and Java version,
covering everything from Java 5 fundamentals through to Java 21 virtual threads
and structured concurrency.

---

## Package Structure

```
com.conygre.threading/
├── basics/               Thread creation, interruption, uncaught exceptions
├── synchronization/      synchronized, volatile, wait/notifyAll
├── atomic/               java.util.concurrent.atomic package
├── locks/                ReentrantLock, ReadWriteLock, StampedLock
├── executors/            ExecutorService, Callable, Future, CompletionService
├── completablefuture/    CompletableFuture pipeline and combinators
├── concurrent/           CountDownLatch, CyclicBarrier, Phaser, Semaphore
├── queues/               BlockingQueue, SynchronousQueue
├── forkjoin/             ForkJoinPool, RecursiveTask, RecursiveAction
├── virtualthreads/       Virtual Threads (Java 21)
├── structured/           Structured Concurrency (Java 21 preview / Java 25)
└── patterns/             Thread-safe Singleton patterns
```

---

## Recommended Learning Path

Work through the packages in order. Each builds on concepts from the previous one.

### Foundations (Java 5 and earlier)

| File | Concept |
|------|---------|
| `basics/RunnableDemo.java` | Creating threads with Runnable and lambdas |
| `basics/LegacyThreadSubclassDemo.java` | Subclassing Thread — historical reference, not recommended |
| `basics/InterruptionDemo.java` | Cooperative thread interruption |
| `basics/UncaughtExceptionDemo.java` | Handling unhandled exceptions in threads |
| `synchronization/SynchronizedDemo.java` | Race conditions and the synchronized keyword |
| `synchronization/VolatileDemo.java` | Visibility problems and the volatile keyword |
| `synchronization/WaitNotifyDemo.java` | wait()/notifyAll() for thread coordination |

### Java 5 — java.util.concurrent (The Big Leap)

| File | Concept |
|------|---------|
| `atomic/AtomicCounterDemo.java` | Lock-free atomic operations (CAS) |
| `locks/ReentrantLockDemo.java` | Explicit locking with tryLock, Condition |
| `locks/ReadWriteLockDemo.java` | Concurrent reads with exclusive writes |
| `executors/ExecutorServiceDemo.java` | Thread pools and the Executor framework |
| `executors/CallableAndFutureDemo.java` | Tasks with return values, invokeAll, invokeAny |
| `executors/CompletionServiceDemo.java` | Process results in completion order |
| `concurrent/CountDownLatchDemo.java` | One-shot starting/end gates |
| `concurrent/CyclicBarrierDemo.java` | Reusable multi-phase barriers |
| `concurrent/SemaphoreDemo.java` | Limiting concurrent access to resources |
| `queues/BlockingQueueDemo.java` | Thread-safe producer-consumer with BlockingQueue |
| `queues/SynchronousQueueDemo.java` | Zero-capacity direct handoff channel |
| `patterns/SingletonDemo.java` | Thread-safe Singleton implementations |

### Java 7–8 — Performance and Expressiveness

| File | Concept |
|------|---------|
| `concurrent/PhaserDemo.java` | Dynamic barrier registration (Java 7) |
| `locks/StampedLockDemo.java` | Optimistic reads for read-heavy workloads (Java 8) |
| `forkjoin/ForkJoinDemo.java` | Divide-and-conquer parallelism (Java 7+) |
| `completablefuture/CompletableFutureDemo.java` | Async pipelines and combinators (Java 8) |

### Java 21 — Project Loom (Modern High-Concurrency)

| File | Concept | Java Version |
|------|---------|--------------|
| `virtualthreads/VirtualThreadsDemo.java` | Lightweight virtual threads | Java 21 |
| `structured/StructuredConcurrencyDemo.java` | Scoped subtask lifecycle management | Java 21 preview / Java 25 |

---

## Java Version Requirements

| Package | Minimum Java Version |
|---------|----------------------|
| basics, synchronization, atomic | Java 5 |
| locks, executors, concurrent, queues, patterns | Java 5 |
| forkjoin | Java 7 |
| locks/StampedLockDemo | Java 8 |
| completablefuture | Java 8 |
| virtualthreads | **Java 21** |
| structured | **Java 21** (`--enable-preview`) or **Java 25** |

---

## Compilation Notes

### Standard demos (Java 8+)
```bash
javac -d out src/com/conygre/threading/**/*.java
java -cp out com.conygre.threading.basics.RunnableDemo
```

### Virtual threads (Java 21+)
```bash
javac --release 21 -d out com/conygre/threading/virtualthreads/VirtualThreadsDemo.java
java -cp out com.conygre.threading.virtualthreads.VirtualThreadsDemo
```

### Structured concurrency (Java 21 with preview)
```bash
javac --enable-preview --release 21 -d out com/conygre/threading/structured/StructuredConcurrencyDemo.java
java --enable-preview -cp out com.conygre.threading.structured.StructuredConcurrencyDemo
```

---

## Key Concepts Summary

### Choosing the right tool

| Scenario | Recommended approach |
|----------|---------------------|
| Simple background task | `Thread.ofVirtual().start(...)` (Java 21) or `ExecutorService` |
| Task with a return value | `Callable` + `Future` or `CompletableFuture.supplyAsync()` |
| Many independent async tasks | `CompletableFuture` pipeline or virtual threads |
| Related tasks that should fail together | `StructuredTaskScope.ShutdownOnFailure` |
| First-result-wins (hedged requests) | `StructuredTaskScope.ShutdownOnSuccess` |
| CPU-bound parallel computation | `ForkJoinPool` or parallel streams |
| Shared mutable state (simple) | `synchronized` or `AtomicInteger` |
| Shared mutable state (complex) | `ReentrantLock` with `Condition` |
| Read-heavy shared data structure | `ReentrantReadWriteLock` or `StampedLock` |
| Limit concurrent resource access | `Semaphore` |
| Coordinate a group of threads | `CountDownLatch`, `CyclicBarrier`, or `Phaser` |
| Thread-safe producer-consumer | `BlockingQueue` |
| Direct thread-to-thread handoff | `SynchronousQueue` |

### Evolution timeline

```
Java 1.0  Thread, Runnable, synchronized, wait/notify
Java 5    java.util.concurrent: ExecutorService, Callable, Future,
          Lock, AtomicInteger, BlockingQueue, CountDownLatch, CyclicBarrier, Semaphore
Java 7    ForkJoinPool, Phaser, TransferQueue
Java 8    StampedLock, CompletableFuture, parallel streams
Java 9    Flow API (reactive streams)
Java 21   Virtual Threads (JEP 444), StructuredTaskScope preview (JEP 453)
Java 25   StructuredTaskScope finalised
```
