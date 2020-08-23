## Chapter 6:  Introduction to Objects in Java

### The Aims
This lab will introduce you to defining classes with instance methods and variables, and then instantiating and manipulating the resulting objects from a main method.

### Defining a class

We are going to create a new class called Account, and save it in a file called **Account.java**.

1. In  your preferred editor, create a new class called ```Account```.
   
2.	Provide two properties called `balance` and `name`, setting them to be a `double` and a `String` respectively. These variables should be declared as private.

3.	Now provide methods which will set and return the balance and the name. Ie. Provide, get and set methods for your two variables. You can use the Eclipse Source / Generate Getters and Setters if you wish. IntelliJ and Visual Studio Code have similar options.

4.	Define a new method called addInterest, which does not take in any parameters or return any value, but increases the balance by 10%. We will be using this method later.

5.	Check for any errors before proceeding.

### *Instantiating the class*

6.	Create another class called **TestAccount** and this time add a main method to it. You can do this at the New Class dialog or in the blank class, type the word main, and the press Ctrl/Space.

7.	Within this main method, declare and instantiate a new Account object called **myAccount**, and then call the set methods to give it a name and a balance. Set name to be your name, and you can give yourself as much money as you like!

8.	Now print out the name and balance to the screen using the get methods. Place appropriate text before the values using the string concatenator (+).

9.	Fix any errors, and run your program. It should print out your name and balance variables. 

10.	Call the **addInterest** method and print out the balance again. It should be different when you run it.
 
