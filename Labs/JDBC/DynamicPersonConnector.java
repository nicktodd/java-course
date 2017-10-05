// provide the appropriate import statement


public class DynamicPersonConnector {

		public static void main(String[] args){

			Connection conn = null;
			try {

				conn = DriverManager.getConnection("jdbc:odbc:people");


				// 	Declare a String called argument and assign it the value args[0]

				// 	Underneath the code which establishes a Connection, use the connection
				//	to prepare a Statement with the String : "select * from people where name = ?"

				//	Use the PreparedStatement's setString()
				//	method to set the first parameter to argument

				//	Obtain a ResultSet by calling
				//	the executeQuery() method on the PreparedStatement

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

			finally
			{
				// close your connection and statement
			}

		}
}