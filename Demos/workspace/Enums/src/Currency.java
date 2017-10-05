

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
