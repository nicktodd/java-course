
public abstract class Account implements Detailable
{
	// instance variables
	private String accountName;
	private double balance;

	// static variable
	private static double interestRate=1.5;

	// constructors
	public Account(String s, double d)
	{
		accountName = s;
		balance = d;
	}

	public Account()
	{
		// constructor calling another constructor in the same class
		this("Nick", 5000);
	}


	// instance method from Detailable

	public String getDetails()
	{
		return "The name is " + accountName + " and the balance is " + balance;
	}


	// instance methods
	public void setBalance(double d)
	{
		balance = d;
	}

	public double getBalance()
	{
		return balance;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String s)
	{
		accountName = s;
	}
	// now abstract
	public abstract void addInterest();

	// method overloading
	public boolean withdraw()
	{
		boolean flag = false;
		if ((balance-20) >0)
		{
			balance -= 20;
			flag = true;
			System.out.println("You have successfully withdrawn £20.");
			System.out.println("There is now £" + balance + " left in your account.");
		}
		else
			System.out.println("Sorry not enough money. YOu only have £" + balance);
		return flag;
	}

	public boolean withdraw(double amount)
	{
		boolean flag = false;
		if ((balance-amount) > 0)
		{
			balance -= amount;
			flag = true;
			System.out.println("You have successfully withdrawn £" + amount +".");
			System.out.println("There is now £" + balance + " left in your account.");
		}
		else
			System.out.println("Sorry not enough money. YOu only have £" + balance);
		return flag;
	}


	// static methods
	public static void setInterestRate(double d)
	{
		interestRate = d;
	}

	public static double getInterestRate()
	{
		return interestRate;
	}
}