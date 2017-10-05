import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// This class will read from one file as text, and write to another file as text
public class TextFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("input.txt");
			writer = new FileWriter("output.txt", true);
			writer.write("here is the output");
			for (int i; (i = reader.read()) != -1; )
			{
				writer.write(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				writer.flush();
				writer.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
