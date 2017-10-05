/*
 * MyFirstClass.java
 *
 * Created on 15 March 2000, 09:37
   Solutions for Chapter 3 - Looping and Branching
   Conygre IT Limited
 */

public class MyFirstClass
{
  // main method
  public static void main(String[] args)
  {
    // lab 1
    String make = "Renault";
    String model = "Laguna";
    double engineSize = 1.8;
    byte gear = 2;

    System.out.println("The make is " + make);
    System.out.println("The model is " + model);
    System.out.println("The engine size is " + engineSize);

    // Looping and Branching
    // part 1
    if (engineSize <= 1.3)
    {
      System.out.println("You have a weak car");
    }
    else
    {
      System.out.println("You have a powerful car");
    }
  
    // part 2
    // notice I've used print not println (What's the difference?)
    System.out.print("You should be travelling ");
    if (gear == 0)
      System.out.print("at 0mph");
    else if (gear==1)
      System.out.print("at 0-10mph");
    else if (gear==2)
      System.out.print("at 10-25mph");
    else if (gear==3)
      System.out.print("at 25-35mph");
    else if (gear==4)
      System.out.print("at 35-50mph");
    else if (gear==5)
      System.out.print("over 50mph");
    else if (gear==-1)
      System.out.print("Backwards!");
  
    // part 3
    System.out.println("This is using a switch case");
    switch (gear)
    {
      case -1:
        System.out.print("Backwards");
        break;
      case 0:
        System.out.print("0mph");
        break;
      case 1:
        System.out.print("0-10mph");
        break;
      case 2:
        System.out.print("10-25mph");
        break;
      case 3:
        System.out.print("25-35mph");
        break;
      case 4:
        System.out.print("35-50mph");
        break;
      case 5:
        System.out.print("over 50mph");
        break;
        default:
        System.out.println("What kind of car do you drive!!?");
     }
    
    //part 4
    for (int i=1900; i<=2000; i++)
    {
      if ((i%4)==0)
      {
        System.out.println(i + " is a leapyear.");
      }
    }
    
    //part 5
    int count = 0;
    for (int i=1900; i<=2000; i++)
    {
      if ((i%4)==0)
      {
        count++;
        System.out.println(i + " is a leapyear.");
      }
      if (count == 5)
        break;
    }
    
  // end of main  
  }
// end of class  
}