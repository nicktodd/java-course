import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseAccessExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class s = Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://54.154.229.50:3306/conygre", "bbc", "bbc");
			stmt = conn.createStatement();
			result = stmt.executeQuery("select * from compact_discs");
			
			while(result.next()) {
				System.out.println(result.getString("title"));
				System.out.println(result.getDouble("price"));
				System.out.println(result.getString("artist"));
				
				
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		
		

	}

}
