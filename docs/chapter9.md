## Chapter 9: Organising Java Classes
### The Aims
In this lab you will write a simple class in a package structure.  You will then experiment with different compilation and runtime options.
### Writing the Class
1.	Write a basic class called HelloWorld.java with a main method that simply outputs the String “Hello World” to the command line via a call to System.out.println() when the program is run.
2.	Add a package declaration putting this class in com.conygre.simple
3.	Open a command prompt in the directory where the Java source file is located.
4.	From the command prompt, enter the command javac –d . HelloWorld.java. Note the spaces either side of the dot.
5.	From the command prompt, enter the command: dir. Notice that a new directory structure has been created so that your class file is in the proper structure according to the package declaration.  The ‘.’ in the javac command simply specifies that the classes should go in the current directory – in their package structure.
6.	From the command prompt, change directory to the new folder containing your generated class file. This can be done with cd com\conygre\simple.  Try running the class with java HelloWorld. What is the result? It should fail. Why?
7.	Now try running it with java com.conygre.simple.HelloWorld Now what is the result? It should fail again. Why?
8.	Now change directory to the root on your machine by typing cd \. Run the same command as in the previous step, but this time use the –classpath switch to specify the directory where your package is located.  The full entry will be:

```java –classpath <location-of-package> com.conygre.simple.HelloWorld

Where the <location-of-package> is the folder containing the folder structure.```

 
