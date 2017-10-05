import java.sql.*;

public class PersonConnector {

		public static void main(String[] args){
			Connection conn=null;
			Statement stmt = null;
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn = DriverManager.getConnection("jdbc:odbc:people");

        stmt = conn.createStatement();
        String query = "select * from people";
        ResultSet result = stmt.executeQuery(query);

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
					stmt.close();
					conn.close();
				}
				catch(SQLException e) {}
			}


		}
}