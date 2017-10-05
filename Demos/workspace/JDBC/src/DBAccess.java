import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBAccess {
	
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:odbc:people");
			stmt = conn.createStatement();
			result = stmt.executeQuery("select * from people");
			
			while(result.next())
			{
				System.out.println("The name is " + result.getString("name"));
				System.out.println("The age is " + result.getInt("age"));
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
