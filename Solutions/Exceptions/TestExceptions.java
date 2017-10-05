
public class TestExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declaring and creating the array of accounts
		Account[] arrayOfAccounts;			// declare the array
		arrayOfAccounts = new Account[5];	// create the array

		double[] amounts = {23,5444,2,345,34};
		String[] names = {"Picard", "Fingers", "Worf", "Troy", "Data"};

		// initialise the array of accounts contents to contain account objects
		try
		{
			for (int i=0; i<arrayOfAccounts.length; i++)
			{
				arrayOfAccounts[i] = new Account();
				arrayOfAccounts[i].setName(names[i]);
				arrayOfAccounts[i].setBalance(amounts[i]);
				System.out.println("The name is " +
											arrayOfAccounts[i].getName());
				System.out.println("The balance is " +
											arrayOfAccounts[i].getBalance());
				arrayOfAccounts[i].addInterest();
				System.out.println("The new balance is " +
								arrayOfAccounts[i].getBalance() + "\n");
			}
		}
		catch (DodgyNameException e)
		{
			System.out.println("Exception: " + e);
			//return;
		}
		finally
		{
			double taxCollected = 0;
			for (int i=0; i<arrayOfAccounts.length; i++)
			{
				if (arrayOfAccounts[i] == null)
					break;
				taxCollected += (arrayOfAccounts[i].getBalance() / 100 *40);
				arrayOfAccounts[i].setBalance(arrayOfAccounts[i].getBalance() / 100 *60);
			}
			System.out.println("Managed to get " + taxCollected + " pounds!");

		}

	}

}
