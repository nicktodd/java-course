import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UsingTryWithResources {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (FileReader reader = new FileReader("input.txt");
				BufferedReader buffReader = new BufferedReader(reader);
				FileWriter writer = new FileWriter("output.txt");
				BufferedWriter buffWriter = new BufferedWriter(writer);
				) {
			
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

		}

}
