
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FileReader input = new FileReader("RegularExpressionExample.java");
			BufferedReader buff = new BufferedReader(input);
			Pattern pattern = Pattern.compile("public class");
			Matcher matcher = null;
			while (true) {
				String nextLine = buff.readLine();
				if (nextLine == null)
					break;
				matcher = pattern.matcher(nextLine);
				if (matcher.find())
					System.out.println(matcher.toString());
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
			}

}
