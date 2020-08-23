## Chapter 1: Introduction to Java
### Aims

In this lab, your aim is to gain familiarity with using the Java Developers Kit (JDK) compiler and runtime environment. We will write a simple Java class that will output some text to the console.
### Your First Java Program
1.	Using a text editor like notepad, create a new file and save it as **MyFirstClass.java.**
2.	At the top of our file we need to firstly declare our class with the line 
**public class** **MyFirstClass** (remember Java is case sensitive so file names and your java code must be correct).
3.	We will then insert curly braces within which to put our class definition.
You should therefore have something like this;

public class MyFirstClass
{


}


4.	Within the curly braces we will put a main method. This, if you recall, is where your applications will start from when you invoke the java runtime environment. The signature for the main method looks like this;

public static void main(String[] args)
{

}

Don’t worry if you do not understand why at this stage. You will later.

5.	**Printing something out to the screen**
Now we can inset some code to print something out to the console. Again, you may not understand why at this stage, but the code to do this is as follows, and it goes inside your main method’s curly braces.

System.out.println(“Hello from my first Java program!”);



6.	Your code should now look something like this;

```public class MyFirstClass```
{
        ```public static void main(String[] args)```
        {
                  ```System.out.println(“Hello from my first java ``program!”);```
         }


7.	Once you have finished you will need to compile your code, so from the command line whilst in your working directory, you will need to enter the line;

javac MyFirstClass.java

8.	This will invoke the compiler to generate a class file called MyFirstClass.class. If nothing appears to happen, that is good news! It has compiled fine. If you have any errors, check that your code is the same as that written above, and saved in a file called MyFirstClass.java.

9.	Once it has been compiled, you can run your first java program. To do this, type the following at the command line;

java MyFirstClass

10.	It should print out you’re the text that is in your System.out.println(“xxx”); statement.

}

7.	Once you have finished you will need to compile your code, so from the command line whilst in your working directory, you will need to enter the line;

javac MyFirstClass.java

8.	This will invoke the compiler to generate a class file called MyFirstClass.class. If nothing appears to happen, that is good news! It has compiled fine. If you have any errors, check that your code is the same as that written above, and saved in a file called MyFirstClass.java.

9.	Once it has been compiled, you can run your first java program. To do this, type the following at the command line;

java MyFirstClass

10.	It should print out you’re the text that is in your System.out.println(“xxx”); statement.

 
