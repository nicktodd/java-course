import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingFromConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(reader);
		while (true)
		{
			String enteredText = null;
			try {
				enteredText = buff.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ("done".equals(enteredText))
				System.exit(0);
			System.out.println("You just typed - " + enteredText);
		}
	}

}
