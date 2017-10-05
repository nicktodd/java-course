import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class BankingFrame extends JFrame
{
	private JButton button;
	private JTextField displayBalance;
	private JComboBox accountSelection;

	private JMenuBar mBar;
	private JMenu menu;
	private JMenuItem mItem;

	private Account[] accounts;

	public BankingFrame()
	{
		// pass a title up to the super class constructor
		super ("Banking Application");

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

		accountSelection.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				for (int i=0; i<accounts.length; i++)
				{
					if (accountSelection.getSelectedItem().equals(accounts[i].getAccountName()))
						displayBalance.setText("" + accounts[i].getBalance());
				}
		    }
		});


		forNorth.add(accountSelection);


		// add components to the forSouth Panel
		forSouth.add(new Label("Balance is "));
		forSouth.add(displayBalance = new JTextField(10));

		displayBalance.setEditable(false);

		// add the Panels to the Frame
		getContentPane().add(forNorth, BorderLayout.NORTH);
		getContentPane().add(forSouth, BorderLayout.SOUTH);


		// create and add the menus
		mBar = new JMenuBar();
		menu = new JMenu("Help");
		mItem = new JMenuItem("About");
		mBar.add(menu);
		menu.add(mItem);
		setJMenuBar(mBar);

		mItem.addActionListener ( new ActionListener()
			{
				public void actionPerformed (ActionEvent evt)
				{
					// create a dialog
					BankingDialog b = new BankingDialog(BankingFrame.this);
					b.setVisible(true);
				}
			});


		// add event handling to handle WindowEvents
		this.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent evt)
					{
						System.exit(0);
					}
				});
		pack();


	}

	public static void main (String [] args)
	{
		JFrame f = new BankingFrame();
		f.setVisible(true);
	}
}

class BankingDialog extends JDialog
{
	private JButton b;

	public BankingDialog (JFrame f)
	{
		super (f, "About", true);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add (new Label("Built by Conygre"));
		getContentPane().add (b = new JButton("OK"));
		b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					dispose();
				}
			});
		pack();
	}
}
