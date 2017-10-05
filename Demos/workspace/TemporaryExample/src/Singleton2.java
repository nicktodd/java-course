
public class Singleton2 {

	
	private Singleton2(){}
	
	
	static class Holder {
		
		static Singleton2 single = new Singleton2();
		
	}
	
	
	public static Singleton2 getInstance() {
		return Holder.single;
	}
	
	
}
