import java.awt.*;
import java.applet.*;

public class BankingApplet extends Applet
{
	private Button button;
	private TextField displayBalance;
	private Choice accountSelection;


	private Account[] accounts;

	public void init()
	{
		// create the accounts array
		accounts = new Account[3];

		// populate the array
		accounts[0] = new CurrentAccount("Sarah", 49.43);
		accounts[1] = new CurrentAccount("Alex", 30.01);
		accounts[2] = new SavingsAccount("Abigail", 45);

		add(new Label("Please select the account"));

		accountSelection = new Choice();

		for (int i=0; i<accounts.length; i++)
		{
			accountSelection.addItem(accounts[i].getAccountName());
		}
		add(accountSelection);

		add(new Label("Balance is "));
		add(displayBalance = new TextField(10));

		displayBalance.setEditable(false);


	}



}