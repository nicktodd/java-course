
public class Account
{
	// instance variables
	private String accountName;
	private double balance;


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

	public void addInterest()
	{
		balance = balance *1.1;
	}
}