import java.lang.Thread.UncaughtExceptionHandler;


public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("My exception handler got this:" + t.getName() + e.toString());
	}

}
