import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class TestExceptions  {
	
	public static void main(String[] args)
	{

				try {
					getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	public static void getConnection() throws Exception
	{
		Connection conn = DriverManager.getConnection("databaseurl");

	}
	

}
