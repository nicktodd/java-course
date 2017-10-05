
public class TestAccount
{
	public static void main(String[] args)
	{
		// declare and instantiate the object
		Account myAccount = new Account();

		// set up the variables
		myAccount.setAccountName("Nick");
		myAccount.setBalance(20000);

		// display the contents
		System.out.println("The name is " + myAccount.getAccountName());
		System.out.println("The balance is " + myAccount.getBalance());

		// call addInterest
		myAccount.addInterest();
		System.out.println("The balance is now " + myAccount.getBalance());



	}



}