
public class TestAssertions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert 2+2 ==4;
		assert "Name".equals("Name");
		
		// this assertion will only work if you configure the JRE settings to include -ea
		// which stands for enable assertions
		// Window / Preferences / Installed JREs / Edit
		
		assert 2+2 == 5 : "it went wrong";

	}

}
