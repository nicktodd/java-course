
// provide the appropriate import statement


public class PersonConnector {

		public static void main(String[] args){
			try {

				//	load the driver

				//	Create a new connection using the driver manager

				//	Use the connection to create a new Statement

				//	Use the executeQuery method on the Statemtent,
				//	passing in a String, to get a ResultSet

				//	Now loop through the ResultSet and display
				//	the data using System.out.println() statements
			}
			catch (SQLException e){
				System.out.println("A Problem occured: " + e);
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Could not load driver: " + e);
			}

			finally
			{
				// close your connection and statement
			}

		}
}