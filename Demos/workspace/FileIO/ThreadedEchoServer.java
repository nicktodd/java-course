import java.io.*;
import java.net.*;

public class ThreadedEchoServer
{
	public static void main(String[] args ) 
	{
		try 
		{
			ServerSocket listeningSocket = new ServerSocket(8081);
         
			for (int i = 1;;i++)
			{
				Socket socket = listeningSocket.accept( );
				System.out.println("Creating thread " + i);
				new ServerThread(socket, i).start();
			}   
      }
      catch (Exception e) 
      {
		  System.out.println("Exception: " + e);
      } 
   } 
}


class ServerThread extends Thread
{
	Socket socket;
	int count;

   ServerThread(Socket socket, int count)
   {
	   this.socket = socket;
	   this.count = count;
   }

   public void run()
   {
	  try 
      {
		 InputStreamReader reader = new InputStreamReader(socket.getInputStream());
         BufferedReader buffR = new BufferedReader(reader);
		 PrintStream out = new PrintStream(socket.getOutputStream());

         out.println( "Hello! Enter \"BYE\" to exit.\r" );

         while (true)
         {
			String s = buffR.readLine();
            if (s == null)
				break;
            else
            {
				out.println("Echo (" + count + "): " + s + "\r");
				System.out.println("got a message from " + count + " which was " + s);
				if (s.trim().equals("BYE")) 
					break;
            } 
         }
         socket.close();         
      }
      catch (Exception e) 
      {
		  System.out.println("Exception: " + e);
      } 
   } 
}


