## Chapter 19: Multithreading

### The Aims

In this exercise you will create applications that work with multiple threads. You will then extend the example to take advantage of synchronization, and finish with a short introduction to the more modern ways Java applications usually run concurrent work.

### Part 1 Creating and running a Basic Thread	

1.	Create a new class called MyRunnable that implements the Runnable interface.

2.	Add a run() method, and in the MyRunnable run() method add a loop which should execute 3 times, each time printing a message of your choice. 

3.	Create another class that has a main method called ThreadTest.
Within the main() method, create an instance of the MyRunnable class.

```
Runnable run = new MyRunnable();
```

4.	Within main() create and start 3 instances of the Thread class, passing in the instance of the MyRunnable object to the constructor.

```
Thread thread1 = new Thread(run);
thread1.start(); 
```

5.	Run the program and check that the correct number of messages are printed, 3 from each thread instance.

6.	Now modify the program to use a Lambda based runnable instead of the MyRunnable class.

7.	This direct use of `new Thread(...)` is still useful for learning how threads work, but in real applications Java code will usually submit work to an `ExecutorService`, and on Java 21+ may use virtual threads.

### Part 2 Working with Synchronization

1.	In the MyRunnable class, add a private String variable containing your message.

2.	In the MyRunnable class, add a slowMessage() method that displays the contents of the message one character at a time with a 10 ms pause between each character (use `Thread.sleep(10)` for the pause).

If you catch `InterruptedException`, do not ignore it. Restore the interrupt flag with:

```
Thread.currentThread().interrupt();
```

3.	In the MyRunnable class, from the run() method, call the slowMessage() method within the loop instead of simply printing the message directly.

4.	Run the ThreadTest class now and see what happens. 
If the message was:

```
"hello from the thread"
```

You will get output something like this:

```
hhheeelllllolo of  rffrormoom mt  thtehh eet  httrhherraeedaa
hdde
h
hleellloll oof  rfforrmoo mmt  httehh eet  ththhrrereeaadadd
h
he
hleelllllooo   frffrrooommm  t httehh ee t tthhrherreeaadadd
```

5. Add the `synchronized` keyword to the `slowMessage()` method and run `ThreadTest` again. What happens this time and why? If you have done this correctly you will see perfect output:

```
hello from the thread
hello from the thread
hello from the thread
hello from the thread
hello from the thread
hello from the thread
hello from the thread
hello from the thread
hello from the thread
```

6.	Refactor the code so that you are now using a `synchronized(this)` block within the method instead of a synchronized method. Run it and check that it still behaves correctly.

7.	Finally, replace `synchronized(this)` with a private lock object, for example:

```
private final Object lock = new Object();
```

and synchronize on that lock object instead.

Why is this better? `synchronized(this)` works here only because all three threads share the same `MyRunnable` instance. Using a dedicated private lock object makes the locking intent explicit and avoids accidentally exposing your monitor to other code. Do not synchronize on a `String` field or string literal, because strings may be shared or interned.

### Part 3 A More Modern Approach

1.	Create a new class called `ModernThreadingDemo`.

2.	In `main()`, create an `ExecutorService` using `Executors.newFixedThreadPool(3)`.

3.	Submit either your `MyRunnable` instance or a lambda-based runnable to the executor three times.

4.	Shut the executor down after submitting the work.

5.	If you are using Java 21 or later, read about `Executors.newVirtualThreadPerTaskExecutor()` and compare it to the fixed thread pool version.

The key idea is that modern Java usually separates the task you want to run from the thread management details.

