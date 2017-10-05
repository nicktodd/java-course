
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestStrings {


	//1.	Create a new Java class with a main method called TestStrings.
	public static void main(String[] args) {


		// 2.	Using a String with the value example.doc, change the String to example.bak.
		StringBuilder fileName = new StringBuilder("example.doc");
		fileName.replace(fileName.length()-3, fileName.length(), "bak");

		System.out.println(fileName);

		// 3.	Input two Strings and test them see if they are equal.
		//      If they are not equal show which of them is lexicographically further forward
		String name1 = "Fred";
		String name2 = "Barnie";

		if (name1.equals(name2))
			System.out.println("The same!");

		String greater = (name1.compareTo(name2) > 0) ? name1 : name2;

		System.out.println("The greater String is " + greater);

		// 4.	Find the number of times "ow" occurs in "the quick brown fox swallowed down the lazy chicken"
		String text = "the quick brown fox swallowed down the lazy chicken";

		int count = 0;
		for (int i=0; i<text.length()-2; i++)
		{
			if (text.substring(i, i+2).equals("ow"))
				count++;
		}
		System.out.printf("the text ow appears %d times\n", count);

		// 5.	Check to see whether a given string is a palindrome (eg "Live not on evil")
		StringBuilder pali = new StringBuilder("Livenotonevil");
		StringBuilder paliCopy = new StringBuilder(pali);
		if (pali.reverse().toString().equalsIgnoreCase(paliCopy.toString()))
			System.out.println("it's a palindrome");

		// 6.	Print today's date in various formats.
		Format yearOnly = new SimpleDateFormat("yyyy");
		Format dayMonthYear = new SimpleDateFormat("dd MM yyyy");
		Format time = new SimpleDateFormat("hh mm");
		System.out.println(yearOnly.format(new Date()));
		System.out.println(dayMonthYear.format(new Date()));
		System.out.println(time.format(new Date()));


	}

}
