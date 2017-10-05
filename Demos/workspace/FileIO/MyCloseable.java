
public class MyCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Closing my thing!");
	}
}
