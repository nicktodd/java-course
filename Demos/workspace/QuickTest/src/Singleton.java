
public class Singleton {
	
	private Singleton() {}
	
	private static class Holder {
		static Singleton single = new Singleton();
	}
	
	public static Singleton getInstance() {
		return Holder.single;
	}
}
