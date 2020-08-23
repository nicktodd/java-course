## Chapter 17: Exception Handling

### The Aims

In this exercise, you will create an exception type for when a blacklisted name is used to create an account, or have the name of an account set to the blacklisted name. If you want to keep solutions to previous exercises, you must create a new project for this exercise, and copy your Account class and its subclasses into a new Project.

### Specifying your Account class uses Exceptions 

1.	Create a new class called DodgyNameException that extends Exception.

2.	Add a default constructor to your exception class that calls the superclass constructor passing the String "Fingers is not allowed an account!". 

3.	Modify both the Account class constructors and the Account class setName method to show that they throw a DodgyNameException.

4.	In the body of the constructors and the setName method, check that the name parameter is not "Fingers", and if it is, throw the exception.

### Using the Modified Account Class

1.	Create a TestExceptions class with a main method, and copy over one of your blocks of code that creates an array or collection of Accounts.

2.	Add the appropriate try / catch blocks.

3.	In the catch block, print the exception information using the toString() method.

4.	Run the application and check that the exception does not get thrown. No output should appear.

5.	Change the code so that one of the new accounts is in the name of "Fingers".

6.	Run it again and see if the exception gets thrown this time. It should be.

### Optional: Working with finally Blocks

1.	Within the catch block, add a return; statement which will end the main method.

2.	Now add a finally block just before the end of the main method.

3.	Because of Death duties, to compensate for all the tax avoided 
by those OffshoreAccounts, collect 40% of the remaining balances of all of the Account objects in the collection or array. Within the finally block, display the amount of tax collected.

4.	Run this code with a "Fingers" and without. Does the presence of "Fingers" make any difference as to whether this block runs?
