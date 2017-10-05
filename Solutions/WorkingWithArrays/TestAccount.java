
public class TestAccount
{
	public static void main(String[] args)
	{

		// declaring and creating the array of accounts
		Account[] arrayOfAccounts;			// declare the array
		arrayOfAccounts = new Account[5];	// create the array

		double[] amounts = {23,5444,2,345,34};
		String[] names = {"Picard", "Ryker", "Worf", "Troy", "Data"};

		// initialise the array of accounts contents to contain account objects
		for (int i=0; i<arrayOfAccounts.length; i++)
		{
			arrayOfAccounts[i] = new Account();
			arrayOfAccounts[i].setAccountName(names[i]);
			arrayOfAccounts[i].setBalance(amounts[i]);
			System.out.println("The name is " +
										arrayOfAccounts[i].getAccountName());
			System.out.println("The balance is " +
										arrayOfAccounts[i].getBalance());
			arrayOfAccounts[i].addInterest();
			System.out.println("The new balance is " +
							arrayOfAccounts[i].getBalance() + "\n");
		}


		ArrayList<Account> myList = new ArrayList<Account>();
		for (Account a : arrayOfAccounts)
		{
			myList.add(a);
		}



	}



}

class Account
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