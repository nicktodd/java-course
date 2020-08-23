## Chapter 7: Working with Arrays
### Aims
You will now take the previous exercise a little further and modify the code to work with an array of accounts rather than single account references.
### Creating an array of Accounts
We will now create an array of Account objects called **arrayOfAccounts**. Remember, creating arrays of objects in Java involves three steps, declaring the array, initialising the array, and populating the array.

1.	Within the same main method that you used in the previous exercise, declare an array of accounts called arrayOfAccounts, and initialise it to be 5 elements in size.
2.	Create two other arrays, one of doubles and one of Strings, which contain values for the names and balances of your account objects. Do this using two array initialisers. Make up values for these two arrays. Something like:

    ```double[] amounts = {23,5444,2,345,34};```
 ```String[] names = {"Picard", "Ryker", "Worf", "Troy", "Data"};```


3.	Using a for loop, populate the object referenced by arrayOfAccounts with account objects specifying a name and a balance using values from your predefined arrays.
4.	Within the loop print out the name and balance from each account object. 
5.Finally, within the loop, call the **addInterest** on each object in the array. Print out the modified balances.

 
