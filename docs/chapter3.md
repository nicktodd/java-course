## Chapter 3: Java – The Basics
### The Aims
This lab will introduce you to using the primitive variable types, the basic operators, and the concept of casting. 

Remember – Java is case sensitive!

### Declaring and initialising variables
1.	Within the main method of **MyFirstClass** developed in  the last lab exercise, you will declare some variables to represent the car you drive, or if you do not have a car – a car you would like to drive! Firstly declare two variables of type `String` called make and model, then declare a variable of type double to be the engineSize, and declare a variable of type byte to be the gear your car is in.

2.	Now initialise those variables with appropriate values. Put in some code so that the program will print out the values of these variables, things like;

The make is x
The gear is y
The engine size is z

You will need to use the string concatenator (+). 

3.	Fix any errors and run the application.
 

Your code should look something like this;

```
public class MyFirstClass
{
       public static void main(String[] args)
       {
              String make = “BMW”;
              String model = “530D”;
              double engineSize = 3.0;
              byte gear = 2;

              System.out.println(“The make is “ + make);
              System.out.println(“The model is “ + model);
              System.out.println(“The engine size is “ + engineSize);
         }
}
```


### Casting
4.	Now declare a variable of type short to be the speed. This variable will be the result of the gear multiplied by 20 (Not scientific but it will do for now!).
5.	Put in a line of code to set the speed to equal the gear multiplied by 20. You will need to cast to get it to compile (why?).

6.	Print out the speed to the console, and run your program to check that it works correctly.

### Optional Extras
7.	Modify your code so that you have a number of other variables of different types. Build in some simple arithmetic, printing out your results to the console. You could place in an int for example to be the revs, which could be based on the speed variable multiplied by the gear!



