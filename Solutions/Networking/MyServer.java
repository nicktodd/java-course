import java.net.*;
import java.io.*;

public class MyServer {

    public static void main(String[] args) {
        int serverPort = 8081;
        int clientPort;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        PrintWriter out = null;

        try {

            // create a ServerSocket and wait ..
            System.out.print("Waiting for a client to connect");
            serverSocket = new ServerSocket(serverPort);
            clientSocket = serverSocket.accept(); // code blocks here ..
            // client has connected
            clientPort   = clientSocket.getPort();
            System.out.println("Connected to client on port number " + clientPort);

            isr = new InputStreamReader(clientSocket.getInputStream());
            br  = new BufferedReader(isr);
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            while ((line = br.readLine()) != null) {
                String uc = line.toUpperCase();
                System.out.println("\n\tReceived  [" + clientPort + "] " + line);
                System.out.println("\tReturning ["   + clientPort + "] " + uc);
                out.println(uc);
            }
            System.out.println("\nDisconnecting from " + clientPort);

        } catch (IOException ex) {
            System.out.println("IO exception: " + ex);
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
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
