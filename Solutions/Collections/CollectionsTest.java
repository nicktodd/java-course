import java.util.*;

public class CollectionsTest
{
	public static void main(String[] args)
	{

		// PART 1
		// Re implementing the inheritance array but using a HashSet

		// declaring and creating a set of accounts
		Set<Account> accounts = new HashSet<Account>();

		// PART 2
		//Set<Account> accounts = new TreeSet<Account>(new AccountComparator());

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