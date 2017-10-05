public class CurrentAccount extends Account
{

	public CurrentAccount(String s, double d)
	{
		super (s,d);
	}

	public void addInterest()
	{
		this.setBalance(getBalance()*1.1);
	}




}