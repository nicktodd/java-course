

public class Account {

	public Account(String name, double balance, Currency currency) {
		this.name = name;
		this.balance = balance;
		this.currency = currency;
	}
	
	
	private String name;
	private double balance;
	
	private Currency currency;
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double b) {
		balance = b;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	
}