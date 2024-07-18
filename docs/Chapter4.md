## Chapter 4: Looping and Branching
### The Aims
This lab will introduce you to using the various flow control constructs of the Java language.

### Part 1 Using if / else
The main method from your previous lab exercise should look something like this.



```
public static void main(String[] args) {
              String make = "Renault";
              String model = "Laguna";
              double engineSize = 1.8;
              byte gear = 2;
              System.out.println("The make is " + make);
              System.out.println("The model is " + model);
              System.out.println("The engine size is " + engineSize);
        }
}
```

1. Firstly, put in some logic to print out either that the car is a powerful car or a weak car based on the engine size, for example, if the size is less than or equal to 1.3.
   
2. Now, using an if / else if construct, display to the user a suitable speed range for each gear, so for example, if the gear is 5, then display the speed should be over 45mph or something. If the gear is 1, then the speed should be less than 10mph etc.

### Part 2 Looping
3. We will now need to generate a loop which loops around all the years between 1900 and the year 2000 and print out all the leap years to the command console. You can use either a for or while loop to do this.
   
4. Once you have done this, set it so that after 5 leap years have been displayed, it breaks out of the loop and prints ‘finished’.
   
### Part 3 Using switch / case

5. Now re-write part 1 to use a switch / case construct. It should do exactly the same thing as the if / else if construct. Don’t forget to use break!
   
### Part 4 (Optional)
6. This will possibly require some research by you to find out how to do this. Create yourself an array capable of containing 10 ints.

7. Now modify your loop above, so that it no longer displays the first five years, but stores the first 10 in your array instead.

8. Now provide another loop to print out the values in the array. Use the length property of the array object to specify how many times to loop.

