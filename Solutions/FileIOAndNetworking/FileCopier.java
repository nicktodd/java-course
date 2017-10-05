import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FileCopier {

	public static void main(String[] args) {

		File in = new File(args[0]);
		File out = new File(args[1]);

		try {
			FileReader reader = new FileReader(in);
			BufferedReader bReader = new BufferedReader(reader);

			FileWriter writer  = new FileWriter(out);
			BufferedWriter bWriter = new BufferedWriter(writer);

			while (true)
			{
				String line = bReader.readLine();
				if (line == null) break;
				bWriter.write(line);
				bWriter.newLine();

			}
			bWriter.flush();
			bWriter.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
