
public class Singleton {

	private Singleton(){}
	
	
	
	static class Holder {
		static Singleton single = new Singleton();
	}
	
	public  static Singleton getInstance() {
		return Holder.single;
	}
	
}
