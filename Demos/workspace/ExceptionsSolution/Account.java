
public class Account {

	private String name;
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws DodgyNameException{
		if ("Fingers".equals(name)) 
			throw new DodgyNameException();
		this.name = name;
	}
	public Account(String name, double balance) throws DodgyNameException {
		if ("Fingers".equals(name)) 
			throw new DodgyNameException();
		this.name = name;
		this.balance = balance;
	}
	public Account(String name) throws DodgyNameException {
		if ("Fingers".equals(name)) 
			throw new DodgyNameException();
		this.name = name;
	}
	public Account() {

	}
	
	public void addInterest()
	{
		balance *= 1.1;
	}
	
	
	
}
