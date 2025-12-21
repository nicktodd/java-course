## Chapter 15 Working with Enums

### Aims

In this exercise you will create an Enum to represent the currency used by your Accounts.

### Create a Basic Currency Enum

1.	In IntelliJ, create a new Java project called CurrencyEnum (or add to your existing project).

2.	Create a new Java file called Currency.java. In IntelliJ, right-click on the src folder, select New → Java Class, then change the kind to "Enum" in the dialog.

3.	Add three possible values for the Enum to be GBP, EUR, and USD.

4.	Save the file and check there are no errors before proceeding.

### Add a Currency property to the Account class

1.	We have provided a simple Account class for you to use with this. Copy the Account.java file from <LAB_HOME>\enums\ into your project's src folder.

2.	Open Account.java and add a new private property of type Currency called currency.

3.	Add get and set methods to go with it. In IntelliJ, you can use Alt+Insert or right-click and select Generate → Getter and Setter.

4.	Add a new constructor that takes in name, balance and now a currency.

### Adding a Symbol to the Currency Enum

1.	Open the Currency.java file again, and now add the following:
	1. A private property called symbol of type char.
	2. A private constructor that takes in a char and sets the symbol property to be the char passed in as a parameter to the constructor.
	3. A standard getSymbol method that returns the symbol property.

2.	Modify the three currencies USD, GBP and EUR to provide a value for the symbol. (to get the Euro symbol, on Windows, press Right-Alt and 4).

Your Currency Enum should now look something like this:

```java
public enum Currency {
	USD('$'), GBP('£'), EUR('€');
	private char symbol;
	private Currency(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
```

### Testing the Enum

1.	Create a class called EnumTest complete with a main method.

2.	Within the main method, create an instance of the Account class using the constructor you added in the earlier part providing a name, balance and currency.

3.	In a System.out.println() statement, print out the balance and currency of the account.
 
