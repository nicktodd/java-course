import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {

    public static void main(String[] args) {

        // set a String variable to point to the host name or IP address of the server machine


        // define an int called port and set it to the same value as the server application 8081



		// declare a variable of type Socket called clientSocket


		// declare a buffered reader called keyboard and assign it to null
	    // declare an InputStreamReader (isr), a BufferedReader (br) , and a PrintWriter (out), and assign them all to null


        try {
			// get connected by instantiating your Socket




            // create a PrintWriter to send data to the server


           // create a BufferedReader to receive input from server


            // read stuff from keyboard and send to server

                // write out the response from the server

            }
            System.out.println("\nConnection closed.");

        }
        catch (UnknownHostException ex) {
            System.out.println("Unknown host exception: " + ex);
        }
        catch (IOException ex) {
            System.out.println("IO exception: " + ex);
        }
        // clean up all the connections

    }
}
