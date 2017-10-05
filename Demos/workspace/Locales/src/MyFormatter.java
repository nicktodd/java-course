import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;
import java.text.Format;
// this class uses the NumberFormat object which contains
// the number formats for the current locale.
public class MyFormatter
{
    public static void main(String[] args)
    {
    	// process a number
    	NumberFormat nf1 = NumberFormat.getInstance(Locale.ENGLISH);
    	System.out.println(nf1.format(1234));


    	// process a currency
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        double d = 23.45364;
        System.out.println("The value of d is "+d);
        System.out.println("The value of currency d is " + nf.format(d));

        // process a date
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.ENGLISH);
        Date today = new Date();
        System.out.println(df.format(today));

        DateFormat time = DateFormat.getTimeInstance();

        System.out.println(time.format(today));


		DecimalFormat twoDForm = new DecimalFormat("#.##");
		Double.valueOf(twoDForm.format(6.6666666));

    }
}