import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class BankingApplet extends Applet
{
	private Button button;
	private TextField displayBalance;
	private Choice accountSelection;


	private Account[] accounts;

	public void init()
	{
		// set the layout manager
		setLayout(new BorderLayout());
		Panel forNorth = new Panel();
		Panel forSouth = new Panel();
		// create the accounts array
		accounts = new Account[3];

		// populate the array
		accounts[0] = new CurrentAccount("Sarah", 49.43);
		accounts[1] = new CurrentAccount("Alex", 30.01);
		accounts[2] = new SavingsAccount("Abigail", 45);

		// add components to the forNorth Panel
		forNorth.add(new Label("Please select the account"));

		accountSelection = new Choice();
		accountSelection.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent evt)
			{
				if (evt.getSource() == accountSelection)
				{
					for (int i=0; i<accounts.length; i++)
					{
						if (accountSelection.getSelectedItem().equals(accounts[i].getAccountName()))
							displayBalance.setText("" + accounts[i].getBalance());
					}
				}
		
			}
		});

		for (int i=0; i<accounts.length; i++)
		{
			accountSelection.addItem(accounts[i].getAccountName());
		}
		forNorth.add(accountSelection);


		// add components to the forSouth Panel
		forSouth.add(new Label("Balance is "));
		forSouth.add(displayBalance = new TextField(10));

		displayBalance.setEditable(false);

		// add the Panels to the applet
		add(forNorth, BorderLayout.NORTH);
		add(forSouth, BorderLayout.SOUTH);


	}





}
