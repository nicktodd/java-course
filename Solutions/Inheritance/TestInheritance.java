
public class TestInheritance
{
	public static void main(String[] args)
	{
		Account[] accounts= {
								new Account("Sarah", 2),
								new SavingsAccount("Alex", 4),
								new CurrentAccount("Abigail", 6)
							};

		for (int i=0; i<accounts.length; i++)
		{
			accounts[i].addInterest();
			System.out.println("The name is " + accounts[i].getAccountName());
			System.out.println("The balance is " + accounts[i].getBalance());
			System.out.println("\n");
		}
	}


}