import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ObjectWriter extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			FileOutputStream out = new FileOutputStream("object.dat");
//			BufferedOutputStream buff = new BufferedOutputStream(out);
//			ObjectOutputStream obOut = new ObjectOutputStream(buff);
//			
//			SerializablePerson p = new SerializablePerson ();
//			p.setName("Fred");
//			p.setAge(50);
//			
//			
//			obOut.writeObject(p);
//			obOut.close();
//			
			FileInputStream fin = new FileInputStream("object.dat");
			BufferedInputStream bis = new BufferedInputStream(fin);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			try {
				SerializablePerson personIn = (SerializablePerson)ois.readObject();
				System.out.println(personIn.getName2());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			ois.close();
//			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
