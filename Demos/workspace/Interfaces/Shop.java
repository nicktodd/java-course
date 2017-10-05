
public class Shop extends Building implements Openable {

	public void open() {
		// TODO Auto-generated method stub
		System.out.println("open the shop!");

	}

	public void close() {
		// TODO Auto-generated method stub
		System.out.println("close the shop!");
	}
	
	public void raiseShutter()
	{
		// raise the shutter
	}
	
	@Override
	public String toString()
	{
		return "hello from the shop";
	}

}
