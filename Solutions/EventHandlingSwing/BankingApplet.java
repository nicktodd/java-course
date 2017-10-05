import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class BankingApplet extends JApplet implements ActionListener
{
	private JTextField displayBalance;
	private JComboBox accountSelection;


	private Account[] accounts;

	public void init()
	{

		// set the layout manager
		getContentPane().setLayout(new BorderLayout());
		JPanel forNorth = new JPanel();
		JPanel forSouth = new JPanel();
		// create the accounts array
		accounts = new Account[3];

		// populate the array
		accounts[0] = new CurrentAccount("Sarah", 49.43);
		accounts[1] = new CurrentAccount("Alex", 30.01);
		accounts[2] = new SavingsAccount("Abigail", 45);

		// add components to the forNorth Panel
		forNorth.add(new JLabel("Please select the account"));

		accountSelection = new JComboBox();


		for (int i=0; i<accounts.length; i++)
		{
			accountSelection.addItem(accounts[i].getAccountName());
		}
		forNorth.add(accountSelection);
		accountSelection.addActionListener(this);

		// add components to the forSouth Panel
		forSouth.add(new Label("Balance is "));
		forSouth.add(displayBalance = new JTextField(10));

		displayBalance.setEditable(false);

		// add the Panels to the applet
		getContentPane().add(forNorth, BorderLayout.NORTH);
		getContentPane().add(forSouth, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent evt)
	{
		for (int i=0; i<accounts.length; i++)
		{
			if (accountSelection.getSelectedItem().equals
													(accounts[i].getAccountName()))
				displayBalance.setText("" + accounts[i].getBalance());
		}
	}



 // example of how to set the look and feel. You do not have to do this in your code
		/*try
		{
			UIManager.setLookAndFeel(
		      	UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Couldn't load the look and feel" + e);
		}
		catch (InstantiationException e)
		{
			System.out.println("Couldn't instantiate the look and feel" + e);
		}
		catch (IllegalAccessException e)
		{
			System.out.println("Illegal access exception " + e);
		}
		catch (UnsupportedLookAndFeelException e)
		{
			System.out.println("Unsupported look and feel " + e);
		}
		*/


}