import java.util.*;

public class CollectionsTest
{
	// Part 1 The Nested Class
	private static class AccountComparator implements java.util.Comparator<Account>
	{
			public int compare(Account a, Account b)
			{
				if (a.getBalance() < b.getBalance()) return -1;
				else if (a.getBalance() > b.getBalance()) return 1;
				else return 0;
			}


}


	public static void main(String[] args)
	{

		final int myInt = 5;

		// Part 2 The Local Inner class
		class AccountComparator implements java.util.Comparator<Account>
		{
				public int compare(Account a, Account b)
				{
					// can only access local variables if they are final
					System.out.println(myInt);
					if (a.getBalance() < b.getBalance()) return -1;
					else if (a.getBalance() > b.getBalance()) return 1;
					else return 0;
				}
   		}


		// Part 3 The Anonymous inner class
		Set<Account> accounts = new TreeSet<Account>(new Comparator<Account>()
		{
			public int compare(Account a, Account b)
							{
								// can only access local variables if they are final
								System.out.println(myInt);
								if (a.getBalance() < b.getBalance()) return -1;
								else if (a.getBalance() > b.getBalance()) return 1;
								else return 0;
				}

		});

		double[] amounts = {23,5444,2,345,34};
		String[] names = {"Picard", "Ryker", "Worf", "Troy", "Data"};



		// initialise the array of accounts contents to contain account objects
		Account current;
		for (int i=0; i<5; i++)
		{
			current = new Account();
			current.setAccountName(names[i]);
			current.setBalance(amounts[i]);
			accounts.add(current);
		}


		// using the iterator
		Iterator<Account> iter = accounts.iterator();

		while (iter.hasNext())
		{
			Account nextAccount = iter.next();
			System.out.println("The name is " +
							nextAccount.getAccountName());
			System.out.println("The balance is " +
							nextAccount.getBalance());
			nextAccount.addInterest();
			System.out.println("The new balance is " +
							nextAccount.getBalance() + "\n");
		}


		// using the Java5 for each
		for (Account nextAccount: accounts)
		{
			System.out.println("The name is " +
							nextAccount.getAccountName());
			System.out.println("The balance is " +
							nextAccount.getBalance());
			nextAccount.addInterest();
			System.out.println("The new balance is " +
				nextAccount.getBalance() + "\n");
		}




	}



}