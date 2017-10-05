import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


// this class will read binary from one file and write binary to another
public class FileStreams{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileInputStream input = null;
		FileOutputStream output = null;
		
		try {
			input = new FileInputStream("in.dat");
			output  = new FileOutputStream("out.dat");

			for (int b=0; (b=input.read())!=-1; )
			{
				output.write(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				input.close();
				output.flush();
				output.close();
			}
			catch (IOException e){}
		}

		
	}

}
