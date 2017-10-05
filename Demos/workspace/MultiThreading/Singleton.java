public class Singleton {

	private static class Holder {
		static Singleton single = new Singleton();
	}
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return Holder.single;
	}
}
