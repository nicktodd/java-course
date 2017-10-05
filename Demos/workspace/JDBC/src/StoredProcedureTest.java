import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;


public class StoredProcedureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/conygre", "root", "c0nygre");
			CallableStatement stmt = conn.prepareCall("{call find_artist(?,?)} ");
			
			stmt.setString(1, "Parachutes");
			stmt.execute();
			
			System.out.println(stmt.getString(2));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
