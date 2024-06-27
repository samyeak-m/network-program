package unit7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TimeoutServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(5000); // Set timeout to 5000 milliseconds (5 seconds)
            System.out.println("TimeoutServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept(); // This will block for up to 5 seconds
                    System.out.println("New client connected to TimeoutServer");
                    // Handle the client connection
                } catch (SocketTimeoutException e) {
                    System.out.println("Accept timed out, no incoming connection in 5 seconds");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}