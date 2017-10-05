import java.awt.*;
import java.awt.event.*;

public class BankingFrame extends Frame
{
	private Button button;
	private TextField displayBalance;
	private Choice accountSelection;

	private MenuBar mBar;
	private Menu menu;
	private MenuItem mItem;

	private Account[] accounts;

	public BankingFrame()
	{
		// pass a title up to the super class constructor
		super ("Banking Application");

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

		// add the Panels to the Frame
		add(forNorth, BorderLayout.NORTH);
		add(forSouth, BorderLayout.SOUTH);


		// create and add the menus
		mBar = new MenuBar();
		menu = new Menu("Help");
		mItem = new MenuItem("About");
		mBar.add(menu);
		menu.add(mItem);
		setMenuBar(mBar);

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
		Frame f = new BankingFrame();
		f.setVisible(true);
	}
}

class BankingDialog extends Dialog
{
	private Button b;

	public BankingDialog (Frame f)
	{
		super (f, "About", true);
		setLayout(new FlowLayout());
		add (new Label("Built by Conygre"));
		add (b = new Button("OK"));
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
