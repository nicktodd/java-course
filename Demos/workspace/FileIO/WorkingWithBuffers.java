import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkingWithBuffers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader buffReader = null;
		BufferedWriter buffWriter = null;
		try {
			reader = new FileReader("input.txt");
			// Decorate
			buffReader = new BufferedReader(reader);
			writer = new FileWriter("output.txt");
			// Decorate
			buffWriter = new BufferedWriter(writer);
			writer.write("here is the output\n");
			while(true) {
				// read a line at a time
				String line = buffReader.readLine();
				if (line == null)
					break;
				buffWriter.write(line + "\n");
				//buffWriter.newLine();
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
				buffWriter.flush();
				buffWriter.close();
				buffReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

}
