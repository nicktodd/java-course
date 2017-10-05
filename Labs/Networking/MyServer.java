import java.net.*;
import java.io.*;

public class MyServer {

    public static void main(String[] args) {

        // declare an int called serverPort, and assign it the value 8081


        // declare an int called clientPort that is not assigned


        // declare a ServerSocket called serverSocket and set it to null

        // declare a Socket called clientSocket and set it to null


        // declare an InputStreamReader (isr), a BufferedReader (br) , and a PrintWriter (out), and assign them all to null



		// add a try block


            // create a serverSocket using the port number


            // accept the connection from the client, and assign the return value to your Socket reference.

            // client has connected

            // obtain the client port number and display the value on the screen.


			// use the InputStreamReader to decorate the input stream from the client

			// use the buffered stream reader to decorate the InputStreamReader


			// use the PrintWriter to decorate the client output stream



			// read in the lines from the client and then right them on the screen,
			// and then write an upper case version back to the client


		// catch the IOException


        // add a finally block to close the streams, the server socket, and the socket.

    }
}
