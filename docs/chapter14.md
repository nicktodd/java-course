## Chapter 14: The Java Collections API
### Aims
In this exercise, you will revisit the array exercise that you completed in an earlier chapter, and re-implement the array as a List. You will then sort the contents using a comparator object.

### Part 1 Re-implement the array from the Inheritance chapter as a TreeSet.
1.	In the Inheritance project, create a new class with a main method called CollectionsTest.
2.	Within main, declare a variable that will reference a HashSet of Account references called accounts.

```HashSet<Account> accounts;```

3.	Instantiate the HashSet using the default constructor.

accounts = new HashSet<Account>();

4.	Create three account objects or subclass objects (if your account class is abstract), and add them to the HashSet using the add method.
5.	Retrieve an Iterator for the HashSet and iterate over each account, and for each account:
a.	Display the output from the getName() and getBalance() methods 
b.	Call addInterest().
c.	Display the output from the getBalance() method.
6.	Repeat the previous step, but this time, refactor using the Java5 “for each” construct 

for (Account a: accounts) {  

}.
7.	Refactor again, but this time use the Java 8 forEach method.

### Part 2 Sort the Collection
1.	Now define a new class called AccountComparator, that implements the Comparator interface.
2.	Within the AccountComparator class, define a compare method that compares two account objects, and sorts them into balance order.
3.	Re-implement your HashSet as a TreeSet passing an instance of your AccountComparator class to the TreeSet constructor.
4.	Re-run the application, and you will see that the accounts are displayed in balance order regardless of the order that they were added in.
5.	Now modify the code to use a Lambda based Comparator.


 
