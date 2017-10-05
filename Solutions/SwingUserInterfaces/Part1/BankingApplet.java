import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class BankingApplet extends JApplet
{
	private JButton button;
	private JTextField displayBalance;
	private JComboBox accountSelection;


	private Account[] accounts;

	public void init()
	{
		getContentPane().setLayout(new FlowLayout());
		// create the accounts array
		accounts = new Account[3];

		// populate the array
		accounts[0] = new CurrentAccount("Sarah", 49.43);
		accounts[1] = new CurrentAccount("Alex", 30.01);
		accounts[2] = new SavingsAccount("Abigail", 45);

		getContentPane().add(new JLabel("Please select the account"));

		accountSelection = new JComboBox();

		for (int i=0; i<accounts.length; i++)
		{
			accountSelection.addItem(accounts[i].getAccountName());
		}
		getContentPane().add(accountSelection);

		getContentPane().add(new JLabel("Balance is "));
		getContentPane().add(displayBalance = new JTextField(10));

		displayBalance.setEditable(false);


	}



}