
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account("Fred", 40, Currency.EUR);
		
		System.out.println("The account has " + acc.getCurrency().getSymbol() + acc.getBalance());

	}

}
