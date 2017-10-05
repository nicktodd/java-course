import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8081;

        Socket  clientSocket = null;
        BufferedReader keyboard = null;
        PrintWriter out = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
			// get connected
            clientSocket = new Socket(host, port);



            // create a PrintWriter to send data to the server
            out = new PrintWriter(clientSocket.getOutputStream(), true);

           // create a BufferedReader to receive input from server
            isr = new InputStreamReader(clientSocket.getInputStream());
            br  = new BufferedReader(isr);

            // read stuff from keyboard and send to server
            String line;
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            while (!(line = keyboard.readLine()).equals("quit")) {
                out.println(line);
                // write out the response from the server
                System.out.println("Response: " + br.readLine() + "\n");
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
        finally {

            try {
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException ex) {
                System.out.println("IO exception: " + ex);
            }
        }
    }
}
