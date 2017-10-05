import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {

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
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from compact_discs");			
			// move the cursor to the end
			result.afterLast();	
			// let's go backwards
			while (result.previous())
			{
				System.out.println(result.getString("title"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
