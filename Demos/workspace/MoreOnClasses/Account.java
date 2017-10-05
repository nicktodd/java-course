
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
	public void setName(String name) {
		this.name = name;
	}
	public Account(String name, double balance) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.balance = balance;
	}
	
	public Account()
	{
		
	}
	
}
