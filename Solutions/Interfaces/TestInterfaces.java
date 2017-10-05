public class TestInterfaces
{
	public static void main(String[] args)
	{
		Detailable[] details= {
								new HomeInsurance(20,200,50),
								new SavingsAccount("Alex", 4),
								new CurrentAccount("Abigail", 6)
							  };

		for (int i=0; i<details.length; i++)
		{
			System.out.println(details[i].getDetails());
			System.out.println("\n");
		}
	}


}