
public class TestAccount2
{
	public static void main(String[] args)
	{
		// declaring and creating the array of accounts
		Account[] arrayOfAccounts;			// declare the array
		arrayOfAccounts = new Account[5];	// create the array

		double[] amounts = {23,5444,2,345,34};
		String[] names = {"Picard", "Ryker", "Worf", "Troy", "Data"};



		// display the array contents
		for (int i=0; i<arrayOfAccounts.length; i++)
		{

			// initialise the array of accounts contents to contain account objects
			arrayOfAccounts[i] = new Account(names[i], amounts[i]);

			System.out.println("The name is " +
							arrayOfAccounts[i].getName());
			System.out.println("The balance is " +
							arrayOfAccounts[i].getBalance());

			// call the addIntrest method on each object
			arrayOfAccounts[i].addInterest();
			System.out.println("The new balance is " +
							arrayOfAccounts[i].getBalance() + "\n");
		}

		// test the withdraw method
		arrayOfAccounts[1].withdraw(200000);
		arrayOfAccounts[0].withdraw();


	}



}