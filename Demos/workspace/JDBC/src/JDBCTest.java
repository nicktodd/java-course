import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {

	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:odbc:people");
			stmt = conn.prepareStatement("select * from people where name = ?");
			
			stmt.setString(1, "Paul");
			
			result = stmt.executeQuery();
			
			while (result.next())
			{
				String name = result.getString("name");
				String gender  = result.getString("gender");
				int age = result.getInt("age");
				
				System.out.printf("Name is %s and gender is %s and age is %d\n", name, gender, age);
				
			}
			
			
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	
}
