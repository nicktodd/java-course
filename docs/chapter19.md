## Chapter 19: Multithreading

### The Aims

In this exercise you will create applications that work with multiple threads. You will then extend it to take advantage of synchronization.

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

### Part 2 Working with Synchronization

1.	In the MyRunnable class, add a private String variable containing your message.

2.	In the MyRunnable class, add a slowMessage() method that displays the contents of the message one character at a time with a 10 ms pause between each character (use Thread.sleep(10)) for the pause.

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

5. Add the synchronized keyword to the slowMessage method and run ThreadTest again. What happens this time and why? If you have done this correctly you will see perfect output:

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

5.	Refactor (change) the code so that are now using a synchronized(this) block within the method. Run it and check that it still behaves correctly.

6.	Finally, change the synchronized block so that you are synchronizing on the String message variable. Run it again and check that it behaves correctly.

