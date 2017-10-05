import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestWriting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(21,"Nick");
		
		try {
			// create an object output stream decorated with a fileoutput stream
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\temp\\output.dat"));
			// write the serializable object
			oos.writeObject(p);
			System.out.println("Object written to disk");
			
			// read the object back in
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("c:\\temp\\output.dat"));
			Person read = (Person)input.readObject();
			
			System.out.println("The person from the disk has the name " + read.getName());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
