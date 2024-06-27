package unit7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReuseAddressServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true); // Enable SO_REUSEADDR
            System.out.println("ReuseAddressServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReuseAddressServer");
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}