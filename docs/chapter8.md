## Chapter 8: More on Java Classes 
### The Aims
We will now modify our classes to incorporate method overloading, constructors, and static variables and methods.
### Adding Constructors
We will now add a constructor to our Account class so that we can create accounts and give them a value for the name and balance variable upon instantiation.

1.	In your **Account** class, define a constructor that takes a String and a double. Assign those values to your instance variables name and balance.
2.	In your Account class, define a no argument constructor that passes your first name and a balance of 50 to the constructor taking a String and a double. Remember, this is done using the this keyword. You will not need this constructor for rest of the exercise, but it is useful to see how it can be done.
3.	Now create a new class called TestAccount2 that has a main method.
4.	In the main method, create an array of account objects as you did in the last lab. You need 5 Account objects as before. Set the name and balance when you create each account object. To do this, use the constructor you added that takes in a name and a balance.

### Static variables and methods
So far, the interest rate for our account object is somewhat arbitrarily defined by our addInterest method. We will now create a variable, which will be the interest rate for our Account objects. This will be a static variable – why?

5.	In the Account class, declare and initialise a static variable of type double to be the interest rate for the Account class. Call it interestRate. Also, provide a set and get method for the variable - remember that these will be static methods.
6.	Modify the addInterest instance method to use this variable instead of our fixed value.
7.	From your main method, change the interest rate using the Account class static method Account.setInterestRate(someDouble) that you defined earlier in step 5.
8.	In the TestAccount2 main method, loop though your array. In the loop you should:
a.	Display the balance
b.	Call the addInterest method
c.	Display the new balance
9.	Run your class. Is it using your new interest rate value?

### Method Overloading
Finally, we will put in some method overloading. We will provide two methods with the same name that take in different arguments. Our methods will both be called withdraw. One will take in a parameter called amount, and the other will not require a parameter.

10.	In class Account, define a withdraw method that takes in a value and checks that there is enough money in the account and if there is, the balance is reduced by the amount passed in. The signature will be:

public boolean withdraw(double amount)

This method will return a boolean, true if there was enough money and false if there was not.

11.	Now define a second withdraw method. This takes in no parameters, and deducts an arbitary value of 20 from the account. This also should return a boolean, true if there is enough money, and false if not, as before.
HINT: Is there a way to write this method in a way that does not duplicate the code you created in the previous step.
12.	Now in your test class, try calling withdraw on some of your account objects. Make calls to both methods, passing in values that are higher than the balance, and check that it doesn’t let you draw the money out (ie. Returns false).
13.	You could modify your withdraw methods to also display a message on the screen as well as return true or false, so your users know whether it has been a successful transaction or not.

 
