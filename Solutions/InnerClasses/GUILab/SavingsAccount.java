
public class SavingsAccount extends Account
{

	public SavingsAccount(String s, double d)
	{
		super (s,d);
	}

	public void addInterest()
	{
		this.setBalance(getBalance()*1.4);
	}




}