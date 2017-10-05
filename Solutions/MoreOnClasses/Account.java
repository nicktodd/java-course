public class Account {
	// instance variables
	private String name;
	private double balance;

	// static variable
	private static double interestRate=1.5;

	// constructors
	public Account(String s, double d) {
		name = s;
		balance = d;
	}

	public Account()	{
		// constructor calling another constructor in the same class
		this("Nick", 5000);
	}

	// instance methods
	public void setBalance(double d) {
		balance = d;
	}

	public double getBalance() {
		return balance;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}

	public void addInterest()
	{
		balance = balance *interestRate;
	}

	// method overloading
	public boolean withdraw()
	{
		return withdraw(20);
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