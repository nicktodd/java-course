import java.io.File;

public class TestSecurityManager {
	
	public static void main(String[] args) {
		SecurityManager  manager = System.getSecurityManager();
		
		if (manager == null) {
			System.out.println("There is no security manager");
		}
		else {
			System.out.println("Security manager: " + manager);
		}
		
		File tempDir = new File("/tmp");
		for (String fileName : tempDir.list()) {
			System.out.println(fileName);
		}
		
	}

}
