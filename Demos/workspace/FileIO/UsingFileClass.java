import java.io.File;


public class UsingFileClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:/temp");
		if (f.isDirectory())
		{
			String[] contents = f.list();
			for (String current : contents)
			{
				System.out.println(current);
			}
		}

	}

}
