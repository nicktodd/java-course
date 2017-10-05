
public class HomeInsurance implements Detailable
{
	private double excess;
	private double amountInsured;
	private double premium;

	public HomeInsurance(double excess, double amountInsured, double premium)
	{
		this.excess = excess;
		this.amountInsured = amountInsured;
		this.premium = premium;
	}

	public String getDetails()
	{
		return "Excess is " + excess + " Amount insured is " + amountInsured + " Premium is " + premium;
	}

}

