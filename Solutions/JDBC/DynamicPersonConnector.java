

import java.sql.*;

public class DynamicPersonConnector {

	public static void main(String[] args){

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:people");
			String argument = args[0];
			pstmt = conn.prepareStatement("select * from people where name = ? and age = ?");
			pstmt.setString(1,argument);
			pstmt.setInt(2, 23);
			ResultSet result = pstmt.executeQuery();

			while(result.next()){
				System.out.println("Name: " + result.getString("name"));
				System.out.println("Age: " + result.getInt("age"));
				System.out.println("Gender: " + result.getString("gender"));
				System.out.println("");
			}
		}
		catch(SQLException e){
			System.out.println("A Problem occured: " + e);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Could not load driver: " + e);
		}

		finally{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch(SQLException e) {}
		}

	}
}