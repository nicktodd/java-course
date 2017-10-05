import java.sql.*;

public class PersonConnector {

    public static void main(String[] args){
      Connection conn=null;
      Statement stmt = null;
      try {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@172.22.100.169:1521:mallon", "Nick", "Nick");

        stmt = conn.createStatement();
        String query = "select * from account";
        ResultSet result = stmt.executeQuery(query);

        while(result.next()){

          System.out.println("got a row");
          //System.out.println("Name: " + result.getString("name"));
          //System.out.println("Age: " + result.getInt("age"));
          //System.out.println("Gender: " + result.getString("gender"));
          //System.out.println("");
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