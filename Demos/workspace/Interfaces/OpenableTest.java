
public class OpenableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Openable[] openables = new Openable[3];
		
		openables[0] = new Mouth();
		openables[1] = new Shop();
		openables[2] = new Eye();
		
		for (Openable current: openables)
		{
			current.open();
		}
		

	}

}
